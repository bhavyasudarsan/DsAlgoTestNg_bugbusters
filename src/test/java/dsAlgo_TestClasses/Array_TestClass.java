package dsAlgo_TestClasses;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Array_PageFactory;

public class Array_TestClass extends BaseClass{
	
	Array_PageFactory array;
	List<Object[]> arrayData;
	private static final Logger logger = LoggerFactory.getLogger(Array_TestClass.class);
	
//	@BeforeMethod
	@Test(priority=1)
	public void arrayGetStarted() {
		array=new Array_PageFactory();
		validLogin();
		array.arrayGetStarted();
		System.out.println("Inside Array---");
	}
	
	
	
	public void pageLink(String string) {
		arrayGetStarted();
		switch (string) {
	case "Arrays in Python":
		logger.info("Inside Arrays in Python");
		array.arraysInPython();
		Assert.assertEquals(array.getTitle(), "Arrays in Python");
		break;
	case "Arrays Using List":
		logger.info("Inside Arrays Using List");
		array.arraysUsingList();
		Assert.assertEquals(array.getTitle(), "Arrays Using List");
		break;
	case "Basic Operations in Lists":
		logger.info("Inside Basic Operations in Lists");
		array.basicOperationsinLists();
		Assert.assertEquals(array.getTitle(), "Basic Operations in Lists");
		break;
	case "Applications of Array":
		logger.info("Inside Applications of Array");
		array.applicationsofArray();
		Assert.assertEquals(array.getTitle(), "Applications of Array");
		break;
		}
		array.tryHere();
	}

	@Test(priority = 2, dataProvider="ArrayExcelValidData")
	public void arraysInPythonvalidTryEditor(String input,String output) {
		pageLink("Arrays in Python");
		array.tryEditorCode(input);
		Assert.assertEquals(array.output(), output);	
	}

	@Test(priority = 3, dataProvider="ArrayExcelInvalidData")
	public void arraysInPythonInvalidTryEditor(String input,String output) {
		pageLink("Arrays in Python");
		array.tryEditorCode(input);
		Assert.assertEquals(array.alertMessage(), output);	
	}
	
	@Test(priority = 4, dataProvider="ArrayExcelValidData")
	public void arraysUsingListvalidTryEditor(String input,String output) {
		pageLink("Arrays Using List");
		array.tryEditorCode(input);
		Assert.assertEquals(array.output(), output);	
	}

	@Test(priority = 5, dataProvider="ArrayExcelInvalidData")
	public void arraysUsingListInvalidTryEditor(String input,String output) {
		pageLink("Arrays Using List");
		array.tryEditorCode(input);
		Assert.assertEquals(array.alertMessage(), output);	
	}
	
	@Test(priority = 6, dataProvider="ArrayExcelValidData")
	public void basicOperationsvalidTryEditor(String input,String output) {
		pageLink("Basic Operations in Lists");
		array.tryEditorCode(input);
		Assert.assertEquals(array.output(), output);	
	}

	@Test(priority = 7, dataProvider="ArrayExcelInvalidData")
	public void basicOperationsInvalidTryEditor(String input,String output) {
		pageLink("Basic Operations in Lists");
		array.tryEditorCode(input);
		Assert.assertEquals(array.alertMessage(), output);	
	}
	
	@Test(priority = 8, dataProvider="ArrayExcelValidData")
	public void applicationsArrayvalidTryEditor(String input,String output) {
		pageLink("Applications of Array");
		array.tryEditorCode(input);
		Assert.assertEquals(array.output(), output);	
	}

	@Test(priority = 9, dataProvider="ArrayExcelInvalidData")
	public void applicationsArrayInvalidTryEditor(String input,String output) {
		pageLink("Applications of Array");
		array.tryEditorCode(input);
		Assert.assertEquals(array.alertMessage(), output);	
	}
	
	@Test(priority=10)
	public void arrayPracticeQuestion() {
		arrayGetStarted();
		array.arraysInPython();
		array.practiceQuestions();
		Assert.assertEquals(array.getTitle(), "Practice Questions");	
	}
	
	@Test(priority=11,dataProvider="SearchArrayInvalidData")
	public void searchTheArrayInvalidTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.searchTheArray();
		array.tryEditorCode(input);
		Assert.assertEquals(array.alertMessage(), output);	
		
	}
	
	@Test(priority=12,dataProvider="SearchArrayValidData")
	public void searchTheArrayValidTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.searchTheArray();
		array.validCodePracticeQuestions(input);
		array.run();
		Assert.assertEquals(array.output(), output);
	}
	
	@Test(priority=13,dataProvider="SearchArraySubmit")
	public void searchTheArraySubmitTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.searchTheArray();
		array.validCodePracticeQuestions(input);
		array.submit();
		Assert.assertEquals(array.output(), output);	
		
	}
	
	@Test(priority=14,dataProvider="MaxConsecutiveInvalidRun")
	public void maxConsecutiveInvalidTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.maxConsecutiveOnes();
		array.tryEditorCode(input);
		Assert.assertEquals(array.alertMessage(), output);	
		
	}

	@Test(priority=15,dataProvider="MaxConsecutiveValidRun")
	public void maxConsecutiveValidTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.maxConsecutiveOnes();
		array.validCodePracticeQuestions(input);
		array.run();
		Double actual=Double.parseDouble(array.output());
		Double expected=Double.parseDouble(output);
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority=16,dataProvider="MaxConsecutiveSubmit")
	public void maxConsecutiveSubmitTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.maxConsecutiveOnes();
		array.validCodePracticeQuestions(input);
		array.submit();
		Assert.assertEquals(array.output(), output);
	}
	
	@Test(priority=17,dataProvider="EvenNumberInvalidRun")
	public void evenNumberInvalidTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.findNumberswithEvenNumberofDigits();
		array.tryEditorCode(input);
		Assert.assertEquals(array.alertMessage(), output);	
		
	}

	@Test(priority=18,dataProvider="EvenNumberValidRun")
	public void evenNumberValidTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.findNumberswithEvenNumberofDigits();
		array.validCodePracticeQuestions(input);
		array.run();
		Double actual=Double.parseDouble(array.output());
		Double expected=Double.parseDouble(output);
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority=19,dataProvider="EvenNumberSubmit")
	public void evenNumberSubmitTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.findNumberswithEvenNumberofDigits();
		array.validCodePracticeQuestions(input);
		array.submit();
		Assert.assertEquals(array.output(), output);
	}
	
	@Test(priority=20,dataProvider="SortedArrayInvalidRun")
	public void sortedArrayInvalidTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.squaresOfaSortedArray();
		array.tryEditorCode(input);
		Assert.assertEquals(array.alertMessage(), output);	
		
	}

	@Test(priority=21,dataProvider="SortedArrayValidRun")
	public void sortedArrayValidTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.squaresOfaSortedArray();
		array.validCodePracticeQuestions(input);
		array.run();
		Assert.assertEquals(array.output(), output);
		
	}
	
	@Test(priority=22,dataProvider="SortedArraySubmit")
	public void sortedArraySubmitTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.squaresOfaSortedArray();
		array.validCodePracticeQuestions(input);
		array.submit();
		Assert.assertEquals(array.output(), output);
	}
	
	@DataProvider(name = "ArrayExcelValidData")
	public Object[][] validCodeFromExcel() {
		return new Object[][] {array.dataFromExcel("Array", 16)};
	   
	}
	
	@DataProvider(name = "ArrayExcelInvalidData")
	public Object[][] invalidCodeFromExcel() {
		return new Object[][]{ array.dataFromExcel("Array", 17),array.dataFromExcel("Array", 18)};
	}	
	
	@DataProvider(name = "SearchArrayInvalidData")
	public Object[][] searchArrayFromExcel() {
		return new Object[][]{ array.dataFromExcel("Array", 1)};
	}
	
	@DataProvider(name = "SearchArrayValidData")
	public Object[][] searchArrayValidFromExcel() {
		return new Object[][]{ array.dataFromExcel("Array", 0)};
	}
	
	@DataProvider(name = "SearchArraySubmit")
	public Object[][] searchArraySubmitFromExcel() {
		return new Object[][]{ array.dataFromExcel("Array", 2),array.dataFromExcel("Array", 3)};
	}

	@DataProvider(name="MaxConsecutiveInvalidRun")
	public Object[][] maxConsecutiveInvalidData(){
		return new Object[][] {array.dataFromExcel("Array", 5)};
		
	}
	@DataProvider(name = "MaxConsecutiveValidRun")
	public Object[][] maxConsecutiveValidData() {
		return new Object[][]{ array.dataFromExcel("Array", 4)};
	}
	@DataProvider(name = "MaxConsecutiveSubmit")
	public Object[][] maxConsecutiveSubmitFromExcel() {
		return new Object[][]{ array.dataFromExcel("Array", 6),array.dataFromExcel("Array", 7)};
	}
	@DataProvider(name="EvenNumberInvalidRun")
	public Object[][] EvenNumberInvalidData(){
		return new Object[][] {array.dataFromExcel("Array", 9)};
		
	}
	@DataProvider(name = "EvenNumberValidRun")
	public Object[][] EvenNumberValidData() {
		return new Object[][]{ array.dataFromExcel("Array", 8)};
	}
	@DataProvider(name = "EvenNumberSubmit")
	public Object[][] EvenNumberSubmitFromExcel() {
		return new Object[][]{ array.dataFromExcel("Array", 10),array.dataFromExcel("Array", 11)};
	}
	
	@DataProvider(name="SortedArrayInvalidRun")
	public Object[][] SortedArrayInvalidData(){
		return new Object[][] {array.dataFromExcel("Array", 13)};
		
	}
	@DataProvider(name = "SortedArrayValidRun")
	public Object[][] SortedArrayValidData() {
		return new Object[][]{ array.dataFromExcel("Array", 12)};
	}
	@DataProvider(name = "SortedArraySubmit")
	public Object[][] SortedArraySubmitFromExcel() {
		return new Object[][]{ array.dataFromExcel("Array", 14),array.dataFromExcel("Array", 15)};
	}
}
