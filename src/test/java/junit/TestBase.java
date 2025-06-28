package junit;

import Pages.SupportPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TestBase {
        SupportPage supportPage = new SupportPage();
        TestData data = new TestData();


        @BeforeAll
        static void beforeAll() {
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
            Configuration.headless = false;
            Configuration.holdBrowserOpen = true;
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://www.croxyproxy.com/";
            Configuration.reportsFolder = "build/reports/selenide";
            Configuration.screenshots = true;
            Configuration.savePageSource = true;
            Configuration.timeout = 20000;
Configuration.browser = "chrome";
Configuration.browserVersion = "128.0";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            Configuration.browserCapabilities = capabilities;
        }
        }

