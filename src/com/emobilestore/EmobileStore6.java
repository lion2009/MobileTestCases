package com.emobilestore;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class EmobileStore6 {
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
	// go to the url and maximaze the page
  public void ReOrder() throws Exception {
		driver.get(url);
		driver.manage().window().maximize();
		
		
driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/ul/li[1]/a")).click();
		
		Thread.sleep(3000);
		
		// Switching to new window
		  for (String handle : driver.getWindowHandles()) {
			   driver.switchTo().window(handle);
		  }
		  // Login to my account
			   driver.findElement(By.id("email")).clear();
			   driver.findElement(By.id("email")).sendKeys(vEmail);
			   driver.findElement(By.id("pass")).clear();
			   driver.findElement(By.id("pass")).sendKeys(vPassword);
			   driver.findElement(By.id("send2")).click();
			   
			//Click on Reorder
			   
			   driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[3]/table/tbody/tr/td[6]/span/a[2]")).click();
			   
			   //Click On Quantity and update
			    driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/input")).clear();
			    driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/input")).sendKeys("10");
			    
			    //  Click Update
			    driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/button")).click();
			   
			    // Verifier grand total is changed
			    String  VerifierPrice = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[3]/span/span")).getText();
			    String GrandTotal = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tfoot/tr/td[2]/strong/span")).getText();
			    
			   /* try {
			    	System.out.println("VerifierPrice =" + VerifierPrice);
			    	System.out.println("GrandTotal =" + GrandTotal);
			    	
			    	assertEquals(VerifierPrice, GrandTotal);
			    	
			    	
			    }catch (Exception e) {
			    	e.printStackTrace();
			    		
			    	}*/
			    if(VerifierPrice == GrandTotal) {
			    	
			    	System.out.println(VerifierPrice + "" +  "has not changed");
			    }else {
			    	System.out.println(GrandTotal + "" + " Grand total price has changed");
			    }

			    // Select Shipping Cost ( click on Radio button), then update total
			    
			   // driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[2]/div/div/form[2]/dl/dd/ul/li/label")).click();
			    //driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[2]/div/div/form[2]/div/button/span/span")).click();
			    
			    //Verifier shipping cost is added to the shipping cost
			   // String vFlateratePrice = "$ 50.00";
			    //String ShippingCostIncluded = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[2]/div/div/form[2]/div/button/span/span")).getText();
			    
			    
			    
			   // Thread.sleep(3000);
			    //driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button/span/span")).click();
			    
			    //Click on Proceed to Checkout
			     
			    driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button/span/span")).click();
			    
			    Thread.sleep(3000);
			    
			    
			    for(String handle : driver.getWindowHandles()) {
			  	   driver.switchTo().window(handle);
			    }
			    
			    // Click on radio button for different address
			   // driver.findElement(By.cssSelector("#billing\\:use_for_shipping_no")).clear();
			   // driver.findElement(By.cssSelector("#billing\\:use_for_shipping_no")).click();
			    
			    //Click on Continue button
			    //driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[1]/div[2]/form/div/div/button")).click();
			    
			    
			    // Billing Information
			    
			   /* try {
			    	Select BillInfo = new Select(driver.findElement(By.name("billing_address_id")));
			    	int BillInfoSize = BillInfo.getOptions().size();
			    	BillInfo.selectByIndex(BillInfoSize-1);
			    } catch (Exception e) {
			    	e.printStackTrace();
			 System.out.println("No dropdown element present");*/
			    
			
			   // driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[1]/div[2]/form/div/ul/li[1]/div/select/option[3]")).click();
			    //driver.findElement(By.xpath("//*[@id=\"billing-address-select\"]")).sendKeys("New Address");
			    
			    
			   // driver.findElement(By.xpath("//*[@id=\"billing:use_for_shipping_no\"]")).clear();
			   // driver.findElement(By.xpath("//*[@id=\"billing:use_for_shipping_no\"]")).click();
			    
			    //driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[1]/div[2]/form/div/div/button/span/span")).click();
			    
			Select Address  =  new Select(driver.findElement(By.xpath("//*[@id=\"billing-address-select\"]")));
			       Address.selectByVisibleText("New Address");
			       
			       //Enter billing information
			       
			       // Address
			       driver.findElement(By.xpath("//*[@id=\"billing:street1\"]")).clear();
			       driver.findElement(By.xpath("//*[@id=\"billing:street1\"]")).sendKeys("555 Refugee Rd");
			       
			       //City
			       driver.findElement(By.xpath("//*[@id=\"billing:city\"]")).clear();
			       driver.findElement(By.xpath("//*[@id=\"billing:city\"]")).sendKeys("Cincinnati");
			       
			       //enter Region
			       //Select region = new Select(driver.findElement(By.xpath("//*[@id=\"billing:region_id\"]")));
			              //region.selectByVisibleText("Ohio");
			       driver.findElement(By.id("billing:region")).clear();
			       driver.findElement(By.id("billing:region")).sendKeys("OHIO");
			       
			       
			       // enter zip code
			       driver.findElement(By.xpath("//*[@id=\"billing:postcode\"]")).clear();
			       driver.findElement(By.xpath("//*[@id=\"billing:postcode\"]")).sendKeys("43222");
			      
			       Thread.sleep(3000);
			      
			      //enter country
			       Select country = new Select(driver.findElement(By.xpath("//*[@id=\"billing:country_id\"]")));
			              country.selectByVisibleText("United States");
			              
			              Thread.sleep(3000);
			              
			              //enter phone number
			              driver.findElement(By.xpath("//*[@id=\"billing:telephone\"]")).clear();
			              driver.findElement(By.xpath("//*[@id=\"billing:telephone\"]")).sendKeys("555-222-1111");
			              
			              Thread.sleep(3000);
			              // Click ship to different address
			              driver.findElement(By.xpath("//*[@id=\"billing:use_for_shipping_no\"]")).click();
			              
			              //Click on continue button
			             driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[1]/div[2]/form/div/div/button/span/span")).click();
			              
			              //Select ShippingAddress = new Select(driver.findElement(By.xpath("//*[@id=\"shipping-address-select\"]")));
			                    // ShippingAddress.selectByVisibleText("New Address");
			             
			             Thread.sleep(3000);
			             
			             // Click as the same address as billing 
			             driver.findElement(By.id("shipping:same_as_billing")).click();
			             
			             //Click on continue
			             driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[2]/div[2]/form/div/button/span/span")).click();
			             
			             Thread.sleep(2000);
			             //Click on Continue for shipping method
			             driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[3]/div[2]/form/div[3]/button/span/span")).click();
			             
			             //Payment information by clicking on the radio button
			             driver.findElement(By.xpath("//*[@id=\"p_method_checkmo\"]")).click();
			             
			             Thread.sleep(2000);
			             
			             // Click on Continue button
			             driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/div[2]/button/span/span")).click();
			             
			             //Place Order
			             driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[5]/div[2]/div/div[2]/div/button/span/span")).click();
			             
			                  
			       
			   
			    
			    
    } 
			    
	
			    
			    
			   
			   
			   
			   
  





@AfterTest
  public void afterTest() {
	
  }
}

