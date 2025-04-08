package dsAlgo_Utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

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
    // Add more DataProviders as needed
}
