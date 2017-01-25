package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import com.invest.core.web.tools.CommonMethods;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_003_FAIL_REGISTRATION_Name_Max_Limit_Rus extends BaseClass {

    @Test
    public void Test_003_FAIL_REGISTRATION_Name_Max_Limit_Rus() {
        StartPage startPage = new StartPage(driver).load();
        startPage.changeLangRu();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        String nameMaxSymbols = CommonMethods.getRandomString(257);
        registrationPage.nameField().inputText(nameMaxSymbols);
        registrationPage.emailAdressField().inputText("");

        String actual = registrationPage.LabelNameHelpBlock().getText();
        String expected = "Пожалуйста, введите не более 256 символов";

        // ПРОВЕРКА : появится предупреждение под полем Name
        Assert.assertEquals(actual, expected);
    }



}
