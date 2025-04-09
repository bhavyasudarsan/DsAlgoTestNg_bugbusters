package dsAlgo_Utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
	  @DataProvider(name = "homeData")
		public Object[][] homeData() {
			return new Object[][] { { "Arrays" }, { "Linked List" }, {"Stack"},{"Queue"},{"Graph"},{"Tree"} };
		}
	  @DataProvider(name = "homepanelData")
		public Object[][] homepanelData() {
			return new Object[][] { { "Array" }, { "Linked List" }, {"Stack"},{"Queue"},{"Graph"},{"Tree"} };
		}
    @DataProvider(name = "loginData")
    public static Object[][] loginDataProvider() throws IOException {
        return ExcelReader.readExcelData("Login");
    }

    @DataProvider(name = "EditorData")
    public static Object[][] editorDataProvider() throws IOException {
        return ExcelReader.readExcelData("Editor");
    }

    @DataProvider(name = "GraphData")
    public static Object[][] stringDataProvider() {
        return new Object[][] { { "Graph" }, { "Graph Representations" }, {"Practice Questions"} };
    }
    
	@DataProvider(name = "QueueData")
	public Object[][] stringData() {
		return new Object[][] { { "Implementation of Queue in Python" }, { "Implementation using collections.deque" }, {"Implementation using array"}, {"Queue Operations"}, {"Practice Questions"} };
	}
	
	@DataProvider(name = "linkedListData")
	public Object[][] linkedListData() {
		return new Object[][] { { "Introduction" },{ "Creating Linked List" },{ "Types of Linked List" },{ "Implement Linked List in Python" }, { "Traversal" }, { "Insertion" }, { "Deletion" },{"Practice Questions"} };
	}
	@DataProvider(name = "stackData")
	public Object[][] stackData() {
		return new Object[][] { { "Operations in Stack" } ,
			{ "Applications" },{"Implementation"},{"Practice Questions"}};
	}
	
	@DataProvider(name = "RegisterData")
    public Object[][] registerDataProvider() throws IOException {
		
        return ExcelReader.readExcelData("Register");
    }
	
}
