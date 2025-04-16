package org.example.pages.saucedemo;

import org.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

  private static final By USERNAME_FIELD = By.id("user-name");
  private static final By PASSWORD_FIELD = By.id("password");
  private static final By LOGIN_BUTTON = By.id("login-button");

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void login(String username, String password) {
    sendKeys(USERNAME_FIELD, username);
    sendKeys(PASSWORD_FIELD, password);

    findElement(LOGIN_BUTTON).click();
  }
}
