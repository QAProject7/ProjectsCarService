package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Andrey on 27.01.2017.
 */
public class RegMasterAndreyPage extends Page {

    @FindBy(id = "exampleTitle2")
    public WebElement registrationMasterLable;
    @FindBy(xpath ="//input[@class='ng-pristine ng-untouched ng-valid ng-empty'][@ng-model='master.mechanics']")
    public WebElement mechanicsCheckbox;
    @FindBy(id = "exampleInputCName")
    public WebElement companyNameField;
    @FindBy(xpath ="//input[@class='form-control ng-pristine ng-untouched ng-valid ng-empty'] [@ng-model='master.chosenPlace']")
    public WebElement locationField;
    @FindBy(id = "exampleInputHouse")
    public WebElement houseField;
    @FindBy(id = "exampleInputTelephone")
    public WebElement telephoneField;
    @FindBy(id = "exampleInputTime")
    public WebElement startHourField;
    @FindBy(id = "exampleInputTime1")
    public WebElement endHourField;
    @FindBy(id = "exampleInputEmail2")
    public WebElement emailField;
    @FindBy(xpath ="//input[@class='ng-pristine ng-untouched ng-valid ng-empty'] [@ng-model='master.categories.passCar']")
    public WebElement categoriesCheckbox;
    @FindBy(id = "exampleSelectVehicle")
    public WebElement selectVehicleDropdown;
    @FindBy(xpath ="//*[@id='exampleSelectVehicle']/option[@label='Audi']")
    public WebElement selectVehicleField;
    @FindBy(xpath ="//input[@class='btn btn-default'][@ng-click='addItem(listCars)']")
    public WebElement addVehicleButton;
    @FindBy(xpath ="//li[@class='ng-binding'][contains(., 'Кузовные работы')]/ul[2]/li/input[@type='checkbox']")
    public WebElement serviceCheckbox;
    @FindBy(id = "exampleInputNameManager")
    public WebElement nameManagerField;
    @FindBy(id = "exampleInputTelManager")
    public WebElement telephoneManagerField;
    @FindBy(id = "exampleInputDirector")
    public WebElement nameDirektorField;
    @FindBy(id = "exampleInputLogo")
    public WebElement selectFileButton;
    @FindBy(xpath ="//input[@class='btn btn-default'] [@ng-click='addImg(master.logo)']")
    public WebElement addFileButton;
    @FindBy(xpath = "//form[@ng-submit='addMaster()']/button[@type='submit']")
    public WebElement submitButton;

    public RegMasterAndreyPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "https://secure-citadel-93919.herokuapp.com/#!/registrationMaster";
        PageFactory.initElements(driver, this);
    }

    public RegMasterAndreyPage openRegMasterPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public RegMasterAndreyPage waitUntilRegMasterPageLoaded() {
        waitUntilIsLoaded(registrationMasterLable);
        return this;
    }

    public RegMasterAndreyPage clickMechanicsCheckbox( ) {
        clickElement(mechanicsCheckbox);
        return this;
    }

    public RegMasterAndreyPage fillCompanyNameField(String text) {
        setElementText(companyNameField, text);
        return this;
    }

    public RegMasterAndreyPage fillLocationField(String text) {
        setElementText(locationField, text);
        return this;
    }

    public RegMasterAndreyPage fillHouseField(String text) {
        setElementText(houseField, text);
        return this;
    }

    public RegMasterAndreyPage fillTelephoneField(String text) {
        setElementText(telephoneField, text);
        return this;
    }

    public RegMasterAndreyPage fillStartHourField(String text) {
        setElementText(startHourField, text);
        return this;
    }

    public RegMasterAndreyPage fillEndHourField(String text) {
        setElementText(endHourField, text);
        return this;
    }

    public RegMasterAndreyPage fillEmailField(String text) {
        setElementText(emailField, text);
        return this;
    }

    public RegMasterAndreyPage clickCategoriesCheckbox( ) {
        clickElement(categoriesCheckbox);
        return this;
    }

    public RegMasterAndreyPage fillVehicle() {
        clickElement(selectVehicleDropdown);
        selectInDropdownByValue(selectVehicleDropdown,"Audi");
        return this;
    }

    public RegMasterAndreyPage clickAddVehicleButton() {
        clickElement(addVehicleButton);
        return this;
    }

    public RegMasterAndreyPage clickServiceCheckbox() {
        clickElement(serviceCheckbox);
        return this;
    }

    public RegMasterAndreyPage fillNameManagerField(String text) {
        setElementText(nameManagerField, text);
        return this;
    }

    public RegMasterAndreyPage fillTelephoneManagerField(String text) {
        setElementText(telephoneManagerField, text);
        return this;
    }

    public RegMasterAndreyPage fillNameDirektorField(String text) {
        setElementText(nameDirektorField, text);
        return this;
    }

    public RegMasterAndreyPage clickSelectFileButton( ) {
        clickElement(selectFileButton);
        return this;
    }

    public RegMasterAndreyPage clickAddFileButton( ) {
        clickElement(addFileButton);
        return this;
    }

    public RegMasterAndreyPage clickSubmitButton( ) {
        clickElement(submitButton);
        return this;
    }

}
