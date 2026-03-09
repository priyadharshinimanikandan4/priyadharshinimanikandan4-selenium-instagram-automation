package classs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class forgotpage {

    WebDriver driver;
    WebDriverWait wait;

    public forgotpage() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openLoginPage() {
        driver.get("https://www.instagram.com/accounts/login/");
        driver.manage().window().maximize();
    }

    public void clickForgotPassword() {
        WebElement forgotPwd = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@href='/accounts/password/reset/']")
                )
        );
        forgotPwd.click();
    }

    public void enterUsernameAndContinue(String user) {
        By userInputLocator = By.xpath("//input[@id=//label[text()='Mobile number, username or email']/@for]");

        // Wait until the input is visible and enabled
        WebElement userField = wait.until(ExpectedConditions.elementToBeClickable(userInputLocator));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", userField);

        // Clear and enter username
        userField.clear();
        userField.sendKeys(user);

        // Wait for Continue button (Next) to be clickable
        By continueBtnLocator = By.xpath("//div[@role='button' and contains(text(),'Next')]");
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueBtnLocator));

        // Scroll and click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
        continueBtn.click();
    }

     
    
}
