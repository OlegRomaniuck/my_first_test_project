package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.util.Util_Logger;
import com.invest.core.web.customwait.CustomWaits;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_002_FAIL_REGISTRATION_Empty_Fields extends BaseClass {

    @Test
    public void Test_002_FAIL_REGISTRATION_Empty_Fields() {
        StartPage startPage = new StartPage(driver).load();

        RegistrationPage registrationPage = startPage.clickOnRegistrationButton();
        registrationPage.buttonNextStep().clickOn();

        new CustomWaits().threadSleep(500);

        Util_Logger.info("We verify that we have not moved to step 2 and remain in step 1");
        boolean actual = registrationPage.isAvailable();

        // ПРОВЕРКА : пользователь остался на первом шаге Регистрации, проверяем что формы присутсвуют на странице
        Assert.assertTrue(actual);
    }

}
