package com.practise.practiseSelenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class AutomatingOnecogni {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream("./src/test/resources/prop.properties");
		Properties property = new Properties();
		property.load(file);
		
		System.setProperty("webdriver.chrome.driver", "G:\\Eclipse WS\\IdentifyCarWashServices\\src\\test\\resources\\drivers\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
		WebDriver driver= new ChromeDriver();
		
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(driver.getTitle(), "OneCognizant");
		
		WebElement trutime=driver.findElement(By.xpath("//*[@id=\"div_hotappscontainer\"]/div/div[2]/div/div[1]/div[1]/div/div[2]/img"));		
		trutime.click();
		
		Assert.assertEquals(driver.getTitle(), "OneCognizant");
		
		WebElement frameInTruTime = driver.findElement(By.xpath("//iframe[@id='appFrame']"));
		driver.switchTo().frame(frameInTruTime);
		
		String textInTruTime = driver.findElement(By.xpath("//a[@class='nav-link active']")).getText();
		System.out.println(textInTruTime);
		
		System.out.println("Executed fully");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
		
	}

}
