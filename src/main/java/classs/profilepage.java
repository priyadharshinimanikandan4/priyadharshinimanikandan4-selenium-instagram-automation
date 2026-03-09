package classs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import instagram.instagram.basec;

public class profilepage  {
	  private WebDriverWait wait;
	    private WebDriver driver;
	      

	    public profilepage(WebDriver driver) {
	        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
	        this.driver = driver;
	        
	    }

    // ---------- HELPER: Safe Click ----------
    private void safeClick(WebElement element) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                new Actions(driver).moveToElement(element).click().perform();
                break; // success
            } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
                attempts++;
                sleep(500); // wait 0.5s before retry
            }
        }
    }

    private void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }

    // ---------- SEARCH PROFILE ----------
    public void search(String username) {
        WebElement searchIcon = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Search']"))
        );
        safeClick(searchIcon);

        WebElement searchBox = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']"))
        );
        searchBox.clear();
        searchBox.sendKeys(username);

        WebElement userResult = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='" + username + "']/ancestor::a")
            )
        );
        safeClick(userResult);
    }

    public void username() {
        WebElement w = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//header//h2"))
        );
        Assert.assertTrue(w.isDisplayed(), "Username header is not displayed");
    }
    public void flwbtn() {
        try {
            WebElement followBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//button[.='Follow' or .='Following' or .='Requested']")
                )
            );

            if (followBtn.getText().equals("Follow")) {
                safeClick(followBtn);
                System.out.println("Followed the account");
            } else {
                System.out.println("Already following or request sent");
            }

        } catch (TimeoutException e) {
            System.out.println("Follow button not visible (own profile or restricted account)");
        }
    }

    public void msgicon() {
        WebElement r = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Message']"))
        );
        safeClick(r);
        System.out.println("Success: Message opened");
    }

    // ---------- SEND MESSAGE ----------
    public void senmsg(String msg) {
        WebElement box = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@contenteditable='true']"))
        );
        box.sendKeys(msg);
        box.sendKeys(Keys.ENTER);
        System.out.println("Success: Message sent");
    }

    public void postvalidate() {
        List<WebElement> posts = driver.findElements(By.xpath("//article//a[contains(@href,'/p/')]"));
        if (!posts.isEmpty()) {
            safeClick(posts.get(0));
            System.out.println("Post opened");
        } else {
            System.out.println("No posts available");
        }
    }

    public void findSuggestion() {
        WebElement btn = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='Similar accounts']"))
        );
        safeClick(btn);

        WebElement seeAll = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='See all']"))
        );
        Assert.assertTrue(seeAll.isDisplayed(), "See All button not displayed");
    }

    // ---------- FIRST SUGGESTED ACCOUNT ----------
    public void firstsuggestedAcc() {
        WebElement acc = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//section//a[starts-with(@href,'/') and not(contains(@href,'/p/'))])[1]")
            )
        );
        safeClick(acc);
    }
}
