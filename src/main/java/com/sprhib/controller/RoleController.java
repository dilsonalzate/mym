package com.sprhib.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sprhib.model.Role;
import com.sprhib.service.RoleService;

@Controller
@RequestMapping(value="/role")
public class RoleController {

		@Autowired
		private RoleService _roleService;
		
		@RequestMapping(value="/add", method=RequestMethod.POST)
		public @ResponseBody Role addRole(@RequestBody Role role) {
			_roleService.addRole(role);
			return role;
		}
		
		@RequestMapping(value="/update", method=RequestMethod.PUT)
		public @ResponseBody Role updateRole(@RequestBody Role role) {
			_roleService.updateRole(role);
			return role;
		}
		
		@RequestMapping(value="/delete", method=RequestMethod.POST)
		public @ResponseBody Role deleteRole(@RequestBody Role role) {
			_roleService.deleteRole(role);
			return role;
		}
		
		@RequestMapping(value="/getRoles", method=RequestMethod.GET)
		public @ResponseBody List<Role> getRoles() {
			List<Role> roles = new ArrayList<Role>();
			roles = _roleService.getRoles();
			return roles;
		}
	}
