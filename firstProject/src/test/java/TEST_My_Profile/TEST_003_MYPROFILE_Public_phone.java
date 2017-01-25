package TEST_My_Profile;

import com.invest.core.BaseClass;
import com.invest.core.web.customwait.CustomWaits;
import com.invest.core.web.pages.*;
import com.invest.core.web.tools.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TEST_003_MYPROFILE_Public_phone extends BaseClass {

    private boolean isPhoneVisible;

    @Test(priority = 1)
    public void TEST_003_MYPROFILE_Public_phone_type1() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();
        isPhoneVisible = myProfilePage.switchElementButtonPhone().getAttributeChecked1();

        //Проверяем switch элемент View in the Blogs and Chat - если выключен, включить (нужно отобразить My personal page)
        boolean isPersonalPageEnabled = myProfilePage.switchViewInBlogs().getAttributeChecked();
        if (!isPersonalPageEnabled) {
            myProfilePage.buttonViewInBlogsAndChat().clickOn();
        }

        String expectedPhoneVisible = "";
        if (isPhoneVisible) {
            expectedPhoneVisible = myProfilePage.LabelGeneralPhone().getText(); //Not empty
        } else {
            expectedPhoneVisible = ""; //Empty
        }
        MyPersonalPage myPersonalPage = main_page.openMyPersonalPage();
        new CustomWaits().threadSleep(1000);
        String actualPhoneVisible = myPersonalPage.LabelGeneralPhone().getText();
        Assert.assertEquals(actualPhoneVisible, expectedPhoneVisible);
    }

    @Test(priority = 2)
    public void TEST_003_MYPROFILE_Public_phone_type2() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();
        myProfilePage.buttonPublicityPhone().clickOn();
        boolean actualPhoneVisibleSwitch = myProfilePage.switchElementButtonPhone().getAttributeChecked();
        Assert.assertNotEquals(actualPhoneVisibleSwitch, isPhoneVisible);
        isPhoneVisible = actualPhoneVisibleSwitch;
        String expectedPhoneVisible = "";
        if (isPhoneVisible) {
            expectedPhoneVisible = myProfilePage.LabelGeneralPhone().getText(); //Not empty
        } else {
            expectedPhoneVisible = ""; //Empty
        }
        MyPersonalPage myPersonalPage = main_page.openMyPersonalPage();
        new CustomWaits().threadSleep(1000);
        String actualPhoneVisible = myPersonalPage.LabelGeneralPhone().getText();
        Assert.assertEquals(actualPhoneVisible, expectedPhoneVisible);
    }
}
