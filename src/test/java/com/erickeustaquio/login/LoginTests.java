package com.erickeustaquio.login;

import com.erickeustaquio.base.BaseTests;
import com.erickeustaquio.pages.LoginPage;
import com.erickeustaquio.pages.SecureAreaPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {


    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage =homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();


        //Comparação mais flexivel usando contains()
        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"),
                "Alert text is incorrect");

        //Debug opcional para ver o titulo real capturado
        System.out.println("Texto capturado: "+secureAreaPage.getAlertText());
    }

}
