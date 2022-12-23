package com.qa.opencart.factory;

import com.microsoft.playwright.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;

    public Page initBrowser(Properties prop) {
        String browserName = prop.getProperty("browser");
        String url = prop.getProperty("url");
        System.out.println("Browser name is : "+browserName);
        playwright = Playwright.create();
        switch (browserName.toLowerCase()){
            case "chromium" :
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox" :
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari" :
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome" :
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                System.out.println("Please give proper browser name");
                break;
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();

        page.navigate(url.trim());

        return page;
    }


    public Properties initProp() {

        try {
            FileInputStream ip = new FileInputStream("./src/main/resources/config/config.properties");
            prop = new Properties();
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

}
