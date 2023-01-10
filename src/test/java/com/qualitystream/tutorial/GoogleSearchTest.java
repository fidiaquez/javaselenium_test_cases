package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class GoogleSearchTest {
	
	private WebDriver driver;
	By videoLinkLocator = By.id("dimg_1");
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testGooglePage() {
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("Selenium");
		searchbox.submit();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//assertEquals("Selenium - Buscar con Google",driver.getTitle());
		
		
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10L))
				.pollingEvery(Duration.ofSeconds(2L))
				.ignoring(NoSuchElementException.class);
		
		WebElement video = fwait.until(new Function<WebDriver,WebElement>(){
		public WebElement apply(WebDriver driver) {
			return driver.findElement(videoLinkLocator);
		}
		}
		);
		
		assertTrue(driver.findElement(videoLinkLocator).isDisplayed());
		
	}

	@After
	public void teardown() {
		driver.quit();
	}

}
