package com.jspiders.hospitalmanagement.dto;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import lombok.Data;
//prescription
@Data
@Entity
public class Medorder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	
	@CreationTimestamp
	private Date date;
	
	@NotBlank(message="doctor name cannot be null or blank")
	private String doctor;
	
	@ManyToOne
	private Encounter encounter;
}
