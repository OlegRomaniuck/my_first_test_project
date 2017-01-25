package TEST_Widjets;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.LoginPage;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.UserPageMain;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TEST_001v009_Check_that_all_widjets_are_working extends BaseClass {

    private final String LOGIN = "";
    private final String PASSWORD = "1";

    @Test
    public void TEST_001_Check_Widjets_my_statistic() {
        StartPage startPage = new StartPage(driver).load();

        LoginPage login_page = startPage.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(LOGIN, PASSWORD);

        boolean actual_available = main_page.tabMyStatistic().isAvailable();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https:cs.html";

        Assert.assertEquals(actual_available, true);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(groups = "High")
    public void TEST_002_Check_Widjets_my_forecast() {
        StartPage startPage = new StartPage(driver).load();

        LoginPage login_page = startPage.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(LOGIN, PASSWORD);

        boolean actual_available = main_page.tabMyForecast().isAvailable();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https:.html";

        Assert.assertEquals(actual_available, true);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void TEST_003_Check_Widjets_rating_pamm() {
        StartPage startPage = new StartPage(driver).load();

        LoginPage login_page = startPage.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(LOGIN, PASSWORD);

        boolean actual_available = main_page.tabRatingPamm().isAvailable();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https:.html";

        Assert.assertEquals(actual_available, true);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void TEST_004_Check_Widjets_rating_investors() {
        StartPage startPage = new StartPage(driver).load();

        LoginPage login_page = startPage.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(LOGIN, PASSWORD);

        boolean actual_available = main_page.tabRatingInvestor().isAvailable();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https:.html";

        Assert.assertEquals(actual_available, true);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void TEST_005_Check_Widjets_rating_signals() {
        StartPage startPage = new StartPage(driver).load();

        LoginPage login_page = startPage.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(LOGIN, PASSWORD);

        boolean actual_available = main_page.tabRatingSignals().isAvailable();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https:/.html";

        Assert.assertEquals(actual_available, true);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void TEST_007_Check_Widjets_economic_calendar() {
        StartPage startPage = new StartPage(driver).load();

        LoginPage login_page = startPage.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(LOGIN, PASSWORD);

        boolean actual_available = main_page.tabEconomicCalendar().isAvailable();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https:.html";

        Assert.assertEquals(actual_available, true);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void TEST_008_Check_Widjets_blogs() {
        StartPage startPage = new StartPage(driver).load();

        LoginPage login_page = startPage.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(LOGIN, PASSWORD);

        boolean actual_available = main_page.tabBlog().isAvailable();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https:.html";

        Assert.assertEquals(actual_available, true);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void TEST_009_Check_Widjets_news() {
        StartPage startPage = new StartPage(driver).load();

        LoginPage login_page = startPage.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(LOGIN, PASSWORD);

        boolean actual_available = main_page.tabNews().isAvailable();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https:forex.html";

        Assert.assertEquals(actual_available, true);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

}
