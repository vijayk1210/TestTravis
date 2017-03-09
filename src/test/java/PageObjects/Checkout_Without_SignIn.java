package PageObjects;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.WebElement;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;


import Utility.ExtentTestManager;
import Utility.util;

public class Checkout_Without_SignIn extends util{
	
	public static boolean checkout_signup() throws InterruptedException, AWTException{
	   boolean status = true;
	  
    List<WebElement> orderSummary = new ArrayList<WebElement>();
	 mousehover(Ecksofas_Wohnlandschaften_e);
	
	ExtentTestManager.getTest().log(LogStatus.INFO, "clicking on Wohnlandschaften category");
	clickevent(wohnlandschaft_sc_e);
	Thread.sleep(4000);
	
	mousehover(number_element_e);
	Thread.sleep(4000);
	
	clickevent(element_48_e); 
	ExtentTestManager.getTest().log(LogStatus.INFO, "clicking on product");
	getelement(util.getTestData("ProductSelected"), productnamelist);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Adding the product cart");
	cartadd();
	Thread.sleep(3000);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Navigating to cart page");
	 clickevent(submitcart_e);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Navigating to sign up page");
	 
	 clickevent(submitcartpage_e);
	 ExtentTestManager.getTest().log(LogStatus.INFO, "Creating the account with valid details and filling all the details");
	 createaccount();	 
	 ExtentTestManager.getTest().log(LogStatus.INFO, "Proceeding to next page");
    	clickIDevent(submit_signup_e);
    	clickevent(Short_callbackoverlay_e);
    	Thread.sleep(2000);
    	ExtentTestManager.getTest().log(LogStatus.INFO, "Verify that next page shipping address page or not");
    	 Assert.assertTrue(getText(headingshippingpage).equalsIgnoreCase(util.getTestData("Shippingpageheading")));
    	 ExtentTestManager.getTest().log(LogStatus.INFO, "Checking the checkbox");
    	 clickevent(checkBoxTerms);
    	 ExtentTestManager.getTest().log(LogStatus.INFO, "Navigating to checkout page");
     	 clickevent(finalSubmit);
    	 Thread.sleep(3000);
    		 
    		 switchToIframe(kalrnaIframe);
    		 ExtentTestManager.getTest().log(LogStatus.INFO, "Selecting the payment method Nachname");
    		 
    		 util.getelement(util.getTestData("mode3"), paymentName);
    		 
    		 
    		 ExtentTestManager.getTest().log(LogStatus.INFO, "Placing the order");
    	
    		 
       pagescroll(1550);
   
    		clickevent(buyButton);
    		 driver.switchTo().defaultContent();
    		  Thread.sleep(7000);
    		 
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "Verify that order id is generated or not");
    		
    		  boolean  referenceCheck = elementPresentOrNot(referenceId);
    		  if(referenceCheck){
    			  ExtentTestManager.getTest().log(LogStatus.PASS, "Referenceid id is generated.");  
    		  }else{
    			  ExtentTestManager.getTest().log(LogStatus.FAIL, "Referenceid id missing."); 
    			  status = false;
    		  }  
    		  		 		 
    		  orderSummary = getElements(OrderSummary);
    		  
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "Verify that page is Order summary is displaying or not");
    		  if((orderSummary.size())>2){
    			  ExtentTestManager.getTest().log(LogStatus.PASS, "Order Summary is getting displayed."); 
    		  }
    		  else{
    			  ExtentTestManager.getTest().log(LogStatus.FAIL, "Order Summary is not getting displayed.");
    			  status = false;
    		  }
    		 
    		  String Order = getText(referenceId);
    		  mousehover(username_e);
    		  clickevent(order_e);
    		 getelement(Order,Orderhistory_e);
    		 	  
    		 
	  
    		  System.out.println(Order);
    		  DeletingTrashdata.ordertrash(Order);
    		  DeletingTrashdata.emailtrash();
    		 
    		  return status;
	
	}
	
	public static void createaccount() throws InterruptedException{
		
		enterdataID(firstname_e, util.getTestData("firstName"));
		 enterdataID(lasttname_e, util.getTestData("lastName"));
		 String newemail = util.getTestData("signupemail") + getRandomNumberInRange(1, 99999) + util.getTestData("emaildomain");
		 enterdata(email_signup_e, newemail);
		 enterdata(pwd_signup_e,util.getTestData("validpasswrd"));
		 enterdataID(company_e, util.getTestData("companyname"));
		 enterdataID(address_pi_e, util.getTestData("address"));
		 Thread.sleep(3000);
		 clickevent(addresslist_e);
		 enterdata(phone_signup_e, util.getTestData("phonenumber"));
		 clickevent(salutation_Mr_e);
		 pagescroll(300);
		 
	    	selectdropdownvalue(DOB_day_e, util.getTestData("Day"));
	    	selectdropdownvalue(DOB_month_e, util.getTestData("Month"));
	    	selectdropdownvalue(DOB_year_e, util.getTestData("Year"));
		
	}

}
