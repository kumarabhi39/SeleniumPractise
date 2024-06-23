package com.practise.practiseSelenium;

import org.openqa.selenium.WebDriver;

public class TrutimePage extends AutomatingOneCogniUsingTestNG{

	public TrutimePage (WebDriver driver){
		this.driver=driver;
	}
	
	public void waiting() throws InterruptedException {
		Thread.sleep(2000);
	}
}
