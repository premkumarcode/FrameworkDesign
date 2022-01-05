package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	 
	public static ExtentReports getReportObject() {		
		String reportPath=System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Peak Bagger - Test Execution Report");
		reporter.config().setDocumentTitle("Daily Execution Report");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Prem Kumar");
		
		return extent;
	}

}
