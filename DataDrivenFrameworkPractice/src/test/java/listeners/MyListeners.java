package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.Base;
import util.ExtentReporter;

public class MyListeners extends Base implements ITestListener {
	
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	public void onTestStart(ITestResult result) {
		extentTest=extentReport.createTest(result.getName());
		}
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test Passed");
		}
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, "Test got failed");
		extentTest.fail(result.getThrowable());
		}
	public void onTestSkipped(ITestResult result) {
		}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		}
	public void onTestFailedWithTimeout(ITestResult result) {
	}
	public void onStart(ITestContext context) {
		
	}
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}
	

	
}
