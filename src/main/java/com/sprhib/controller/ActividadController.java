package com.sprhib.controller;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sprhib.model.Actividad;
import com.sprhib.service.ActividadService;

@Controller
@RequestMapping(value="/activity")
public class ActividadController {
	
	@Autowired
	private ActividadService _actividadService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody Actividad addActividad(@RequestBody Actividad actividad) {
		_actividadService.addActividad(actividad);
		return actividad;
	} 
	
	@JsonIgnore
	@RequestMapping(value="/getActividades", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Actividad> getActividades() {
		List<Actividad> actividades = new ArrayList<Actividad>();
		actividades = _actividadService.getActividades();
		return actividades;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody Actividad deleteActividad(@RequestBody Actividad actividad) {
		_actividadService.deleteActividad(actividad.getIdactividad());
		return actividad;
	}
}
