package sit707_week2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BunningsLoginTest {

    private WebDriver driver;
    private String baseUrl = "https://www.bunnings.com.au/login";
    private WebDriverWait wait;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", 
            "/Users/teddy/Documents/deakin-coursework/sit707/chromedriver-mac-arm64/chromedriver");
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        
   
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        handleBuddyPopup();
    }

    private void handleBuddyPopup() {
        try {
      
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(., 'Close') or contains(., 'thanks')]")
            ));
            closeButton.click();
        } catch (Exception e) {
            System.out.println("Popup not detected.");
        }
    }

    @Test
    public void r1_loginEmpty() {
  
        driver.findElement(By.id("login-submit")).click(); 

        WebElement emailError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username-error-message")));
        WebElement passError = driver.findElement(By.id("password-error-message"));

        Assert.assertEquals("This field is required", emailError.getText());
        Assert.assertEquals("This field is required", passError.getText());
    }

    @Test
    public void r2_invalidEmail() {
        driver.findElement(By.id("username")).sendKeys("not-an-email");
        driver.findElement(By.id("login-submit")).click();


        WebElement emailError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username-error-message")));
        Assert.assertEquals("Please provide a valid email address", emailError.getText());
    }

    @Test
    public void r3_incorrectCredentials() {
        driver.findElement(By.id("username")).sendKeys("testuser@example.com");
        driver.findElement(By.id("password")).sendKeys("WrongPassword123");
        driver.findElement(By.id("login-submit")).click();

 
        WebElement alert = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//div[@data-locator='form-error-alert']")
        ));
        
        Assert.assertTrue(alert.getText().contains("Your email address or password is incorrect"));
    }
    

    @Test
    public void r4_validLogin() {

        driver.findElement(By.id("username")).sendKeys("*****@gmail.com");
        driver.findElement(By.id("password")).sendKeys("*****");
        
  
        driver.findElement(By.id("login-submit")).click();


        wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("/login")));
        
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Login successful. Redirected to: " + currentUrl);
        
    
        Assert.assertFalse("URL should change after successful login", 
            currentUrl.contains("/login"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}