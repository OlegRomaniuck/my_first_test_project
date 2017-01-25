package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.customwait.CustomWaits;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_019_REGISTRATION_Showing_PaySystem_Platinum_Eng extends BaseClass {

    @Test(groups = "High")
    public void Test_019_REGISTRATION_Showing_PaySystem_Platinum_Eng() {
        StartPage page = new StartPage(driver).load();

        RegistrationPage registrationPage = page.clickOnRegistrationButton();
        registrationPage.nameField().inputText("");
        registrationPage.emailAdressField().inputText("t");
        registrationPage.phoneField().inputText("");
        registrationPage.loginField().inputText("");
        registrationPage.passField().inputText("123");
        registrationPage.repeatPassField().inputText("123");
        registrationPage.buttonNextStep().clickOn();

        new CustomWaits().threadSleep(500);

        registrationPage.buttonPlatinum().clickOn();
        registrationPage.checkBoxAcceptLicense().activate();
        String actualPriceInPaySystem = registrationPage.getPriceFromShowingPaySystemAfterClickSignUp();
        String expectedPrice = "1000";

        Assert.assertEquals(actualPriceInPaySystem, expectedPrice);
    }
}
