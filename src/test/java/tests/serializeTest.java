package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;

public class serializeTest {

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
		
		Response res = given().queryParam("key","qaclick123").body(p)
		.when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().response();

		String responseString = res.asString();
		System.out.println(responseString);
		
	}

}
