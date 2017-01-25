package TEST_My_Profile;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.LoginPage;
import com.invest.core.web.pages.MyProfilePage;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.UserPageMain;
import com.invest.core.web.tools.CommonMethods;
import com.invest.core.web.tools.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TEST_002_MYPROFILE_Change_status extends BaseClass {

    @Test
    public void TEST_002_MYPROFILE_Change_status_type_1() {
        String status = CommonMethods.getRandomString(25);

        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();
        myProfilePage.changeStatus(status);

        String actual = myProfilePage.LabelMyStatus().getTextByAttribute();

        Assert.assertEquals(actual, status);
    }

    @Test(dependsOnMethods = "TEST_002_MYPROFILE_Change_status_type_1")
    public void TEST_002_MYPROFILE_Change_status_type2() {
        String status = "I'm the happiest trader in 4invest!";

        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();
        myProfilePage.changeStatus(status);

        String actual = myProfilePage.LabelMyStatus().getTextByAttribute();

        Assert.assertEquals(actual, status);
    }

}
