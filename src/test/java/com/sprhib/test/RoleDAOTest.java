package com.sprhib.test;

import java.util.List;

import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.sprhib.dao.RoleDAO;
import com.sprhib.dao.RoleDAOImpl;
import com.sprhib.init.TestContext;
import com.sprhib.model.Role;

@ContextConfiguration(classes = {TestContext.class})
public class RoleDAOTest extends AbstractTestNGSpringContextTests {
	
	@InjectMocks
	private RoleDAO _roleDao = new RoleDAOImpl();
	
	@Test
	public void testGetRoles(){
			
	     List<Role> roles = _roleDao.getRoles();
	     
	}

}
