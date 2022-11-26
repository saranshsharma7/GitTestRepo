package com.sframework.testCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.sframework.pageObjects.HandleCheckBoxAndRadioButton;


public class TC_HandleCheckBoxAndRadioButton extends BaseClass {
	
	//@Test(priority=0)
	public void selectRadioButton()
	{
		HandleCheckBoxAndRadioButton radioButton=new HandleCheckBoxAndRadioButton(driver);
		radioButton.radioButton1().click();
		if(radioButton.radioButton1().isSelected()){
			Assert.assertTrue(true);
			Logger.info("radioButton1 is selected.");
			System.out.println("radioButton1 is selected.");
			
		}else{
			try {
				captureScreen(driver,"Failed to select radioButton1.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
			Logger.info("Failed to select radioButton1.");
		}
		radioButton.radioButton2().click();
		radioButton.radioButton3().click();
		
		
	}
	
	
	//@Test(priority=1)
	public void selectCheckBox()
	{
			
		WebElement loopcheckbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
		List<WebElement> selectAll= loopcheckbox.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("size of list" + Integer.toString(selectAll.size()));
		for (WebElement inputtag:selectAll)
		{
			
				inputtag.click();
				if(inputtag.isSelected()){
					
					System.out.println("is selected");
				}else{
					System.out.println("not selected");
					
				}
				
			}		
	}
	
//@Test(priority=0)
 public void selectDrodown()
 {
	 
	 Select dropdown=new Select(driver.findElement(By.id("fruits")));
	 if(dropdown.isMultiple())
	 {
		 System.out.println("True");
	 }
	 else{
		 System.out.println("False");
	 }
	 dropdown.selectByVisibleText("Banana");
	 dropdown.selectByIndex(2);
	 dropdown.deselectAll();
	 dropdown.selectByValue("banana");
	 
	 
 }
 
 //@Test(priority=0)
 public void hoverMouse(){
	 
	 WebElement linktext= driver.findElement(By.linkText("Selenium"));
	 WebElement colour=driver.findElement(By.className("dropdown-toggle"));
	 Actions builder=new Actions(driver);
	 Action mousehover= builder.moveToElement(linktext).build();
	 
	String textcolour=colour.getCssValue("color");
	System.out.println("Beforehover"+ textcolour);
	
	 mousehover.perform();
	 
	 try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
 
 //@Test(priority=0)
 public void drgaAndDrop()
 
 {
   WebElement from=driver.findElement(By.id("credit2"));
   WebElement to=driver.findElement(By.cssSelector("#bank > li:nth-child(1)"));
   Actions dragdrop= new Actions(driver);
   try {
	Thread.sleep(3000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   dragdrop.dragAndDrop(from, to).build().perform();  
}
 
 //@Test(priority=0)
 public void alertFunctions(){
	 
	 WebElement cusID=driver.findElement(By.name("cusid"));
	 WebElement submit=driver.findElement(By.name("submit"));
	 cusID.sendKeys("12345");
	 submit.click();
	 
	 Alert alert=driver.switchTo().alert();
	 String alertmsg=driver.switchTo().alert().getText();
	 
	 System.out.println("Alert message:"+ alertmsg);
	 try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 alert.accept();
	 
 }
 
 //@Test(priority=0)
 public void checkBrokenURL()
 {
	 driver.get(baseurl);
	 String url = "";
	 HttpURLConnection huc = null;
     int respCode = 200;
     
     List<WebElement> links = driver.findElements(By.tagName("a"));
     
     Iterator<WebElement> it = links.iterator();
     
     while(it.hasNext()){
         
         url = it.next().getAttribute("href");
         
         System.out.println(url);
     
         if(url == null || url.isEmpty()){
             System.out.println("URL is either not configured for anchor tag or it is empty");
             continue;
         }
         
         if(!url.startsWith(baseurl)){
             System.out.println("URL belongs to another domain, skipping it.");
             continue;
         }
         
         try {
             huc = (HttpURLConnection)(new URL(url).openConnection());
             
             huc.setRequestMethod("HEAD");
             
             huc.connect();
             
             respCode = huc.getResponseCode();
             
             if(respCode >= 400){
                 System.out.println(url+"==> is a broken link");
             }
             else{
                 System.out.println(url+"==> is a valid link");
             }
                 
         } catch (MalformedURLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
     }
 }
	
 
}

