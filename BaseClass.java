package com.iNetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.iNetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig(); //create object for readconfig
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	
	
	/*public String baseURL="https://demo.guru99.com/V4/index.php";
	public String username="mngr476215";
	public String password="evUsury";*/
	public static WebDriver driver;
	//public static Logger Logger;
	
	@Parameters("browser")//craeted xml file for this at project level
	@BeforeClass
	public void setup(String br)
	{
	
		//Logger=Logger.getLogger("ebanking");
		   //PropertyConfigurator.configure("Log4j.properties");
		if(br.equals("chrome"))
		{	
	 System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");//F:\\Selenium_Self Practice\\eBankingMiniProject_Maven\\iNetBankingV1 = Project Path = System.getProperty("user.dir")
	   //System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());

	   driver=new ChromeDriver();
		}
		else if (br.equals("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());

			   driver=new FirefoxDriver();
		}
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get(baseURL);
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source,target);
		System.out.println("Screenshot taken");	
	}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5); //It is inbuilt method and 5 means it will generate string of 5 random chars 
		return generatedString;
	}
	
	public String randomNum()
	{
		String generatedNumeric=RandomStringUtils.randomNumeric(5); //It is inbuilt method and 5 means it will generate string of 5 random numbers 
		return generatedNumeric;
	}
}
