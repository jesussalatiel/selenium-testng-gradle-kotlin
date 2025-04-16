package org.example.builders;

import org.example.pages.saucedemo.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginBuilder extends LoginPage {

  public LoginBuilder(WebDriver driver) {
    super(driver);
  }

  public LoginBuilder withCredentials(String username, String password) {
    login(username, password);
    return this;
  }

  public LoginBuilder enterUsername(String username) {
    setUsername(username);
    return this;
  }

  public LoginBuilder enterPassword(String password) {
    setPassword(password);
    return this;
  }

  public LoginPage submit() {
    performSubmit();
    return this;
  }
}
