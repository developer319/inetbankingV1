package com.inetbanking.pageObjects;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	WebDriver driver;
	public NewAccount(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[5]/a")
	WebElement lnknewaccount;
	
	@FindBy(name="cusid")
	WebElement txtcusid;
	
	@FindBy(name="selaccount")
	WebElement dropdownselectaccount;
	
	@FindBy(name="inideposit")
	WebElement txtdeposit;
	
	@FindBy(name="button2")
	WebElement btnsubmit;
	
	@FindBy(xpath="//*[@id=\"account\"]/tbody/tr[4]/td[2]")
	WebElement txtAccountId;
	
	@FindBy(xpath="//*[@id=\"account\"]/tbody/tr[10]/td[2]")
	WebElement txtAmount;
	public void clickNewAccountLink()
	{
		lnknewaccount.click();
	}
	
	public void sendcustomerId(int cusid)
	{
		txtcusid.sendKeys(String.valueOf(cusid));
	}
	
	public void selectAccount()
	{
		Select select=new Select(dropdownselectaccount);
		String arr[]= {"Savings","Current"};
	    
		select.selectByValue(getRandom(arr));;
	}
	
	public void sendDepositAmount(double amount)
	{
		txtdeposit.sendKeys(String.valueOf(amount));
	}
	
	public void clickSubmit()
	{
		btnsubmit.click();
	}
	
	public int getAccountId()
	{
		return Integer.parseInt(txtAccountId.getText());
		
	}
	public Double getAmount()
	{
		return Double.parseDouble(txtAmount.getText());
	}
	
	public static String getRandom(String[] array) {
	    int rnd = new Random().nextInt(array.length);
	    return array[rnd];
	}

}
