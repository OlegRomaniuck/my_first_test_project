package TEST_My_Profile;

import com.invest.core.BaseClass;
import com.invest.core.web.pages.LoginPage;
import com.invest.core.web.pages.MyProfilePage;
import com.invest.core.web.pages.PopUps.BasicInformationPopUp;
import com.invest.core.web.pages.StartPage;
import com.invest.core.web.pages.UserPageMain;
import com.invest.core.web.tools.CommonMethods;
import com.invest.core.web.tools.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TEST_006_MYPROFILE_Cant_change_generalInfo_without_pass extends BaseClass {

    @Test
    public void TEST_006_MYPROFILE_Cant_change_generalInfo_without_pass() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();

        BasicInformationPopUp basicInformationPopUp = myProfilePage.openBasicInfoChanging();

        basicInformationPopUp.buttonApply().clickOn();

        String actualMessagePassFail = basicInformationPopUp.labelErrorMessagePassword().getText();
        String expectedMessagePassFail = "This field is required";

        Assert.assertEquals(actualMessagePassFail, expectedMessagePassFail);
        Assert.assertTrue(basicInformationPopUp.buttonApply().isAvailable());

    }

}
