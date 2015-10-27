package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.RoleDAO;
import com.sprhib.model.Role;

@Service
@Transactional
public class RoleServiceImp implements RoleService {

	@Autowired
	private RoleDAO _roleDAO;
	
	
	@Override
	public List<Role> getRoles() {
		return _roleDAO.getRoles();
	}


	@Override
	public void addRole(Role role) {
		_roleDAO.addRole(role);
	}


	@Override
	public void updateRole(Role role) {
		_roleDAO.updateRole(role);
	}


	@Override
	public void deleteRole(Role role) {
		_roleDAO.deleteRole(role);
	}

}
