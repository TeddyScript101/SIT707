package sit707_week2;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", 
			    "/Users/teddy/Documents/deakin-coursework/sit707/chromedriver-mac-arm64/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement firstnameElement = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + firstnameElement);
		// Send first name
		firstnameElement.sendKeys("Teddy");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		WebElement lastnameElement = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + lastnameElement);
		lastnameElement.sendKeys("Yee");
		
		WebElement phoneNumberElement = driver.findElement(By.id("phoneNumber"));
		System.out.println("Found element: " + phoneNumberElement);
		phoneNumberElement.sendKeys("0490401142");
		
		WebElement emailElement = driver.findElement(By.id("email"));
		System.out.println("Found element: " + emailElement);
		emailElement.sendKeys("s223983938@deakin.edu.au");
		
		WebElement passwordElement = driver.findElement(By.id("password"));
		System.out.println("Found element: " + passwordElement);
		passwordElement.sendKeys("P0201706a@");
		
		WebElement confirmPasswordElement = driver.findElement(By.id("confirmPassword"));
		System.out.println("Found element: " + confirmPasswordElement);
		confirmPasswordElement.sendKeys("wrong@");
		
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		WebElement button = driver.findElement(By.cssSelector("[data-testid='account-action-btn']"));
		button.click();
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		
		// take screenshot
		try {
		    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    File dest = new File("officeworks_registration.png");

		    Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

		    System.out.println("Screenshot saved.");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
//		// Sleep a while
		sleep(5);
//		
//		// close chrome driver
		driver.close();	
	}
	
	public static void woolworths_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", 
			    "/Users/teddy/Documents/deakin-coursework/sit707/chromedriver-mac-arm64/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
			// Load a webpage in chromium browser.
		driver.get(url);
		
	
		
		WebElement emailElement = driver.findElement(By.id("shared-text-input-1"));
		System.out.println("Found element: " + emailElement);
		emailElement.sendKeys("s223983938gmal.com");
		
		WebElement passwordElement = driver.findElement(By.id("signupForm-password"));
		System.out.println("Found element: " + passwordElement);
		passwordElement.sendKeys("P0201706a@");
		
		WebElement firstnameElement = driver.findElement(By.id("shared-text-input-3"));
		System.out.println("Found element: " + firstnameElement);
		firstnameElement.sendKeys("Teddy");
		
		WebElement lastnameElement = driver.findElement(By.id("shared-text-input-4"));
		System.out.println("Found element: " + lastnameElement);
		lastnameElement.sendKeys("Yee");
		
		WebElement dobDlement = driver.findElement(By.id("shared-text-input-5"));
		System.out.println("Found element: " + dobDlement);
		dobDlement.sendKeys("22/11/2003");
		
		WebElement phoneNumberElement = driver.findElement(By.id("shared-text-input-6"));
		System.out.println("Found element: " + phoneNumberElement);
		phoneNumberElement.sendKeys("0490401142");
		
		WebElement termsLabel = driver.findElement(By.cssSelector("label[for='signupForm-tsAndCs']"));
		System.out.println("Found element: " + termsLabel);
		termsLabel.click();
		
		
		WebElement button = driver.findElement(By.cssSelector("button[type='submit']"));
		System.out.println("Found element: " + button);
		button.click();
		
		try {
		    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    File dest = new File("woolworth_registration.png");

		    Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

		    System.out.println("Screenshot saved.");
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		sleep(5);

		driver.close();	
	}
	
	
}
