package classs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import instagram.instagram.basec;

public class login extends basec {

    private WebDriverWait wait;

    public login(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    // Dismiss cookie banner if present
    public void handleCookies() {
        try {
            WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Allow all cookies']")));
            cookieBtn.click();
        } catch (Exception e) {
            // ignore if not present
        }
    }

    // Enter username
    public void enterusername(String Username) {
        WebElement loginForm = wait.until(ExpectedConditions.visibilityOfElementLocated(
        		 By.xpath("//input[@name='email']")));
        loginForm.sendKeys(Username);
           }

    // Enter password
    public void enterpass(String password) {
        WebElement e = driver.findElement(By.xpath("//input[@name='pass']"));
 e.sendKeys(password);
    }

    // Submit login form
    public void logini() {
 driver.findElement(By.xpath("//span[text()='Log in']")).click();
        
    }

    // Go to forgot password page
    public forgotpage forget() {
        driver.findElement(By.xpath("//a[@href='/accounts/password/reset/']")).click();
        return new forgotpage();
    }
}
