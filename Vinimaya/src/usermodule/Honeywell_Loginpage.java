package usermodule;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Honeywell_Loginpage {

	
		// TODO Auto-generated method stub
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			FirefoxDriver driver=new FirefoxDriver();
			//driver.manage().window().maximize();
	       driver.get("https://admin:V3n3maya3@smartsearchdev.vinimaya.com/kcp6.0sp1/simulator/ariba/");
			int size1 = driver.findElements(By.tagName("frame")).size();
		   driver.switchTo().frame(1);
		 driver.findElement(By.xpath("//*[@type='Submit'][@value='Post To Input Adapter']")).click();
			driver.findElement(By.linkText("here")).click();
			driver.manage().window().maximize();

	}

}
