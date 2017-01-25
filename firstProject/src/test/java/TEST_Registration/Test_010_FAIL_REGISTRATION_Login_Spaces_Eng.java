package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_010_FAIL_REGISTRATION_Login_Spaces_Eng extends BaseClass {

    @Test
    public void Test_010_FAIL_REGISTRATION_Login_Spaces_Eng() {
        StartPage startPage = new StartPage(driver).load();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        String spaces = "   ";
        registrationPage.loginField().inputText(spaces);
        registrationPage.emailAdressField().inputText("");

        String actual = registrationPage.LabelLoginHelpBlock().getText();
        String expected = "This field can not contain spaces.";

        // ПРОВЕРКА : появится предупреждение под полем Логин
        Assert.assertEquals(actual, expected);
    }
}
