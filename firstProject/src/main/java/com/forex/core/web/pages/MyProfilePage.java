package com.invest.core.web.pages;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebPage;
import com.invest.core.web.customwait.CustomWaits;
import com.invest.core.web.elements.*;
import com.invest.core.web.pages.PopUps.BasicInformationPopUp;
import com.invest.core.web.pages.PopUps.ContactInformationPopUp;
import com.invest.core.web.tools.ToolRobotTypeKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;


public class MyProfilePage extends WebPage<MyProfilePage> {

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    private static final String PAGE_URL = "/en/profile.html";

    @Override
    public MyProfilePage load() {
        driver.get(PAGE_URL);
        Util_Logger.showUrl(PAGE_URL);
        return this;
    }

    @Override
    public boolean isAvailable() {
        Util_Logger.showUrl(PAGE_URL);
        return statusField().isAvailable() && buttonGeneralInfoTab().isAvailable() && buttonContactsTab().isAvailable()
                && buttonChangeStatus().isAvailable() && buttonChoosePhoto().isAvailable()
                && buttonChangeBasicInfo().isAvailable();
    }

    public void changeStatus(String newStatus){
        buttonChangeStatus().clickOn();
        statusField().clearInput();
        statusField().inputText(newStatus);
        buttonGeneralInfoTab().clickOn();
    }

    public BasicInformationPopUp openBasicInfoChanging(){
        buttonChangeBasicInfo().clickOn();
        return new BasicInformationPopUp(driver).waitUntilAvailable();
    }

    public ContactInformationPopUp openContactInformationPopUpChanging(){
        buttonChangeContactInfo().clickOn();
        return new ContactInformationPopUp(driver).waitUntilAvailable();
    }

    // Just open window, enter path and upload file, this method don't press Button 'Upload' image
    public void uploadAvatar(String pathToFileInTheProject){
        buttonChoosePhoto().clickOn();
        new CustomWaits().threadSleep(10000);
        String absolutePathToFile = new File(pathToFileInTheProject).getAbsoluteFile().toString();
        ToolRobotTypeKeys.uploadFileByPath(absolutePathToFile);
        Util_Logger.Log.info("Image was uploaded in window upload file!");
        new CustomWaits().threadSleep(2000);
    }

    // ************************ Fields *****************

    public TextInput statusField() {
        Util_Logger.Log.info("Trying to find Field status");
        return new TextInput(driver, By.xpath("//div[starts-with(@id,'user-profile-head-')]//div[starts-with(@id,'textfield-')]/input"));
    }

    // ********************* Buttons elements *****************

    public Button buttonGeneralInfoTab() {
        Util_Logger.Log.info("Trying to find Button general info tab");
        return new Button(driver, By.xpath("//div[starts-with(@id,'user-profile-mainInfo-panel-')]/div[starts-with(@id,'tabbar-')]//a[starts-with(@id,'tab-')][1]"));
    }

    public Button buttonContactsTab() {
        Util_Logger.Log.info("Trying to find Button contacts tab");
        return new Button(driver, By.xpath("//div[starts-with(@id,'user-profile-mainInfo-panel-')]/div[starts-with(@id,'tabbar-')]//a[starts-with(@id,'tab-')][2]"));
    }

    public Button buttonChangeStatus() {
        Util_Logger.Log.info("Trying to find Button change status");
        return new Button(driver, By.xpath("//div[starts-with(@id,'user-profile-head-')]//a/span/span/span[2]"));
    }

    public Button buttonChoosePhoto() {
        Util_Logger.Log.info("Trying to find Button choose photo");
        return new Button(driver, By.xpath("//div[starts-with(@id,'form-')]/div[starts-with(@id,'fileuploadfield-')]"));
    }

    public Button buttonChangeBasicInfo() {
        Util_Logger.Log.info("Trying to find Button change basic info");
        return new Button(driver, By.xpath("//div[starts-with(@id, 'user-profile-mainInfo-generalInfo-')]//div[@class='type_table table_visual']//div[@class='type_table_row'][1]//span[@class='icon_edit']"));
    }

    public Button buttonChangeContactInfo() {
        Util_Logger.Log.info("Trying to find Button change contact info");
        return new Button(driver, By.xpath("//div[starts-with(@id, 'user-profile-mainInfo-contacts-')]//div[@class='type_table table_visual']//div[@class='type_table_row'][1]//span[@class='icon_edit']"));
    }

    public Switch switchElementButtonEmail() {
        Util_Logger.Log.info("Trying to find switch element email visible");
        return new Switch(driver, "#checkbox-2595");
    }

    public Switch switchElementButtonPhone() {
        Util_Logger.Log.info("Trying to find switch element phone visible");
        return new Switch(driver, "#info-prof-email .chBox");

    }

    public Switch switchViewInBlogs() {
        Util_Logger.Log.info("Trying to find switch element view in blogs");
        return new Switch(driver, "#checkbox-2555");

    }

    public Button buttonPublicityEmail() {
        Util_Logger.Log.info("Trying to find Button (switch) Publicity Email");
        return new Button(driver, By.cssSelector("#info-prof-email span.chBox"));
    }

    public Button buttonPublicityPhone() {
        Util_Logger.Log.info("Trying to find Button (switch) Publicity Phone");
        return new Button(driver, By.cssSelector("#info-prof-phone span.chBox"));
    }

    public Button buttonNotificationToEmail() {
        Util_Logger.Log.info("Trying to find Button (switch) Notification Email");
        return new Button(driver, By.xpath("//div[starts-with(@id,'user-profile-bottomPanel-profile-')]/div[1]/div[2]//div[starts-with(@id,'checkbox-')]//span[@class='chBox']"));
    }

    public Button buttonPublicityInvestTable() {
        Util_Logger.Log.info("Trying to find Button (switch) Publicity Invest Table");
        return new Button(driver, By.xpath("//div[starts-with(@id,'user-profile-bottomPanel-profile-')]/div[3]/div[2]//div[starts-with(@id,'fieldcontainer-')]/div[starts-with(@id,'checkbox-')][1]//span[@class='chBox']"));
    }

    public Button buttonViewInBlogsAndChat() {
        Util_Logger.Log.info("Trying to find Button (switch) views in blogs and chat");
        return new Button(driver, By.xpath("//div[starts-with(@id,'user-profile-bottomPanel-profile-')]/div[3]/div[2]//div[starts-with(@id,'fieldcontainer-')]/div[starts-with(@id,'checkbox-')][2]//span[@class='chBox']"));
    }

    public Button buttonUpload() {
        Util_Logger.Log.info("Trying to find Button Upload file");
        return new Button(driver, By.xpath("//div[starts-with(@id,'user-profile-profileInfo-')]/div[2]//a"));
    }

    // ************************ Labels *****************

    public Lable LabelGeneralName() {
        Util_Logger.Log.info("Trying to find Label general Name");
        return new Lable(driver, By.xpath("//span[@class='label_value label_name_value']"));
    }

    public Lable LabelGeneralEmail() {
        Util_Logger.Log.info("Trying to find Label general Email");
        return new Lable(driver, By.xpath("//span[@class='label_value label_email_value']"));
    }

    public Lable LabelGeneralCountry() {
        Util_Logger.Log.info("Trying to find Label general country");
        return new Lable(driver, By.xpath("//span[@class='label_value label_country_value']"));
    }

    public Lable LabelGeneralPhone() {
        Util_Logger.Log.info("Trying to find Label general phone");
        return new Lable(driver, By.xpath("//span[@class='label_value label_phone_value']"));
    }

    public Lable LabelContactFacebook() {
        Util_Logger.Log.info("Trying to find Label contact facebook");
        return new Lable(driver, By.cssSelector("span.field_facebook > span.label__value"));
    }

    public Lable LabelContactSkype() {
        Util_Logger.Log.info("Trying to find Label contact Skype");
        return new Lable(driver, By.cssSelector("span.field_skype > span.label__value"));
    }

    public Lable LabelContactTwitter() {
        Util_Logger.Log.info("Trying to find Label contact Twitter");
        return new Lable(driver, By.cssSelector("span.field_twitter > span.label__value"));
    }

    public Lable LabelContactLinkedIn() {
        Util_Logger.Log.info("Trying to find Label contact LinkedIn");
        return new Lable(driver, By.cssSelector("span.field_Linkedin > span.label__value"));
    }

    public Lable LabelContactViber() {
        Util_Logger.Log.info("Trying to find Label contact Viber");
        return new Lable(driver, By.cssSelector("span.field_viber > span.label__value"));
    }

    public Lable LabelContactUrl() {
        Util_Logger.Log.info("Trying to find Label contact Viber");
        return new Lable(driver, By.cssSelector("span.field_url > span.label__value"));
    }

    public Lable LabelMyBalance() {
        Util_Logger.Log.info("Trying to find Label my balance");
        return new Lable(driver, By.xpath("//div[starts-with(@id,'user-profile-mainInfo-statisticInfo-')]/div[1]//span[@class='data']"));
    }

    public Lable LabelMyStatus() {
        Util_Logger.Log.info("Trying to find Label my status");
        return new Lable(driver, By.xpath("//div[starts-with(@id,'user-profile-head-')]//div[starts-with(@id,'textfield-')]/input"));
    }

    public WebElement uploadFile(){
        return driver.findElement(By.xpath("//input[@type='file']"));
    }





}
