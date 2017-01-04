package usermodule;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class qwer {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://smartsearchdev.vinimaya.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSed() throws Exception {
    driver.get(baseUrl + "/kcp6.0sp1/simulator/ariba/");
    new Select(driver.findElement(By.id("supplierselect"))).selectByVisibleText("Newark");
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("2");
    driver.findElement(By.name("itemNumber")).clear();
    driver.findElement(By.name("itemNumber")).sendKeys("47K2935");
    driver.findElement(By.cssSelector("#searchTypeContent > #buttons > input.blue-button")).click();
    new Select(driver.findElement(By.id("searchType"))).selectByVisibleText("Manufacturer Part #");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
