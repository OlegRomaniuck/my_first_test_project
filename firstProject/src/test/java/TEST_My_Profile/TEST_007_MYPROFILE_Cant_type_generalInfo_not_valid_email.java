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



public class TEST_007_MYPROFILE_Cant_type_generalInfo_not_valid_email extends BaseClass {

    @Test
    public void TEST_007_MYPROFILE_Cant_type_generalInfo_not_valid_email() {
        StartPage page = new StartPage(driver).load();
        LoginPage login_page = page.clickOnLogin();
        UserPageMain main_page = login_page.getMainUserpage(Constants.LOGIN, Constants.PASSWORD);

        MyProfilePage myProfilePage = main_page.openMyProfile();

        String randomWrongEmail = CommonMethods.getRandomString(8);

        BasicInformationPopUp basicInformationPopUp = myProfilePage.openBasicInfoChanging();
        basicInformationPopUp.emailField().clearInput().inputText(randomWrongEmail);
        basicInformationPopUp.confirmPasswordField().clearInput().inputText(Constants.PASSWORD);

        String actualMessage = basicInformationPopUp.labelWrongEmailChange().getText();
        String expectedMessage = "email is not valid";

        Assert.assertEquals(actualMessage, expectedMessage);
        Assert.assertTrue(basicInformationPopUp.buttonApply().isAvailable());

    }

}
