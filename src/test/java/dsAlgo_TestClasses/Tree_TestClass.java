package dsAlgo_TestClasses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dsAlgo_BaseClass.BaseClass;
import dsAlgo_PageFactory.Tree_PageFactory;

public class Tree_TestClass extends BaseClass {
	
	Tree_PageFactory tree;
	private static final Logger logger = LoggerFactory.getLogger(Tree_TestClass.class);
	
	//@BeforeMethod
	@Test(priority=1)
	public void treeGetStarted() {
		tree = new Tree_PageFactory();
		validLogin();
		tree.treeGetStarted();	
	}
	
	@DataProvider(name = "stringData")
		public Object[][] stringData() {
		return new Object[][] {
//            {"Overview of Trees"},
//			  {"Terminologies"}
//            {"Types of Trees"},
//            {"Tree Traversals"},
//            {"Traversals-Illustration"},
//            {"Binary Trees"},
//            {"Types of Binary Trees"},
//            {"Implementation in Python"},
//            {"Binary Tree Traversals"},
//            {"Implementation of Binary Trees"},
//            {"Applications of Binary trees"},
//            {"Binary Search Trees"},
//			  {"Implementation Of BST"}
       };
	}
	
//	@Test(priority=2,dataProvider = "stringData")
	public void pageLink(String string) {
		treeGetStarted();
		switch (string) {
	case "Overview of Trees":
		logger.info("Inside Overview of Trees");
		tree.overviewOfTrees();
		Assert.assertEquals(tree.getTitle(), "Overview of Trees");
		break;
	case "Terminologies":
		tree.terminologies();
		Assert.assertEquals(tree.getTitle(), "Terminologies");
		logger.info("Inside Terminologies page");
		break;
	case "Types of Trees":
		tree.typesOfTrees();
		logger.info("Inside Types of Trees");
		break;
	case "Tree Traversals":
		tree.treeTraversals();
		logger.info("Inside Tree Traversals");
		break;
	case "Traversals-Illustration":
		tree.traversalsIllustration();
		logger.info("Inside Traversals-Illustration");
		break;
	case "Binary Trees":
		tree.binaryTrees();
		logger.info("Inside Binary Trees");
		break;
	case "Types of Binary Trees":
		tree.typesOfBinaryTrees();
		logger.info("Inside Types of Binary Trees");
		break;
	case "Implementation in Python":
		tree.implementationInPython();
		logger.info("Inside Implementation in Python");
		break;
	case "Binary Tree Traversals":
		tree.binaryTreeTraversals();
		logger.info("Inside Binary Tree Traversals");
		break;
	case "Implementation of Binary Trees":
		tree.implementationOfBinaryTrees();
		logger.info("Inside Implementation of Binary Trees");
		break;
	case "Applications of Binary trees":
		tree.applicationsOfBinarytrees();
		logger.info("Inside Applications of Binary Trees");
		break;
	case "Binary Search Trees":
		tree.binarySearchTrees();
		logger.info("Inside Binary Search Trees");
		break;
	case "Implementation Of BST":
		tree.implementationOfBST();
		logger.info("Inside Implementation of BST");
		break;
	}
		tree.tryHere();
}
	
	@Test(priority= 2,dataProvider = "EditorExcelValidData")
	public void overviewValidTryEditor(String input,String output) {
		pageLink("Overview of Trees");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.output(), output);
	}
	
	@Test(priority= 3,dataProvider = "EditorExcelInvalidData")
	public void overviewinvalidTryEditor(String input,String output) {
		pageLink("Overview of Trees");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.alertMessage(), output);
	}
	
	@Test(priority= 4,dataProvider = "EditorExcelValidData")
	public void terminologiesValidTryEditor(String input,String output) {
		pageLink("Terminologies");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.output(), output);
	}
	
	@Test(priority= 5,dataProvider = "EditorExcelInvalidData")
	public void terminologiesinvalidTryEditor(String input,String output) {
		pageLink("Terminologies");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.alertMessage(), output);
	}
	
	@DataProvider(name = "EditorExcelValidData")
	public Object[][] validCodeFromExcel() {
		return new Object[][] {tree.dataFromExcel("Editor", 1)};
	   
	}
	
	@DataProvider(name = "EditorExcelInvalidData")
	public Object[][] invalidCodeFromExcel() {
		return new Object[][]{ tree.dataFromExcel("Editor", 2),tree.dataFromExcel("Editor", 3)};
	}	
	
	
}