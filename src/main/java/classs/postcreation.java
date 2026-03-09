package classs;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class postcreation {
  WebDriver driver;
  WebDriverWait w;
  public postcreation(WebDriver driver) {
	    this.driver = driver;
	    this.w = new WebDriverWait(driver, Duration.ofSeconds(30));
	}  public void createbtn() {
	  WebElement a = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.//span[text()='Create']]")));
	  a.click();
  }
	
  public void imgbtn() {
	  WebElement c = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Close']")));
	  c.click();
	  
	  
  }
  public void postcreatebtn() throws IOException {
	  WebElement d = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.//span[text()='Create']]")));
	  d.click();
	  WebElement f =  w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@accept='image/avif,image/jpeg,image/png,image/heic,image/heif,video/mp4,video/quicktime']")));
	  f.sendKeys("C:\\Users\\HP\\Downloads\\flower.png");
	  WebElement g = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Next']")));
	  g.click();
	//div[text()='Next' 2 
	//div[text()='Next']
	  WebElement e = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Next']")));
	  e.click();
	  
	  System.out.println("before share");
	 	//div[text()='Share']
	  WebElement h = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Share']")));
	  h.click();
	  
	  System.out.println("before share");
	
	  try {
		    WebElement cancelBtn = w.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Cancel']"))
		    );
		    cancelBtn.click();
		    System.out.println("Discard pop-up appeared and closed.");
		} catch (TimeoutException e1) { // catch only timeout, not all exceptions
		    System.out.println("No pop-up displayed.");
		}

		System.out.println("before share");

	
	  System.out.println("before share");
	  //*[@aria-label='Close' and @role='img']forclose
	  WebElement i = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Close' and @role='img']")));
	  i.click();
	  System.out.println("before shared");
	 
  }
  public void postdelebtn() {
	 
	  WebElement o = w.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/p/')]")));
	  o.click();
	  WebElement i =  w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[name()='svg' and contains(@aria-label,'More')]")));
	  i.click();
	  WebElement r = w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Delete']")));
	  r.click();
  WebElement m = w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Delete']")));
  m.click();}
	  public void bacu() {
		  driver.navigate().back();
	  }
	  
  
}
