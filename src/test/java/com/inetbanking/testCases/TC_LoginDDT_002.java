package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String username,String password) throws InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();	
		Thread.sleep(3000);
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login is not successfull!!");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login passed!!");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
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
	@DataProvider(name="LoginData")
	public String[][] getdata() throws IOException{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/Login.xlsx";
		int rownum=XLUtils.getRowCount(path,"Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i, j);
			}
		}
		return logindata;
	}
}
