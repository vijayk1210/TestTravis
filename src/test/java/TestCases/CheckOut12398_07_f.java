package TestCases;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utility.Base;
import Utility.ExtentTestManager;
import Utility.util;
import applicationUtility.appFunctions;

import com.relevantcodes.extentreports.LogStatus;

public class CheckOut12398_07_f extends Base {
	
  @Test
  public void verifyOrderCompletion() throws InterruptedException, AWTException {
	  String order = null;
	  String checkOrderLinkText = "Bestellverlauf überprüfen";
	  String actualCheckOrderText = null;
	  String thankYouText = "Vielen Dank für Ihre Bestellung!";
	  String actualThankYouText = null;
	  List<WebElement> orderSummary = new ArrayList<WebElement>();
	  
      appFunctions.completeShippingProcess(util.getTestData("loginEmailCheckout"),util.getTestData("loginPasswordCheckout"));
	  
	  util.clickByXpath(weiterCart);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on continue on step 1 of checkout process on cart page.");
	  
	  util.clickByXpath(checkBoxTerms);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on terms and conditions checkbox.");
	  
	  util.clickByXpath(finalSubmit);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on final submit button at step 3.");
	  
	  Thread.sleep(3000);
	 // util.scrollTo();
	  util.switchToIframe(kalrnaIframe);
	  Thread.sleep(2000);
	  
	  util.getelement(util.getTestData("mode3"), paymentName);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Selected paymenmt by Cash.");
	  
	  util.clickByXpath(buyButton);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on buy button.");
	  driver.switchTo().defaultContent();
	  Thread.sleep(7000);
	  
	  order = util.getText(orderId);
		 
	  if(order.length()>0){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Order id id: "+order);  
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Order Id is missing.");  
	  }
	  
	  actualThankYouText = util.getText(thankYou);
	  if(actualThankYouText.equalsIgnoreCase(thankYouText)){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Thank you is getting displayed."); 
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Thank you is not getting displayed."); 
	  }
	  
	  orderSummary = util.getElements(OrderSummary);
	  if((orderSummary.size())>2){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Order Summary is getting displayed."); 
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Order Summary is not getting displayed."); 
	  }
	  
	  actualCheckOrderText = util.getText(checkOrderHistory);
	  if(actualCheckOrderText.contains(checkOrderLinkText)){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Check order history link is present.");
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Check order history link is missing.");
	  }
	  
	  
	  
  }
}
