package com.youtube.tests;

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

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VideoTests {
    private PropertyReader propertyReader;
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

        videoPage = new VideoPage(driver);
    }

    @Test
    @DisplayName("Check if the particular video is opened")
    void videoTest() {
        driver.get(propertyReader.getProperty("youtube_video_page"));

        WebElement videoName =
                wait.until(presenceOfElementLocated(By.xpath(propertyReader.getProperty("video_name_xpath"))));

        assertEquals(propertyReader.getProperty("video_name_expected_result"), videoName.getText());
    }

    @Test
    @DisplayName("Check if user can share the video")
    void shareVideoTest() throws IOException, UnsupportedFlavorException {
        driver.get(propertyReader.getProperty("youtube_video_page"));

        WebElement shareBtn =
                wait.until(presenceOfElementLocated(By.xpath(propertyReader.getProperty("share_btn_xpath"))));
        videoPage.click(shareBtn);

        WebElement copyLinkBtn =
                wait.until(presenceOfElementLocated(By.xpath(propertyReader.getProperty("share_link_btn_xpath"))));
        videoPage.click(copyLinkBtn);

        String videoLink = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);

        videoPage.click(videoPage.getCloseShareDialogBtn());

        assertEquals(propertyReader.getProperty("video_shared_link_expected_result"), videoLink);
    }

    @Test
    @DisplayName("Check if video buttons are available")
    void videoButtonsTest() {
        driver.get(propertyReader.getProperty("youtube_video_page"));

        wait.until(presenceOfElementLocated(By.xpath(propertyReader.getProperty("video_name_xpath"))));

        videoPage.click(videoPage.getMuteBtn());
        videoPage.click(videoPage.getAutoNavigationBtn());
        videoPage.click(videoPage.getSubtitlesBtn());
        videoPage.click(videoPage.getPlayBtn());
        videoPage.click(videoPage.getDislikeBtn());
        videoPage.click(videoPage.getLikeBtn());

        videoPage.click(videoPage.getFullScreenBtn());
        videoPage.click(videoPage.getFullScreenBtn());

        videoPage.click(videoPage.getNextVideo());
    }

}
