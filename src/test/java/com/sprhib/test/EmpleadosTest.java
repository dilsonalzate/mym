package com.sprhib.test;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.sprhib.dao.EmpleadoDAO;
import com.sprhib.init.TestContext;
import com.sprhib.model.Empleado;
import com.sprhib.service.EmpleadoService;
import com.sprhib.service.EmpleadoServiceImpl;

@ContextConfiguration(classes = {TestContext.class})
public class EmpleadosTest  extends AbstractTestNGSpringContextTests {
	
	
	private static Logger logger = Logger.getLogger(EmpleadosTest.class);
	 
	@InjectMocks
	@Spy
	private EmpleadoService empleadoService = new EmpleadoServiceImpl();
	
	@Mock
	private EmpleadoDAO _empleadoDAO;
	 
	private Empleado firstUser;
	 
	/**
	* Creates Test Users
	*/
	private void createUsers() {
	List<Empleado> empleados = new ArrayList<Empleado>();	
	firstUser = new Empleado();
	firstUser.setApellido("Apellido");
	empleados.add(firstUser);
//	Mockito.when(userService.getEmpleados()).thenReturn(empleados);
	}

	/**
	*  Asserts that User Properties are not null.
	* @param User
	*/
	private void assertNotNullUserProperties(Empleado user) {
	Assert.assertNotNull(user, "User must not be null!");
	}
	 
	/**
	* The annotated method will be run before any test method belonging to the classes
	* inside the <test> tag is run.
	*
	*/
	@BeforeTest
	public void beforeTest() {
	logger.debug("BeforeTest method is run...");
	}
	 
	/**
	* The annotated method will be run before the first test method in the current class
	* is invoked.
	*/
	@BeforeClass
	public void beforeClass() {
	logger.debug("BeforeClass method is run...");
	createUsers();
	}
	 
	/**
	* The annotated method will be run before each test method.
	*/
	@BeforeMethod
	public void beforeMethod() {
	MockitoAnnotations.initMocks(this);
	logger.debug("BeforeMethod method is run...");
	} 
	 
	/**
	* Tests the process of adding user
	*/
	@Test
	public void addUser() {
	assertNotNullUserProperties(firstUser);
	}
	 
	/**
	* Tests the process of querying user
	*/
	@Test
	public void getUserById() {
	Empleado tempUser = getUserService().getEmpleados().get(0);
	assertNotNullUserProperties(tempUser);
	Assert.assertEquals("Id is wrong!", "1", tempUser.getNombre());
	Assert.assertEquals("Name is wrong!", "Lionel", tempUser.getApellido());
	Assert.assertEquals("Surname is wrong!", "Messi", tempUser.getCedula());
	}
	 
	/**
	* Tests the process of deleting user
	*/
	@Test
	public void deleteUser() {
	assertNotNullUserProperties(firstUser);
//	Assert.assertTrue("User can not be added! User : " + secondUser, getUserService().addUser(secondUser));
//	Assert.assertTrue("User can not be deleted! User : " + secondUser, getUserService().deleteUser(secondUser));
	}
	 
	/**
	* Test user count
	*/
	@Test
	public void getUsers() {
		List<Empleado> empleados = new ArrayList<Empleado>();	
		firstUser = new Empleado();
		firstUser.setApellido("Apellido");
		empleados.add(firstUser);
		Mockito.when(_empleadoDAO.getEmpleados()).thenReturn(empleados);
//		Mockito.doReturn(empleados).when(userService.getEmpleados());
		List<Empleado> expecteds = empleadoService.getEmpleados();
		
		Assert.assertEquals(expecteds.get(0), firstUser);
	}
	 
	/**
	* The annotated method will be run after all the test methods in the current class have been run.
	*/
	@AfterClass
	public void afterClass() {
	logger.debug("AfterClass method is run...");
	}
	 
	/**
	* The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run.
	*/
	@AfterTest
	public void afterTest() {
	logger.debug("AfterTest method is run...");
	}
	
	/**
	* The annotated method will be run after each test method.
	*/
	@AfterMethod
	public void afterMethod() {
	logger.debug("AfterMethod method is run...");
	}
	 
	/**
	* Gets User Service
	* @return IUserService User Service
	*/
	public EmpleadoService getUserService() {
	return empleadoService;
	}
	 
	/**
	* Sets User Service
	* @param IUserService User Service
	*/
	public void setUserService(EmpleadoService userService) {
	this.empleadoService = userService;
	}
	 
	}

