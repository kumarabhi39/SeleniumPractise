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

public class FindBrokenLinks {

	@Test
	public void findBrokenLinksOnAWebPage() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"G:\\\\Eclipse WS\\\\IdentifyCarWashServices\\\\src\\\\test\\\\resources\\\\drivers\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://www.google.co.in/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		int Brokencount = 0;

		for (WebElement e : links) {
			// System.out.println(e);

			String url = e.getAttribute("href");
			URL webLink = new URL(url);
			HttpURLConnection httpC = (HttpURLConnection) webLink.openConnection();
			httpC.connect();

			int code = httpC.getResponseCode();

			if (code >= 400) {
				System.out.println("Broken link: " + url);
				Brokencount++;
			} else {
				System.out.println("Valid link: " + url);
			}

		}

		System.out.println();
		System.out.println(Brokencount + " broken links are present on the webpage.");
		System.out.println();
		System.out.println("All links on the webpage have been checked.");
		driver.quit();
	}

}
