package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class formdata {

	public WebDriver driver;
	
	By name=By.name("name");
	By email=By.name("email");
	By pass=By.xpath("//input[@placeholder='Password']");
	By dob=By.xpath("//label[text()='Date of Birth']");
	
	
	public formdata(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement personname()
	{
		return driver.findElement(name);
	}
	
	public WebElement personaemail()
	{
		return driver.findElement(email);
	}
	
	public WebElement personpassword()
	{
		return driver.findElement(pass);
	}
	
}

