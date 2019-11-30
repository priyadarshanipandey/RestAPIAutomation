package com.restapi.validator;

import org.json.JSONObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import com.restapi.response.ResponseCapture;


/*Class to perform all types of data validations from the REST API response*/

public class ResponseValidation {
	
	//Validation of response code
	public boolean validateResponseCode(int expectedCode, int actualCode)
	{
		if(expectedCode == actualCode)
		{
			return true;
		}
		return false;
	}
	
	//Validation of response body
	public boolean validateResponseBody(ResponseCapture response,String expectedCharSeq)
	{
		if(response.getResponseBody().contains(expectedCharSeq))
		{
			System.out.println("Expected data exists in the response body -> " + expectedCharSeq);
			return true;
		}
		return false;
	}
	
	//validation of response json
	public boolean validateJSONResponse(ResponseCapture responseCapture,String nodeName,String expectedValue)
	{
		
		Response response = responseCapture.getResponseObject();
		JsonPath path = response.jsonPath();
		if(path!=null)
		{
			String value = path.get(nodeName);
			if(value.equalsIgnoreCase(expectedValue))
			{
				System.out.println(nodeName + " value is correct ->" + value);
				return true;
			}
		}
		
		return false;
	}

}
