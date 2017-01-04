package usermodule;

import java.util.concurrent.TimeUnit;

import net.sf.cglib.core.ClassNameReader;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WB_Checkout extends beanClass
{
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
		//driver.manage().window().maximize();
		driver.get("https://prodadmin:V8n8maya8@nse.vinimaya.com/y12/simulator/ariba");
		int size = driver.findElements(By.tagName("frameset")).size();
		System.out.println("Total Frames --" + size);

		int size1 = driver.findElements(By.tagName("frame")).size();
		System.out.println("Total Frames --" + size1);
			
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//*[@type='Submit'][@value='Post To Input Adapter']")).click();
		driver.findElement(By.linkText("here")).click();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("a[href*='#allsuppliers']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


		driver.findElement(By.name("categoryselection")).click();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#ss536_3 > input.supsfilterbox")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("search-text")).clear();
		driver.findElement(By.id("search-text")).sendKeys("paper");
		driver.findElement(By.id("search-button")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("img[alt=\"expandcollapse\"]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='completed'][@alt='completed']")));

		//driver.manage().window().maximize();
		driver.findElement(By.id("refreshresults")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElement(By.name("Selection")).click();
		driver.findElement(By.id("refineterm")).clear();
		driver.findElement(By.id("refineterm")).sendKeys("HAM86700");
		driver.findElement(By.id("refineterm")).sendKeys(Keys.ENTER);
		driver.findElement(By.name("Selection")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.name("addtocart")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Click here to view your cart")).click();  
		driver.findElement(By.id("checkoutbtn1")).click();
		String element = driver.findElement(By.xpath("//textarea")).getText();


	//	System.out.println("Printing string --" + element.toString());


		//int i=1;
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

