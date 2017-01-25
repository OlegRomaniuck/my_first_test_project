package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_009_FAIL_REGISTRATION_Name_Spaces_Rus extends BaseClass {

    @Test
    public void Test_009_FAIL_REGISTRATION_Name_Spaces_Rus() {
        StartPage startPage = new StartPage(driver).load();
        startPage.changeLangRu();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        String spaces = "   ";
        registrationPage.nameField().inputText(spaces);
        registrationPage.emailAdressField().inputText("");

        String actual = registrationPage.LabelNameHelpBlock().getText();
        String expected = "Это поле не может содержать пробелы.";

        // ПРОВЕРКА : появится предупреждение под полем Name
        Assert.assertEquals(actual, expected);
    }



}
