package tests;

import io.restassured.RestAssured;


import io.restassured.path.json.JsonPath;

import static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import files.ReUsableMethods;
import files.payload;


public class Testsexamples {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//given - All input details 
		//2.when  - Submit the API
		//3.then  - Validate the Response
		// log().all() we see the logs in console because using log().all()
		// We want to extract whole response into strings [extract().response().asString()] need to create one variable as Sting response
		//JsonPath js=new JsonPath()THE JsonPath is a class, JsonPath class is the one which takes String as an input and convert that into Json and it will help to parse the Json
		// Add place ->update Place with new Address -> get place to validate if new address is present in response	
		// "+placeId+" in this + symbol represents concadination operator without + mentioning placdId considering as a string so if we write using + concatination operator then considers as a variable
        // TestNg Jar file downloaded and added in Package(RestAssuredAutomation->Right click properties->java Build path ->libraries->click add->import downloaded jar file ->Apply and close. 
		// Static Json body -> have 3 different types -> Directly we can add Json body in the test-> we create new class and make it as payload from there we can call it -> we can do it from add file Notepad++
		// Dynamic Json body -. we can have Data provider annotation and call it.
		
		//AddPlaceApi
		
		//RestAssured.baseURI= "https://rahulshettyacademy.com";
		//String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		//.body(payload.AddPlace()).when().post("/maps/api/place/add/json")
		//.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
		//.header("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		//System.out.println(response);
		
		//JsonPath  js=new JsonPath(response);         //For parsing Json   //There is a path called JsonPath and also im created object for the class
		//String placeId=js.getString("place_id");     //Extract placeid from Json payload or body.
		
		//System.out.println(placeId);
		
		// trying for static Json Payloads installing Notepad++ from their json path copying and pasting here.
		// Content of the file to string-> content of file can convert into Byte ->Byte data to string
		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(new String (Files.readAllBytes(Paths.get("C:\\Users\\ArunkumarM\\Downloads\\addPlace.Json"))))     // keep the curser on Bytes and shows Add throws declaration click and import it.
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		JsonPath  js=new JsonPath(response);         //For parsing Json   //There is a path called JsonPath and also im created object for the class
		String placeId=js.getString("place_id");     //Extract placeid from Json payload or body.
		
		System.out.println(placeId);
		
		
		
		//Update place
		String newAddress = "winter walk, USA";
		
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"place_id\": \""+placeId+"\",\r\n" 
				+ "    \"address\": \""+newAddress+"\",\r\n"
				+ "    \"key\": \"qaclick123\"\r\n"
				+ "}")
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));		
	
	// Get Place API
		String getPlaceResponse=given().log().all().queryParam("key","qaclick123")
		.queryParam("place_id",placeId)
		.when().get("/maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		//JsonPath js1 = new JsonPath(getPlaceResponse);           //Jsonpath is a class which expects string arguments thastwhy created a variable as getPlaceResponse
		//JsonPath js1 = new JsonPath(getPlaceResponse);     We need to remove the Java related code from here and restrict the testcases only to restassured core logic We can have a one more class which we call as a ReUsableMethods and we will use and call from this methods, This is used to optimizing our test and making it our cleaner way nothing is different
		JsonPath js1= ReUsableMethods.rawToJson(getPlaceResponse);
		String actualAddress=js1.getString("address");
		System.out.println(actualAddress);
		Assert.assertEquals(actualAddress, newAddress);  // import TestNG
		
	//Cucumber Junit,TestNg
		
	}

}
