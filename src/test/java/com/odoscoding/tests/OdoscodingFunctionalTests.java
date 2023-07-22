package com.odoscoding.tests;

import com.codeborne.selenide.testng.SoftAsserts;
import com.odoscoding.pageObjects.BaseTest;
import com.odoscoding.pageObjects.HomePage;
import com.odoscoding.pageObjects.LoggedUserPage;
import com.odoscoding.pageObjects.ProfilePage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({SoftAsserts.class})
public class OdoscodingFunctionalTests extends BaseTest {
    
    HomePage homePage = new HomePage();
    LoggedUserPage loggedUserPage;
    ProfilePage profilePage;
    
    @Test(priority = 0, groups = {"negative"})
    public void negativeLoginTestEmail() {
        homePage
                .clickOnLogInBtn()
                .fillUpFields("w.b@gmail.com", "haslo123")
                .clickOnSignInBtn();
    }
    
    @Test(priority = 1, groups = {"negative"})
    public void negativeLoginTestPassword() {
        homePage
                .clickOnLogInBtn()
                .fillUpFields("woj_luk@wp.pl", "haslo123")
                .clickOnSignInBtn();
    }
    
    @Test(priority = 2, groups = {"negative"})
    public void incorrectLoginTestEmail() {
        homePage
                .clickOnLogInBtn()
                .fillUpFields("w@gmail.com.", "haslo123")
                .clickOnSignInBtn();
        homePage
                .assertIncorrectEmailMessage();
    }
    
    @Test(priority = 3, groups = {"positive"})
    public void positiveLoginTest() throws InterruptedException {
        homePage.clickOnLogInBtn()
                .fillUpFields("woj_luk@wp.pl", "Odoscoding890!");
        
        loggedUserPage = homePage.clickOnSignInBtn();
        profilePage = loggedUserPage.goToProfilePage();
        
        profilePage.assertDisplayedNameAndEmail("Wojtek", "woj_luk@wp.pl");
    }
    
    @Test(priority = 4, groups = {"positive"})
    public void positiveLoginTestAndLogOut() throws InterruptedException {
        homePage.clickOnLogInBtn()
                .fillUpFields("woj_luk@wp.pl", "Odoscoding890!");
        
        loggedUserPage = homePage.clickOnSignInBtn();
        loggedUserPage
                .logOut().assertPositiveLogOut();
    }
}



