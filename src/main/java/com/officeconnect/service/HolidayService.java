package com.officeconnect.service;

import com.officeconnect.dto.HolidayViewModel;
import com.officeconnect.entity.EmployeeMaster;
import com.officeconnect.entity.Holiday;
import com.officeconnect.repository.EmployeeMasterRepository;
import com.officeconnect.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;
    
    @Autowired
    private EmployeeMasterRepository employeeMasterRepository;

    public List<HolidayViewModel> getAllHoliday(HolidayViewModel model) {
        // Validate LoginId
        if (model == null || model.getLoginId() == null || model.getLoginId() == 0) {
            throw new RuntimeException("LoginId is Missing");
        }
        
        Integer loginId = model.getLoginId();
        
        // Special case: loginId == 149 gets ALL active holidays (no location filter)
        List<Holiday> holidays;
        if (loginId == 149) {
            holidays = holidayRepository.findByStatus("Active");
        } else {
            // Get employee's locationId
            Integer locId = 4;
            EmployeeMaster emp = employeeMasterRepository.findByEmpIdAndActive(loginId);
            
            if (emp == null || emp.getLocationId() == null) {
                throw new RuntimeException("Employee location is not mapped!!");
            }
            
            locId = emp.getLocationId();
            if (locId == 0) {
                locId = 4;
            }
            
            // Regular user: filter by location
            holidays = holidayRepository.findByStatusAndLocationId("Active", locId);
        }
        
        if (holidays == null || holidays.isEmpty()) {
            throw new RuntimeException("No Holidays Found");
        }
        
        // Sort by Holiday_Id descending
        holidays.sort((a, b) -> Integer.compare(b.getHolidayId(), a.getHolidayId()));
        
        // Group by Title + Date + HolidayType (matching .NET GroupBy logic)
        Map<String, List<Holiday>> grouped = new LinkedHashMap<>();
        for (Holiday h : holidays) {
            String title = h.getTitle() != null ? h.getTitle() : "";
            String dateKey = h.getDate() != null ? String.valueOf(h.getDate().getTime()) : "";
            String holidayType = h.getHolidayType() != null ? h.getHolidayType() : "";
            String key = title + "|" + dateKey + "|" + holidayType;
            grouped.computeIfAbsent(key, k -> new ArrayList<>()).add(h);
        }
        
        // Convert groups to ViewModel list
        List<HolidayViewModel> result = new ArrayList<>();
        for (Map.Entry<String, List<Holiday>> entry : grouped.entrySet()) {
            List<Holiday> group = entry.getValue();
            Holiday first = group.get(0);
            
            HolidayViewModel vm = new HolidayViewModel();
            
            // Holiday_Id list (matching .NET Select)
            List<Integer> holidayIds = group.stream()
                .map(Holiday::getHolidayId)
                .distinct()
                .collect(Collectors.toList());
            vm.setHolidayId(holidayIds.toArray(new Integer[0]));
            
            vm.setTitle(first.getTitle());
            vm.setDay(null);
            vm.setDate(HolidayViewModel.formatDate(first.getDate()));
            vm.setDescription(first.getDescription());
            vm.setCreatedBy(first.getCreatedBy());
            vm.setCreatedDate(HolidayViewModel.formatDate(first.getCreatedDate()));
            vm.setModifyBy(first.getModifyBy());
            vm.setModifyDate(first.getModifyDate() != null ? 
                HolidayViewModel.formatDate(first.getModifyDate()) : null);
            vm.setStatus(first.getStatus());
            vm.setMsg(null);
            vm.setLoginId(0);
            
            // LocationId list (same order as Holiday_Id)
            List<Integer> locationIds = group.stream()
                .map(Holiday::getLocationId)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
            Integer[] locationIdArray = locationIds.toArray(new Integer[0]);
            vm.setLocationId(locationIdArray);
            vm.setHolidayLocationId(locationIdArray);
            
            vm.setHolidayType(first.getHolidayType());
            vm.setYear(first.getYear() != null ? first.getYear() : 0);
            
            // Location list (same order as Holiday_Id)
            List<String> locations = group.stream()
                .map(Holiday::getLocation)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
            String[] locationArray = locations.toArray(new String[0]);
            vm.setLocation(locationArray);
            vm.setHolidayLocation(locationArray);
            
            vm.setUpdatedHolidays(null);
            result.add(vm);
        }
        
        return result;
    }
}
