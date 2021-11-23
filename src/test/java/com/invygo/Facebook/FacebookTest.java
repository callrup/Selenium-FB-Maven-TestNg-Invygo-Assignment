package com.invygo.Facebook;

import org.testng.annotations.Test;

import com.invygo.pageEvents.CreateStoryBoard;
import com.invygo.utils.*;

import com.invygo.pageEvents.Login;

public class FacebookTest extends BaseTest {

	@Test
	
	public void facebooklogin ()
	{
		Login login = new Login();
		login.loginToFaceBook();
		CreateStoryBoard storyboard= new CreateStoryBoard();
		storyboard.createStoryBoard();	
	
}
}