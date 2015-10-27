package com.sprhib.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="asignacion")
public class Asignacion implements Serializable {
	
	
	
			@Id		
	@OneToOne
	private RolActividad role;
	
			@Id
	@OneToOne
	private Empleado empleado;
	
	@ManyToOne  
	@JoinColumn(name = "idprogramacion")   
    private Programacion programacion;

	public Programacion getProgramacion() {
		return programacion;
	}

	public void setProgramacion(Programacion programacion) {
		this.programacion = programacion;
	}

	public RolActividad getRole() {
		return role;
	}

	public void setRole(RolActividad role) {
		this.role = role;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
}
