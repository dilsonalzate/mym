package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Actividad;

public interface ActividadDAO {

	public void addActividad(Actividad team);
	public void updateActividad(Actividad team);
	public Actividad getActividad(int id);
	public void deleteActividad(int id);
	public List<Actividad> getActividades();
}
