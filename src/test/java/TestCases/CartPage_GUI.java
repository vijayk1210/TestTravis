package TestCases;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import Utility.ExtentTestManager;
import Utility.util;

public class CartPage_GUI extends util {
	
	@Test
	public void sikulifunc() throws FindFailed, InterruptedException{
		boolean arrows = false;
		boolean eTrustsign = false;
		boolean cartcounter = false;
		boolean prdaddbtn = false;
		boolean srvcaddbttn = false;
		boolean servicemsg = false;
		
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "mouse hover on Ecksofas & Wohnlandschaften ");
		mousehover(Ecksofas_Wohnlandschaften_e);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "clicking on Wohnlandschaften category");
		clickevent(wohnlandschaft_sc_e);
		Thread.sleep(4000);
		
		mousehover(number_element_e);
		Thread.sleep(4000);
		
		ExtentTestManager.getTest().log(LogStatus.INFO, "clicking on 48 number");
		clickevent(element_48_e); 
		getelement(util.getTestData("ProductSelected"), productnamelist);
		cartadd();
		
		Thread.sleep(5000);
		driver.navigate().to("http://qa1.homesofa.de/bestellung");
		
		arrows = util.guiMatch(util.getTestData("cartpageArrows"));
		if(arrows){
			ExtentTestManager.getTest().log(LogStatus.INFO, "Steps arrows are displaying");
			System.out.println("Steps arrows are displaying");
		}
		else{
			ExtentTestManager.getTest().log(LogStatus.INFO, "Steps arrows are missing");
			System.out.println("Steps arrows are missing");
		}
			
		cartcounter = util.guiMatch(util.getTestData("CartCounter_Icon"));
		if(cartcounter){
			ExtentTestManager.getTest().log(LogStatus.INFO, "Cart Counter Icon is displaying");
			System.out.println("Cart Counter Icon is displaying");
		}
		else{
			ExtentTestManager.getTest().log(LogStatus.INFO, "Cart Counter Icon missing");
			System.out.println("Cart Counter Icon is missing");
		}
		
	
		prdaddbtn = util.guiMatch(util.getTestData("CartPage_prdaddbtn"));
		if(prdaddbtn){
			ExtentTestManager.getTest().log(LogStatus.INFO, "cart plus minus button are displaying");
			System.out.println("cart plus minus button are displaying");
		}
		else{
			ExtentTestManager.getTest().log(LogStatus.INFO, "cart plus minus button are missing");
			System.out.println("cart plus minus button are missing");
		}
		
		pagescroll(450);
		
		eTrustsign = util.guiMatch(util.getTestData("cartEtrustsign"));
		if(eTrustsign){
			ExtentTestManager.getTest().log(LogStatus.INFO, "eTrustsign is displaying");
			System.out.println("eTrustsign is displaying");
		}
		else{
			ExtentTestManager.getTest().log(LogStatus.INFO, "eTrustsign is missing");
			System.out.println("eTrustsign is missing");
		}
		
		
			
		servicemsg = util.guiMatch(util.getTestData("CartPage_service"));
		if(servicemsg){
			ExtentTestManager.getTest().log(LogStatus.INFO, "service is displaying");
			System.out.println("service is displaying");
		}
		else{
			ExtentTestManager.getTest().log(LogStatus.INFO, "service is missing");
			System.out.println("service is missing");
		}
		
		srvcaddbttn = util.guiMatch(util.getTestData("CartPage_service_addbuttns"));
		if(srvcaddbttn){
			ExtentTestManager.getTest().log(LogStatus.INFO, "service plus minus button are displaying");
			System.out.println("service plus minus button are displaying");
		}
		else{
			ExtentTestManager.getTest().log(LogStatus.INFO, "service plus minus button are missing");
			System.out.println("service plus minus button are missing");
		}
	}

}
