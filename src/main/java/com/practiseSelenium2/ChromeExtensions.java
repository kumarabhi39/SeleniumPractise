package com.practiseSelenium2;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ChromeExtensions {

	@Test
	public void testing() {

		System.setProperty("webdriver.chrome.driver",
				"G:\\\\Eclipse WS\\\\IdentifyCarWashServices\\\\src\\\\test\\\\resources\\\\drivers\\\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("4.1.8_0.crx"));
		options.addArguments("start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("chrome-extension://mgijmajocgfcbeboacabfgobmjgjcoja/browser_action.html");

	}
}
