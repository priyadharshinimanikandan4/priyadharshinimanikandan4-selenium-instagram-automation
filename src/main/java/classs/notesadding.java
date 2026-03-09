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
        By messagesIcon = By.xpath("//a[.//*[name()='svg' and @aria-label='Messages']]");
        By turnOffNotif = By.xpath("//button[text()='Not Now' or text()='Turn Off']"); // adjust based on actual text

        for (int i = 0; i < 3; i++) {
            try {
                // Refetch the element each retry
                WebElement msg = w.until(
                        ExpectedConditions.elementToBeClickable(messagesIcon)
                );

                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView({block:'center'});", msg
                );

                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].click();", msg
                );

                System.out.println("'Messages' icon clicked");

                // Handle Turn Off Notifications pop-up if present
                try {
                    WebElement notif = new WebDriverWait(driver, Duration.ofSeconds(3))
                            .until(ExpectedConditions.elementToBeClickable(turnOffNotif));
                    notif.click();
                    System.out.println("'Turn off notifications' pop-up dismissed");
                } catch (TimeoutException e) {
                    // Pop-up not shown, nothing to do
                    System.out.println("No notifications pop-up displayed");
                }

                return;
                

            } catch (StaleElementReferenceException e) {
                System.out.println("Retrying Messages click due to stale element...");
                try { Thread.sleep(500); } catch (InterruptedException ex) {}
            } catch (TimeoutException e) {
                System.out.println("Messages icon not clickable yet, retrying...");
            }
        }

        throw new RuntimeException("Failed to click Messages icon after retries");
    }

    
   

      public void icon() {
    	  By turnOffNotif = By.xpath("//button[text()='Not Now' or text()='Turn Off']"); // adjust based on actual text

        handleNotNowPopup();
        By messagesIcon = By.xpath("//a[.//*[name()='svg' and @aria-label='Messages']]");
        handleNotNowPopup();
        try {
            WebElement notif = new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(turnOffNotif));
            notif.click();
            System.out.println("'Turn off notifications' pop-up dismissed");
        } catch (TimeoutException e) {
            // Pop-up not shown, nothing to do
            System.out.println("No notifications pop-up displayed");
        }

        WebElement msg = w.until(
                ExpectedConditions.elementToBeClickable(messagesIcon)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", msg
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", msg
        );

        System.out.println("'Messages' icon clicked");
        
        By yourNote = By.xpath("//span[text()='Your note']");

        for (int i = 0; i < 3; i++) {
            try {
                WebElement noteBtn = w.until(ExpectedConditions.elementToBeClickable(yourNote));

                ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center'});", noteBtn
                );

                ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", noteBtn
                );

                System.out.println("'Your note' clicked");
                return;

            } catch (Exception e) {
                System.out.println("Retrying to click 'Your note'...");
            }
        }

        throw new RuntimeException("Failed to click 'Your note' button after retries");
    }

   public void noteswrit(String content) {
        By textbox = By.xpath("//div[@contenteditable='true']");

        for (int i = 0; i < 5; i++) { // increase retries
            try {
                  WebElement c = w.until(ExpectedConditions.visibilityOfElementLocated(textbox));

                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", c);

                try {
                    c.click();
                } catch (org.openqa.selenium.ElementClickInterceptedException e) {
                    System.out.println("Click intercepted, trying JS click...");
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", c);
                }

                  ((JavascriptExecutor) driver).executeScript("arguments[0].innerText='';", c);

                c.sendKeys(content);

                System.out.println("Note written: " + content);
                return;
            } catch (StaleElementReferenceException | TimeoutException e) {
                System.out.println("Retrying to write note...");
                try { Thread.sleep(500); } catch (InterruptedException ex) {}
            }
        }

        throw new RuntimeException("Failed to write note after multiple retries");
    }



      public void sarebtnclick() {
        By shareBtn = By.xpath("//div[@role='button']//span[contains(.,'Share')]");
        WebElement d = w.until(ExpectedConditions.elementToBeClickable(shareBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", d);
        System.out.println("Note shared successfully");
      
    }

      public void leavenote() {
     	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	  WebElement g = w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='Close']")));
  		g.click();

    	WebElement t = wait.until(ExpectedConditions.elementToBeClickable(
        	    By.xpath("//div[@role='button' and contains(., 'Your note')]")));
    	t.click();

    	WebElement leaveNoteBtn = wait.until(ExpectedConditions.elementToBeClickable(
    	    By.xpath("//div[@role='button' and contains(text(), 'Leave a new note')]")
    	));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", leaveNoteBtn);

    	// Click the button
    	leaveNoteBtn.click();

    }


       public void handleNotNowPopup() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement notNow = shortWait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[text()='Not Now']")
            ));
            notNow.click();
            System.out.println("'Not Now' popup dismissed");
        } catch (TimeoutException e) {
                }
    }
}
