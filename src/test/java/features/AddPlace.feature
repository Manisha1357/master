Feature: Validating Place API's
@AddPlace
Scenario Outline: Add Place API

Given Add place Payload with "<name>" "<language>" "<address>"
When user calls "AddPlaceAPI" with "Post" http request
Then API call got success and status code is 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And Verify place_id created maps to "<name>" using "getPlaceAPI"

Examples:
  |name    |language   |address  |
  |Aa house|English    |Centre   |
# |bb house|English    |Hyderabad|
# |CC House|Spanish    |Spain    |
@DeletePlace 
Scenario: Verify if Delete place functionality is working 

Given delete place API payload 
When user calls "deletePlaceAPI" with "Post" http request
Then API call got success and status code is 200
And "status" in response body is "OK"

