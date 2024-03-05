package com.dao.impl;

import com.dao.FiliereDAO;
import com.entity.Filiere;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class FiliereDaoImpl extends HibernateDaoSupport implements FiliereDAO {

	@Autowired
	public void setUpSessionFactory(SessionFactory sessionFactory) {
		System.out.println("Setting up SessionFactory");
		this.setSessionFactory(sessionFactory);
	}

	@Override
	@Transactional
	public void saveOrUpdate(Filiere f) {
		System.out.println("saving Filiere");
		this.getHibernateTemplate().saveOrUpdate(f);
	}


	@Override
	@Transactional
	public void delete(Filiere f) {
		System.out.println("deleting Filiere");
		this.getHibernateTemplate().delete(f);
	}

	@Override
	public Filiere getById(int id) {
		System.out.println("getting by id Filiere");
		return this.getHibernateTemplate().get(Filiere.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Filiere> getAll() {
		System.out.println("getting all filiere");

		return (List<Filiere>) this.getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(Filiere.class));
	}
}
