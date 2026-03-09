package test;

import org.testng.annotations.Test;
import classs.explore;
import instagram.instagram.basec;

public class exploretest extends basec {

   
    @Test(groups = "exploreFlow", dependsOnGroups = {"homeFlow"})
    public void explo() {
    	 explore e = new explore(driver);
        System.out.println("Clicking Explore button...");
        e.cliexplore();

        System.out.println("Opening first Reel...");
        e.disreel();

        System.out.println("Explore test completed successfully.");
    }
}
