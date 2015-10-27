package com.sprhib.cucumber;

import com.sprhib.model.Empleado;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmpleadoStepDefs {

	@Given("^Nombre del empleado \"([^\"]*)\"$")
	public void Nombre_del_empleado(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	   Empleado empleado = new Empleado();
	}

	@Given("^identification del empleado \"([^\"]*)\"$")
	public void identification_del_empleado(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^Doy click en el boton \"([^\"]*)\"$")
	public void Doy_click_en_el_boton(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^Se debe crear un empleado.$")
	public void Se_debe_crear_un_empleado() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
}
