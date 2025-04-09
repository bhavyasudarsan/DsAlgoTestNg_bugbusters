package dsAlgo_Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentTest;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    static ConfigReader configReader = new ConfigReader();
    private static final int maxRetryCount = Integer.parseInt(configReader.getRetry());    

    @Override
    public boolean retry(ITestResult result) {    	
        if (retryCount < maxRetryCount) {
            retryCount++;
            ITestResult currentResult = Reporter.getCurrentTestResult();
            ExtentTest test = (ExtentTest) currentResult.getAttribute("extentTest");
            if (test != null)
            	test.skip("Retrying Test (" + retryCount + "/" + maxRetryCount + ")");
            
            return true;
        }
        return false;
    }
}