package Framework_GroupID.BuildFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;



public class validateTitle extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void intialize() throws IOException {
		driver = intializeDriver();
		log.info("Driver successfully intialized");
		driver.get(prop.getProperty("baseUrl"));
		log.info(prop.getProperty("baseUrl") + " successfully launched");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Browser is closed successfully");
	}
	
	@Test
	public void validateHomepageTitle() throws IOException {	
				
		System.out.println(System.getProperty("user.dir"));
		// Initialize the Classes required


		Assert.assertEquals(driver.getTitle(), "1Peakbagger.com Home Page");
		log.info("Assertion for title - " + driver.getTitle() + " is success");
		
		
		
		
	}
	


}
