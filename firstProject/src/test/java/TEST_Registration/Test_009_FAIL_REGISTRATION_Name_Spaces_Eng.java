package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_009_FAIL_REGISTRATION_Name_Spaces_Eng extends BaseClass {

    @Test
    public void Test_009_FAIL_REGISTRATION_Name_Spaces_Eng() {
        StartPage startPage = new StartPage(driver).load();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        String spaces = "   ";
        registrationPage.nameField().inputText(spaces);
        registrationPage.emailAdressField().inputText("");

        String actual = registrationPage.LabelNameHelpBlock().getText();
        String expected = "This field can not contain spaces.";

        // ПРОВЕРКА : появится предупреждение под полем Name
        Assert.assertEquals(actual, expected);
    }



}
