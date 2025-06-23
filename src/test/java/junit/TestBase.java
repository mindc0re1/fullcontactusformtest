package junit;

import Pages.SupportPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


    public class TestBase {
        SupportPage supportPage = new SupportPage();
        TestData data = new TestData();

        @BeforeAll
        static void beforeAll() {
            Configuration.headless = true;
            Configuration.holdBrowserOpen = true;
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://www.croxyproxy.com/";
            Configuration.reportsFolder = "build/reports/selenide";
            Configuration.screenshots = true;
            Configuration.savePageSource = true;
            Configuration.timeout = 20000;
        }
}
