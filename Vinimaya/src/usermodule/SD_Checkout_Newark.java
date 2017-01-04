package usermodule;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SD_Checkout_Newark extends beanClass implements ISearch {

 // @Override
  public List<suppliermodel> launchSearch(final String filePath) {
    List<suppliermodel> listOfSDSupplier = new ArrayList<>();
    suppliermodel supplierModel = new suppliermodel();
    supplierModel.setSupplierName("#ss37_3 > input.supsfilterbox");
    FirefoxDriver driver=new FirefoxDriver();
	//driver.manage().window().maximize();
   driver.get("https://prodadmin:V7n7maya7@nse.vinimaya.com/y12/simulator/ariba");
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
    
driver.findElement(By.cssSelector("a[href*='launchsd.do?from=allsuppliers&supplierId=535']")).click();     
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
try {
	Thread.sleep(20000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	System.out.println(e);
}
driver.manage().window().maximize();
driver.switchTo().frame(1);
 driver.findElement(By.id("ctl00_ProductSearchWidget_QuickSearchTextBox")).clear();
    driver.findElement(By.id("ctl00_ProductSearchWidget_QuickSearchTextBox")).sendKeys("HAM86700");
    driver.findElement(By.id("ctl00_ProductSearchWidget_SearchGoButtonImage")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_SearchResults1_rptDetailSearchResults_ctl01_AddToCartWidget_AddToCartButton")).click();
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    driver.findElement(By.id("ctl00_CartWidgetFlyout1_CartSummaryFormView_CartLinesLink")).click();
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ShoppingCart1_rptShoppingCartResults_ctl02_lnkProceedToCheckout")).click();
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_SubmitOrderLink")).click();
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    try {
		Thread.sleep(20000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
    
    driver.switchTo().frame(1);
   
    driver.findElement(By.xpath("//input[@id='checkoutbtn1'and @value='Checkout']")).click();

    String element = driver.findElement(By.xpath("//textarea")).getText();
    //String element = driver.findElement(By.xpath("//textarea")).getText();
    supplierModel.setSupplierCheckOut(element);
    listOfSDSupplier.add(supplierModel);
    return listOfSDSupplier;
  }
}

