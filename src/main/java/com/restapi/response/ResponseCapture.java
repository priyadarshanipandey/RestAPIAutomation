package com.restapi.response;

import io.restassured.http.Headers;
import io.restassured.response.Response;

/*Class to hold the respons data obtained fromt he REST API calls*/

public class ResponseCapture {
	
	public int responseCode;
	public String responseBody;
	public Headers headers;
	public String sessionID;
	public String statusLine;
	public Response response;
	
	public ResponseCapture (Response response) 
	{ 
	  responseCode = response.getStatusCode(); 
	  responseBody = response.body().asString(); 
	  headers = response.getHeaders(); 
	  sessionID = response.getSessionId(); 
	  statusLine = response.getStatusLine(); 
	  this.response = response;
	}
	 

	public int getResponseCode() {
		return responseCode;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public Headers getHeaders() {
		return headers;
	}

	public String getSessionID() {
		return sessionID;
	}

	public String getStatusLine() {
		return statusLine;
	}
	
	public Response getResponseObject()
	{
		return response;
	}
	

}
