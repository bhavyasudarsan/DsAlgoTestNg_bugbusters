package dsAlgo_PageFactory;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import dsAlgo_DriverFactory.Driver_Factory;
import dsAlgo_Utilities.ConfigReader;

public class Login_PageFactory {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	static ConfigReader configReader = new ConfigReader();
	
	 public Login_PageFactory ()
	 {
	   driver = Driver_Factory.getDriverInstance();
	   PageFactory.initElements(driver, this);		 
	 }
	 
	 @FindBy(xpath="//input[@name='username']")
	 @CacheLookup
	 public WebElement inputUsername;
	 
	 @FindBy(xpath ="//input[@name='password']")
	 @CacheLookup
	 public WebElement inputPassword;
	 
	 @FindBy(xpath="//input[@type='submit']")
	 @CacheLookup
	 WebElement btnLogin; 
	 
	 @FindBy(xpath="//*[text()='Sign in']")
	 @CacheLookup
	 WebElement SignIn;	
	 
	 @FindBy(xpath="//*[text()='Sign out']")
	 @CacheLookup
	 WebElement SignOut;
	
	 @FindBy(xpath="//div[@class='alert alert-primary']")
	 @CacheLookup
	 WebElement Alertmsg;
	 
	   
	 public void openHome() {
	  driver.get(configReader.getHomeUrl());
	 }
	 
	 public void openLogin() {
	  driver.get(configReader.getLoginUrl());
	 }
	 
	 public String getTitle() {
	  return driver.getTitle();
	 }
	 
	 public void SetUserName(String uName) {
	  wait.until(ExpectedConditions.visibilityOf(inputUsername)).clear();		 
	  inputUsername.sendKeys(uName);
	 }
	   
	 public void SetPassword(String pwd) {
	  inputPassword.clear();
	  inputPassword.sendKeys(pwd);
	 }  
	 
	 public void ClickBtnLogin() {
	  btnLogin.click();
	 }
	 
	 public String getErrMsg() {			 
	   return wait.until(ExpectedConditions.visibilityOf(Alertmsg)).getText();  
	 }
	 	 
	 public void ClickSignIn() {
		  SignIn.click();
		 }
	 
	 public void ClickSignOut() {
		 wait.until(ExpectedConditions.elementToBeClickable(SignOut)).click(); 
		 }
	 
	 public String getValidationMessage(WebElement element) {
	  return (String) ((JavascriptExecutor) driver).executeScript(
	       "return arguments[0].validationMessage;", element);
	    }
}
