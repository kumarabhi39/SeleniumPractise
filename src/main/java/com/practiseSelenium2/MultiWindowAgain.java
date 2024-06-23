package com.practiseSelenium2;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultiWindowAgain {

	@Test
	public void testingMultipleWindow() {
		
		System.setProperty("webdriver.chrome.driver", "G:\\Eclipse WS\\IdentifyCarWashServices\\src\\test\\resources\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://jobserve.com/in/en/Job-Search/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String mw= driver.getWindowHandle();
		System.out.println(mw);
		
		driver.findElement(By.xpath("//img[@alt='Try JobServe from your Mobile']")).click();
//		.sendKeys("Hey", Keys.ENTER);

		
		Set<String> whs=driver.getWindowHandles();
		
		Iterator<String> it=whs.iterator();
		String pw = it.next();
		String sw=it.next();
		
		System.out.println(pw+" "+ sw);
		
		driver.switchTo().window(sw);
		
		driver.findElement(By.xpath("//input[@id='JobSearch_Keywords']")).sendKeys("Abhishek");
		
		driver.quit();
		
//		ChromeDriver driver2=new ChromeDriver();
//		driver2.navigate().to("url");
		
	}
	
}
