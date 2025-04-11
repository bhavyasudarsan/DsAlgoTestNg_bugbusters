package dsAlgo_PageFactory;

import java.time.Duration;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import dsAlgo_DriverFactory.DriverFactory;
import dsAlgo_DriverFactory.Driver_Factory;

public class Stack_PageFactory {
	
	WebDriver driver;
	WebDriverWait wait;
 
	public Stack_PageFactory() {
		driver = Driver_Factory.getDriverInstance();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//button[@class='btn']")
	WebElement getStartBtn;
	@FindBy(xpath = "//div[@class='nav-item dropdown']")
	WebElement dropdownMenu;

	@FindBy(xpath = "//a[text()='Stack']")
	WebElement selectStackFromDropdoMenu;

//	@FindBy(xpath = "//button[@class='btn']")
//	WebElement getStartBtn;

	@FindBy(xpath = "//a[text()='Sign in']")
	WebElement signIn;

	@FindBy(xpath = "//div[@class='bs-example']")
	WebElement loginPage;

//	@FindBy(name = "username")
//	WebElement userName;
//
//	@FindBy(name = "password")
//	WebElement passWord;
//
//	@FindBy(xpath = "//input[@type=\"submit\"]")
//	WebElement login;

	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement status;

	@FindBy(xpath = "//h5[text()='Stack']/../a")
	WebElement getStartedStackBtn;

	@FindBy(xpath = "//div[@class='nav-item dropdown']")
	WebElement dropdownMenuStack;
	@FindBy(xpath = "//title[text()='NumpyNinja']")
	WebElement titleHome;

	@FindBy(xpath = "//a[text()='Stack']")
	WebElement selectStackFromDropdownMenu;

	@FindBy(xpath = "//h4[@class='bg-secondary text-white']")
	WebElement title;

	@FindBy(xpath = "//a[@href='introduction']")
	WebElement introduction;

	@FindBy(xpath = "//a[text()='Operations in Stack']")
	WebElement operationLinkBtn;
	@FindBy(xpath = "//p[text()='Operations in Stack']")
	WebElement operationInStackPageIdentifier;
	@FindBy(name = "username")
	WebElement userName;
	@FindBy(name = "password")
	WebElement passWord;
	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement login;
	@FindBy(xpath = "//a[text()='Try here>>>']")
	WebElement tryHereBtn;
	@FindBy(xpath = "//button[text()='Run']")
	WebElement runBtn;
	@FindBy(xpath = "//div[@class='CodeMirror cm-s-default']\r\n")
	WebElement tryEditor;
	@FindBy(xpath = "//div[@class='CodeMirror-code']")
	WebElement tryEditorInput;
	@FindBy(xpath = "//pre[@id='output']")
	public WebElement tryEditorConsole;

	@FindBy(xpath = "//a[text()='Implementation']")
	WebElement linkImplementation;
	@FindBy(xpath = "//p[text()='Implementation']")
	WebElement implementationPageIdentifier;
	@FindBy(xpath = "//a[text()='Applications']")
	WebElement linkApplication;
	@FindBy(xpath = "//p[text()='Applications']")
	WebElement applicationsPageIdentifier;
	@FindBy(xpath = "//*[text()='Practice Questions']")
	WebElement linkPracticeQstn;
	@FindBy(xpath = "/html/head/title")
	WebElement linkPracticeQstnPageIdentifier;
	


	public void dropDownStack() {
		dropdownMenu.click();
	}

	public void dropDownSelectStack() {
		selectStackFromDropdoMenu.click();
	}

	public void clickGetStartedStackBtn() {
		getStartedStackBtn.click();
	}

	public String statusMessage() {
		return status.getText();
	}

	public String titleStack() {
		return title.getText();
	}

	public void operationLinkBtnClick() {
		operationLinkBtn.click();
	}

	public String stackPageIdentify() {
		return operationInStackPageIdentifier.getText();
	}

	public void tryHereBtnClick() {
		tryHereBtn.click();
	}

	public void runBtnClick() {
		runBtn.click();
	}

	public String runBtnText() {
		return runBtn.getText();
	}
	public String alertMessage() {
		try {
		    String alertMessage = driver.switchTo().alert().getText();
//		    driver.switchTo().alert().accept();
		    return alertMessage;
		} catch (NoAlertPresentException e) {
			 return "No alert found.";
		}
	}
	public void inputEditor(String inputText) {

		Actions actions = new Actions(driver);
		actions.moveToElement(tryEditorInput).click().sendKeys(inputText).build().perform();
	}

	public String console() {
		return tryEditorConsole.getText();
	}

	public void linkImplementationClick() {
		linkImplementation.click();
	}

	public String implementationPageIdentify() {
		return implementationPageIdentifier.getText();
	}
 
	public void linkPracticeQstnClick() {
		linkPracticeQstn.click();
	}
	public String linkPracticeQstnPageIdentify() {
		return linkPracticeQstnPageIdentifier.getText();
	}
 


	public void linkApplicationClick() {
		linkApplication.click();
	}

	public String applicationPageIdentify() {
		return applicationsPageIdentifier.getText();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

	public void ClickGetStBtn() {
		getStartBtn.click();
		
	}

	public void SignBtn() {
		signIn.click();
		
	}

	public void username(String username) {
		userName.sendKeys(username);
		
	}

	public void password(String password) {
		passWord.sendKeys(password);
		
	}
	public void Loginbtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(login)).click();
	}



}
