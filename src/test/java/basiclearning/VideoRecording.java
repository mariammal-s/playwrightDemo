package basiclearning;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VideoRecording {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")));
        Page page = browserContext.newPage();

        page.navigate("https://www.amazon.com/");

        // Click input[name="field-keywords"]
        page.locator("input[name=\"field-keywords\"]").click();

        // Fill input[name="field-keywords"]
        page.locator("input[name=\"field-keywords\"]").fill("toys");

        // Press Enter
        page.locator("input[name=\"field-keywords\"]").press("Enter");
        //assertThat(page).hasURL("https://www.amazon.com/s?k=toys&ref=nav_bb_sb");

        // Click [aria-label="Crayola"] i
        page.locator("[aria-label=\"Crayola\"] i").click();
        //assertThat(page).hasURL("https://www.amazon.com/s?k=toys&rh=n%3A165793011%2Cp_89%3ACrayola&dc&ds=v1%3ADAQPflWZB1y4%2BI6lH9EEZxY3GbU9p6WkQdlE2MX5cNM&qid=1668237737&rnid=2528832011&ref=sr_nr_p_89_1");

        // Click text=& Orders
        page.locator("text=& Orders").click();

        page.locator("[aria-label=\"Amazon\"]").click();
        assertThat(page).hasURL("https://www.amazon.com/ref=ap_frn_logo");

        // Click [aria-label="Amazon"]
        page.locator("[aria-label=\"Amazon\"]").click();
        assertThat(page).hasURL("https://www.amazon.com/ref=nav_logo");

        // Click text=0 Cart >> span >> nth=1
        page.locator("text=0 Cart >> span").nth(1).click();
        assertThat(page).hasURL("https://www.amazon.com/gp/cart/view.html?ref_=nav_cart");

        // Click text=Your Amazon Cart is empty
        page.locator("text=Your Amazon Cart is empty").click();

        browserContext.close();
    }
}
