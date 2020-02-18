package com.emobilestore;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class EmobileStore5 {
	
	public String url = "http://live.demoguru99.com/";
	public WebDriver driver;
	public String pathDriver = "C:\\firefox\\geckodriver.exe";
	public String firstName = "Melany";
	public String lastName = "Boungou";
	public String vEmail = "nicolemalouala3@gmail.com";
	public String vPassword = "123456";
  
	@BeforeTest
	  public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", pathDriver);
		    driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
  public void MyOrders() throws Exception {
		//Navigate to url
		
		driver.get(url);
		driver.manage().window().maximize();
		
		// Click on my Account
		
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/ul/li[1]/a")).click();
		
		Thread.sleep(3000);
		
		// Switching to new window
		  for (String handle : driver.getWindowHandles()) {
			   driver.switchTo().window(handle);
		  }
			   driver.findElement(By.id("email")).clear();
			   driver.findElement(By.id("email")).sendKeys(vEmail);
			   driver.findElement(By.id("pass")).clear();
			   driver.findElement(By.id("pass")).sendKeys(vPassword);
			   driver.findElement(By.id("send2")).click();
			   
			   Thread.sleep(3000);
			   
			   // Switching to new window
			   for (String handle : driver.getWindowHandles()) {
				   driver.switchTo().window(handle);
			}
			   //Click on my orders
  
	driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[4]/a")).click();
 
	// Click on view orders
	
	driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/table/tbody/tr/td[6]/span/a[1]")).click();
	
	//Print the orders
	
	driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/a[2]")).click();
	}
  @AfterTest
  public void afterTest() {
  }

}
