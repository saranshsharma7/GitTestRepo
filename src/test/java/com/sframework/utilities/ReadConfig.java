package com.sframework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	
	{
		//Get config.properties file path
		File src= new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
			
			
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
	}
	
	// Get data from config.properties file
	public String getApplicationUrl()
	
	{
		String baseurl=pro.getProperty("baseurl");
		return baseurl;
	}
	
	
	public String getApplicationUsernamel()
	
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getApplicationPassword()
	
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromeDriver()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	public String getIEDriver()
	{
		String ipath=pro.getProperty("ipath");
		return ipath;
	}
	public String getFireFoxDriver()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}

}
