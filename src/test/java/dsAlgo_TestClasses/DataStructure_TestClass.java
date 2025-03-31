package dsAlgo_TestClasses;

import org.testng.annotations.Test;
import dsAlgo_BaseClass.BaseClass;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import dsAlgo_PageFactory.DataStructure_PageFactory;
import dsAlgo_TestClasses.DataStructure_TestClass;

public class DataStructure_TestClass extends BaseClass {
	
	private static final Logger logger = LoggerFactory.getLogger(DataStructure_TestClass.class);
	DataStructure_PageFactory dataStructure_PF;
	
	@DataProvider (name = "tryEditor_dataProvider")
	public Object[][] tryEditor_dataProvider(){
		
		return new Object[][] {{1},{2},{3}};
	}
	
	@BeforeMethod
	public void test() throws IOException {
		
		dataStructure_PF = new DataStructure_PageFactory();
		dataStructure_PF.ClickGetStBtn();
		dataStructure_PF.SignBtn();
	//	dataStructure_PF.Login("Login");
		dataStructure_PF.enterCredentials("bugbusters","Team@bug");
		dataStructure_PF.Loginbtn();
		dataStructure_PF.data_structureGetSatrted();
	}
	
	@Test(priority = 1, description = "Verify that user should land on the Time Complexity Page")
	public void timeCompexityPage() {
		
		dataStructure_PF.timeComplexity();
		assertEquals("Time Complexity", dataStructure_PF.getTitle());
		logger.info("User is in the Time Complexity page");
	}
	
	@Test(priority = 2, description = "Verify that user should land on the Practice Questions Page")
	public void practiceQuestionsPage() {
		
		dataStructure_PF.timeComplexity();
		dataStructure_PF.practiceQuestion();
		assertEquals("Practice Questions", dataStructure_PF.getTitle());
		logger.info("User is in the Practice Questions page");
	}
	
	@Test(priority = 3, description = "Verify that user should land on the Try Editor Page")
	public void tryEditorPage() {
		
		dataStructure_PF.timeComplexity();
		dataStructure_PF.timeComplexityTryhere();
		assertEquals("Assessment", dataStructure_PF.getTitle());
		logger.info("User is in the Practice Questions page");
	}
	
	@Test(priority = 4, dataProvider = "tryEditor_dataProvider")
	public void tryEditorRunButtonClick(int number) {
		
		String inputText;
		dataStructure_PF.timeComplexity();
		dataStructure_PF.timeComplexityTryhere();
		
		switch (number) {
		
		case 1:
		
			inputText = "Hiiii";
			dataStructure_PF.inputEditor(inputText);
			dataStructure_PF.runBtnClick();
			String alertMsg= dataStructure_PF.alertMessage();
			assertEquals("NameError: name 'Hiiii' is not defined on line 1", alertMsg);
			
			break;

		case 2:
			
			inputText = " ";
			dataStructure_PF.inputEditor(inputText);
			dataStructure_PF.runBtnClick();
			logger.info("No Output displayed");
			break;
			
		case 3:
			
			inputText = "print('Hello')";
			dataStructure_PF.inputEditor(inputText);
			dataStructure_PF.runBtnClick();
			String output = dataStructure_PF.console();
			assertEquals("Hello", output);
			
		}
	}
}
