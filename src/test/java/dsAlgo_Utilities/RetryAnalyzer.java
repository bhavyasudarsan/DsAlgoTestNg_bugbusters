package dsAlgo_Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentTest;
import dsAlgo_DriverFactory.Driver_Factory;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = Integer.parseInt(Driver_Factory.configReader.getRetry());    

    @Override
    public boolean retry(ITestResult result) {    	
        if (retryCount < maxRetryCount) {
            retryCount++;
            ITestResult currentResult = Reporter.getCurrentTestResult();
            ExtentTest test = (ExtentTest) currentResult.getAttribute("extentTest");
            test.skip("Retrying Test (" + retryCount + "/" + maxRetryCount + ")");
            
            return true;
        }
        return false;
    }
}