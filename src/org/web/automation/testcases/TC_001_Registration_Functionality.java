package org.web.automation.testcases;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_001_Registration_Functionality {
	ChromeDriver driver;
	
	@BeforeMethod
	public void startBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		//driver.navigate().to("https://www.google.com/");
		driver.get("https://www.thetestingworld.com/testings/"); 
		
		//driver.navigate().back();
		//Thread.sleep(5000);
		//driver.navigate().forward();
		//Thread.sleep(5000);
		//driver.navigate().refresh();
		
	}
	
	@Test
	public void tc001() throws InterruptedException {
		 
		// Enter data
		driver.findElementByName("fld_username").sendKeys("dtest4070");
		driver.findElementByName("fld_email").sendKeys("dtest4070@gmail.com");
		driver.findElementByName("fld_password").sendKeys("Thetest&123");
		driver.findElementByName("fld_cpassword").sendKeys("Thetest&123");
		driver.findElementByName("dob").sendKeys("01/01/1990");
		driver.findElementByName("phone").sendKeys("1234567890");
		driver.findElementByName("address").sendKeys("123 Test Street");
		
		driver.findElementByXPath("//input[@name='add_type' and @value='home']").click();
		
	
		Select gender = new Select(driver.findElementByName("sex"));
		gender.selectByIndex(2);
		
		Select country = new Select(driver.findElementById("countryId"));
		country.selectByVisibleText("United States");
		
		// Print all country
		List<WebElement> allOptions = country.getOptions();
		for(WebElement e : allOptions) {
			System.out.println(e.getText());
		}
		
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElementById("stateId"), "California"));
	
		Select state = new Select(driver.findElementById("stateId"));
		state.selectByVisibleText("California");
		
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElementById("cityId"), "Los Angeles"));
		
		Select city = new Select(driver.findElementById("cityId"));
		city.selectByVisibleText("Los Angeles");
		
		driver.findElementByName("zip").sendKeys("90001");
		
		System.out.println(driver.findElementByName("terms").isSelected());
		driver.findElementByName("terms").click();
		System.out.println(driver.findElementByName("terms").isSelected());
		
		// Fetch data
		 System.out.println("URL of Current Page is : -->  " + driver.getCurrentUrl());
	     System.out.println("Title of Page is : -- > " + driver.getTitle());
	     System.out.println("HTML OF PAGE IS HERE : -- > " +  driver.getPageSource());
		
	     // Click Sign up
	     System.out.println("Element Enable : " + driver.findElementByXPath("//input[@value='Sign up']").isEnabled());
	     System.out.println("Element Visible : " + driver.findElementByXPath("//input[@value='Sign up']").isDisplayed());
		 driver.findElementByXPath("//input[@value='Sign up']").click();
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		//driver.close();
	}

}

