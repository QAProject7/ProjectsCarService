package com.telran;

import com.telran.pages.RegistrationPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestNgTestBase {

    private RegistrationPage registrationPage;

    @BeforeMethod
    public void initPageObjects() {
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
    }

    @Test
    public void positveLogin() {

        // Assert.assertFalse("".equals(loginpage.header.getText()));
    }
}
