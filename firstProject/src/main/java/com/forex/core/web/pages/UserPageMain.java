package com.invest.core.web.pages;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebPage;
import com.invest.core.web.elements.Button;
import com.invest.core.web.elements.ListSomeElements;
import com.invest.core.web.pages.myforecast.UserForecast;
import com.invest.core.web.pages.mystatistic.MyStatistic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class UserPageMain extends WebPage<UserPageMain> {

    public UserPageMain(WebDriver driver) {
        super(driver);
    }

    private static final String PAGE_URL = "https:";

    @Override
    public UserPageMain load() {
        driver.get(PAGE_URL);
        Util_Logger.showUrl(PAGE_URL);
        return this;
    }

    @Override
    public boolean isAvailable() {
        Util_Logger.showUrl(PAGE_URL);
        return buttonDashboard().isAvailable() && buttonMyStatistic().isAvailable() && buttonMyForecast().isAvailable()
                && buttonRatingPamm().isAvailable() && buttonRatingInvestors().isAvailable()
                && buttonRatingSignals().isAvailable() /*&& buttonTechnicalAnalysis().isAvailable()*/ // убрали пока тех агализ
                && buttonEconomicCalendar().isAvailable() && buttonBlog().isAvailable()
                && buttonOpenMenuInProfile().isAvailable();
    }

    public UserForecast tabMyForecast() {
        Util_Logger.Log.info("Try click on button " + Thread.currentThread().getStackTrace()[1].getMethodName());
        buttonMyForecast().clickOn();
        return new UserForecast(driver).waitUntilAvailable();
    }

    public MyStatistic tabMyStatistic() {

        Util_Logger.Log.info("Try click on button my Statistic");
        buttonMyStatistic().clickOn();
        return new MyStatistic(driver).waitUntilAvailable();
    }

    public TraidersPage tabRatingPamm() {
        Util_Logger.Log.info("Try click on button Rating Pamm");
        buttonRatingPamm().click();
        return new TraidersPage(driver).waitUntilAvailable();
    }

    public RatingInvestorPage tabRatingInvestor() {
        Util_Logger.Log.info("Try click on button Rating Investors");
        buttonRatingInvestors().click();
        return new RatingInvestorPage(driver).waitUntilAvailable();
    }

    public RatingSignals tabRatingSignals() {
        Util_Logger.Log.info("Try click on button Rating Signals");
        buttonRatingSignals().click();
        return new RatingSignals(driver).waitUntilAvailable();
    }



    public EconomicCalendar tabEconomicCalendar() {
        Util_Logger.Log.info("Try click on button Technical Analysis");
        buttonEconomicCalendar().click();
        return new EconomicCalendar(driver).waitUntilAvailable();
    }

    public Blog tabBlog() {
        Util_Logger.Log.info("Try click on button Blog");
        buttonBlog().click();
        return new Blog(driver).waitUntilAvailable();
    }

    public News tabNews() {
        Util_Logger.Log.info("Try click on button News");
        buttonNews().click();
        return new News(driver).waitUntilAvailable();
    }



    public AboutService tabAboutService() {
        Util_Logger.Log.info("Try click on button About Service");
        buttonAboutService().click();
        return new AboutService(driver).waitUntilAvailable();
    }

    public MyProfilePage openMyProfile() {
        Util_Logger.Log.info("Try click on button my name for open my menu");
        buttonOpenMenuInProfile().clickOn();
        Util_Logger.Log.info("Try click on button in menu Profile");
        buttonProfileInMenu().waitUntilAvailable();
        buttonProfileInMenu().clickOn();
        return new MyProfilePage(driver).waitUntilAvailable();
    }

    public MyPersonalPage openMyPersonalPage() {
        Util_Logger.Log.info("Try click on button my name for open my menu");
        buttonOpenMenuInProfile().clickOn();
        Util_Logger.Log.info("Try click on button in menu Profile");
        buttonMyPersonalPage().waitUntilAvailable();
        buttonMyPersonalPage().clickOn();
        return new MyPersonalPage(driver).waitUntilAvailable();
    }

    public List<String> getListOfTab() {
        List<String> list_text = new ArrayList<>();
        List<WebElement> _list = new ListSomeElements(driver, By.xpath("//div[starts-with(@id,'app-desktop-')]/div[starts-with(@id,'tabbar')]//a")).getListElementsFluent();
        for (WebElement ele : _list) {
            list_text.add(ele.getText().replaceAll("\\n", " "));
        }
        return list_text;
    }

    // ********************* Buttons elements *****************

    public Button buttonMyForecast() {
        return new Button(driver, By.xpath("//div[starts-with(@id,'app-desktop-')]/div[starts-with(@id,'tabbar-')]//a[1]"));
    }

    public Button buttonMyStatistic() {
        return new Button(driver, By.xpath("//div[starts-with(@id,'app-desktop-')]/div[starts-with(@id,'tabbar-')]//a[2]"));
    }

    public Button buttonDashboard() {
        return new Button(driver, By.xpath("//div[starts-with(@id,'app-desktop-')]/div[starts-with(@id,'tabbar-')]//a[3]"));
    }

    public Button buttonRatingPamm() {
        return new Button(driver, By.xpath("//div[starts-with(@id,'app-desktop-')]/div[starts-with(@id,'tabbar-')]//a[4]"));
    }

    public Button buttonRatingInvestors() {
        return new Button(driver, By.xpath("//div[starts-with(@id,'app-desktop-')]/div[starts-with(@id,'tabbar-')]//a[5]"));
    }

    public Button buttonRatingSignals() {
        return new Button(driver, By.xpath("//div[starts-with(@id,'app-desktop-')]/div[starts-with(@id,'tabbar-')]//a[6]"));
    }



    public Button buttonEconomicCalendar() {
        return new Button(driver, By.xpath("//div[starts-with(@id,'app-desktop-')]/div[starts-with(@id,'tabbar-')]//a[7]"));
    }

    public Button buttonBlog() {
        return new Button(driver, By.xpath("//div[starts-with(@id,'app-desktop-')]/div[starts-with(@id,'tabbar-')]//a[8]"));
    }

    public Button buttonNews() {
        return new Button(driver, By.xpath("//div[starts-with(@id,'app-desktop-')]/div[starts-with(@id,'tabbar-')]//a[9]"));
    }


    public Button buttonOpenMenuInProfile() {
        return new Button(driver, By.xpath("//div[starts-with(@id,'app-toolbar-')]/a[1]"));
    }

    public Button buttonProfileInMenu() {
        return new Button(driver, By.xpath("//div[starts-with(@id,'menu-')]/div[starts-with(@id,'menuitem-')][1]/a"));
    }

    public Button buttonMyPersonalPage() {
        return new Button(driver, By.xpath("//div[starts-with(@id,'menu-')]/div[starts-with(@id,'menuitem-')][2]/a"));
    }


}
