package com.officeconnect.repository;

import com.officeconnect.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Integer> {
    
    @Query("SELECT h FROM Holiday h WHERE h.status = ?1")
    List<Holiday> findByStatus(String status);
    
    @Query("SELECT h FROM Holiday h WHERE h.status = ?1 AND h.locationId = ?2")
    List<Holiday> findByStatusAndLocationId(String status, Integer locationId);
}
