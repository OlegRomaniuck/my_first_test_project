package TEST_My_Profile;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.LoginPage;
import com.invest.core.web.pages.MyProfilePage;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.UserPageMain;
import com.invest.core.web.tools.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TEST_001_MYPROFILE_Open_page extends BaseClass {

    @Test
    //@Video
    public void TEST_001_MYPROFILE_Open_page() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();
        Assert.assertTrue(myProfilePage.isAvailable());
    }

}
