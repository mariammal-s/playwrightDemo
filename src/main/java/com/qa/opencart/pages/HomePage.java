package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;

    private String search = "input[name='search']";
    private String searchIcon = "div#search button";
    private String searchPageHeader = "div#content h1";
    private String myAccountDropDown = "//span[normalize-space()='My Account']";
    private String loginLink = "(//a[normalize-space()='Login'])[1]";

    public HomePage(Page page){
        this.page = page;
    }

    public String getHomePageTitle() {
        String pageTitle = page.title();
        System.out.println("Page Title is : "+pageTitle);
        return pageTitle;
    }

    public String getHomePageUrl() {
        String pageUrl = page.url();
        System.out.println("Page URL is : "+pageUrl);
        return pageUrl;
    }

    public String doSearch (String productName) {
        page.fill(search,productName);
        page.click(searchIcon);
        String headerText =  page.textContent(searchPageHeader);
        System.out.println("Page Header is : "+headerText);
        return headerText;
    }

    public LoginPage navigateToLoginPage(){
        page.click(myAccountDropDown);
        page.click(loginLink);
        return new LoginPage(page);
    }

}
