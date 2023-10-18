package com.jspiders.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.hospitalmanagement.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer>{

	public Hospital findByEmail(String email);
}
