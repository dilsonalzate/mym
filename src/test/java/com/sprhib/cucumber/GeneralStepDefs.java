package com.sprhib.cucumber;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GeneralStepDefs {

	private static WebDriver _webDriver;
	
	public static WebDriver getWebDriver() {
		if (_webDriver == null)
		{
			_webDriver = new FirefoxDriver(new FirefoxProfile());
		}
		return _webDriver;
	}
	
	@Given("^Usuario entra a la aplicacion$")
	public void Usuario_entra_a_la_aplicacion() throws Throwable {
		_webDriver = new FirefoxDriver(new FirefoxProfile());
		_webDriver.get("http://evening-woodland-2196.herokuapp.com/Dilson/");
	}
}
