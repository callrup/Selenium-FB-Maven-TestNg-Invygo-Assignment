package com.invygo.pageObject;



public interface StoryBoardPageElements {

	
String createStoryBoard	= "//div[@class='bp9cbjyn is6700om qavdm89g gsh9l1b6 lwukve8w jpyiy761 j83agx80 k7cz35w2 taijpn5t bsnbvmp4']//*[name()='svg']//*[name()='g' and contains(@fill-rule,'evenodd')]//*[name()='g' and contains(@fill-rule,'nonzero')]//*[name()='path' and contains(@d,'M95 201.5h')]";
String clickCreateIcon= "//a[@aria-label='Create'][@href='/stories/create/']";
//String createphStory= "//div[@class='k4urcfbm pmk7jnqg stjgntxs ni8dbmo4 datstx6m l82x9zwi uo3d90p7 pw54ja7n ue3kfks5']//i[@data-visualcompletion='css-img']";
String createphStory="//div[contains(text(),'Create a Text Story')]";
String typeInTextArea = "//label[@aria-label='Start typing']";
String clickCleanDropDown="//div[@aria-label='Font style']";
String selectFancy ="//div[contains(text(),'fancy')]";
String shareStory = "//span[contains(text(),'Share to Story')]";




}
