package com.telran;


import com.telran.pages.RegistrationIgorPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegPageIgorTest extends TestNgTestBase {


  private RegistrationIgorPage registrationPage;

  @BeforeClass(alwaysRun = true)
  public void openRegPage() {
    registrationPage = PageFactory.initElements(driver, RegistrationIgorPage.class);
    registrationPage.openRegistrationPage();


  }

  @BeforeMethod
  public void initPageObjects() {

  }

  @Test
  public void testHomePageHasAHeader() {

    registrationPage.fillName("VASYA");
    registrationPage.fillYear("1812");
    Assert.assertTrue(registrationPage.registrationIgorPage(),"Logged in with empty");
  }



}