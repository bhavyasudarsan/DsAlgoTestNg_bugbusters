package dsAlgo_Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import dsAlgo_DriverFactory.Driver_Factory;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = Integer.parseInt(Driver_Factory.configReader.getRetry());    

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}