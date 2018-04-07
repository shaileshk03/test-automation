package Listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import Pages.TestBase;


public class Listener extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if(result.isSuccess()){
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			
			String methodName = result.getName();

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "E:/Selenium workspace/Amazon/src/main/resources/reports/reports";
				File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");
				
				FileUtils.copyFile(scrFile, destFile);
				
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if(!result.isSuccess()){
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			String methodName = result.getName();
			File scrFile = ((TakesScreenshot)
					        driver).getScreenshotAs(OutputType.FILE);
			try {
				String reportDirectory = new File(System.getProperty("user.dir"))
				.getAbsolutePath() + "E:/Selenium workspace/Amazon/src/main/resources/reports/reports";
				
				File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png");	
				FileUtils.copyFile(scrFile, destFile);
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		
	@Override
	public void onTestSkipped(ITestResult result) {

		Reporter.log("Test is skipped" + result.getMethod().getMethodName());	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {	
		
	}

	@Override
	public void onFinish(ITestContext context) {
	
	 Reporter.log("Test has been finished" + context.getName());
		
	}

	
}
