package assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignment.utils.CommonAbstractMethods;

public class CheckOutPage extends CommonAbstractMethods{
	WebDriver driver;
	 /**
     * Constructor for CheckOutPage.
     * Initializes WebDriver and PageFactory elements.
     */
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

    // Locator for "Place Order" button which takes the user to payment page
	@FindBy(css = "a[href='/payment']")
	private WebElement placeOrderButton;

	//Places the order by clicking on the "Place Order" button
	public PaymentConfirmation orderPlacing() {
		//scrollDownToPage(0,500);
		scrollToAnElement(placeOrderButton);
		waitForElementToBeClickable(placeOrderButton);
		placeOrderButton.click();
		return new PaymentConfirmation(driver);
		
	}
	
	
	
}
