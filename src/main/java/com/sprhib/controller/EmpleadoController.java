package com.sprhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Empleado;
import com.sprhib.model.Team;
import com.sprhib.service.TeamService;

@Controller
@RequestMapping(value="/empleado")
public class EmpleadoController { 
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addTeamPage() {
		ModelAndView modelAndView = new ModelAndView("agregar-empleado-form");
		modelAndView.addObject("empleado", new Empleado());
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView agregarEmpleado(@ModelAttribute Empleado empleado) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		Team team = new Team();
		
		teamService.addTeam(team);
		
		String message = "Team was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public ModelAndView modificarEmpleado(@ModelAttribute Empleado empleado) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		Team team = new Team();
		
		teamService.addTeam(team);
		
		String message = "Team was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.PUT)
	public ModelAndView eliminarEmpleado(@ModelAttribute Empleado empleado) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		Team team = new Team();
		
		teamService.addTeam(team);
		
		String message = "Team was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("list-of-teams");
		
		List<Team> teams = teamService.getTeams();
		modelAndView.addObject("teams", teams);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-team-form");
		Team team = teamService.getTeam(id);
		modelAndView.addObject("team",team);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute Team team, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		teamService.updateTeam(team);
		
		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		teamService.deleteTeam(id);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
