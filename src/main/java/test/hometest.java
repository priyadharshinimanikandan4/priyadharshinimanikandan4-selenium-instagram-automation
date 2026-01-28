package test;

import org.testng.annotations.Test;

import classs.Homepage;
import instagram.instagram.basec;

public class hometest extends basec{

	Homepage hp ;
	
	@Test(dependsOnGroups={"notesFlow"} , groups={"homeFlow"})
	public void hime() {
		hp = new Homepage(driver);
		hp.findhom();
		hp.like();
		hp.Notifictaions();
		hp.reels();
	}
}
