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
	
//	@DataProvider(name = "stringData")
//		public Object[][] stringData() {
//		return new Object[][] {
//            {"Overview of Trees"},
//			  {"Terminologies"},
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
//       };
//	}
	
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
	
	@Test(priority= 6,dataProvider = "EditorExcelValidData")
	public void typesOfTreesValidTryEditor(String input,String output) {
		pageLink("Types of Trees");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.output(), output);
	}
	
	@Test(priority= 7,dataProvider = "EditorExcelInvalidData")
	public void typesOfTreesinvalidTryEditor(String input,String output) {
		pageLink("Types of Trees");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.alertMessage(), output);
	}
	
	@Test(priority= 8,dataProvider = "EditorExcelValidData")
	public void treeTraversalsValidTryEditor(String input,String output) {
		pageLink("Tree Traversals");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.output(), output);
	}
	
	@Test(priority= 9,dataProvider = "EditorExcelInvalidData")
	public void treeTraversalsinvalidTryEditor(String input,String output) {
		pageLink("Tree Traversals");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.alertMessage(), output);
	}
	
	@Test(priority= 10,dataProvider = "EditorExcelValidData")
	public void traversalsValidTryEditor(String input,String output) {
		pageLink("Traversals-Illustration");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.output(), output);
	}
	
	@Test(priority= 11,dataProvider = "EditorExcelInvalidData")
	public void traversalsinvalidTryEditor(String input,String output) {
		pageLink("Traversals-Illustration");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.alertMessage(), output);
	}
	
	@Test(priority= 12,dataProvider = "EditorExcelValidData")
	public void binaryTreesValidTryEditor(String input,String output) {
		pageLink("Binary Trees");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.output(), output);
	}
	
	@Test(priority= 13,dataProvider = "EditorExcelInvalidData")
	public void binaryTreesinvalidTryEditor(String input,String output) {
		pageLink("Binary Trees");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.alertMessage(), output);
	}
	
	@Test(priority= 12,dataProvider = "EditorExcelValidData")
	public void typesBinaryTreesValidTryEditor(String input,String output) {
		pageLink("Types of Binary Trees");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.output(), output);
	}
	
	@Test(priority= 13,dataProvider = "EditorExcelInvalidData")
	public void typesBinaryTreesinvalidTryEditor(String input,String output) {
		pageLink("Types of Binary Trees");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.alertMessage(), output);
	}
	@Test(priority= 14,dataProvider = "EditorExcelValidData")
	public void implementationPythonValidTryEditor(String input,String output) {
		pageLink("Implementation in Python");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.output(), output);
	}
	
	@Test(priority= 15,dataProvider = "EditorExcelInvalidData")
	public void implementationPythoninvalidTryEditor(String input,String output) {
		pageLink("Implementation in Python");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.alertMessage(), output);
	}
	@Test(priority= 16,dataProvider = "EditorExcelValidData")
	public void binaryTreeTraversalsValidTryEditor(String input,String output) {
		pageLink("Binary Tree Traversals");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.output(), output);
	}
	
	@Test(priority= 17,dataProvider = "EditorExcelInvalidData")
	public void binaryTreeTraversalsinvalidTryEditor(String input,String output) {
		pageLink("Binary Tree Traversals");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.alertMessage(), output);
	}
	@Test(priority= 18,dataProvider = "EditorExcelValidData")
	public void implementationBinaryTreesValidTryEditor(String input,String output) {
		pageLink("Implementation of Binary Trees");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.output(), output);
	}
	
	@Test(priority= 19,dataProvider = "EditorExcelInvalidData")
	public void implementationBinaryTreesinvalidTryEditor(String input,String output) {
		pageLink("Implementation of Binary Trees");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.alertMessage(), output);
	}
	
	@Test(priority= 20,dataProvider = "EditorExcelValidData")
	public void applicationsBinaryTreesValidTryEditor(String input,String output) {
		pageLink("Applications of Binary trees");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.output(), output);
	}
	
	@Test(priority= 21,dataProvider = "EditorExcelInvalidData")
	public void applicationsBinaryTreesinvalidTryEditor(String input,String output) {
		pageLink("Applications of Binary trees");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.alertMessage(), output);
	}
	
	@Test(priority= 22,dataProvider = "EditorExcelValidData")
	public void binarySearchTreesValidTryEditor(String input,String output) {
		pageLink("Binary Search Trees");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.output(), output);
	}
	
	@Test(priority= 23,dataProvider = "EditorExcelInvalidData")
	public void binarySearchTreesinvalidTryEditor(String input,String output) {
		pageLink("Binary Search Trees");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.alertMessage(), output);
	}
	
	@Test(priority= 24,dataProvider = "EditorExcelValidData")
	public void implementationOfBSTValidTryEditor(String input,String output) {
		pageLink("Implementation Of BST");
		tree.pythonCodeFromExcel(input);
		Assert.assertEquals(tree.output(), output);
	}
	
	@Test(priority= 25,dataProvider = "EditorExcelInvalidData")
	public void implementationOfBSTinvalidTryEditor(String input,String output) {
		pageLink("Implementation Of BST");
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