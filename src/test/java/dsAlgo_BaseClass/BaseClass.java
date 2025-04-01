package dsAlgo_BaseClass;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import dsAlgo_DriverFactory.Driver_Factory;
//import dsAlgo_Utilities.ConfigReader;

public class BaseClass {
	private static final Logger logger = LoggerFactory.getLogger(BaseClass.class);

	Driver_Factory driverFactory;
	WebDriver driver;
	
	public BaseClass() {
		this.driverFactory = new Driver_Factory();
	}
	
	@BeforeMethod
	public void setup() {
		String browser = Driver_Factory.getBrowserType();
		driver= driverFactory.driverSetup(browser);	
		driver.get(Driver_Factory.configReader.getUrl());
		logger.info("Launched the application");
	}
	
	

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
