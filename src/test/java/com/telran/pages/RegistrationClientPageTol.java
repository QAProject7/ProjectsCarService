package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class RegistrationClientPageTol extends Page {


    @FindBy(id = "exampleSelectVehicle")
    @CacheLookup
    public WebElement carVendorDroplist;
    @FindBy(id="exampleInputName")
    public WebElement clientNameInputBox;
    @FindBy(id="exampleSelectModel")
    public WebElement carModelDroplist;
    @FindBy(id="exampleInputTime")
    public WebElement carYearInputBox;
    @FindBy(id="exampleInputText")
    public WebElement carEngineInputBox;
    @FindBy (xpath = "//input[@class='btn btn-default'][@value='add']")
    public WebElement addButton;
    @FindBy(id="exampleInputEmail1")
    public WebElement email1InputBox;
    @FindBy(xpath = "//button[@class='btn btn-default'][@type='submit']")
    public WebElement submitButton;

    public RegistrationClientPageTol(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "https://secure-citadel-93919.herokuapp.com/#!/registrationClient";
        PageFactory.initElements(driver, this);

    }
    public RegistrationClientPageTol openRegClientPage() {
        driver.get(PAGE_URL);
        return this;
    }
    public RegistrationClientPageTol waitUntilRegPageLoaded() {
        waitUntilIsLoaded(carModelDroplist);
        return this;
    }
    public void selectCarVendor(String vendor){
        selectValueInDropdownbyText(carVendorDroplist, vendor);
    }
    public void selectCarModel(String model){
        selectValueInDropdownbyText(carModelDroplist, model);
    }
    public void fillClientName(String clientName){
        setElementText(clientNameInputBox, clientName);

    }
    public void fillYearCar(String yearCar){
        setElementText(carYearInputBox, yearCar);
    }
    public void fillEngineCar(String engineCar){
        setElementText(carEngineInputBox, engineCar);
    }
    public void fillEmailClient(String eMailClient){
        setElementText(email1InputBox, eMailClient);
    }
    public void clickAddButton(){
        clickElement(addButton);
    }
    public void clickSubmitButton(){
        clickElement(submitButton);
    }
}
