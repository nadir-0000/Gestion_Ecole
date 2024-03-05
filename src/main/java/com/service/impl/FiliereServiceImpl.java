package com.service.impl;

import com.dao.FiliereDAO;
import com.entity.Filiere;
import com.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class FiliereServiceImpl implements FiliereService {
	@Autowired
	private FiliereDAO filiereDao;

	@Override
	@Transactional
	public void save(Filiere f) {
		this.filiereDao.saveOrUpdate(f);
	}

	@Override
	@Transactional
	public void delete(Filiere f) {
		this.filiereDao.delete(f);
	}

	@Override
	public List<Filiere> getAll() {
		return this.filiereDao.getAll();
	}

	@Override
	public Filiere getById(int id) {
		return filiereDao.getById(id);
	}

	@Override
	public List<Filiere> getSortedFiliere() {
		
		List<Filiere> filieres = this.getAll();
		
		Collections.sort(filieres, new Comparator<Filiere>() {

			@Override
			public int compare(Filiere o1, Filiere o2) {
				return o1.getCode().compareTo(o2.getCode());
			}
		});
		System.out.println("size of filieres : "+filieres.size());
		
		return filieres;
	}

}
