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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
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
        result.setAttribute("extentTest", test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = Driver_Factory.getDriverInstance();
        if (driver != null && driver instanceof RemoteWebDriver) {
            SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
            if (sessionId != null) {
                try {
                    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    if (screenshotFile != null && screenshotFile.exists()) {
                        test.fail(result.getThrowable(),
                            MediaEntityBuilder.createScreenCaptureFromPath(screenshotFile.getAbsolutePath()).build());
                    }
                } catch (Exception e) {
                    System.out.println("Screenshot capture failed: " + e.getMessage());
                }
            } else {
                System.out.println("WebDriver session is null, skipping screenshot.");
            }
        }
    }
    
   @Override
    public void onTestSkipped(ITestResult result) {
        test.skip(result.getThrowable());        
    }

}