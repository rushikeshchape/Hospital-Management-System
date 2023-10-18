package com.jspiders.hospitalmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.hospitalmanagement.dto.Meditems;
import com.jspiders.hospitalmanagement.service.MeditemsService;
import com.jspiders.hospitalmanagement.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

@RestController
@RequestMapping("/meditems")
public class MeditemsController {

	@Autowired
	private MeditemsService meditemsService;
	
	@ApiOperation(value = "save meditems",notes = "api is used to save meditems")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Meditems>> saveMeditems(@Valid @RequestBody Meditems meditems,@RequestParam int mid) {
		return meditemsService.saveMeditems(meditems, mid);
	}
	
	@ApiOperation(value = "update meditems",notes = "api is used to update meditems")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully updated"),@ApiResponse(code = 404, message = "id not found")})
	@PutMapping
	public ResponseEntity<ResponseStructure<Meditems>> updateMeditems(@RequestParam int id, @Valid @RequestBody Meditems meditems) {
		return meditemsService.updateMeditems(meditems, id);
	}
	
	@ApiOperation(value = "delete meditems",notes = "api is used to delete meditems")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted"),@ApiResponse(code = 404, message = "id not found")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Meditems>> deleteMeditems(@RequestParam int id) {
		return meditemsService.deleteMeditems(id);
	}
	
	@ApiOperation(value = "get meditems by id",notes = "api is used to find meditems based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found"),@ApiResponse(code = 404, message = "id not found")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Meditems>> getMeditemsById(@RequestParam int id) {
		return meditemsService.getMeditemsById(id);
	}
}
