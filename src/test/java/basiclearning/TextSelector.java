package basiclearning;

import com.microsoft.playwright.*;

public class TextSelector {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext brcntxt = browser.newContext();

        /*Page page = brcntxt.newPage();
        page.navigate("https://www.facebook.com/r.php?locale=en_GB&display=page");
        Locator policyLinks = page.locator("text = Policy");
        for(int i = 0 ; i < policyLinks.count() ; i++){
            String temp = policyLinks.nth(i).textContent();
            if (temp.equalsIgnoreCase("privacy policy")) {
                policyLinks.nth(i).click();
                break;
            }
        }*/

        Page pagenew = brcntxt.newPage();
        pagenew.navigate("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
        String header = pagenew.locator("div.card-body h2:has-text('New Customer')").textContent();
        System.out.println(header);
        String pageHeader = pagenew.locator("img.img-fluid").getAttribute("title");
        System.out.println(pageHeader);
        pagenew.locator("form button:has-text('Login')").click();
        System.out.println("Done");
    }
}
