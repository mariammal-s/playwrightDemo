package basiclearning;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class demo {

        @Test
        public  void demo1() {
            try (Playwright playwright = Playwright.create()) {
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false));
                BrowserContext context = browser.newContext();
                // Open new page
                Page page = context.newPage();
                // Go to https://www.amazon.in/
                page.navigate("https://www.amazon.in/");
                // Click [aria-label="Search"]
                page.locator("[aria-label=\"Search\"]").click();
                // Click [aria-label="Search"]
                page.locator("[aria-label=\"Search\"]").click();
                // Fill [aria-label="Search"]
                page.locator("[aria-label=\"Search\"]").fill("toys");
                // Press Enter
                page.locator("[aria-label=\"Search\"]").press("Enter");
                //assertThat(page).hasURL("https://www.amazon.in/s?k=toys&crid=1QN4GIJSHGBEO&sprefix=toys%2Caps%2C354&ref=nb_sb_noss_1");
                // Click [aria-label="\30  items in cart"] >> text=0
                page.locator("[aria-label=\"\\30  items in cart\"] >> text=0").click();
                //assertThat(page).hasURL("https://www.amazon.in/ref=nav_logo");
                // Click [aria-label="\30  items in cart"] >> text=0
                page.locator("[aria-label=\"\\30  items in cart\"] >> text=0").click();
                // Open new page
                Page page1 = context.newPage();

        }
    }
}
