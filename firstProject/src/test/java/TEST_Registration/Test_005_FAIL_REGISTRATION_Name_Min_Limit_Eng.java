package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_005_FAIL_REGISTRATION_Name_Min_Limit_Eng extends BaseClass {

    @Test
    public void Test_005_FAIL_REGISTRATION_Name_Min_Limit_Eng() {
        StartPage startPage = new StartPage(driver).load();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        String nameMinSymbols = "a";
        registrationPage.nameField().inputText(nameMinSymbols);
        registrationPage.emailAdressField().inputText("");

        String actual = registrationPage.LabelNameHelpBlock().getText();
        String expected = "Please enter at least 2 characters";

        // ПРОВЕРКА : появится предупреждение под полем Name
        Assert.assertEquals(actual, expected);
    }



}
