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

public class LinkedList_TestClass extends BaseClass {
	LinkedList_PageFactory linkedList;

	@DataProvider(name = "stringData")
	public Object[][] stringData() {
		return new Object[][] { { "Introduction" }, { "Creating Linked List" } };
	}
	//, { "Types of Linked List" },{ "Implement Linked List in Pytho" }, { "Traversal" }, { "Insertion" }, { "Deletion" }

	private static final Logger logger = LoggerFactory.getLogger(LinkedList_PageFactory.class);
		
	@BeforeMethod(description="User Login")
	public void test() {
		logger.info("User is in the Linked List page");
		linkedList = new LinkedList_PageFactory();
		linkedList.ClickGetStBtn();
		linkedList.SignBtn();      
		linkedList.username( Driver_Factory.configReader.getUsername());
		linkedList.password(Driver_Factory.configReader.getPassword());
		linkedList.Loginbtn();
	}
	@Test(priority = 1, description = "Verify that user is able to navigate to \\\"Linked List\\\" by using start button")
	public void user_clicks_the_button_in_the_linked_list_panel_for_linked_list() {
		linkedList.clcikGetStartedLinkedListBtn();
		assertEquals("Linked List", linkedList.titleLinkedList());
		logger.info("User is in the Linked List page");
	}

	@Test(priority = 2, dataProvider = "stringData")
	public void userr_clicks_the_button_for_lists(String string) {
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
	}
	
	

}
