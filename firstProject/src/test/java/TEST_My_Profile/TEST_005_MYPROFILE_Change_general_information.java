package TEST_My_Profile;

import com.invest.core.BaseClass;
import com.invest.core.web.customwait.CustomWaits;
import com.invest.core.web.pages.LoginPage;
import com.invest.core.web.pages.MyProfilePage;
import com.invest.core.web.pages.PopUps.BasicInformationPopUp;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.UserPageMain;
import com.invest.core.web.tools.ToolRobotTypeKeys;
import com.invest.core.web.tools.CommonMethods;
import com.invest.core.web.tools.Constants;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TEST_005_MYPROFILE_Change_general_information extends BaseClass {

    private String name;
    private String email;
    private String country;
    private String phone;

    private String randomName;
    private String randomEmail;
    private String randomCountry;
    private String randomPhone;

    // Сохраняем свои текущие данные в своем профиле основная информация
    @Test(priority = 1)
    public void TEST_005_01_MYPROFILE_Change_general_information_save_data_SETUP() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();
        name = myProfilePage.LabelGeneralName().getText();
        email = myProfilePage.LabelGeneralEmail().getText();
        country = myProfilePage.LabelGeneralCountry().getText();
        phone = CommonMethods.getOnlyNumbersFromString(myProfilePage.LabelGeneralPhone().getText());
    }

    // Изменяем основные данные на рандомные сохраняем рандомные значения для следующего теста
    @Test(priority = 2, dependsOnMethods = "TEST_005_01_MYPROFILE_Change_general_information_save_data_SETUP")
    public void TEST_005_02_MYPROFILE_Change_general_information_changing_random_values() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();

        randomName = CommonMethods.getRandomString(10);
        randomEmail = CommonMethods.getRandomString(8) + "@4invest.net";

        randomCountry = "Zimbabwe";
        randomPhone = CommonMethods.getRandomNumber();

        BasicInformationPopUp basicInformationPopUp = myProfilePage.openBasicInfoChanging();
        basicInformationPopUp.nameField().clearInput().inputText(randomName);
        basicInformationPopUp.emailField().clearInput().inputText(randomEmail);

        basicInformationPopUp.countryComboBox().clickOn();
        basicInformationPopUp.countryComboBox().sendKeys(Keys.END);
        new CustomWaits().threadSleep(500);
        basicInformationPopUp.countryComboBox().sendKeys(Keys.ENTER); // choose last country Zimbabwe

        basicInformationPopUp.phoneField().clearInput();
        basicInformationPopUp.phoneField().click();
        new CustomWaits().threadSleep(1000);
        basicInformationPopUp.phoneField().sendKeys(Keys.PAGE_DOWN);
        new CustomWaits().threadSleep(1000);
        basicInformationPopUp.phoneField().sendKeys(Keys.HOME);
        new CustomWaits().threadSleep(1000);
//
        basicInformationPopUp.phoneField().inputText(randomPhone);

        basicInformationPopUp.confirmPasswordField().clearInput().inputText(Constants.PASSWORD);

        basicInformationPopUp.buttonApply().clickOn();

        new CustomWaits().threadSleep(500);
    }

    // Сверяем свои данные (рандомные) с теми что сейчас в данный момент в профиле основной информации
    @Test(priority = 3, dependsOnMethods = "TEST_005_01_MYPROFILE_Change_general_information_save_data_SETUP")
    public void TEST_005_03_MYPROFILE_Change_general_information_changing_random_values() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(randomEmail, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();

        String actualName = myProfilePage.LabelGeneralName().getText();
        String actualEmail = myProfilePage.LabelGeneralEmail().getText();
        String actualCountry = myProfilePage.LabelGeneralCountry().getText();
        String actualPhone = CommonMethods.getOnlyNumbersFromString(myProfilePage.LabelGeneralPhone().getText());

        Assert.assertEquals(actualName, randomName);
        Assert.assertEquals(actualEmail, randomEmail);
        Assert.assertEquals(actualCountry, randomCountry);
        Assert.assertEquals(actualPhone, randomPhone);
    }

    // Возращаем на свои основные данные (которые были изначально)
    @Test(priority = 4, dependsOnMethods = "TEST_005_01_MYPROFILE_Change_general_information_save_data_SETUP")
    public void TEST_005_04_MYPROFILE_Change_general_information_changing_back_TEARDOWN() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(randomEmail, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();

        BasicInformationPopUp basicInformationPopUp = myProfilePage.openBasicInfoChanging();
        basicInformationPopUp.nameField().clearInput().inputText(name);
        basicInformationPopUp.emailField().clearInput().inputText(email);

        basicInformationPopUp.countryComboBox().clickOn();
        basicInformationPopUp.countryComboBox().sendKeys(Keys.HOME);
        new CustomWaits().threadSleep(500);
        basicInformationPopUp.countryComboBox().sendKeys(Keys.ENTER); // choose first country Afganistan
        new CustomWaits().threadSleep(1000);
        basicInformationPopUp.phoneField().clearInput();
        basicInformationPopUp.phoneField().click();
        basicInformationPopUp.phoneField().sendKeys(Keys.PAGE_DOWN);
        new CustomWaits().threadSleep(1000);
        basicInformationPopUp.phoneField().sendKeys(Keys.HOME);
        new CustomWaits().threadSleep(1000);
        basicInformationPopUp.phoneField().inputText(phone);

        basicInformationPopUp.confirmPasswordField().clearInput().inputText(Constants.PASSWORD);

        basicInformationPopUp.buttonApply().clickOn();

        new CustomWaits().threadSleep(500);
    }

    // Сверяем свои данные основные с теми что были изначально и теми что сейчас
    @Test(priority = 5, dependsOnMethods = "TEST_005_01_MYPROFILE_Change_general_information_save_data_SETUP")
    public void TEST_005_05_MYPROFILE_Change_general_information_verify_values() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();

        String actualName = myProfilePage.LabelGeneralName().getText();
        String actualEmail = myProfilePage.LabelGeneralEmail().getText();
        String actualCountry = myProfilePage.LabelGeneralCountry().getText();
        String actualPhone = CommonMethods.getOnlyNumbersFromString(myProfilePage.LabelGeneralPhone().getText());

        Assert.assertEquals(actualName, name);
        Assert.assertEquals(actualEmail, email);
        Assert.assertEquals(actualCountry, country);
        Assert.assertEquals(actualPhone, phone);;
    }
}
