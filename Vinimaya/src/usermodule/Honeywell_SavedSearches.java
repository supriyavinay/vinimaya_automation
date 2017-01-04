package usermodule;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Honeywell_SavedSearches {


	public static void main(String[] args) {
FirefoxDriver driver=new FirefoxDriver();

driver.get("https://admin:V3n3maya3@smartsearchdev.vinimaya.com/kcp6.0sp1/simulator/ariba/");
int size = driver.findElements(By.tagName("frameset")).size();
int size1 = driver.findElements(By.tagName("frame")).size();
driver.switchTo().frame(1);
driver.findElement(By.xpath("//*[@type='Submit'][@value='Post To Input Adapter']")).click();
driver.findElement(By.linkText("here")).click();
driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
driver.manage().window().maximize();



    driver.findElement(By.id("search-text")).clear();
    driver.findElement(By.id("search-text")).sendKeys("tools");
    driver.findElement(By.id("search-button")).click();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.findElement(By.id("opener")).click();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.findElement(By.id("txtFavName")).clear();
    driver.findElement(By.id("txtFavName")).sendKeys("test");
    driver.findElement(By.name("nameoffavorite")).click();
    assertEquals(closeAlertAndGetItsText1(), "The current search has been added to your Favorites List");
    driver.findElement(By.linkText("Saved Searches")).click();
    driver.findElement(By.xpath(".//*[@id='header']/div[1]/div/ul/li[1]/a")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | _self | 30000]]
    driver.findElement(By.xpath(".//*[@id='favoritestab']/div[1]/div[1]/div/ul/li[1]/ul/li/a[2]")).click();
    driver.findElement(By.xpath("(//img[@alt='Launch'])[2]")).click();
  }

	private static void assertEquals(Object closeAlertAndGetItsText,
			String string) {
		// TODO Auto-generated method stub
		
	}
	private static String closeAlertAndGetItsText1() {
	    boolean acceptNextAlert = false;
		try {
	      WebDriver driver = null;
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
	


	private static Object closeAlertAndGetItsText() {
		// TODO Auto-generated method stub
		return null;
	}

  
    
  }


