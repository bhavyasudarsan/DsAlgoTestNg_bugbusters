package dsAlgo_TestClasses;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Graph_PageFactory;
import dsAlgo_Utilities.*;

public class Graph_TestClass extends BaseClass {
	Graph_PageFactory graph_PF;

	private static final Logger logger = LoggerFactory.getLogger(Graph_PageFactory.class);
	
	@DataProvider(name = "stringData")
	public Object[][] stringData() {
		return new Object[][] { { "Graph" }, { "Graph Representations" }, {"Practice Questions"} };
	}
	
	@BeforeMethod
	public void test() {
		logger.info("User is in the signin page");
		graph_PF = new Graph_PageFactory();
		graph_PF.openLogin();
	    graph_PF.SetUserName("bugbusters");
		graph_PF.SetPassword("Team@bug");
		graph_PF.ClickBtnLogin();
	}

	@Test(priority = 1, description = " Verify that user is able to navigate to Graph page")
	public void getTitle() {
		graph_PF.ClickGraph();
		assertEquals("Graph", graph_PF.getTitle());
		logger.info("User is in the Graph page");
	}

	@Test(priority = 2, dependsOnMethods = { "getTitle" }, dataProvider = "stringData", retryAnalyzer = RetryAnalyzer.class)
	public void user_clicks_link(String string) {
		graph_PF.ClickGraph();
		if (string.equals("Practice Questions"))
		{
			graph_PF.ClickSubGraph();
		}
		if (string.equals("Graph"))
		{			
			graph_PF.ClickGraph2(string);
		}
		else
		{
			graph_PF.ClickText(string);	
		}
		assertEquals(string, graph_PF.getTitle());
		logger.info("User is in the " + string + " Page");
	}
		
		
	@Test(priority = 3, dataProvider = "EditorData", retryAnalyzer = RetryAnalyzer.class, description = "Verify that user is in the tryEditor page in Graph page")
	public void TestEditor_page(String inputText, String expectedOutput) {
		graph_PF.ClickGraph();	
		graph_PF.ClickGraph2("Graph");		
		graph_PF.ClickTryEditor();
		graph_PF.PythonCode(inputText);        
		graph_PF.ClickBtnRun();
		if (expectedOutput.contains("NameError"))
		{
			String alertMsg = graph_PF.AlertMsg();
			Assert.assertTrue(alertMsg.contains("NameError:"));	
			logger.info(alertMsg);
			graph_PF.Alertaccept();
		}
		else
		{
			Assert.assertEquals(expectedOutput, graph_PF.getOPMsg());
			logger.info(expectedOutput);
		}				
	}
	
	@Test(priority = 4, dataProvider = "EditorData", retryAnalyzer = RetryAnalyzer.class, description = "Verify that user is in the tryEditor page in Graph Representations page")
	public void TestEditor_GRpage(String inputText, String expectedOutput) {
		graph_PF.ClickGraph();	
		graph_PF.ClickText("Graph Representations");		
		graph_PF.ClickTryEditor();
		graph_PF.PythonCode(inputText);        
		graph_PF.ClickBtnRun();
		if (expectedOutput.contains("NameError"))
		{
			String alertMsg = graph_PF.AlertMsg();
			Assert.assertTrue(alertMsg.contains("NameError:"));	
			logger.info(alertMsg);
			graph_PF.Alertaccept();
		}
		else
		{
			Assert.assertEquals(expectedOutput, graph_PF.getOPMsg());
			logger.info(expectedOutput);
		}	
	}
	
	@DataProvider(name = "EditorData")
    public Object[][] loginDataProvider() throws IOException {
        return ExcelReader.readExcelData("Editor");
    }

}


