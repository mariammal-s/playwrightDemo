package basiclearning;

import com.microsoft.playwright.*;

import java.util.List;

public class ComplexWebTables {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        /*page.navigate("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
        Locator rows = page.locator("table#example tr");
        rows.locator(":scope", new Locator.LocatorOptions().setHasText("Bruno Nash")).locator("td.select-checkbox").click();*/

        page.navigate("http://primefaces.org/primeng/table");
        Locator rows = page.locator("table#pr_id_2-table tr");
        rows.locator(":scope", new Locator.LocatorOptions().setHasText("Josephine Darakjy")).locator(".p-checkbox-box").click();
        List<String> allTableElements = rows.locator(":scope").allInnerTexts();
        allTableElements.forEach(e -> System.out.println(e));

        /*for (String e : allTableElements) {
            System.out.println(e);
        }*/

    }
}
