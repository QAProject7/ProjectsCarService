package com.telran;

import com.telran.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestNgTestBase {

    private LoginPage loginpage;

    @BeforeMethod
    public void initPageObjects() {
        loginpage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void positveLogin() {
        loginpage.openLoginPage()
                .fillEmailField("email@email.com")
                .fillPasswordField("password")
                .clickOnSubmit();

        // Assert.assertFalse("".equals(loginpage.header.getText()));
    }

    @Test
    public void NegativeLogin() {
        loginpage.openLoginPage()
                .fillEmailField("")
                .fillPasswordField("")
                .clickOnSubmit();
        Assert.assertTrue(loginpage.IsOnLoginPage(), "Logged in with empty fields");

        // Assert.assertFalse("".equals(loginpage.header.getText()));
    }
}
