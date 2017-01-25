package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_014_FAIL_REGISTRATION_Empty_Repeat_Passwords_Rus extends BaseClass {

    @Test
    public void Test_014_FAIL_REGISTRATION_Empty_Repeat_Passwords_Rus() {
        StartPage startPage = new StartPage(driver).load();
        startPage.changeLangRu();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        registrationPage.nameField().inputText("");
        registrationPage.emailAdressField().inputText("");
        registrationPage.phoneField().inputText("");
        registrationPage.loginField().inputText("A");
        registrationPage.passField().inputText("123456");
        registrationPage.buttonNextStep().clickOn();

        String actual = registrationPage.LabelPasswordRepeatHelpBlock().getText();
        String expected = "Это поле обязательно к заполнению.";

        // ПРОВЕРКА : появится предупреждение под полем Email
        Assert.assertEquals(actual, expected);
    }
}
