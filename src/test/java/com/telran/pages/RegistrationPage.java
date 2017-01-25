package com.telran.pages;

import org.openqa.selenium.By;
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

    @FindBy(id = "exampleInputName")
    @CacheLookup
    public WebElement nameField;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "https://secure-citadel-93919.herokuapp.com/#!/registrationClient";
        PageFactory.initElements(driver, this);

    }

    public RegistrationPage openRegistrationPage() {
        driver.get(PAGE_URL);
        return this;
    }


    public RegistrationPage waitUntilRegPageLoaded() {
        waitUntilIsLoaded(carModelDroplist);
        return this;
    }

    public RegistrationPage fillNameField(String name) {
        setElementText(nameField, name);
        return this;
    }

    public RegistrationPage selectCarbyText(String carmodel) {
        clickElement(carModelDroplist);
        //selectValueInDropdownbyText(carModelDroplist, carmodel);

        String locator = "//*[@id='exampleSelectVehicle']/*[text()='" + carmodel + "']";
        WebElement element = driver.findElement(By.xpath(locator));
        clickElement(element);
        return this;
    }

    public RegistrationPage selectCarbyValue(String value) {
        clickElement(carModelDroplist);
        // selectValueInDropdown(carModelDroplist, value);
        return this;
    }

    public RegistrationPage selectCarbyIndex(int value) {
        clickElement(carModelDroplist);
        selectValueInDropdownbyIndex(carModelDroplist, value);
        return this;
    }
}
