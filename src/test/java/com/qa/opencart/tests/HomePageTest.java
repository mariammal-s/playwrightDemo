package com.qa.opencart.tests;

import com.qa.opencart.base.TestBase;
import com.qa.opencart.constants.ApplicationConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test
    public void homePageTitleTest() {
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, ApplicationConstants.HOME_PAGE_TITLE);
    }

    @Test
    public void homePageUrlTest() {
        String actualURL = homePage.getHomePageUrl();
        Assert.assertEquals(actualURL,prop.getProperty("url"));
    }

    @Test
    public void searchTest() {
        String actualHeader = homePage.doSearch("MacBook");
        Assert.assertEquals(actualHeader,"Search - MacBook");
    }



}
