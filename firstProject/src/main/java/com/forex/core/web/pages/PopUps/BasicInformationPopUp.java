package com.invest.core.web.pages.PopUps;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebPage;
import com.invest.core.web.elements.Button;
import com.invest.core.web.elements.Lable;
import com.invest.core.web.elements.List;
import com.invest.core.web.elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BasicInformationPopUp extends WebPage<BasicInformationPopUp> {

    public BasicInformationPopUp(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasicInformationPopUp load() {
        return this;
    }

    @Override
    public boolean isAvailable() {
        Util_Logger.showUrl("Open PopUp Basic Information");
        return nameField().isAvailable() && lastNameField().isAvailable() && emailField().isAvailable()
                && confirmPasswordField().isAvailable() && phoneField().isAvailable()
                && countryComboBox().isAvailable() && buttonApply().isAvailable() && buttonClose().isAvailable();
    }

    // ************************ Fields *****************

    public TextInput nameField() {
        Util_Logger.Log.info("Trying to find Field name");
        return new TextInput(driver, By.xpath("//div[starts-with(@id,'change-infoNew-')]//div[starts-with(@id,'form-')]/div[starts-with(@id,'textfield-')][1]//input"));
    }

    public TextInput lastNameField() {
        Util_Logger.Log.info("Trying to find Field last name");
        return new TextInput(driver, By.xpath("//div[starts-with(@id,'change-infoNew-')]//div[starts-with(@id,'form-')]/div[starts-with(@id,'textfield-')][2]//input"));
    }

    public TextInput emailField() {
        Util_Logger.Log.info("Trying to find Field email");
        return new TextInput(driver, By.xpath("//div[starts-with(@id,'change-infoNew-')]//div[starts-with(@id,'form-')]/div[starts-with(@id,'textfield-')][3]//input"));
    }

    public TextInput confirmPasswordField() {
        Util_Logger.Log.info("Trying to find Field confirm password");
        return new TextInput(driver, By.xpath("//div[starts-with(@id,'change-infoNew-')]//div[starts-with(@id,'form-')]/div[starts-with(@id,'textfield-')][4]//input"));
    }

    public TextInput phoneField() {
        Util_Logger.Log.info("Trying to find Field phone");
        return new TextInput(driver, By.xpath("//div[starts-with(@id,'change-infoNew-')]//div[starts-with(@id,'form-')]/div[starts-with(@id,'phonefield-')]//input"));
    }

    // **************************** List ****************

    public List listFromCountry() {
        Util_Logger.Log.info("Trying to find List with countries");
        return new List(driver, By.xpath("//ul[starts-with(@id,'boundlist-')]"));
    }

    // **************************** Labels ****************
    public Lable labelErrorMessagePassword() {
        Util_Logger.Log.info("Trying to find Label message wrong password");
        return new Lable(driver, By.xpath("//div[starts-with(@id,'textfield-')]//li"));
    }

    public Lable labelWrongEmailChange() {
        Util_Logger.Log.info("Trying to find Label message wrong email");
        return new Lable(driver, By.xpath("//div[starts-with(@id,'textfield-')]/ul[@class='x-list-plain']/li"));
    }

    // **************************** Buttons *****************
    public Button countryComboBox() {
        Util_Logger.Log.info("Trying to find ComboBox country button");
        return new Button(driver, By.xpath("//div[starts-with(@id,'change-infoNew-')]//div[starts-with(@id,'form-')]/div[starts-with(@id,'combobox-')]//input"));
    }

    public Button buttonApply() {
        Util_Logger.Log.info("Trying to find button Apply");
        return new Button(driver, By.xpath("//div[starts-with(@id, 'change-infoNew-')]/a"));
    }

    public Button buttonClose() {
        Util_Logger.Log.info("Trying to find button Apply changes");
        return new Button(driver, By.xpath("//div[starts-with(@id,'change-infoNew-')]/div[starts-with(@id,'tool-')]"));
    }
}
