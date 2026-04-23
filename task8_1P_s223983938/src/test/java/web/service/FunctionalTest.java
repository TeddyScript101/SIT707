package web.service;

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

public class FunctionalTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String BASE_URL = "http://localhost:8080"; 

    @Before
    public void setUp() {
        String driverPath = "/Users/teddy/Documents/deakin-coursework/sit707/chromedriver-mac-arm64/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        // Wait up to 10 seconds for elements/conditions
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    private void loginAsValidUser() {
        driver.get(BASE_URL + "/login");
        driver.findElement(By.id("username")).sendKeys("teddy");
        driver.findElement(By.id("passwd")).sendKeys("123");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        // Wait for redirect to Q1 to ensure login is processed
        wait.until(ExpectedConditions.urlContains("/q1"));
    }

    @Test
    public void testLoginFailure_InvalidCredentials() {
        driver.get(BASE_URL + "/login");
        driver.findElement(By.id("username")).sendKeys("wrongUser");
        driver.findElement(By.id("passwd")).sendKeys("wrongPass");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Use wait to avoid stale elements or race conditions
        WebElement messageDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div")));
        Assert.assertTrue("Should stay on login with error", messageDiv.getText().contains("Incorrect credentials"));
    }

    @Test
    public void testQ1_Addition_CorrectAnswer() {
        loginAsValidUser();
        driver.findElement(By.id("number1")).sendKeys("10");
        driver.findElement(By.id("number2")).sendKeys("5");
        driver.findElement(By.id("result")).sendKeys("15");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Fix: Wait for the URL to change to Q2
        wait.until(ExpectedConditions.urlContains("/q2"));
        Assert.assertTrue("Should progress to Q2", driver.getPageSource().contains("Q2"));
    }

    @Test
    public void testQ2_Subtraction_CorrectAnswer() {
        loginAsValidUser();
        
        // Solve Q1
        driver.findElement(By.id("number1")).sendKeys("10");
        driver.findElement(By.id("number2")).sendKeys("5");
        driver.findElement(By.id("result")).sendKeys("15");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        wait.until(ExpectedConditions.urlContains("/q2"));

        // Solve Q2
        driver.findElement(By.id("number1")).sendKeys("20");
        driver.findElement(By.id("number2")).sendKeys("8");
        driver.findElement(By.id("result")).sendKeys("12");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Fix: Wait for the URL to change to Q3
        wait.until(ExpectedConditions.urlContains("/q3"));
        Assert.assertTrue("Should progress to Q3", driver.getPageSource().contains("Q3"));
    }

    @Test
    public void testQ3_Multiplication_CorrectAnswer() {
        loginAsValidUser();
        
        // Solve Q1
        driver.findElement(By.id("number1")).sendKeys("1");
        driver.findElement(By.id("number2")).sendKeys("1");
        driver.findElement(By.id("result")).sendKeys("2");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        wait.until(ExpectedConditions.urlContains("/q2"));
        
        // Solve Q2
        driver.findElement(By.id("number1")).sendKeys("10");
        driver.findElement(By.id("number2")).sendKeys("5");
        driver.findElement(By.id("result")).sendKeys("5");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        wait.until(ExpectedConditions.urlContains("/q3"));

        // Solve Q3
        driver.findElement(By.id("number1")).sendKeys("6");
        driver.findElement(By.id("number2")).sendKeys("7");
        driver.findElement(By.id("result")).sendKeys("42");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // 1. Wait for the URL to change to the NEW congrats page
        wait.until(ExpectedConditions.urlContains("/congrats"));
        
        // 2. Verify the content of the new page
        WebElement congratsMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
        Assert.assertTrue("Should show STEM Math Challenge Complete", 
            congratsMsg.getText().contains("STEM Math Challenge"));
        
        Assert.assertTrue("Should see success text", 
            driver.getPageSource().contains("Congratulations! You have answered all questions correctly."));
    }

    @Test
    public void testAnyQuestion_WrongAnswer_StaysOnPage() {
        loginAsValidUser();
        driver.findElement(By.id("number1")).sendKeys("1");
        driver.findElement(By.id("number2")).sendKeys("1");
        driver.findElement(By.id("result")).sendKeys("3");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Wait for the message to update on the same page
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div")));
        Assert.assertTrue("Should show wrong answer error", errorMessage.getText().contains("Wrong answer"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}