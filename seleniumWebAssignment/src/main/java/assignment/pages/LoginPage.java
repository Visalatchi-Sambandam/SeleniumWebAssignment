package assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignment.utils.CommonAbstractMethods;

	public class LoginPage extends CommonAbstractMethods {

	    WebDriver driver;

	    /**
	     * Constructor for LoginPage.
	     * Initializes WebDriver and PageFactory elements.
	     * 
	     * @param driver WebDriver instance passed from test
	     */
	    public LoginPage(WebDriver driver) {
	        super(driver);   // Calls parent constructor (likely with common utility methods)
	        this.driver = driver;   // Keeps local reference of WebDriver
	        PageFactory.initElements(driver, this);   // Initializes @FindBy elements
	    }
	    
	    // Locator for the login email input field
	    @FindBy(name = "email")
	    private WebElement loginEmail;
	    
	    // Locator for the login password input field
	    @FindBy(xpath = "//input[@type='password']")
	    private WebElement loginPassword;
	    
	    // Locator for the login button
	    @FindBy(xpath = "//button[@data-qa='login-button']")
	    private WebElement loginButton;

	    //Launches the website and opens the login page.
	    public void launchWebsite() {
	        driver.get("https://automationexercise.com/login");
	    }

	   // Enters the provided credentials and logs in.
	  //@return HomePage instance (next page after login)
	    public HomePage credentialsToLogin(String email, String password) {
	        loginEmail.sendKeys(email);
	        loginPassword.sendKeys(password);
	        loginButton.click();
	        return new HomePage(driver);
	    }
	
	
	
	

}
