package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRoles() {
		
		return getCurrentSession().createQuery("from Role").list();
	}

	@Override
	public void addRole(Role role) {
		getCurrentSession().save(role);
	}

	@Override
	public void updateRole(Role role) {
		getCurrentSession().update(role);
	}

	@Override
	public void deleteRole(Role role) {
		getCurrentSession().delete(role);
	}

}
