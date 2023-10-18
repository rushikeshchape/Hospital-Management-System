package com.jspiders.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.hospitalmanagement.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
