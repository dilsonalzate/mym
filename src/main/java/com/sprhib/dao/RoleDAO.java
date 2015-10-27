package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Empleado;
import com.sprhib.model.Role;

public interface RoleDAO {

	List<Role> getRoles();
	
	public void addRole(Role role);

	public void updateRole(Role role);

	public void deleteRole(Role role);
}
