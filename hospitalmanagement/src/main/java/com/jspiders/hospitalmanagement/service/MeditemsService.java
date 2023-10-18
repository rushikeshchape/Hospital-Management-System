package com.jspiders.hospitalmanagement.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.hospitalmanagement.dao.MeditemsDao;
import com.jspiders.hospitalmanagement.dto.Meditems;
import com.jspiders.hospitalmanagement.exception.IdNotFound;
import com.jspiders.hospitalmanagement.util.ResponseStructure;

@Service
public class MeditemsService {

	@Autowired
	private MeditemsDao meditemsDao;

	public ResponseEntity<ResponseStructure<Meditems>> saveMeditems(Meditems meditems, int mid) {
		ResponseStructure<Meditems> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Successfully saved.");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(meditemsDao.saveMeditems(meditems, mid));
		return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Meditems>> updateMeditems(Meditems meditems, int id) {
		Meditems meditems2 = meditemsDao.getMeditemsById(id);
		meditems.setMedorder(meditems2.getMedorder());
		Meditems dbMeditems = meditemsDao.updateMeditems(id, meditems);
		ResponseStructure<Meditems> responseStructure = new ResponseStructure<>();

		if (dbMeditems != null) {
			responseStructure.setMessage("Successfully updated.");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbMeditems);
			return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure,HttpStatus.OK);
		} else {
			throw new IdNotFound("Id not found for meditems.");
		}
	}

	public ResponseEntity<ResponseStructure<Meditems>> deleteMeditems(int id) {
		Meditems meditems = meditemsDao.deleteMeditems(id);
		ResponseStructure<Meditems> responseStructure = new ResponseStructure<>();
		
		if (meditems != null) {
			responseStructure.setMessage("Successfully deleted.");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(meditems);
			return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure,HttpStatus.OK);
		} else {
			throw new IdNotFound("Id not found for meditems.");
		}
	}

	public ResponseEntity<ResponseStructure<Meditems>> getMeditemsById(int id) {
		Meditems meditems = meditemsDao.getMeditemsById(id);
		ResponseStructure<Meditems> responseStructure = new ResponseStructure<>();
		
		if (meditems != null) {
			responseStructure.setMessage("Successfully found.");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(meditems);
			return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("Id not found.");
		}
	}
}