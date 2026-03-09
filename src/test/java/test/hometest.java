package test;

import org.testng.annotations.Test;

import classs.Homepage;
import instagram.instagram.basec;

public class hometest extends basec{

	Homepage hp ;
	
	@Test(dependsOnGroups={"notesFlow"} , groups={"homeFlow"})
	public void hime() throws InterruptedException {
		hp = new Homepage(driver);
		hp.findHome();
		hp.like();
		hp.notifications();
		hp.reels();
	}
}
