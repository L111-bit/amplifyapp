package com.MyTrip;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calculator {

	WebDriver driver;
	
	
	@BeforeTest
	@Parameters(value= {"browser"})
	public void SetUp(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
		
		String url = "https://www.makemytrip.com/";
		//String url ="https://www.spicejet.com";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=1)
	public void Search() throws InterruptedException {
	
		
		Thread.sleep(1000);
		Actions action = new Actions(driver);
	
		Thread.sleep(1000);
		List<WebElement> Menu = driver.findElements(By.xpath("//span[@class='chNavText darkGreyText']"));
		
		
		for(WebElement option : Menu) {
			System.out.println(option.getText());
			if(option.getText().equalsIgnoreCase("Hotels")) {
				option.click();
				break;
			}
			
			
		}
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[2]//a[1]//span[2]")));
//		
//		WebElement Hotels =	driver.findElement(By.xpath("//li[2]//a[1]//span[2]"));
//	    action.moveToElement(Hotels).build().perform();
//		
//		
//		WebElement Flight =driver.findElement(By.xpath("//a[@class='active makeFlex hrtlCenter column']"));
//		action.moveToElement(Flight).build().perform();
		
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Round Trip')]//span")));
		
		WebElement RoundTrip = driver.findElement(By.xpath("//li[contains(text(),'Round Trip')]//span"));
	    RoundTrip.click();
		
      
	   String FROM = "Delhi";
	   String TO   = "Bangaluru";
	  
	  
		WebElement FromCity = (driver.findElement(By.xpath("//input[@id='fromCity']")));
		FromCity.sendKeys(FROM);
		
//		Thread.sleep(500);
		WebElement FromDropdown = driver.findElement(By.xpath("//p[text()='Delhi, India']"));
		action.moveToElement(FromDropdown).build().perform();
		
		
		
		System.out.println(FROM+"city is selected");
		
		
//		Thread.sleep(500);
		WebElement TOCity = (driver.findElement(By.xpath("//input[@id='toCity']")));
		TOCity.sendKeys(TO);
		
		WebDriverWait wait2 = new WebDriverWait(driver,30);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Bengaluru, India']")));

		WebElement TODropdown = driver.findElement(By.xpath("//p[text()='Bengaluru, India']"));
		action.moveToElement(TODropdown).build().perform();
		
		System.out.println(TO+"city is selected");

	   
//   		if(var.getText().equals("New Delhi, India (DEL)"))
//   		{ 
//   			var.click();
//   			break; 
//	}
   	
   	}
	@Test(priority=2)
	  public void City() throws InterruptedException {
	  
		
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		Thread.sleep(1000);
		action.sendKeys(Keys.PAGE_UP).build().perform();
		
		
	 
	
	
}
	
	@Test(priority = 3)
	public void Calendar() throws InterruptedException {
		
		
		WebElement date = driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]"));
		date.click();
		
		WebDriverWait wait3 = new WebDriverWait(driver,30);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Tue Aug 11 2020']//div[1]")));
		
		driver.findElement(By.xpath("//div[@aria-label='Tue Aug 11 2020']//div[1]")).click();
		
		
		Thread.sleep(200);
		driver.findElement(By.xpath("//div[@aria-label='Fri Sep 11 2020']")).click();
		//WebElement date = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_txt_Fromdate']"));
		
//		String dateval ="30-08-2020";
//		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].setAttribute('value','"+dateval+"');", date);
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
