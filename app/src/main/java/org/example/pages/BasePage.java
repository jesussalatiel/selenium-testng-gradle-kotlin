package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo(String url) {
        driver.get("https://www.saucedemo.com/");
    }

    public WebElement findElement(By element) {
        return driver.findElement(element);
    }
}
