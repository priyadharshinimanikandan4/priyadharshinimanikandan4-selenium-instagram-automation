package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import classs.login;
import classs.search;
import classs.useraccount;
import instagram.instagram.basec;
import instagram.instagram.datapo;

public class useraccTest extends basec {

	useraccount ua ;
	 @BeforeClass
	    public void setupPage() {
	        ua = new useraccount(driver);
	    }
		
    @Test(dependsOnGroups = {"searchFlow"}, groups = {"userFlow"})
    public void checkProfileName() {
        ua.name();
       ua.profile();
    
        ua.bio();
   
        ua.getaccstatus();
        ua.accsta();
    ua.bas();
        ua.accstah();
   
        ua.posticon();
   
        ua.saveditems(user);
        ua.tagged(user);
    }

  
}
