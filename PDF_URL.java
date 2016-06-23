package com.pratice;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class PDF_URL {

	//   http://www.princexml.com/samples/flyer/flyer.pdf
		
		
	@Test
		public void testVerifyPDFInURL() {
			WebDriver driver = new FirefoxDriver();
			driver.get("http://www.princexml.com/samples/");
			driver.findElement(By.linkText("PDF flyer")).click();
			String getURL = driver.getCurrentUrl();
			Assert.assertTrue(getURL.contains(".pdf"));
			}
	
	
		/*@Test
		public void testRichText(){
			
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://yizeng.me/2014/01/31/test-wysiwyg-editors-using-selenium-webdriver/");
			 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			 driver.findElement(By.xpath("//a[@id='cke_34']")).click();
			 driver.switchTo().frame(0);
			 System.out.println("Switched into frame");
			 driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr']/p")).sendKeys("Hello...There...");
			 
			 

			 driver.findElement(By.xpath("//div[@id='mce_4']")).click();
			 driver.switchTo().frame("tinymce-editor_ifr");
			 System.out.println("Switched into frame");
			 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			 
			 WebElement body= driver.findElement(By.xpath("//body[@id='tinymce']/p"));
		      Actions builder = new Actions(driver);
		      Actions seriesOfActions = builder.moveToElement(body).click().sendKeys(body,"Hi...Please Die beofore I Kill You.");
		      seriesOfActions.perform();
		      System.out.println("Text Entered");
		      System.out.println("Hello");
			 driver.findElement(By.xpath("//body[@id='tinymce']/p")).sendKeys("Hello...There...");
			 System.out.println("Text Entered");
			 
			 
*/			 
			
	
}
