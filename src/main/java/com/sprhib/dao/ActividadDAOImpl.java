package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Actividad;
import com.sprhib.model.RolActividad;
import com.sprhib.model.Role;

@Repository
public class ActividadDAOImpl implements ActividadDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	

	public void addActividad(Actividad actividad) {
		Session session = (Session) sessionFactory.openSession();
		session.beginTransaction();  
		session.save(actividad);
		  
		 for(RolActividad role : actividad.getRolActividadList())
		 {
			 session.save(role);  
		 }
		 session.getTransaction().commit();  
		 session.close();  
	}


	public void updateActividad(Actividad team) {
		Actividad teamToUpdate = getActividad(team.getIdactividad());
		teamToUpdate.setNombre(team.getNombre());
		getCurrentSession().update(teamToUpdate);
	}


	public Actividad getActividad(int id) {
		Actividad team = (Actividad) getCurrentSession().get(Actividad.class, id);
		return team;
	}


	public void deleteActividad(int id) {
		Actividad team = getActividad(id);
		if (team != null)
			getCurrentSession().delete(team);
	}

	@SuppressWarnings("unchecked")
	public List<Actividad> getActividades() {
		return getCurrentSession().createQuery("from Actividad").list();
	}

}
