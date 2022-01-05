package Framework_GroupID.BuildFramework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger ;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectModel.landingPage;
import pageObjectModel.loginPage;

public class HomePage extends base {
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
	
	@Test(dataProvider="getData")
	public void homePageNavigation(String username,String password) throws IOException {
		
			
		
		// Initialize the Classes required
		landingPage landing_page = new landingPage(driver);
		loginPage login_page = new loginPage(driver);
		
		
		
		landing_page.loginLinkElement().click(); 
		
		//Login with valid user name and password
		login_page.setUsername().sendKeys(username);
		login_page.setPassword().sendKeys(password);
		login_page.clickLoginButton().click();
		Assert.assertEquals(login_page.loginSuccessMsg().getText(), "Successful Login!");
		Assert.assertTrue(login_page.peakListElement().isDisplayed());
		Assert.assertTrue(login_page.climbersElement().isDisplayed());
		Assert.assertTrue(login_page.rangesElement().isDisplayed());
		Assert.assertTrue(login_page.geographyElement().isDisplayed());
		Assert.assertTrue(login_page.helpElement().isDisplayed());
		Assert.assertTrue(login_page.searchElement().isDisplayed());
		
		
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] user_data = new Object[1][2];
		
		user_data[0][0]="premkumar.h@gmail.com";
		user_data[0][1]="Passw0rd";
		
		return user_data;
	}

}
