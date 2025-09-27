package assignment.tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import assignment.pages.CartCatalogue;
import assignment.pages.CheckOutPage;
import assignment.pages.HomePage;
import assignment.pages.LoginPage;
import assignment.pages.OrderAcknowledgePage;
import assignment.pages.PaymentConfirmation;
import assignment.pages.ProductCatalogue;
import assignment.utils.ExcelUtil;

public class PurchaseOrder extends BaseClass {
	/**
	 * End-to-end test: logs in, adds products to cart, checks out, places order,
	 * and validates order confirmation.
	 */

	@Test(dataProvider = "getData")
	public void purchaseOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		// Launch application and login
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.credentialsToLogin(input.get("email"), input.get("password"));

		// Navigate to products and add items
		ProductCatalogue productCatalogue = homePage.goToProductCatalogue();
		productCatalogue.addProductsToCart(input.get("product1"));
		productCatalogue.addProductsToCart(input.get("product2"));

		// Go to cart and verify products
		CartCatalogue cartCatalogue = homePage.goTocartPage();
		Boolean productMatch = cartCatalogue.verifyProductAddedToCart(input.get("product1"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(productMatch);
		Boolean productMatch2 = cartCatalogue.verifyProductAddedToCart(input.get("product2"));
		softAssert.assertTrue(productMatch2);

		// Proceed to checkout → payment → confirmation
		CheckOutPage checkOutPage = cartCatalogue.proceedToCheckOut();
		PaymentConfirmation paymentConfirm = checkOutPage.orderPlacing();
		OrderAcknowledgePage orderConfirm = paymentConfirm.enterCardDetails("Visali", "324556678972", 311, 07, 2027);

		// Validate order confirmation title & message
		String expectedTitle = "ORDER PLACED!";
		String actualTitle = orderConfirm.getTitle();
		softAssert.assertEquals(actualTitle, expectedTitle);

		String expectedMsg = "Congratulations! Your order has been confirmed!";
		String actualMsg = orderConfirm.getMessage();
		softAssert.assertEquals(actualMsg, expectedMsg);

		// Collates all soft assertions
		softAssert.assertAll();
	}

	// DataProvider for test data from Excel file.
	@DataProvider(name = "getData")
	public Object[][] getExcelData() {
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\purchaseOrderExcelData.xlsx";
		return ExcelUtil.getExcelData(path, "dataSheet");
	}
}
