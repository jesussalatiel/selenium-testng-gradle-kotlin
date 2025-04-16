package org.example.builders;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
import org.example.utils.Browser;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class EnvironmentBuilder {

  private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

  private static final Dimension DESKTOP_DIMENSION = new Dimension(1280, 720);
  private static final Dimension TABLET_DIMENSION = new Dimension(600, 1024);

  public EnvironmentBuilder setDriver(Browser browser, String device) {
    WebDriver driver = createDriver(browser);
    driverThreadLocal.set(driver);
    applyDeviceDimension(device);
    return this;
  }

  private WebDriver createDriver(Browser browser) {
    boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));

    switch (browser) {
      case CHROME:
        {
          WebDriverManager.chromedriver().setup();
          ChromeOptions options = new ChromeOptions();
          options.addArguments("incognito");
          if (isHeadless) {
            options.addArguments("--headless=new");
          }
          return new ChromeDriver(options);
        }
      case FIREFOX:
        {
          WebDriverManager.firefoxdriver().setup();
          FirefoxOptions options = new FirefoxOptions();
          if (isHeadless) {
            options.addArguments("-headless");
          }
          return new FirefoxDriver(options);
        }
      case SAFARI:
        {
          WebDriverManager.safaridriver().setup();
          return new SafariDriver();
        }
      default:
        throw new IllegalArgumentException("Unsupported browser: " + browser);
    }
  }

  private void applyDeviceDimension(String device) {
    Map<String, Dimension> deviceSizes = new HashMap<>();
    deviceSizes.put("DESKTOP", DESKTOP_DIMENSION);
    deviceSizes.put("TABLET", TABLET_DIMENSION);

    Dimension selected = deviceSizes.getOrDefault(device.toUpperCase(), DESKTOP_DIMENSION);
    driverThreadLocal.get().manage().window().setSize(selected);
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
