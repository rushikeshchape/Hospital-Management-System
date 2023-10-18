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

import com.jspiders.hospitalmanagement.dto.Person;
import com.jspiders.hospitalmanagement.service.PersonService;
import com.jspiders.hospitalmanagement.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

@RestController	
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@ApiOperation(value = "save person",notes = "api is used to save person")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Person>> savePerson(@Valid @RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	@ApiOperation(value = "update person",notes = "api is used to update person")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully updated"),@ApiResponse(code = 404, message = "id not found")})
	@PutMapping
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@RequestParam int pid,@Valid @RequestBody Person person) {
		return personService.updatePerson(pid, person);
	}
	
	@ApiOperation(value = "delete person",notes = "api is used to delete person")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted"),@ApiResponse(code = 404, message = "id not found")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@RequestParam int pid) {
		return personService.deletePerson(pid);
	}
	
	@ApiOperation(value = "get person by id",notes = "api is used to find person based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found"),@ApiResponse(code = 404, message = "id not found")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@RequestParam int pid) {
		return personService.getPersonById(pid);
	}
}
