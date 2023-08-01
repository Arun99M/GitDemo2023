Feature: Validating Place API's
@AddPlace
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI    //If i put Scenario Outline instaed of Scenario it will consider the dynamic exmaples into the pictures
	Given Add place payload with "<name>"  "<language>" "<address>"
	When user calls "AddPlaceAPI" with "POST" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_id created maps to "<name>" using "getPlaceAPI"
	
	
	
Examples:  //drive the data Dynamically //multiple tests need to test then take and give other column 
	|name   | language| address          |
	|AAhouse|English  |World cross Centre|
#	|BBhouse|Spanish  |Sea   cross Centre|

@DeletePlace
Scenario: verify if Delete Place functionality is working

      Given DeletePlace Payload 
 			When user calls "deletePlaceAPI" with "POST" http request
 			Then the API call got success with status code 200
 			And "status" in response body is "OK"