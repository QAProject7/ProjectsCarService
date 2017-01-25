package com.telran;

import com.telran.pages.RegistrationPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestNgTestBase {

    private RegistrationPage registrationPage;

    @BeforeClass(alwaysRun = true)
    public void openRegPage() {
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        registrationPage.openRegistrationPage();

    }
    @BeforeMethod
    public void initPageObjects() {

    }

    @Test
    public void RegistrationTestPositive() throws InterruptedException {
        registrationPage.waitUntilRegPageLoaded()
                .fillNameField("MeName");
        Thread.sleep(3000);
        registrationPage.selectCarbyText("object:90");

        Thread.sleep(5000);
        //registrationPage.fillNameField("MeName");

        // Assert.assertFalse("".equals(loginpage.header.getText()));
    }
}
