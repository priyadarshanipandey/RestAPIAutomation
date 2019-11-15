import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.restapi.executor.ExecutorEngine;
import com.restapi.response.ResponseCapture;
import com.restapi.validator.ResponseValidation;

public class RestAPIGetTest {

	@Test
	public void test() 
	{
		//Initialize executor instance
		ExecutorEngine e = new ExecutorEngine();
		//load the global properties
		e.loadproperties();
		
		ResponseCapture response = e.makeGETCall("<resource-path>");
		//Initialize validator instance to work on response data
		ResponseValidation validate = new ResponseValidation();
		//Call validation methods as per the requirements of test
		Assert.assertTrue(validate.validateResponseCode(200, response.getResponseCode()));
		Assert.assertTrue(validate.validateResponseBody(response, "<resource-name>"));
	}

}
