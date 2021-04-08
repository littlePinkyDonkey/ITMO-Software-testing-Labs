package com.youtube.tests;

import com.youtube.pages.LoginPage;
import com.youtube.util.PropertyReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginPageTests {
    private PropertyReader propertyReader;
    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;

    @BeforeAll
    void init() {
        propertyReader = new PropertyReader();

        System.setProperty("webdriver.chrome.driver", propertyReader.getProperty("chrome_driver"));
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption(propertyReader.getProperty("debugger_address_property"),
                propertyReader.getProperty("debugger_address_property_value"));

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
    }

    @Test
    void loginPageTest() throws InterruptedException {
        driver.get(propertyReader.getProperty("youtube_main_page"));

        WebElement loginBtn =
                wait.until(presenceOfElementLocated(By.xpath(propertyReader.getProperty("login_btn_xpath"))));
        loginBtn.click();

        loginPage.click(loginPage.getChangeAccountBtn());

        Thread.sleep(1000);
        loginPage.inputLogin("");
        Thread.sleep(1000);

        assertEquals(propertyReader.getProperty("google_trolling_message_expected_result"),
                loginPage.getGoogleTrollingMessage().getText());
    }
}
