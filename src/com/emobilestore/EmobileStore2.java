package com.emobilestore;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class EmobileStore2 {
	
	public String url = "http://live.demoguru99.com/";
	public WebDriver driver;
	
	@BeforeTest
	  public void beforeTest() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\My Chrome\\chromedriver.exe");
		
		driver = new ChromeDriver();
	  }

	
	
  @Test
  public void Emobilebaskectpage() {
	  
	  driver.get(url);
	  driver.manage().window().maximize();
	  
	  driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a")).click();
  }
  @AfterClass
  public void afterClass() {
  }



}
