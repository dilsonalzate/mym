package com.sprhib.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="programacion")
public class Programacion {
	
	@Id
	@GeneratedValue
	private Integer idprogramacion;
	
	private String lugar;
	
	private Date fecha;
	
	private Time hora;
	
	private String establecimiento;
	
	public Integer getIdprogramacion() {
		return idprogramacion;
	}
	public void setIdprogramacion(Integer idprogramacion) {
		this.idprogramacion = idprogramacion;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public String getEstablecimiento() {
		return establecimiento;
	}
	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}
	
	
	@OneToMany(mappedBy = "programacion")  
    private List<Asignacion> asignaciones;

	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}
	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

}
