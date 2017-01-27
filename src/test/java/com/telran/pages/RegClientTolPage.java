package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Author: Anatoly Katz
 */
public class RegClientTolPage extends Page {


    @FindBy(id = "exampleSelectVehicle")
    //@CacheLookup
    private WebElement carVendorDroplist;
    @FindBy(id="exampleInputName")
    private WebElement clientNameInputBox;
    @FindBy(id="exampleSelectModel")
    private WebElement carModelDroplist;
    @FindBy(id="exampleInputTime")
    private WebElement carYearInputBox;
    @FindBy(id="exampleInputText")
    private WebElement carEngineInputBox;
    @FindBy (xpath = "//input[@class='btn btn-default'][@value='add']")
    private WebElement addButton;
    @FindBy(id="exampleInputEmail1")
    private WebElement email1InputBox;
    @FindBy(xpath = "//button[@class='btn btn-default'][@type='submit']")
    private WebElement submitButton;

    public RegClientTolPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "https://secure-citadel-93919.herokuapp.com/#!/registrationClient";
        PageFactory.initElements(driver, this);

    }
    public RegClientTolPage openRegClientPage() {
        driver.get(PAGE_URL);
        return this;
    }
    public RegClientTolPage waitUntilRegPageLoaded() {
        waitUntilIsLoaded(this.carVendorDroplist);
        return this;
    }
    public RegClientTolPage waitUntilModelDropListLoaded() {
        waitUntilIsLoaded(this.carModelDroplist);
        return this;
    }
    public RegClientTolPage selectCarVendor(String vendor){
        clickElement(carVendorDroplist);
        selectValueInDropdownbyText(this.carVendorDroplist, vendor);
        return this;
    }
    public RegClientTolPage selectCarModel(String model){
        //clickElement(carModelDroplist);
        selectValueInDropdownbyValue(carModelDroplist, model);
        return this;
    }
    public RegClientTolPage fillClientName(String clientName){
        setElementText(clientNameInputBox, clientName);
        return this;
    }
    public RegClientTolPage fillYearCar(String yearCar){
        setElementText(carYearInputBox, yearCar);
        return this;
    }
    public RegClientTolPage fillEngineCar(String engineCar){
        setElementText(carEngineInputBox, engineCar);
        return this;
    }
    public RegClientTolPage fillEmailClient(String eMailClient){
        setElementText(email1InputBox, eMailClient);
        return this;
    }
    public RegClientTolPage clickAddButton(){
        clickElement(addButton);
        return this;
    }
    public RegClientTolPage clickSubmitButton(){
        clickElement(submitButton);
        return this;
    }
}
