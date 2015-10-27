package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Actividad;
import com.sprhib.model.Asignacion;
import com.sprhib.model.Programacion;
import com.sprhib.model.RolActividad;

@Repository
public class ProgramacionDAOImpl implements ProgramacionDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addProgramacion(Programacion programacion) {
		Session session = (Session) sessionFactory.openSession();
		session.beginTransaction();  
		session.save(programacion);
		  
		 for(Asignacion asignacion : programacion.getAsignaciones())
		 {
			 session.save(asignacion);  
		 }
		 session.getTransaction().commit();  
		 session.close();  
	}

	@Override
	public void updateProgramacion(Programacion programacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Actividad getProgramacion(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProgramacion(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Programacion> getProgramaciones() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
