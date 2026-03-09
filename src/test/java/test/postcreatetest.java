package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import classs.login;
import classs.postcreation;
import classs.search;
import classs.useraccount;
import instagram.instagram.basec;
import instagram.instagram.datapo;

public class postcreatetest extends basec {

	
postcreation pc;
    @Test(dependsOnGroups = {"userFlow"}, groups = {"postFlow"})
    public void createPostFlow() throws IOException {
    	pc = new postcreation(driver);
        pc.createbtn();
       // pc.posbtn();
       pc.imgbtn();   // OS file dialog opens → press ESC manually
       pc.postcreatebtn();
       
     pc.postdelebtn();
       pc.bacu();     // go back
       
       
    }


    }

