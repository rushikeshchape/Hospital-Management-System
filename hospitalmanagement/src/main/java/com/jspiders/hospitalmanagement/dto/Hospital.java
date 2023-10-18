package com.jspiders.hospitalmanagement.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "name cannot be blank or null")
	private String name;
	
	@NotBlank(message = "email cannot be blank or null")
	@Pattern(regexp ="^[A-Za-z0-9+_.-]+@(.+)$")
	private String email;
	
}
