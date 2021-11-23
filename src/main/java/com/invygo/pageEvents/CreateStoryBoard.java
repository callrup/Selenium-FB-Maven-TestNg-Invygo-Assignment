package com.invygo.pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.invygo.pageObject.StoryBoardPageElements;
import com.invygo.utils.Constants;
import com.invygo.utils.ElementFetch;
import com.invygo.utils.SeleniumUtils;

public class CreateStoryBoard 
{
	private static WebDriver driver;
ElementFetch elementfetch = new ElementFetch();

	
	public void createStoryBoard() 
	{

		elementfetch.getWebElement("XPATH",StoryBoardPageElements.createStoryBoard).click();
		elementfetch.getWebElement("XPATH",StoryBoardPageElements.createphStory).click();
		elementfetch.getWebElement("XPATH",StoryBoardPageElements.typeInTextArea).sendKeys("Old is Gold");
		elementfetch.getWebElement("XPATH",StoryBoardPageElements.clickCleanDropDown).click();
		elementfetch.getWebElement("XPATH",StoryBoardPageElements.selectFancy).click();
		elementfetch.getWebElement("XPATH",StoryBoardPageElements.shareStory).click();
    }

}