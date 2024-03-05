package com.dao.impl;

import com.dao.EtudiantDAO;
import com.entity.Etudiant;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EtudiantDaoImpl extends HibernateDaoSupport implements EtudiantDAO {

	@Autowired
	public void setUpSessionFactory(SessionFactory sessionFactory) {
		System.out.println("Setting up SessionFactory");
		this.setSessionFactory(sessionFactory);
	}

	@Override
	@Transactional
	public void saveOrUpdate(Etudiant f) {
		System.out.println("saving etudiant");
		this.getHibernateTemplate().saveOrUpdate(f);
	}

	@Override
	@Transactional
	public void delete(Etudiant f) {
		System.out.println("deleting etudiant");
		this.getHibernateTemplate().delete(f);

	}

	@Override
	public Etudiant getById(int id) {
		System.out.println("getting by etudiant");
		return this.getHibernateTemplate().get(Etudiant.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> getAll() {
		System.out.println("getting all etudiant");
		return (List<Etudiant>) this.getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(Etudiant.class));
	}
}
