package com.jspiders.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.hospitalmanagement.dto.Medorder;

public interface MedorderRepo extends JpaRepository<Medorder, Integer>{

}
