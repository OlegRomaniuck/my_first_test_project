package TEST_My_Profile;

import com.invest.core.BaseClass;
import com.invest.core.web.customwait.CustomWaits;
import com.invest.core.web.pages.LoginPage;
import com.invest.core.web.pages.MyProfilePage;
import com.invest.core.web.pages.PopUps.BasicInformationPopUp;
import com.invest.core.web.pages.PopUps.ContactInformationPopUp;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.UserPageMain;
import com.invest.core.web.tools.CommonMethods;
import com.invest.core.web.tools.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TEST_008_MYPROFILE_Change_contact_information extends BaseClass {

    private String facebook;
    private String skype;
    private String twitter;
    private String Linkedin;
    private String viber;
    private String url;

    private String randomFacebook;
    private String randomSkype;
    private String randomTwitter;
    private String randomLinkedin;
    private String randomViber;
    private String randomUrl;


    @Test(priority = 1)
    public void TEST_008_01_MYPROFILE_Change_contact_information_save_data_SETUP() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();
        myProfilePage.buttonContactsTab().clickOn();

        facebook = myProfilePage.LabelContactFacebook().getText();
        skype = myProfilePage.LabelContactSkype().getText();
        twitter = myProfilePage.LabelContactTwitter().getText();
        Linkedin = myProfilePage.LabelContactLinkedIn().getText();
        viber = myProfilePage.LabelContactViber().getText();
        url = myProfilePage.LabelContactUrl().getText();
    }

    @Test(priority = 2)
    public void TEST_008_02_MYPROFILE_Change_contact_information_SETUP_changing_random_values() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();
        myProfilePage.buttonContactsTab().clickOn();

        randomFacebook = CommonMethods.getRandomString(10);
        randomSkype = CommonMethods.getRandomString(10);
        randomTwitter = CommonMethods.getRandomString(10);
        randomLinkedin = CommonMethods.getRandomString(10);
        randomViber = CommonMethods.getRandomString(10);
        randomUrl = CommonMethods.getRandomString(10);

        ContactInformationPopUp contactInformationPopUp = myProfilePage.openContactInformationPopUpChanging();
        contactInformationPopUp.facebookField().clearInput().inputText(randomFacebook);
        contactInformationPopUp.skypeField().clearInput().inputText(randomSkype);
        contactInformationPopUp.twitterField().clearInput().inputText(randomTwitter);
        contactInformationPopUp.linkedInField().clearInput().inputText(randomLinkedin);
        contactInformationPopUp.viberField().clearInput().inputText(randomViber);
        contactInformationPopUp.websiteField().clearInput().inputText(randomUrl);

        contactInformationPopUp.buttonApply().clickOn();

        new CustomWaits().threadSleep(500);
    }

    @Test(priority = 3)
    public void TEST_008_03_MYPROFILE_Change_contact_information_SETUP_verify_values() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();
        myProfilePage.buttonContactsTab().clickOn();

        String actualFacebook = myProfilePage.LabelContactFacebook().getText();
        String actualSkype = myProfilePage.LabelContactSkype().getText();
        String actualTwitter = myProfilePage.LabelContactTwitter().getText();
        String actualLinkedin = myProfilePage.LabelContactLinkedIn().getText();
        String actualViber = myProfilePage.LabelContactViber().getText();
        String actualUrl = myProfilePage.LabelContactUrl().getText();

        Assert.assertEquals(actualFacebook, randomFacebook);
        Assert.assertEquals(actualSkype, randomSkype);
        Assert.assertEquals(actualTwitter, randomTwitter);
        Assert.assertEquals(actualLinkedin, randomLinkedin);
        Assert.assertEquals(actualViber, randomViber);
        Assert.assertEquals(actualUrl, randomUrl);
    }

    @Test(priority = 4)
    public void TEST_008_04_MYPROFILE_Change_contact_information_SETUP_back_TEARDOWN() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();
        myProfilePage.buttonContactsTab().clickOn();

        ContactInformationPopUp contactInformationPopUp = myProfilePage.openContactInformationPopUpChanging();
        contactInformationPopUp.facebookField().clearInput().inputText(facebook);
        contactInformationPopUp.skypeField().clearInput().inputText(skype);
        contactInformationPopUp.twitterField().clearInput().inputText(twitter);
        contactInformationPopUp.linkedInField().clearInput().inputText(Linkedin);
        contactInformationPopUp.viberField().clearInput().inputText(viber);
        contactInformationPopUp.websiteField().clearInput().inputText(url);

        contactInformationPopUp.buttonApply().clickOn();

        new CustomWaits().threadSleep(500);
    }

    @Test(priority = 5)
    public void TEST_008_05_MYPROFILE_Change_contact_information_SETUP_verify_values() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();
        myProfilePage.buttonContactsTab().clickOn();

        String actualFacebook = myProfilePage.LabelContactFacebook().getText();
        String actualSkype = myProfilePage.LabelContactSkype().getText();
        String actualTwitter = myProfilePage.LabelContactTwitter().getText();
        String actualLinkedin = myProfilePage.LabelContactLinkedIn().getText();
        String actualViber = myProfilePage.LabelContactViber().getText();
        String actualUrl = myProfilePage.LabelContactUrl().getText();

        Assert.assertEquals(actualFacebook, facebook);
        Assert.assertEquals(actualSkype, skype);
        Assert.assertEquals(actualTwitter, twitter);
        Assert.assertEquals(actualLinkedin, Linkedin);
        Assert.assertEquals(actualViber, viber);
        Assert.assertEquals(actualUrl, url);
    }

}
