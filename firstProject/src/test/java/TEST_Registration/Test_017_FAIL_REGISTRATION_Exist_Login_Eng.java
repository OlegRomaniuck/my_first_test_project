package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_017_FAIL_REGISTRATION_Exist_Login_Eng extends BaseClass {

    // Test зависим от Test_001 - в случае его не успешного прохождения, юзера в базе не будет и как следствие этот тест пройдет
    @Test
    public void Test_017_FAIL_REGISTRATION_Exist_Login_Eng() {
        StartPage startPage = new StartPage(driver).load();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        String existingLoginTest001 = "tOleg";
        registrationPage.loginField().inputText(existingLoginTest001);
        registrationPage.emailAdressField().inputText("");

        String actual = registrationPage.LabelLoginHelpBlock().getText();
        String expected = "Sorry, this username is taken";

        // ПРОВЕРКА : появится предупреждение под полем Email
        Assert.assertEquals(actual, expected);
    }
}
