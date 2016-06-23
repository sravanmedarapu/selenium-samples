package com.pratice;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class handlingalert {
	public static WebDriver driver;

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
	     
		driver = new ChromeDriver();
		  driver.get("http://www.rediff.com/");
		  //driver.manage().deleteAllCookies();
		  driver.findElement(By.xpath("//a[@title='Already a user? Sign in']")).click();
		  driver.findElement(By.xpath("//input[@name='proceed']")).click();
		  Alert al = driver.switchTo().alert();
		  System.out.println(al.getText());
		  al.dismiss();
		 // al.dismiss(); //only if cancel is there . In our case cancel is not there.
		 
		 }
		

}
