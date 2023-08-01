package Pojo;

import java.util.List;

public class Courses {
	
	// due to complex nested Json courses inside have 3 sub Json for that creating a new class and updating.
	
	private List<WebAutomation> webAutomation;   // replacing the String return type with nested inside nested WebAutomation and also adding list
	private List<Api> api;    // In array there is a list of items then we need to consider as LIST
	private List<Mobile> mobile;
	
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;          //keep the cursor over Courses it will show change type of "WebAutomation" click that
	}
	public void setWebAutomation(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;  // keep the cursor over Courses it will show change type of "WebAutomation to WebAutomation" click that
	}
	public List<Api> getApi() {
		return api;  //keep the cursor over Courses it will show change method return type to "api" 
	}
	public void setApi(List<Api> api) {
		this.api = api;   //keep the cursor over Courses it will show change type to "api" to "api"
	}
	public List<Mobile> getMobile() {
		return mobile;     //keep the cursor over Courses it will show change method return type to "mobile"
	}
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;    //keep the cursor over Courses it will show change type to mobile to mobile
	}
	

}
