package com.westernunion.test;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WesternUnionTest {

		private WebDriver driver;
		
		@Before
		public void setUp() {
			System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver104/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			//driver.manage().timeouts().im
			driver.get("https://www.westernunion.com/lt/en/home.html");
		}
		@Test
		public void testGooglePage() {
			
			driver.findElement(By.id("hamburger-nav-item")).click();
			driver.findElement(By.linkText("Settings")).click();
			
			new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("Question")));
			
			Select countrySelect = new Select(driver.findElement(By.id("Question")));
			countrySelect.selectByVisibleText("United States");
			
			driver.findElement(By.xpath("//translate[text()='Yes']")).click();
			
			assertEquals("https://www.westernunion.com/us/en/home.html", driver.getCurrentUrl()); 

		}
		
		@After
		public void tearDown() {
			driver.quit();
		}
		
		
}
