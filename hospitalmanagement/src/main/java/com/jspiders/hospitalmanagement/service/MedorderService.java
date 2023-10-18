package com.jspiders.hospitalmanagement.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.hospitalmanagement.dao.MedorderDao;
import com.jspiders.hospitalmanagement.dto.Medorder;
import com.jspiders.hospitalmanagement.exception.IdNotFound;
import com.jspiders.hospitalmanagement.util.ResponseStructure;

@Service
public class MedorderService {

	@Autowired
	private MedorderDao medorderDao;

	public ResponseEntity<ResponseStructure<Medorder>> saveMedorder(Medorder medorder, int eid) {
		ResponseStructure<Medorder> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Successfully saved.");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(medorderDao.saveMedorder(medorder, eid));
		return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Medorder>> updateMedorder(int mid, Medorder medorder) {

		Medorder medorder2 = medorderDao.getMedorderById(mid);
		medorder.setEncounter(medorder2.getEncounter());
		Medorder dbMedorder = medorderDao.updateMedorder(mid, medorder);
		ResponseStructure<Medorder> responseStructure = new ResponseStructure<>();

		if (dbMedorder != null) {
			responseStructure.setMessage("Successfully saved.");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbMedorder);
			return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Id not found for medorder.");
		}
	}

	public ResponseEntity<ResponseStructure<Medorder>> deleteMedorder(int mid) {
		Medorder medorder = medorderDao.deleteMedorderById(mid);
		ResponseStructure<Medorder> responseStructure = new ResponseStructure<>();
		if (medorder != null) {
			responseStructure.setMessage("Successfully deleted.");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(medorder);

			return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Id not found for medorder.");
		}
	}

	public ResponseEntity<ResponseStructure<Medorder>> getMedorderById(int mid) {
		Medorder medorder = medorderDao.getMedorderById(mid);
		ResponseStructure<Medorder> responseStructure = new ResponseStructure<>();
		
		if (medorder != null) {
			responseStructure.setMessage("Successfully found.");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(medorder);
			return new ResponseEntity<ResponseStructure<Medorder>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("Id not found.");
		}
	}
}