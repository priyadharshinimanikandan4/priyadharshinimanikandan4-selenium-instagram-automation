package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import classs.forgotpage;
public class forgettest {
   
   @Test
   public void forggot() {
   
  WebDriver driver = new ChromeDriver();
  driver.get("https://www.instagram.com/accounts/password/reset/");
   
  forgotpage fp = new forgotpage();
  fp.username("priyadharshinimanikandan4@gmail.com");
  fp.loginq();
  
  driver.close();
   
  
   }
}
