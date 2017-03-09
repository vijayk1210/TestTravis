package TestCases;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentTestManager;
import Utility.util;

public class CallBack_UI extends util{

	@Test
	public void CallBackUI() throws FindFailed, InterruptedException{
		
		boolean callbackoverlay_sign = false;
		boolean  call_sign = false;

		callbackoverlay_sign = util.guiMatch(util.getTestData("CallBackOverlaySign"));
		if(callbackoverlay_sign){
			ExtentTestManager.getTest().log(LogStatus.INFO, "CallBack Overlay Sign is displaying");
			System.out.println("CallBack Overlay Sign is displaying");
		}
		else{
			ExtentTestManager.getTest().log(LogStatus.INFO, "CallBack Overlay Sign is missing");
			System.out.println("CallBack Overlay Sign is missing");
		}
		
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
		
		call_sign = util.guiMatch(util.getTestData("CallSign"));
		if(call_sign){
			ExtentTestManager.getTest().log(LogStatus.INFO, "Call Sign is displaying");
			System.out.println("Call Sign is displaying");
		}
		else{
			ExtentTestManager.getTest().log(LogStatus.INFO, "Call Sign is missing");
			System.out.println("Call Sign is missing");
		}
		
		driver.navigate().to("http://qa1.homesofa.de/bestellung");
		
		
	}
	
}
