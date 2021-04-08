package com.youtube.pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class VideoPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"container\"]/h1/yt-formatted-string")
    private WebElement videoName;

    @FindBy(xpath = "//*[@id=\"movie_player\"]/div[26]/div[2]/div[2]/button[1]")
    private WebElement autoNavigationBtn;

    @FindBy(xpath = "//*[@id=\"movie_player\"]/div[26]/div[2]/div[2]/button[3]")
    private WebElement subtitlesBtn;

    @FindBy(xpath = "//*[@id=\"movie_player\"]/div[26]/div[2]/div[2]/button[10]")
    private WebElement fullScreenBtn;

    @FindBy(xpath = "//*[@id=\"movie_player\"]/div[26]/div[2]/div[1]/button")
    private WebElement playBtn;

    @FindBy(xpath = "//*[@id=\"movie_player\"]/div[26]/div[2]/div[1]/span/button")
    private WebElement muteBtn;

    @FindBy(xpath = "//*[@id=\"top-level-buttons\"]/ytd-toggle-button-renderer[1]")
    private WebElement likeBtn;

    @FindBy(xpath = "//*[@id=\"top-level-buttons\"]/ytd-toggle-button-renderer[2]")
    private WebElement dislikeBtn;

    @FindBy(xpath = "//*[@id=\"thumbnail\"]")
    private WebElement nextVideo;

    @FindBy(xpath = "//*[@id=\"close-button\"]")
    private WebElement closeShareDialogBtn;

    public VideoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getName() {
        return videoName.getText();
    }

    public void click(WebElement element) {
        element.click();
    }
}
