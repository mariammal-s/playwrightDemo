package basiclearning;

import com.microsoft.playwright.*;

public class FrameHandle {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();

        Page page = browserContext.newPage();
        page.navigate("https://demoqa.com/");
        page.locator("text = Alerts, Frame & Windows").click();
        page.locator("text = Frames").first().click();
        String header = page.frameLocator("iframe#frame1").locator("h1").textContent();
        System.out.println(header);
        page.pause();
        String nextHeader = page.frameLocator("//iframe[@id='frame2']").locator("h1").textContent();
        System.out.println(nextHeader);
        page.close();


    }
}
