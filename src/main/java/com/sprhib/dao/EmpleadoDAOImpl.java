package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Actividad;
import com.sprhib.model.Empleado;
import com.sprhib.model.RolActividad;

@Repository
public class EmpleadoDAOImpl implements EmpleadoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addEmpleado(Empleado empleado) {
		getCurrentSession().save(empleado);
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
	
	@Override
    @SuppressWarnings("unchecked")
    public List<Empleado> getEmpleados()
    {
        return getCurrentSession().createQuery("from Empleado").list();
    }

	@Override
	public void updateEmpleado(Empleado empleado) {
		getCurrentSession().update(empleado);
	}

	@Override
	public void deleteEmpleado(Empleado empleado) {
		getCurrentSession().delete(empleado);
	}
}
