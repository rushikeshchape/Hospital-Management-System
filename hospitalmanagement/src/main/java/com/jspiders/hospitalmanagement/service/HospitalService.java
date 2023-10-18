package com.jspiders.hospitalmanagement.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.hospitalmanagement.dao.HospitalDao;
import com.jspiders.hospitalmanagement.dto.Hospital;
import com.jspiders.hospitalmanagement.exception.IdNotFound;
import com.jspiders.hospitalmanagement.util.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao hospitalDao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Successfully saved.");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(hospitalDao.saveHospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int hid, Hospital hospital) {

		Hospital hospital2 = hospitalDao.updateHospital(hid, hospital);
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
		if (hospital2 != null) {
			responseStructure.setMessage("Successfully updated.");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital2);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Id not found for the hospital");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int hid) {
		Hospital hospital = hospitalDao.deleteHospital(hid);
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
		if (hospital != null) {
			responseStructure.setMessage("Successfully deleted.");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital);

			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Id not found for the hospital");
		}
	}

	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int hid) {
		Hospital hospital = hospitalDao.getHospitalById(hid);
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
		if (hospital != null) {
			responseStructure.setMessage("Successfully found.");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);

			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("No Id found.");
		}
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalByEmail(String email) {
		Hospital hospital = hospitalDao.getHospitalByEmail(email);
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<>();
		if (hospital != null) {
			responseStructure.setMessage("Successfully found.");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);

			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("No email found.");
		}
	}
}
