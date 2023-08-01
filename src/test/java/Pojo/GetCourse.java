package Pojo;



public class GetCourse {
	
	// Parsing data from Complex nested Json using POjo classes, the respose is applied in Json editor tool

	
	private String url;                //All variables should be considers in private. string is mentioned nothing ut all the values in string
	private String services;
	private String expertise;          // Short cut to get all the getters and setters is mark all the private and give ALT + SHIFT + S and it will automatically rewrites.
	private Courses Courses;   // return type of this course is String,return type is the class(Courses)
	private String instructor;
	private String linkedin;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public Pojo.Courses getCourses() {     // keep the cursor over Courses it will show change type of "Courses" to "string" click that 
		return Courses;
	}
	public void setCourses(Pojo.Courses courses) {  // keep the cursor over courses it will show change type of 'courses' to 'courses' click that
		Courses = courses;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	
	
		
}


