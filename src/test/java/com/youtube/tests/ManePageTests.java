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
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ManePageTests {
    private PropertyReader propertyReader;
    private MainPage mainPage;
    private WebDriver driver;
    private WebDriverWait wait;
    private VideoPage videoPage;

    @BeforeAll
    void init() {
        propertyReader = new PropertyReader();
        System.setProperty("webdriver.chrome.driver", propertyReader.getProperty("chrome_driver"));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
        videoPage = new VideoPage(driver);
    }

    @Test
    @DisplayName("Check if search works correctly")
    void mainPageSearchTest() throws InterruptedException {
        driver.get(propertyReader.getProperty("youtube_main_page"));

        mainPage.click(mainPage.getSearchInput());
        mainPage.inputSearchCondition("Веб. Раздел 12");
        mainPage.click(mainPage.getSearchBtn());

        WebElement foundElement =
                wait.until(presenceOfElementLocated(By.xpath(propertyReader.getProperty("found_video_xpath"))));
        mainPage.click(foundElement);

        Thread.sleep(5000);
        assertEquals(propertyReader.getProperty("video_name_expected_result"),videoPage.getName());
    }

    @Test
    @DisplayName("Check if navigation on main page works correctly")
    void mainPageNavigationTest() throws InterruptedException {
        driver.get(propertyReader.getProperty("youtube_main_page"));

        wait.until(presenceOfElementLocated(By.xpath(propertyReader.getProperty("user_info_btn_xpath"))));

        mainPage.click(mainPage.getSubscriptions());
        Thread.sleep(1000);
        mainPage.click(mainPage.getNavigator());
        Thread.sleep(1000);
        mainPage.click(mainPage.getLibrary());
        Thread.sleep(1000);
        mainPage.click(mainPage.getHistory());
        Thread.sleep(1000);
        mainPage.click(mainPage.getLikedOnes());
        Thread.sleep(1000);
        mainPage.click(mainPage.getMainPage());
        mainPage.click(mainPage.getNotifications());
    }

    @Test
    @DisplayName("Check if logout button works")
    void mainPageLogoutTest() {
        driver.get(propertyReader.getProperty("youtube_main_page"));

        WebElement userInfoBtn =
                wait.until(presenceOfElementLocated(By.xpath(propertyReader.getProperty("user_info_btn_xpath"))));
        mainPage.click(userInfoBtn);

        WebElement logoutBtn =
                wait.until(presenceOfElementLocated(By.xpath(propertyReader.getProperty("logout_btn_xpath"))));
        mainPage.click(logoutBtn);
    }
}
