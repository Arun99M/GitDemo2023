package resources;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {               //utils nothing but utilities
	
	public static RequestSpecification req;  // if don't put a static, 2nd time while running test treated as null, if we put static it will declared across our test cases
	
	public RequestSpecification requestSpecification() throws IOException 
	
	{
		if(req==null)      //used to avoid the mutliple test cases over written
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));  //FileOutputStream is to write the file in output
		
		//RestAssured.baseURI="https://rahulshettyacademy.com";	// i can remove this because create a new file and calling from th	
		req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key","qaclick123")               //Import Spec Builder
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();  //Once everything is set at finally we need to add build that will build the whole specification of request and response
		return req;        //addFilter is used to show the output of logs
		
		}
		return req;
	}
	
	public static String getGlobalValue(String key) throws IOException  // this method creating for baseUrl to get from global.Properties.//static is creating for we can access method directly without creating object 
	{
		Properties prop = new Properties();  //FIleInputStream is to read the file from the global.properties inside
		FileInputStream fis = new FileInputStream("C:\\Users\\ArunkumarM\\eclipse-workspace\\RestAssuredAutomation\\src\\test\\java\\resources\\global.properties"); //right click go to properties in gobal.properties resources and copy the link and past over here.
		prop.load(fis);
		return prop.getProperty(key); // i can put in bracket baseUrl or Key, if i put baseUrl it takes only concern one or else if i put key it will consider different url while running
		
	}
	public String getJsonPath(Response response,String key)
	{
		 String resp=response.asString();  //all the this and next steps took from step definition  @Then("{string} in response body is {string}")
		   JsonPath js = new JsonPath(resp);
		   return js.get(key).toString();
	}
	
}

