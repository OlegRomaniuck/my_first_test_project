package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.customwait.CustomWaits;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_021_FAIL_REGISTRATION_SignUp_Without_Subscription_Rus extends BaseClass {

    @Test(groups = "High")
    public void Test_021_FAIL_REGISTRATION_SignUp_Without_Subscription_Rus() {
        StartPage startPage = new StartPage(driver).load();
        startPage.changeLangRu();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        registrationPage.nameField().inputText("t");
        registrationPage.emailAdressField().inputText("");
        registrationPage.phoneField().inputText("");
        registrationPage.loginField().inputText("t");
        registrationPage.passField().inputText("123");
        registrationPage.repeatPassField().inputText("123");
        registrationPage.buttonNextStep().clickOn();

        new CustomWaits().threadSleep(500);

        registrationPage.checkBoxAcceptLicense().unActivate();
        registrationPage.buttonSignUP().clickOn();

        String actualErrorMessage = registrationPage.LabelLicenseHelpBlock().getText();
        String expected = "Это поле обязательно к заполнению.";

        Assert.assertEquals(actualErrorMessage, expected);

    }
}
