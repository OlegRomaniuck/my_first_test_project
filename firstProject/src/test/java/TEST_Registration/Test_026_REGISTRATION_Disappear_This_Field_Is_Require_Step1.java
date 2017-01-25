package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_026_REGISTRATION_Disappear_This_Field_Is_Require_Step1 extends BaseClass {

    @Test
    public void Test_026_REGISTRATION_Disappear_This_Field_Is_Require_Step1() {
        StartPage page = new StartPage(driver).load();

        RegistrationPage registrationPage = page.clickOnRegistrationButton();
        registrationPage.buttonNextStep().clickOn();

        registrationPage.nameField().inputText("");
        registrationPage.emailAdressField().inputText("");
        registrationPage.phoneField().inputText("");
        registrationPage.loginField().inputText("");
        registrationPage.passField().inputText("123");
        registrationPage.repeatPassField().inputText("123");

        Assert.assertFalse(registrationPage.LabelNameHelpBlock().isAvailable());
        Assert.assertFalse(registrationPage.LabelEmailHelpBlock().isAvailable());
        Assert.assertFalse(registrationPage.LabelPhoneHelpBlock().isAvailable());
        Assert.assertFalse(registrationPage.LabelLoginHelpBlock().isAvailable());
        Assert.assertFalse(registrationPage.LabelPasswordHelpBlock().isAvailable());
        Assert.assertFalse(registrationPage.LabelPasswordRepeatHelpBlock().isAvailable());
    }
}
