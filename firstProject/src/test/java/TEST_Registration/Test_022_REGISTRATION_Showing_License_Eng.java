package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.customwait.CustomWaits;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_022_REGISTRATION_Showing_License_Eng extends BaseClass {

    @Test
    public void Test_022_REGISTRATION_Showing_License_Eng() {
        StartPage page = new StartPage(driver).load();

        RegistrationPage registrationPage = page.clickOnRegistrationButton();
        registrationPage.nameField().inputText("");
        registrationPage.emailAdressField().inputText("t");
        registrationPage.phoneField().inputText("");
        registrationPage.loginField().inputText("t");
        registrationPage.passField().inputText("123");
        registrationPage.repeatPassField().inputText("123");
        registrationPage.buttonNextStep().clickOn();

        new CustomWaits().threadSleep(500);

        registrationPage.buttonLicense().clickOn();

        new CustomWaits().threadSleep(500);

        boolean actualLicenseCloseButtonDisplayed = registrationPage.buttonCloseLicense().isAvailable();

        registrationPage.buttonCloseLicense().clickOn();

        Assert.assertTrue(actualLicenseCloseButtonDisplayed);
    }
}
