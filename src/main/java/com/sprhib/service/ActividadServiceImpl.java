package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.ActividadDAO;
import com.sprhib.model.Actividad;

@Service
@Transactional
public class ActividadServiceImpl implements ActividadService {
	
	@Autowired
	private ActividadDAO _actividadDAO;

	@Override
	public void addActividad(Actividad actividad) {
		_actividadDAO.addActividad(actividad);
	}

	@Override
	public void updateActividad(Actividad actividad) {

		_actividadDAO.updateActividad(actividad);
	}

	@Override
	public Actividad getActividad(int id) {
		return _actividadDAO.getActividad(id);
	}

	@Override
	public void deleteActividad(int id) {
		_actividadDAO.deleteActividad(id);
	}

	@Override
	public List<Actividad> getActividades() {
		return _actividadDAO.getActividades();
	}

}
