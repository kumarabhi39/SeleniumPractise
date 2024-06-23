package com.practiseSelenium2;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows {

	public static void main(String[] args) {

//		System.setProperty("webdriver.chrome.driver",
//				"G:\\Eclipse WS\\IdentifyCarWashServices\\src\\test\\resources\\drivers\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement e1 = driver.findElement(By.xpath("//button[@onClick='multiwindow()']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", e1);

		String mw = driver.getWindowHandle();
		System.out.println(mw);
		System.out.println("-----------");
		Set<String> cws = driver.getWindowHandles();

		for (String cw : cws) {
			System.out.println(cw);
		}
		System.out.println("--------------");

		Iterator<String> it = cws.iterator();

		while (it.hasNext()) {
			String cw = it.next();

			if (!mw.equals(cw)) {
				driver.switchTo().window(cw);
				System.out.println("-----------");
				System.out.println(cw);
				System.out.println("-----------");

				try {
					WebElement e = driver.findElement(By.xpath("//h2[text()='Getting Started']"));
					System.out.println(e.isDisplayed());
					System.out.println(cw);

				} catch (Exception e) {
//					driver.close();
					System.out.println(e);
				}

				try {
					WebElement e2 = driver.findElement(By.xpath("//img[@id='logo']"));
					System.out.println(e2.isDisplayed());
					System.out.println(cw);
				} catch (NoSuchElementException e) {
//					driver.close();
					System.out.println(e);
				}
			}
		}
		driver.quit();
	}
}
