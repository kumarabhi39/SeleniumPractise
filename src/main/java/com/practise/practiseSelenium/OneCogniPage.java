package com.practise.practiseSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestListener;

public class OneCogniPage extends AutomatingOneCogniUsingTestNG{

	public OneCogniPage (WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath = "//body//div[@id='DesktopPlatformBar']//div[@class='row']//div[@class='row']//div[1]//div[1]//div[2]//img[1]")
	public WebElement trutime;
	
	public TrutimePage clickonTrutime() {
		trutime.click();
		return PageFactory.initElements(driver, TrutimePage.class);

	}
}
