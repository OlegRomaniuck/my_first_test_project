package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.customwait.CustomWaits;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_018_REGISTRATION_Showing_PaySystem_GOLD_Eng extends BaseClass {

    @Test(groups = "High")
    public void Test_018_REGISTRATION_Showing_PaySystem_GOLD_Eng() {
        StartPage page = new StartPage(driver).load();

        RegistrationPage registrationPage = page.clickOnRegistrationButton();
        registrationPage.nameField().inputText("");
        registrationPage.emailAdressField().inputText("");
        registrationPage.phoneField().inputText("3");
        registrationPage.loginField().inputText("");
        registrationPage.passField().inputText("123");
        registrationPage.repeatPassField().inputText("123");
        registrationPage.buttonNextStep().clickOn();

        new CustomWaits().threadSleep(500);

        registrationPage.buttonGold().clickOn();
        registrationPage.checkBoxAcceptLicense().activate();
        String actualPriceInPaySystem = registrationPage.getPriceFromShowingPaySystemAfterClickSignUp();
        String expectedPrice = "100";

        Assert.assertEquals(actualPriceInPaySystem, expectedPrice);
    }
}
