package basiclearning;

import com.microsoft.playwright.*;

public class CommaSelectors {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();

        Page page = browserContext.newPage();
        page.navigate("https://www.facebook.com/login/");
        System.out.println(page.title());
        page.locator("a:has-text('Create New Account'), a:has-text('Sign up for Facebook')").click();
        System.out.println(page.title());

        Locator imp_elements = page.locator("input#u_0_b_mY, a:has-text('Already have an account?') ,span:has-text('Meta © 2022')");

        if (imp_elements.count() == 3)
            System.out.println("PASS");
        else
            System.out.println("FAIL");
    }

}
