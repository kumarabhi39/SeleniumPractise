package com.practiseSelenium2;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MultipleWindow {

	@Test
	public void testingMultipleWindows() throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "G:\\Eclipse WS\\IdentifyCarWashServices\\src\\test\\resources\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://jobserve.com/in/en/Job-Search/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String mainWindow= driver.getWindowHandle();
		System.out.println(mainWindow);
		
		driver.findElement(By.xpath("//img[@alt='Try JobServe from your Mobile']")).click();
		
		
//		Point p=new Point(0, 0);
//		p.x=2;
//		p.y=5;
//		System.out.println(p.getX()+p.getY());
//		Dimension d=new Dimension(2,5);
		
		
		Set<String> windows= driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
//		while (iterator.hasNext()) {
//      String ChildWindow = iterator.next();
//          if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
//          driver.switchTo().window(ChildWindow);
//          WebElement text = driver.findElement(By.id("sampleHeading"));
//          System.out.println("Heading of child window is " + text.getText());
//      }
//  }
		
		String mW = it.next();
		String sW = it.next();
		
		driver.switchTo().window(sW);
		
		driver.findElement(By.xpath("//input[@id='JobSearch_Keywords']")).sendKeys("Abhishek");
		Thread.sleep(5000);
		
		driver.close();
		driver.switchTo().window(mW);
		
		driver.findElement(By.xpath("//img[@alt='Try JobServe from your Mobile']")).click();
		
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./src/test/resources/ss1.png"));
		
		Thread.sleep(2000);
		driver.quit();
		
//		Alert a= driver.switchTo().alert();
		
		

		
				
//		Actions a= new Actions(driver);
//		a.clickAndHold(driver.findElement(By.xpath("//input[@id='JobSearch_Keywords']"))).moveToElement(null).release().build().perform();
		
		
	}
	
}
