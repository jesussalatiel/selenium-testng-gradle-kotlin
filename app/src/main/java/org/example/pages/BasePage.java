package org.example.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  private int DURATION_SECONDS = 15;
  protected WebDriver driver;

  protected BasePage(WebDriver driver) {
    this.driver = driver;
  }

  protected void goTo(String url) {
    driver.get(url);
    driver.manage().deleteAllCookies();
  }

  protected WebElement findElement(By element) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DURATION_SECONDS));
    return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
  }

  protected void sendKeys(By element, String text) {
    WebElement webElement = this.findElement(element);
    webElement.clear();
    webElement.sendKeys(text);
  }
}
