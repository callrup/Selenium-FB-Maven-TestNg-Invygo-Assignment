package com.invygo.pageEvents;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.invygo.pageObject.LoginPageElements;
import com.invygo.utils.Constants;
import com.invygo.utils.ElementFetch;
import com.invygo.utils.SeleniumUtils;

public class Login {

	
WebDriver driver;
	
	public void loginToFaceBook()
	{
		ElementFetch elementfetch = new ElementFetch();
		
		elementfetch.getWebElement("XPATH",LoginPageElements.username).sendKeys(Constants.username);
		elementfetch.getWebElement("XPATH",LoginPageElements.password).sendKeys(Constants.password);
		elementfetch.getWebElement("XPATH",LoginPageElements.submit).click();
		//SeleniumUtils.screenshot(driver, "Landing career Page");
	}
}
