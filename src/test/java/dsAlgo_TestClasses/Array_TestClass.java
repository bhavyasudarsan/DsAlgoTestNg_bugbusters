package dsAlgo_TestClasses;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Array_PageFactory;

public class Array_TestClass extends BaseClass{
	
	Array_PageFactory array;
	List<Object[]> arrayData;
	private static final Logger logger = LoggerFactory.getLogger(Array_TestClass.class);
	
	@BeforeMethod
	//@Test(priority=1)
	public void arrayGetStarted() {
		array=new Array_PageFactory();
		validLogin();
		array.arrayGetStarted();
		System.out.println("Inside Array---");
	}
	
	@Test(priority=1)
	public void arraysInPython() {
		array.arraysInPython();
		System.out.println("Inside ArraysIn Python");
		array.tryHere();
		logger.info("In try editor page-------");
	}
	
	@DataProvider(name = "EditorExcelData")
	public Object[][] validCodeFromExcel() {
		return array.dataFromExcel("Array", 16);
	   
	}

	@Test(priority = 2, dataProvider="EditorExcelData")
	public void validCodeTryEditor(String input,String output) {
		arraysInPython();
		array.validPythonCode(input);
		Assert.assertEquals(array.output(), output);	
	}
	

}
