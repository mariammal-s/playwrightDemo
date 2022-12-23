package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    private String emailID = "//input[@id='input-email']";
    private String password = "//input[@id='input-password']";
    private String loginButton = "//input[@value='Login']";
    private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
    private String logOutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

    public LoginPage(Page page){
        this.page = page;
    }

    public String getLoginPageTitle() {
        return page.title();
    }

    public String getLoginPageUrl() {
        return page.url();
    }

    public boolean isForgotPasswordPresent() {
        return page.isVisible(forgotPwdLink);
    }

    public boolean doLogin(String appUserName , String appPassword) {
        System.out.println("App Credentials : "+ appUserName+" , "+appPassword);
        page.fill(emailID,appUserName);
        page.fill(password,appPassword);
        page.click(loginButton);
        if(page.isVisible(logOutLink)) {
            System.out.println("User has successfully Logged in ");
            return true;
        }
        return false;
    }

}
