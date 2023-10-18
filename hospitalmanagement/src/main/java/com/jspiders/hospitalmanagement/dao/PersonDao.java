package com.jspiders.hospitalmanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.hospitalmanagement.dto.Person;
import com.jspiders.hospitalmanagement.repository.PersonRepo;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepo personRepo;
	
	public Person savePerson(Person person) {
		return personRepo.save(person);
	}
	
	public Person updatePerson(int pid, Person person) {

		if (personRepo.findById(pid).isPresent()) {
			person.setPid(pid);
			return personRepo.save(person);
		}else {
			return null;
		}
	}
	
	public Person deletePerson(int pid) {
		if (personRepo.findById(pid).isPresent()) {
			Person person = personRepo.findById(pid).get();
			personRepo.deleteById(pid);
			return person;
		}else {
			return null;
		}	
	}
	
	public Person getPersonById(int pid) {
		if (personRepo.findById(pid).isPresent()) {
			Person person = personRepo.findById(pid).get();
			return person;
		}else {
			return null;
		}
		
	}
	
	
}
