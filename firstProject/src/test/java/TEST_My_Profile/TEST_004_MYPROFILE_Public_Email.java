package TEST_My_Profile;

import com.invest.core.BaseClass;
import com.invest.core.web.customwait.CustomWaits;
import com.invest.core.web.pages.*;
import com.invest.core.web.tools.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TEST_004_MYPROFILE_Public_Email extends BaseClass {

    private boolean isEmailVisibleOn;

    @Test
    public void TEST_004_MYPROFILE_Public_Email_type1() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();
        isEmailVisibleOn = myProfilePage.switchElementButtonEmail().getAttributeChecked();

        //Проверяем switch элемент View in the Blogs and Chat - если выключен, включить (нужно отобразить My personal page)
        boolean isPersonalPageEnabled = myProfilePage.switchViewInBlogs().getAttributeChecked();
        if (!isPersonalPageEnabled) {
            myProfilePage.buttonViewInBlogsAndChat().clickOn();
        }

        String expectedEmailVisible = "";
        if (isEmailVisibleOn) {
            expectedEmailVisible = Constants.LOGIN; //Not empty
        } else {
            expectedEmailVisible = ""; //Empty
        }
        MyPersonalPage myPersonalPage = main_page.openMyPersonalPage();
        new CustomWaits().threadSleep(1000);
        String actualEmailVisible = myPersonalPage.LabelGeneralEmail().getText();
        Assert.assertEquals(actualEmailVisible, expectedEmailVisible);
    }

    @Test
    public void TEST_004_MYPROFILE_Public_Email_type2() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();
        myProfilePage.buttonPublicityEmail().clickOn();
        boolean actualEmailNotificationSwitch = myProfilePage.switchElementButtonEmail().getAttributeChecked();
        Assert.assertNotEquals(actualEmailNotificationSwitch, isEmailVisibleOn);
        isEmailVisibleOn = actualEmailNotificationSwitch;
        String expectedEmailVisible = "";
        if (isEmailVisibleOn) {
            expectedEmailVisible = Constants.LOGIN; //Not empty
        } else {
            expectedEmailVisible = ""; //Empty
        }
        MyPersonalPage myPersonalPage = main_page.openMyPersonalPage();
        new CustomWaits().threadSleep(1000);
        String actualEmailVisible = myPersonalPage.LabelGeneralEmail().getText();
        Assert.assertEquals(actualEmailVisible, expectedEmailVisible);
    }
}
