package instagram.instagram;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class basec {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    protected static String username;
    protected static String user;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {

        // ✅ Initialize credentials ONCE
      

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        driver.get("https://www.instagram.com/");
        System.out.println("Instagram launched successfully.");
    }

   
    @BeforeMethod(alwaysRun = true)
    public void autoHandlePopups() {
        try {
            List<WebElement> notNowBtns =
                    driver.findElements(By.xpath("//button[text()='Not Now']"));

            if (!notNowBtns.isEmpty()) {
                wait.until(ExpectedConditions.elementToBeClickable(notNowBtns.get(0))).click();
                System.out.println("Popup handled: 'Not Now' clicked.");
            }

        } catch (Exception e) {
            System.out.println("No popups detected.");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver quit successfully.");
        }
    }
}
