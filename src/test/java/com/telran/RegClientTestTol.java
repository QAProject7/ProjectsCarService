package com.telran;

import com.telran.pages.LoginPage;
import com.telran.pages.RegistrationClientPageTol;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegClientTestTol extends TestNgTestBase {

    private LoginPage loginpage;
    private RegistrationClientPageTol regClientPage;

    @BeforeMethod
    public void initPageObjects() {
        regClientPage = PageFactory.initElements(driver, RegistrationClientPageTol.class);
    }

    @Test
    public void positiveRegClient() throws InterruptedException {
        regClientPage.openRegClientPage();
        regClientPage.waitUntilRegPageLoaded();
        regClientPage.fillClientName("testTol");
        regClientPage.selectCarVendor("Chevrolet");
        regClientPage.wait(3000);
        regClientPage.selectCarModel("Cruze");
        regClientPage.fillYearCar("2012");
        regClientPage.fillEngineCar("1.6");
        regClientPage.clickAddButton();
        regClientPage.fillEmailClient("email@email.com");

        regClientPage.clickSubmitButton();

        // Assert.assertFalse("".equals(loginpage.header.getText()));
    }
}
