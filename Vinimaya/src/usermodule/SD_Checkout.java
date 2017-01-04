package usermodule;

import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SD_Checkout extends beanClass {

	static String Totalprc="",qty ="",prtno="",prtnoAID="",Untprc="",uM="",spc="", xml="",Outp="",purpose="";
	
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
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.id("ctl00_CartWidgetFlyout1_CartSummaryFormView_CartLinesLink")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ShoppingCart1_rptShoppingCartResults_ctl02_lnkProceedToCheckout")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_SubmitOrderLink")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	    
	    driver.switchTo().frame(1);
	   
	    driver.findElement(By.xpath("//input[@id='checkoutbtn1'and @value='Checkout']")).click();
	
	    String element = driver.findElement(By.xpath("//textarea")).getText();

	
	    

	  System.out.println("Printing string --" + element.toString());
	   
	  
	 // int i=1;
		purpose= "SD_Checkout_Results";
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
		 
		/*String Totalprc="",qty ="",prtno="",prtnoAID="",Untprc="",uM="",spc="";
		if(xml.indexOf("<cXML payloadID")!=-1)
		{
			Totalprc = xml.substring(xml.indexOf("<Total>")+"<Total>".length());
			Totalprc = Totalprc.substring(Totalprc.indexOf("currency=\"USD\">")+"currency=\"USD\">".length());
			Totalprc = Totalprc.substring(0, Totalprc.indexOf("<"));
			System.out.println("Total price : " + Totalprc);
			xml= xml.substring(xml.indexOf("</PunchOutOrderMessageHeader>"));
		}
		while(xml.indexOf("<ItemIn")!=-1)
		{
			
			if(xml.indexOf("quantity=\"")!=-1)
			{
				qty = xml.substring(xml.indexOf("quantity=\"")+"quantity=\"".length());
				qty = qty.substring(0, qty.indexOf("\""));
			}
			if(xml.indexOf("SupplierPartID>")!=-1)
			{
				prtno = xml.substring(xml.indexOf("SupplierPartID>")+"SupplierPartID>".length());
				prtno = prtno.substring(0, prtno.indexOf("<"));
				prtnoAID = prtno;
			}
			if(xml.indexOf("currency=\"USD\">")!=-1)
			{
				Untprc = xml.substring(xml.indexOf("currency=\"USD\">")+"currency=\"USD\">".length());
				Untprc = Untprc.substring(0, Untprc.indexOf("<"));
			}
			if(xml.indexOf("UnitOfMeasure>")!=-1)
			{
				uM = xml.substring(xml.indexOf("UnitOfMeasure>")+"UnitOfMeasure>".length());
				uM = uM.substring(0, uM.indexOf("<"));
			}
			if(xml.indexOf("\"UNSPSC\">")!=-1)
			{
				spc = xml.substring(xml.indexOf("\"UNSPSC\">")+"\"UNSPSC\">".length());
				spc = spc.substring(0, spc.indexOf("<"));
			}
			System.out.println(i +"st"+" Item Qyantity : " + qty);
			System.out.println(i +"st"+" Item Part number : " + prtno);
			System.out.println(i +"st"+" Item Part AUX ID : " + prtno);
			System.out.println(i +"st"+" Item Unit Price : " + Untprc);
			System.out.println(i +"st"+" Item UOM : " + uM);
			System.out.println(i +"st"+" Item UNSPSC : " + spc);
			i++;
			xml = xml.substring(xml.indexOf("</ItemIn>")+"</ItemIn>".length());
			
			
			
		}*/
		
		

	
	}
	  
	  
	  
	  
	  
	  

 
		}

	
	   
	
