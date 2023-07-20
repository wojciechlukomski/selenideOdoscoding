package com.odoscoding.tests;

import com.codeborne.selenide.testng.SoftAsserts;
import com.odoscoding.pageObjects.BaseTest;
import com.odoscoding.pageObjects.HomePage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({SoftAsserts.class})
public class OdoscodingFunctionalTests extends BaseTest {
    
    HomePage homePage = new HomePage();
    
    @Test
    public void negativeLoginTestEmail() {
        homePage
                .clickOnLogInBtn()
                .fillUpFields("w.b.lukomski@gmail.com","haslo123")
                .clickOnLogInBtnField();
    }

//        @Test(priority = 2, groups = "negative")
//        public void negativeLoginTestPassword() {
//            loginPage.fillUpFields("woj_luk@wp.pl", "BadPassword2022");
//            profilePage = loginPage.pushSignInButton();
//            loginPage.assertIncorrectEmailMessage();
//        }
//
//        @Test(priority = 0, groups = "positive")
//        public void positiveLoginTest() throws InterruptedException {
//            loginPage.fillUpFields("woj_luk@wp.pl", "Automation2022");
//            profilePage = loginPage.pushSignInButton();
//            profilePage.assertFirstAndLastName("Wojti", "Luko");
//            profilePage.assertLinkRowFields();
//        }
}


