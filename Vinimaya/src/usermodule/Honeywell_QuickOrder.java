package usermodule;
import static org.testng.Assert.assertEquals;

import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Honeywell_QuickOrder extends beanClass {
	
		static String Totalprc="",qty ="",prtno="",prtnoAID="",Untprc="",uM="",spc="", xml="",Outp="",purpose="";

		public static String getUntprc() {
			return Untprc;
		}

		public static void setUntprc(String untprc) {
			Untprc = untprc;
		}

public static void main(String[] args) {
// TODO Auto-generated method stub
FirefoxDriver driver=new FirefoxDriver();

driver.get("https://admin:V3n3maya3@smartsearchdev.vinimaya.com/kcp6.0sp1/simulator/ariba/");
int size = driver.findElements(By.tagName("frameset")).size();
int size1 = driver.findElements(By.tagName("frame")).size();
driver.switchTo().frame(1);
driver.findElement(By.xpath("//*[@type='Submit'][@value='Post To Input Adapter']")).click();
driver.findElement(By.linkText("here")).click();
driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
driver.manage().window().maximize();

 

driver.findElement(By.id("quickordertab2")).click();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
new Select(driver.findElement(By.id("supplierselect"))).selectByVisibleText("Newark");
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.findElement(By.xpath("//*[@id='searchType']/option[@value='P']")).click();


                                                                                                                                                                                                                                     

int i=1;
//for (int i = 1; i <=1; i++) {
//Quantity
driver.findElement(By.xpath(".//*[@id='quickordertable']/tbody/tr["+i+"]/td[1]/input")).sendKeys("5");

//Item number
driver.findElement(By.xpath(".//*[@id='quickordertable']/tbody/tr["+i+"]/td[2]/input")).sendKeys("47K2935");
//}

driver.findElement(By.cssSelector("#searchTypeContent > #buttons > input.blue-button")).click();
driver.findElement(By.id("allItems")).click();
driver.findElement(By.id("checkoutbtn1")).click();
String element = driver.findElement(By.xpath("//textarea")).getText();
purpose= "WB_Checkout_Results";
xml=element;

try {
	itemelement(xml,purpose);
} catch (Exception e) {
	// TODO: handle exception
}

try{
	WriteGuru99ExcelFile.main("xyz");
}catch(Throwable t){
	System.out.println(t.getMessage());
}
}
}



