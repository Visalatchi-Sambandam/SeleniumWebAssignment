package assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignment.utils.CommonAbstractMethods;

public class OrderAcknowledgePage extends CommonAbstractMethods{

	WebDriver driver;
	
	 /**
     * Constructor for OrderAcknowledgePage.
     * Initializes WebDriver and PageFactory elements.
     */
	public OrderAcknowledgePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	  // Locator for the title inside <h2> element where order confirmation is displayed
    @FindBy(xpath = "//h2[@data-qa='order-placed']/b")
    private WebElement actualTitle;
    
    // Locator for the message text that appears below the order placed title
    @FindBy(xpath = "//h2[@data-qa='order-placed']/following::p")
    private WebElement actualText;

    // Returns the title text shown in the confirmation message
    public String getTitle() {
        return actualTitle.getText();
    }

    // Returns the confirmation message text
    public String getMessage() {
        return actualText.getText();
    }
}


//driver.findElement(RelativeLocator.with(By.tagName("input")).below(username));