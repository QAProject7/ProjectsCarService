package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class RegistrationPage extends Page {


    @FindBy(id = "exampleSelectVehicle")
    @CacheLookup
    public WebElement carModelDroplist;


    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "https://secure-citadel-93919.herokuapp.com/#!/viewLogin";
        PageFactory.initElements(driver, this);

    }

    public RegistrationPage waitUntilRegPageLoaded() {
        waitUntilIsLoaded(carModelDroplist);
        return this;
    }


}
