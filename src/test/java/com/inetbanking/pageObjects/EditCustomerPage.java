package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	
	WebDriver driver;
	public EditCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[3]/a")
	WebElement linkeditCustomer;
	
	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input")
	WebElement txtcustomerId;
	
	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input[1]")
	WebElement btnSubmit;
	
	@FindBy(name="city")
	WebElement txtCity;
	
	@FindBy(name="addr")
	WebElement txtaddress;
	
	@FindBy(name="state")
	WebElement txtstate;
	
	@FindBy(name="pinno")
	WebElement txtpinno;
	
	@FindBy(name="telephoneno")
	WebElement txttelephoneno;
	
	@FindBy(name="emailid")
	WebElement txtemail;
	
	@FindBy(name="sub")
	WebElement btnEditSubmit;
	
	public void clickEditCustomer()
	{
		linkeditCustomer.click();
	}
	
	public void sendCustomerId(int id)
	{
		txtcustomerId.sendKeys(String.valueOf(id));
	}
	public void clickBtnSubmit()
	{
		btnSubmit.click();
	}
	
	public void sendCityName(String city)
	{
		txtCity.clear();
		txtCity.sendKeys(city);
	}
	
	public void sendAddress(String address)
	{
		txtaddress.clear();
		txtaddress.sendKeys(address);
	}
	
	public void sendState(String state)
	{
		txtstate.clear();
		txtstate.sendKeys(state);
	}
	public void sendPinno(int pin)
	{
		txtpinno.clear();
		txtpinno.sendKeys(String.valueOf(pin));
	}
	public void sendTelephoneNo(String teleno)
	{
		txttelephoneno.clear();
		txttelephoneno.sendKeys(teleno);
	}
	public void sendEmailId(String email)
	{
		txtemail.clear();
		txtemail.sendKeys(email);
	}
	public void clickBtnEditSubmit()
	{
		btnEditSubmit.click();
	}

}
