package tests;

import io.restassured.RestAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;

public class SpecBuilderTest {

	private static RequestSpecification res;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		p.setName("Frontline house");
		List<String> myList = new ArrayList<String>();     //Creating object class for arrayList due to array mentioned in List.
		myList.add("shoe park");
		myList.add("shop");
		
		p.setTypes(myList);
		Location l= new Location();  // drag on Location and import location(pojo)
		l.setLat(-38.383494);  // it is a double return type
		l.setLng(33.427362);
		
		p.setLocation(l);
		
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")               //Import Spec Builder
		.setContentType(ContentType.JSON).build();  //Once everything is set at finally we need to add build that will build the whole specification of request and response
		
		
		 RequestSpecification res = given().spec(req)
		.body(p);
		
		ResponseSpecification res1=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();     ////Once everything is set at finally we need to build that will build the whole specification of request and response
		
		Response response= res.when().log().all().post("/maps/api/place/add/json")
				.then().spec(res1).extract().response();

		String responseString = response.asString();
		System.out.println(responseString);
		
	}

}
