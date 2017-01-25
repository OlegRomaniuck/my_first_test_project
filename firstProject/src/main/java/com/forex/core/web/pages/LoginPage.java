package com.invest.core.web.pages;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebPage;
import com.invest.core.web.elements.Button;
import com.invest.core.web.elements.TextInput;
import com.invest.core.web.pages.myforecast.UserForecast;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Tester3 on 30.09.2015.
 */
public class LoginPage extends WebPage<LoginPage> {

    private static final String PAGE_URL="https:/";

    private static final String NAME = "";
    private static final String PASS = "";

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public LoginPage load() {
        driver.get(PAGE_URL);
        Util_Logger.showUrl(PAGE_URL);
        return this;
    }

    @Override
    public boolean isAvailable() {
        Util_Logger.showUrl(PAGE_URL);
        return getPasswordInput().isAvailable() && getPasswordInput().isAvailable() && button_login().isAvailable();
    }

    public UserPageMain getMainUserpage() {

        getUsernameInput().inputText(NAME);
        Util_Logger.Log.info("input data  name ");
        getPasswordInput().inputText(PASS);
        Util_Logger.Log.info("input data  passs");
        Util_Logger.Log.info(" try click on button and wait user main page");
        button_login().click();
        Util_Logger.Log.info("click on button and wait user main page");
        return new UserPageMain(driver).waitUntilAvailable();
    }

    public UserPageMain getMainUserpage(String login, String password) {
        Util_Logger.Log.info("input data  login:  "+ login);
        getUsernameInput().inputText(login);
        Util_Logger.Log.info("input data  password:  "+ password);
        getPasswordInput().inputText(password);
        Util_Logger.Log.info("try click on login button in form  ");
        button_login().click();
        Util_Logger.Log.info("click on button and wait user main page");
        return new UserPageMain(driver).waitUntilAvailable();


    }


    private TextInput getUsernameInput() {
        return new TextInput(driver, By.name("login"));
    }

    private TextInput getPasswordInput() {
        return new TextInput(driver, By.name("password"));
    }

    private Button button_login() {
        return new Button(driver, By.xpath("//button[@class='button green buttonLogIn']"));
    }

    public UserForecast getForecastPage(String login, String password) {
        Util_Logger.Log.info("input data  login:  "+ login);
        getUsernameInput().inputText(login);
        Util_Logger.Log.info("input data  password:  "+ password);
        getPasswordInput().inputText(password);
        Util_Logger.Log.info("try click on login button in form  ");
        button_login().click();
        Util_Logger.Log.info("click on button and wait user main page");
        return new UserForecast(driver).waitUntilAvailable();

    }
}
