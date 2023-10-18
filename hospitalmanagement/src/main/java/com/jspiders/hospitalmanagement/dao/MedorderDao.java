package com.jspiders.hospitalmanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.hospitalmanagement.dto.Encounter;
import com.jspiders.hospitalmanagement.dto.Medorder;
import com.jspiders.hospitalmanagement.repository.MedorderRepo;

@Repository
public class MedorderDao {

	@Autowired
	private MedorderRepo medorderRepo;

	@Autowired
	private EncounterDao encounterDao;

	public Medorder saveMedorder(Medorder medorder, int eid) {
		Encounter encounter = encounterDao.getEncounterById(eid);
		medorder.setEncounter(encounter);
		return medorderRepo.save(medorder);
	}

	public Medorder updateMedorder(int mid, Medorder medorder) {
		if (medorderRepo.findById(mid).isPresent()) {
			medorder.setMid(mid);
			return medorderRepo.save(medorder);
		} else {
			return null;
		}
	}

	public Medorder deleteMedorderById(int mid) {
		if (medorderRepo.findById(mid).isPresent()) {
			Medorder medorder = medorderRepo.findById(mid).get();
			medorderRepo.deleteById(mid);
			return medorder;
		} else {
			return null;
		}
	}

	public Medorder getMedorderById(int mid) {
		if (medorderRepo.findById(mid).isPresent()) {
			Medorder medorder = medorderRepo.findById(mid).get();
			return medorder;
		} else {
			return null;
		}
	}
}
