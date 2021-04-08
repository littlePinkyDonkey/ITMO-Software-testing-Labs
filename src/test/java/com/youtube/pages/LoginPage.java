package com.youtube.pages;

import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div/div/ul/li[2]")
    private WebElement changeAccountBtn;

    @FindBy(xpath = "//*[@id=\"identifierId\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"identifierNext\"]")
    private WebElement loginNextBtn;

    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button")
    private WebElement passwordNextBtn;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void inputLogin(String login) {
        loginField.sendKeys(login, Keys.ENTER);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password, Keys.ENTER);
    }
}
