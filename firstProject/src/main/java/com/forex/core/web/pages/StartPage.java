package com.invest.core.web.pages;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebPage;
import com.invest.core.web.elements.Button;
import com.invest.core.web.pages.registration.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Tester3 on 30.09.2015.
 */
public class StartPage extends WebPage<StartPage> {

    private static final String Page_Url = "https://";

    public StartPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public StartPage load() {
        driver.get(Page_Url);
        Util_Logger.showUrl(Page_Url);
        return this.waitUntilAvailable();

    }

    @Override
    public boolean isAvailable() {
        Util_Logger.showUrl(Page_Url);
        Util_Logger.showUrl("Check that all elements present on the page!");
        return getLoginButton().isAvailable() && getRegistrationButton().isAvailable();
    }

    public LoginPage clickOnLogin() {
        String parentWindowHandle = driver.getWindowHandle();

        Util_Logger.Log.info(" try click on Login Button");
        getLoginButton().click();
        //log
        Util_Logger.Log.info("click on Login Button");


        Util_Logger.info("try to go Login page ");
        return new LoginPage(driver).waitUntilAvailable();
    }


    private Button getLoginButton() {
        Util_Logger.info("Try to find Login Button");
        return new Button(driver, By.xpath("//a[@href='https:/']"));
    }


    public RegistrationPage clickOnRegistrationButton() {
        Util_Logger.info(" try click on Registration button");
        getRegistrationButton().click();
        Util_Logger.info("Click on Registration button");
        return new RegistrationPage(driver).waitUntilAvailable();

    }

    public void changeLangRu() {
        if(buttonLanguage().getText().equalsIgnoreCase("ru")){
            buttonLanguage().clickOn();
        }
    }

    public void changeLangEn() {
        if(buttonLanguage().getText().equalsIgnoreCase("en")){
            buttonLanguage().clickOn();
        }
    }

    public Button buttonLanguage(){
        Util_Logger.info("Try to find Lang Ru Button");
        return new Button(driver, By.xpath("//ul[@class='menuSupport']/li[4]/a/span"));
    }

    private Button getRegistrationButton() {
        Util_Logger.info("Try to find Registration Button");
        return new Button(driver, By.xpath("//ul[@class='menuSupport']/li[3]//span"));
    }

}