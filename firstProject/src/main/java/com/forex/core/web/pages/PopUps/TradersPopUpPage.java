package com.invest.core.web.pages.PopUps;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebPage;
import com.invest.core.web.elements.Button;
import com.invest.core.web.elements.Lable;
import com.invest.core.web.elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class TradersPopUpPage extends WebPage<TradersPopUpPage> {

    public TradersPopUpPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public TradersPopUpPage load() {
        return this;
    }

    @Override
    public boolean isAvailable() {
        Util_Logger.showUrl("Open PopUp Trader Detail Information");
        return LabelActualInvestments().isAvailable() && button_information_tab().isAvailable() && button_Invest_tab().isAvailable()
                && button_withdraw_tab().isAvailable();
    }


    public void click_on_link() {
        WebElement link_on_enemysite = driver.findElement(By.xpath("//a[@class='value_billText type_link']"));
        link_on_enemysite.click();
    }

    public List<String> agregate_data_from_popUp_page() {
        List<String> various_data = new ArrayList<String>();
        //find element name traider
        WebElement el_name_traider = driver.findElement(By.xpath("//div[starts-with(@id,'trader-invest-')]//span[@class='title']"));
        String name_traider = el_name_traider.getText();
        various_data.add(name_traider);

        //find schet numb
        WebElement el_schet_numb = driver.findElement(By.xpath("//a[@class='value_billText type_link']"));
        String schet_numb = el_schet_numb.getText();
        various_data.add(schet_numb);

        //fing indicator forinvest
        WebElement el_indicator_4invest = driver.findElement(By.xpath("//div[@class='blockItem blockBordered']/div/div[@class='lineLable lineLableTiped'][1]/span[@class='labelValue']"));
        String inidactor_4invest = el_indicator_4invest.getText();
        various_data.add(inidactor_4invest);

        //find years old
        WebElement el_years = driver.findElement(By.xpath("//div[@class='panelBodyFlex']/div[1]/div[1]//span[@class='valueMain cssBgDark']"));
        String years = el_years.getText();
        various_data.add(years);

        //fing torgovui period
        WebElement el_torgov_period = driver.findElement(By.xpath("//div[@class='panelBodyFlex']/div[1]/div[2]//span[@class='valueMain cssBgDark']"));
        String torgov_period = el_torgov_period.getText();
        various_data.add(torgov_period);

        //find dolya dohoda dlya invest
        WebElement el_dolya_dohoda = driver.findElement(By.xpath("//div[@class='panelBodyFlex']/div[1]/div[3]//span[@class='valueMain cssBgGreen']"));
        String dolya_dohoda = el_dolya_dohoda.getText();
        various_data.add(dolya_dohoda);

        //find minimum summa
        WebElement el_minum_sum = driver.findElement(By.xpath("//div[@class='panelBodyFlex']/div[2]/div[1]//span[@class='valueMain cssBgSky']"));
        String minum_sum = el_minum_sum.getText();
        various_data.add(minum_sum);

        //find periodichnost obnovlen
        WebElement el_period_obnov = driver.findElement(By.xpath("//div[@class='panelBodyFlex']/div[2]/div[2]//span[@class='valueMain cssBgDark']"));
        String period_obnov = el_period_obnov.getText();
        various_data.add(period_obnov);

        //find last obnov
        WebElement el_last_obnov = driver.findElement(By.xpath("//div[@class='panelBodyFlex']/div[2]/div[3]//span[@class='valueMain cssBgDark']"));
        String last_obnov = el_last_obnov.getText();
        various_data.add(last_obnov);

        //find best week
        WebElement el_best_week = driver.findElement(By.xpath("//div[@class='item type_table_cell'][1]/span[@class='data']"));
        String best_week = el_best_week.getText();
        various_data.add(best_week);

        //find worth week
        WebElement el_worth_week = driver.findElement(By.xpath("//div[@class='item type_table_cell'][2]/span[@class='data']"));
        String worth_week = el_worth_week.getText();
        various_data.add(worth_week);

        //find srednya
        WebElement el_srednya = driver.findElement(By.xpath("//div[@class='item type_table_cell'][3]/span[@class='data']"));
        String srdnya = el_srednya.getText();
        various_data.add(srdnya);

        //find mediana
        WebElement el_mediana = driver.findElement(By.xpath("//div[@class='item type_table_cell'][4]/span[@class='data']"));
        String mediana = el_mediana.getText();
        various_data.add(mediana);

        //find dohod
        WebElement el_dohod = driver.findElement(By.xpath("//div[@class='item type_table_cell'][5]/span[@class='data']"));
        String dohod = el_dohod.getText();
        various_data.add(dohod);


        //close page
        WebElement button_close = driver.findElement(By.xpath("//div[starts-with(@id,'trader-invest-')]/div[2]/div[@class='x-tool-img x-tool-close']"));
        // button_close.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(button_close).click().perform();


        return various_data;



    }

    public int getNumberRowWithdrawBySumOfDeposit(int sumOfDeposit) {
        Util_Logger.Log.info("Trying to find number of row with sum of deposit - " + sumOfDeposit);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@id,'trader-invest-get-')]//div/table/tbody/tr/td[3]")));
        List<WebElement> list = driver.findElements(By.xpath("//div[starts-with(@id,'trader-invest-get-')]//div/table/tbody/tr/td[3]"));
        for (int numberOfRow = 0; numberOfRow < list.size(); numberOfRow++) {
            if (list.get(numberOfRow).getText().equals(String.valueOf(sumOfDeposit))) {
                Util_Logger.Log.info("Found number of row - " + (numberOfRow + 1));
                return numberOfRow + 1;
            }
        }
        Util_Logger.Log.info("Not Found number of row!");
        throw new AssertionError("Not find withdraw row with sum = " + sumOfDeposit);
    }

    // ************************ Labels *****************

    public Lable LabelActualInvestments() {
        Util_Logger.Log.info("Trying to find Label Actual Investments");
        return new Lable(driver, By.xpath("//div/div[2]//div[@class='valueContainer']/span[@class='valueMain']"));
    }

    public Lable LabelSuccessAfterInvest() {
        Util_Logger.Log.info("Trying to find Label 'Success' After Invest");
        return new Lable(driver, By.xpath("//div[starts-with(@id,'trader-invest-set-')]//div[contains(@class, 'eventMessage') and contains(@class, 'info')]"));
    }

    public Lable LabelSuccessAfterWithdraw() {
        Util_Logger.Log.info("Trying to find Label 'Success' After Withdraw");
        return new Lable(driver, By.xpath("//div[starts-with(@id,'trader-invest-get-')]//div[contains(@class, 'eventMessage') and contains(@class, 'info')]"));
    }

    // ************************ Fields *****************

    public TextInput amountOfInvestment() {
        Util_Logger.Log.info("Trying to find Amount of investment");
        return new TextInput(driver, By.xpath("//span[text()='Amount of investments:']/../..//input"));
    }

    // ************************ Checkboxes

    public Button checkbox_in_table_of_offers(int numberOfOffer) {
        Util_Logger.Log.info("Trying to find CheckBox in table of offers");
        return new Button(driver, By.xpath("//div/table[" + numberOfOffer + "]//div[@class='x-itemTableCheckerCheckbox']"));
    }

    // ********************* Buttons elements *****************

    public Button button_information_tab() {
        Util_Logger.Log.info("Trying to find button Information tab");
        return new Button(driver, By.xpath("//span[starts-with(@id,'tab-')]/span[text()='Information']"));
    }

    public Button button_Invest_tab() {
        Util_Logger.Log.info("Trying to find button Invest tab");
        return new Button(driver, By.xpath("//span[starts-with(@id,'tab-')]/span[text()='Invest']"));
    }

    public Button button_withdraw_tab() {
        Util_Logger.Log.info("Trying to find button Withdraw tab");
        return new Button(driver, By.xpath("//span[starts-with(@id,'tab-')]/span[text()='Withdraw']"));
    }

    public Button button_radio_in_table_of_offers(int offer) {
        Util_Logger.Log.info("Trying to find radio button in table of offers");
        return new Button(driver, By.xpath("//div/table[" + offer + "]//div[@class='x-itemTableCheckerRadio']"));
    }

    public Button button_Invest() {
        Util_Logger.Log.info("Trying to find button Invest!");
        return new Button(driver, By.xpath("//span[starts-with(@id,'button-')]/span[text()='Invest']"));
    }

    public Button button_Withdraw() {
        Util_Logger.Log.info("Trying to find button Withdraw!");
        return new Button(driver, By.xpath("//span[starts-with(@id,'button-')]/span[text()='Withdraw']"));
    }

    // Not working 25.03.16
    public Button button_Close_popup() {
        Util_Logger.Log.info("Trying to find button Close popup");
        return new Button(driver, By.xpath("//div[starts-with(@id,'trader-invest-')]/div[2]/div[@class='x-tool-img x-tool-close']"));
    }

}


