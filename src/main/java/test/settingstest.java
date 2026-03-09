package test;

import org.testng.annotations.Test;

import classs.settings;
import instagram.instagram.basec;

public class settingstest extends basec {

	
	settings s ;
	
	@Test(dependsOnGroups = {"proFlow"}, groups= {"settFlow"})
	public void set() {
		s = new settings(driver);
		s.sett();
		s.theme();
		s.icon();
		s.back();
		s.logout();
	}
}

