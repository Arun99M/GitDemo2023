package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.ReUsableMethods;
import files.payload;

public class DynamicJson {
	
	@Test(dataProvider="BooksData")
	public void addbook(String isbn,String aisle)  // both string declaring to parse the data provider array elements
	{
		 RestAssured.baseURI="http://216.10.245.166";
		 String response =given().header("Content-Type","application/json")
		 .body(payload.Addbook("jhgsu8ut","8712090800"))                   //Always need to change the aile value in payload or else output getfailed due to already exists. and the aile and isbn value updating here to change the value easy because everytime go and change in payload,in payload made aile and isbn with concatination opertaor. 
		 .when().post("/Library/Addbook.php")
		 .then().assertThat().log().all().statusCode(200).extract().response().asString();
		 JsonPath js=ReUsableMethods.rawToJson(response);
		 String id =js.get("ID");
		 System.out.println(id);
		
		
		
	//Output am not getting due to payload string format need to change
	}
//Understanding TestNG Data provider for parameterization
@DataProvider (name="BooksData")
public Object[][] getData()        //Remove the void and place with Object[][] because return type array to be added
{
	//array = collection of elements
	//multidimentional array = collection of arrays
	return new Object[][] {{"office","8678"},{"querty","9789"},{"hytg","9767"},{"jkyy","5678"}};
	
	}

	
}
