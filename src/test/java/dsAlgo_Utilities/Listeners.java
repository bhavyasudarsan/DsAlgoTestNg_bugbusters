package dsAlgo_Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	private static final Logger logger = LoggerFactory.getLogger(Listeners.class);

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("From Listner- Test Started:" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("From Listner- Test Failed:" + result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("From Listner- Test Skipped:" + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("From Listner- Test Success:" + result.getName());

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("");
		logger.info("From Listner- Test suite started:" + context.getName());

	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("From Listner- Test is finished:" + context.getName());

	}
}
