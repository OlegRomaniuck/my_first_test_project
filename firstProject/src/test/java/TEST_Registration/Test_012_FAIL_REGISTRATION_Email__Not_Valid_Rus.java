package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_012_FAIL_REGISTRATION_Email__Not_Valid_Rus extends BaseClass {

    @Test
    public void Test_012_FAIL_REGISTRATION_Email__Not_Valid_Rus() {
        StartPage startPage = new StartPage(driver).load();
        startPage.changeLangRu();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        registrationPage.emailAdressField().inputText("");
        registrationPage.nameField().inputText("");
        registrationPage.buttonNextStep().clickOn();

        String actual = registrationPage.LabelEmailHelpBlock().getText();
        String expected = "Некорректный e-mail";

        // ПРОВЕРКА : появится предупреждение под полем Email
        Assert.assertEquals(actual, expected);
    }
}
