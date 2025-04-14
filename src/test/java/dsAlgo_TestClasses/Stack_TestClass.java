package dsAlgo_TestClasses;

import static org.testng.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Stack_PageFactory;
import dsAlgo_Utilities.DataProviders;
import dsAlgo_Utilities.RetryAnalyzer;

public class Stack_TestClass extends BaseClass {

	Stack_PageFactory stack;
	int int1;
	private static final Logger logger = LoggerFactory.getLogger(Stack_PageFactory.class);

	@BeforeMethod(description = "User Login")
	public void test() {
		stack = new Stack_PageFactory();
		stack.ClickGetStBtn();
		validLogin();
		logger.info("User is in the Stack page");
	}
	@Test(priority = 1, description = "Verify that user is able to navigate to Stack by using start button")
	public void userInStackPage() {
		stack.clickGetStartedStackBtn();
		assertEquals("Stack", stack.titleStack());
		logger.info("User is in the Stack  page");
	}

	@Test(priority = 2, dataProviderClass = DataProviders.class,dataProvider = "stackData", retryAnalyzer = RetryAnalyzer.class, description = "Verify that user is able to navigate to try editor page through each link")
	public void userInRespectiveLinkPage(String string) {
		
		stack.clickGetStartedStackBtn();
		switch (string) {
		case "Operations in Stack":
			stack.operationLinkBtnClick();
			stack.stackPageIdentify();
			assertEquals(stack.stackPageIdentify(), "Operations in Stack");
			logger.info("User is in Operations in Stack page");
			break;

		case "Applications":
			stack.linkApplicationClick();
			stack.applicationPageIdentify();
			assertEquals(stack.applicationPageIdentify(), "Applications");
			logger.info("User is in Applications page");
			break;

		case "Implementation":
			stack.linkImplementationClick();
			stack.implementationPageIdentify();
			assertEquals(stack.implementationPageIdentify(), "Implementation");
			logger.info("User is in Implementation page");
			break;

		
	case "Practice Questions":
		stack.linkPracticeQstnClick();
		stack.linkPracticeQstnPageIdentify();

		assertEquals(stack.linkPracticeQstnPageIdentify(), " Practice Questions ");
		logger.info("User is in  Practice Questions  page");
		break;
		
		}
		stack.tryHereBtnClick();
		assertEquals(stack.runBtnText(), "Run");
		logger.info("User is in Try Editor page");
		stack.runBtnClick();

	}
	
	

	@Test(priority = 3,dataProviderClass = DataProviders.class,dataProvider = "EditorData",retryAnalyzer = RetryAnalyzer.class)
	public void OutputForPythonInOperationsinStack(String inputText, String expectedOutput) {
		stack.clickGetStartedStackBtn();
		stack.operationLinkBtnClick();
		stack.tryHereBtnClick();
		stack.inputEditor(inputText);
		stack.runBtnClick();
		if (expectedOutput.contains("NameError:")) {
			assertEquals(expectedOutput, stack.alertMessage());
		} else {
			assertEquals(expectedOutput, stack.console());
			logger.info(expectedOutput);

		}
	}

	@Test(priority = 4, dataProviderClass = DataProviders.class,dataProvider = "EditorData",retryAnalyzer = RetryAnalyzer.class)
	public void OutputForPythonInApplication(String inputText, String expectedOutput) {
		stack.clickGetStartedStackBtn();
		stack.linkApplicationClick();
		stack.tryHereBtnClick();
		stack.inputEditor(inputText);
		stack.runBtnClick();
		if (expectedOutput.contains("NameError:")) {
			assertEquals(expectedOutput, stack.alertMessage());
		} else {
			assertEquals(expectedOutput, stack.console());
			logger.info(expectedOutput);

		}
	}

	@Test(priority = 5,dataProviderClass = DataProviders.class, dataProvider = "EditorData",retryAnalyzer = RetryAnalyzer.class)
	public void OutputForPythonInImplementation(String inputText, String expectedOutput) {
		stack.clickGetStartedStackBtn();
		stack.linkImplementationClick();
		stack.tryHereBtnClick();
		stack.inputEditor(inputText);
		stack.runBtnClick();
		String alert = stack.alertMessage();
		logger.info(alert);
		if (expectedOutput.contains("NameError:")) {
			assertEquals(expectedOutput, stack.alertMessage());
		} else {
			assertEquals(expectedOutput, stack.console());
			logger.info(expectedOutput);

		}

	}
}
