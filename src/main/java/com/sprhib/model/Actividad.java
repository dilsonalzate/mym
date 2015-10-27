package com.sprhib.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table(name="actividad")
public class Actividad {
	
	@Id
	@GeneratedValue
	private Integer idactividad;
	
	private String nombre;
	
	private Date fecha_inicio;
	
	private Date fecha_fin;
	
	public String getNombre() {
		return nombre;
	}
	public Integer getIdactividad() {
		return idactividad;
	}
	public void setIdactividad(Integer idactividad) {
		this.idactividad = idactividad;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@OneToMany(mappedBy = "actividad", fetch = FetchType.EAGER) 
    private List<RolActividad> rolActividadList;

	
	public List<RolActividad> getRolActividadList() {
		return rolActividadList;
	}
	public void setRolActividadList(List<RolActividad> rolActividadList) {
		this.rolActividadList = rolActividadList;
	}  
  

}
