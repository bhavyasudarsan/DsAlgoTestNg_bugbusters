package dsAlgo_TestClasses;

import org.testng.annotations.Test;
import dsAlgo_BaseClass.BaseClass;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import dsAlgo_PageFactory.DataStructure_PageFactory;
import dsAlgo_TestClasses.DataStructure_TestClass;
import dsAlgo_Utilities.*;

public class DataStructure_TestClass extends BaseClass {
	
	private static final Logger logger = LoggerFactory.getLogger(DataStructure_TestClass.class);
	DataStructure_PageFactory dataStructure_PF;
	
	@BeforeMethod
	public void test() throws IOException {
		
		dataStructure_PF = new DataStructure_PageFactory();
		dataStructure_PF.ClickGetStBtn();
		dataStructure_PF.SignBtn();
		validLogin();
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
	
	@Test(priority = 4, dataProvider = "EditorData", dataProviderClass = DataProviders.class, retryAnalyzer = RetryAnalyzer.class)
	public void tryEditorRunButtonClick(String inputText,String expectedResult) throws IOException {
		
		dataStructure_PF.timeComplexity(); 
		dataStructure_PF.timeComplexityTryhere();
		dataStructure_PF.inputEditor(inputText);
		dataStructure_PF.runBtnClick();
		
		if (expectedResult.contains("NameError"))
		{
			String alertMsg = dataStructure_PF.alertMessage();
			Assert.assertTrue(alertMsg.contains("NameError:"));	
			logger.info(alertMsg);
		}
		else
		{
			Assert.assertEquals(expectedResult, dataStructure_PF.console());
			logger.info(expectedResult);
		}	
		logger.info(expectedResult);
	}
}
