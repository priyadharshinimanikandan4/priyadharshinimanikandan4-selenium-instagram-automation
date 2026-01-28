package classs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class notesadding {
    WebDriver driver;
    WebDriverWait w;

    public notesadding(WebDriver driver) {
        this.driver = driver;
        w = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // ===================== Messages =====================
    public void message() {
        By msgIcon = By.xpath("//a[.//*[name()='svg' and @aria-label='Messages']]\r\n"
        		+ "");
        for (int i = 0; i < 3; i++) {
            try {
                WebElement msg = w.until(ExpectedConditions.presenceOfElementLocated(msgIcon));
                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].scrollIntoView({block:'center'});", msg);
                w.until(ExpectedConditions.elementToBeClickable(msg));
                msg.click();
                System.out.println("'Messages' icon clicked");
                return;
            } catch (StaleElementReferenceException e) {
                System.out.println("Retrying to click Messages...");
            }
        }
        throw new RuntimeException("Failed to click Messages due to stale element");
    }

    // ===================== 'Your note' icon =====================
    public void icon() {
        handleNotNowPopup(); // dismiss any popup first

        By yourNoteBtn = By.xpath("//div[@role='button' and contains(., 'Your note')]");

        for (int i = 0; i < 3; i++) { // retry 3 times
            try {
                WebElement y = w.until(ExpectedConditions.visibilityOfElementLocated(yourNoteBtn));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", y);
                w.until(ExpectedConditions.elementToBeClickable(y));

                Actions actions = new Actions(driver);
                actions.moveToElement(y).click().perform();

                System.out.println("'Your note' button clicked via Actions");
                return;
            } catch (StaleElementReferenceException | TimeoutException e) {
                System.out.println("Retrying to click 'Your note' button...");
            }
        }

        throw new RuntimeException("Failed to click 'Your note' button after retries");
    }


    // ===================== Write note =====================
    public void noteswrit(String content) {
        By textbox = By.xpath("(//div[@role='button' and @tabindex='0' and descendant::span[contains(@class,'x1lliihq')]])[2]");
        WebElement c = null;

        for (int i = 0; i < 3; i++) {
            try {
                c = w.until(ExpectedConditions.visibilityOfElementLocated(textbox));
                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].scrollIntoView({block:'center'});", c);

                Actions actions = new Actions(driver);
                actions.moveToElement(c).click().sendKeys(content).perform();

                System.out.println("Note written: " + content);
                return;
            } catch (StaleElementReferenceException | TimeoutException e) {
                System.out.println("Retrying to write note...");
            }
        }

        throw new RuntimeException("Failed to write note after retries");
    }

    // ===================== Click Share button =====================
    public void sarebtnclick() {
        By shareBtn = By.xpath("//div[@role='button']//span[contains(.,'Share')]");
        WebElement d = w.until(ExpectedConditions.elementToBeClickable(shareBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", d);
        System.out.println("Note shared successfully");
      
    }

    // ===================== Leave note =====================
    public void leavenote() {
    	// Wait for the "Leave a new note" button to be clickable
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	  WebElement g = w.until(ExpectedConditions.elementToBeClickable(By.xpath(" //*[@aria-label='Close']")));
  		g.click();

    	WebElement t = wait.until(ExpectedConditions.elementToBeClickable(
        	    By.xpath("//div[@role='button' and contains(., 'Your note')]")));
    	t.click();

    	WebElement leaveNoteBtn = wait.until(ExpectedConditions.elementToBeClickable(
    	    By.xpath("//div[@role='button' and contains(text(), 'Leave a new note')]")
    	));

    	// Scroll into view (sometimes needed for div buttons)
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", leaveNoteBtn);

    	// Click the button
    	leaveNoteBtn.click();

    }


    // ===================== Verify shared note =====================
  


    // ===================== Handle 'Not Now' popup =====================
    public void handleNotNowPopup() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement notNow = shortWait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[text()='Not Now']")
            ));
            notNow.click();
            System.out.println("'Not Now' popup dismissed");
        } catch (TimeoutException e) {
            // Popup didn't appear, safe to continue
        }
    }
}
