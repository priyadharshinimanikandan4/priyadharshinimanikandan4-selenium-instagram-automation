package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import classs.explore;
import instagram.instagram.basec;

public class exploretest extends basec {

	explore e1;
	
	@Test(dependsOnGroups = {"homeFlow"} , groups = {"exploreFlow"})
	public void explo() {
		e1 = new explore(driver);
	e1.cliexplore();
	e1.disreel();
	}
	
}
