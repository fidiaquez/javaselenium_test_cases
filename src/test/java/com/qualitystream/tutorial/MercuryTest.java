package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTest {
	
	private WebDriver driver;
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	By userNameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmpasswordLocator = By.name("confirmPassword");
	By registerButtonLocator = By.name("submit");
	
	By nameLocator = By.name("userName");
	By passLocator = By.name("password");
	By submitLocator = By.name("submit");
	By loginsuccessLocator= By.tagName("h3");
	
	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
		
	}
	
	@Test
	public void registerUser() throws InterruptedException{
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		if(driver.findElement(registerPageLocator).isDisplayed()) {
			driver.findElement(userNameLocator).sendKeys("qualitaadmin");
			driver.findElement(passwordLocator).sendKeys("pass1");
			driver.findElement(confirmpasswordLocator).sendKeys("pass1");
			driver.findElement(registerButtonLocator).click();
		}
		else {
		System.out.println("Register page was not found");
		}
		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		assertEquals("Note: Your user name is qualitaadmin.",fonts.get(5).getText());
		
		
	}
	
	@Test
	public void SignIn() throws InterruptedException{
		
		if(driver.findElement(nameLocator).isDisplayed()) {
			driver.findElement(nameLocator).sendKeys("qualitaadmin");
			driver.findElement(passLocator).sendKeys("pass1");
			driver.findElement(submitLocator).click();
			
			Thread.sleep(2000);
			
			assertEquals("Login Successfully",driver.findElement(loginsuccessLocator).getText());
		}
		else {
			System.out.println("Login page not found");
		}
		
	}
	
	
	
	@After
	public void teardown() {
		//driver.quit();
	}
	
}
