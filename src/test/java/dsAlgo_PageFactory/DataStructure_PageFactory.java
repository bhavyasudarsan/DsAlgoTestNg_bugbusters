package dsAlgo_PageFactory;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import dsAlgo_DriverFactory.Driver_Factory;
import dsAlgo_Utilities.ConfigReader;


public class DataStructure_PageFactory {
	
	WebDriver driver ;
	WebDriverWait wait;
	String expectedResult;
	String inputText;
	ConfigReader configReader = new ConfigReader();
	
	public DataStructure_PageFactory() {
		
	    driver=  Driver_Factory.getDriverInstance();
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(xpath = "//button[@class='btn']")WebElement getStartBtn;
	@FindBy(linkText = "Get Started")WebElement getStart;
	@FindBy(linkText = "Sign in")WebElement signIn;
	@FindBy(id = "id_username")WebElement userName;
	@FindBy(id = "id_password")WebElement password;
	@FindBy(xpath = "//input[@type=\"submit\"]")WebElement login;
	@FindBy(xpath = "//*[@class ='alert alert-primary']")WebElement loginStatus;
	@FindBy(xpath = "//a[@href='data-structures-introduction']")WebElement data_structureGetSatrted;
	@FindBy(xpath = "//a[@href='/data-structures-introduction/practice']")WebElement practiceQuestion;
	@FindBy(xpath = "//a[@href='time-complexity']")WebElement timeComplexity;
	@FindBy(linkText="Try here>>>")WebElement timeComplexityTryhere;
	@FindBy(xpath = "//div[@class='CodeMirror-code']")WebElement textEditor;
	@FindBy(xpath = "//pre[@id='output']")WebElement console;
	@FindBy(xpath = "//button[text()='Run']")WebElement runButton;

	
	public void ClickGetStBtn() {
		getStartBtn.click();
	}

	public void SignBtn() {
		signIn.click();
	}
	public void enterCredentials(String loginName, String loginPassword) {

		userName.sendKeys(loginName);
		password.sendKeys(loginPassword);
	}
	public void Loginbtn() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(login)).click();
	}
	
	public String getStatus() {

		return loginStatus.getText();
	}
	
	public void data_structureGetSatrted() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(data_structureGetSatrted)).click();
	}
	
	public void practiceQuestion() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(practiceQuestion)).click();
	}
	
	public void timeComplexity() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		timeComplexity.click();
	}
	
	public void timeComplexityTryhere() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)", "");
		timeComplexityTryhere.click();
	}  
	public void textEditorWithNoData() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)", "");
		
		Actions actions = new Actions(driver);
        actions.moveToElement(textEditor).click().sendKeys(" ").build().perform();
		runButton.click();
	}  
	
	public void textEditorWithInvalidData() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)", "");
		
		Actions actions = new Actions(driver);
        actions.moveToElement(textEditor).click().sendKeys("Hiiii").build().perform();
		runButton.click();
	}  
	public void textEditorWithValiddData() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)", "");
		
		Actions actions = new Actions(driver);
        actions.moveToElement(textEditor).click().sendKeys("print(\"Hello\")").build().perform();
		runButton.click();
	} 
	
	public String alertMessage() {
	
		try {
		    String alertMessage = driver.switchTo().alert().getText();
		    driver.switchTo().alert().accept();
		    System.out.println(alertMessage);
		    return alertMessage;
		    
		} catch (NoAlertPresentException e) {
			
			 return "No alert found.";
		}
	}
	
	public void Alertaccept() {
		 try {
			 driver.switchTo().alert().accept();
		 }
		 catch (NoAlertPresentException e) {
			 //No alert found.
		 }
	 }
	
	public void inputEditor(String code) {

		Actions actions = new Actions(driver);
		actions.moveToElement(textEditor).click().sendKeys(code).build().perform();
	}
	
	public void runBtnClick() {
		
		runButton.click();
	}
	
	public String console() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String output = console.getText();
		System.out.println(output);
		return output;
	}
	
	public String getTitle() {
		
		return driver.getTitle();	
	}

}

