package usermodule;

	import java.util.regex.Pattern;
	import java.util.concurrent.TimeUnit;
	import org.testng.annotations.*;
	import static org.testng.Assert.*;
	import org.openqa.selenium.*;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

	public class ControlsupplierSD {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "https://admin:V3n3maya3@smartsearchdev.vinimaya.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testControllcheckout() throws Exception {
	    driver.get(baseUrl + "/kcp6.0sp1/simulator/ariba/");
	   // driver.findElement(By.cssSelector("#ss30_3 > a")).click();
	    int size = driver.findElements(By.tagName("frameset")).size();
		   System.out.println("Total Frames --" + size);
		   
		   int size1 = driver.findElements(By.tagName("frame")).size();
		   System.out.println("Total Frames --" + size1);
		   
		 driver.switchTo().frame(1);
		    driver.findElement(By.xpath("//*[@type='Submit'][@value='Post To Input Adapter']")).click();
		driver.findElement(By.linkText("here")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("a[href*='#allsuppliers']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=main | ]]
	    driver.findElement(By.name("b_productsearch")).click();
	    driver.findElement(By.name("ContentBlank2")).click();
	    driver.findElement(By.name("Keyword")).clear();
	    driver.findElement(By.name("Keyword")).sendKeys("780");
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	    driver.findElement(By.linkText("780")).click();
	    driver.findElement(By.xpath("//input[@value='Add To Cart']")).click();
	    driver.findElement(By.name("Checkout")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
	    driver.findElement(By.id("checkoutbtn1")).click();
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

	