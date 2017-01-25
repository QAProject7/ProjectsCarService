package com.telran;

import com.telran.pages.RegisterClientPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by i3 on 22.01.2017.
 */
public class RegisterMyTest extends TestNgTestBase {

    private RegisterClientPage regPage;

    // @BeforeClass
    @BeforeMethod   //повторяется кажды раз
    public void initPageObjects() {
        regPage = PageFactory.initElements(driver, RegisterClientPage.class);
        regPage.openRegPage();
    }

    @Test
    public void regTest() throws InterruptedException {
        regPage.openRegPage()
                .waitUntilLoad()
                .fillName("Benya")
//                .selectCarbyText("Audi")
                .selectCarbyValue("object:32");
        Thread.sleep(2000);
        regPage.fillYear("1945")
                .fillVol("1.9")
                .fillEmail("benya@mail.com")
//        Thread.sleep(5000);
                .clickSubmit();
        Thread.sleep(3000);
        Assert.assertFalse(regPage.isOnLoginPage());
    }


}
