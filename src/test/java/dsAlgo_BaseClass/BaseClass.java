package dsAlgo_BaseClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import dsAlgo_DriverFactory.Driver_Factory;
import dsAlgo_PageFactory.Tree_PageFactory;
import dsAlgo_Utilities.ConfigReader;



public class BaseClass {
	
	Driver_Factory driverFactory;
	ConfigReader configReader;
	WebDriver driver;
	String url;
	

	public BaseClass() {
		this.driverFactory = new Driver_Factory();
		this.configReader = new ConfigReader();
	}
	
	@BeforeMethod
	public void setup() {
		String browser = Driver_Factory.getBrowserType();
		driver= driverFactory.driverSetup(browser);	
		url = configReader.getUrl();
		driver.get(url);
		System.out.println("Launched the application");
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	public void validLogin() {
		Tree_PageFactory tree =	new Tree_PageFactory();
		tree.clickSignin();
		String username=configReader.getUsername();
		tree.username(username);
		String password = configReader.getPassword();
		tree.password(password);
		tree.Loginbtn();
			
		
	}

}
