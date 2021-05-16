package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003  extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage  lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("username is entered");
		lp.setPassword(password);
		logger.info("password is entered");
		lp.clickSubmit();
		logger.info("sign in successfull!!");
		
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		addcust.setCustomerName(randomString());
		addcust.custGender("male");
		addcust.custDob("10", "15","1995");
		Thread.sleep(3000);
		addcust.custaddress(randomString());
		addcust.custcity(randomString());
		addcust.custstate(randomString());
		addcust.custpinno(Integer.parseInt(randomNum()+"111"));
		addcust.custtelehoneno("9876543210");
		String email=randomString()+randomNum()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("test1234");
		addcust.clickSubmit();
		Thread.sleep(3000);
		logger.info("validation started.....");
		///boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		boolean res=driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[1]/td/p")).getText().equals("Customer Registered Successfully!!!");
		//driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case is passed");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("test case is failed");
		}
		

		
	}
	

	
}
