package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Role;

public interface RoleService {

	List<Role> getRoles();
	
	public void addRole(Role role);

	public void updateRole(Role role);

	public void deleteRole(Role role);
}
