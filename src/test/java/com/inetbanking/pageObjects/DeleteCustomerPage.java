package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	
	WebDriver driver;
	public DeleteCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[4]/a")
	WebElement lnkDeleteCustomer;
	
	@FindBy(name="cusid")
	WebElement txtcustid;
	
	@FindBy(name="AccSubmit")
	WebElement btnSubmit;
	
	public void clickDeleteCustomer()
	{
		lnkDeleteCustomer.click();
	}
	
	public void sendCustId(int custid)
	{
		txtcustid.sendKeys(String.valueOf(custid));
	}
	
	public void clickSubmitButton()
	{
		btnSubmit.click();
	}

}
