package com.practise.practiseSelenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class AutomatingOneCogniUsingTestNG {

	public WebDriver driver;
	public String urlvar;

	public void readProperty() throws IOException {
		FileInputStream file = new FileInputStream("./src/test/resources/prop.properties");
		Properties property = new Properties();
		property.load(file);

		urlvar = property.getProperty("url");
	}

	public WebDriver openBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"G:\\Eclipse WS\\IdentifyCarWashServices\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	public OneCogniPage openWebsite() throws InterruptedException {
		driver.get(urlvar);
		Thread.sleep(50000);
		return PageFactory.initElements(driver, OneCogniPage.class);
	}

	public void tearDown() {
		driver.quit();
	}
}
