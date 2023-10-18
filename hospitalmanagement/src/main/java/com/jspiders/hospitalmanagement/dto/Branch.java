package com.jspiders.hospitalmanagement.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	@NotBlank(message="name cannot be null or blank")
	private String name;
	
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long phone;
	
	@NotBlank(message = "manager cannot be null or blank")
	private String manager;
	
	@ManyToOne
	private Hospital hospital;
	
	@OneToOne
	private Address address;
	
}