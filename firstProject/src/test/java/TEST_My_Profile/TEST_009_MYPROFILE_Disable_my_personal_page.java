package TEST_My_Profile;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.*;
import com.invest.core.web.tools.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TEST_009_MYPROFILE_Disable_my_personal_page extends BaseClass {

    private boolean isPersonalPageEnabled;

    @Test
    public void TEST_009_MYPROFILE_Public_phone_type1() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();
        isPersonalPageEnabled = myProfilePage.switchViewInBlogs().getAttributeChecked();
        if (isPersonalPageEnabled) {
            String expectedName = myProfilePage.LabelGeneralName().getText();
            MyPersonalPage myPersonalPage = main_page.openMyPersonalPage();
            String actualNameInPersonalPage = myPersonalPage.LabelGeneralName().getText();
            Assert.assertEquals(actualNameInPersonalPage, expectedName);
        } else {
            String expectedMessage = "The user has concealed his page";
            MyPersonalPage myPersonalPage = main_page.openMyPersonalPage();
            String actualPageDisabled = myPersonalPage.LabelPageDisabled().getText();
            Assert.assertEquals(actualPageDisabled, expectedMessage);
        }
    }

    @Test
    public void TEST_009_MYPROFILE_Public_phone_type2() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();
        myProfilePage.buttonViewInBlogsAndChat().clickOn();
        boolean actualSwitchViewInBlogs = myProfilePage.switchViewInBlogs().getAttributeChecked();
        Assert.assertNotEquals(actualSwitchViewInBlogs, isPersonalPageEnabled, "Click on switch button doesn't work");

        isPersonalPageEnabled = myProfilePage.switchViewInBlogs().getAttributeChecked();
        if (isPersonalPageEnabled) {
            String expectedName = myProfilePage.LabelGeneralName().getText();
            MyPersonalPage myPersonalPage = main_page.openMyPersonalPage();
            String actualNameInPersonalPage = myPersonalPage.LabelGeneralName().getText();
            Assert.assertEquals(actualNameInPersonalPage, expectedName);
        } else {
            String expectedMessage = "The user has concealed his page";
            MyPersonalPage myPersonalPage = main_page.openMyPersonalPage();
            String actualPageDisabled = myPersonalPage.LabelPageDisabled().getText();
            Assert.assertEquals(actualPageDisabled, expectedMessage);
        }
    }
}
