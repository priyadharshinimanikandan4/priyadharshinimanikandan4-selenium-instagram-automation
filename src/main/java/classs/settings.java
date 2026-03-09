package classs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class settings {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public settings(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);
    }

    // Robust click method with retry, scrolling, and Actions fallback
    private void clickElement(By locator) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                // Wait for element presence
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

                // Scroll into view
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

                // Wait until clickable
                wait.until(ExpectedConditions.elementToBeClickable(element));

                // Try normal click
                element.click();
                return; // success
            } catch (StaleElementReferenceException e) {
                attempts++;
                System.out.println("StaleElementReferenceException caught. Retrying... Attempt: " + attempts);
            } catch (org.openqa.selenium.ElementClickInterceptedException e) {
                attempts++;
                System.out.println("Click intercepted. Retrying with Actions... Attempt: " + attempts);
                try {
                    WebElement element = driver.findElement(locator);
                    actions.moveToElement(element).click().perform(); // fallback click
                    return; // success
                } catch (Exception ex) {
                    System.out.println("Actions click failed. Retrying...");
                }
            } catch (Exception e) {
                attempts++;
                System.out.println("Other exception caught. Retrying... Attempt: " + attempts);
            }
        }
        throw new RuntimeException("Failed to click element after 3 attempts: " + locator);
    }

    // Settings button
    public void sett() {
        clickElement(By.xpath("//*[@aria-label='Settings']"));
    }

    // Theme button
    public void theme() {
        clickElement(By.xpath("//*[@aria-label='Theme icon']"));
    }

    // Toggle theme switch
    public void icon() {
        clickElement(By.xpath("//input[@role='switch']"));
        System.out.println("Theme toggled successfully");
    }

    // Back button
    public void back() {
        clickElement(By.xpath("//*[@aria-label='Back']"));
    }

    // Logout button
    public void logout() {
        clickElement(By.xpath("//span[text()='Log out']"));
        System.out.println("Logged out successfully");
    }
}
