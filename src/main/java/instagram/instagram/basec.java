package instagram.instagram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class basec {

	
		// TODO Auto-generated method stub
protected static WebDriver driver = null;
protected static String user;
protected static String username;


@BeforeSuite
public void setUp() {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");

	driver = new ChromeDriver(options);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.instagram.com/accounts/login/");
}

@AfterSuite
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}
}