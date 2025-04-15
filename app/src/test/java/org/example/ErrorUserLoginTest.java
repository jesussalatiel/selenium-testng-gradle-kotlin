package org.example;

import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorUserLoginTest {

    protected WebDriver driver;
    protected LoginPage page;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        page = new LoginPage(driver);
    }

    @Test
    public void shouldHaveErrorUserLogin() {
        driver.get("https://www.saucedemo.com/");

        page.login("error_user", "secret_sauce");

        // driver.findElement(By.id("user-name")).sendKeys("error_user");
        // driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // driver.findElement(By.id("login-button")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "error_user should be logged in and redirected to the inventory page.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}