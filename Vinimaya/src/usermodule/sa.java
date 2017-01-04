package usermodule;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class sa {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://nse.vinimaya.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDsd() throws Exception {
    driver.get(baseUrl + "/y12/simulator/ariba/");
    driver.findElement(By.linkText("Go to site")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=main | ]]
    driver.findElement(By.id("ctl00_ProductSearchWidget_QuickSearchTextBox")).clear();
    driver.findElement(By.id("ctl00_ProductSearchWidget_QuickSearchTextBox")).sendKeys("PAP62145");
    driver.findElement(By.id("ctl00_ProductSearchWidget_SearchGoButtonImage")).click();
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
  public void writereport(String text) 
  { 
   try
   {
 /* FileOutputStream f = new FileOutputStream(“c:\\Test\\output.xls”,true);
  WritableWorkbook book = Workbook.createWorkbook(f); 
  WritableSheet sheet = book.createSheet(“output”, 0);
  Label l = new Label(0, 0, text);
  sheet.addCell(l);
  book.write(); 
  book.close(); */
   }
   catch (Exception e)
   {
    e.printStackTrace();
   }
   }
}
