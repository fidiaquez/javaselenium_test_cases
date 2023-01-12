package com.project.pom;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signinPage extends base{

	public signinPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By nameLocator = By.name("userName");
	By passLocator = By.name("password");
	By submitLocator = By.name("submit");
	By loginsuccessLocator= By.tagName("h3");
	
	public void SignIn(){
		if(isDisplayed(nameLocator){
			type("qualitaadmin",nameLocator);
			type("pass1",passLocator);
			click(submitLocator);
			
		
		}
		else {
			System.out.println("Login page not found");
		}
			
		
	}
	
	public String loginMessage() {
		return findElement(loginsuccessLocator).getText();
	}
	

	
	

}
