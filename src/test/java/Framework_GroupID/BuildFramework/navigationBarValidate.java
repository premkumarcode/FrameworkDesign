package Framework_GroupID.BuildFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;


import pageObjectModel.loginPage;

public class navigationBarValidate extends base {
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
	public void navigationMenuValidate() throws IOException {		

		// Initialize the Classes required
		loginPage login_page = new loginPage(driver);	
		
		Assert.assertTrue(login_page.peakListElement().isDisplayed());
		Assert.assertTrue(login_page.climbersElement().isDisplayed());
		Assert.assertTrue(login_page.rangesElement().isDisplayed());
		Assert.assertTrue(login_page.geographyElement().isDisplayed());
		Assert.assertTrue(login_page.helpElement().isDisplayed());
		Assert.assertTrue(login_page.searchElement().isDisplayed());
		
		
	}
	

}
