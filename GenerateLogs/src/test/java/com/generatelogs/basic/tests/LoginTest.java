package com.generatelogs.basic.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	Logger log = Logger.getLogger(LoginTest.class);
	
	@BeforeMethod
	public void setup(){

		log.info("************Starting test execution**************");

		System.setProperty("webdriver.chrome.driver", "E:\\All Elements\\Java Selenium\\Prosmart\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("Launching Chrome Browser");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/");
		log.info("Entering application URL");
		log.warn("Hey this just a warn message");
		log.fatal("Hey this is just fatal error message");
		log.debug("This is debug message");
	}
	
	@Test(priority=1)
	public void FreeCrmTitleTest(){
		log.info("************Starting Test cases**************");
		String title = driver.getTitle();
		System.out.println(title);
		log.info("Login page title--->"+title);
		Assert.assertEquals(title, "#1 Free CRM Software in the cloud for sales and service");
		log.info("************Ending Test cases**************");

	}
	
	@Test(priority=2)
	public void FreeCrmLogoTest(){
		log.info("************Starting Test cases**************");

		boolean b = driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed();
		Assert.assertTrue(b);
		log.info("************Ending Test cases**************");

	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		log.info("************Browser is Closed**************");

	}
}
