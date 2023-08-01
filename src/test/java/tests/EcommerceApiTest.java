package tests;

import Pojo.LoginRequest;


import Pojo.LoginResponse;
import Pojo.OrderDetail;
import Pojo.Orders;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

public class EcommerceApiTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
	    .setContentType(ContentType.JSON).build();
		
		LoginRequest LoginRequest = new LoginRequest();
		LoginRequest.setUserEmail("postman100876@gmail.com");
		LoginRequest.setUserPassword("Postman@1234$");
		
		RequestSpecification reqLogin= given().relaxedHTTPSValidation().log().all().spec(req).body(LoginRequest); //SSL certificate is invalid we have to use relaxedHTTPSValidation() to byepass the errors.
		LoginResponse loginResponse = reqLogin.when().post("/api/ecom/auth/login").then().log().all().extract().response()
				.as(LoginResponse.class);
		
		//if required ResponseSpecBuilder also i can use or directly got with RequestSpecBuilder
				
	    //ResponseSpecification resLogin=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	   //LoginResponse loginResponse = given().spec(req).log().all().body(LoginRequest).when().post("/api/ecom/auth/login").then().spec(resLogin).extract().response().as(LoginResponse.class);
		
		System.out.println(loginResponse.getToken());
		String token = loginResponse.getToken();        // i can store the gettoken as token to pass in add product authorization value.
		System.out.println(loginResponse.getMessage());
		System.out.println(loginResponse.getUserId());
		
		String UserId = loginResponse.getUserId();   // i can store the getUserId as Userid to pass in add product, as a Productaddedby value
		
		
		//Add Product
		
		RequestSpecification addProductBaseReq= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
			  .addHeader("Authorization", token).build();
		RequestSpecification reqAddProduct = given().log().all().spec(addProductBaseReq).param("productName","qwerty").param("productAddedBy", UserId)
		.param("productCategory", "fashion").param("productSubCategory", "shirts").param("productPrice", 11500).param("productDescription", "Addias Originals")
		.param("productFor","women").multiPart("productimage",new File("C:\\Users\\ArunkumarM\\Videos\\Captures//women.png"));  // Formdata got so we will consider them in param.	
		
		
		String addProductResponse = reqAddProduct.when().post("/api/ecom/product/add-product").then().log().all().extract().response().asString();  // Not using Pojo classes for response payload(deserialization) due to have only 2 responses such as product id and message. 
		
		JsonPath js = new JsonPath(addProductResponse);
		String productId = js.get("productId");
		
		//Create Order
		
		RequestSpecification createOrderBaseReq= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				  .addHeader("Authorization", token).build();
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setCountry("India");
		orderDetail.setProductOrderedId("productId");
		
		List<OrderDetail>orderDetailList = new ArrayList<OrderDetail>();  //Basically this List is nothing but OrdetDetail List.mainly we adding list beacus ein fututre there is n number of array comes then easy to use.
		orderDetailList.add(orderDetail);
		Orders orders = new Orders();
		orders.setOrders(orderDetailList);
		
		
		
		RequestSpecification createOrderReq= given().log().all().spec(createOrderBaseReq).body(orders);
		
		String responseAddOrder = createOrderReq.when().post("/api/ecom/order/create-order").then().log().all().extract().response().asString();
		
		System.out.println(responseAddOrder);
		
		
		//Delete Product
		
		RequestSpecification deleteProdBaseReq= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				  .addHeader("Authorization", token).build();
		RequestSpecification deleteProdReq = given().log().all().spec(deleteProdBaseReq).pathParam("productId", productId);
	     String deleteProductResponse = deleteProdReq.when().delete("/api/ecom/product/delete-product/{productId}").then().log().all().extract().response().asString();
	    
	     JsonPath js1 = new JsonPath(deleteProductResponse);  // we can do response with two different classes one is POJO adn other is Jsonpath, my suggestions is if response have one single varibale directly take it string or Jsonpath if we have more variable kinldy go thorugh POjO Classes. 
		 Assert.assertEquals("Product Deleted sucessfully",js1.get("message"));
	
	}

}
