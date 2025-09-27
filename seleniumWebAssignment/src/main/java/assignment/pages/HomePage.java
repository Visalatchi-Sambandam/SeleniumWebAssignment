package assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignment.utils.CommonAbstractMethods;

public class HomePage extends CommonAbstractMethods{

	WebDriver driver;
	 /**
     * Constructor for HomePage.
     * Initializes WebDriver and PageFactory elements.
     */
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	  // Locator for "Products" link in navigation menu
    @FindBy(xpath = "//a[contains(@href,'/products')]")
    private WebElement productsPageLink;
    
    // Locator for "Cart" link in navigation menu
    @FindBy(xpath = "//a[contains(@href,'/view_cart')]")
    private WebElement cartPageLink;

    // Navigates from Home Page to Product Catalogue page.
	public ProductCatalogue goToProductCatalogue() {
		productsPageLink.click();
		return new ProductCatalogue(driver);
		
	}
	 // Navigates from Home Page to Cart Catalogue page.
	public CartCatalogue goTocartPage() {
		scrollToTopOfPage(0,0);
		cartPageLink.click();
		return new CartCatalogue(driver);
		
	}

	
	
	

}
