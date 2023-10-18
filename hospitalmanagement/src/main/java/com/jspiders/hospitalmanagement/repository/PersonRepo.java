package com.jspiders.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.hospitalmanagement.dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

}
