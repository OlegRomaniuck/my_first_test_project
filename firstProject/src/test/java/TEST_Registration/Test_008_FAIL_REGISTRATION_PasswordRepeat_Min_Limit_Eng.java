package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_008_FAIL_REGISTRATION_PasswordRepeat_Min_Limit_Eng extends BaseClass {

    @Test
    public void Test_008_FAIL_REGISTRATION_PasswordRepeat_Min_Limit_Eng() {
        StartPage startPage = new StartPage(driver).load();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        String passwordMinSymbols = "q2";
        registrationPage.passField().inputText(passwordMinSymbols);
        registrationPage.repeatPassField().inputText(passwordMinSymbols);
        registrationPage.emailAdressField().inputText("");

        String actual = registrationPage.LabelPasswordRepeatHelpBlock().getText();
        String expected = "Please enter at least 3 characters";

        // ПРОВЕРКА : появится предупреждение под полем Пароль повтор
        Assert.assertEquals(actual, expected);
    }



}
