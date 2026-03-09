package classs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import instagram.instagram.basec;

public class explore {
	  private WebDriver driver;
	    private WebDriverWait wait;

	    public explore(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }

	    public void cliexplore() {

	        By exploreBtn = By.xpath("//a[@href='/explore/']");

	        int attempts = 0;

	        while (attempts < 5) {
	            try {
	                        WebElement explore =
	                        wait.until(ExpectedConditions.presenceOfElementLocated(exploreBtn));

	                wait.until(ExpectedConditions.elementToBeClickable(explore));

	                      ((JavascriptExecutor) driver)
	                        .executeScript("arguments[0].click();", explore);

	                System.out.println("Explore clicked successfully.");
	                return;

	            } catch (StaleElementReferenceException e) {
	                System.out.println("Explore stale, retrying... " + attempts);
	                attempts++;
	            }
	        }

	        throw new RuntimeException("Explore click failed after retries");
	    }


    // Open first reel safely
    public void disreel() {
        By reelXpath = By.xpath("(//div[@class='_aagw'])[1]");
        By modalXpath = By.xpath("//div[@role='presentation' or contains(@class,'x1ey2m1c')]");

        for (int i = 1; i <= 3; i++) {
            try {
                WebElement reel = wait.until(ExpectedConditions.refreshed(
                        ExpectedConditions.elementToBeClickable(reelXpath)
                ));
                reel.click();

                WebElement modal =
                        wait.until(ExpectedConditions.visibilityOfElementLocated(modalXpath));

                System.out.println(modal.isDisplayed() ? "Success" : "Not displayed");
                break;

            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                System.out.println("Retrying reel click, attempt " + i);
            }
        }
    }
}
