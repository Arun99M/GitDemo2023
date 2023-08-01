package files;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {
	
	public static JsonPath rawToJson(String response)  //Call raw to Json name, if we make static directly we can access from class name to method.
	{
		JsonPath  js1=new JsonPath(response);
		return js1;  
		
	}

}
