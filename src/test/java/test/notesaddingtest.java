package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import classs.login;
import classs.notesadding;
import classs.postcreation;
import classs.search;
import classs.useraccount;
import instagram.instagram.basec;
import instagram.instagram.datapo;

public class notesaddingtest extends basec {

	
   

  notesadding n;
  
 String note;
    @Test(dependsOnGroups = {"postFlow"}, groups = {"notesFlow"})
    public void notesadd() {
    	n = new notesadding(driver);
    	note = "should go with flow of life";
    	n.message();
    	n.icon();
    	n.noteswrit(note);
    	n.sarebtnclick();
    	
        	 
    
    }
}
