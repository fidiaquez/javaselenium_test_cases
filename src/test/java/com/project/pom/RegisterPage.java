package com.project.pom;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends base {

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	By userNameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmpasswordLocator = By.name("confirmPassword");
	By registerButtonLocator = By.name("submit");
	By registeredMessage = By.tagName("font");
	

	public void registerUser() throws InterruptedException {
		click(registerLinkLocator);
		Thread.sleep(2000);
	    
		if (isDisplayed(registerPageLocator)) {
			type("qualitaadmin",userNameLocator);
			type("pass1",passwordLocator);
			type("pass1",confirmpasswordLocator);
			click(registerButtonLocator);			
		
		}
		else {
			System.out.println("Register page was not found");
			}
			
	}
	
	public String registerMessage() {
		List<WebElement> fonts = findElements(registeredMessage);
		return fonts.get(5).getText();
	}
}
