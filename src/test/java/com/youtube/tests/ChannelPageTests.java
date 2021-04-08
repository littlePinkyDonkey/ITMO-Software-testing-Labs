package com.youtube.tests;

import com.youtube.pages.ChannelPage;
import com.youtube.util.PropertyReader;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ChannelPageTests {
    private PropertyReader propertyReader;
    private WebDriver driver;
    private WebDriverWait wait;
    private ChannelPage channelPage;

    @BeforeAll
    void init() {
        propertyReader = new PropertyReader();
        System.setProperty("webdriver.chrome.driver", propertyReader.getProperty("chrome_driver"));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();

        channelPage = new ChannelPage(driver);
    }

    @Test
    @DisplayName("Check if there is a right channel")
    void particularChannel() {
        driver.get(propertyReader.getProperty("youtube_channel_page"));

        WebElement channelName =
                wait.until(presenceOfElementLocated(By.xpath(propertyReader.getProperty("channel_name_xpath"))));

        assertEquals(propertyReader.getProperty("channel_name_expected_result"), channelName.getText());
    }

    @Test
    @DisplayName("Check if channel navigation works")
    void navigationChanelPageTest() {
        driver.get(propertyReader.getProperty("youtube_channel_page"));

        wait.until(presenceOfElementLocated(By.xpath(propertyReader.getProperty("channel_name_xpath"))));

        channelPage.click(channelPage.getPlaylists());
        channelPage.click(channelPage.getVideos());
        channelPage.click(channelPage.getDiscussions());
        channelPage.click(channelPage.getChanelInfo());
    }

    @Test
    @DisplayName("Check if search works correctly")
    void searchChannelTest() throws InterruptedException {
        driver.get(propertyReader.getProperty("youtube_channel_page"));

        wait.until(presenceOfElementLocated(By.xpath(propertyReader.getProperty("channel_name_xpath"))));

        channelPage.click(channelPage.getSearchBtn());
        channelPage.inputSearchCondition("Веб. Раздел 12");

        Thread.sleep(1000);
        channelPage.click(channelPage.getFoundVideo());
    }

    @Test
    void notificationsTest() throws InterruptedException {
        driver.get(propertyReader.getProperty("youtube_channel_page"));

        wait.until(presenceOfElementLocated(By.xpath(propertyReader.getProperty("channel_name_xpath"))));

        channelPage.click(channelPage.getNotificationsBtn());
        channelPage.click(channelPage.getAllNotificationsBtn());
        Thread.sleep(1000);

        channelPage.click(channelPage.getNotificationsBtn());
        channelPage.click(channelPage.getNoNotificationsBtn());
        Thread.sleep(1000);

        channelPage.click(channelPage.getNotificationsBtn());
        channelPage.click(channelPage.getPreferenceBasedNotificationsBtn());
    }

    @Test
    @DisplayName("Check if user can unsubscribe and subscribe to the channel")
    void subscribeBtnTest() {
        driver.get(propertyReader.getProperty("youtube_channel_page"));

        WebElement subscribeBtn =
                wait.until(presenceOfElementLocated(By.xpath(propertyReader.getProperty("subscribe_btn_xpath"))));
        channelPage.click(subscribeBtn);
        channelPage.click(channelPage.getUnsubscribeBtn());
        channelPage.click(subscribeBtn);
    }

    @AfterAll
    void destroy() {
        driver.quit();
    }
}
