package com.odoscoding.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    
    private final SelenideElement displayedName = $(By.xpath("//*[@id=\"root\"]/main/div/main/div/div/div[2]/div[1]/div/div[1]/div[2]"));
    private final SelenideElement displayedEmail = $(By.xpath("//*[@id=\"root\"]/main/div/main/div/div/div[2]/div[1]/div/div[2]/div[2]"));
    
    public ProfilePage assertDisplayedNameAndEmail(String name, String email) {
        displayedName.shouldHave(Condition.text(name));
        displayedEmail.shouldHave(Condition.text(email));
        return this;
    }
}
