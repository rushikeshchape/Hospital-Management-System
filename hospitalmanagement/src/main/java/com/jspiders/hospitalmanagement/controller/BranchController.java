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

import com.jspiders.hospitalmanagement.dto.Branch;
import com.jspiders.hospitalmanagement.service.BranchService;
import com.jspiders.hospitalmanagement.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchService branchService;
	
	@ApiOperation(value = "save branch",notes = "api is used to save branch")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully saved")})
	@PostMapping
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@Valid @RequestBody Branch branch,@RequestParam int hid,@RequestParam int aid) {
		return branchService.saveBranch(branch, hid, aid);
	}
	
	@ApiOperation(value = "update branch",notes = "api is used to update branch")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully updated"),@ApiResponse(code = 404, message = "id not found")})
	@PutMapping
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestParam int bid, @Valid @RequestBody Branch branch) {
		return branchService.updateBranch(bid, branch);
	}
	
	@ApiOperation(value = "delete branch",notes = "api is used to delete branch")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "successfully deleted"),@ApiResponse(code = 404, message = "id not found")})
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam int bid) {
		return branchService.deleteBranch(bid);
	}
	
	@ApiOperation(value = "get branch by id",notes = "api is used to find branch based on id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "successfully found"),@ApiResponse(code = 404, message = "id not found")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@RequestParam int bid) {
		return branchService.getBranchById(bid);
	}
}