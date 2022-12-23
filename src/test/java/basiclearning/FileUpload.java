package basiclearning;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUpload {

    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
        page.setInputFiles("#filesToUpload", Paths.get("applogin.json"));
        //Deselecting the file
        Thread.sleep(2000);
        page.setInputFiles("#filesToUpload",new Path[0]);

        page.setInputFiles("#filesToUpload",
                new Path[] {
                Paths.get("Files/laidsforDuesPerformance.csv"),
                Paths.get("Files/laidstoCopy.csv"),
                Paths.get("applogin.json")
        });
        Thread.sleep(2000);
        page.setInputFiles("#filesToUpload",new Path[0]);

        //Run Time File
        page.setInputFiles("#filesToUpload",new FilePayload("Sample.txt","text/plain","This is a sample text for sample file".getBytes(StandardCharsets.UTF_8)));
        Thread.sleep(2000);
        page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
        page.setInputFiles("input[name = 'upfile']",new FilePayload("Sample.txt","text/plain","This is a sample text for sample file".getBytes(StandardCharsets.UTF_8)));
        page.click("input[value = 'Press']");

    }

}
