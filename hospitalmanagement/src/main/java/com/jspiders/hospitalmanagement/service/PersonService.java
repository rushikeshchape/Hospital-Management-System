package com.jspiders.hospitalmanagement.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspiders.hospitalmanagement.dao.PersonDao;
import com.jspiders.hospitalmanagement.dto.Person;
import com.jspiders.hospitalmanagement.exception.IdNotFound;
import com.jspiders.hospitalmanagement.util.ResponseStructure;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Successfully saved.");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(personDao.savePerson(person));
		return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Person>> updatePerson(int pid, Person person) {
		Person person2 = personDao.updatePerson(pid, person);
		ResponseStructure<Person> responseStructure = new ResponseStructure<>();
		if (person2 != null) {
			responseStructure.setMessage("Successfully updated.");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(person2);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Id not found for person.");
		}
	}

	public ResponseEntity<ResponseStructure<Person>> deletePerson(int pid) {
		Person person = personDao.deletePerson(pid);
		ResponseStructure<Person> responseStructure = new ResponseStructure<>();
		if (person != null) {
			responseStructure.setMessage("Successfully deleted.");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Id not found for person.");
		}
	}

	public ResponseEntity<ResponseStructure<Person>> getPersonById(int pid) {
		Person person = personDao.getPersonById(pid);
		ResponseStructure<Person> responseStructure = new ResponseStructure<>();
		if (person != null) {
			responseStructure.setMessage("Successfully saved.");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new NoSuchElementException("Id not found.");
		}
	}
}
