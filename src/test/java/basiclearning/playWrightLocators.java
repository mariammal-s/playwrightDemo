package basiclearning;

import com.microsoft.playwright.*;

import java.util.List;

public class playWrightLocators {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext brcntxt = browser.newContext();

        Page page = brcntxt.newPage();
        page.navigate("https://www.facebook.com/login/");
        Locator contactSalesLocator = page.locator("text = Sign up for Facebook");
        contactSalesLocator.last().hover();
        contactSalesLocator.last().click();

        Locator countryOptions = page.locator("select#month option");
        System.out.println(countryOptions.count());
        List<String> optionsList = countryOptions.allTextContents();

        for (String e :optionsList){
            System.out.println(e);
        }

    }

}
