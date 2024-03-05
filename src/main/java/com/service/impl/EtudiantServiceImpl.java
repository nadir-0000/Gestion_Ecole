package com.service.impl;

import com.dao.EtudiantDAO;
import com.entity.Etudiant;
import com.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class EtudiantServiceImpl  implements EtudiantService {
	@Autowired
     private EtudiantDAO etuDao;

	@Override
	@Transactional
	public void save(Etudiant e) {
		etuDao.saveOrUpdate(e);
	}

	@Override
	@Transactional
	public void delete(Etudiant e) {
		etuDao.delete(e);
	}

	@Override
	public List<Etudiant> getAll() {
		return etuDao.getAll();
	}


	@Override
	public List<Etudiant> getSortedEtudiant(){
		List<Etudiant> etudiants = this.getAll();
  		Collections.sort(etudiants, new Comparator<Etudiant>() {
			@Override
			public int compare(Etudiant o1, Etudiant o2) {
				return o1.getNom().compareTo(o2.getNom());
			}
		});

  		
  		return etudiants;
    	  
	}
}
     
