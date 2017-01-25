package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_013_FAIL_REGISTRATION_Different_Passwords_Eng extends BaseClass {

    @Test
    public void Test_013_FAIL_REGISTRATION_Different_Passwords_Eng() {
        StartPage startPage = new StartPage(driver).load();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        registrationPage.passField().inputText("123");
        registrationPage.repeatPassField().inputText("qwe");
        registrationPage.buttonNextStep().clickOn();

        String actual = registrationPage.LabelPasswordRepeatHelpBlock().getText();
        String expected = "Passwords mismatch";

        // ПРОВЕРКА : появится предупреждение под полем Email
        Assert.assertEquals(actual, expected);
    }
}
