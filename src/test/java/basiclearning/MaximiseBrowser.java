package basiclearning;

import com.microsoft.playwright.*;

import java.awt.*;

public class MaximiseBrowser {
    public static void main(String[] args) {

        Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
        double width = dm.getWidth();
        double height =  dm.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize((int) width, (int) height));
        Page page = browserContext.newPage();

        page.navigate("https://playwright.dev/docs/input");
    }
}
