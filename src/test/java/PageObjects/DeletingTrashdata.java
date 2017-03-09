package PageObjects;


import org.testng.annotations.Test;

import Utility.util;

public class DeletingTrashdata extends util{

	
	public static void emailtrash() throws InterruptedException{
		
		clickevent(admin_Customer_viewlink_e);
		
		enterdata(Custmrpage_email_filterField_e,"test");
		clickevent(Customerpage_search_filterbutton_e);
		 Thread.sleep(5000);
		clickevent(pagination_drpdwn_e);
		clickevent(pagination_sel_max_e);
		clickevent(listpage_action_drpdwn_e);
		clickevent(listpage_allcheckbox_sel);
		Thread.sleep(5000);
		clickevent(listpage_action_drpdwn_e);
		clickevent(listpage_allstatus_decactv);
		Thread.sleep(5000);
	 	System.out.println("heloo");
		    	
		    
	}
	
	public static void adminlogin() throws InterruptedException{
		driver.navigate().to(util.getConfigValue("adminUrl"));
		enterdata(admin_userid_e, util.getTestData("adminuserid"));
		enterdata(admin_passwrd_e, util.getTestData("adminpwd"));
		clickevent(admin_loginbttn_e);
		Thread.sleep(5000);
	}
	
	public static void ordertrash(String str) throws InterruptedException{
		 adminlogin();
		//str = "H60945855";
		clickevent(admin_Order_viewlink_e);
		enterdata(Orderpage_ref_filterField_e, str);
		clickevent(Orderpage_search_filterbutton_e);
		clickevent(admin_OrderNoslist_es);
		Thread.sleep(5000);
		pagescroll(400);
		clickevent(admin_orderviewpage_statusdrpdwn_e);
		clickevent(OrderStatus_Cancel_e);
		clickevent(orderstatuschange_bttn_e);
		System.out.println("heloo");
		
		
	}

}
	
