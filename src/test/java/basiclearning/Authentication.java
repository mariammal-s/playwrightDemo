package basiclearning;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Authentication {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("http://stg-agency.whizdm.com/");
        page.fill("[placeholder='Username']","shweta");
        page.fill("[placeholder='Password']","markandey");
        page.click("span:has-text('SIGN IN')");

        browserContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));

    }

}
