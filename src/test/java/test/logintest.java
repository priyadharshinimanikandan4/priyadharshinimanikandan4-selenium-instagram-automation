package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import classs.login;
import instagram.instagram.basec;
import instagram.instagram.datapo;

public class logintest extends basec {

	


	@Test(groups = {"loginFlow"},dataProvider = "login",dataProviderClass = datapo.class)
	public void logintes(String Username,String password) {
		
		login lp = new login(driver);
		lp.enterusername(Username);
		lp.enterpass(password);
		lp.logini();
		user = Username;
		
		
		
	}
}
