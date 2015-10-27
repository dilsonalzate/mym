package com.sprhib.test;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sprhib.dao.RoleDAO;
import com.sprhib.init.TestContext;
import com.sprhib.model.Role;
import com.sprhib.service.RoleService;
import com.sprhib.service.RoleServiceImp;

@ContextConfiguration(classes = {TestContext.class})
public class RoleServiceTest extends AbstractTestNGSpringContextTests {
	
	
	@InjectMocks
	private RoleService _roleService = new RoleServiceImp();
	
	@Mock
	private RoleDAO _roleDAO;
	
	@BeforeMethod
	public void beforeMethod() {
	MockitoAnnotations.initMocks(this);
	} 
	
	@Test
	public void testGetRoles() {
		
		List<Role> roles = new ArrayList<Role>();
		Role role = new Role();
		role.setDescripcion("Role encargado de coordinar los diferentes evento logisticos");
		role.setNombre_rol("Coordinador");
		roles.add(role);
		Mockito.when(_roleDAO.getRoles()).thenReturn(roles);
		
		List<Role> actualRoles = _roleService.getRoles();
		Assert.assertEquals(actualRoles.get(0), role);
		Mockito.verify(_roleDAO, Mockito.times(1)).getRoles();
	}

}
