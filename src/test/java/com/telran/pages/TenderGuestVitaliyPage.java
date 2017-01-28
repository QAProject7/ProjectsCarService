package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vitaliy on 28.01.2017.
 */
public class TenderGuestVitaliyPage extends Page{
    //FILES
//==========================>> NAVIGATION BAR ON THE TOP<<==========================//a
    @FindBy(xpath = "//*[contains(text(), 'Home')]")
    private WebElement HomeLink;

    @FindBy(xpath = "//*[@href='#!/masterView']")
    private WebElement MasterViewLink;

    @FindBy(xpath = "//*[@href='#!/mountingView']")
    private WebElement MountingViewLink;

    @FindBy(xpath = "//*[@href='#!/carWashView']")
    private WebElement CarWashViewLink;

    @FindBy(xpath = "//*[@href='#!/towTruckView']")
    private WebElement TowTruckViewLink;

    @FindBy(xpath = "//*[@href='#!/#!/commentsView']")
    private WebElement CommentsViewLink;

    @FindBy(xpath = "//*[@href='#!/tenderView']")
    private WebElement TenderViewLink;

    @FindBy (xpath = "//*[@class='navbar-form navbar-left ng-pristine ng-valid']//input")
    private WebElement SearchField;

    @FindBy (xpath = "//button[@type='submit']")
    private  WebElement SubmitButton;

    @FindBy (xpath = "//a[contains(text(),'Account')]")
    private WebElement AccountSettingLink;

    @FindBy (xpath = "//a[contains(text(),'Log Out')]")
    private WebElement LogOut;
//================================================================================//





    public TenderGuestVitaliyPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "https://secure-citadel-93919.herokuapp.com"+"/#!/tenderView";
        PageFactory.initElements(driver, this);
    }

    public TenderGuestVitaliyPage GoToTenderView (){
        driver.get(PAGE_URL);
        return  this;
    }
}
