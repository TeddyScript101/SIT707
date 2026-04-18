package web.service;

import java.io.File;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {
	
    private static final String CHROME_DRIVER_PATH = "/Users/teddy/Documents/deakin-coursework/sit707/chromedriver-mac-arm64/chromedriver"; 
    private WebDriver driver;

    private String getHtmlFilePath() {
        File htmlFile = new File("/Users/teddy/Documents/deakin-coursework/sit707/7.1P/7.1P-resources/pages/login.html");
        return htmlFile.toURI().toString();
    }

    private void sleep(long sec) {
        try { 
            Thread.sleep(sec * 1000); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        }
    }
	
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.navigate().to(getHtmlFilePath());
        sleep(1); 
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); 
        }
    }

    @Test
    public void testSelenium_ValidLogin() {
        driver.findElement(By.id("username")).sendKeys("teddy");
        driver.findElement(By.id("passwd")).sendKeys("password");
        
        // Note: If this fails, try changing "2026-04-18" to "18042026" or "04182026" depending on your Chrome locale
        driver.findElement(By.id("dob")).sendKeys("18042026"); 
		
        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(2);
		
        String title = driver.getTitle();
        System.out.println("[testSelenium_ValidLogin] Title: " + title);
        Assert.assertEquals("success", title);
    }

    @Test
    public void testSelenium_InvalidPassword() {
        driver.findElement(By.id("username")).sendKeys("teddy");
        driver.findElement(By.id("passwd")).sendKeys("wrong_password"); 
        driver.findElement(By.id("dob")).sendKeys("2026-04-18"); 
		
        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(2);
		
        String title = driver.getTitle();
        System.out.println("[testSelenium_InvalidPassword] Title: " + title);
        Assert.assertEquals("fail", title);
    }

    @Test
    public void testSelenium_InvalidDob() {
        driver.findElement(By.id("username")).sendKeys("teddy");
        driver.findElement(By.id("passwd")).sendKeys("password");
        driver.findElement(By.id("dob")).sendKeys("1990-01-01"); 
		
        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(2);
		
        String title = driver.getTitle();
        System.out.println("[testSelenium_InvalidDob] Title: " + title);
        Assert.assertEquals("fail", title);
    }

    @Test
    public void testSelenium_EmptyFormSubmit() {
        driver.findElement(By.cssSelector("[type=submit]")).submit();
        sleep(2);
		
        String title = driver.getTitle();
        System.out.println("[testSelenium_EmptyFormSubmit] Title: " + title);
        Assert.assertEquals("fail", title);
    }
}