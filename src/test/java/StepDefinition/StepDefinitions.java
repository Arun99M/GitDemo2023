package StepDefinition;

import static io.restassured.RestAssured.given;



import static org.junit.Assert.*;     // this package used for assertEquals need to write manually
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinitions extends Utils {  // import utils resources  // using inhertance concepts just extends the class and i can use all the method of the class i can call them in this step defintion class without creating objects, because using inheritance class step definition class is treated as child class inherting all the methods which are available in parent utils class.
	RequestSpecification res; // put for a global / declar it globally
	ResponseSpecification res1;  //put for a global / declar it globally
	Response response ;
	TestDataBuild data = new TestDataBuild();   //create a one object using TestDataBuild
	static String place_id;  //mention the static or else for place_id it will through a null error, beacsue same testcases(AddPlaceAPI) using for delete API
	
	
	@Given("Add place payload with {string}  {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	

		
		 res = given().spec(requestSpecification()) // i can remove RequestSpecification over here because already mentioned as global from there res will point it out and // spec(requestSpecification)object calling from Utils
		.body(data.addPlacePayload(name,language,address));   //dynamic value is passing in arguments.
	}
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource,String method) {
	    // Write code here that turns the phrase above into concrete actions
		
//constructor will be called with value of resource which we pass
		APIResources resourceAPI = APIResources.valueOf(resource);  // enum name writing
		System.out.println(resourceAPI.getResource());
		res1=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();     ////Once everything is set at finally we need to build that will build the whole specification of request and response
			
		if(method.equalsIgnoreCase("POST"))		
	        	 response= res.when().post(resourceAPI.getResource()); // for POST method repose should be in POST
		
	    else if(method.equalsIgnoreCase("GET"))
	        	response=res.when().get(resourceAPI.getResource());   //for GET method response should be get
	
	}
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	   assertEquals(response.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExpectedValue) {
	    // Write code here that turns the phrase above into concrete actions     // keyValue is nothing but "status" which mentioned in feature and  ExpectedValue is nothing but "OK" which mentioned in feature to call we using
	   
	   	
	   assertEquals(getJsonPath(response,keyValue).toString(),ExpectedValue);   // to string is used to extract 
	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
		// requestSpec
	    place_id = getJsonPath(response,"place_id");      
		res=given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource,"GET");  //this using for in 1st test case getplaceAPI
		String actualname = getJsonPath(response,"name");  //verifying the name what we got exactly same what we sending in the dynamic name
		assertEquals(actualname,expectedName);
	}

	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	 res=given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	
}
}
