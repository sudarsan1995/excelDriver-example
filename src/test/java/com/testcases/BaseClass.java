package com.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

	

	public WebDriver driver;
	public Properties pro;

public WebDriver setup() throws IOException
{
	 pro=new Properties();
	
	File src=new File("./configurations/config.properties");
	FileInputStream fis=new FileInputStream(src);
	
	pro.load(fis);
	
	String desiredbrowser=pro.getProperty("browser");
	String chromedriver=pro.getProperty("chromebrowser");
	String firefoxdriver=pro.getProperty("firefoxbrowser");
	String iedriver=pro.getProperty("iebrowser");
	String edgedriver=pro.getProperty("edgebrowser");
	
	
	if(desiredbrowser.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", chromedriver);
				driver=new ChromeDriver();
	}
	else if(desiredbrowser.equals("firefox"))
	{
		System.setProperty("webdriver.chrome.driver", firefoxdriver);
		driver=new FirefoxDriver();
	}
	
	else if(desiredbrowser.equals("ie"))
	{
		System.setProperty("webdriver.chrome.driver", iedriver);
		driver=new InternetExplorerDriver();
	}
	
	else if(desiredbrowser.equals("edge"))
	{
		System.setProperty("webdriver.edge.driver", "G:\\edgedriver_win64 - Copy\\msedgedriver.exe");
		driver = new EdgeDriver();
	}
	
	System.out.println(desiredbrowser);
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	return driver;
	
}


public static String takeScreenshot(WebDriver driver,String testCaseName) throws IOException
{
	
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	
	TakesScreenshot ts=(TakesScreenshot) driver;
	
	File src=ts.getScreenshotAs(OutputType.FILE);
	String target = System.getProperty("user.dir") + "/screenshots/" +testCaseName +".png";
	FileUtils.copyFile(src,new File(target));
	
	System.out.println("Screenshot Taken");
	
	return target;
	

}

}


