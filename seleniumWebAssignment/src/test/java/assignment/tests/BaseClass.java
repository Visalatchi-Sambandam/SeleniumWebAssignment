package assignment.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import assignment.pages.LoginPage;

public class BaseClass {
	public WebDriver driver;
	protected JavascriptExecutor js;
	
	 /**
     * Initializes WebDriver based on browser name provided in global.properties.
     * Supports Chrome, Edge, and Firefox.
     */
	public WebDriver initializeDriver() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();

	        // Disable notifications
	        options.addArguments("--disable-notifications");

	        // Disable pop-up blocking
	        options.addArguments("--disable-popup-blocking");

	        // Disable info bars (like “Chrome is being controlled by automated test software”)
	        options.addArguments("disable-infobars");

			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		//Maximizing and applying the implicit wait for page loading purpose
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	//Launches the application login page.
	@BeforeMethod(alwaysRun=true)
	public void launchApplication() throws IOException
	{
		driver = initializeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.launchWebsite();
		
	}
	
	//Closing the browser after executing the test
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
	}

}
