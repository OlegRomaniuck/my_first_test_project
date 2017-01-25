package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_006_FAIL_REGISTRATION_Login_Min_Limit_Eng extends BaseClass {

    @Test
    public void Test_006_FAIL_REGISTRATION_Login_Min_Limit_Eng() {
        StartPage startPage = new StartPage(driver).load();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        String loginMinSymbols = "a";
        registrationPage.loginField().inputText(loginMinSymbols);
        registrationPage.emailAdressField().inputText("");

        String actual = registrationPage.LabelLoginHelpBlock().getText();
        String expected = "Please enter at least 2 characters";

        // ПРОВЕРКА : появится предупреждение под полем Логин
        Assert.assertEquals(actual, expected);
    }
}
