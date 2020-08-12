package toolsqa;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredExample {

	public static void main(String[] args)
	{
		RestAssured.baseURI = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();
		response.getHeaders();
		response.getBody();
		response.getStatusCode();
		response.getStatusLine();
		
		System.out.println(response.getHeaders().toString());
		System.out.println(response.getBody().prettyPrint());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine().toString());
		
		JsonPath jsonPath = response.jsonPath();
		
		System.out.println(jsonPath.getString("cod"));
	}

}
