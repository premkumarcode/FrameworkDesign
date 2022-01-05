package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	public WebDriver driver;
	
	
	
	//get user name,password and login element details
	By userName = By.id("EmailTextBox");
	By password = By.name("PasswordTextBox");
	By loginButton = By.xpath("//input[@name='GoButton']");
	By loginMessage = By.id("MessageBox");
	By peakList = By.xpath("//a[text()='Peak Lists']");
	By climbers = By.xpath("//a[text()='Climbers']");
	By ranges = By.xpath("//a[text()='Ranges']");
	By geography = By.xpath("//a[text()='Geography']");
	By help = By.xpath("//a[text()='Help']");
	By search = By.xpath("//a[text()='Search']");
	
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement setUsername() {
		return driver.findElement(userName);
	}
	
	public WebElement setPassword() {
		return driver.findElement(password);
	}

	public WebElement clickLoginButton() {
		return driver.findElement(loginButton);
	}

	public WebElement loginSuccessMsg() {
		return driver.findElement(loginMessage);
	}
	
	public WebElement peakListElement() {
		return driver.findElement(peakList);
	}
	
	public WebElement climbersElement() {
		return driver.findElement(climbers);
	}
	
	public WebElement rangesElement() {
		return driver.findElement(ranges);
	}
	
	public WebElement geographyElement() {
		return driver.findElement(geography);
	}
	
	public WebElement helpElement() {
		return driver.findElement(help);
	}
	
	public WebElement searchElement() {
		return driver.findElement(search);
	}
	
	

}
