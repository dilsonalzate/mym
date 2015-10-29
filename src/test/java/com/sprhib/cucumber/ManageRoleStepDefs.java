package com.sprhib.cucumber;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManageRoleStepDefs {
	
	private static WebDriver mDriver;

	@Given("^Usuario ingresa a la aplicacion$")
	public void Usuario_ingresa_a_la_aplicacion() throws Throwable {
		mDriver = new FirefoxDriver(new FirefoxProfile());
		mDriver.get("http://localhost:8080/mymlogistica/index.html");
		
	}

	@When("^Ingresa a la seccion de administracion de \"([^\"]*)\"$")
	public void Ingresa_a_la_seccion_de_administracion_de(String menu) throws Throwable {
		mDriver.findElement(By.xpath("//a[text()[contains(., '" + menu + "')]]")).click();
	}

	@Then("^Se muestra la seccion de administracion de \"([^\"]*)\"$")
	public void Se_muestra_la_seccion_de_administracion_de(String buttonName) throws Throwable {
		WebElement element = mDriver.findElement(By.xpath("//button[text()[contains(., '" + buttonName + "')]]"));
		Assert.assertTrue(element.isDisplayed());	
		mDriver.close();
	}

	@When("^Abre la ventana para \"([^\"]*)\"$")
	public void Abre_la_ventana_para(String buttonName) throws Throwable {
		WebElement element = mDriver.findElement(By.xpath("//button[text()[contains(., '" + buttonName + "')]]"));
	    element.click();
	}
	
	@When("^Guardo los datos$")
	public void Guardo_los_datos() throws Throwable {
		WebElement element = mDriver.findElement(By.id("btn_add_activity"));
	    element.click();
	}

	@When("^Ingreso los datos del formulario$")
	public void Ingreso_los_datos_del_formulario(DataTable roleData) throws Throwable {
	    
		List<List<String>> data = roleData.raw();
		
		switch (data.get(0).get(1)) {
		case "Actividad":
			WebElement nombreActividad = mDriver.findElement(By.id("text_nombre_activity"));
			nombreActividad.sendKeys(data.get(2).get(1));
			WebElement fechaInicio = mDriver.findElement(By.id("text_fecha_inicio_activity"));
			fechaInicio.sendKeys(data.get(3).get(1));
			WebElement fechaFin = mDriver.findElement(By.id("text_fecha_fin_activity"));
			fechaFin.sendKeys(data.get(4).get(1));
			break;

		default:
			WebElement nombreRole = mDriver.findElement(By.id("text_nombre_role"));
			nombreRole.sendKeys(data.get(1).get(1));
			WebElement descripcionRole = mDriver.findElement(By.id("text_descripcion_role"));
			descripcionRole.sendKeys(data.get(2).get(1));
			break;
		}
		
	}
	
	@Then("^El role creado se debe visualizar en la tabla de roles.$")
	public void El_role_creado_se_debe_visualizar_en_la_tabla_de_roles() throws Throwable {
	    mDriver.close();
	}
}
