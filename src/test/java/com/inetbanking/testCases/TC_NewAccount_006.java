package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.NewAccount;

import junit.framework.Assert;

public class TC_NewAccount_006 extends BaseClass{

	@Test
	public void newAccount() throws InterruptedException, IOException
	{
		LoginPage  lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("username is entered");
		lp.setPassword(password);
		logger.info("password is entered");
		lp.clickSubmit();
		logger.info("sign in successfull!!");
		Thread.sleep(3000);
		
		NewAccount newaccount=new NewAccount(driver);
		newaccount.clickNewAccountLink();
		newaccount.sendcustomerId(new TC_AddCustomerTest_003().custid);
		newaccount.selectAccount();
		newaccount.sendDepositAmount(Double.parseDouble(randomNum()));
		newaccount.clickSubmit();
		boolean res=driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[1]/td/p")).getText().equals("Account Generated Successfully!!!");
		//driver.getPageSource().contains("Customer Registered Successfully!!!")
		//double accountid=newaccount.getAccountId();
		if(res==true)
		{
			logger.info("Account id :"+newaccount.getAccountId());
			logger.info("Account Balace is:"+newaccount.getAmount());
			Assert.assertTrue(true);
			logger.info("Account is successfully created!!!!");
			logger.info("test case is passed");
		}
		else
		{
			captureScreen(driver,"addNewAccount");
			Assert.assertTrue(false);
			logger.info("test case is failed");
		}
	}
}
