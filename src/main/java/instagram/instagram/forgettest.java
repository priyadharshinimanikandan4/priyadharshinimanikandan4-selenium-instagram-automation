package instagram.instagram;

import org.testng.annotations.Test;
import classs.forgotpage;

public class forgettest {

    @Test
    public void forgotPasswordTest() {

        forgotpage page = new forgotpage();

        page.openLoginPage();
        page.clickForgotPassword();
        page.enterUsernameAndContinue("8807791065");   //     page.clickSendLoginLink();
        System.out.println("Forgot password flow executed successfully");
        page.enterUsernameAndContinue("8807791065");   //     page.clickSendLoginLink();

        System.out.println("Forgot password flow executed successfully");
    }
}
