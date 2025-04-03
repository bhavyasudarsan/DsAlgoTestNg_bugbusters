package dsAlgo_TestClasses;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Register_PageFactory;
import dsAlgo_Utilities.*;

public class Register_TestClass extends BaseClass {
	
	private static final Logger logger = LoggerFactory.getLogger(DataStructure_TestClass.class);
	Register_PageFactory register_PF;
	
	@DataProvider(name = "RegisterData")
    public Object[][] registerDataProvider() throws IOException {
		
        return ExcelReader.readExcelData("Register");
    }
	
	@BeforeMethod
	public void test() throws IOException {
		
		register_PF = new Register_PageFactory();
		register_PF.getStart();
		register_PF.registerlink();
		logger.info("You are on the registration page");
	}
	
	@Test(priority = 1, dataProvider = "RegisterData")
	public void dsAlgo_registration(String username, String password1, String password2, String expectedResult) throws IOException, InterruptedException {
		
	    
		register_PF.enterCredentials(username, password1, password2);
		register_PF.clickRegister();
		 
	    if (expectedResult.equals("Please fill in this field.")) {
	    	
	    	 if (username.equals(""))
			 {
				 Assert.assertEquals(expectedResult, register_PF.getValidationMessage());
				 System.out.println("No Username \n");
				 logger.info(expectedResult);
			 }
			 else if (password1.equals(""))
			 {
				 Assert.assertEquals(expectedResult, register_PF.getValidationMessagePwd());
				 System.out.println("No P1 \n");
				 logger.info(expectedResult);
			 }	
			 else if (password2.equals(""))
			 {
				 Assert.assertEquals(expectedResult, register_PF.getValidationMessagePwd2());
				 System.out.println("No P2 \n");
				 logger.info(expectedResult);
			 }
	    }
	    else
		 {
			 Assert.assertEquals(expectedResult,register_PF.alertMessage());		
			 logger.info(expectedResult);
		 }
	    
	    if(expectedResult.contains("New Account created")) {
	    	
	    	Assert.assertEquals(register_PF.getTitle(), "NumpyNinja");
			logger.info("You are on the NumpyNinja page");
	    }
	   
		 
	}
}
