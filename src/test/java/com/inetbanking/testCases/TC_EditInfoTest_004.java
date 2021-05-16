package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.EditCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_EditInfoTest_004 extends BaseClass {
	
	@Test
	public void editCustomerInfo() throws InterruptedException, IOException
	{
		LoginPage  lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("username is entered");
		lp.setPassword(password);
		logger.info("password is entered");
		lp.clickSubmit();
		logger.info("sign in successfull!!");
		Thread.sleep(3000);
		
	EditCustomerPage editPage=new EditCustomerPage(driver);
	editPage.clickEditCustomer();
	editPage.sendCustomerId(36179);
	editPage.clickBtnSubmit();
	editPage.sendAddress(randomString()+"Country");
	editPage.sendCityName(randomString()+"City");;
	editPage.sendPinno(Integer.parseInt(randomNum()+"9"));
	editPage.sendEmailId(randomString()+randomNum()+"@gmail.com");
	editPage.sendState(randomString()+"State");
	
	String telephoneno=randomNum()+randomNum()+"99";
	editPage.sendTelephoneNo(telephoneno);
	editPage.clickBtnEditSubmit();
	Thread.sleep(3000);
	logger.info("validation started.....");
	boolean res=driver.getPageSource().contains("Customer details updated Successfully!!!");
	if(res==true)
	{
		Assert.assertTrue(true);
		logger.info("test case is passed");
	}
	else
	{
		captureScreen(driver,"UpdateCustomer");
		Assert.assertTrue(false);
		logger.info("test case is failed");
	}
	
		
	}

	
	

}
