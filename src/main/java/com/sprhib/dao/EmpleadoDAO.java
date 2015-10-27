package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Empleado;

public interface EmpleadoDAO {

	public void addEmpleado(Empleado empleado);

	List<Empleado> getEmpleados();

	public void updateEmpleado(Empleado empleado);

	public void deleteEmpleado(Empleado empleado);
}
