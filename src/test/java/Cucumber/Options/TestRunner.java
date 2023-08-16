package Cucumber.Options;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/java/features",glue= {"StepDefinition"})

//tags= "@DeletePlace"    //tags is used to run only particular apis

 
public class TestRunner {
  
}



//Features - Place Validations
//StepDefinition - Public void methods for features (src/tests/java)
//TestDataBuild - Placing all the payloads and object calling to step definition
//Utils - in this using url for request format and create the new method for Base url to call
//resources-APIResources - enum class = 
//@Addplace like tag name mentioning for to run the particular code

//Hooks -> Hooks is used to set precondition and postcondition for our cucumber scenarios. to create in under stepdefinition package create new class 
