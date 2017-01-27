package com.telran;

import com.telran.pages.LoginPage;
import com.telran.pages.RegClientTolPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegClientTolTest extends TestNgTestBase {

    private LoginPage loginpage;
    private RegClientTolPage regClientPage;

    @BeforeMethod
    public void initPageObjects() {
        regClientPage = PageFactory.initElements(driver, RegClientTolPage.class);
    }

    @Test
    public void positiveRegClient()  {
        regClientPage.openRegClientPage();
        regClientPage.waitUntilRegPageLoaded();
        regClientPage.fillClientName("testTol");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        regClientPage.selectCarVendor("AC");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        regClientPage.waitUntilModelDropListLoaded();
        regClientPage.selectCarModel("Ace");
        regClientPage.fillYearCar("2012");
        regClientPage.fillEngineCar("1.6");
        regClientPage.clickAddButton();
        regClientPage.fillEmailClient("carClient@yopmail.com");

        //regClientPage.clickSubmitButton();


    }
}
