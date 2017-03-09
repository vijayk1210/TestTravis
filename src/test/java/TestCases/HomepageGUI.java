package TestCases;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utility.Base;
import Utility.ExtentTestManager;
import Utility.util;

public class HomepageGUI extends Base {
	
  @Test
  public void homePageGui()  {
	  boolean homeLogoMatch = false;
	  boolean homeProfileMatch = false;
	  boolean homeTrustedLogo = false;
	  boolean homeServiceLogo = false;
	  boolean homeCartLogo = false;
	  boolean homeSearchLogo = false;
	  
	  
	  homeLogoMatch = util.guiMatch(util.getTestData("homeLogo"));
	  
	  if(homeLogoMatch){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Home Logo exists."); 
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Home Logo is missing."); 
	  }
	  
	  homeProfileMatch = util.guiMatch(util.getTestData("homeProfileLogo"));
	  
	  if(homeProfileMatch){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Profile logo exists."); 
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Profile logo is missing."); 
	  }
	  
	  homeTrustedLogo = util.guiMatch(util.getTestData("homeTrustedLogo"));
	  
	  if(homeTrustedLogo){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Trusted logo exists."); 
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Trusted logo is missing."); 
	  }
	  
	  homeServiceLogo = util.guiMatch(util.getTestData("homeServiceLogo"));
	  
	  if(homeServiceLogo){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Service logo exists."); 
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Service logo is missing."); 
	  }
	  
	  homeCartLogo = util.guiMatch(util.getTestData("homeCartLogo"));
	  
	  if(homeCartLogo){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Cart logo exists."); 
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Cart logo is missing."); 
	  }
	  
	  homeSearchLogo = util.guiMatch(util.getTestData("homeSearchLogo"));
	  
	  if(homeSearchLogo){
		  ExtentTestManager.getTest().log(LogStatus.PASS, "Search logo exists."); 
	  }else{
		  ExtentTestManager.getTest().log(LogStatus.FAIL, "Search logo is missing."); 
	  }
	  
		
  }
}


