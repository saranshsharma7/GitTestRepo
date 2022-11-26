package com.sframework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver logindriver)
	{
		driver = logindriver;
	 PageFactory.initElements(logindriver, this);
	 
	}
	
	@FindBy(id="email")
	WebElement userEmail;
	
	
	@FindBy(id="passwd")
	WebElement userPassword;
	
	
	@FindBy(name="SubmitLogin")
	WebElement submitLogin;
	
	
	public void getUserName(String username)
	{
		userEmail.sendKeys(username);
	}
	
	public void getPassword(String password)
	{
		userPassword.sendKeys(password);
	}
	
	public void clickLoginBtn()
	{
		submitLogin.click();
	}
}
