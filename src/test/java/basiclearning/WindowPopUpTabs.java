package basiclearning;

import com.microsoft.playwright.*;

public class WindowPopUpTabs {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();

        Page page = browserContext.newPage();

        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Page popup = page.waitForPopup(() -> {
            page.click("div.orangehrm-login-footer-sm > a:nth-child(3)");

        });
        popup.waitForLoadState();
        System.out.println(popup.title());
        popup.close();
        System.out.println(page.title());

        Page popupnew = page.waitForPopup(() -> {
            page.click("a[target='_blank']");

        });
        popupnew.waitForLoadState();
        popupnew.navigate("https://www.google.com/");
        System.out.println(popupnew.title());
        popupnew.close();
    }
}
