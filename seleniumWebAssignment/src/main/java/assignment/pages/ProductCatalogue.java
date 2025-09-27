package assignment.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignment.utils.CommonAbstractMethods;

public class ProductCatalogue extends CommonAbstractMethods{
	
	WebDriver driver;
	 /**
     * Constructor for ProductCatalogue.
     * Initializes WebDriver and PageFactory elements.
     */
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	  // WebElements representing the list of all product cards on the page
    @FindBy(xpath = "//div[@class='productinfo text-center']")
    private List<WebElement> productList;

    // WebElement representing the 'Continue Shopping' button that appears after adding a product to cart
    @FindBy(xpath = "//button[text()='Continue Shopping']")
    private WebElement continueShopping;

    // Locator for the 'Add to Cart' button inside a product card
    By addToCartButton = By.cssSelector("a[class*='add-to-cart']");

    // Locator to identify product name element within a product card
    By productFinder = By.cssSelector("p");
	

    /**
     * Adds a product with the specified name to the cart.
     * And clicks 'Continue Shopping' to return to the product catalogue
     */
	public void addProductsToCart(String productName) {
		waitForVisibilityOfAllElements(productList);
		WebElement product = productList.stream().filter(products -> products.findElement(productFinder).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		if (product != null) {
		    scrollToAnElement(product);
		    product.findElement(addToCartButton).click();
		    continueShopping.click();
		} else {
			System.out.println("Product is not Found");
		}
	}
	
	

}
