package com.invest.core.web.pages.registration;

import com.invest.core.util.Util_Logger;
import com.invest.core.web.WebPage;
import com.invest.core.web.customwait.CustomWaits;
import com.invest.core.web.elements.*;
import com.invest.core.web.pages.UserPageMain;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * Created by Tester3 on 07.03.2016.
 * <p/>
 * заходим на страницу заполняем форму, вызываем окно активации подписки , заполняем реальными данными, активируем
 * акк==
 * <p/>
 * пассворд ===
 */
public class RegistrationPage extends WebPage<RegistrationPage> {


    private static final String REGISTRATION_URL = "https:   en/register.html";

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public RegistrationPage load() {
        driver.get(REGISTRATION_URL);
        Util_Logger.showUrl(REGISTRATION_URL);
        return this;
    }

    @Override
    public boolean isAvailable() {
        Util_Logger.showUrl(REGISTRATION_URL);
        return nameField().isAvailable() && emailAdressField().isAvailable() && phoneField().isAvailable() && loginField().isAvailable()
                && passField().isAvailable() && repeatPassField().isAvailable() && buttonNextStep().isAvailable();
    }

    public UserPageMain clickButtonSignUP() {
        buttonSignUP().clickOn();
        return new UserPageMain(driver).waitUntilAvailable();
    }

    public UserPageMain successActivateMySubscription() {
        String parentWindowHandle = driver.getWindowHandle();
        buttonActivateMySubscription().clickOn();
        Set<String> allWindowHandles = driver.getWindowHandles();
        String lastWindowHandle = "";
        for (String handle : allWindowHandles) {
            Util_Logger.Log.info("Switching to window - > " + handle);
            Util_Logger.Log.info("Navigating to login page");
            lastWindowHandle = handle;
        }

        //Switch to the parent window
        driver.switchTo().window(lastWindowHandle);
        try {
            clickOnLogInPayPal();
        } catch (NoSuchWindowException except) {
            //смоделировать ситуацию когда окно не закрылось

        }
        driver.switchTo().window(parentWindowHandle);
        return clickButtonSignUP();
    }

    public String getPriceFromShowingPaySystemAfterClickSignUp() {
        String parentWindowHandle = driver.getWindowHandle();
        buttonSignUP().clickOn();
        Util_Logger.Log.info("Should opens window payment: intercasa");
        Set<String> allWindowHandles = driver.getWindowHandles();
        String lastWindowHandle = "";
        for (String handle : allWindowHandles) {
            lastWindowHandle = handle;
        }

        //Switch to the parent window
        driver.switchTo().window(lastWindowHandle);
        String price = "";
        try {
            Util_Logger.Log.info("Trying find price in intercassa window");
            new CustomWaits().customFindElement(driver, By.xpath("//span[@ng-bind='paymentInfo.amount']"), 5000);
            price = driver.findElement(By.xpath("//span[@ng-bind='paymentInfo.amount']")).getText();
            new CustomWaits().threadSleep(500);
        } finally {
            driver.close();
            new CustomWaits().threadSleep(500);
            driver.switchTo().window(parentWindowHandle);
            Util_Logger.Log.info("Switch to parent window 4invest");
        }
        return price;
    }

    public void clickOnLogInPayPal() throws NoSuchWindowException {
        getEmailPayPalAcc().clearInput();
        getEmailPayPalAcc().inputText("");
        getPassPayPalAcc().clearInput();
        getPassPayPalAcc().inputText("");
        buttonLogInPayPal().clickOn();


        try {
            new CustomWaits().waitUntilWindowsClosefinal(driver, 20);
        } catch (TimeoutException except) {
            except.printStackTrace();
            throw new TimeoutException("WINDOW DON'T CLOSE");
        }
    }

    // --------------------------------------------------------------- ELEMENTS -------------------------------------------

    // ************************ Fields

    public TextInput nameField() {
        Util_Logger.Log.info("Trying to find Field name");
        return new TextInput(driver, By.name("name"));
    }

    public TextInput emailAdressField() {
        Util_Logger.Log.info("Trying to find Field email");
        return new TextInput(driver, By.name("email"));
    }

    public TextInput phoneField() {
        Util_Logger.Log.info("Trying to find Field phone");
        return new TextInput(driver, By.name("phone"));
    }

    public TextInput loginField() {
        Util_Logger.Log.info("Trying to find Field login");
        return new TextInput(driver, By.name("login"));
    }

    public TextInput passField() {
        Util_Logger.Log.info("Trying to find Field password");
        return new TextInput(driver, By.name("password"));
    }

    public TextInput repeatPassField() {
        Util_Logger.Log.info("Trying to find Field repeat password");
        return new TextInput(driver, By.name("confirm_password"));
    }

    private TextInput getEmailPayPalAcc() {
        new CustomWaits().customFindElement(driver, By.name("email"), 10);
        Util_Logger.Log.info("Trying to find Field Email PayPal Account");
        return new TextInput(driver, By.name("email"));
    }

    private TextInput getPassPayPalAcc() {
        WebElement elemnt = new CustomWaits().customFindElement(driver, By.name("password"), 10);
        Util_Logger.Log.info("Trying to find Field Pass PayPal Account");
        return new TextInput(driver, By.name("password"));
    }

    // ************************ Labels

    public Lable LabelNameHelpBlock() {
        Util_Logger.Log.info("Trying to find Label error name Help Block");
        return new Lable(driver, By.id("name-error"));
    }

    public Lable LabelEmailHelpBlock() {
        Util_Logger.Log.info("Trying to find Label error email Help Block");
        return new Lable(driver, By.id("email-error"));
    }

    public Lable LabelPhoneHelpBlock() {
        Util_Logger.Log.info("Trying to find Label error phone Help Block");
        return new Lable(driver, By.id("phone-error"));
    }

    public Lable LabelLoginHelpBlock() {
        Util_Logger.Log.info("Trying to find Label error login Help Block");
        return new Lable(driver, By.id("login-error"));
    }

    public Lable LabelPasswordHelpBlock() {
        Util_Logger.Log.info("Trying to find Label error password Help Block");
        return new Lable(driver, By.id("password-error"));
    }

    public Lable LabelPasswordRepeatHelpBlock() {
        Util_Logger.Log.info("Trying to find Label error password repeat Help Block");
        return new Lable(driver, By.id("confirm_password-error"));
    }

    public Lable LabelLicenseHelpBlock() {
        Util_Logger.Log.info("Trying to find Label License Help Block");
        return new Lable(driver, By.xpath("//label/span[@class='help-block']"));
    }

    public Lable LabelPayPalHelpBlock() {
        Util_Logger.Log.info("Trying to find Label error PayPal Help Block");
        return new Lable(driver, By.id("paypal-error"));
    }

    public Lable LabelAddMyPayPalHelpBlock() {
        Util_Logger.Log.info("Trying to find Label Add My PayPal Help Block");
        return new Lable(driver, By.id("spawn-info"));
    }

    // ************************ Buttons

    public Button buttonActivateMySubscription() {
        Util_Logger.Log.info("Trying to find Button Activate My Subscription");
        return new Button(driver, By.id("paypal"));
    }

    public Button buttonNextStep() {
        Util_Logger.Log.info("Trying to find Button Next Step");
        return new Button(driver, By.xpath("//a[@class='button green buttonNext']"));
    }

    public Button buttonTrial() {
        Util_Logger.Log.info("Trying to find Button Trial");
        return new Button(driver, By.xpath("//li[@class='typeGreen']/a/div"));
    }

    public Button buttonGold() {
        Util_Logger.Log.info("Trying to find Button Gold");
        return new Button(driver, By.xpath("//li[@class='typeGold']/a/div"));
    }

    public Button buttonPlatinum() {
        Util_Logger.Log.info("Trying to find Button Platinum");
        return new Button(driver, By.xpath("//li[@class='typePurple']/a/div"));
    }

    public Button buttonLicense() {
        Util_Logger.Log.info("Trying to find Button Open License");
        return new Button(driver, By.xpath("//span[@class='register-license-agreement-link']"));
    }

    public Button buttonCloseLicense() {
        Util_Logger.Log.info("Trying to find Button Close License");
        return new Button(driver, By.xpath("//div[@class='buttonClose']"));
    }

    public Button buttonDropDown() {
        Util_Logger.Log.info("Trying to find Button in DropDown");
        return new Button(driver, By.xpath("//div[@class='arrow']"));
    }

    public Button buttonSignUP() {
        Util_Logger.Log.info("Trying to find Button SignUP");
        return new Button(driver, By.xpath("//a[@class='button green buttonRegistration']"));
    }

    private Button buttonLogInPayPal() {
        new CustomWaits().waitUntilAvalible(driver, By.name("_eventId_submit"), 10);
        Util_Logger.Log.info("Trying to find Button Log In PayPal");
        return new Button(driver, By.name("_eventId_submit"));
    }

    // ************************ Checkboxes

    public CheckBox checkBoxReceiveEmail() {
        Util_Logger.Log.info("Trying to find CheckBox Receive Email");
        return new CheckBox(driver, By.name("email_send"));
    }

    public CheckBox checkBoxShowInvestorTable() {
        Util_Logger.Log.info("Trying to find CheckBox Show Investor Table");
        return new CheckBox(driver, By.name("enabled_rating"));
    }

    public CheckBox checkBoxAcceptLicense() {
        Util_Logger.Log.info("Trying to find CheckBox Accept License");
        return new CheckBox(driver, By.name("accept"));
    }

    // ************************* Combobox -> list elements

    public List listBoxInDropDown() {
        return new List(driver, By.xpath("//div[@class='blockSelect']/ul"));
    }
}
