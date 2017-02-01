package com.telran;

import com.telran.pages.LoginPage;
import com.telran.pages.LoginTolPage;
import com.telran.pages.RegClientTolPage;
import com.telran.pages.RegistrationPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegClientTolTest extends TestNgTestBase {

    private LoginTolPage loginpage;
    private RegClientTolPage regClientPage;

    @BeforeClass(alwaysRun = true)
    public void openRegPage() {
        regClientPage = PageFactory.initElements(driver, RegClientTolPage.class);
        loginpage = PageFactory.initElements(driver, LoginTolPage.class);
        regClientPage.openRegClientPage();

    }
    @BeforeMethod
    public void initPageObjects() {

    }

    @Test(groups = {"positive"})
    public void positiveRegClient()  {
        String email = "carClient@yopmail.com";
        regClientPage.waitUntilRegPageLoaded();
        regClientPage.fillClientName("testTol");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        regClientPage.selectCarVendor("AC");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        regClientPage.waitUntilModelDropListLoaded();
        regClientPage.selectCarModel("Ace");
        regClientPage.fillYearCar("2012");
        regClientPage.fillEngineCar("1.6");
        regClientPage.clickAddButton();
        regClientPage.fillEmailClient(email);

        regClientPage.clickSubmitButton();
        Assert.assertTrue(loginpage.isLogIn(),"Client Registration not successful");
        LoginTolPage.readTableUsers("");
        Assert.assertTrue(LoginTolPage.isClientExists(email), "Client Registration Info not added");
    }

    @Test(groups = {"negative"})
    public void negativeRegClientEmptyEmail()  {

        regClientPage.waitUntilRegPageLoaded();
        regClientPage.fillClientName("testTol");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        regClientPage.selectCarVendor("AC");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        regClientPage.waitUntilModelDropListLoaded();
        regClientPage.selectCarModel("Ace");
        regClientPage.fillYearCar("2012");
        regClientPage.fillEngineCar("1.6");
        regClientPage.clickAddButton();
        regClientPage.fillEmailClient("");

        regClientPage.clickSubmitButton();
        Assert.assertFalse("Login".equals(loginpage.getHeader().getText()));

        //Assert.assertFalse(loginpage.isLogIn());
    }
    @Test(groups = {"negative"})
    public void negativeRegClientNotCorrectlyEmail()  {

        regClientPage.waitUntilRegPageLoaded();
        regClientPage.fillClientName("testTol");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        regClientPage.selectCarVendor("AC");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        regClientPage.waitUntilModelDropListLoaded();
        regClientPage.selectCarModel("Ace");
        regClientPage.fillYearCar("2012");
        regClientPage.fillEngineCar("1.6");
        regClientPage.clickAddButton();
        regClientPage.fillEmailClient("carClient@");

        regClientPage.clickSubmitButton();
        Assert.assertFalse("Login".equals(loginpage.getHeader().getText()));
    }
    @Test(groups = {"negative"})
    public void negativeRegClientExistEmail()  {

        regClientPage.waitUntilRegPageLoaded();
        regClientPage.fillClientName("testTol");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        regClientPage.selectCarVendor("AC");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        regClientPage.waitUntilModelDropListLoaded();
        regClientPage.selectCarModel("Ace");
        regClientPage.fillYearCar("2012");
        regClientPage.fillEngineCar("1.6");
        regClientPage.clickAddButton();
        regClientPage.fillEmailClient("carClient@yopmail.com");

        regClientPage.clickSubmitButton();
        Assert.assertFalse("Login".equals(loginpage.getHeader().getText()));
    }
}
