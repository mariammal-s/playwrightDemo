package basiclearning;

import com.microsoft.playwright.*;

public class ShadowDomHandle {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();

        Page page = browserContext.newPage();
        page.navigate("https://books-pwakit.appspot.com/");
        page.locator("book-app[apptitle='BOOKS'] #input").fill("Test Books");
        String message= page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
        System.out.println(message);


    }
}
