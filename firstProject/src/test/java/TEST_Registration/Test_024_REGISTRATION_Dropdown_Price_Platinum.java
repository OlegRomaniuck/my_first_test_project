package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.customwait.CustomWaits;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_024_REGISTRATION_Dropdown_Price_Platinum extends BaseClass {

    @Test(groups = "High")
    public void Test_024_REGISTRATION_Dropdown_Price_Platinum() {
        StartPage page = new StartPage(driver).load();

        RegistrationPage registrationPage = page.clickOnRegistrationButton();
        registrationPage.nameField().inputText("");
        registrationPage.emailAdressField().inputText("t");
        registrationPage.phoneField().inputText("3");
        registrationPage.loginField().inputText("t");
        registrationPage.passField().inputText("123");
        registrationPage.repeatPassField().inputText("123");
        registrationPage.buttonNextStep().clickOn();

        new CustomWaits().threadSleep(500);

        registrationPage.buttonPlatinum().clickOn();

        registrationPage.buttonDropDown().clickOn();
        registrationPage.listBoxInDropDown().chooseByPosition(8);

        String actual = registrationPage.getPriceFromShowingPaySystemAfterClickSignUp();
        String expected = "8000";

        Assert.assertEquals(actual, expected);
    }
}
