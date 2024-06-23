package com.practiseSelenium2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestingSelenium {
//	@Parameters({"a", "b"})
	@Test
	public void testing() {
		
		System.setProperty("webdriver.chrome.driver", "G:\\Eclipse WS\\IdentifyCarWashServices\\src\\test\\resources\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String states = js.executeScript("return document.readyState").toString();
		
		if(states.equals("complete")) {
			System.out.println("Page is loaded completely!");
		}
		
		
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		
//		List<WebElement> links = driver.findElements(By.tagName("a"));
//		System.out.println(links.size());
//		
//		List<WebElement> links2 = driver.findElements(By.xpath("//a"));
//		System.out.println(links2.size());
//		
		driver.quit();
		
//		for(WebElement w : links) {
//			System.out.println(w.getText());
//		}
	}

}
