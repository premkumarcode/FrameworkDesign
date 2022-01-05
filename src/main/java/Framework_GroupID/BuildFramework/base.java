package Framework_GroupID.BuildFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base 
{
	public WebDriver driver;
	public Properties prop;

	public WebDriver intializeDriver() throws IOException {
		//Initializing to retrieve properties from data.properties file
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
//        mvn test -Dbrowser=chrome [Maven Command]
//		String browserName =System.getProperties("browser"); //Input from Jenkins / Maven commands
		String browserName = prop.getProperty("browser");
		String baseUrl = prop.getProperty("baseUrl");
		String chromeDriverPath=prop.getProperty("chromeDriverFilePath");
		String edgeDriverPath=prop.getProperty("edgeDriverFilePath");
		String geckoDriverPath=prop.getProperty("geckoDriverFilePath");
		Integer implicitTimeOut=Integer.parseInt(prop.getProperty("implicitTimeOut"));

		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",chromeDriverPath);
//			Below code to be used when chrome needs to be run in headless mode
//			ChromeOptions option = new ChromeOptions();
//			option.addArguments("headless");
//			driver = new ChromeDriver(option);
			
			driver = new ChromeDriver();
		}
		else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver",edgeDriverPath);
			driver = new EdgeDriver();
		}
		else if (browserName.equals("gecko")) {
			System.setProperty("webdriver.gecko.driver",geckoDriverPath);
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTimeOut));		
		return driver;

	}
	
	public String takeScreenshot(String fileName,WebDriver driver) throws IOException {
		System.out.println(fileName);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotFile =ts.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir") + "\\reports\\" + fileName + ".png";
		
		FileUtils.copyFile(screenshotFile, new File(destFile));
		return destFile;
	}

}
