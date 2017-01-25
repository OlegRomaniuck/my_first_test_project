package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.customwait.CustomWaits;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_020_FAIL_REGISTRATION_SignUp_Without_Checkbox_Eng extends BaseClass {

    @Test(groups = "High")
    public void Test_020_FAIL_REGISTRATION_SignUp_Without_Checkbox_Eng() {
        StartPage page = new StartPage(driver).load();

        RegistrationPage registrationPage = page.clickOnRegistrationButton();
        registrationPage.nameField().inputText("");
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
        String expected = "This field is required.";

        Assert.assertEquals(actualErrorMessage, expected);

    }
}
