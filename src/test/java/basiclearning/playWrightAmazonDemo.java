package basiclearning;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class playWrightAmazonDemo {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Go to https://www.amazon.com/
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
            //assertThat(page).hasURL("https://www.amazon.com/ap/signin?_encoding=UTF8&accountStatusPolicy=P1&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fcss%2Forder-history%3Fie%3DUTF8%26ref_%3Dnav_orders_first&pageId=webcs-yourorder&showRmrMe=1");

            // Click [aria-label="Amazon"]
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

            // Close page
            page.close();
        }
    }
}