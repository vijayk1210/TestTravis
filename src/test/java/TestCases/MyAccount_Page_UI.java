package TestCases;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import Utility.ExtentTestManager;
import Utility.util;

import com.relevantcodes.extentreports.LogStatus;

public class MyAccount_Page_UI extends util{
	
	@Test
	public void CallBackUI() throws FindFailed, InterruptedException{
		
		boolean wishlisticon = false;
		boolean orderhistoryicon = false;
		boolean userinfoicon = false;
		
		login_in();

		orderhistoryicon = util.guiMatch(util.getTestData("OrderHistory_Icon"));
		if(orderhistoryicon){
			ExtentTestManager.getTest().log(LogStatus.INFO, "Order History Icon is displaying");
			System.out.println("Order History Icon is displaying");
		}
		else{
			ExtentTestManager.getTest().log(LogStatus.INFO, "Order History Icon is missing");
			System.out.println("Order History Icon is missing");
		}
		
		
		
		userinfoicon = util.guiMatch(util.getTestData("UserInfo_icon"));
		if(userinfoicon){
			ExtentTestManager.getTest().log(LogStatus.INFO, "User Info Icon is displaying");
			System.out.println("User Info Icon is displaying");
		}
		else{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User Info Icon is missing");
			System.out.println("User Info Icon is missing");
		}
		
		wishlisticon = util.guiMatch(util.getTestData("MyWishlist_Icon"));
		if(wishlisticon){
			ExtentTestManager.getTest().log(LogStatus.INFO, "My Wishlist Icon is displaying");
			System.out.println("My Wishlist Icon is displaying");
		}
		else{
			ExtentTestManager.getTest().log(LogStatus.INFO, "My Wishlist Icon is missing");
			System.out.println("My Wishlist Icon is displaying missing");
		}
	}

}
