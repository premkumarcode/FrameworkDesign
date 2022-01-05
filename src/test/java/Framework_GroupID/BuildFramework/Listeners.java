package Framework_GroupID.BuildFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.Writable;

import resources.ExtentReporter;

public class Listeners extends base implements ITestListener{
	public static Logger log = LogManager.getLogger(base.class.getName()); //Initialize for the log4j
	
	ExtentReports extent = ExtentReporter.getReportObject();
	ExtentTest extTest;
	ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<ExtentTest>(); //To make the thread safe when the test are run in parallel to avoid overriding
	@Override
	public void onTestStart(ITestResult result) {
		extTest = extent.createTest(result.getMethod().getMethodName());
		threadLocal.set(extTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info(result.getMethod().getMethodName() + "- Successfully executed");
		threadLocal.get().log(Status.PASS, result.getMethod().getMethodName() + "- Successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		threadLocal.get().fail(result.getThrowable());
		
		
		System.out.println(result.getMethod().getMethodName());
		String screenshotFileName = result.getMethod().getMethodName();
		try {
			
			//Below statement to get access to field names of the class
			WebDriver driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			String destPath= takeScreenshot(screenshotFileName,driver);
			threadLocal.get().addScreenCaptureFromPath(destPath, screenshotFileName);
			
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
