package com.jspiders.hospitalmanagement.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import lombok.Data;
//tablets
@Data
@Entity
public class Meditems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="meditem name cannot be null or blank")
	private String name;
	
	private double cost;
	
	@ManyToOne
	private Medorder medorder;
}
