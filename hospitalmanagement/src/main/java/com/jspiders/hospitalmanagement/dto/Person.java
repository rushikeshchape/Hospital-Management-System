package com.jspiders.hospitalmanagement.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	@NotBlank(message="name cannot be null or blank")
	private String name;
	
	@NotBlank(message="email cannot be null or blank")
	@Pattern(regexp ="^[A-Za-z0-9+_.-]+@(.+)$")
	private String email;
	
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long phone;
}
