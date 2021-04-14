package com.youtube.tests;

import com.youtube.pages.MainPage;
import com.youtube.pages.VideoPage;
import com.youtube.util.PropertyReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainPageLogoutTests {
    private PropertyReader propertyReader;
    private MainPage mainPage;
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    void init() {
        propertyReader = new PropertyReader();
        propertyReader.setProp("driver-prop.properties");

        if (propertyReader.getProperty("current_driver").equals("chrome_driver")) {
            System.setProperty("webdriver.chrome.driver", propertyReader.getProperty("chrome_driver"));
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption(propertyReader.getProperty("debugger_address_property"),
                    propertyReader.getProperty("debugger_address_property_value"));
            driver = new ChromeDriver(options);
        } else {
            System.setProperty("webdriver.gecko.driver", propertyReader.getProperty("mozilla_driver"));
            driver = new FirefoxDriver();
        }

        propertyReader.setProp("config.properties");

        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Check if logout button works")
    void mainPageLogoutTest() {
        assumeTrue(driver.getClass() == ChromeDriver.class);

        driver.get(propertyReader.getProperty("youtube_main_page"));

        WebElement userInfoBtn =
                wait.until(presenceOfElementLocated(By.xpath(propertyReader.getProperty("user_info_btn_xpath"))));
        mainPage.click(userInfoBtn);

        WebElement logoutBtn =
                wait.until(presenceOfElementLocated(By.xpath(propertyReader.getProperty("logout_btn_xpath"))));
        mainPage.click(logoutBtn);
    }
}
