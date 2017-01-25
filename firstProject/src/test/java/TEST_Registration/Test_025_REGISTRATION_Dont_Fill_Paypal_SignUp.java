package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.customwait.CustomWaits;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_025_REGISTRATION_Dont_Fill_Paypal_SignUp extends BaseClass {

    @Test(groups = "High")
    public void Test_025_REGISTRATION_Dont_Fill_Paypal_SignUp() {
        StartPage page = new StartPage(driver).load();

        RegistrationPage registrationPage = page.clickOnRegistrationButton();
        registrationPage.nameField().inputText("");
        registrationPage.emailAdressField().inputText("");
        registrationPage.phoneField().inputText("");
        registrationPage.loginField().inputText("");
        registrationPage.passField().inputText("123");
        registrationPage.repeatPassField().inputText("123");
        registrationPage.buttonNextStep().clickOn();

        new CustomWaits().threadSleep(500);

        registrationPage.buttonActivateMySubscription().clickOn();

        registrationPage.buttonSignUP().clickOn();

        boolean actual = registrationPage.LabelAddMyPayPalHelpBlock().isAvailable();

        Assert.assertTrue(actual);

    }
}
