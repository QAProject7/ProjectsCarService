package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class RegisterClientPage extends Page {

    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup
    public WebElement header;

    @FindBy(id = "exampleSelectVehicle")
    @CacheLookup
    public WebElement carBrandDropdown;

    @FindBy(id = "exampleInputName")
    @CacheLookup
    public WebElement nameField;

    @FindBy(id = "exampleInputTime")
    @CacheLookup
    public WebElement yearField;

    @FindBy(id = "exampleInputText")
    @CacheLookup
    public WebElement volume;

    @FindBy(id = "exampleInputEmail1")
    @CacheLookup
    public WebElement email;

    @FindBy(xpath = "//form[@role='form']/button[@type='submit']")
    @CacheLookup
    public WebElement submitBtn;

    @FindBy(id = "exampleSelectVehicle")
    @CacheLookup
    public WebElement selectVehicle;

    @FindBy(id = "exampleSelectModel")
    @CacheLookup
    public WebElement selectModelDropdown;

    @FindBy(xpath = "//*[@id='exampleSelectModel']/option[@value='Q3']")
    @CacheLookup
    public WebElement vehicleModel;

    @FindBy(xpath = "//*[@id='exampleSelectVehicle']/option[@label='Audi']")
    @CacheLookup
    public WebElement vehicleBrand;


    public RegisterClientPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "https://secure-citadel-93919.herokuapp.com/#!/registrationClient";
        PageFactory.initElements(driver, this);
    }

    public RegisterClientPage waitUntilLoade() {
        waitUntilIsLoaded(carBrandDropdown);
        return this;
    }

    public RegisterClientPage openLoginPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public RegisterClientPage fillName(String text) {
        setElementText(nameField, text);
        return this;
    }

    public RegisterClientPage fillEmail(String text) {
        setElementText(email, text);
        return this;
    }

    public RegisterClientPage fillVehicle() {
        clickElement(carBrandDropdown);
        clickElement(vehicleBrand);
        return this;
    }

    public RegisterClientPage fillModel() {
        clickElement(selectModelDropdown);
        clickElement(vehicleModel);
        return this;
    }

    //***********************//
    public RegisterClientPage fillYear(String year) {
        clickElement(yearField);
        yearField.sendKeys(year);
        return this;
    }

    public RegisterClientPage fillVol(String vol) {
        clickElement(volume);
        volume.sendKeys(vol);
        return this;
    }

    public RegisterClientPage presSubmit() {
        clickElement(submitBtn);
        return this;
    }
}
