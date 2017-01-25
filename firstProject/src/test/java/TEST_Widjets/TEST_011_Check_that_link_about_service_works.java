package TEST_Widjets;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TEST_011_Check_that_link_about_service_works extends BaseClass {

    private final String LOGIN = "";
    private final String PASSWORD = "";

    @Test
    public void TEST_001_Check_Widjets_about_service() {
        StartPage startPage = new StartPage(driver).load();

        LoginPage login_page = startPage.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(LOGIN, PASSWORD);

        AboutService aboutService = main_page.tabAboutService();
        String expectedUrl = ".html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
    }

   }
