package com.iNetBanking.testCases;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass

{
  
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		
		//Logger.info("URL is Opened");
		Thread.sleep(3000);
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		//Logger.info("Username is Entered");
		
		lp.setPassword(password);
		//Logger.info("Password is Entered");
		
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage1"))
		{
		   Assert.assertTrue(true);
		  // Logger.info("LoginTest Pass");
		}else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			//Logger.info("LoginTest Fail");
		}
	}
	
}
