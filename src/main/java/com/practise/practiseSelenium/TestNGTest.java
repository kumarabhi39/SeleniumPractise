package com.practise.practiseSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGTest 
implements ITestListener 
{
	
	public void onStart(ITestContext context) {
		context.getName();
		context.getSkippedTests();
	}
	public void onTestFailure(ITestResult result) {
		result.getTestContext().getName();
		result.getName();
	}
	
	@Ignore
	@Test
//	(dependsOnMethods = "", alwaysRun = true, ignoreMissingDependencies = true)
	public  void testing() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", 
				"G:\\Eclipse WS\\IdentifyCarWashServices\\src\\test\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}
	
	@Test(dataProvider="data")
	public void m(Object[] o) {
	
		for(Object ob: o) {
		System.out.println(ob);
		}
	
	}
	
	@DataProvider(name="data")
	public Object[][] data(){

//	return new Object[][]{

//			{"name", "password"},
//			{"name2", "password2"},
//			{"name3", "password3", "name4"}
//		
//			};

//	Object[][] data=new Object[][]{
		Object[][] data={
				{"Abhishek", "One"},
				{"Abhishek", "Two"},
				{"Abhishek", "One", "Two"}
			};
	return data;

		}

	}

