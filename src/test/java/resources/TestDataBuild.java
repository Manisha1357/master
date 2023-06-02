package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayLoad(String name, String language, String address)
	{
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		//p.setAddress("29, Street 1");
		//p.setAddress("29, Street 1");
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("990090900");
		p.setWebsite("rahulshetty");
		//p.setName("Mani");
		p.setName(name);
		List<String> mylist = new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");		
		p.setTypes(mylist);
		Location l = new Location();
		l.setLat(-1.900);
		l.setLng(-1119);	
		p.setLocation(l);
		return p;
	}
	
	public String deletePlacePayload(String placeid)
	{
		return "{\r\n"
				+ "\"place_id\":\""+placeid+"\"\r\n"
				+ "}";
	}

}
