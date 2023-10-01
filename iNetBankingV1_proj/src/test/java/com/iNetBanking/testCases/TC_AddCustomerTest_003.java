package com.iNetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.pageObjects.AddCustomerPage;
import com.iNetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass 

{
	/**
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	@Test
  public void addNewCustomer() throws InterruptedException, IOException
  {
	 LoginPage lp=new LoginPage(driver); 
	 lp.setUserName(username);
	 lp.setPassword(password);
	 lp.clickSubmit();
	 
	 Thread.sleep(3000);
	 
	 AddCustomerPage addCustomer=new AddCustomerPage(driver);
	
	  addCustomer.clickAddNewCustomer();
	  addCustomer.customerName("Pavan");
	  addCustomer.customerGender("male");               
	  addCustomer.customerDOB("10", "15", "1985");
	  Thread.sleep(3000);
	  addCustomer.customerAddress("India");
	  addCustomer.customerCity("Hydrabad");
	  addCustomer.customerState("Telangana");
	  addCustomer.customerPIN("5000074");
	  addCustomer.customerMobileNumber("1234567890");
	  addCustomer.customerEmailId(randomString()+"@gmail.com");
	  addCustomer.customerPassword("abcdef");
	  addCustomer.clickSubmitBtn();
	  
	  Thread.sleep(3000);
	  
	  boolean res= driver.getPageSource().contains("Customer Registered Successfully!!!");
	  
	  if(res==true)
	  {
		  Assert.assertTrue(true);
		  System.out.println("New Custmer Added Successfully.");
	  }
	  
	  else
	  {
		  captureScreen(driver, "addNewCustomer");
		  Assert.assertTrue(false);
	  }
  }

	/*add below methods in baseclass for reusing in other Tcs if required
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5); //It is inbuilt method and 5 means it will generate string of 5 random chars 
		return generatedString;
	}
	
	public String randomNum()
	{
		String generatedNumeric=RandomStringUtils.randomNumeric(5); //It is inbuilt method and 5 means it will generate string of 5 random numbers 
		return generatedNumeric;
	}*/	
}
