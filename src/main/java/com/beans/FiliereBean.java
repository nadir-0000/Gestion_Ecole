package com.beans;


import com.entity.Filiere;
import com.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import java.util.List;

@Component
@ManagedBean
@Scope("session")
public class FiliereBean {
	@Autowired
	private FiliereService filiereService;
	private Filiere filiere;
	private boolean modifyContext;
	public FiliereBean() {
		this.filiere = new Filiere();
		this.modifyContext = false;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}


	public boolean isModifyContext() {
		return modifyContext;
	}

	public void setModifyContext(boolean modifyContext) {
		this.modifyContext = modifyContext;
	}

	public List<Filiere> getFilieres() {
		return this.filiereService.getSortedFiliere();
	}

	public String getLabel() {
		return isModifyContext() ? "Modification" : "Ajout";
	}

	@Transactional
	public void save() {
		this.filiereService.save(this.filiere);
		this.setModifyContext(false);
		this.setFiliere(new Filiere());
	}


	public void modifier(Filiere f) {
		this.setFiliere(f);
		this.setModifyContext(true);
	}

	@Transactional
	public void supprimer(Filiere f) {
		this.filiereService.delete(f);
	}
}
