package dsAlgo_PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsAlgo_DriverFactory.Driver_Factory;


public class Home_PageFactory {
	
	public static final String optionList = null;
    WebDriver driver;
	WebDriverWait wait;
	
	public Home_PageFactory() {
	    driver=  Driver_Factory.getDriverInstance();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='btn']")
	WebElement btn;

	@FindBy(xpath = "//div[@id='navbarCollapse']/div[2]/ul/a[2]")
	WebElement register;

	@FindBy(xpath = "//div[@id='navbarCollapse']/div[2]/ul/a[3]")
	WebElement signIn;

	@FindBy(xpath = "//div[@id='navbarCollapse']/div[1]")
	WebElement dropDown;

	@FindBy(xpath = "//div[@id='navbarCollapse']/div[1]/div[1]/div[1]/a")

	List<WebElement> options;
	@FindBy(xpath = "//a[text()='Arrays']")
	WebElement arrayToSelect;
	@FindBy(xpath = "//a[text()='Linked List']")
	WebElement linkedListToSelect;
	@FindBy(xpath = "//a[text()='DataStructure']")
	WebElement dataStructureToSelect;
	@FindBy(xpath = "//a[text()='Stack']")
	WebElement stackToSelect;
	@FindBy(xpath = "//a[text()='Queue']")
	WebElement queueToSelect;
	@FindBy(xpath = "//a[text()='Tree']")
	WebElement treeToSelect;
	@FindBy(xpath = "//a[text()='Graph']")
	WebElement graphToSelect;

	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement warningMessage;
	@FindBy(xpath = "//h5[text()='Array']/../a")
	WebElement arrayBtn;

	@FindBy(xpath = "//h5[text()='Data Structures-Introduction']/../a")
	WebElement dataSttructureBtn;
	@FindBy(xpath = "//h5[text()='Stack']/../a")
	WebElement stackBtn;
	@FindBy(xpath = "//h5[text()='Queue']/../a")
	WebElement queueBtn;
	@FindBy(xpath = "//h5[text()='Tree']/../a")
	WebElement treeBtn;
	@FindBy(xpath = "//h5[text()='Linked List']/../a")
	WebElement graphBtn;

	public void clickStBtn() {
		btn.click();
	}

	public String clickStBtnString() {
		return btn.getText();
	}

	public String registerBtn() {
		String p = register.getText();
		return p;
	}

	public String signInBtn() {
		return signIn.getText();
	}

	public void dropDownClick() {
		dropDown.click();
	}

	public int getDropdownOptionsCount() {
		return options.size();
	}
	public List<String> getDropdownOptionsText() {
		List<String> optionText = new ArrayList<>();
		for (WebElement option : options) {
			optionText.add(option.getText().trim());
		}
		return optionText;
	}

	public List<String> getExpectedOptionsList(String optionList) {
		String[] optionsArray = optionList.split(",");
		List<String> expectedOptions = new ArrayList<>();
		for (String option : optionsArray) {
			expectedOptions.add(option.trim());
		}
		return expectedOptions;
	}

	public void arrayClick() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", arrayToSelect);
		wait.until(ExpectedConditions.elementToBeClickable(arrayToSelect)).click();
	}

	public void linkedListClick() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkedListToSelect);
		wait.until(ExpectedConditions.elementToBeClickable(linkedListToSelect)).click();
	}

	public void stackClick() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stackToSelect);
		wait.until(ExpectedConditions.elementToBeClickable(stackToSelect)).click();
	}
	public void dataStructureClick() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stackToSelect);
		wait.until(ExpectedConditions.elementToBeClickable(dataStructureToSelect)).click();
	}

	public void treeClick() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", treeToSelect);
		wait.until(ExpectedConditions.elementToBeClickable(treeToSelect)).click();
	}

	public void graphClick() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", graphToSelect);
		wait.until(ExpectedConditions.elementToBeClickable(graphToSelect)).click();
	}

	public void queueClick() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", queueToSelect);
		wait.until(ExpectedConditions.elementToBeClickable(queueToSelect)).click();
	}

	public String messageDisplayed() {
		 return warningMessage.getText();
	}
	public void home() {
		driver.get("https://dsportalapp.herokuapp.com/home");
	}

	public void clickArrayBtn() {
		arrayBtn.click();
	}

	public void clickDataStructureBtn() {
		dataSttructureBtn.click();
	}

	public void clickStackBtn() {
		stackBtn.click();
	}

	public void clickQueueBtn() {
		queueBtn.click();
	}

	public void clickTreeBtn() {
		treeBtn.click();
	}

	public void clickGraphBtn() {
		graphBtn.click();
	}
	public void getUrl() {
		driver.get("https://dsportalapp.herokuapp.com/");
	}

	public void currentURL() {
		driver.getCurrentUrl();
	}

}
