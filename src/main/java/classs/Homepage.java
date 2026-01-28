package classs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import instagram.instagram.basec;

public class Homepage extends basec{
	//public Homepage(WebDriver driver) {
	// TODO Auto-generated constructor stub
//} ebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));
	WebDriver driver;
WebDriverWait w;

	public Homepage(WebDriver driver) {
	// TODO Auto-generated constructor stub
		this.driver = driver;
		w = new WebDriverWait(driver,Duration.ofSeconds(30));
}
	public void findhom() {
		WebElement we = w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label ='Home']")));
		we.click();
	}
	public void like() {
		WebElement li = w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@aria-label='Like'])[1]")));
		if(li.getAttribute("aria-label").equals("Like")) {
			System.out.println("Selected");
			li.click();
		}else {
			System.out.println("Already Selected");
			
		}
	}
				public void Notifictaions() {
	WebElement e = w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='Notifications']")));
			e.click();
			List <WebElement> link = w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//main[@role='main']//div[@role='button']")));

			if(!link.isEmpty()) {
			// Get the text inside the <a> tag
				System.out.println("The text is: " + link.get(0).getText());
			}
			}
			public void reels() {
				WebElement r = w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='Reels']")));
				r.click();
				
				WebElement s =  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='button' and @aria-disabled='false']")));
			if(s.isDisplayed()){
				System.out.println("displays");
			}
				
			
			
			
	}
	



}
