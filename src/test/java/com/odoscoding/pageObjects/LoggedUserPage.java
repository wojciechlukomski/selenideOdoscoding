package com.odoscoding.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoggedUserPage {
    
    private final SelenideElement avatarIcon = $(By.xpath("//*[@id=\"root\"]/header/div[3]/div[3]/div"));
    private final SelenideElement profileBtn = $("body > div:nth-child(2) > header:nth-child(1) > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)");
    private final SelenideElement helpBtn = $("body > div:nth-child(2) > header:nth-child(1) > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(1)");
    private final SelenideElement paymentBtn = $(By.xpath("//a[contains(text(),'Plan i Płatności')]"));
    private final SelenideElement logOutBtn = $(By.xpath("//button[normalize-space()='Wyloguj']"));
    
    public ProfilePage goToProfilePage() {
        avatarIcon.click();
        profileBtn.click();
        return new ProfilePage();
    }
    
    public HomePage logOut() {
        avatarIcon.click();
        logOutBtn.click();
        return new HomePage();
    }
}
