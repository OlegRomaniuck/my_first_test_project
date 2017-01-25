package TEST_Registration;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.UserPageMain;
import com.invest.core.web.pages.registration.RegistrationPage;
import com.invest.core.web.webrequest.HttpRequest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tester3 on 07.03.2016.
 * Регистрация через пайпал предварительно дергаем апи  and удаляем юзера добавляем юзера
 */
public class Test_001_SUCCESS_REGISTRATION_Using_PayPal extends BaseClass {

    private static final String URLHASH = "/test/delete_test/?_hash=3";

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{{"Test", "test", "3", "Oleg", ""}};
    }

    @Test
    public void deleteUserFromBD() {
        HttpRequest request_on_delete = new HttpRequest();
        request_on_delete.requestToDeleteUserPayPal(URLHASH);
    }

    @Test(dataProvider="getData", groups = "High", dependsOnMethods = {"deleteUserFromBD"})
    public void registration_New_User_From_Pay_Pal(String name, String email, String phone, String login, String password) {
        StartPage page = new StartPage(driver).load();

        RegistrationPage registrationPage = page.clickOnRegistrationButton();
        registrationPage.nameField().inputText(name);
        registrationPage.emailAdressField().inputText(email);
        registrationPage.phoneField().inputText(phone);
        registrationPage.loginField().inputText(login);
        registrationPage.passField().inputText(password);
        registrationPage.repeatPassField().inputText(password);
        registrationPage.buttonNextStep().clickOn();

        UserPageMain main_page = registrationPage.successActivateMySubscription();

        List<String> list_expected_tab = new ArrayList<>();
        list_expected_tab.add("My FORECAST");
        list_expected_tab.add("My STATISTICS");
        list_expected_tab.add("DASHBOARD");
        list_expected_tab.add("Rating ACCOUNTS");
        list_expected_tab.add("Rating INVES");
        list_expected_tab.add("Rating ");
        list_expected_tab.add("Economic CALENDAR");
        list_expected_tab.add("BLOG");
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < list_expected_tab.size(); i++) {
            System.out.println("11 " + main_page.getListOfTab().get(i));
            softAssert.assertEquals(main_page.getListOfTab().get(i), list_expected_tab.get(i));

        }

        softAssert.assertTrue(main_page.isAvailable());

        softAssert.assertAll();

    }



}


