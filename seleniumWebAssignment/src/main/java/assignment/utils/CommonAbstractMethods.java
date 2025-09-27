package assignment.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonAbstractMethods {
	WebDriver driver;
	JavascriptExecutor js;
	

    /**
     * Constructor for CommonAbstractMethods.
     * Initializes WebDriver and JavaScript executor.
     */
	public CommonAbstractMethods(WebDriver driver)
	{
		this.driver = driver;
		this.js = (JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
	}
	//Returns a timestamp
	public static String getTimeStamp() {
	        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

	    }
	
	//Waits for visibility of all elements in a list.
	public void waitForVisibilityOfAllElements(List<WebElement> listOfElements)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfElements));
	}
	//Waits until a WebElement is clickable.
	public void waitForElementToBeClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	//Scrolls down the page by given x and y offset.
	public void scrollDownToPage(int x, int y)
	{
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}
	
	//Scrolls top of the page by given x and y offset.
	public void scrollToTopOfPage(int x, int y)
	{
		js.executeScript("window.scroll(" + x + "," + y + ")");
	}
	
	//Scrolls until the element is in the viewport.
	public void scrollToAnElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	// Takes a screenshot and saves it under /target/screenshots with timestamp.
	public static void takeScreenshot(WebDriver driver, String testName)
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			String fileName = testName+"_"+getTimeStamp()+".png";
			FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"\\target\\screenshots\\"+fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
