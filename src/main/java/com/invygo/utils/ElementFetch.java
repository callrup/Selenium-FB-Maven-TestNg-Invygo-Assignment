package com.invygo.utils;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class ElementFetch {

	WebDriver driver;
	public WebElement getWebElement(String IdentifierType, String IdentifierValue) {
		
		switch(IdentifierType)
		{
		case "ID":
		   return BaseTest.driver.findElement(By.id(IdentifierValue));	
		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(IdentifierValue));		
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(IdentifierValue));
		case "TAGNAME":
			return BaseTest.driver.findElement(By.tagName(IdentifierValue));
			default:
			return null;
		}
		
	}
	
public List<WebElement>getListWebElements(String IdentifierType, String IdentifierValue) {
		
		switch(IdentifierType)
		{
		case "ID":
		   return BaseTest.driver.findElements(By.id(IdentifierValue));	
		case "CSS":
			return BaseTest.driver.findElements(By.cssSelector(IdentifierValue));		
		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(IdentifierValue));
		case "TAGNAME":
			return BaseTest.driver.findElements(By.tagName(IdentifierValue));
			default:
			return null;
		}
		
	}
}
