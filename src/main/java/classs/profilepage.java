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

public class profilepage extends basec{

	
	WebDriverWait wait ;
	public profilepage(WebDriver driver) {
		
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		// TODO Auto-generated constructor stub
	}
	
	public void username()
	{
		WebElement w = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header//h2 | //header//h")));
		Assert.assertTrue(w.isDisplayed());
	}
	public void flwbtn() {
		WebElement e =  wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//button[@type='button']")
		    ));
		
		Assert.assertTrue(e.isDisplayed());
		Assert.assertTrue(e.isEnabled());
	}
public void msgicon() {
	
	WebElement r =  wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//div[text()='Message']")));
	r.isDisplayed();

}

public void postvalidate()
{
	List<WebElement> a = driver.findElements(By.xpath("//span[text()=' posts']"));
	
	if(a.size()> 0) {
		a.get(0).click();
		System.out.println("Sucess");
	}
	else {
		System.out.println("No posts avaoil");
	}
}
public void findSuggestion() {
	WebElement t =  wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//*[@aria-label='Similar accounts']")));
	if(t.isEnabled()) {
		t.click();
	}else {
		System.out.println("err");
	}
	WebElement su =  wait.until(ExpectedConditions.visibilityOfElementLocated(
	         By.xpath("//span[text()='See all']")));
	Assert.assertTrue(su.isDisplayed());
	
}

public void firstsuggestedAcc() {
	wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("(//section//a[starts-with(@href,'/') and not(contains(@href,'/p/'))])[6]"))).click();
}
	

	

}
