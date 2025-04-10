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
   
	@DataProvider(name = "EditorExcelValidData")
	public Object[][] treeValidCode() {
		Object[][] editorData = ExcelReader.readExcelData("Editor");
		return new Object[][] {
			{editorData[1][0], editorData[1][1]} 
			};   
	}
	
	@DataProvider(name = "EditorExcelInvalidData")
	public Object[][] treeInvalidCode() {
		Object[][] editorData = ExcelReader.readExcelData("Editor");
		return new Object[][]{ 
			{editorData[2][0], editorData[2][1]},{editorData[3][0], editorData[3][1]}
			};
	}
	
	@DataProvider(name = "ArrayExcelValidData")
	public Object[][] validCodeFromExcel() {
		Object[][] editorData = ExcelReader.readExcelData("Array");
		return new Object[][] {
			{editorData[16][1], editorData[16][2]}};  
	}
	
	@DataProvider(name = "ArrayExcelInvalidData")
	public Object[][] invalidCodeFromExcel() {
		Object[][] editorData = ExcelReader.readExcelData("Array");
		return new Object[][]{ 
			{editorData[17][1], editorData[17][2]},{editorData[18][1], editorData[18][2]}
			};
	}	
	
	@DataProvider(name = "SearchArrayInvalidData")
	public Object[][] searchArrayFromExcel() {
		Object[][] practiceQuestion = ExcelReader.readExcelData("Array");
		return new Object[][] {
			{practiceQuestion[1][1], practiceQuestion[1][2]}
			};  
	}
	
	@DataProvider(name = "SearchArrayValidData")
	public Object[][] searchArrayValidFromExcel() {
		Object[][] practiceQuestion = ExcelReader.readExcelData("Array");
		return new Object[][] {
			{practiceQuestion[0][1], practiceQuestion[0][2]}
			};  
	}
	
	@DataProvider(name = "SearchArraySubmit")
	public Object[][] searchArraySubmitFromExcel() {
		Object[][] practiceQuestion = ExcelReader.readExcelData("Array");
		return new Object[][] {
			{practiceQuestion[2][1], practiceQuestion[2][2]},
			{practiceQuestion[3][1], practiceQuestion[3][2]}
			};  
	}

	@DataProvider(name="MaxConsecutiveInvalidRun")
	public Object[][] maxConsecutiveInvalidData(){
		Object[][] practiceQuestion = ExcelReader.readExcelData("Array");
		return new Object[][] {
			{practiceQuestion[5][1], practiceQuestion[5][2]}
			};  
	}
	@DataProvider(name = "MaxConsecutiveValidRun")
	public Object[][] maxConsecutiveValidData() {
		Object[][] practiceQuestion = ExcelReader.readExcelData("Array");
		return new Object[][] {
			{practiceQuestion[4][1], practiceQuestion[4][2]}
			}; 
	}
	
	@DataProvider(name = "MaxConsecutiveSubmit")
	public Object[][] maxConsecutiveSubmitFromExcel() {
		Object[][] practiceQuestion = ExcelReader.readExcelData("Array");
		return new Object[][] {
			{practiceQuestion[6][1], practiceQuestion[6][2]},
			{practiceQuestion[7][1], practiceQuestion[7][2]}
			};  
	}
	
	@DataProvider(name="EvenNumberInvalidRun")
	public Object[][] EvenNumberInvalidData(){
		Object[][] practiceQuestion = ExcelReader.readExcelData("Array");
		return new Object[][] {
			{practiceQuestion[9][1], practiceQuestion[9][2]}
			}; 
	}
	
	@DataProvider(name = "EvenNumberValidRun")
	public Object[][] EvenNumberValidData() {
		Object[][] practiceQuestion = ExcelReader.readExcelData("Array");
		return new Object[][] {
			{practiceQuestion[8][1], practiceQuestion[8][2]}
			}; 
	}
	
	@DataProvider(name = "EvenNumberSubmit")
	public Object[][] EvenNumberSubmitFromExcel() {
		Object[][] practiceQuestion = ExcelReader.readExcelData("Array");
		return new Object[][] {
			{practiceQuestion[10][1], practiceQuestion[10][2]},
			{practiceQuestion[11][1], practiceQuestion[11][2]}
			};  
	}
	
	@DataProvider(name="SortedArrayInvalidRun")
	public Object[][] SortedArrayInvalidData(){
		Object[][] practiceQuestion = ExcelReader.readExcelData("Array");
		return new Object[][] {
			{practiceQuestion[13][1], practiceQuestion[13][2]}
			}; 
	}
	
	@DataProvider(name = "SortedArrayValidRun")
	public Object[][] SortedArrayValidData() {
		Object[][] practiceQuestion = ExcelReader.readExcelData("Array");
		return new Object[][] {
			{practiceQuestion[12][1], practiceQuestion[12][2]}
			}; 
	}
	
	@DataProvider(name = "SortedArraySubmit")
	public Object[][] SortedArraySubmitFromExcel() {
		Object[][] practiceQuestion = ExcelReader.readExcelData("Array");
		return new Object[][] {
			{practiceQuestion[14][1], practiceQuestion[14][2]},
			{practiceQuestion[15][1], practiceQuestion[15][2]}
			};  
	}

	
}
