package usermodule;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sapa extends readdata_excel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirefoxDriver driver=new FirefoxDriver();
		//driver.manage().window().maximize();
       driver.get("https://admin:V3n3maya3@smartsearchdev.vinimaya.com/kcp6.0sp1/simulator/ariba/");
		int size = driver.findElements(By.tagName("frameset")).size();
	   System.out.println("Total Frames --" + size);
	   
	   
	   int size1 = driver.findElements(By.tagName("frame")).size();
	   System.out.println("Total Frames --" + size1);
	   
	 driver.switchTo().frame(1);
	    driver.findElement(By.xpath("//*[@type='Submit'][@value='Post To Input Adapter']")).click();
	driver.findElement(By.linkText("here")).click();
	driver.findElement(By.cssSelector("a[href*='#allsuppliers']")).click();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    
	    driver.findElement(By.name("categoryselection")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.cssSelector("ss37_3 > input.supsfilterbox")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.id("search-text")).clear();
	    driver.findElement(By.id("search-text")).sendKeys("paper");
	    driver.findElement(By.id("search-button")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.cssSelector("img[alt=\"expandcollapse\"]")).click();
	    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	    WebDriverWait wait = new WebDriverWait(driver, 5);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='completed'][@alt='completed']")));
	    
	    //driver.manage().window().maximize();
	    driver.findElement(By.id("refreshresults")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    //driver.findElement(By.name("Selection")).click();
	    driver.findElement(By.id("refineterm")).clear();
	    driver.findElement(By.id("refineterm")).sendKeys("PAP62145");
	    driver.findElement(By.id("refineterm")).sendKeys(Keys.ENTER);
	 	driver.findElement(By.name("Selection")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.name("addtocart")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.linkText("Click here to view your cart")).click();
	    
	    //document.ResultsForm.Selection[2]
	    
	   // List<WebElement> els = driver.findElements( By.className( "product_check") );
	    
	    //System.out.println(Integer.toString(els.size()));
	    
	    /*for ( WebElement el : els ) {
	        if ( !el.isSelected() ) 
	        {
	        	
	        	el.click();
	            
	        }
	    }*/
	    
	   
	   /* List<WebElement> children = driver.findElements(By.className( "product_check")); 
	    int sz= 3;
	    System.out.println("Size is: "+sz);
	    for (int i = 0; i <sz; i++) 
	    {
	        boolean check= children.get(i).isSelected();
	        
	        if(check==true)
	        {
	        	children.get(i).click();
	           // System.out.println(children.get(i).getText()+ "is selected");
	        }
	        
	    }  
	    
	    
	    driver.findElement(By.name("addtocart")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.linkText("Click here to view your cart")).click();
	    driver.findElement(By.id("checkoutbtn1")).click();*/
	}

}