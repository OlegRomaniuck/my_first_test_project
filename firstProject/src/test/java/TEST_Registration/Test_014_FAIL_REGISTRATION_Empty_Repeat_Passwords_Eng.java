package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_014_FAIL_REGISTRATION_Empty_Repeat_Passwords_Eng extends BaseClass {

    @Test
    public void Test_014_FAIL_REGISTRATION_Empty_Repeat_Passwords_Eng() {
        StartPage startPage = new StartPage(driver).load();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        registrationPage.nameField().inputText("");
        registrationPage.emailAdressField().inputText("");
        registrationPage.phoneField().inputText("3");
        registrationPage.loginField().inputText("");
        registrationPage.passField().inputText("12345");
        registrationPage.buttonNextStep().clickOn();

        String actual = registrationPage.LabelPasswordRepeatHelpBlock().getText();
        String expected = "This field is required.";

        // ПРОВЕРКА : появится предупреждение под полем Email
        Assert.assertEquals(actual, expected);
    }
}
