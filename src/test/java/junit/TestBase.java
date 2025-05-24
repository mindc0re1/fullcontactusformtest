package junit;

import Pages.SupportPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


    public class TestBase {
        SupportPage supportPage = new SupportPage();
        TestData data = new TestData();

        @BeforeAll
        static void beforeAll() {
            Configuration.holdBrowserOpen = true;
            Configuration.browserSize = "2560x1140";
            Configuration.baseUrl = "https://failsafe.test/";
        }
}
