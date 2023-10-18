package com.jspiders.hospitalmanagement.controller;

import javax.validation.Valid;

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

import com.jspiders.hospitalmanagement.dto.Address;
import com.jspiders.hospitalmanagement.service.AddressService;
import com.jspiders.hospitalmanagement.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	

	@ApiOperation(value = "save address",notes = "api is used to save address")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@Valid @RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	@ApiOperation(value = "update address",notes = "api is used to update address")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully updated"),@ApiResponse(code = 404, message = "id not found")})
	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestParam int aid, @Valid @RequestBody Address address) {
		return addressService.updateAddress(address, aid);
	}
	
	@ApiOperation(value = "delete address",notes = "api is used to delete address")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted"),@ApiResponse(code = 404, message = "id not found")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@RequestParam int aid) {
		return addressService.deleteAddress(aid);
	}
	
	@ApiOperation(value = "get address by id",notes = "api is used to find address based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found"),@ApiResponse(code = 404, message = "id not found")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@RequestParam int aid) {
		return addressService.getAddressById(aid);
	}
}
