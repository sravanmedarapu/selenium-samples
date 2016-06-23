package com.pratice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Upload_AutoIt {

	
 WebDriver driver;
	
	  @Test
	 public void setup() throws Exception {
	  driver =new FirefoxDriver();     
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
	  //Click on browse button.
	  driver.findElement(By.name("img")).click();    
	  
	  //To execute autoIt script .exe file which Is located at E:\\AutoIT\\ location.
	  Runtime.getRuntime().exec("D:\\Madhu\\Autoit_Trng\\Upload.exe");
	  
	}
}