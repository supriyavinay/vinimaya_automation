package usermodule;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class param extends beanClass implements ISearch {


@Override
  public List<suppliermodel> launchSearch(final String filePath) {
    ReadExcelFile readFile = new ReadExcelFile();
    List<suppliermodel> listOfSupplierData = readFile.readExcelFile(filePath);
    for (suppliermodel supplierModel : listOfSupplierData) {
      // Here you can pass the supplier name and keyword to launch the search
      System.out.println("Supplier Name: " + supplierModel.getSupplierName1() + "    Keyword: " +
          supplierModel.getKeyword() + " PartNo:" + supplierModel.getPartNo());
      // Map<String, List<String>> readExcelFile = readFile.readdata_excel();
      // Set<Entry<String, List<String>>> entrySet = readExcelFile.entrySet();
      // for (Entry<String, List<String>> entry : entrySet) {
      // List<String> keywords = entry.getValue();
      // for (String keyword : keywords) {
      // String supplierName = entry.getKey();
      // String RefineTerm=entry.getKey();
      // Here pass the supplier name and keyword to launch the search
      // System.out.println("Supplier Name: " + supplierName + " Keyword: " + keyword + " RefineTerm: " + RefineTerm);

      FirefoxDriver driver = new FirefoxDriver();
      driver.manage().window().maximize();
      driver.get("https://admin:V3n3maya3@smartsearchdev.vinimaya.com/kcp6.0sp1/simulator/ariba/");
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


      driver.findElement(By.linkText("All Suppliers")).click();

      driver.findElement(By.cssSelector(supplierModel.getSupplierName1())).click();

      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      driver.findElement(By.id("search-text")).clear();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      System.out.println(supplierModel.getSupplierName1());
      System.out.println(supplierModel.getKeyword());

      driver.findElement(By.id("search-text")).sendKeys(supplierModel.getKeyword());
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      driver.findElement(By.id("search-button")).click();
      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      driver.findElement(By.cssSelector("img[alt=\"expandcollapse\"]")).click();
      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

      WebDriverWait wait = new WebDriverWait(driver, 60);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='completed'][@alt='completed']")));

      // driver.manage().window().maximize();
      driver.findElement(By.id("refreshresults")).click();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      // driver.findElement(By.name("Selection")).click();
      driver.findElement(By.id("refineterm")).clear();
      driver.findElement(By.id("refineterm")).sendKeys(supplierModel.getPartNo());
      driver.findElement(By.id("refineterm")).sendKeys(Keys.ENTER);
      driver.findElement(By.name("Selection")).click();
      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      driver.findElement(By.name("addtocart")).click();
      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      driver.findElement(By.linkText("Click here to view your cart")).click();
      driver.findElement(By.id("checkoutbtn1")).click();
      String element = driver.findElement(By.xpath("//textarea")).getText();
      supplierModel.setWBSearch(true);
      supplierModel.setSupplierCheckOut(element);
      // try {
      // WriteGuru99ExcelFile.main("xyz");
      // }
      // catch (Throwable t) {
      // System.out.println(t.getMessage());
      // driver.close();
      //
      // }

    }
    return listOfSupplierData;
  }
}

