package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginSuccessfull()
    {
        LoginPage loginPage=homePage.clicksOnFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage=loginPage.clicksOnLogin();
        String actual=secureAreaPage.getAlertText();
        Assert.assertTrue(actual.contains("You logged into a secure area!"),"You logged into a secure area!");


    }
    @Test
    public void testLoginFailed()
    {
        LoginPage loginPage=homePage.clicksOnFormAuthentication();
        loginPage.setUsername("Tom");
        loginPage.setPassword("Jerry");
        loginPage.clicksOnLogin();
        String actual=loginPage.showError();
        System.out.println(actual);
        Assert.assertTrue(actual.contains("Your username is invalid!"),"Error message show invalid error message");
    }


}
