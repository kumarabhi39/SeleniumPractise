package com.practiseSelenium2;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class MaximizingUsingArgumentsInOptions {

	@Test
	public void testing() {
	
	System.setProperty("webdriver.chrome.driver", "G:\\Eclipse WS\\IdentifyCarWashServices\\src\\test\\resources\\drivers\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	
	options.addArguments("start-maximized");
	
	WebDriver driver= new ChromeDriver(options);
	
	driver.get("https://www.google.com/");
	
//	Dimension d = new Dimension(1000,1000);
//	driver.manage().window().setSize(d);
//	Point p=new Point(0,-1000);
//	System.out.println(p.getX()+p.getY());
//	System.out.println(p.x+p.y);
//	driver.manage().window().setPosition(p);
//	driver.manage().window().maximize();
	
	}
	
}
