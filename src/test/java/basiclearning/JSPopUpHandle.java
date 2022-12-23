package basiclearning;

import com.microsoft.playwright.*;

public class JSPopUpHandle {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();
        page.onDialog(dialog -> {
            String text = dialog.message();
            System.out.println(text);
            //dialog.dismiss();
            dialog.accept("Hello this is for Prompt");
        });

        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.click("//button[contains(text(),'Click for JS Confirm')]");
        String result = page.textContent("#result");
        System.out.println(result);

        page.click("//button[contains(text(),'Click for JS Prompt')]");
        String resultPrompt = page.textContent("#result");
        System.out.println(resultPrompt);
    }
}
