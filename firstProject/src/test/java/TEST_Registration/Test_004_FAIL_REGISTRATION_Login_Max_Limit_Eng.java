package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import com.invest.core.web.tools.CommonMethods;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_004_FAIL_REGISTRATION_Login_Max_Limit_Eng extends BaseClass {

    @Test
    public void Test_004_FAIL_REGISTRATION_Login_Max_Limit_Eng() {
        StartPage startPage = new StartPage(driver).load();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        String loginMaxSymbols = CommonMethods.getRandomString(257);
        registrationPage.loginField().inputText(loginMaxSymbols);
        registrationPage.emailAdressField().inputText("");

        String actual = registrationPage.LabelLoginHelpBlock().getText();
        String expected = "Please enter no more than 256 characters";

        // ПРОВЕРКА : появится предупреждение под полем Логин
        Assert.assertEquals(actual, expected);
    }
}
