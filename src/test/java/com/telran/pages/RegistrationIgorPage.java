package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by a on 25.01.2017.
 */
public class RegistrationIgorPage extends Page {

    @FindBy(id = "exampleInputName")
    @CacheLookup
    public WebElement nameTxtField;


    @FindBy(id = "exampleInputTime")
    @CacheLookup
    public WebElement yearInputField;

    @FindBy(xpath = "//*[@id='exampleTitle1']/h1")
    @CacheLookup
    public WebElement regHeader;






    public RegistrationIgorPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "https://secure-citadel-93919.herokuapp.com/#!/registrationClient";
        PageFactory.initElements(driver, this);

    }


    public RegistrationIgorPage openRegistrationPage() {
        driver.get(PAGE_URL);
        return this;}

    public RegistrationIgorPage fillName(String text) {
        setElementText(nameTxtField, text);
        return this;
    }

    public RegistrationIgorPage fillYear(String text) {
        setElementText(yearInputField, text);
        return this;
    }

    public boolean registrationIgorPage(){
        return exists(regHeader);
    }



}
