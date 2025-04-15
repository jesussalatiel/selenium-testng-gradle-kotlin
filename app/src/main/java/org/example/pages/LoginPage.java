package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        findElement(By.id("user-name")).sendKeys(username);
        findElement(By.id("password")).sendKeys(password);
        findElement(By.id("login-button")).click();
    }
}
