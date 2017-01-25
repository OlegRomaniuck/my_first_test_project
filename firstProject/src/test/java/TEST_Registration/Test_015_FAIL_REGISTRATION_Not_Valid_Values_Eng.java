package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.customwait.CustomWaits;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_015_FAIL_REGISTRATION_Not_Valid_Values_Eng extends BaseClass {

    @Test
    public void Test_015_FAIL_REGISTRATION_Not_Valid_Values_Eng() {
        StartPage startPage = new StartPage(driver).load();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        registrationPage.nameField().inputText("A");
        registrationPage.emailAdressField().inputText(".net");
        registrationPage.loginField().inputText("A");
        registrationPage.passField().inputText("1245");
        registrationPage.repeatPassField().inputText("1334");
        registrationPage.buttonNextStep().clickOn();

        new CustomWaits().threadSleep(500);

        boolean actual = registrationPage.isAvailable();

        // ПРОВЕРКА : появится предупреждение под полем Email
        Assert.assertTrue(actual);
    }
}
