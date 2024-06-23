package com.practise.practiseSelenium;

import java.io.IOException;

import org.testng.IReporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAutomatingOneCogniUsingTestNG 
//implements IReporter
{

	AutomatingOneCogniUsingTestNG obj1 = new AutomatingOneCogniUsingTestNG();
	OneCogniPage obj2;
	TrutimePage obj3;
	
	@BeforeClass
	public void open() throws IOException {
		obj1.readProperty();
		obj1.openBrowser();
	}
	
	@Test
	public void testing() throws InterruptedException {
		
		obj2=obj1.openWebsite();
		obj3=obj2.clickonTrutime();
		obj3.waiting();
	}
	
	@AfterClass
	public void closeBrowser() {
		obj1.tearDown();
	}
}
