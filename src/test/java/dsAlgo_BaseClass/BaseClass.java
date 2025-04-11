package dsAlgo_BaseClass;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import dsAlgo_DriverFactory.Driver_Factory;
import dsAlgo_PageFactory.Login_PageFactory;
import dsAlgo_Utilities.ConfigReader;

public class BaseClass {
	
	Driver_Factory driverFactory;
	ConfigReader configReader;
	WebDriver driver;
	String url;
  private static final Logger logger = LoggerFactory.getLogger(BaseClass.class);

	public BaseClass() {
		this.driverFactory = new Driver_Factory();
		this.configReader = new ConfigReader();
	}
	
	@BeforeMethod  
	public void setup() {
		try {
		String browser = Driver_Factory.getBrowserType();
		driver= driverFactory.driverSetup(browser);	
		url = this.configReader.getUrl();
		driver.get(url);
    logger.info("Launched the application");
		}catch(Exception e) {
			System.out.println("exception: "+ e);
		}
	}
	

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	public void validLogin() {
		Login_PageFactory login =	new Login_PageFactory();
		login.openHome();
		login.ClickSignIn();
		String username=configReader.getUsername();
		login.SetUserName(username);
		String password = configReader.getPassword();
		login.SetPassword(password);
		login.ClickBtnLogin();		
		
	}
	
	@BeforeTest
	@Parameters("browserType")
	public void browserChange(@Optional() String browserType) {
	
	   if (browserType != null && !browserType.equals("param-val-not-found")) {		   
	   Driver_Factory.setBrowserType(browserType);	 
	    }
	}


}