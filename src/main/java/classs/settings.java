package classs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class settings {
  
	
	WebDriver driver;
	WebDriverWait w;
	public settings(WebDriver driver) {
		this.driver = driver;
		w = new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	public void sett() {
		WebElement a = w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='Settings']")));
		a.click();
	}
	public void theme() {
		WebElement b = w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='Theme icon']")));
		b.click();
	}
	public void icon() {
		WebElement c = w.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@role='switch']")));
		
		c.click();
		System.out.println("one");}
	
	public void back() {
		WebElement d = w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='Back']")));
		d.click();
	}public void logout() {
		WebElement e = w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@role='button' and @tabindex='0'])[25]")));
		e.click();
	}
}
