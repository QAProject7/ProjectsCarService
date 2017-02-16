package com.telran;

import com.telran.pages.LoginTolPage;
import com.telran.pages.RegMasterTolPage;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

/**
 * Created by 1 on 07.02.2017.
 */
public class RegMasterTolTest extends TestNgTestBase{

    private LoginTolPage loginpage;
    private RegMasterTolPage regMasterPage;

    @BeforeClass(alwaysRun = true)
    public void openRegPage() {
        regMasterPage = PageFactory.initElements(driver, RegMasterTolPage.class);
        loginpage = PageFactory.initElements(driver, LoginTolPage.class);
        regMasterPage.openRegMasterPage();
        regMasterPage.setArrayCheckBox();
    }
        /*private WebDriver driver;
        private String baseUrl;*/
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();



        @Test
        public void testRegMaster() throws Exception {
            String email = "carMaster@yopmail.com";
            regMasterPage.setMechanicsCheckbox()
                         .setMountingCheckbox()
                         .setCarwashCheckbox()
                         .setTowtracksCheckbox();
            regMasterPage.fillCompanyName("companyname")
                         .fillAddressClient("address")
                         .fillHouseClient("house")
                         .fillTelephoneClient("telephone")
                         .fillStartHour("10")
                         .fillEndHour("22")
                         .fillEmailClient(email);
            regMasterPage.setBicycleCheckbox()
                         .setLorryCheckbox()
                         .setMopedCheckbox()
                         .setPasscarCheckbox()
                         .setBusCheckbox();
            regMasterPage.selectVehicle("Audi")
                         .clickAddcar();
            regMasterPage.checkArrayCheckBox()
                         .checkArrayCheckBox(2)
                         .checkArrayCheckBox(0,0);
            regMasterPage.fillNameManager("manager")
                         .fillTelManager("telmanager")
                         .fillDirector("director");
            regMasterPage.clickSubmit();
            Thread.sleep(3000);
            Assert.assertTrue(loginpage.isLogIn(),"Client Registration not successful");
            LoginTolPage.readTableUsers("");
            Assert.assertTrue(LoginTolPage.isClientExists(email), "Client Registration Info not added");
            /*
            driver.findElement(By.id("exampleInputLogo")).clear();
            driver.findElement(By.id("exampleInputLogo")).sendKeys("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
            driver.findElement(By.xpath("//div[@id='ng-view']/div/div/div/form/div[13]/div/input[2]")).click();
            driver.findElement(By.xpath("//div[@id='ng-view']/div/div/div/form/button")).click();
            */
        }

        /*@AfterClass(alwaysRun = true)
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }*/

        private boolean isElementPresent(By by) {
            try {
                driver.findElement(by);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }

        private boolean isAlertPresent() {
            try {
                driver.switchTo().alert();
                return true;
            } catch (NoAlertPresentException e) {
                return false;
            }
        }

        private String closeAlertAndGetItsText() {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                if (acceptNextAlert) {
                    alert.accept();
                } else {
                    alert.dismiss();
                }
                return alertText;
            } finally {
                acceptNextAlert = true;
            }
        }


}
