package com.sframework.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class HandleCheckBoxAndRadioButton
{

	WebDriver driver;
	
	public HandleCheckBoxAndRadioButton(WebDriver HandleCARdriver)
	{
		driver=HandleCARdriver;
		PageFactory.initElements(HandleCARdriver, this);
	}
	
	By radioButton1= By.id("vfb-7-1");
	public WebElement radioButton1()
	{
		return driver.findElement(radioButton1);
	}
	
	
	By radioButton2= By.id("vfb-7-2");
	public WebElement radioButton2(){
		return driver.findElement(radioButton2);
	}
	
	By radioButton3=By.id("vfb-7-3");
	public WebElement radioButton3()
	{
		return driver.findElement(radioButton3);
	}
	
	By checkBox1=By.id("vfb-6-0");
	public WebElement checkBox1()
	{
		return driver.findElement(checkBox1);
	}
	
	By checkBox2=By.id("vfb-6-1");
	public WebElement checkBox2()
	{
		return driver.findElement(checkBox2);
	}
	
	By loopselectcheckbox=By.xpath("//input[@type='checkbox']");
	public WebElement loopselectcheckbox()
	{
		return driver.findElement(loopselectcheckbox);
	}
	
	By selectDroddown=By.name("country");
	public WebElement selectDroddown()
	{
		return driver.findElement(selectDroddown);
	}
	
	}

	

