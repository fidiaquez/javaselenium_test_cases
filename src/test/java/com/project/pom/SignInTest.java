package com.project.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class SignInTest {
	
	private WebDriver driver;
	signinPage signInPage;

	@Before
	public void setUp() throws Exception {
		signInPage = new signinPage(driver);
		driver = signInPage.chromeDriverConnection();
		signInPage.visit("https://demo.guru99.com/test/newtours/");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		signInPage.SignIn();
		Thread.sleep(2000);
		assertEquals("Login Successfully",signInPage.loginMessage());
	}

}
