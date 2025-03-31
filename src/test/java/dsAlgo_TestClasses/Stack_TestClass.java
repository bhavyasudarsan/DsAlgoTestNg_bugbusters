package dsAlgo_TestClasses;


import static org.testng.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_DriverFactory.Driver_Factory;
import dsAlgo_PageFactory.LinkedList_PageFactory;
import dsAlgo_PageFactory.Stack_PageFactory;

public class Stack_TestClass extends BaseClass{
	
	Stack_PageFactory stack;
	private static final Logger logger = LoggerFactory.getLogger(Stack_PageFactory.class);
	@DataProvider(name = "stringData")
	public Object[][] stringData() {
		return new Object[][] { { "Operations in Stack" }, { "Implementation" } };
	}
	@BeforeMethod(description="User Login")
	public void test() {
		logger.info("User is in the Stack page");
		stack = new Stack_PageFactory();
		stack.ClickGetStBtn();
		stack.SignBtn();      
		stack.username( Driver_Factory.configReader.getUsername());
		stack.password(Driver_Factory.configReader.getPassword());
		stack.Loginbtn();
	}
	
	@Test(priority = 1, description = "Verify that user is able to navigate to Stack by using start button")
	public void user_clicks_the_button_in_the_stack_panel_for_stack() {
		stack.clickGetStartedStackBtn();
		assertEquals("Stack", stack.titleStack());
		logger.info("User is in the Stack  page");
	}
  
	@Test(priority = 2, dataProvider = "stringData")
	public void userr_clicks_the_button_for_lists(String string) {
		stack.clickGetStartedStackBtn();
		switch (string) {
		case "Operations in Stack":
			stack.operationLinkBtnClick();
			break;

		case "Applications":
			stack.linkApplicationClick();
			break;

		case "Implementation":
			stack.linkImplementationClick();
			break;

		
		}
	}
	
	
}
