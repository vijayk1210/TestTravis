package applicationUtility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;


import PageObjects.DeletingTrashdata;
import Utility.Base;
import Utility.ExtentTestManager;
import Utility.util;

public class appFunctions extends Base {
	
	   
	
	   public static void login(String username,String password){
		   driver.findElement(By.xpath(PageObjects.email_l_e)).sendKeys(username);
		   driver.findElement(By.xpath(PageObjects.pwd_l_e)).sendKeys(password);
		   driver.findElement(By.xpath(PageObjects.login_submit_e)).click();
	   }
	
	    public static String Topsellerwishlistproductimg_e(String str){
	    	String a = "//descendant::img[@class='replace-2x img-responsive'][";
	    	int b = Integer.parseInt(str);
	    	String c = "]";
	    	String d=a+b+c;
	    	return d;
	    }
	  
	    

       public String wishlistproduct_e(String str){
	        String a = "//descendant::a[@class='s_title_block product-view-ga'][";
	        int b = Integer.parseInt(str);
	        String c = "]";
	        String d=a+b+c;
	        return d;
        }

       public String deleteproductwishlist_e(String str){
	       String a = "//descendant::i[@class='fa fa-close close-hover'][";
	       int b = Integer.parseInt(str);
	       String c = "]";
	       String d=a+b+c;
	       return d;
   }
       
       public static void updateAddress(){
    	try{ 
    	  util.clearText(strafze);
    	  util.enterText(util.getTestData("updateStrafze"), strafze);
    	  Thread.sleep(3000);
		  util.clickByXpath(strafzeValue);
		  ExtentTestManager.getTest().log(LogStatus.INFO, "Entered strafze.");
		  
    	/*  System.out.println("Data: "+util.getTestData("newStrafze"));
    	  util.enterText(util.getTestData("newStrafze"), strafze);
 		  ExtentTestManager.getTest().log(LogStatus.INFO, "Entered  new strafze.");
 		  
 		  util.clearText(housnr);
 		  util.enterText(util.getTestData("newHouse"), housnr);
 		  ExtentTestManager.getTest().log(LogStatus.INFO, "Entered new house no.");
 		  
 		  util.clearText(plz);
 		  util.enterText(util.getTestData("newPlz"), plz);
 		  ExtentTestManager.getTest().log(LogStatus.INFO, "Entered  new plz.");
 		  
 		  util.clearText(Ort);
 		  util.enterText(util.getTestData("newArea"), Ort);
 		  ExtentTestManager.getTest().log(LogStatus.INFO, "Entered new Ort."); */
 		  
 		  util.clickByXpath(profileSubmit);
		  ExtentTestManager.getTest().log(LogStatus.INFO, "clicked on submit");
		  
		  util.elementPresentOrNot(step3Cart);
		  
    	}catch(Exception e){
    		Alert alert = driver.switchTo().alert();
    		alert.accept();
    	}	  
		  
       }
       
       public static void explicitWait(String xpath){
    	   WebDriverWait wait = new WebDriverWait(driver, 10);
    	   
    	   WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
       }
       
       public static void enterProfileDetails(){
    	   try{
    	      util.clickByXpath(profileHerr);
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "Selected Herr.");
    		    
    		  util.selectDropDownValue(util.getTestData("day"), dobDateXpath);
       		  ExtentTestManager.getTest().log(LogStatus.INFO, "Entered date.");
       		  
       		  util.selectDropDownValue(util.getTestData("month"), dobMonthXpath);
     		  ExtentTestManager.getTest().log(LogStatus.INFO, "Entered month.");
     		  
     		  util.selectDropDownValue(util.getTestData("month"), dobMonthXpath);
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "Entered year.");
     		  
    		  util.clearText(strafze);
    		  Thread.sleep(3000);
    		  util.enterText(util.getTestData("strafze"), strafze);
    		  Thread.sleep(4000);
    		  util.clickByXpath(strafzeValue);
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "Entered strafze.");
    		  
    		  util.clearText(telefon);
    		  util.enterText(util.getTestData("telefon"), telefon);
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "Entered telefon.");
    		  
    		  util.enterText(util.getTestData("loginPassword"), derzeitigesPasswort);
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "Entered current password.");
    		  
    		  util.clickByXpath(profileSubmit);
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "clicked on submit");
    	   }catch(Exception e){
    		   
    	   }
       }

      
       

       public static void completeShippingProcess(String email, String password) throws InterruptedException{
    	      navigateToProductDetailPage(email,password);
    		  
    		  util.clickByXpath(addtocart_e);
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on add to cart.");
    		  
    		  Thread.sleep(4000);
    		  util.clickByXpath(submitcart_e);
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on shipping.");
       }
       
       public static void navigateToSubCategoryPage(String hover, String click) throws InterruptedException{
    	   
 		  util.mousehover(hover);
 		  util.clickByXpath(click);
 		  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on sub category");
 		  ExtentTestManager.getTest().log(LogStatus.INFO, "USer is on category page");
 		  Thread.sleep(4000);
       }
       
       
       public static void navigateToProductDetailPage(String email,String password) throws InterruptedException{
    	   
    	      String productIndex = "1";
    	   
    		  util.clickByXpath(Mein_konto_e);
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on mein konto on home page header");
    		  
    		  appFunctions.login(email, password);
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "logged in");
    		  
    		  util.clickByXpath(logo_e);
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on homesofa logo");
    		  
    		  navigateToSubCategoryPage(Ecksofas_Wohnlandschaften_e, wohnlandschaft_sc_e);
    		  
    		  util.clickByXpath(appFunctions.Topsellerwishlistproductimg_e(productIndex));
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on first product on category and moved to its detail page.");
       }
       
       
       
       public static void ProductDetailPageWithoutLogin() throws InterruptedException{
    	   
    	      String productIndex = "1";
    	   
    		  util.clickByXpath(Mein_konto_e);
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on mein konto on home page header");
    		  
    		  util.clickByXpath(logo_e);
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on homesofa logo");
    		  
    		  navigateToSubCategoryPage(Ecksofas_Wohnlandschaften_e, wohnlandschaft_sc_e);
    		  
    		  util.clickByXpath(appFunctions.Topsellerwishlistproductimg_e(productIndex));
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "Clicked on first product on category and moved to its detail page.");
       }
       
       public static int priceValueConvertion(String priceText){
    	   int priceValue=0;
    	   
    	   String[] priceVal1 = priceText.split(" ");
    	   int size = priceVal1.length;
    	   
    	   if(size==4){
    	  
    	   String[] priceVal2 = priceVal1[2].split(",");
    	   String priceVal = priceVal1[1].concat(priceVal2[0]);
    	   String finalPriceVal = priceVal.concat(priceVal2[1]);
    	   priceValue = Integer.parseInt(finalPriceVal);
    	   
    	   }else{
    		   
        	   String[] priceVal2 = priceVal1[1].split(",");
        	   String finalPriceVal = priceVal2[0].concat(priceVal2[1]);
        	   priceValue = Integer.parseInt(finalPriceVal);
    		   
    	   }
    	   return priceValue; 
    	   
       }
       
       public static int priceValueConvertionForFilter(String priceText){
    	   int priceValue=0;
    	   
    	   String[] priceVal1 = priceText.split(" ");
    	   
    		   
        	   String[] priceVal2 = priceVal1[2].split(",");
        	   String midPriceVal = priceVal1[1].concat(priceVal2[0]);
        	   
        	   priceValue = Integer.parseInt(midPriceVal);
    		   
        	   
    	   return priceValue; 
    	   
       }
       
       public static boolean verifyShippingCost(String priceText, String singleProductPrice){
    	   boolean status = false;
    	    
    	   String priceT =util.getText(priceText);
    	   String tempArr[] = priceT.split("Anzahl");
    	   String[] tempArr1 = tempArr[1].split("-");
    	   System.out.println("int value is: "+tempArr1[0]);
    	   String[] tempArr2 = tempArr1[0].split("-");
    	   System.out.println("int value is: "+tempArr2[0]);
    	   String[] tempArr3 = tempArr2[0].split(" ");
    	   System.out.println("Final value is: "+tempArr3[1]);
    	   
    	   int finalCount = Integer.parseInt(tempArr3[1]);
    	   
    	   String priceVal1 = util.getText(price);
    	   String[] priceVal2 = priceVal1.split(" ");
    	   String[] priceVal3 = priceVal2[1].split(" ");
    	   System.out.println("Price now is: "+priceVal3[0]);
    	   String[] priceVal4 = priceVal3[0].split(",");
    	   String priceVal = priceVal2[0].concat(priceVal4[0]);
    	   String finalPriceVal = priceVal.concat(priceVal4[1]);
    	   int priceValue = Integer.parseInt(finalPriceVal);
    	   System.out.println("Total Price value: "+priceValue);
    	   
    	   String[] singlePriceVal2 = singleProductPrice.split(" ");
    	   String[] singlePriceVal3 = singlePriceVal2[1].split(" ");
    	   System.out.println("Price now is: "+singlePriceVal3[0]);
    	   String[] singlePriceVal4 = singlePriceVal3[0].split(",");
    	   String singlePriceVal = singlePriceVal2[0].concat(singlePriceVal4[0]);
    	   String singleFinalPriceVal = singlePriceVal.concat(priceVal4[1]);
    	   int singlePriceValue = Integer.parseInt(singleFinalPriceVal);
    	   
    	   
    	   
    	   if(priceValue==(finalCount*singlePriceValue)){
    		   status=true;
    		   ExtentTestManager.getTest().log(LogStatus.PASS, "Price of product for shipping is correct even with multiple product count."); 
    	   }else{
    		   ExtentTestManager.getTest().log(LogStatus.FAIL, "Price of product for shipping is incorrect when count is more than one.");
    	   }
    	   
    	   
    	   return status;
       }
       
       
       public static boolean priceSortingHomePage(String xpath,String sortingOrder){
    	      boolean status =false;
    	      List<WebElement> priceList = new ArrayList<WebElement>();
       	      List newPriceList = new ArrayList();
       	      List otherPriceList = new ArrayList();
    	   
    		  priceList = util.getElements(priceOnProductCard);
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "Retrieved all price list.");
    		  System.out.println("Size of list: "+priceList.size());
    		  for(WebElement price: priceList){
    				String priceVal = price.getText();
    				int singleVal = priceValueConvertion(priceVal);
    				int i=0;
    				newPriceList.add(i, singleVal);
    				int value1 = (int)newPriceList.get(i);
  
    				otherPriceList.add(i, singleVal);
    				i=i+1;
    		   }
    		  
    		  for(int i=newPriceList.size() - 1;i>3;i--){
    			  
    			  int val1 = (int) newPriceList.get(i);
    			  
    			 for(int j= i-1;j>2;j--) {
    				 
    				 int val2 = (int) otherPriceList.get(j);
    				if(sortingOrder.equalsIgnoreCase("highToLow")) {
    				   if(val1>=val2){
    					 status=true;
    					 
    				   }else{
    					 ExtentTestManager.getTest().log(LogStatus.FAIL, "Prices are not sorted, value: "+val1+" found less than "+val2);
    					 
    					 Assert.fail();
    				   }
    				}else{
    					if(val1<=val2){
       					 status=true;
       					 System.out.println("Value: "+val1+" found greater than "+val2);
       				     }else{
       					   ExtentTestManager.getTest().log(LogStatus.FAIL, "Prices are not sorted, value: "+val1+" found greater than "+val2);
       					 
       					   Assert.fail();
       				    }
    					
    				}
    			 }
    			  
    		  }
    		  
            return status;

       }
       
       public static boolean colorFilterTest(String colorVal) throws InterruptedException{
    	   boolean status = false;
    	   String colorXpath= Colors.replace("test", colorVal);
    	   //String colorProductPage = colorsProductDetail.replace("test", colorVal);
    	   List<WebElement> subCatProds = new ArrayList<WebElement>();
    	   List<WebElement> colorDetail = new ArrayList<WebElement>();
    	   
    	   util.mousehover(colorFilter);
    	   Thread.sleep(2000);
    	   util.clickByXpath(colorXpath);
    	   ExtentTestManager.getTest().log(LogStatus.INFO, "selected color."); 
    		  
    	   util.clickByXpath(setFilters);
    	   ExtentTestManager.getTest().log(LogStatus.INFO, "clicked on set filter."); 
    	   Thread.sleep(6000);
    	   subCatProds = util.getElements(subCategoryProductBlocks);
    	   
    	   for(int i=0;i<subCatProds.size()-3;i++){
    		   int count =0;
    		   subCatProds = util.getElements(subCategoryProductBlocks);
    		   subCatProds.get(i).click();
    		   ExtentTestManager.getTest().log(LogStatus.INFO, "Moved to product detail page."); 
    		   Thread.sleep(3000);
    		   colorDetail = util.getElements(colorProductDetail);
    		   
    		   for(WebElement prodColor : colorDetail){
    			   String color = prodColor.getAttribute("title");
    			   String colorActual = color.toLowerCase();
    			   String colorExpected = colorVal.toLowerCase();
    			   
    			   if(colorActual.contains(colorExpected)){
    				   count = count + 1;
    				   
    			   }
    			     
    			 
    		   }
    		   if(count>=1){
	    		   status=true;
	    	   }else{
	    		   status=false;
	    		   break;
	    	   }
    		   
    		   driver.navigate().back();
    		   System.out.println("successfully verified up to: "+i);
    		   ExtentTestManager.getTest().log(LogStatus.INFO, "Verifying filter for next product."); 
    		   Thread.sleep(5000);
    		   
    	   } 
    	   
    	   return status;
    	   
       }
       
       
       public static boolean priceFilterTest(){
    	   boolean status=false;
    	   util.mousehover(priceFilter);
    	   String minVal=null;
    	   String maxVal=null;
    	   List<WebElement> priceList = new ArrayList();
    	       	   
    	   util.clickByXpath(slider);
    	   ExtentTestManager.getTest().log(LogStatus.INFO, "Moved left slider.");
    	   
    	   minVal = util.getAttribute("prc-min", amountVal);
    	   maxVal = util.getAttribute("prc-max", amountVal);
    	   int minRangeVal = Integer.parseInt(minVal);
    	   int maxRangeVal = Integer.parseInt(maxVal);
    	   ExtentTestManager.getTest().log(LogStatus.INFO, "Got the price range values.");
    	   
    	   try{
    	       util.clickByXpath(setFilters);
    	       ExtentTestManager.getTest().log(LogStatus.INFO, "clicked on set filter."); 
    	       Thread.sleep(4000);
    	       
    	      } catch(Exception e){
    	    	  ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());  
    	       }
    	   
    	   priceList = util.getElements(priceOnProductCard);
    	   
    	   for(int i=0;i<priceList.size()-3;i++){
    		   
    		    String priceVal = priceList.get(i).getText();
				int singleVal = priceValueConvertionForFilter(priceVal);
				
				if((singleVal >= minRangeVal) && (singleVal <= maxRangeVal)){
					status =true;
				}
				
		   }
    	   
    	   return status;
    	   
       }
     /*  
       public static void selectPaymentMode(String paymentMode){
    	   
    	   List<WebElement> payM = new ArrayList();
    	   
    	   payM = util.getElements(paymentName);
    	   
    	   for(WebElement payText : payM ){
    		   String payment = payText.getText();
    		   if(payment.equalsIgnoreCase(paymentMode)){
    			   payText.click();
    		   }
    	   }	   
    	   
       }*/
       
       
       public static String verifyKlarnaPayment(String amountOrderPage){
    	   String orderId = null;
    	   try{ 
    		   //1.617,99 €
    		   //1.617,99 €
    	     driver.switchTo().frame(klarnaFrameButton);
    		  
    		  util.clickByXpath(klarnaBestellung);
    		  
    		  driver.switchTo().defaultContent();
    		   
    		  Thread.sleep(4000);
    		  
    		  driver.switchTo().frame(klarnaFrameOrder);
    		  Thread.sleep(4000);
    		  //explicitWait(klarnaOrderId);
    		  
    		  orderId = util.getText(klarnaOrderId);
    		  
    		  ExtentTestManager.getTest().log(LogStatus.INFO,"Order id is: "+ orderId);
    		  
    		  DeletingTrashdata.ordertrash(orderId);
    		  ExtentTestManager.getTest().log(LogStatus.INFO,"Cancelled the order placed above from admin.");
    		  
    		  
    	 }catch(Exception e){
    		 ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());  
    	 }
    	   return orderId;
       }
       
       public static String selectPaymentMode(String payMethod){
    	     String amountShip =null;
    	     try{ 	     
    	      util.switchToIframe(kalrnaIframe);
    		  Thread.sleep(3000);
    		  
    		  util.getelement(payMethod, paymentName);
    		  ExtentTestManager.getTest().log(LogStatus.INFO, "Selected paymenmt by Cash.");
    		  
    		  amountShip = util.getText(amountShipping);
    	     }catch(Exception e){
    	    	ExtentTestManager.getTest().log(LogStatus.ERROR, e.getMessage());  
    	     }
    	     return amountShip;
       }
       
}
