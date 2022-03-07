package com.qa.visulon.Listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.visulon.Utils.ConstantData;
import com.qa.visulon.basePackages.baseSetup;




public class Testlistener extends baseSetup implements ITestListener {

	WebDriver driver;
	private static ExtentReports reports = new ExtentReports();

	private static ExtentSparkReporter reporter = new ExtentSparkReporter(ConstantData.ExtentReport_path);

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Object currentclass = result.getInstance();

		WebDriver driver = ((baseSetup) currentclass).getDriver();

		System.out.println("***** Success " + result.getName() + " test has Passed *****");
		String methodName = result.getName().toString().trim();
		int status = result.getStatus();

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String ScreenshotDir="./PUMARegression/ExtentReport";
	      
		Object currentclass = result.getInstance();

		WebDriver driver = ((baseSetup) currentclass).getDriver();

		System.out.println("***** Error " + result.getName() + " test has failed *****");
		String methodname = result.getName().toString().trim();
		int status = result.getStatus();

		if (ITestResult.FAILURE == status) {
			Screenshot(driver, methodname);
			
			reports.attachReporter(reporter);
			reports.createTest(methodname)
			.log(Status.FAIL,result.getThrowable()).addScreenCaptureFromPath(ScreenshotDir+ methodname + ".png");
		
			reports.flush();
			             
		}
	}

	public void Screenshot(WebDriver driver, String methodname) {
		Date d = new Date();

		SimpleDateFormat s = new SimpleDateFormat("dd_MM_YYYY");

		String date = s.format(d);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(ConstantData.failure_screenshot + methodname + date + ".png");

		try {
			FileUtils.copyFile(src, dest);

			System.out.println("Successfully captured a screenshot");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception While taking screenshot" + e.getMessage());
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
