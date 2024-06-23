package com.practiseSelenium2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGGoogleSearchCognizant {
	
	/**
	 * Print the 10 results that show on search bar when just typed Cognizant there
	 */
	
	@Test
	public void googleSearchCognizant() {
		
		System.setProperty("webdriver.chrome.driver", "G:\\Eclipse WS\\IdentifyCarWashServices\\src\\test\\resources\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Cognizant");
		
		List<WebElement> searchResults = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		
		for(WebElement w : searchResults) {
			System.out.println(w.getText());
		}
		
//		for(int i=0; i<searchResults.size(); i++) {
//			String s = searchResults.get(i).getText();
//			System.out.println(s);
//		}
		
		driver.quit();

		
	}

}
