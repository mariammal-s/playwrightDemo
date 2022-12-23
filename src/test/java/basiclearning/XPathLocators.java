package basiclearning;

import com.microsoft.playwright.*;

import java.util.List;

public class XPathLocators {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();

        Page page = browserContext.newPage();
        page.navigate("https://www.amazon.in/");
        Locator innerLinkText = page.locator("//a[contains(text(),Amazon)]");
        List<String> linkText = innerLinkText.allInnerTexts();
        for (String e : linkText)
            System.out.println(e);
    }
}
