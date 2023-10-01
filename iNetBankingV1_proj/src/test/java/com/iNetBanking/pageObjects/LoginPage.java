package com.iNetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	// https://demo.guru99.com/V4/index.php
	
	WebDriver ldriver; //localDriver
	
	public LoginPage(WebDriver rdriver) //remoteDriver, created constructor
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this); //Pagefactory class 
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	
	//Action methods:
	
	public void setUserName(String userName) 
	{
		txtUserName.sendKeys(userName);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickSubmit()
	{
		btnLogin.click(); 
	}
	
	public void clickLogout()
	{
		lnkLogout.click(); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
