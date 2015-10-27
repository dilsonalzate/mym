package com.sprhib.cucumber;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DoctorStepDefs {
	
	
	private WebDriver getWebDriver() {
		return GeneralStepDefs.getWebDriver();
	}
	
	@When("^Ingresa a la seccion de \"([^\"]*)\"$")
	public void Ingresa_a_la_seccion_de(String seccion) throws Throwable {
		getWebDriver().findElement(By.xpath("//a[text()[contains(., '" + seccion + "')]]")).click();
	}

	@Then("^Se muestra la pantalla \"([^\"]*)\"$")
	public void Se_muestra_la_pantalla(String seccion) throws Throwable {
		WebElement element = getWebDriver().findElement(By.xpath("//h1//small[text()[contains(., '" + seccion + "')]]"));
		Assert.assertTrue(element.isDisplayed());	
		getWebDriver().close();
	}

	@When("^Ingresa los datos del formulario$")
	public void Ingresa_los_datos_del_formulario(DataTable doctorData) throws Throwable {
		
		List<List<String>> data = doctorData.raw();
		WebElement nombre = getWebDriver().findElement(By.id("name"));
		nombre.sendKeys(data.get(1).get(1));
		WebElement apellidos = getWebDriver().findElement(By.id("last_name"));
		apellidos.sendKeys(data.get(2).get(1));
		WebElement telefono = getWebDriver().findElement(By.id("telephone"));
		telefono.sendKeys(data.get(3).get(1));
		WebElement tipoDocumento = getWebDriver().findElement(By.id("identification_type"));
		tipoDocumento.sendKeys(data.get(4).get(1));
		WebElement documento = getWebDriver().findElement(By.id("identification"));
		documento.sendKeys(data.get(5).get(1));
	}
	
	@When("^Guarda los datos$")
	public void Guarda_los_datos() throws Throwable {
		WebElement element = getWebDriver().findElement(By.cssSelector(".btn.btn-primary.pull-right"));
	    element.click();
	}

	@Then("^Se muestra el mensaje de exito \"([^\"]*)\".$")
	public void Se_muestra_el_mensaje_de_exito(String successMessage) throws Throwable {
		WebElement element = getWebDriver().findElement(By.xpath("//p[text()[contains(., '" + successMessage + "')]]"));
		Assert.assertTrue(element.isDisplayed());	
	}

	@Then("^El doctor creado se visualiza en la tabla$")
	public void El_doctor_creado_se_visualiza_en_la_tabla(DataTable doctorData) throws Throwable {
		List<List<String>> data = doctorData.raw();
		
		WebElement element = getWebDriver().findElement(By.id("firstName"));
		Assert.assertTrue(element.getText().equals(data.get(1).get(1)));	
		getWebDriver().close();
	}
}
