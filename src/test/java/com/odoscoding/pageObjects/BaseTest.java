package com.odoscoding.pageObjects;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    
    HomePage homePage = new HomePage();
    
    @BeforeTest(alwaysRun = true)
    public void setUpBrowser() {
        Configuration.browser = "safari";
        Configuration.timeout = 8000;
        Configuration.assertionMode = AssertionMode.SOFT;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(false).savePageSource(true));
    }
    
    @BeforeMethod
    public void beforeMethodSetUp() {
        
        homePage
                .goTo()
                .clickPopUpAllowCookies();
    }
    
    @AfterMethod
    public void afterMethodSetUp() {
        WebDriverRunner.closeWebDriver();
    }
}


