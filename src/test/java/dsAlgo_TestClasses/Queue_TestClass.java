package dsAlgo_TestClasses;

import static org.testng.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Queue_PageFactory;
import dsAlgo_Utilities.*;

public class Queue_TestClass extends BaseClass {
	Queue_PageFactory queue_PF;

	private static final Logger logger = LoggerFactory.getLogger(Queue_PageFactory.class);
		
	@BeforeMethod
	public void test() {
		logger.info("User is in the signin page");
		queue_PF = new Queue_PageFactory();
		queue_PF.openLogin();
		queue_PF.SetUserName("bugbusters");
		queue_PF.SetPassword("Team@bug");
		queue_PF.ClickBtnLogin();
	}

	@Test(priority = 1, description = " Verify that user is able to navigate to Queue page")
	public void getTitle() {
		queue_PF.ClickQueue();
		assertEquals("Queue", queue_PF.getTitle());
		logger.info("User is in the Queue page");
	}

	@Test(priority = 2, dependsOnMethods = { "getTitle" }, dataProviderClass = DataProviders.class, dataProvider = "QueueData", retryAnalyzer = RetryAnalyzer.class)
	public void user_clicks_link(String string) {
		queue_PF.ClickQueue();
		if (string.equals("Practice Questions"))
		{			
			queue_PF.ClickQueueOP();
		}
		queue_PF.ClickText(string);				
		assertEquals(string, queue_PF.getTitle());
		logger.info("User is in the " + string + " Page");
	}
		
		
	@Test(priority = 3, dataProviderClass = DataProviders.class, dataProvider = "EditorData", retryAnalyzer = RetryAnalyzer.class, description = "Verify that user is in the tryEditor page in Queue in Python page")
	public void TestEditor_Pypage(String inputText, String expectedOutput) {	
		queue_PF.ClickQueue();
		queue_PF.ClickText("Implementation of Queue in Python");
		queue_PF.ClickTryEditor();
		queue_PF.PythonCode(inputText);        
		queue_PF.ClickBtnRun();
		if (expectedOutput.contains("NameError"))
		{
			String alertMsg = queue_PF.AlertMsg();
			Assert.assertTrue(alertMsg.contains("NameError:"));	
			logger.info(alertMsg);
			queue_PF.Alertaccept();
		}
		else
		{
			Assert.assertEquals(expectedOutput, queue_PF.getOPMsg());
			logger.info(expectedOutput);
		}				
	}	
	
	@Test(priority = 4, dataProviderClass = DataProviders.class, dataProvider = "EditorData", retryAnalyzer = RetryAnalyzer.class, description = "Verify that user is in the tryEditor page in deque page")
	public void TestEditor_dequepage(String inputText, String expectedOutput) {	
		queue_PF.ClickQueue();
		queue_PF.ClickText("Implementation using collections.deque");
		queue_PF.ClickTryEditor();
		queue_PF.PythonCode(inputText);        
		queue_PF.ClickBtnRun();
		if (expectedOutput.contains("NameError"))
		{
			String alertMsg = queue_PF.AlertMsg();
			Assert.assertTrue(alertMsg.contains("NameError:"));	
			logger.info(alertMsg);
			queue_PF.Alertaccept();
		}
		else
		{
			Assert.assertEquals(expectedOutput, queue_PF.getOPMsg());
			logger.info(expectedOutput);
		}				
	}
	
	@Test(priority = 5, dataProviderClass = DataProviders.class, dataProvider = "EditorData", retryAnalyzer = RetryAnalyzer.class, description = "Verify that user is in the tryEditor page in array page")
	public void TestEditor_arraypage(String inputText, String expectedOutput) {	
		queue_PF.ClickQueue();
		queue_PF.ClickText("Implementation using array");
		queue_PF.ClickTryEditor();
		queue_PF.PythonCode(inputText);        
		queue_PF.ClickBtnRun();
		if (expectedOutput.contains("NameError"))
		{
			String alertMsg = queue_PF.AlertMsg();
			Assert.assertTrue(alertMsg.contains("NameError:"));	
			logger.info(alertMsg);
			queue_PF.Alertaccept();
		}
		else
		{
			Assert.assertEquals(expectedOutput, queue_PF.getOPMsg());
			logger.info(expectedOutput);
		}				
	}
	
	@Test(priority = 6, dataProviderClass = DataProviders.class, dataProvider = "EditorData", retryAnalyzer = RetryAnalyzer.class, description = "Verify that user is in the tryEditor page in Operations page")
	public void TestEditor_Operpage(String inputText, String expectedOutput) {	
		queue_PF.ClickQueue();
		queue_PF.ClickText("Queue Operations");
		queue_PF.ClickTryEditor();
		queue_PF.PythonCode(inputText);        
		queue_PF.ClickBtnRun();
		if (expectedOutput.contains("NameError"))
		{
			String alertMsg = queue_PF.AlertMsg();
			Assert.assertTrue(alertMsg.contains("NameError:"));	
			logger.info(alertMsg);
			queue_PF.Alertaccept();
		}
		else
		{
			Assert.assertEquals(expectedOutput, queue_PF.getOPMsg());
			logger.info(expectedOutput);
		}				
	}	
}
