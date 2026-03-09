package classs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import instagram.instagram.basec;

public class search {
	    private WebDriver driver;
	      

	   
	        
	    
	private WebDriverWait wait;
	public search(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
	 
	
	public void sear(String in) throws InterruptedException {
		 WebElement searchIcon = wait.until(
		            ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label='Search']"))
		        );
		        searchIcon.click();
		 WebElement searchBox = wait.until(
		            ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//input[@placeholder='Search']") // This is the real input field
		            )
		        );

	        searchBox.clear();
	        searchBox.sendKeys(in);
	        Thread.sleep(2000);
	        searchBox.sendKeys(Keys.ENTER);
	}
	public profilepage firstresult(String in) {
		WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//span[contains(text(),'" + in +"')]")
		    ));
		e.click();
		
		return new profilepage(driver);
		}
}
