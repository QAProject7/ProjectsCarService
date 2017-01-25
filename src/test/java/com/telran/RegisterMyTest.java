package com.telran;

import com.telran.pages.RegisterClientPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by i3 on 22.01.2017.
 */
public class RegisterMyTest extends TestNgTestBase {

    private RegisterClientPage regPage;

    @BeforeMethod
    public void initPageObjects() {
        regPage = PageFactory.initElements(driver, RegisterClientPage.class);
    }

    @Test
    public void regTest() throws InterruptedException {
        regPage.openLoginPage()
                .fillName("Benya")
                .fillVehicle();
        Thread.sleep(500);
        regPage.fillModel()
                .fillYear("1945")
                .fillVol("1.9")
                .fillEmail("benya@mail.com");
        Thread.sleep(50000);
//                .clickSubmit();
    }


}
