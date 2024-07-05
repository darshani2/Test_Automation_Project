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

public class CustomerCreationTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\welcome\\Downloads\\chromedriver-win64");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.phptravels.net/admin/login.php");
        driver.manage().window().maximize();
        driver.findElement(By.name("email")).sendKeys("admin@phptravels.com");
        driver.findElement(By.name("password")).sendKeys("demoadmin");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        List<WebElement> menuElementAccounts=
                driver.findElements(By.xpath("//*[@href='javascript:void(0);']"));
        menuElementAccounts.get(2).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Customers")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("fname")).sendKeys("Imperial");
        driver.findElement(By.name("lname")).sendKeys("College");
        driver.findElement(By.name("email")).sendKeys("info@imperial.com");
        driver.findElement(By.name("password")).sendKeys("admin@123");
        driver.findElement(By.name("mobile")).sendKeys("0112432311");



    }

    @Test
    public void testCreateCustomer() {
    }

    @AfterMethod
    public void tearDown() {

    }
}
