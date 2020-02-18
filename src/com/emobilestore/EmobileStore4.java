package com.emobilestore;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class EmobileStore4 {
	
	public String url ="http://live.demoguru99.com/";
	public WebDriver driver;
	public String pathDriver = "C:\\My Chrome\\chromedriver.exe";
	public String firstName = "Melany";
	public String lastName = "Boungou";
	public String vEmail = "nicolemalouala3@gmail.com";
	public String vPassword = "123456";

  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", pathDriver);
	       driver = new ChromeDriver();
	       
	       
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test
  public void UserAble() throws Exception{
	  // Navigate to the url
	  driver.get(url);
	  driver.manage().window().maximize();
	  
	  // Click on my Account
	  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[3]/div/div[4]/ul/li[1]/a")).click();
	  
	  
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
		   
		   //Switching to new window
		   for (String handle : driver.getWindowHandles()) {
			 driver.switchTo().window(handle);
		   }
			  
			   
			   // Click on TV
			   driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/a")).click();
			   
			   //Click on  MY WISHLIST LINK
			   //driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]")).click();
			  // Thread.sleep(3000);
			   
			   //Click to Add to my WISHLIST
			 	  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span")).click();
			   
			 	   Thread.sleep(3000);
			   
			   //Switching to new Window
			   for(String handle : driver.getWindowHandles()) {
				   driver.switchTo().window(handle);
			   }
			 	   
			 	   //Enter General shipping country,region and zip code
			   Select Country = new Select (driver.findElement(By.xpath("//*[@id=\"country\"]")));
			          Country.selectByVisibleText("United States");
			      
			          Select Region = new Select (driver.findElement(By.xpath("//*[@id=\"region_id\"]")));
			                 Region.selectByVisibleText("Texas");
			                 
			                 driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys("75056");
			                 
			        // Click Estimate
			                 driver.findElement(By.xpath("//*[@id=\"shipping-zip-form\"]/div/button")).click();
			                 
			        // Verify Shipping Cost Generated
			            String sFlatRate = "Flat Rate";
			            String flatRate = driver.findElement(By.xpath("//*[@id=\"co-shipping-method-form\"]/dl/dt")).getText();
			            
			      try {
			    	  System.out.println("sFlatRate = " +sFlatRate);
			    	  System.out.println("flatRate = " +flatRate);
			    	   
			    	  assertEquals(sFlatRate, flatRate);
			    	  
			      }catch (Exception e) {
					
			    	  e.printStackTrace();
			      }
		   
  
  			String sFlatRatePrice = "Fixed - $5.00";
		     String flatRatePrice = driver.findElement(By.xpath("//*[@id=\"co-shipping-method-form\"]/dl/dd/ul/li/label")).getText();
		     try {
		    	 System.out.println("sFlatRatePrice = "+sFlatRatePrice);
		    	 System.out.println("flatRatePrice ="+flatRatePrice);
		    	 assertEquals(sFlatRatePrice, flatRatePrice);
		     } catch (Exception e) { 
		           e.printStackTrace();
		     
		    	 
		     }
		     
		   // Select Shipping Cost ( click on Radio button), then update total
		     driver.findElement(By.id("s_method_flatrate_flatrate")).click();
		     driver.findElement(By.xpath("//button[@title='Update Total']")).click();
  
  
  // Verify Shipping cost is add to total
  String vFlatRatePrice = "$5.00";
  String shippingCostIncluded = driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[2]/td[2]/span")).getText();
  
  try {
	  System.out.println("vFlatRatePrice = "+vFlatRatePrice);
	  System.out.println("shippingCostIncluded = "+shippingCostIncluded);
	  assertEquals(vFlatRatePrice, shippingCostIncluded);
  } catch (Exception e) {
	 
  
	  e.printStackTrace();
  
	  
  }
  // Click Proceed to Check out
  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[1]/ul/li/button")).click();
  
  Thread.sleep(3000);
  
  
  for(String handle : driver.getWindowHandles()) {
	   driver.switchTo().window(handle);
  }
  
  // Enter Billing information
  //driver.findElement(By.xpath("//*[@id=\"billing:street1\"]")).sendKeys("Leora Ln");
 // driver.findElement(By.xpath("//*[@id=\"billing:city\"]")).sendKeys("Dallas");
 
  //Select Region1 =  new Select(driver.findElement(By.xpath("//*[@id=\"billing:region_id\"]")));
     // Region1.selectByVisibleText("Texas");
     // driver.findElement(By.xpath("//*[@id=\"billing:postcode\"]")).sendKeys("75056");
 // Select Country1 = new Select(driver.findElement(By.xpath("//*[@id=\"billing:country_id\"]")));
       //  Country1.selectByVisibleText("United States");
          
        //driver.findElement(By.xpath("//*[@id=\"billing:telephone\"]")).sendKeys("972-000-2222");
        
        //driver.findElement(By.xpath("//*[@id=\"co-billing-form\"]/div/ul/li[4]/label")).click();
        
        //driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
        //driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(firstName);
       // driver.findElement(By.xpath("//*[@id=\"lastname\"]")).clear();
       // driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(lastName);
        //driver.findElement(By.xpath("//*[@id=\"street_1\"]")).clear();
  //Enter Adress
        driver.findElement(By.xpath("//*[@id=\"billing:street1\"]")).clear();
  driver.findElement(By.xpath("//*[@id=\"billing:street1\"]")).sendKeys("Ohio Dr");
        //driver.findElement(By.xpath("//*[@id=\"city\"]")).clear();
        
        //Enter City
  driver.findElement(By.xpath("//*[@id=\"billing:city\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"billing:city\"]")).sendKeys("Dallas");
        //driver.findElement(By.xpath("//*[@id=\"region_id\"]")).clear();
        
        //Enter Region
        driver.findElement(By.xpath("//*[@id=\"billing:region\"]")).clear();
        
       driver.findElement(By.xpath("//*[@id=\"billing:region\"]")).sendKeys("Texas");
       
       
        // driver.findElement(By.xpath("//*[@id=\"region_id\"]")).sendKeys("Libreville");
        
        //Enter Zip
        driver.findElement(By.xpath("//*[@id=\"billing:postcode\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"billing:postcode\"]")).sendKeys("75056");
       Thread.sleep(3000);
        
       // enter Country
       // driver.findElement(By.xpath("//*[@id=\"billing:country_id\"]")).clear();
        Select Country1 = new Select(driver.findElement(By.xpath("//*[@id=\"billing:country_id\"]")));
               Country1.selectByVisibleText("Angola");
        Thread.sleep(6000);
             
        //driver.findElement(By.id("Country")).sendKeys("Gabon");
        driver.findElement(By.xpath("//*[@id=\"billing:telephone\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"billing:telephone\"]")).sendKeys("972-000-2222");
     
       // Click on Continue Button
       // driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button/span/span")).click();
        
        Thread.sleep(3000);
        //Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"billing-address-select\"]")));
        //dropdown.selectByVisibleText(",Rennes Goma,850 Leora Ln,Lewisville,Texas,75056");
        
        //Click to Radio Button for different address
        driver.findElement(By.id("billing:use_for_shipping_no")).click();
        
        
     // Click on Continue Button
        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button/span/span")).click();
        
        
        
        for (String handle : driver.getWindowHandles()) {
 		   driver.switchTo().window(handle);
 	  }
        //SHIPPING ADDRESS
        
        driver.findElement(By.xpath("//*[@id=\"shipping:firstname\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"shipping:firstname\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"shipping:firstname\"]")).sendKeys(firstName);
        driver.findElement(By.xpath("//*[@id=\"shipping:lastname\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"shipping:lastname\"]")).sendKeys(lastName);
        
        
        driver.findElement(By.xpath("//*[@id=\"shipping:street1\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"shipping:street1\"]")).sendKeys("555 Red fox");
        
        driver.findElement(By.xpath("//*[@id=\"shipping:city\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"shipping:city\"]")).sendKeys("Columbus");
        
        //driver.findElement(By.xpath("//*[@id=\"shipping:region_id\"]")).clear();
        Select country = new Select(driver.findElement(By.xpath("//*[@id=\"shipping:region_id\"]")));
              country.selectByVisibleText("Ohio");
        
        driver.findElement(By.xpath("//*[@id=\"shipping:postcode\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"shipping:postcode\"]")).sendKeys("43222");
        
        
        //shipping country must be selected first from dropdown
        //driver.findElement(By.xpath("//*[@id=\"shipping:country_id\"]")).clear();
        new Select(driver.findElement(By.xpath("//*[@id=\"shipping:country_id\"]"))).selectByVisibleText("United States");
        
        //driver.findElement(By.xpath("//*[@id=\"shipping:region_id\"]")).clear();
        //Select country = new Select(driver.findElement(By.xpath("//*[@id=\"shipping:region_id\"]")));
               //country.selectByVisibleText("Ohio");
        
        //driver.findElement(By.xpath("//*[@id=\"shipping:region_id\"]")).clear();
        //driver.findElement(By.xpath("//*[@id=\"shipping:region_id\"]")).sendKeys("Ohio");
        
        //driver.findElement(By.xpath("//*[@id=\"shipping:city\"]")).clear();
       // driver.findElement(By.xpath("//*[@id=\"shipping:city\"]")).sendKeys("Columbus");
        
        //driver.findElement(By.xpath("//*[@id=\"shipping:postcode\"]")).clear();
      //  driver.findElement(By.xpath("//*[@id=\"shipping:postcode\"]")).sendKeys("43222");
        
        driver.findElement(By.xpath("//*[@id=\"shipping:telephone\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"shipping:telephone\"]")).sendKeys("4503332222");
        
        Thread.sleep(3000);
        
       //Click continu button of shipping
        driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/button/span/span")).click();
        
        //Click on shipping method button continue
         driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button/span/span")).click();
         
         // Select check/order money and then click continu
         driver.findElement(By.xpath("//*[@id=\"p_method_checkmo\"]")).click();
         driver.findElement(By.xpath("//*[@id=\"payment-buttons-container\"]/button/span/span")).click();
         
         // Click on Place Order
         driver.findElement(By.xpath("//*[@id=\"review-buttons-container\"]/button/span/span")).click();
         
 
  }
  
		     
        @AfterTest
		     public void afterTest() {
		    	 
		     }	  
	
}
		    	 
		   



