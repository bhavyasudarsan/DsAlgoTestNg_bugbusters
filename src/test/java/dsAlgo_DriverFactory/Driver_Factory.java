package dsAlgo_DriverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dsAlgo_Utilities.ConfigReader;

public class Driver_Factory {

	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
	public static ConfigReader configReader = new ConfigReader();
	private static final Logger logger = LoggerFactory.getLogger(Driver_Factory.class);
	public final static int TIMEOUT = 2;
	static String browserType = null;

	public static void setBrowserType(String browser) {
		browserType = browser;
	}

	public static String getBrowserType() {
		if (browserType == null) {
			try {
				browserType = configReader.getBrowser();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return browserType;
	}

	public WebDriver driverSetup(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			threadDriver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("Firefox")) {
			threadDriver.set(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase("Edge")) {
			threadDriver.set(new EdgeDriver());
		} else {
			threadDriver.set(new ChromeDriver());
		}
		threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
		threadDriver.get().manage().window().maximize();
		logger.info("Driver initialised with browser as:  "  +browser) ;
		return threadDriver.get();
	}

	public static WebDriver getDriverInstance() {
		return threadDriver.get();
	}

	public String getTitle() {
		return threadDriver.get().getTitle();
	}

}
