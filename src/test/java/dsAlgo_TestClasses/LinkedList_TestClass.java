package dsAlgo_TestClasses;

import static org.testng.Assert.assertEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
//import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.LinkedList_PageFactory;
import dsAlgo_Utilities.DataProviders;

public class LinkedList_TestClass extends BaseClass {

	LinkedList_PageFactory linkedList;
	private static final Logger logger = LoggerFactory.getLogger(LinkedList_PageFactory.class);

	@BeforeMethod(description = "User Login")
	public void test() {
		logger.info("User is in the Linked List page");
		linkedList = new LinkedList_PageFactory();
		linkedList.ClickGetStBtn();
		validLogin();
	}

	@Test(priority = 1, description = "Verify that user is able to navigate to 'Linked List' by using start button")
	public void user_clicks_the_button_in_the_linked_list_panel_for_linked_list() {
		linkedList.clcikGetStartedLinkedListBtn();
		assertEquals("Linked List", linkedList.titleLinkedList());
		logger.info("User is in the Linked List page");
	}

	@Test(priority = 1, dataProviderClass = DataProviders.class, dataProvider = "linkedListData", description = "Verify that user is able to navigate to try editor page through each link")
	public void tryEditorPge(String string) {
		linkedList.clcikGetStartedLinkedListBtn();
		switch (string) {
		case "Introduction":
			linkedList.clickIntrodcution();
			break;

		case "Creating Linked List":
			linkedList.creatingLinkedListClick();
			break;

		case "Types of Linked List":
			linkedList.typeOfLinkListinkClick();
			break;

		case "Implement Linked List in Python":
			linkedList.implimentLinkedListClick();
			break;

		case "Traversal":
			linkedList.traversalClick();
			break;

		case "Insertion":
			linkedList.insertionClick();

			break;

		case "Deletion":
			linkedList.deletionClick();
		}
		linkedList.tryHereBtnClick();
		linkedList.runBtnText();
		assertEquals(linkedList.runBtnText(), "Run");
		logger.info("User in Try editor page");

	}

	@Test(priority = 2, dataProviderClass = DataProviders.class, dataProvider = "EditorData", dependsOnMethods = {
			"tryEditorPge" }, description = "Verify that user is able to chech python code in try editor page through 'Introdcution' link")
	public void OutputForPythonInCreatingLinkedListPage(String inputText, String expectedOutput) {
		linkedList.clcikGetStartedLinkedListBtn();
		linkedList.clickIntrodcution();
		linkedList.tryHereBtnClick();
		linkedList.inputEditor(inputText);
		linkedList.runBtnClick();
		if (expectedOutput.contains("NameError:")) {
			Assert.assertEquals(expectedOutput, linkedList.alertMessage());
		} else {
			assertEquals(expectedOutput, linkedList.console());
			logger.info(expectedOutput);

		}
	}

	@Test(priority = 3, dataProviderClass = DataProviders.class, dataProvider = "EditorData", dependsOnMethods = {
			"tryEditorPge" }, description = "Verify user able to check python code in try editor page through CreatingLinkedList link")
	public void OutputForPythonInIntroductionPage(String inputText, String expectedOutput) {
//		throw new SkipException("This test case is skipped");
		linkedList.clcikGetStartedLinkedListBtn();
		linkedList.creatingLinkedListClick();
		linkedList.tryHereBtnClick();
		linkedList.inputEditor(inputText);
		linkedList.runBtnClick();
		if (expectedOutput.contains("NameError:")) {
			Assert.assertEquals(expectedOutput, linkedList.alertMessage());
		} else {
			assertEquals(expectedOutput, linkedList.console());
			logger.info(expectedOutput);

		}
	}

	@Test(priority = 4, dataProviderClass = DataProviders.class, dataProvider = "EditorData", dependsOnMethods = {
			"tryEditorPge" }, description = "Verify user able to check python code in try editor page through 'TypesofLinkedListPage' link")
	public void OutputForPythonInITypesofLinkedListPage(String inputText, String expectedOutput) {
		linkedList.clcikGetStartedLinkedListBtn();
		linkedList.typeOfLinkListinkClick();
		linkedList.tryHereBtnClick();
		linkedList.inputEditor(inputText);
		linkedList.runBtnClick();
		if (expectedOutput.contains("NameError:")) {
			Assert.assertEquals(expectedOutput, linkedList.alertMessage());
		} else {
			assertEquals(expectedOutput, linkedList.console());
			logger.info(expectedOutput);

		}
	}

	@Test(priority = 5, dataProviderClass = DataProviders.class, dataProvider = "EditorData", dependsOnMethods = {
			"tryEditorPge" }, description = "Verify user  able to chech python code in try editor page through 'ImplementLnkedListinPython' link")
	public void OutputForPythonInImplementLnkedListinPythonPage(String inputText, String expectedOutput) {
		linkedList.clcikGetStartedLinkedListBtn();
		linkedList.implimentLinkedListClick();
		linkedList.tryHereBtnClick();
		linkedList.inputEditor(inputText);
		linkedList.runBtnClick();
		if (expectedOutput.contains("NameError:")) {
			Assert.assertEquals(expectedOutput, linkedList.alertMessage());
		} else {
			assertEquals(expectedOutput, linkedList.console());
			logger.info(expectedOutput);

		}
	}

	@Test(priority = 6, dataProviderClass = DataProviders.class, dataProvider = "EditorData", dependsOnMethods = {
			"tryEditorPge" }, description = "Verify user is able to chech python code in try editor page through 'Traversal' link")
	public void OutputForPythonInTraversalPage(String inputText, String expectedOutput) {
		linkedList.clcikGetStartedLinkedListBtn();
		linkedList.traversalClick();
		linkedList.tryHereBtnClick();
		linkedList.inputEditor(inputText);
		linkedList.runBtnClick();
		if (expectedOutput.contains("NameError:")) {
			Assert.assertEquals(expectedOutput, linkedList.alertMessage());
		} else {
			assertEquals(expectedOutput, linkedList.console());
			logger.info(expectedOutput);

		}
	}

	@Test(priority = 7, dataProviderClass = DataProviders.class, dataProvider = "EditorData", dependsOnMethods = {
			"tryEditorPge" }, description = "Verify  user able to chech python code in try editor page through 'Insertion' link")
	public void OutputForPythonInInsertionPage(String inputText, String expectedOutput) {
		linkedList.clcikGetStartedLinkedListBtn();
		linkedList.insertionClick();
		linkedList.tryHereBtnClick();
		linkedList.inputEditor(inputText);
		linkedList.runBtnClick();
		if (expectedOutput.contains("NameError:")) {
			Assert.assertEquals(expectedOutput, linkedList.alertMessage());
		} else {
			assertEquals(expectedOutput, linkedList.console());
			logger.info(expectedOutput);

		}
	}

	@Test(priority = 8, dataProvider = "EditorData", dependsOnMethods = {
			"tryEditorPge" }, description = "Verify that user is able to chech python code in try editor page through 'Deletion' link")
	public void OutputForPythonInDeletionPage(String inputText, String expectedOutput) {
		linkedList.clcikGetStartedLinkedListBtn();
		linkedList.deletionClick();
		linkedList.tryHereBtnClick();
		linkedList.inputEditor(inputText);
		linkedList.runBtnClick();
		if (expectedOutput.contains("NameError:")) {
			Assert.assertEquals(expectedOutput, linkedList.alertMessage());
		} else {
			assertEquals(expectedOutput, linkedList.console());
			logger.info(expectedOutput);

		}
	}

}