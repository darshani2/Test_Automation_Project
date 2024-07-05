package net.phptravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        // Set up WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
       
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/admin/login.php");
        Thread.sleep(2000); // Wait for page to load

        // Enter login credentials
        driver.findElement(By.name("email")).sendKeys("admin@phptravels.com");
        driver.findElement(By.name("password")).sendKeys("demoadmin");

        // Click on login button
        driver.findElement(By.xpath("//button[contains(text(), 'Login')]")).click();
        Thread.sleep(3000); // Wait for login to complete
    }

    @Test
    public void testLogin() {
        // Verify successful login by checking dashboard page title
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Add assertions or further verifications here based on the dashboard page elements
        // For example:
        // Assert.assertTrue(pageTitle.contains("Dashboard"), "Login successful - Dashboard page loaded");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after each test method
        driver.quit();
    }
}
