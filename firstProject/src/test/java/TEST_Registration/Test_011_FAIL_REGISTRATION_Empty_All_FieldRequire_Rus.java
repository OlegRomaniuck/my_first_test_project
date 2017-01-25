package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_011_FAIL_REGISTRATION_Empty_All_FieldRequire_Rus extends BaseClass {

    @Test
    public void Test_011_FAIL_REGISTRATION_Empty_All_FieldRequire_Rus() {
        StartPage startPage = new StartPage(driver).load();
        startPage.changeLangRu();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        registrationPage.buttonNextStep().clickOn();

        String actualHelpNameField = registrationPage.LabelNameHelpBlock().getText();
        String actualHelpEmailField = registrationPage.LabelEmailHelpBlock().getText();
        String actualHelpPhoneField = registrationPage.LabelPhoneHelpBlock().getText();
        String actualHelpLoginField = registrationPage.LabelLoginHelpBlock().getText();
        String actualHelpPasswordField = registrationPage.LabelPasswordHelpBlock().getText();
        String actualHelpPasswordRepeatField = registrationPage.LabelPasswordRepeatHelpBlock().getText();
        String expected = "Это поле обязательно к заполнению.";

        // ПРОВЕРКА : появится предупреждение под всеми полями This field is required.
        Assert.assertEquals(actualHelpNameField, expected);
        Assert.assertEquals(actualHelpEmailField, expected);
        Assert.assertEquals(actualHelpPhoneField, expected);
        Assert.assertEquals(actualHelpLoginField, expected);
        Assert.assertEquals(actualHelpPasswordField, expected);
        Assert.assertEquals(actualHelpPasswordRepeatField, expected);
    }
}
