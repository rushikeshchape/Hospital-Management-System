package com.jspiders.hospitalmanagement.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStructure<T> {

	private String message;
	private int status;
	private T data;
	
}