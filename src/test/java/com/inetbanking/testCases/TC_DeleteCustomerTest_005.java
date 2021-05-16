package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.DeleteCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_DeleteCustomerTest_005 extends BaseClass{
	
	@Test
	public void deleteCustomer() throws InterruptedException
	{
		LoginPage  lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("username is entered");
		lp.setPassword(password);
		logger.info("password is entered");
		lp.clickSubmit();
		logger.info("sign in successfull!!");
		Thread.sleep(3000);
		
		DeleteCustomerPage deletepage=new DeleteCustomerPage(driver);
		deletepage.clickDeleteCustomer();
		deletepage.sendCustId(new TC_AddCustomerTest_003().custid);
		deletepage.clickSubmitButton();
		Thread.sleep(3000);
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().alert().accept();					
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.info("Customer is Successfully deleted. Test Passed");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Customer not deleted. Test Failed!!!!!");
		}

		
	}
	public boolean isAlertPresent()
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		

}
}