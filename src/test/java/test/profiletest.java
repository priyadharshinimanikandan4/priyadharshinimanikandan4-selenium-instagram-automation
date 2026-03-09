package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import classs.login;
import classs.profilepage;
import classs.search;
import instagram.instagram.basec;
import instagram.instagram.datapo;

public class profiletest extends basec{

	
	profilepage p;
	
	
	
	@Test(dependsOnGroups= {"exploreFlow"},groups= {"proFlow"})
		    public void validateUsername() throws InterruptedException {
		p = new profilepage(driver) ;
		p.search("priya_dharshini_manikandan");
		
		        p.username();
		  
		        p.flwbtn(); // You can remove the parameter in your class if unused
		  
		       p.msgicon();
		   p.senmsg("hii");
		        p.postvalidate();
		   
		        p.findSuggestion();
		   
		        p.firstsuggestedAcc();
		    
	}
	
}
