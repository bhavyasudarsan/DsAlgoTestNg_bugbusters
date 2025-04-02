package dsAlgo_TestClasses;

import org.testng.annotations.Test;
import dsAlgo_BaseClass.BaseClass;
import dsAlgo_DriverFactory.Driver_Factory;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import dsAlgo_PageFactory.DataStructure_PageFactory;
import dsAlgo_TestClasses.DataStructure_TestClass;
import dsAlgo_Utilities.ExcelReader;

public class DataStructure_TestClass extends BaseClass {
	
	private static final Logger logger = LoggerFactory.getLogger(DataStructure_TestClass.class);
	DataStructure_PageFactory dataStructure_PF;
	String expectedResult;
	String inputText;
	
	@DataProvider (name = "tryEditor_dataProvider")
	public Object[][] tryEditor_dataProvider(){
		
		return new Object[][] {{"Editor",2},{"Editor",1},{"Editor",3}};
	}
	
	@BeforeMethod
	public void test() throws IOException {
		
		dataStructure_PF = new DataStructure_PageFactory();
		dataStructure_PF.ClickGetStBtn();
		dataStructure_PF.SignBtn();
		dataStructure_PF.enterCredentials(Driver_Factory.configReader.getUsername(), Driver_Factory.configReader.getPassword());
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
	public void tryEditorRunButtonClick(String sheetName , int Rowno) throws IOException {
		
		dataStructure_PF.timeComplexity(); 
		dataStructure_PF.timeComplexityTryhere();
		
		List<Object[]> registerData = ExcelReader.readExcelData(sheetName);
		
	     if (Rowno <= registerData.size()) 
	     {
	    	    Object[] row = registerData.get(Rowno-1); 
	    	    inputText = (String) row[0];
	    	    expectedResult = (String) row[1];  
	    	    dataStructure_PF.inputEditor(inputText);
	    	    dataStructure_PF.runBtnClick();
	     } 
	    
	     if (expectedResult.equals("Hello")) {
	    	 
	    	 Assert.assertEquals(expectedResult,dataStructure_PF.console());	
	     }
	     else {
	    	 
	    	 Assert.assertEquals(expectedResult,dataStructure_PF.alertMessage());	
	     }
	  
		logger.info(expectedResult);
		
		
	}
}
