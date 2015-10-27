package com.sprhib.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table(name="role_x_actividad")
public class RolActividad {
	
	@Id
	@GeneratedValue
	private Integer id;
	
//	private Integer idrole;
	
	private Double valor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdrole() {
		return role.getIdrole();
	}
	
	public String getNombre_rol() {
		return role.getNombre_rol();
	}
//
//	public void setIdrole(Integer idrole) {
//		this.idrole = idrole;
//	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
//    private Integer idactividad;  
  
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idactividad") 
	@JsonBackReference
    private Actividad actividad;  
    
//    public Integer getIdactividad() {
//		return idactividad;
//	}
//
//	public void setIdactividad(Integer idactividad) {
//		this.idactividad = idactividad;
//	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idrole") 
	@JsonBackReference
    private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}  
    
//    public Integer getIdactividad() {
//		return idactividad;
//	}
//
//	public void setIdactividad(Integer idactividad) {
//		this.idactividad = idactividad;
//	}
}