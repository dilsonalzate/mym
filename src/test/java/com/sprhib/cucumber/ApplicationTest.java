package com.sprhib.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public abstract class ApplicationTest {
	
	private static WebDriver _webDriver;

	public static WebDriver getWebDriver() {
		return _webDriver;
	}

	@BeforeClass
	public void init(){
		_webDriver = new FirefoxDriver(new FirefoxProfile());
	}

	@Given("^Usuario entra a la aplicacion$")
	public void Usuario_entra_a_la_aplicacion() throws Throwable {
		_webDriver.get("http://evening-woodland-2196.herokuapp.com/Dilson/");
	}
	
	@When("^Ingresa a la seccion de \"([^\"]*)\"$")
	public void Ingresa_a_la_seccion_de(String seccion) throws Throwable {
		getWebDriver().findElement(By.xpath("//a[text()[contains(., '" + seccion + "')]]")).click();
	}
	
	
}
