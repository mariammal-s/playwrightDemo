package basiclearning;

import com.microsoft.playwright.*;

import java.util.List;

public class RelativeSelectors {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();

        Page page = browserContext.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/");
        page.locator("input[type='checkbox']:left-of(:text('John.Smith'))").first().click();
        String user_role = page.locator("td:right-of(:text('John.Smith'))").first().textContent();
        System.out.println(user_role);

        System.out.println(page.locator("a:above(:text('John.Smith'))").first().textContent());
        System.out.println(page.locator("a:below(:text('John.Smith'))").first().textContent());

        Locator nearElements = page.locator("td:near(:text('John.Smith'),400)");
        List<String> nearElementsText= nearElements.allInnerTexts();

        for(String e : nearElementsText)
            System.out.println(e);
    }
}
