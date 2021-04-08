package com.youtube.pages;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class MainPage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div/div[1]/input")
    private WebElement searchInput;

    @FindBy(xpath = "/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/button")
    private WebElement searchBtn;

    @FindBy(xpath = "/html/body/ytd-app/div/ytd-page-manager/ytd-browse/ytd-two-column-browse-results-renderer/div[1]/ytd-rich-grid-renderer/div[6]/ytd-rich-item-renderer[1]/div/ytd-rich-grid-media/div[1]/ytd-thumbnail/a")
    private WebElement video;

    @FindBy(xpath = "/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[3]/div[2]/ytd-notification-topbar-button-renderer/div[1]/a")
    private WebElement notifications;

    @FindBy(xpath = "/html/body/ytd-app/div/tp-yt-app-drawer/div[2]/div/div[2]/div[2]/ytd-guide-renderer/div[1]/ytd-guide-section-renderer[1]/div/ytd-guide-entry-renderer[1]/a")
    private WebElement mainPage;

    @FindBy(xpath = "/html/body/ytd-app/div/tp-yt-app-drawer/div[2]/div/div[2]/div[2]/ytd-guide-renderer/div[1]/ytd-guide-section-renderer[1]/div/ytd-guide-entry-renderer[2]/a")
    private WebElement navigator;

    @FindBy(xpath = "/html/body/ytd-app/div/tp-yt-app-drawer/div[2]/div/div[2]/div[2]/ytd-guide-renderer/div[1]/ytd-guide-section-renderer[2]/div/ytd-guide-entry-renderer[1]/a")
    private WebElement library;

    @FindBy(xpath = "/html/body/ytd-app/div/tp-yt-app-drawer/div[2]/div/div[2]/div[2]/ytd-guide-renderer/div[1]/ytd-guide-section-renderer[1]/div/ytd-guide-collapsible-section-entry-renderer/div[2]/ytd-guide-entry-renderer[1]/a")
    private WebElement history;

    @FindBy(xpath = "/html/body/ytd-app/div/tp-yt-app-drawer/div[2]/div/div[2]/div[2]/ytd-guide-renderer/div[1]/ytd-guide-section-renderer[1]/div/ytd-guide-entry-renderer[3]/a")
    private WebElement subscriptions;

    @FindBy(xpath = "/html/body/ytd-app/div/tp-yt-app-drawer/div[2]/div/div[2]/div[2]/ytd-guide-renderer/div[1]/ytd-guide-section-renderer[1]/div/ytd-guide-collapsible-section-entry-renderer/div[2]/ytd-guide-entry-renderer[3]/a")
    private WebElement likedOnes;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void inputSearchCondition(String condition) {
        searchInput.sendKeys(condition);
    }
}
