package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_013_FAIL_REGISTRATION_Different_Passwords_Rus extends BaseClass {

    @Test
    public void Test_013_FAIL_REGISTRATION_Different_Passwords_Rus() {
        StartPage startPage = new StartPage(driver).load();
        startPage.changeLangRu();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        registrationPage.passField().inputText("1");
        registrationPage.repeatPassField().inputText("qwe");
        registrationPage.buttonNextStep().clickOn();

        String actual = registrationPage.LabelPasswordRepeatHelpBlock().getText();
        String expected = "Пароли не совпадают";

        // ПРОВЕРКА : появится предупреждение под полем Email
        Assert.assertEquals(actual, expected);
    }
}
