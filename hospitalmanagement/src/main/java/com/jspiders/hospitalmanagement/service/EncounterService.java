package com.jspiders.hospitalmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.hospitalmanagement.dao.BranchDao;
import com.jspiders.hospitalmanagement.dao.EncounterDao;
import com.jspiders.hospitalmanagement.dao.PersonDao;
import com.jspiders.hospitalmanagement.dto.Branch;
import com.jspiders.hospitalmanagement.dto.Encounter;
import com.jspiders.hospitalmanagement.dto.Person;
import com.jspiders.hospitalmanagement.exception.IdNotFound;
import com.jspiders.hospitalmanagement.util.ResponseStructure;

@Service
public class EncounterService {

	@Autowired
	private EncounterDao encounterDao;

	@Autowired
	private PersonDao personDao;

	@Autowired
	private BranchDao branchDao;

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int pid, int bid) {
		Person person = personDao.getPersonById(pid);
		Branch branch = branchDao.getBranchById(bid);
		encounter.setPerson(person);
		List<Branch> list = new ArrayList<>();
		list.add(branch);
		encounter.setList(list);
		
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Successfully saved.");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(encounterDao.saveEncounter(encounter));
		
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(int eid, Encounter encounter,int bid) {
		Encounter encounter2 = encounterDao.getEncounterById(eid);
		Branch branch = branchDao.getBranchById(bid);
		
		List<Branch> list =  encounter2.getList();
		encounter.setList(encounter2.getList());
		encounter.setPerson(encounter2.getPerson());
		
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Successfully updated.");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(encounterDao.updateEncounter(eid,encounter));
	    
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int eid) {
		Encounter encounter = encounterDao.deleteEncounterById(eid);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		
		if (encounter != null) {
			responseStructure.setMessage("Successfully deleted.");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(encounter);
		   
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.OK);
		} else {
			throw new IdNotFound("Id not found for encounter");
		}
	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int eid) {
		Encounter encounter = encounterDao.getEncounterById(eid);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<>();
		if (encounter != null) {
			responseStructure.setMessage("Successfully found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("No Id found.");
		}
	}
}
