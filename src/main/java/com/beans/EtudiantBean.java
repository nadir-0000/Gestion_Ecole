package com.beans;

import com.entity.Etudiant;
import com.service.EtudiantService;
import com.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.faces.bean.ManagedBean;
import java.util.List;

@Component
@Scope("session")
@ManagedBean
public class EtudiantBean {
	@Autowired
	private EtudiantService etudiantService;
	@Autowired
	private FiliereService fser;
	private Etudiant etudiant ;
	private boolean modifyContext;
	private int filiere;
	@Autowired
	public EtudiantBean(EtudiantService etudiantService, FiliereService fser) {
		this.etudiant = new Etudiant();
		this.etudiantService = etudiantService;
		this.modifyContext = false;
		this.fser = fser;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public boolean isModifyContext() {
		return modifyContext;
	}

	public void setModifyContext(boolean modifyContext) {
		this.modifyContext = modifyContext;
	}


	public List<Etudiant> getEtudiants() {
		return this.etudiantService.getAll();
	}

	public String getLabel() {
		return isModifyContext() ? "Modification" : "Ajout";
	}



	public int getFiliere() {
		return filiere;
	}

	public void setFiliere(int filiere) {
		this.filiere = filiere;
	}

	@Transactional
	public void save() {
		System.out.println("------ bean : saving -------");
		this.etudiant.setFiliere(fser.getById(filiere));
		this.etudiantService.save(this.etudiant);
		this.setEtudiant(new Etudiant());
		this.setModifyContext(false);
	}

	public void modifier(Etudiant e) {
		this.setEtudiant(e);
		this.setModifyContext(true);
	}

	@Transactional
	public void supprimer(Etudiant e) {
		this.etudiantService.delete(e);
	}
}
