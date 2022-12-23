package basiclearning;

import com.microsoft.playwright.*;

import java.util.List;

public class VisibleInvisibleElements {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();

        Page page = browserContext.newPage();
        page.navigate("https://www.amazon.in/");
        List<String> linkTexts = page.locator("a:visible").allInnerTexts();
        for(String e: linkTexts)
            System.out.println(e);

        int imgCount = page.locator("//img >> visible=true").count();
        System.out.println(imgCount);

    }
}
