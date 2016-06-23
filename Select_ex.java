package com.pratice;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_ex {	
	@Test
	public void set() throws InterruptedException
	{

		// Create a new instance of the FireFox driver
		WebDriver driver = new FirefoxDriver();

		// Put an Implicit wait, 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the URL
		driver.get("http://www.toolsqa.com/automation-practice-form");

		// Step 3: Select 'Continents' Drop down ( Use Id to identify the element )
		// Find Select element of "Single selection" using ID locator.
		WebElement ele=driver.findElement(By.id("continents"));
		Select sel = new Select(ele);

		// Step 4:) Select option 'Europe' (Use selectByIndex)
		sel.selectByVisibleText("South America");
		
		 List<WebElement> list = sel.getOptions();

		    for(int i=0;i<list.size();i++){
		        if(list.get(i).getText().equals(sel.getFirstSelectedOption().getText())){
		            System.out.println("The index of the selected option is: "+i);
		            break;
		            }
		    }
		    
		    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());	
		    driver.switchTo().window(tabs.get(0));
		    
		    /*String ele1="//*[@id='sample']";
		    Actions builder = new Actions(driver);
		    builder.keyDown(Keys.CONTROL).click(ele).release().perform(); */
		// Using sleep command so that changes can be noticed
		Thread.sleep(2000);

		// Step 5: Select option 'Africa' now (Use selectByVisibleText)
		sel.selectByIndex(2);
		Thread.sleep(2000);

		// Step 6: Print all the options for the selected drop down and select one option of your choice
		// Get the size of the Select element
		List<WebElement> oSize = sel.getOptions();
		int iListSize = oSize.size();

		// Setting up the loop to print all the options
		for(int i1 =0; i1 < iListSize ; i1++){
			// Storing the value of the option
			String sValue = sel.getOptions().get(i1).getText();
			
			// Printing the stored value
			System.out.println(sValue);
			// Putting a check on each option that if any of the option is equal to 'Africa" then select it 
			if(sValue.equals("Africa")){
				sel.selectByIndex(i1);
				
				
				break;
				}
			}	    
		
	}		

	}
