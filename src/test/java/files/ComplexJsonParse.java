package files;

import files.payload;


import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	
	public static void main(String[]args) {
	
	
	JsonPath js = new JsonPath(payload.CoursePrice());
	//Print No of Courses returned by API
	
int count =js.getInt("courses.size()");     // courses.size is mentioned to verify the numbr of courses written in API.
System.out.println(count);

//Print purchase Amount
int totalAmount=js.getInt("dashboard.purchaseAmount");
System.out.println(totalAmount);

//Print title of the first course

String firstcourses=js.get("courses[0].title");
System.out.println(firstcourses);

//print all courses titles and their respective prices

for (int i=0;i<count;i++)
{
	String courseTitles=js.get("courses["+i+"].title");
	System.out.println(js.get("courses["+i+"].price").toString());  //without assigning variable directly we can print using System.out.println and add last .toString and automatically convert everything into string
	System.out.println(courseTitles);
	
}
 System.out.println("Print no of copies sold by RPA Course");
 for (int i=0;i<count;i++)
 {
 	String courseTitles=js.get("courses["+i+"].title");
 	if (courseTitles.equalsIgnoreCase("RPA"))
 	{
 		int copies=js.get("courses["+i+"].copies");
 		System.out.println(copies);
 		break;
 	}
 }
 }

}
