package com.qa.opencart.tests;

import com.qa.opencart.base.TestBase;
import com.qa.opencart.constants.ApplicationConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    @Test(priority = 1)
    public void loginPageNavigationTest() {
        loginPage = homePage.navigateToLoginPage();
        String actualTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actualTitle, ApplicationConstants.LOGIN_PAGE_TITLE);
        String actualURL = loginPage.getLoginPageUrl();
        Assert.assertEquals(actualURL,ApplicationConstants.LOGIN_PAGE_URL);
    }

    @Test(priority = 2)
    public void forgetPasswordLinkExistTest() {
       Assert.assertTrue(loginPage.isForgotPasswordPresent());
    }

    @Test(priority = 3)
    public void loginTest() {
        Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(),
                prop.getProperty("password").trim() ));
    }


}
