package resources;

import io.restassured.RestAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class Utils {
	public static RequestSpecification req;
	
	public RequestSpecification requestSpecification() throws IOException
	{
		if(req ==null)
		{
		
		PrintStream stream = new PrintStream(new FileOutputStream("logging.txt"));
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		 req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
				 .addFilter(RequestLoggingFilter.logRequestTo(stream))
				 .addFilter(ResponseLoggingFilter.logResponseTo(stream))
		.setContentType(ContentType.JSON).build();
		 return req;
		}
		return req;
	}
	
	public static String getGlobalValue(String key) throws IOException
	{
		Properties prop =new Properties();
		FileInputStream fip = new FileInputStream("C:\\Users\\manisha.pallerla\\eclipse-workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fip);
		return prop.getProperty(key);
	}
	
	public String getJsonPath(Response response, String key)
	{
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		System.out.println("Key is"+ js.get(key));
		return js.get(key);
		
		 
	}

}
