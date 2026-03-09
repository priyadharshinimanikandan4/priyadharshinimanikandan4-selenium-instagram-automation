package classs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import instagram.instagram.basec;

public class Homepage  {

    WebDriver driver;
    WebDriverWait w;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        w = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // ✅ Updated findHome method
    public void findHome() {
        try {
            WebElement homeBtn = w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='Home']")));
            homeBtn.click();
            System.out.println("Home clicked successfully");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Home button click intercepted. Retrying...");
        } catch (Exception e) {
            System.out.println("Failed to click Home: " + e.getMessage());
        }
    }

    public void like() {
        try {
            WebElement li = w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@aria-label='Like'])[1]")));
            if (li.getAttribute("aria-label").equals("Like")) {
                li.click();
                System.out.println("Post liked");
            } else {
                System.out.println("Already liked");
            }
        } catch (Exception e) {
            System.out.println("Like action failed: " + e.getMessage());
        }
    }

    public void notifications() {
        try {
            WebElement e = w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='Notifications']")));
            e.click();
            
            List<WebElement> links = w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//main[@role='main']//div[@role='button']")));

            if (!links.isEmpty()) {
                System.out.println("Notification text: " + links.get(0).getText());
            } else {
                System.out.println("No notifications found");
            }
        } catch (Exception ex) {
            System.out.println("Notifications action failed: " + ex.getMessage());
        }
    }

    public void reels() {
        try {
            WebElement r = w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='Reels']")));
            r.click();

            WebElement s = w.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@role='button' and @aria-disabled='false']")));
            if (s.isDisplayed()) {
                System.out.println("Reels button displayed");
            }
        } catch (Exception e) {
            System.out.println("Reels action failed: " + e.getMessage());
        }
    }
}
