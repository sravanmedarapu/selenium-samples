package com.pratice;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MouseMover {

	/**
	 * @param args
	 */
	
	

    public static final int FIVE_SECONDS = 5000;
    public static final int MAX_Y = 1050;
    public static final int MAX_X = 1900;
    
	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver= new FirefoxDriver();
		   driver.get("https://www.google.com");
		        Robot robot = new Robot();
		        String url= driver.getTitle();
		        while (url!=null) {
		            robot.mouseMove(MAX_X, MAX_Y);
		            Thread.sleep(FIVE_SECONDS);
		        }
		    }
}
