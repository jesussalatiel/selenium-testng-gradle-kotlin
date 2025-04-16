package org.example.builders;

import org.example.pages.saucedemo.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginBuilder extends LoginPage {

  public LoginBuilder(WebDriver driver) {
    super(driver);
  }

  public LoginBuilder loginAs(String username, String password) {
    login(username, password);
    return this;
  }

  public LoginBuilder run() {
    return this;
  }
}
