package com.service;

import com.entity.Etudiant;
import java.util.List;

public interface EtudiantService{
	void save(Etudiant e);
	void delete(Etudiant e);
	List<Etudiant> getAll();
	List<Etudiant> getSortedEtudiant();
}
