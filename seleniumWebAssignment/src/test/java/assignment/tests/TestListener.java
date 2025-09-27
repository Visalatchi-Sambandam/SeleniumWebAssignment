package assignment.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import assignment.utils.CommonAbstractMethods;

public class TestListener extends BaseClass implements ITestListener{
	
	 public void onTestStart(ITestResult result) {
		  System.out.println("🚀 Starting Test: " + result.getName()); 
		  }

	 public void onTestSuccess(ITestResult result) {
		  System.out.println("✅ Test Passed: " + result.getName());
		  }

	 public void onTestFailure(ITestResult result) { System.out.println("❌ Test Failed: " + result.getName());
     if(ITestResult.FAILURE == result.getStatus())
    	 {Object testClass = result.getInstance();
     WebDriver driver = ((BaseClass) testClass).driver;
     CommonAbstractMethods.takeScreenshot(driver, result.getName() + "_FAIL");
		  }
	 }

	 public void onTestSkipped(ITestResult result) {
		    // not implemented
		  }
	 public void onFinish(ITestContext context) {
		    // not implemented
		  }
	

}
