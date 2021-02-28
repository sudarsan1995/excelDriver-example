package com.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pageobjects.formdata;

import com.utilities.ExcelDriven;
import com.utilities.ListenerClass;


@Listeners(ListenerClass.class)
public class TC_01_DataDriven extends BaseClass {

	
	public WebDriver driver;
	public ExcelDriven edp;
	

	
	
	
	@BeforeTest
	public void initializeDriver() throws IOException, InterruptedException
	{
		
		
		driver=setup();
		driver.get(pro.getProperty("url"));// this basically retrieving value from property file	
		Thread.sleep(4000);
	
	}
	
	
	@Test
	public void a_readExcelData() throws IOException, InterruptedException
	{
			
		edp=new ExcelDriven();
		formdata form=new formdata(driver);
		
		form.personname().click();
		form.personname().sendKeys(edp.getStringData("form", 0, 0));
		System.out.println(edp.getStringData("form", 0, 0));
		
		form.personaemail().click();
		form.personaemail().sendKeys(edp.getStringData("form", 0, 1));
		System.out.println(edp.getStringData("form", 0, 1));
		
	
	
		form.personpassword().click();
		form.personpassword().sendKeys(edp.getNumericgData("form", 0, 2));
		System.out.println(edp.getNumericgData("form", 0, 2));
		Assert.assertTrue(false);
		
	}
	
	
	@Test
	public void b_simple()
	{
		System.out.println("entered into b_simple");	
	}
	
	
	
	@Test
	public void c_simple()
	{
		System.out.println("entered into c_simple");	
	}
	
	
	
	@Test
	public void d_simple()
	{
		System.out.println("entered into d_simple");	
	}
	
	
	
	@Test
	public void e_simple()
	{
		System.out.println("entered into e_simple");	
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		//driver.close();
	}


	}

	

