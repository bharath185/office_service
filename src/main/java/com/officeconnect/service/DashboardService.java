package com.officeconnect.service;

import com.officeconnect.dto.DashboardViewModel;
import com.officeconnect.entity.EmployeeMaster;
import com.officeconnect.entity.Holiday;
import com.officeconnect.repository.EmployeeMasterRepository;
import com.officeconnect.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    @Autowired
    private EmployeeMasterRepository employeeMasterRepository;

    @Autowired
    private HolidayRepository holidayRepository;

    public DashboardViewModel getEmployeeEvents(DashboardViewModel model) {
        Integer loginId = model.getLoginId();
        Integer leId = model.getLeId();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        DashboardViewModel dbvm = new DashboardViewModel();
        dbvm.setLoginId(loginId);
        dbvm.setLeId(leId);

        Calendar cal = Calendar.getInstance();
        int todayMonth = cal.get(Calendar.MONTH) + 1;
        int todayDay = cal.get(Calendar.DAY_OF_MONTH);

        // Calculate current week range (Sunday to Saturday)
        Calendar weekStart = Calendar.getInstance();
        weekStart.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        weekStart.set(Calendar.HOUR_OF_DAY, 0);
        weekStart.set(Calendar.MINUTE, 0);
        weekStart.set(Calendar.SECOND, 0);
        weekStart.set(Calendar.MILLISECOND, 0);

        Calendar weekEnd = Calendar.getInstance();
        weekEnd.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        weekEnd.set(Calendar.HOUR_OF_DAY, 23);
        weekEnd.set(Calendar.MINUTE, 59);
        weekEnd.set(Calendar.SECOND, 59);
        weekEnd.set(Calendar.MILLISECOND, 999);

        List<EmployeeMaster> activeEmps = employeeMasterRepository.findAll().stream()
            .filter(e -> e.getIsActive() != null && e.getIsActive())
            .filter(e -> e.getIsDeleted() == null || !e.getIsDeleted())
            .filter(e -> "ACTIVE".equalsIgnoreCase(e.getEmpStatus()))
            .collect(Collectors.toList());

        List<Map<String, Object>> dayBirthdays = new ArrayList<>();
        List<Map<String, Object>> monthBirthdays = new ArrayList<>();
        List<Map<String, Object>> weekBirthdays = new ArrayList<>();

        for (EmployeeMaster e : activeEmps) {
            if (e.getDob() != null) {
                Calendar eb = Calendar.getInstance();
                eb.setTime(e.getDob());
                int month = eb.get(Calendar.MONTH) + 1;
                int day = eb.get(Calendar.DAY_OF_MONTH);

                // Create a calendar for the birthday in the current year to compare with week range
                Calendar bdayInCurrentYear = Calendar.getInstance();
                bdayInCurrentYear.set(Calendar.YEAR, cal.get(Calendar.YEAR));
                bdayInCurrentYear.set(Calendar.MONTH, eb.get(Calendar.MONTH));
                bdayInCurrentYear.set(Calendar.DAY_OF_MONTH, day);
                bdayInCurrentYear.set(Calendar.HOUR_OF_DAY, 0);
                bdayInCurrentYear.set(Calendar.MINUTE, 0);
                bdayInCurrentYear.set(Calendar.SECOND, 0);
                bdayInCurrentYear.set(Calendar.MILLISECOND, 0);

                Map<String, Object> bvm = new HashMap<>();
                bvm.put("EmpId", e.getEmpId());
                bvm.put("UserName", e.getUserName() != null ? e.getUserName() : "");
                bvm.put("EmpCode", e.getEmpCode() != null ? e.getEmpCode() : "");
                bvm.put("FirstName", e.getFirstName() != null ? e.getFirstName() : "");
                bvm.put("MiddleName", e.getMiddleName() != null ? e.getMiddleName() : "");
                bvm.put("LastName", e.getLastName() != null ? e.getLastName() : "");
                bvm.put("DOB", sdf.format(e.getDob()));
                bvm.put("Day", "Birth Day");
                bvm.put("Gender", e.getGender() != null ? e.getGender() : "");

                if (month == todayMonth && day == todayDay) {
                    dayBirthdays.add(bvm);
                }
                if (month == todayMonth) {
                    monthBirthdays.add(bvm);
                }
                // Check if birthday falls in current week
                if (bdayInCurrentYear.compareTo(weekStart) >= 0 && bdayInCurrentYear.compareTo(weekEnd) <= 0) {
                    weekBirthdays.add(bvm);
                }
            }
        }

        Map<String, Object> birthdayList = new HashMap<>();
        birthdayList.put("lstofdaybirthday", dayBirthdays);
        birthdayList.put("daycount", dayBirthdays.size());
        birthdayList.put("lstofweekbirthday", weekBirthdays);
        birthdayList.put("weekcount", weekBirthdays.size());
        birthdayList.put("lstofmonthbirthday", monthBirthdays);
        birthdayList.put("monthcount", monthBirthdays.size());
        dbvm.setLstofbirthday(birthdayList);

        List<Map<String, Object>> holidays = new ArrayList<>();
        try {
            List<Holiday> holidayList = holidayRepository.findAll();
            Calendar now = Calendar.getInstance();
            int currentYear = now.get(Calendar.YEAR);

            for (Holiday h : holidayList) {
                if (h.getDate() != null) {
                    Calendar hc = Calendar.getInstance();
                    hc.setTime(h.getDate());
                    int hYear = hc.get(Calendar.YEAR);

                    if (hYear == currentYear) {
                        Map<String, Object> hvm = new HashMap<>();
                        hvm.put("LocationId", h.getLocationId());
                        hvm.put("Location", h.getLocation() != null ? h.getLocation() : "");
                        hvm.put("HolidayId", h.getHolidayId());
                        hvm.put("Year", hYear);
                        hvm.put("Title", h.getTitle() != null ? h.getTitle() : "");
                        hvm.put("Date", sdf.format(h.getDate()));
                        hvm.put("HolidayType", h.getHolidayType() != null ? h.getHolidayType() : "");
                        holidays.add(hvm);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        dbvm.setLstofholiday(holidays);

        List<Map<String, Object>> empList = new ArrayList<>();
        for (EmployeeMaster e : activeEmps) {
            Map<String, Object> evm = new HashMap<>();
            evm.put("EmpId", e.getEmpId());
            evm.put("UserName", e.getUserName() != null ? e.getUserName() : "");
            evm.put("EmpCode", e.getEmpCode() != null ? e.getEmpCode() : "");
            evm.put("FirstName", e.getFirstName() != null ? e.getFirstName() : "");
            evm.put("MiddleName", e.getMiddleName() != null ? e.getMiddleName() : "");
            evm.put("LastName", e.getLastName() != null ? e.getLastName() : "");
            evm.put("DeptId", e.getCategoryId());
            evm.put("Department", e.getDeptName() != null ? e.getDeptName() : "");
            evm.put("DesigId", e.getDesignationId());
            evm.put("Designation", e.getDesignationName() != null ? e.getDesignationName() : "");
            evm.put("Gender", e.getGender() != null ? e.getGender() : "");
            evm.put("EmailId", e.getEmailId() != null ? e.getEmailId() : "");
            empList.add(evm);
        }
        dbvm.setLstofemp(empList);

        dbvm.setMsg("Success");
        return dbvm;
    }

    public DashboardViewModel getAllHRCount(DashboardViewModel model) {
        DashboardViewModel dbvm = new DashboardViewModel();
        long activeEmployees = employeeMasterRepository.findAll().stream()
            .filter(e -> e.getIsActive() != null && e.getIsActive() && e.getIsDeleted() != null && !e.getIsDeleted())
            .count();
        dbvm.setLoginId((int) activeEmployees);
        return dbvm;
    }

    public DashboardViewModel getDashboardSummary(DashboardViewModel model) {
        DashboardViewModel dbvm = new DashboardViewModel();
        long activeEmployees = employeeMasterRepository.findAll().stream()
            .filter(e -> e.getIsActive() != null && e.getIsActive() && e.getIsDeleted() != null && !e.getIsDeleted())
            .count();
        dbvm.setLoginId((int) activeEmployees);
        return dbvm;
    }

    public DashboardViewModel getLeaveStatistics(DashboardViewModel model) {
        DashboardViewModel dbvm = new DashboardViewModel();
        return dbvm;
    }

    public DashboardViewModel getAttendanceStatistics(DashboardViewModel model) {
        DashboardViewModel dbvm = new DashboardViewModel();
        return dbvm;
    }
}