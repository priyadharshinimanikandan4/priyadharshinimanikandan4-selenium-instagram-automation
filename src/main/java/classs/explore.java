package classs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import instagram.instagram.basec;

public class explore extends basec {
  WebDriver driver;
  WebDriverWait w ;
  
	public explore(WebDriver driver) {
		this.driver = driver;
		w =  new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	public void cliexplore() {
		WebElement e = w.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/explore/']")));
		e.click();
	}
	
	public void disreel() {
		WebElement r = w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='_aagw'])[1]")));
		r.click();
		WebElement m = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='presentation' or  contains(@class,'x1ey2m1c')]")));
		if(m.isDisplayed()) {
			System.out.println("Success");
		}else {
			System.out.println("not");
		}
	}
	
	
}
