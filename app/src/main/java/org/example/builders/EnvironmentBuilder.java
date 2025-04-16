package org.example.builders;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.utils.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class EnvironmentBuilder {

  private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
  String headless = System.getProperty("headless", "false");
  boolean isHeadless = headless.equalsIgnoreCase("true");

  public EnvironmentBuilder setDriver(Browser browser) {
    WebDriver driver;
    switch (browser) {
      case Browser.CHROME:
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        if (isHeadless) chromeOptions.addArguments("--headless");

        driver = new ChromeDriver(chromeOptions);
        break;

      case Browser.FIREFOX:
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        if (isHeadless) firefoxOptions.addArguments("-headless");

        driver = new FirefoxDriver(firefoxOptions);
        break;
      case Browser.SAFARI:
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        break;

      default:
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        break;
    }
    driverThreadLocal.set(driver);
    return this;
  }

  public EnvironmentBuilder navigate(String url) {
    driverThreadLocal.get().get(url);
    return this;
  }

  public WebDriver build() {
    return driverThreadLocal.get();
  }

  public WebDriver getDriver() {
    return driverThreadLocal.get();
  }

  public void tearDown() {
    WebDriver driver = driverThreadLocal.get();
    if (driver != null) {
      driver.quit();
      driverThreadLocal.remove();
    }
  }
}
