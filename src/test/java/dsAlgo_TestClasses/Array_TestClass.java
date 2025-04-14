package dsAlgo_TestClasses;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Array_PageFactory;
import dsAlgo_Utilities.DataProviders;
import dsAlgo_Utilities.RetryAnalyzer;

public class Array_TestClass extends BaseClass{
	
	Array_PageFactory array;
	List<Object[]> arrayData;
	private static final Logger logger = LoggerFactory.getLogger(Array_TestClass.class);
	
	@BeforeMethod
	public void arrayGetStarted() {
		array=new Array_PageFactory();
		validLogin();
		array.arrayGetStarted();
		logger.info("User is Inside Array Page---");
		
	}
	
	public void pageLink(String string) {
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

	@Test(priority = 1,dataProviderClass = DataProviders.class,dataProvider="ArrayExcelValidData")
	public void arraysInPythonvalidTryEditor(String input,String output) {
		pageLink("Arrays in Python");
		array.tryEditorCode(input);
		Assert.assertEquals(array.output(), output);	
	}

	@Test(priority = 2,dataProviderClass = DataProviders.class,dataProvider="ArrayExcelInvalidData",retryAnalyzer = RetryAnalyzer.class)
	public void arraysInPythonInvalidTryEditor(String input,String output) {
		pageLink("Arrays in Python");
		array.tryEditorCode(input);
		Assert.assertEquals(array.alertMessage(), output);	
	}
	
	@Test(priority = 3,dataProviderClass = DataProviders.class,dataProvider="ArrayExcelValidData")
	public void arraysUsingListvalidTryEditor(String input,String output) {
		pageLink("Arrays Using List");
		array.tryEditorCode(input);
		Assert.assertEquals(array.output(), output);	
	}

	@Test(priority = 4,dataProviderClass = DataProviders.class,dataProvider="ArrayExcelInvalidData",retryAnalyzer = RetryAnalyzer.class)
	public void arraysUsingListInvalidTryEditor(String input,String output) {
		pageLink("Arrays Using List");
		array.tryEditorCode(input);
		Assert.assertEquals(array.alertMessage(), output);	
	}
	
	@Test(priority = 5,dataProviderClass = DataProviders.class,dataProvider="ArrayExcelValidData")
	public void basicOperationsvalidTryEditor(String input,String output) {
		pageLink("Basic Operations in Lists");
		array.tryEditorCode(input);
		Assert.assertEquals(array.output(), output);	
	}

	@Test(priority = 6,dataProviderClass = DataProviders.class,dataProvider="ArrayExcelInvalidData",retryAnalyzer = RetryAnalyzer.class)
	public void basicOperationsInvalidTryEditor(String input,String output) {
		pageLink("Basic Operations in Lists");
		array.tryEditorCode(input);
		Assert.assertEquals(array.alertMessage(), output);	
	}
	
	@Test(priority = 7,dataProviderClass = DataProviders.class,dataProvider="ArrayExcelValidData")
	public void applicationsArrayvalidTryEditor(String input,String output) {
		pageLink("Applications of Array");
		array.tryEditorCode(input);
		Assert.assertEquals(array.output(), output);	
	}

	@Test(priority = 8,dataProviderClass = DataProviders.class,dataProvider="ArrayExcelInvalidData",retryAnalyzer = RetryAnalyzer.class)
	public void applicationsArrayInvalidTryEditor(String input,String output) {
		pageLink("Applications of Array");
		array.tryEditorCode(input);
		Assert.assertEquals(array.alertMessage(), output);	
	}
	
	@Test(priority=9)
	public void arrayPracticeQuestion() {
		array.arraysInPython();
		array.practiceQuestions();
		logger.info("Practice Question page");
		Assert.assertEquals(array.getTitle(), "Practice Questions");	
	}
	
	@Test(priority=10,dataProviderClass = DataProviders.class,dataProvider="SearchArrayInvalidData",retryAnalyzer = RetryAnalyzer.class)
	public void searchTheArrayInvalidTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.searchTheArray();
		array.tryEditorCode(input);
		Assert.assertEquals(array.alertMessage(), output);	
		
	}
	
	@Test(priority=11,dataProviderClass = DataProviders.class,dataProvider="SearchArrayValidData",retryAnalyzer = RetryAnalyzer.class)
	public void searchTheArrayValidTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.searchTheArray();
		array.validCodePracticeQuestions(input);
		array.run();
		Assert.assertEquals(array.output(), output);
	}
	
	@Test(priority=12,dataProviderClass = DataProviders.class,dataProvider="SearchArraySubmit",retryAnalyzer = RetryAnalyzer.class)
	public void searchTheArraySubmitTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.searchTheArray();
		array.validCodePracticeQuestions(input);
		array.submit();
		Assert.assertEquals(array.output(), output);	
		
	}
	
	@Test(priority=13,dataProviderClass = DataProviders.class,dataProvider="MaxConsecutiveInvalidRun",retryAnalyzer = RetryAnalyzer.class)
	public void maxConsecutiveInvalidTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.maxConsecutiveOnes();
		array.tryEditorCode(input);
		Assert.assertEquals(array.alertMessage(), output);	
		
	}

	@Test(priority=14,dataProviderClass = DataProviders.class,dataProvider="MaxConsecutiveValidRun",retryAnalyzer = RetryAnalyzer.class)
	public void maxConsecutiveValidTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.maxConsecutiveOnes();
		array.validCodePracticeQuestions(input);
		array.run();
		Double actual=Double.parseDouble(array.output());
		Double expected=Double.parseDouble(output);
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority=15,dataProviderClass = DataProviders.class,dataProvider="MaxConsecutiveSubmit",retryAnalyzer = RetryAnalyzer.class)
	public void maxConsecutiveSubmitTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.maxConsecutiveOnes();
		array.validCodePracticeQuestions(input);
		array.submit();
		Assert.assertEquals(array.output(), output);
	}
	
	@Test(priority=16,dataProviderClass = DataProviders.class,dataProvider="EvenNumberInvalidRun",retryAnalyzer = RetryAnalyzer.class)
	public void evenNumberInvalidTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.findNumberswithEvenNumberofDigits();
		array.tryEditorCode(input);
		Assert.assertEquals(array.alertMessage(), output);	
		
	}

	@Test(priority=17,dataProviderClass = DataProviders.class,dataProvider="EvenNumberValidRun",retryAnalyzer = RetryAnalyzer.class)
	public void evenNumberValidTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.findNumberswithEvenNumberofDigits();
		array.validCodePracticeQuestions(input);
		array.run();
		Double actual=Double.parseDouble(array.output());
		Double expected=Double.parseDouble(output);
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority=18,dataProviderClass = DataProviders.class,dataProvider="EvenNumberSubmit",retryAnalyzer = RetryAnalyzer.class)
	public void evenNumberSubmitTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.findNumberswithEvenNumberofDigits();
		array.validCodePracticeQuestions(input);
		array.submit();
		Assert.assertEquals(array.output(), output);
	}
	
	@Test(priority=19,dataProviderClass = DataProviders.class,dataProvider="SortedArrayInvalidRun",retryAnalyzer = RetryAnalyzer.class)
	public void sortedArrayInvalidTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.squaresOfaSortedArray();
		array.tryEditorCode(input);
		Assert.assertEquals(array.alertMessage(), output);	
		
	}

	@Test(priority=20,dataProviderClass = DataProviders.class,dataProvider="SortedArrayValidRun",retryAnalyzer = RetryAnalyzer.class)
	public void sortedArrayValidTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.squaresOfaSortedArray();
		array.validCodePracticeQuestions(input);
		array.run();
		Assert.assertEquals(array.output(), output);
		
	}
	
	@Test(priority=21,dataProviderClass = DataProviders.class,dataProvider="SortedArraySubmit",retryAnalyzer = RetryAnalyzer.class)
	public void sortedArraySubmitTryEditor (String input,String output) {
		arrayPracticeQuestion();
		array.squaresOfaSortedArray();
		array.validCodePracticeQuestions(input);
		array.submit();
		Assert.assertEquals(array.output(), output);
	}
	
	}
