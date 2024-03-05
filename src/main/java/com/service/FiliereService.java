package com.service;

import com.entity.Filiere;
import java.util.List;

public interface FiliereService {
	void save(Filiere f);
	void delete(Filiere f);
	List<Filiere> getAll();
	Filiere getById(int id);
	List<Filiere> getSortedFiliere();
}
