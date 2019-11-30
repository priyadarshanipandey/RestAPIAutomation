package com.restapi.executor;

import java.io.FileInputStream;
import java.util.Properties;

import org.json.JSONObject;

import com.restapi.response.ResponseCapture;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*Class the execute the REST requests made in the tests*/

public class ExecutorEngine {
	
	
	public Properties props = null;
	ResponseCapture response = null;
	
	//Load the properties file
	public void loadproperties()
	{
		try 
		{
			FileInputStream input = new FileInputStream("src/main/resources/config.properties");
			props = new Properties();
			props.load(input);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//Call to GET  method
	public ResponseCapture makeGETCall(String pathQuery)
	{
		RestAssured.baseURI = props.getProperty("baseURI");
		RequestSpecification request  = RestAssured.given();
		response = new ResponseCapture (request.get("/"+pathQuery));
		return response;
	}
	
	//Call to POST method
	public ResponseCapture makePOSTCall(String JSON, String pathQuery, String header)
	{
		RestAssured.baseURI = props.getProperty("baseURI");
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type",header);
		JSONObject requestParams = prepareJSONRequest(JSON);
		request.body(requestParams.toString());
		response = new ResponseCapture (request.post(pathQuery));
		return response;
	}
	
	//Method to prepare JSON request passed in request body
	public JSONObject prepareJSONRequest(String paramString)
	{
		JSONObject requestParams = new JSONObject();
		String[] pairs = paramString.split(",");
		
		for(int i=0;i<pairs.length; i++)
		{
			String[] keyValues = pairs[i].split(":");
			requestParams.put(keyValues[0], keyValues[1]);
		}
		return requestParams;
	}

}
