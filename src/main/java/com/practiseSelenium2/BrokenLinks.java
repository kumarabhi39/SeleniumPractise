package com.practiseSelenium2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.practise.practiseSelenium.TrutimePage;

public class BrokenLinks {

	@Test
	public void testing() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"G:\\\\Eclipse WS\\\\IdentifyCarWashServices\\\\src\\\\test\\\\resources\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		int brokenCount = 0;
		
		for(WebElement e:links) {
			String url= e.getAttribute("href");
			URL weblink=new URL(url);
			HttpURLConnection httpC =(HttpURLConnection) weblink.openConnection();
			httpC.connect();
			
			if(httpC.getResponseCode()>=400) {
				System.out.println("Broken link: "+ url);
				brokenCount++;
			}else {
				System.out.println("Valid link: "+ url);
			}
			
		}
		System.out.println("Total broken links: "+brokenCount);
		driver.quit();
		
//		driver.wait(10000);
	}
	
}
