package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_017_FAIL_REGISTRATION_Exist_Login_Rus extends BaseClass {

    // Test зависим от Test_001 - в случае его не успешного прохождения, юзера в базе не будет и как следствие этот тест пройдет
    @Test
    public void Test_017_FAIL_REGISTRATION_Exist_Login_Rus() {
        StartPage startPage = new StartPage(driver).load();
        startPage.changeLangRu();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        String existingLoginTest001 = "Oleg";
        registrationPage.loginField().inputText(existingLoginTest001);
        registrationPage.emailAdressField().inputText("");

        String actual = registrationPage.LabelLoginHelpBlock().getText();
        String expected = "Извините, этот логин уже используется";

        // ПРОВЕРКА : появится предупреждение под полем Email
        Assert.assertEquals(actual, expected);
    }
}
