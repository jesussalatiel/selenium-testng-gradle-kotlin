package org.example;

import org.example.builders.EnvironmentBuilder;
import org.example.builders.LoginBuilder;
import org.example.utils.Browser;
import org.example.utils.PracticePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SauceDemoSuite {

  private EnvironmentBuilder builder;

  @BeforeMethod
  @Parameters("browser")
  public void setup(@Optional("CHROME") String browser) {
    Browser browserEnum = Browser.valueOf(browser.toUpperCase());

    builder =
        new EnvironmentBuilder().setDriver(browserEnum).navigate(PracticePages.SAUCE_DEMO_URL);
  }

  @Test
  public void shouldHaveErrorUserLogin() {
    new LoginBuilder(builder.getDriver()).loginAs("error_user", "secret_sauce").run();

    Assert.assertTrue(
        builder.getDriver().getCurrentUrl().contains("inventory"),
        "error_user should be logged in and redirected to the inventory page.");
  }

  @Test
  public void shouldHaveLockedOutUserError() {
    new LoginBuilder(builder.getDriver()).loginAs("locked_out_user", "secret_sauce").run();

    WebElement errorMessage =
        builder.getDriver().findElement(By.cssSelector("h3[data-test='error']"));

    Assert.assertTrue(
        errorMessage.isDisplayed(),
        "locked_out_user should display an error message due to being locked out.");
  }

  @Test
  public void shouldHavePerformanceGlitchUserLogin() {
    new LoginBuilder(builder.getDriver()).loginAs("performance_glitch_user", "secret_sauce").run();

    Assert.assertTrue(
        builder.getDriver().getCurrentUrl().contains("inventory"),
        "performance_glitch_user should be logged in and redirected to the inventory page.");
  }

  @Test
  public void shouldHaveProblemUserLogin() {
    new LoginBuilder(builder.getDriver()).loginAs("problem_user", "secret_sauce").run();

    Assert.assertTrue(
        builder.getDriver().getCurrentUrl().contains("inventory"),
        "problem_user should be logged in and redirected to the inventory page.");
  }

  @Test
  public void shouldHaveStandardUserLogin() {
    new LoginBuilder(builder.getDriver()).loginAs("standard_user", "secret_sauce").run();

    Assert.assertTrue(
        builder.getDriver().getCurrentUrl().contains("inventory"),
        "standard_user should be logged in and redirected to the inventory page.");
  }

  @Test
  public void shouldHaveVisualUserLogin() {
    new LoginBuilder(builder.getDriver()).loginAs("visual_user", "secret_sauce").run();

    Assert.assertTrue(
        builder.getDriver().getCurrentUrl().contains("inventory"),
        "visual_user should be logged in and redirected to the inventory page.");
  }

  @AfterMethod
  public void tearDown() {
    builder.tearDown();
  }
}
