package com.youtube.pages;

import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class ChanelPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"text\"]")
    private WebElement chanelName;

    @FindBy(xpath = "//*[@id=\"confirm-button\"]/a")
    private WebElement unsubscribeBtn;

    @FindBy(xpath = "//*[@id=\"cancel-button\"]/a")
    private WebElement cancelBtn;

    @FindBy(xpath = "//*[@id=\"notification-preference-button\"]/ytd-subscription-notification-toggle-button-renderer/a")
    private WebElement notificationsBtn;

    @FindBy(xpath = "//*[@id=\"items\"]/ytd-menu-service-item-renderer[1]")
    private WebElement allNotificationsBtn;

    @FindBy(xpath = "//*[@id=\"items\"]/ytd-menu-service-item-renderer[2]")
    private WebElement preferenceBasedNotificationsBtn;

    @FindBy(xpath = "//*[@id=\"items\"]/ytd-menu-service-item-renderer[3]")
    private WebElement noNotificationsBtn;

    @FindBy(xpath = "//*[@id=\"tabsContent\"]/tp-yt-paper-tab[2]")
    private WebElement videos;

    @FindBy(xpath = "//*[@id=\"tabsContent\"]/tp-yt-paper-tab[3]")
    private WebElement playlists;

    @FindBy(xpath = "//*[@id=\"tabsContent\"]/tp-yt-paper-tab[5]")
    private WebElement discussions;

    @FindBy(xpath = "//*[@id=\"tabsContent\"]/tp-yt-paper-tab[6]")
    private WebElement chanelInfo;

    @FindBy(xpath = "/html/body/ytd-app/div/ytd-page-manager/ytd-browse/div[3]/ytd-c4-tabbed-header-renderer/tp-yt-app-header-layout/div/tp-yt-app-header/div[2]/tp-yt-app-toolbar/div/div/tp-yt-paper-tabs/div/div/ytd-expandable-tab-renderer[7]/yt-icon-button/button")
    private WebElement searchBtn;

    @FindBy(xpath = "//*[@id=\"input-1\"]/input")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"thumbnail\"]")
    private WebElement foundVideo;

    public ChanelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getName() {
        return chanelName.getText();
    }

    public void click(WebElement element) {
        element.click();
    }

    public void inputSearchCondition(String condition) {
        searchInput.sendKeys(condition, Keys.ENTER);
    }

}
