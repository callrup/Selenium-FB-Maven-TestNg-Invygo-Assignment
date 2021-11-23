package com.invygo.utils;

import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

//import org.openqa.selenium.support.ui.ExpectedCondition;


public class SeleniumUtils extends SuiteListener {
	
	public static WebDriver driver ;
	public static ExtentTest logger;
	
	public static WebElement findElement(String loc)
	{
		WebElement element = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver,60);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc)));
		
		if (element.isDisplayed())
		{
			
		}
		else 
		{
			Assert.assertTrue(element.isDisplayed());
		}
		}
		
		catch (Exception e)
		{
			System.out.println("Element not found");
		}
		
		return element;
	}

	public static void scrollToTheElement(String locator)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement ele = findElement(locator);
		js.executeScript("arguments[0].scrollIntoView();",ele);
		
	}
	
	public static void scrolldown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight || document.documentElement.scrollHeight)", "");js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public static WebElement waitForElementVisible(By Loc) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element;

        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(Loc));
            return element;
        } catch (TimeoutException te) {
            return null;
        }
    }
	
	 public static boolean isPageLoaded(By selector) {
	        return waitForElementVisible(selector) != null;
	    }
	 
	 public  boolean isHomePageLoaded() {
	        return isPageLoaded(By.xpath(null));
	    }
	 
	 public static void waitForLoad(WebDriver driver) {
	        ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
	                };
	        WebDriverWait wait = new WebDriverWait(driver, 60);
	        wait.until(pageLoadCondition);
	    }
	 
	 public static void swtchToActiveElement()
	 {
		 driver.switchTo().defaultContent();
	 }
	 
	 
	 public static void swtchToAlert(WebDriver driver)
	 {
		 WebDriverWait wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.alertIsPresent());
		 Alert alert=driver.switchTo().alert();
  		 System.out.println(alert.getText());
  	     alert.accept();
	 }
	 


    // waits until a list of elements is displayed and returns the list, or null
    protected List<WebElement> waitForElementsVisible(By elementSelector) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        List<WebElement> elements;

        try {
            elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementSelector));
            return elements;
        } catch (TimeoutException te) {
            return null;
        }
    }

    public static void switchToNewTab() {
        Set<String> handles = driver.getWindowHandles();
        if(handles.size() > 1) {
            try {
                String currentHandle = driver.getWindowHandle();

                for (String handle : handles) {
                    if (!handle .equals(currentHandle)) {
                        driver.close(); //otherwise, you will have the browser window still opened at the end of the test
                        driver.switchTo().window(handle);
                    }
                }
            } catch(NullPointerException exception) {
                System.out.println("Something didn't work at switching tabs.");
            }
        } else {
        	System.out.println("No new tab was opened.");
        }
    }
    
    public static void switchtToTab() {
        switchToNewTab();
    }
    
    public static void screenshot(WebDriver driver,String screenshotName)
    {
    	 if (driver instanceof TakesScreenshot) {

    	try 
    	{
    	DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
        Date date = new Date();
    	TakesScreenshot ts=(TakesScreenshot) driver;
    	 
    	File source=ts.getScreenshotAs(OutputType.FILE);
    	File file = new File(System.getProperty("user.dir") + "\\screenshots\\"+screenshotName+dateFormat.format(date)+".jpg");
        String dest = file.getCanonicalPath();
        File destination = new File(dest);
    	//String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
    	//FileHandler.copy(source, new File("./screenshots/"+screenshotName+dateFormat.format(date)+".png"));
        FileHandler.copy(source,destination);
    	System.out.println("Screenshot taken");
    	} 
    	catch (Exception e)
    	{
    	 
    	System.out.println("Exception while taking screenshot "+e.getMessage());
    	} 

    	 }
    }
   
    
    
   
    }

