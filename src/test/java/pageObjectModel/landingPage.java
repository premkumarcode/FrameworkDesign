package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	public WebDriver driver;
	
	
	
	//get login element details
	By loginLink = By.xpath("//a[contains(text(),'Log')]");
	
	public landingPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement loginLinkElement() {
		return driver.findElement(loginLink);
	}

}
