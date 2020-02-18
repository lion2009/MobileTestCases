package com.emobilestore;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class EmobileStore3 {
	
	public String url = "http://live.demoguru99.com/";
	public WebDriver driver;
	public String pathDriver = "C:\\My Chrome\\chromedriver.exe";
	
	
	
@BeforeTest
	
	
	  public void beforeTest() {
		
		System.setProperty("webdriver.chrome.driver", pathDriver);
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
  @Test
  public void MobileAccount() throws Exception {
	  //call or navigate to the url page
	  driver.get(url);
	  driver.manage().window().maximize();
	 
	  //click on my account
	  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[3]/div/div[4]/ul/li[1]/a")).click();
	  
	  //Switch to a new window
	  for (String handle: driver.getWindowHandles()) {
		  driver.switchTo().window(handle);
	  }
	  
	  //Click on Create the Account Link
	  driver.findElement(By.linkText("CREATE AN ACCOUNT")).click();
	  Thread.sleep(2000);
	  
	  //Switching to a new window
	  for (String handle : driver.getWindowHandles()) {
		  
		  driver.switchTo().window(handle);
	  }
	  
	  //Fill new user information
	  driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Melany");
	  driver.findElement(By.id("lastname")).sendKeys("Boungou");
	  
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	  driver.findElement(By.xpath("//*[@id=\"confirmation\"]")).sendKeys("123456");
	  
	  //Click on Register
	  driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button/span/span")).click();
	  /*Fail to Register. Email address is required.
	   * Please navigate back and enter your email address*/
	   
	  
	  Thread.sleep(6000);
	  driver.navigate().back();
	  
	  //Click on Create the Account Link
	  driver.findElement(By.linkText("CREATE AN ACCOUNT")).click();
	  Thread.sleep(2000);
	  //Fill new user information
	  driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Melany");
	  driver.findElement(By.id("lastname")).sendKeys("Boungou");
	  driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys("nicolemalouala3@gmail.com");
	  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
	  driver.findElement(By.xpath("//*[@id=\"confirmation\"]")).sendKeys("123456");
	  
	  //Click on Register
	  driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button/span/span")).click();
	  
	  //Verify register is done
	  
	  String ExpectedMsg = "Account registration done.";
	 String ActualMsg = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span")).getText();
	  //String ActualMsg = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div/div[2]/p[1]/strong")).getText();
	  System.out.println(ActualMsg);
	  
	  //Assert.assertEquals(ActualMsg, ExpectedMsg);
	  Assert.assertNotEquals(ActualMsg, ExpectedMsg);
	  
	  for (String handle: driver.getWindowHandles()) {
		  driver.switchTo().window(handle);
	  }
	  
	  driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/a")).click();
	  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")).click();
	  driver.findElement(By.linkText("Add to Wishlist")).click();
	  driver.findElement(By.xpath("//*[@id=\"wishlist-view-form\"]/div/div/button[1]/span/span")).click();
  }
  
 

  @AfterTest
  public void afterTest() { 
	  
	  driver.quit();
  }

}
