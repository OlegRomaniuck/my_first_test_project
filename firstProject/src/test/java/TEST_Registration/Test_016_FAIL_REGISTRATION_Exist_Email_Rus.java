package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_016_FAIL_REGISTRATION_Exist_Email_Rus extends BaseClass {

    // Test зависим от Test_001 - в случае его не успешного прохождения, юзера в базе не будет и как следствие этот тест пройдет
    @Test
    public void Test_016_FAIL_REGISTRATION_Exist_Email_Rus() {
        StartPage startPage = new StartPage(driver).load();
        startPage.changeLangRu();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        String existingEmailTest001 = "";
        registrationPage.emailAdressField().inputText(existingEmailTest001);
        registrationPage.loginField().inputText("");

        String actual = registrationPage.LabelEmailHelpBlock().getText();
        String expected = "Пользователь с этим e-mail уже зарегистрирован";

        // ПРОВЕРКА : появится предупреждение под полем Email
        Assert.assertEquals(actual, expected);
    }
}
