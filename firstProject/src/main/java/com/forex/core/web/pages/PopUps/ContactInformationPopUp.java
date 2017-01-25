package com.invest.core.web.pages.PopUps;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebPage;
import com.invest.core.web.elements.Button;
import com.invest.core.web.elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ContactInformationPopUp extends WebPage<ContactInformationPopUp> {

    public ContactInformationPopUp(WebDriver driver) {
        super(driver);
    }

    @Override
    public ContactInformationPopUp load() {
        return this;
    }

    @Override
    public boolean isAvailable() {
        Util_Logger.showUrl("Open PopUp Contact Information");
        return facebookField().isAvailable() && skypeField().isAvailable() && twitterField().isAvailable()
                && linkedInField().isAvailable() && viberField().isAvailable()
                && websiteField().isAvailable() && buttonApply().isAvailable() && buttonClose().isAvailable();
    }

    // ************************ Fields *****************

    public TextInput facebookField() {
        Util_Logger.Log.info("Trying to find Field facebook");
        return new TextInput(driver, By.xpath("//div[starts-with(@id,'change-infoNew-')]//div[starts-with(@id,'form-')]/div[starts-with(@id,'textfield-')][1]//input"));
    }

    public TextInput skypeField() {
        Util_Logger.Log.info("Trying to find Field skype");
        return new TextInput(driver, By.xpath("//div[starts-with(@id,'change-infoNew-')]//div[starts-with(@id,'form-')]/div[starts-with(@id,'textfield-')][2]//input"));
    }

    public TextInput twitterField() {
        Util_Logger.Log.info("Trying to find Field twitter");
        return new TextInput(driver, By.xpath("//div[starts-with(@id,'change-infoNew-')]//div[starts-with(@id,'form-')]/div[starts-with(@id,'textfield-')][3]//input"));
    }

    public TextInput linkedInField() {
        Util_Logger.Log.info("Trying to find Field linkedIn");
        return new TextInput(driver, By.xpath("//div[starts-with(@id,'change-infoNew-')]//div[starts-with(@id,'form-')]/div[starts-with(@id,'textfield-')][4]//input"));
    }

    public TextInput viberField() {
        Util_Logger.Log.info("Trying to find Field viber");
        return new TextInput(driver, By.xpath("//div[starts-with(@id,'change-infoNew-')]//div[starts-with(@id,'form-')]/div[starts-with(@id,'textfield-')][5]//input"));
    }

    public TextInput websiteField() {
        Util_Logger.Log.info("Trying to find Field facebook");
        return new TextInput(driver, By.xpath("//div[starts-with(@id,'change-infoNew-')]//div[starts-with(@id,'form-')]/div[starts-with(@id,'textfield-')][6]//input"));
    }

    // **************************** Buttons *****************
    public Button buttonApply() {
        Util_Logger.Log.info("Trying to find button Apply changes");
        return new Button(driver, By.xpath("//div[starts-with(@id, 'change-infoNew-')]/a"));
    }

    public Button buttonClose() {
        Util_Logger.Log.info("Trying to find button Apply changes");
        return new Button(driver, By.xpath("//div[starts-with(@id,'change-infoNew-')]/div[starts-with(@id,'tool-')]"));
    }
}
