package com.invest.core.web.pages;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebPage;
import com.invest.core.web.elements.Lable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyPersonalPage extends WebPage<MyPersonalPage> {

    public MyPersonalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MyPersonalPage load() {
        return this;
    }

    @Override
    public boolean isAvailable() {
        return LabelGeneralName().isAvailable() && LabelGeneralEmail().isAvailable() && LabelGeneralCountry().isAvailable()
                && LabelGeneralPhone().isAvailable() || LabelPageDisabled().isAvailable();
    }

    // ********************* Buttons elements *****************

    // ************************ Labels *****************

    public Lable LabelGeneralName() {
        Util_Logger.Log.info("Trying to find Label general Name");
        return new Lable(driver, By.xpath("//div[@class='type_table table_visual']/div[1]/div[2]/span"));
    }

    public Lable LabelGeneralEmail() {
        Util_Logger.Log.info("Trying to find Label general Email");
        return new Lable(driver, By.xpath("//div[@class='type_table table_visual']/div[2]/div[2]/span"));
    }

    public Lable LabelGeneralCountry() {
        Util_Logger.Log.info("Trying to find Label general country");
        return new Lable(driver, By.xpath("//div[@class='type_table table_visual']/div[3]/div[2]/span"));
    }

    public Lable LabelGeneralPhone() {
        Util_Logger.Log.info("Trying to find Label general phone");
        return new Lable(driver, By.xpath("//div[@class='type_table table_visual']/div[4]/div[2]/span"));
    }

    public Lable LabelPageDisabled() {
        Util_Logger.Log.info("Trying to find Label page disabled");
        return new Lable(driver, By.xpath("//div[starts-with(@id, 'user-page-panel-')]/div[starts-with(@id, 'panel-')]"));
    }
}
