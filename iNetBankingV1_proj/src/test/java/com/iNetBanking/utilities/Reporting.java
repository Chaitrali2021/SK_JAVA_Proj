package com.iNetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//Listener Class used to generate extent report.

public class Reporting extends TestListenerAdapter //testlisteneradapter is imported not created manually

{
  public ExtentHtmlReporter htmlReporter;
  public ExtentReports extent;
  public ExtentTest logger;
  
  public void onStart(ITestContext testContext)
  
  {
	  String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//timestamp
	  String repName="Test-Report-"+timeStamp+".html";
	  htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/" +repName);//specify location
	  htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
	  
	  extent=new ExtentReports();
	  
	  extent.attachReporter(htmlReporter);
	  extent.setSystemInfo("Host name", "localhost");
	  extent.setSystemInfo("Environment", "QA");
	  extent.setSystemInfo("user", "SK");
	  
	  htmlReporter.config().setDocumentTitle("InetBanking Test Project");//title of report
	  htmlReporter.config().setReportName("FUnctional Automation Test Report");//name of the report
	  //htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//location of the chart
	  htmlReporter.config().setTheme(Theme.DARK);
	 
  }
  
  public void onTestSuccess(ITestResult tr)
  
  {
	  logger=extent.createTest(tr.getName());//create new entry in the report
	  logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));//send passed info in green color
  }
  
  public void onTestFailure(ITestResult tr)
  {
	  logger=extent.createTest(tr.getName());//create new entry in report
	  logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));//send failed info in red color
      
	  String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
	  
	  File f=new File(screenshotPath);
	  
	  if(f.exists())
	  {
		  try {
			  logger.fail("SCreenshot is below:"+logger.addScreenCaptureFromPath(screenshotPath));
		  }catch(IOException e) {
			  e.printStackTrace();
		  }
		  
	  }
	  
  }  
	  public void onTestSkipped(ITestResult tr)
	  
	  {
		  logger=extent.createTest(tr.getName());//create new entry in report
		  logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));//send skipped info in orange color
	  }
  
  public void onFinish(ITestContext testContext)
  {
	  extent.flush();
  }
  
  
  
  
  
}
