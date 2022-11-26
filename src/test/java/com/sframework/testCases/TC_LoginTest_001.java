package com.sframework.testCases;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.sframework.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass

{
	

	@Test(priority=0)
	public void openURL() throws IOException, InterruptedException
	
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
		
		if(driver.getCurrentUrl().equals("https://demo.guru99.com/test/guru99home/"))
		{
			Assert.assertTrue(true);
			Logger.info("Url open: https://demo.guru99.com/test/login.html");
		  	   System.out.println("Url open: https://demo.guru99.com/test/login.html");
		      }
		     else{
		    	 captureScreen(driver,"Error 404.");
					Assert.assertTrue(false);
					Logger.info("Error 404.");
		   	          System.out.println("Error 404.");
		   	          
		   	          
		     }	
		
		WebElement webUrl;
		webUrl= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'rt-header\']/div/div[2]/div/ul/li[4]/a")));
		webUrl.click();
	
}
	//@Test(priority=1)
	public void userLogin() throws IOException
	
	{
		//user login
		
		LoginPage userlogin=new LoginPage(driver);
		userlogin.getUserName(username);
		Logger.info("Username Entered: "+ username);
		userlogin.getPassword(password);
		Logger.info("Password Entered: "+ password);
		userlogin.clickLoginBtn();
				
		     if(driver.getCurrentUrl().equals("https://demo.guru99.com/test/success3.html"))
		         {
		    	 Assert.assertTrue(true);
		    	 Logger.info("User Login Successfully.");
			  	   System.out.println("User Login Successfully.");
		    	 
		} 
		     else{
		    	 captureScreen(driver,"Login Failed.");
		    	 Assert.assertTrue(false);
		    	 System.out.println("Login Failed.");
		     }
	}
	
		
}
	  
	  
	  
