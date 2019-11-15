import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.restapi.executor.ExecutorEngine;
import com.restapi.response.ResponseCapture;
import com.restapi.validator.ResponseValidation;

public class RestAPIPostTest {

	@Test
	public void test() 
	{
		//Initialize executor instance
		ExecutorEngine executor = new ExecutorEngine();
		//load the global properties
		executor.loadproperties();
		//Initialize validator instance to work on response data
		ResponseValidation validate = new ResponseValidation();
		//Add the json body key  value pairs in format key:value
		ResponseCapture response = executor.makePOSTCall("<json-body-key-value-pairs>", "<resource-path>", "application/json");
		//Call validation methods as per the requirements of test
		Assert.assertTrue(validate.validateResponseCode(200, response.getResponseCode()));
	}

}
