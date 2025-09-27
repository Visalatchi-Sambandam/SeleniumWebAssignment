package assignment.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignment.utils.CommonAbstractMethods;

public class CartCatalogue extends CommonAbstractMethods{

	WebDriver driver;
	  /**
     * Constructor for CartCatalogue.
     * Initializes WebDriver and PageFactory elements.
     */
	public CartCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	// List of product elements currently displayed in the cart
	@FindBy(xpath = "//h4/a")
	List<WebElement> cartProductList;
	 // WebElement representing the checkout button/link
	@FindBy(css = "a[class*='check_out']")
	WebElement checkOut;

	/**
     * Verifies if a product with the given name is present in the cart.
     * @return true if product is found in the cart, false otherwise.
     */
	public Boolean verifyProductAddedToCart(String productName) {
		waitForVisibilityOfAllElements(cartProductList);
		Boolean isProductPresent = cartProductList.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return isProductPresent;		
	}

	//Clicks on the checkout button and navigates to the CheckOutPage.
	public CheckOutPage proceedToCheckOut() {
		checkOut.click();
		return new CheckOutPage(driver);
	}

	
}
