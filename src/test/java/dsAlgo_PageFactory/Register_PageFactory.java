
package dsAlgo_PageFactory;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import dsAlgo_DriverFactory.Driver_Factory;

public class Register_PageFactory {
	
	WebDriver driver ;
	WebDriverWait wait;
	String expectedResult;
	String userName;
	String password;
	String ConfirmPassword;
	
	public Register_PageFactory() {
		
		driver=Driver_Factory.getDriverInstance();
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Get Started")WebElement getStart;
	@FindBy(xpath = "//a[@href='/register']")WebElement registerlink;
	@FindBy(id = "id_username")WebElement userNameElement;
	@FindBy(id = "id_password1")WebElement password1Element;
	@FindBy(id = "id_password2")WebElement password2Element;
	@FindBy(xpath = "//*[@value='Register']")WebElement btnRegister;
	@FindBy(xpath = "//*[@class ='alert alert-primary']")WebElement registerStatus;
	@FindBy(xpath = "//a[@href='/login']")WebElement SignInlink;
	@FindBy(xpath = "//div[@id='navbarCollapse']/div[1]")
	WebElement dropDown;
	List<WebElement> options;
	@FindBy(xpath = "//a[text()='Arrays']")
	WebElement arrayToSelect;
	@FindBy(xpath = "//a[text()='Linked List']")
	WebElement linkedListToSelect;
	@FindBy(xpath = "//a[text()='Stack']")
	WebElement stackToSelect;
	@FindBy(xpath = "//a[text()='Queue']")
	WebElement queueToSelect;
	@FindBy(xpath = "//a[text()='Tree']")
	WebElement treeToSelect;
	@FindBy(xpath = "//a[text()='Graph']")
	WebElement graphToSelect;

	public void getStart() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(getStart)).click();
	}

	public void registerlink() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(registerlink)).click();
	}
	public void enterCredentials(String userName, String Password1, String Password2){
		
		userNameElement.sendKeys(userName);
		password1Element.sendKeys(Password1);
		password2Element.sendKeys(Password2);
	}
	public void clickRegister() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(btnRegister)).click();
	}
	
	public void SigninlinkIn() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		SignInlink.click();
	}
	
	public String alertMessage() {
		
		try {
			
		    String alertMessage = driver.switchTo().alert().getText();
		    driver.switchTo().alert().accept();
		    System.out.println("Invalid data \n");
		    return alertMessage;
		    
		} catch (NoAlertPresentException e) {
			
			 return "No alert found.";
		}
	}
	public String getValidationMessage() {
		
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", userNameElement);
    }
	
	public String getValidationMessagePwd() {
		
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", password1Element);
    }
	
	public String getValidationMessagePwd2() {
		
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", password2Element);
    }
	
	public String getTitle() {
		
		return driver.getTitle();
	}
	
	public void dropDownClick() {
		
		dropDown.click();
	}
	public void arrayClick() {
		
		arrayToSelect.click();
	}

	public void linkedListClick() {
		
		linkedListToSelect.click();
	}

	public void stackClick() {
		
		stackToSelect.click();
	}

	public void treeClick() {
		
		treeToSelect.click();
	}

	public void graphClick() {
		
		graphToSelect.click();
	}

	public void queueClick() {
		
		queueToSelect.click();
	}
	
}
