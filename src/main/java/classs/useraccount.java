package classs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class useraccount {

	
	WebDriver driver;
	WebDriverWait w;
	public useraccount(WebDriver driver) {
        this.driver = driver;
        this.w = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
	
	
	public void name() {
WebElement a = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header//h2 | //header//h")));
Assert.assertTrue(a.isDisplayed());

	}
	
	
	public void profile() {
		WebElement b = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Edit profile']")));
		Assert.assertTrue(b.isDisplayed());
		b.click();
		List<WebElement> f = driver.findElements(By.xpath("//a[text()='Edit profile']"));
		System.out.println(f.size());
		for(WebElement h: f) {
			System.out.println(h.getTagName() + " " +h.getText());
		}
		
			}
	public void bio() {
		WebElement c = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='pepBio']")));
		Assert.assertTrue(c.isDisplayed());
		System.out.println("Bio Text is : " + c.getAttribute("value"));
	}
	public void getaccstatus() {
		WebElement d = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Account privacy']")));
		Assert.assertTrue(d.isDisplayed());
		System.out.println("acc Text is : " + d.getText());
		d.click();
			}
	public void accsta() {
		try {
		WebElement e = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Private account']")));
		Assert.assertTrue(e.isDisplayed());
		}
		catch(Exception e) {
			System.out.println("public");
		}
	}
public void bas() {
	driver.navigate().back();  // goes back one page
	driver.navigate().back();  // goes back second page

}
		public void accstah() {
			
			try {
			    WebElement archive = w.until(ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//a[@href='/archive/stories/']")
			    ));
			    if (archive.isDisplayed()) {
			        System.out.println("Archive stories link is visible!");
			    } 
			    } catch (TimeoutException e) {
			    System.out.println("No archive link available for this user.");
			}

		
}
		public void posticon() {try {
		    WebElement postsTab = w.until(ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//*[contains(text(),'Posts')]")
		        ));if(postsTab.isDisplayed()) {
		        	System.out.println("post availabe");
		        }
		    } catch (TimeoutException e) {
		        System.out.println("Posts tab not available for this user.");
		    }

				}
		public void saveditems(String username) {
			try {
			WebElement k = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/" + username +"/saved/']")));
			
			if(k.isDisplayed()) {
				System.out.println("post visible");
			}}catch(Exception e ) {
			
				 System.out.println("Posts tab not available for this user.");
					
			}
				}
		public void tagged(String username) {
			try {
			WebElement l = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/" + username + "/tagged/']")));
			Assert.assertTrue(l.isDisplayed());
			}
			catch(Exception e) {
				 System.out.println("Posts tab not available for this user.");
					
			}
					}
		
}
