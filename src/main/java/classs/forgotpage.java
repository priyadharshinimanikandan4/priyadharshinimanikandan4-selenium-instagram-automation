package classs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import instagram.instagram.basec;

public class forgotpage extends basec{

	
	public void username(String email) {
		   driver.findElement(By.xpath("//span[text()=' Phone, or Username']")).sendKeys(email);
		   
	   }
	   
	   public void loginq() {
	driver.findElement(By.xpath("//div[text()='Send login link']"));
	   }
	   

}
