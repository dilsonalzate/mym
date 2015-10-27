package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Actividad;
import com.sprhib.model.Programacion;

public interface ProgramacionDAO {
	
	public void addProgramacion(Programacion programacion);
	public void updateProgramacion(Programacion programacion);
	public Actividad getProgramacion(int id);
	public void deleteProgramacion(int id);
	public List<Programacion> getProgramaciones();

}
