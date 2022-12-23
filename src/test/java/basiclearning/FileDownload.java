package basiclearning;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class FileDownload {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=102.0.5005.27/");
        Download download = page.waitForDownload(() -> {
            page.click("a:text('chromedriver_mac64.zip')");
        });
        //Cancel Download
        //download.cancel();

        System.out.println(download.failure());

        System.out.println(download.url());

        String path = download.path().toString();
        System.out.println(path);
        download.saveAs(Paths.get("Sample_Download.zip"));
        System.out.println(download.suggestedFilename());

    }
}

