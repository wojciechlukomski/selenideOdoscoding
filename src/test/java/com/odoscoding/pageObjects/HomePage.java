package com.odoscoding.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomePage {
    
    private final SelenideElement popUpAllowButton = $(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/button[2]"));
    private final SelenideElement logInBtn = $(By.xpath("//button[@class='btn text-base outline-btn flex flex-row items-center justify-center font-medium disabled:opacity-25 text-base px-4 py-2']"));
    
    private final SelenideElement inputEmail = $("#email");
    private final SelenideElement inputPassword = $("#current-password");
    private final SelenideElement signInBtn = $("button[class='w-full text-lg h-10 mb-6 btn solid-btn flex items-center justify-center font-medium disabled:pointer-events-none disabled:opacity-25 hover:opacity-60']");
    
    private final SelenideElement incorrectEmailMessage = $(".error-message");
    
    public HomePage clickPopUpAllowCookies() {
        popUpAllowButton.click();
        return this;
    }
    
    public HomePage clickOnLogInBtn() {
        logInBtn.click();
        return this;
    }
    
    public LoggedUserPage clickOnSignInBtn() {
        signInBtn.click();
        return new LoggedUserPage();
    }
    
    public HomePage goTo() {
        open("https://odoscoding.com/");
        getWebDriver().manage().window().maximize();
        return this;
    }
    
    public HomePage fillUpFields(String email, String password) {
        inputEmail.setValue(email);
        inputPassword.setValue(password);
        return this;
    }
    
    public HomePage assertIncorrectEmailMessage() {
        incorrectEmailMessage.shouldHave(Condition.text("Błędny adres email"));
        return this;
    }
    
    public HomePage assertNegativeEmailMessage() {
        incorrectEmailMessage.shouldHave(Condition.text("Zły adres lub hasło."));
        return this;
    }
    
    public HomePage assertPositiveLogOut() {
        signInBtn.shouldBe(Condition.visible);
        return this;
    }
  
}
