package TestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import applicationUtility.appFunctions;

import com.relevantcodes.extentreports.LogStatus;

import PageObjects.DeletingTrashdata;
import Utility.Base;
import Utility.ExtentTestManager;
import Utility.util;

public class CheckOut12398_07_d extends Base {
	
  @Test (enabled=true)
  public void verifySummary() throws InterruptedException {
	  String amountShip = null;
	  String order = null;
	  String emailUrl = "https://www.mailinator.com/";
	  List<WebElement> ls = new ArrayList<WebElement>();
	  int initialCount;
	  int afterCount;
	  String finalValue = null;
	  String finalValueEmail = null;
	  
	  driver.navigate().to(emailUrl);
	  util.enterText(util.getTestData("loginEmailCheckout"), emailField);
	  util.clickByXpath(submitMailinator);
	  
	  ls = util.getElements(emails);
	  initialCount = ls.size();
	  System.out.println("initial email count is: "+initialCount);
	  
	  driver.navigate().to(util.getConfigValue("appUrl"));
      appFunctions.completeShippingProcess(util.getTestData("loginEmailCheckout"),util.getTestData("loginPasswordCheckout"));
	  
	  util.clickByXpath(weiterCart);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on continue on step 1 of checkout process on cart page.");
	  
	  util.clickByXpath(checkBoxTerms);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on terms and conditions checkbox.");
	  
	  util.clickByXpath(finalSubmit);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on final submit button at step 3.");
	  
	  Thread.sleep(6000);
	  appFunctions.selectPaymentMode(util.getTestData("mode3"));
	  
	  finalValue = util.getText(finalAmount);
	  finalValue = util.replaceChar(finalValue,".", " ");
	  
	  util.clickByXpath(buyButton);
	  driver.switchTo().defaultContent();
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on buy button.");
	 
	  Thread.sleep(6000);
	  
	  driver.navigate().to(emailUrl);
	  util.enterText(util.getTestData("loginEmailCheckout"), emailField);
	  util.clickByXpath(submitMailinator);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "logged into email.");
	  Thread.sleep(10000); 
	  
	  ls = util.getElements(emails);
	  afterCount = ls.size();
	  
	  if(afterCount==(initialCount + 1)){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Recieved email for order summary."); 
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Didn't recieve email for order summary.");
	  }
	  
	  util.clickByXpath(inboxEmail);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on summary email");
	  
	  util.switchToIframe(inboxFrame);
	  
	  finalValueEmail = util.getText(pricaValueEmail);
	  
	  if(finalValue.equalsIgnoreCase(finalValueEmail)){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Price value shown in email is correct.");
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Price value shown in email is different then what it was displayed on buy page.");
	  }	  
	  
  }
  
  
  @Test(enabled=true)
  public void verifyPaymentViaRechnung(){
	try{  
	  String amountShip = null;
	  driver.navigate().to(util.getConfigValue("appUrl"));
      appFunctions.completeShippingProcess(util.getTestData("loginEmailCheckout"),util.getTestData("loginPasswordCheckout"));
	  
	  util.clickByXpath(weiterCart);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on continue on step 1 of checkout process on cart page.");
	  
	  util.clickByXpath(checkBoxTerms);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on terms and conditions checkbox.");
	  
	  util.clickByXpath(finalSubmit);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on final submit button at step 3.");
	  
	  Thread.sleep(6000);
	  appFunctions.selectPaymentMode(util.getTestData("mode1"));
	  
	  util.clickByXpath(termsCheckPayment);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Checked terms and condition checkbox."); 
	  
	  
	  util.clickByXpath(buyButton);
	  driver.switchTo().defaultContent();
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on buy button.");
	  Thread.sleep(4000); 
	  
      appFunctions.verifyKlarnaPayment(amountShip);
	  
	}catch(Exception e){
		String path = util.getscreenshot(driver, "verifyPaymentViaRatenkauf");
        ExtentTestManager.getTest().addScreenCapture(path);
		ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
	}
	  
  }
  
  @Test (enabled=true)
  public void verifyPaymentViaRatenkauf(){
	try{
	  String amountShip = null;
	  driver.navigate().to(util.getConfigValue("appUrl"));
      appFunctions.completeShippingProcess(util.getTestData("loginEmailCheckout"),util.getTestData("loginPasswordCheckout"));
	  
	  util.clickByXpath(weiterCart);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on continue on step 1 of checkout process on cart page.");
	  
	  util.clickByXpath(checkBoxTerms);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on terms and conditions checkbox.");
	  
	  util.clickByXpath(finalSubmit);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on final submit button at step 3.");
	  
	  Thread.sleep(6000);
	  appFunctions.selectPaymentMode(util.getTestData("mode2"));
	  
	  util.clickByXpath(termsCheckPayment);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Checked terms and condition checkbox."); 
	  
	  
	  util.clickByXpath(buyButton);
	  driver.switchTo().defaultContent();
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on buy button.");
	  Thread.sleep(4000); 
	  
      appFunctions.verifyKlarnaPayment(amountShip);
	  
	  
	}catch(Exception e){
		String path = util.getscreenshot(driver, "verifyPaymentViaRechnung");
        ExtentTestManager.getTest().addScreenCapture(path);
		ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
	}
	  
  }
  
  
  @Test (enabled=true)
  public void verifyPaymentViaVorkasse(){
	try{ 
	  String order = null;
	  String amountShip = null;

	  driver.navigate().to(util.getConfigValue("appUrl"));
      appFunctions.completeShippingProcess(util.getTestData("loginEmailCheckout"),util.getTestData("loginPasswordCheckout"));
	  
	  util.clickByXpath(weiterCart);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on continue on step 1 of checkout process on cart page.");
	  
	  util.clickByXpath(checkBoxTerms);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on terms and conditions checkbox.");
	  
	  util.clickByXpath(finalSubmit);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on final submit button at step 3.");
	  
	  Thread.sleep(6000);
	  appFunctions.selectPaymentMode(util.getTestData("mode4"));
	
	  util.clickByXpath(buyButton);
	  driver.switchTo().defaultContent();
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on buy button.");
	  
	  Thread.sleep(7000);
	 // appFunctions.explicitWait(orderId);
	  order = util.getText(orderId);
	  if(order.length()>0){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Order id id: "+order);  
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Order Id is missing.");  
	  }
	  
	  
	}catch(Exception e){
		ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
	}
	  
  }
  
  
  
  @Test (enabled=false)
  public void verifyPaymentViaPayPal(){
	try{  
	  driver.navigate().to(util.getConfigValue("appUrl"));
      appFunctions.completeShippingProcess(util.getTestData("loginEmailCheckout"),util.getTestData("loginPasswordCheckout"));
	  
	  util.clickByXpath(weiterCart);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on continue on step 1 of checkout process on cart page.");
	  
	  util.clickByXpath(checkBoxTerms);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on terms and conditions checkbox.");
	  
	  util.clickByXpath(finalSubmit);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on final submit button at step 3.");
	  
	  Thread.sleep(6000);
	  appFunctions.selectPaymentMode(util.getTestData("mode5"));
	
	  util.clickByXpath(buyButton);
	  driver.switchTo().defaultContent();
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on buy button.");
	  Thread.sleep(4000); 
	  
	  
	  
	  
	}catch(Exception e){
		ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
	}
	  
  }
  
  
  @Test (enabled=false)
  public void verifyPaymentViaLastschrift(){
	try{  
	  driver.navigate().to(util.getConfigValue("appUrl"));
      appFunctions.completeShippingProcess(util.getTestData("loginEmailCheckout"),util.getTestData("loginPasswordCheckout"));
	  
	  util.clickByXpath(weiterCart);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on continue on step 1 of checkout process on cart page.");
	  
	  util.clickByXpath(checkBoxTerms);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on terms and conditions checkbox.");
	  
	  util.clickByXpath(finalSubmit);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on final submit button at step 3.");
	  
	  Thread.sleep(6000);
	  appFunctions.selectPaymentMode(util.getTestData("mode6"));
	  
	  util.clickByXpath(termsCheckPayment);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Checked terms and condition checkbox."); 
	  
	  util.clickByXpath(buyButton);
	  driver.switchTo().defaultContent();
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on buy button.");
	  Thread.sleep(4000); 
	  
	  
	  
	  
	}catch(Exception e){
		ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
	}
	  
  }
  
  
  @Test (enabled=false)
  public void verifyPaymentViaKreditkarte(){
	try{  
	  driver.navigate().to(util.getConfigValue("appUrl"));
      appFunctions.completeShippingProcess(util.getTestData("loginEmailCheckout"),util.getTestData("loginPasswordCheckout"));
	  
	  util.clickByXpath(weiterCart);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on continue on step 1 of checkout process on cart page.");
	  
	  util.clickByXpath(checkBoxTerms);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on terms and conditions checkbox.");
	  
	  util.clickByXpath(finalSubmit);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on final submit button at step 3.");
	  
	  Thread.sleep(6000);
	  appFunctions.selectPaymentMode(util.getTestData("mode7"));
	  
	  util.clickByXpath(termsCheckPayment);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Checked terms and condition checkbox."); 
	  
	  util.clickByXpath(buyButton);
	  driver.switchTo().defaultContent();
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on buy button.");
	  Thread.sleep(4000); 
	  
	  
	  
	  
	}catch(Exception e){
		ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());
	}
	  
  }
  
}
