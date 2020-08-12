
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FirstRestAssuredExample 
{
	
	public void getResponseBody()
	{
		//Using query parameter, print only body
				given()
				.queryParam("CUSTOMER_ID", "68195")
				.queryParam("PASSWORD", "1234!")
				.queryParam("Account_No", "1")
				.when()
				.get("http://demo.guru99.com/V4/sinkministatement.php")
				.then()
				.log().body();
				
	}
	
	public void getResponseHeader()
	{
		//Using only get method to print the headers using extract method.
				System.out.println(get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1")
				.then().extract().headers());
		
	}

	public int getResponseStatusCode()
	{
		int statusCode = get("http://demo.guru99.com/V4/sinkministatement.php")
		.getStatusCode();
		
		return statusCode;
	}
	
	public long getResponseTime()
	{
		long responseTime = get("http://demo.guru99.com/V4/sinkministatement.php").getTime();
		System.out.println("Response Time: " + responseTime);
		System.out.println("Response Time: " + get("http://demo.guru99.com/V4/sinkministatement.php").timeIn(TimeUnit.MILLISECONDS) + " Milliseconds");
				
		return responseTime;
	}
	
	public String getContentType()
	{
		String contentType = given()
		.when()
		.get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1")
		.getContentType();
		System.out.println("Content Type: " + contentType);
		return contentType;
	}
	
	public String getSessionId()
	{
		String sessionId = given()
		.when()
		.get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1")
		.getSessionId();
		System.out.println("Session ID: " + sessionId);
		return sessionId;
	}
	
	public void getResponseAll()
	{
		//log all
				given()
				.when()
				.get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1")
				.then().log().all();
	}
	
	public void verifyResponseStatusCode(int expectedStatusCode)
	{
		//Using query parameter & assert status code
				given()
				.queryParam("CUSTOMER_ID", "68195")
				.queryParam("PASSWORD", "1234!")
				.queryParam("Account_No", "1")
				.when()
				.get("http://demo.guru99.com/V4/sinkministatement.php")
				.then()
				.assertThat().statusCode(expectedStatusCode);
	}
	
	public void getSpecificPathOfResponseBody()
	{
		/*
		 * String amounts;
		 * 
		 * int sum = 0;
		 * 
		 * for(String amount : amounts) { sum = sum + Integer.valueOf(amount);
		 * System.out.println("Amount is " + amount);
		 * 
		 * } System.out.println("Sum of Amount is " + sum);
		 */
	}
	
	public static void main(String[] args) 
	{
		
		FirstRestAssuredExample ra = new FirstRestAssuredExample();
		ra.getResponseAll();
		ra.getResponseBody();
		ra.getResponseHeader();
		System.out.println(ra.getResponseStatusCode());
		ra.verifyResponseStatusCode(200);
		ra.getContentType();
		ra.getResponseTime();
		ra.getSessionId();
		ra.getSpecificPathOfResponseBody();
		
	}

}
