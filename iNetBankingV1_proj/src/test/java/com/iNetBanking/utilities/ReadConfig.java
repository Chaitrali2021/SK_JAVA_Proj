package com.iNetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro; // pro is object
	
	public ReadConfig() //constructor = for loading config file runtime
	{
		File src= new File("./ConfigurationFiles/config.properties");
		//src is variable referring to config.properties file
		try {
		FileInputStream fis= new FileInputStream(src);	
		pro =new Properties(); //pro object is initialized
		pro.load(fis); //load is method to load file runtime
	} catch (Exception e)
		{
		  System.out.println("Exception is" + e.getMessage());
		
	    }

}
	
	//methods to read different values from config.proprties file
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxpath=pro.getProperty("Firefoxpath");
		return firefoxpath;
	}
	
	
	
	
	
	
	
	
	
	
	
}