package com.telran;

import com.telran.pages.LoginPage;
import com.telran.pages.LoginTolPage;
import com.telran.pages.RegClientTolPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Anatoly on 28.01.2017.
 */
public class LoginTolTest extends TestNgTestBase {
    private LoginTolPage loginpage;
    private String testEmail = "tol-ka@mail.ru";
    private String testPassword = "";

    @BeforeMethod
    public void initPageObjects() {
        loginpage = PageFactory.initElements(driver, LoginTolPage.class);
    }

    @Test
    public void loginPositiveTest(){
        loginpage.openLoginPage();
        loginpage.fillEmail(testEmail);
        testPassword = loginpage.getPasswordFromServer(testEmail);
        loginpage.fillPassword(testPassword);
        loginpage.clickLoginSubmit();

        Assert.assertFalse(loginpage.isLogin(), "Login not successful");
    }
}
