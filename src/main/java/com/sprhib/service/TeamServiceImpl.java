package com.sprhib.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.ActividadDAO;
import com.sprhib.dao.ProgramacionDAO;
import com.sprhib.dao.TeamDAO;
import com.sprhib.model.Actividad;
import com.sprhib.model.Asignacion;
import com.sprhib.model.Empleado;
import com.sprhib.model.Programacion;
import com.sprhib.model.RolActividad;
import com.sprhib.model.Team;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	private TeamDAO teamDAO;
	
	@Autowired
	private ActividadDAO _actividadDAO;
	
	@Autowired
	private ProgramacionDAO _programacionDAO;
	
	public void addTeam(Team team) {
		
		Programacion programacion = new Programacion();
		programacion.setLugar("Belen");
		programacion.setEstablecimiento("Fonda los Amigos");
		programacion.setFecha(Date.valueOf("2014-04-02"));
		programacion.setHora(Time.valueOf("04:00:00"));
		
		List<Asignacion> asignaciones = new ArrayList<Asignacion>();
		Asignacion asignacion = new Asignacion();
		
		Empleado empleado = new Empleado();
		empleado.setIdempleado(1);
		empleado.setNombre("Dilson");
		empleado.setApellido("Alzate");
		empleado.setCedula("71387604");
		
		RolActividad rolActividad = new RolActividad();
//		rolActividad.setActividad(_actividadDAO.getActividad(2));
		rolActividad.setId(6);
		rolActividad.setValor(2000D);
//		rolActividad.setIdrole(1);
		
		asignacion.setEmpleado(empleado);
		asignacion.setRole(rolActividad);
		asignacion.setProgramacion(programacion);
		asignaciones.add(asignacion);
		programacion.setAsignaciones(asignaciones);
		_programacionDAO.addProgramacion(programacion);
		
//		Actividad actividad = new Actividad();
//		actividad.setFecha_fin(Date.valueOf("2014-04-04"));
//		actividad.setFecha_inicio(Date.valueOf("2014-04-03"));
//		actividad.setNombre("ON");
//		
//		List<RolActividad> rolActividadList = new ArrayList<RolActividad>();
//		RolActividad rolActividad = new RolActividad();
//		rolActividad.setActividad(actividad);
//		rolActividad.setIdrole(1);
//		rolActividad.setValor(2000D);
//		rolActividadList.add(rolActividad);
//		actividad.setRolActividadList(rolActividadList);
//		_actividadDAO.addActividad(actividad);
		
		
		
		teamDAO.addTeam(team);	
		
	}

	public void updateTeam(Team team) {
		teamDAO.updateTeam(team);
	}

	public Team getTeam(int id) {
		return teamDAO.getTeam(id);
	}

	public void deleteTeam(int id) {
		teamDAO.deleteTeam(id);
	}

	public List<Team> getTeams() {
		return teamDAO.getTeams();
	}

}
