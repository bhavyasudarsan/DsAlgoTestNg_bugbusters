package dsAlgo_Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import dsAlgo_DriverFactory.Driver_Factory;
import tech.grasshopper.reporter.ExtentPDFReporter;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

public class ExtentReporter implements ISuiteListener, ITestListener {
    private ExtentReports extent;
    private ExtentTest test;    

    @Override
    public void onStart(ISuite suite) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent.html");
        ExtentPDFReporter pdfReporter = new ExtentPDFReporter("extent.pdf");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter, pdfReporter);
    }

    @Override
    public void onFinish(ISuite suite) {
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {        
        WebDriver driver = Driver_Factory.getDriverInstance();
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		if (screenshotFile != null && screenshotFile.exists()) {	
            test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotFile.getAbsolutePath()).build());
		}
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip(result.getThrowable());
    }

}