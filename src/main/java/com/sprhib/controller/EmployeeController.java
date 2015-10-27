package com.sprhib.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprhib.model.Empleado;
import com.sprhib.service.EmpleadoService;

@Controller
@RequestMapping(value="/employee")
public class EmployeeController {

	@Autowired
	private EmpleadoService _empleadoService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody Empleado addEmpleado(@RequestBody Empleado empleado) {
		_empleadoService.addEmpleado(empleado);
		
		return empleado;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public @ResponseBody Empleado updateEmpleado(@RequestBody Empleado empleado) {
		_empleadoService.updateEmpleado(empleado);
		
		return empleado;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody Empleado deleteEmpleado(@RequestBody Empleado empleado) {
		_empleadoService.deleteEmpleado(empleado);
		return empleado;
	}
	
	@RequestMapping(value="/getEmpleados", method=RequestMethod.GET)
	public @ResponseBody List<Empleado> getEmpleados() {
		List<Empleado> empleados = new ArrayList<Empleado>();
		empleados = _empleadoService.getEmpleados();
		
		return empleados;
	}
}
