package com.officeconnect.repository;

import com.officeconnect.entity.EmailSetUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailSetUpRepository extends JpaRepository<EmailSetUp, Integer> {
}