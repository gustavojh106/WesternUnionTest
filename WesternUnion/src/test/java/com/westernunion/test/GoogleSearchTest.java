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
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchTest {

		private WebDriver driver;
		
		@Before
		public void setUp() {
			System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver104/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.google.com/");
		}
		@Test
		public void testGooglePage() {
			WebElement searchbox = driver.findElement(By.name("q"));//se encuentra el elemento (input html) por inspeccionar pagina
			searchbox.clear(); //borrar todo lo que exista en la barra de busqueda
			searchbox.sendKeys("perros"); //envia el texto que queremos buscar
			searchbox.submit(); //simula la presion de un "enter" para hacer submit del formulario
			new WebDriverWait(driver, Duration.ofSeconds(10));

			assertEquals("perros - Buscar con Google", driver.getTitle() ); // comprueba que el titulo de la pagina resultante sea "perros"
		}
		
		@After
		public void tearDown() {
			driver.quit();
		}
		
		
}
