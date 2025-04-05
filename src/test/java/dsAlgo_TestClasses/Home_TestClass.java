package dsAlgo_TestClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Home_PageFactory;
import dsAlgo_Utilities.ConfigReader;

public class Home_TestClass  extends BaseClass{
	private static final Logger logger = LoggerFactory.getLogger(Home_PageFactory.class);
	ConfigReader configReader = new ConfigReader();
	
	Home_PageFactory homePage;
	@DataProvider(name = "stringData")
	public Object[][] stringData() {
		return new Object[][] { { "Arrays" }, { "Linked List" }, {"Stack"},{"Queue"},{"Graph"},{"Tree"} };
	}

	@BeforeMethod
	public void userInDsAlgoPortal() {
		homePage=  new Home_PageFactory();
		configReader.getUrl();
		Assert.assertEquals("Get Started",homePage.clickStBtnString() );
		logger.info("User is in DsAlgo portal");
		
	}
	@Test(priority = 1, description = "Verify the Home page for a user without Sign in")
	public void userAtHomePage() {
		homePage.clickStBtn();
		Assert.assertEquals("Register",homePage.registerBtn() );
		Assert.assertEquals("Sign in",homePage.signInBtn() );
		logger.info("User is at the Data Structure Introduction Page");
	
	}
	
	@Test(priority = 2, description = "Verify that user is able to view options for 'Data Structures' dropdown on home page without Sign in")
	public void verifyDropDown() {
		homePage.clickStBtn();
		homePage.dropDownClick();
			Assert.assertEquals(6,homePage.getDropdownOptionsCount() );
		logger.info("User able to see options at dropdown");
	
	}
	@Test(priority = 2, dataProvider= "stringData",description = "Verify that user able to see warning message while selecting Strings from the drop down without Sign in")
	public void verifyWarningFromDropdown( String daraStructures) {
		homePage.clickStBtn();
		homePage.dropDownClick();
		switch (daraStructures) {
		case "Arrays":
			homePage.arrayClick();
			break;
		case "Linked List":
			homePage.linkedListClick();
			break;

		case "Stack":
			homePage.stackClick();
			break;
		case "Queue":
			homePage.queueClick();
			break;
		case "Graph":
			homePage.graphClick();
			break;
		case "Tree":
			homePage.treeClick();
			break;
		default:
			break;
		}
Assert.assertEquals("You are not logged in",homePage.messageDisplayed());
logger.info("Warning Message appears: " + "You are not logged in");
	
	}
	@Test(priority = 4, dataProvider= "stringData",description = "Verify user able to see warning message while clicking 'Get Started' buttons of 'Data Structures-panel' without Sign in")

	public void WarningByClikingGetStartedBtn( String daraStructureType) {
		homePage.clickStBtn();
		switch (daraStructureType) {
		case "Array":
			homePage.clickArrayBtn();
			break;
		case "Data Structures-Introduction":
			homePage.clickDataStructureBtn();
			break;
		case "Stack":
			homePage.clickStackBtn();
			break;
		case "Queue":
			homePage.clickQueueBtn();
			break;
		case "Tree":
			homePage.clickTreeBtn();
			break;
		case "Linked List":
			homePage.clickGraphBtn();
			break;
		default:
			break;
		}

Assert.assertEquals("You are not logged in",homePage.messageDisplayed());
logger.info("Warning Message appears: " + "You are not logged in");
	
	}

}
