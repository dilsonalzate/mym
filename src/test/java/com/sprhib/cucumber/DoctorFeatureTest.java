package com.sprhib.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( features = {"src/test/resources/com/sprhib/cucumber/doctor.feature"}, 
glue = {"com.sprhib.cucumber"},
format = {"pretty"} )
public class DoctorFeatureTest {

}
