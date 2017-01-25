package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_005_FAIL_REGISTRATION_Name_Min_Limit_Rus extends BaseClass {

    @Test
    public void Test_005_FAIL_REGISTRATION_Name_Min_Limit_Rus() {
        StartPage startPage = new StartPage(driver).load();
        startPage.changeLangRu();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        String nameMinSymbols = "a";
        registrationPage.nameField().inputText(nameMinSymbols);
        registrationPage.emailAdressField().inputText("");

        String actual = registrationPage.LabelNameHelpBlock().getText();
        String expected = "Пожалуйста введите не менее 2 символов";

        // ПРОВЕРКА : появится предупреждение под полем Name
        Assert.assertEquals(actual, expected);
    }



}
