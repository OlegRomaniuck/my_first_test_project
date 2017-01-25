package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_008_FAIL_REGISTRATION_PasswordRepeat_Min_Limit_Rus extends BaseClass {

    @Test
    public void Test_008_FAIL_REGISTRATION_PasswordRepeat_Min_Limit_Rus() {
        StartPage startPage = new StartPage(driver).load();
        startPage.changeLangRu();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        String passwordMinSymbols = "q2";
        registrationPage.passField().inputText(passwordMinSymbols);
        registrationPage.repeatPassField().inputText(passwordMinSymbols);
        registrationPage.emailAdressField().inputText("");

        String actual = registrationPage.LabelPasswordRepeatHelpBlock().getText();
        String expected = "Пожалуйста введите не менее 3 символов";

        // ПРОВЕРКА : появится предупреждение под полем Пароль повтор
        Assert.assertEquals(actual, expected);
    }



}
