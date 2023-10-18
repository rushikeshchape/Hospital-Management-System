package com.jspiders.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.hospitalmanagement.dto.Encounter;

public interface EncounterRepo extends JpaRepository<Encounter, Integer>{

}
