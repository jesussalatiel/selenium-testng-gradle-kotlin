package org.example.pages.saucedemo;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

  private static final By USERNAME_FIELD = By.id("user-name");
  private static final By PASSWORD_FIELD = By.id("password");
  private static final By LOGIN_BUTTON = By.id("login-button");

  protected LoginPage(WebDriver driver) {
    super(driver);
  }

  protected void login(String username, String password) {
    setUsername(username);
    setPassword(password);
    performSubmit();
  }

  protected void setUsername(String username) {
    sendKeys(USERNAME_FIELD, username);
  }

  protected void setPassword(String password) {
    sendKeys(PASSWORD_FIELD, password);
  }

  protected void performSubmit() {
    findElement(LOGIN_BUTTON).click();
  }
}
