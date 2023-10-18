package com.jspiders.hospitalmanagement.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.hospitalmanagement.dao.AddressDao;
import com.jspiders.hospitalmanagement.dto.Address;
import com.jspiders.hospitalmanagement.exception.IdNotFound;
import com.jspiders.hospitalmanagement.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressDao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {

		ResponseStructure<Address> responseStructure = new ResponseStructure<>("Successfully saved.",
				HttpStatus.CREATED.value(), addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address, int aid) {
		Address address2 = addressDao.updateAddress(aid, address);
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();

		if (address2 != null) {
			responseStructure.setMessage("Successfully updated.");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(address2);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Id not found for address");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int aid) {
		Address address = addressDao.deleteAddress(aid);
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
		
		if (address != null) {
			responseStructure.setMessage("Successfully deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		} else {
			throw new IdNotFound("Id not found for address");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> getAddressById(int aid) {
		Address address = addressDao.getAddressById(aid);
		ResponseStructure<Address> responseStructure = new ResponseStructure<>();
		if (address != null) {
			responseStructure.setMessage("Successfully found.");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("No Id found.");
		}
	}
}
