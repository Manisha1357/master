package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		//execute this when place_id is null
		StepDefination m = new StepDefination();
		if(StepDefination.place_id==null)
		{
		m.add_place_payload_with("manisha", "english", "address");
		m.user_calls_with_post_http_request("AddPlaceAPI", "POST");
		m.verify_place_id_created_maps_to_using("manisha", "getPlaceAPI");
		}
	}

}
