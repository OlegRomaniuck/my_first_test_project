package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.customwait.CustomWaits;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_023_REGISTRATION_Dropdown_Price_Gold extends BaseClass {

    @Test(groups = "High")
    public void Test_023_REGISTRATION_Dropdown_Price_Gold() {
        StartPage page = new StartPage(driver).load();

        RegistrationPage registrationPage = page.clickOnRegistrationButton();
        registrationPage.nameField().inputText("");
        registrationPage.emailAdressField().inputText("t");
        registrationPage.phoneField().inputText("");
        registrationPage.loginField().inputText("");
        registrationPage.passField().inputText("123");
        registrationPage.repeatPassField().inputText("123");
        registrationPage.buttonNextStep().clickOn();

        new CustomWaits().threadSleep(500);

        registrationPage.buttonGold().clickOn();

        registrationPage.buttonDropDown().clickOn();
        registrationPage.listBoxInDropDown().chooseByPosition(3);

        String actual = registrationPage.getPriceFromShowingPaySystemAfterClickSignUp();
        String expected = "300";

        Assert.assertEquals(actual, expected);
    }
}
