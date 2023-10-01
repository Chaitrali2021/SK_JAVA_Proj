package com.iNetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
    
	@FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement addNewCustomer;
	
	@FindBy(how=How.NAME, using="name")
	@CacheLookup
	WebElement customerName;
	
	@FindBy(how=How.NAME, using="rad1")
	@CacheLookup
	WebElement gender;
	
	@FindBy(how=How.NAME, using="dob")
	@CacheLookup
	WebElement DOB;
	
	@FindBy(how=How.NAME, using="addr")
	@CacheLookup
	WebElement address;
	
	@FindBy(how=How.NAME, using="city")
	@CacheLookup
	WebElement city;
	
	@FindBy(how=How.NAME, using="state")
	@CacheLookup
	WebElement state;
	
	@FindBy(how=How.NAME, using="pinno")
	@CacheLookup
	WebElement pin;
	
	@FindBy(how=How.NAME, using="telephoneno")
	@CacheLookup
	WebElement mobileNumber;
	
	@FindBy(how=How.NAME, using="emailid")
	@CacheLookup
	WebElement emailId;
	
	@FindBy(how=How.NAME, using="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.NAME, using="sub")
	@CacheLookup
	WebElement submit;
	
	
	public void clickAddNewCustomer()
	{
		addNewCustomer.click();
	}
	
	public void customerName(String cName)
	{
		customerName.sendKeys(cName);
	}
	
	public void customerGender(String cGender)
	{
		gender.click();
	}
	
	public void customerDOB(String mm, String dd, String yy)
	{
		DOB.sendKeys(mm);
		DOB.sendKeys(dd);
		DOB.sendKeys(yy);
	}
	
	public void customerAddress(String cAddress)
	{
		address.sendKeys(cAddress);
	}
	
	public void customerCity(String cCity)
	{
		city.sendKeys(cCity);
	}
	
	public void customerState(String cState)
	{
		state.sendKeys(cState);
	}
	
	public void customerPIN(String cPin)
	{
		pin.sendKeys(cPin);
	}
	
	public void customerMobileNumber(String cMobileNo)
	{
		mobileNumber.sendKeys(cMobileNo);
	}
	
	public void customerEmailId(String cEmail)
	{
		emailId.sendKeys(cEmail);
	}
	
	public void customerPassword(String cPassword)
	{
		password.sendKeys(cPassword);
	}	
	
	public void clickSubmitBtn()
	{
		submit.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
