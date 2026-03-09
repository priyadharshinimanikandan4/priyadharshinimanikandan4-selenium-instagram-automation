package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import classs.forgotpage;
import classs.login;
import classs.search;
import instagram.instagram.basec;
import instagram.instagram.datapo;
public class searchtest extends basec  {

	

	
	 @Test(dependsOnGroups = {"loginFlow"}, groups = {"searchFlow"})
	public void first() throws InterruptedException {

		search s = new search(driver);
		s.sear(user);
		s.firstresult(user);

	}
	
	
	
	
	
	

	
}
