package dsAlgo_TestClasses;

import static org.testng.Assert.assertEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import dsAlgo_Utilities.*;
import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Login_PageFactory;

public class Login_TestClass extends BaseClass {

	public Login_PageFactory login_PF;	
	private static final Logger logger = LoggerFactory.getLogger(Login_TestClass.class);
		    
	@BeforeMethod
	public void test() {
		logger.info("User is in the Login page");
		login_PF = new Login_PageFactory();		
		login_PF.openLogin();
	}
	
	@Test(priority = 1, description = "Verify that user should land on the Login Page")
	public void Loginpage() {
		assertEquals("Login", login_PF.getTitle());
		logger.info("User is in the Sign in page");
	}
	
	@Test(priority = 2, dependsOnMethods = { "Loginpage" }, dataProviderClass = DataProviders.class, dataProvider = "loginData", retryAnalyzer = RetryAnalyzer.class)
	public void testLogin(String username, String password, String expectedResult) throws InterruptedException {
		login_PF.SetUserName(username);
		login_PF.SetPassword(password);
		login_PF.ClickBtnLogin();
		
		if (expectedResult.equals("Please fill out this field."))
		{ 
			if (username.equals(""))
			{
				Assert.assertEquals(expectedResult, login_PF.getValidationMessage(login_PF.inputUsername)); 
			}
			else
			{
				Assert.assertEquals(expectedResult, login_PF.getValidationMessage(login_PF.inputPassword));
			}			 
		 }	 
		else
		{
			Assert.assertEquals(expectedResult, login_PF.getErrMsg()); 
		}
	}
	
	@Test(priority = 3, description = "Verify that user able to sign out successfully")
	public void Logoutpage() {
		login_PF.SetUserName("bugbusters");
		login_PF.SetPassword("Team@bug");
		login_PF.ClickBtnLogin();
		login_PF.ClickSignOut();
		Assert.assertEquals("Logged out successfully", login_PF.getErrMsg());
		logger.info("User Logged out successfully");
	}    
}
