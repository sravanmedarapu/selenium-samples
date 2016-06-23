package com.pratice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class takingscrshot {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static WebDriver driver;
	
	static SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
	static Date curDate = new Date();
	static String strDate = sdf.format(curDate);
	
	public void Scrshot() throws IOException
	{
		
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
	     
		driver = new ChromeDriver();
		 driver.get("https://www.google.com/");
		 driver.manage().window().maximize();

		 File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(scrFile, new File("D:/"+strDate+".jpg"));

	}
	public static void main(String[] args) throws Exception {
		
		
		takingscrshot tobj= new takingscrshot();
		tobj.Scrshot();
		driver.close();
	}
}