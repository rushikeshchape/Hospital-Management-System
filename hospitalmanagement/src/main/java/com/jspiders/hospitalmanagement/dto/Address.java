package com.jspiders.hospitalmanagement.dto;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	
	@NotBlank(message = "state cannot be null or blank")
	private String state;
	
	@NotBlank(message = "city cannot be null or blank")
	private String city;

	@NotNull(message = "pincode cannot be null")
	@Min(value = 000001)
	@Max(value = 999999)
	private long pincode;
}
