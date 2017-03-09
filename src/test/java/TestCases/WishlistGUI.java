package TestCases;

import org.testng.annotations.Test;

import Utility.Base;
import Utility.ExtentTestManager;
import Utility.util;

import applicationUtility.appFunctions;

import com.relevantcodes.extentreports.LogStatus;

public class WishlistGUI extends Base {
	
  @Test (enabled=false)
  public void verifyEmptyWishlistGUI() {
	  
	  boolean wishHeartExists = false;
	  
	  util.mousehoverVj(Mein_konto_e);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on mein konto on home page header");
	  
	  util.clickByXpath(wishlistcounter2_e);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Moved to wishlist page");
	  
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  wishHeartExists = util.guiMatch(util.getTestData("wishHeart"));
	  
	  if(wishHeartExists){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Empty wishlist Heart exists."); 
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Empty wishlist Heart is missing."); 
	  }
  }
  
  
  @Test
  public void verifyfilledWishlist(){
	  
	 boolean wishListAddtoCart = false;
	 
     try {
		appFunctions.ProductDetailPageWithoutLogin();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  util.clickByXpath(addtowishlist);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on add to wishlist");
	  
	  
	  util.mousehoverVj(Mein_konto_e);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on mein konto on home page header");
	  
	  util.clickByXpath(wishlistcounter2_e);
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Moved to wishlist page");
	  
	  wishListAddtoCart = util.guiMatch(util.getTestData("productDetailCart"));
	  
	  if(wishListAddtoCart){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "WishList AddtoCart Logo exists."); 
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "WishList AddtoCart Logo is missing."); 
	  }
	  
	  
  }
}
