package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



import files.payload;


public class MyselfPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//given - All input details 
		//2.when  - Submit the API
		//3.then  - Validate the Response
		// log().all() we see the logs in console because using log().all()
		// We want to extract whole response into strings [extract().response().asString()] need to create one variable as Sting response
		// Add place ->update Place with new Address -> get place to validate if new address is present in response	
		// "+placeId+" in this + symbol represents concadination operator without + mentioning placdId considering as a string so if we write using + concatination operator then considers as a variable
        // TestNg Jar file downloaded and added in Package(RestAssuredAutomation->Right click properties->java Build path ->libraries->click add->import downloaded jar file ->Apply and close. 
		// Content of the file to string- content of file can convert into Byte ->Byte data to string
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlace()).when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		JsonPath  js=new JsonPath(response);         //For parsing Json   //There is a path called JsonPath and also im created object for the class
		//String placeId=js.getString("place_id");
		
		//System.out.println(placeId);
	}
}