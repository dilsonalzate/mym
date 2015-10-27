package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Empleado;

public interface EmpleadoService {
	
	public void addEmpleado(Empleado empleado);

	public List<Empleado> getEmpleados();

	public void updateEmpleado(Empleado empleado);

	public void deleteEmpleado(Empleado empleado);

}
