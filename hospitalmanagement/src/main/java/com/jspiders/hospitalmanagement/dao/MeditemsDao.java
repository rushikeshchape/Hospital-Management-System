package com.jspiders.hospitalmanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.hospitalmanagement.dto.Meditems;
import com.jspiders.hospitalmanagement.dto.Medorder;
import com.jspiders.hospitalmanagement.repository.MeditemsRepo;

@Repository
public class MeditemsDao {
	@Autowired
	private MeditemsRepo meditemsRepo;

	@Autowired
	private MedorderDao medorderDao;

	public Meditems saveMeditems(Meditems meditems, int mid) {
		Medorder medorder = medorderDao.getMedorderById(mid);
		meditems.setMedorder(medorder);
		return meditemsRepo.save(meditems);
	}

	public Meditems updateMeditems(int id, Meditems meditems) {
		if (meditemsRepo.findById(id).isPresent()) {
			meditems.setId(id);
			return meditemsRepo.save(meditems);
		} else {
			return null;
		}
	}

	public Meditems deleteMeditems(int id) {
		if (meditemsRepo.findById(id).isPresent()) {
			Meditems meditems = meditemsRepo.findById(id).get();
			meditemsRepo.deleteById(id);
			return meditems;
		} else {
			return null;
		}
	}

	public Meditems getMeditemsById(int id) {
		if (meditemsRepo.findById(id).isPresent()) {
			Meditems meditems = meditemsRepo.findById(id).get();
			return meditems;
		} else {
			return null;
		}
	}
}