package TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utility.Base;
import Utility.ExtentTestManager;
import Utility.util;
import applicationUtility.appFunctions;

public class ProductDetailGUI extends Base {
  @Test
  public void verifyProductDetailGUI() throws InterruptedException {
	  
	  boolean productDetailCartLogo = false;
	  boolean productDetailCallBack = false;
	  boolean productDetailShippingLogo = false;
	  String productIndex = "1";
	  
	  appFunctions.navigateToSubCategoryPage(Ecksofas_Wohnlandschaften_e, wohnlandschaft_sc_e);
	  
	  util.clickByXpath(appFunctions.Topsellerwishlistproductimg_e(productIndex));
	  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on first product on category and moved to its detail page.");
	  
	  
      util.clickByXpath(Short_callbackoverlay_e);
      
      
      productDetailCartLogo = util.guiMatch(util.getTestData("productDetailCart"));
      
      if(productDetailCartLogo){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Cart Logo on product detail page exists."); 
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Cart Logo on product detail page is missing."); 
	  }
      
      
      productDetailCallBack = util.guiMatch(util.getTestData("productDetailCallBack"));
      
      if(productDetailCallBack){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "CallBack on product detail page exists."); 
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "CallBack on product detail page is missing."); 
	  }
      
      
      productDetailShippingLogo = util.guiMatch(util.getTestData("productDetailShippingLogo"));
      
      if(productDetailShippingLogo){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Shipping logo on product detail page exists."); 
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Shipping logo on product detail page is missing."); 
	  }
      
  }
}
