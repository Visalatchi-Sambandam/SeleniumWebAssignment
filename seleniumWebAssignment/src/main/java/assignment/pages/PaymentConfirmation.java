package assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assignment.utils.CommonAbstractMethods;

public class PaymentConfirmation extends CommonAbstractMethods{
	WebDriver driver;
	 /**
     * Constructor for PayemnetConfirmation.
     * Initializes WebDriver and PageFactory elements.
     */
	public PaymentConfirmation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	  // WebElement for cardholder's name input field
    @FindBy(name = "name_on_card")
    private WebElement cardName;

    // WebElement for card number input field
    @FindBy(name = "card_number")
    private WebElement cardNumber;

    // WebElement for CVC input field
    @FindBy(xpath = "//input[@data-qa='cvc']")
    private WebElement cvcDigit;

    // WebElement for card expiry month input field
    @FindBy(name = "expiry_month")
    private WebElement expireMonth;

    // WebElement for card expiry year input field
    @FindBy(name = "expiry_year")
    private WebElement expireYear;

    // WebElement for the button to confirm and submit the order
    @FindBy(id = "submit")
    private WebElement confirmOrderButton;

    // Fills in the card details and submits the payment to complete the order.
	
	public OrderAcknowledgePage enterCardDetails(String nameofCard, String cardNum, int cvc, int monthExpiry, int yearExpiry)
	{
		cardName.sendKeys(nameofCard);
		cardNumber.sendKeys(cardNum);
		cvcDigit.sendKeys(String.valueOf(cvc));
		expireMonth.sendKeys(String.valueOf(monthExpiry));
		expireYear.sendKeys(String.valueOf(yearExpiry));
		confirmOrderButton.click();
		return new OrderAcknowledgePage(driver);
	}
}
