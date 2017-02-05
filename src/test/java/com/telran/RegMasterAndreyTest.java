package com.telran;

import com.telran.pages.LoginPage;
import com.telran.pages.RegMasterAndreyPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andrey on 28.01.2017.
 */
public class RegMasterAndreyTest {

    private LoginPage loginpage;
    private RegMasterAndreyPage regMasterPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        regMasterPage = PageFactory.initElements(driver, RegMasterAndreyPage.class);
        loginpage = PageFactory.initElements(driver, LoginPage.class);

    }

//    @BeforeMethod
//    public void initPageObjects() {
//        regMasterPage = PageFactory.initElements(driver, RegMasterAndreyPage.class);
//    }

    @Test
    public void positiveRegMaster() throws InterruptedException {
        regMasterPage.openRegMasterPage();
        regMasterPage.waitUntilRegMasterPageLoaded();
        regMasterPage.clickMechanicsCheckbox();
        regMasterPage.fillCompanyNameField("TelRan");
        regMasterPage.fillLocationField("Holon");
        regMasterPage.fillHouseField("45");
        regMasterPage.fillTelephoneField("09290230329");
        regMasterPage.fillStartHourField("9:00");
        regMasterPage.fillEndHourField("21:00");
        regMasterPage.fillEmailField("andkkd@gmail.com");
        regMasterPage.clickCategoriesCheckbox();
        regMasterPage.fillVehicle();
        regMasterPage.clickAddVehicleButton();
        regMasterPage.clickServiceCheckbox();
        regMasterPage.fillNameManagerField("Viktor");
        regMasterPage.fillTelephoneManagerField("09949494");
        regMasterPage.fillNameDirektorField("Moshe");
       // regMasterPage.clickSelectFileButton();
        //regMasterPage.clickAddFileButton();
        regMasterPage.clickSubmitButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(loginpage.IsOnLoginPage(), "Is not on Login Page");

    }

//    @Test
//    public void negativeRegMaster() throws InterruptedException {
//
//    }

    }
