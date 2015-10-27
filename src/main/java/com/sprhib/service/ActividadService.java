package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Actividad;

public interface ActividadService {

	public void addActividad(Actividad actividad);
	public void updateActividad(Actividad actividad);
	public Actividad getActividad(int id);
	public void deleteActividad(int id);
	public List<Actividad> getActividades();
}
