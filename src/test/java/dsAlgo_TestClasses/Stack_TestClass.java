package dsAlgo_TestClasses;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
//import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_DriverFactory.Driver_Factory;
import dsAlgo_PageFactory.Stack_PageFactory;
import dsAlgo_Utilities.ExcelReader;

public class Stack_TestClass extends BaseClass {

	Stack_PageFactory stack;
	int int1;
	private static final Logger logger = LoggerFactory.getLogger(Stack_PageFactory.class);

	@DataProvider(name = "stringData")
	public Object[][] stringData() {
		return new Object[][] { { "Operations in Stack" } };
//			{ "Applications" },{"Implementation"}};
	}

	@DataProvider(name = "EditorData")
	public Object[][] loginDataProvider() throws IOException {
		return ExcelReader.readExcelData("Editor");
	}

	@BeforeMethod(description = "User Login")
	public void test() {
		logger.info("User is in the Stack page");
		stack = new Stack_PageFactory();
		stack.ClickGetStBtn();
		stack.SignBtn();
		stack.username(Driver_Factory.configReader.getUsername());
		stack.password(Driver_Factory.configReader.getPassword());
		stack.Loginbtn();
	}

	@Test(priority = 1, description = "Verify that user is able to navigate to Stack by using start button")
	public void userInStackPage() {
		stack.clickGetStartedStackBtn();
		assertEquals("Stack", stack.titleStack());
		logger.info("User is in the Stack  page");
	}

	@Test(priority = 2, dataProvider = "stringData", description = "Verify that user is able to navigate to try editor page through each link")
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

		}
		stack.tryHereBtnClick();
		assertEquals(stack.runBtnText(), "Run");
		logger.info("User is in Try Editor page");
	}

	@Test(priority = 3, dataProvider = "EditorData")
	public void OutputForPythonInOperationsinStack(String inputText, String expectedOutput) {
		stack.clickGetStartedStackBtn();
		stack.operationLinkBtnClick();
		stack.tryHereBtnClick();
		stack.inputEditor(inputText);
		stack.runBtnClick();
		if (expectedOutput.contains("NameError:")) {
			Assert.assertEquals(expectedOutput, stack.alertMessage());
		} else {
			assertEquals(expectedOutput, stack.console());
			logger.info(expectedOutput);

		}
	}

	@Test(priority = 4, dataProvider = "EditorData")
	public void OutputForPythonInApplication(String inputText, String expectedOutput) {
		stack.clickGetStartedStackBtn();
		stack.linkApplicationClick();
		stack.tryHereBtnClick();
		stack.inputEditor(inputText);
		stack.runBtnClick();
		if (expectedOutput.contains("NameError:")) {
			Assert.assertEquals(expectedOutput, stack.alertMessage());
		} else {
			assertEquals(expectedOutput, stack.console());
			logger.info(expectedOutput);

		}
	}

	@Test(priority = 5, dataProvider = "EditorData")
	public void OutputForPythonInImplementation(String inputText, String expectedOutput) {
		stack.clickGetStartedStackBtn();
		stack.linkImplementationClick();
		stack.tryHereBtnClick();
		stack.inputEditor(inputText);
		stack.runBtnClick();
		String alert = stack.alertMessage();
		logger.info(alert);
		if (expectedOutput.contains("NameError:")) {
			Assert.assertEquals(expectedOutput, stack.alertMessage());
		} else {
			assertEquals(expectedOutput, stack.console());
			logger.info(expectedOutput);

		}

	}
}
