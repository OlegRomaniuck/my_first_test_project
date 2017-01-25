package TEST_My_Profile;

import com.invest.core.BaseClass;
import com.invest.core.web.customwait.CustomWaits;
import com.invest.core.web.pages.LoginPage;
import com.invest.core.web.pages.MyProfilePage;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.UserPageMain;
import com.invest.core.web.tools.CommonMethods;
import com.invest.core.web.tools.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by Vadym on 10.03.2016.
 */

public class TEST_010_MYPROFILE_Change_photo extends BaseClass {

    @Test
    public void TEST_010_MYPROFILE_Change_photo() {
        String path = "src/test/resources/images/image1.jpg";

        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();
        String absolutePathToFile = new File(path).getAbsoluteFile().toString();
        myProfilePage.uploadFile().sendKeys(absolutePathToFile);

        new CustomWaits().threadSleep(2000);

        boolean actualShowingButtonUpload = myProfilePage.buttonUpload().isAvailable();

        Assert.assertTrue(actualShowingButtonUpload, "Button 'Upload' should showing");

        myProfilePage.buttonUpload().clickOn();

        actualShowingButtonUpload = myProfilePage.buttonUpload().isAvailable();

        Assert.assertFalse(actualShowingButtonUpload, "Button 'Upload' should not showing after pressed Upload avatar");
    }

}
