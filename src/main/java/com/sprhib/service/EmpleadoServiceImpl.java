package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.EmpleadoDAO;
import com.sprhib.model.Empleado;

@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoDAO _empleadoDAO;

	public void addEmpleado(Empleado empleado)
	{
		_empleadoDAO.addEmpleado(empleado);
	}

	@Override
	public List<Empleado> getEmpleados() {
		return _empleadoDAO.getEmpleados();
	}

	@Override
	public void updateEmpleado(Empleado empleado) {
		_empleadoDAO.updateEmpleado(empleado);
	}

	@Override
	public void deleteEmpleado(Empleado empleado) {
		_empleadoDAO.deleteEmpleado(empleado);
	}
}
