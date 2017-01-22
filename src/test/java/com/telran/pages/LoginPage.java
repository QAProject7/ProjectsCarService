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
public class LoginPage extends Page {

  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;

  @FindBy(id = "exampleInputPassword1")
  @CacheLookup
  public WebElement passwordField;

  @FindBy(id = "exampleInputEmail1")
  @CacheLookup
  public WebElement emailField;

  @FindBy(xpath = "//form[@name='form']//button[@type='submit']")
  @CacheLookup
  public WebElement submitButton;

  public LoginPage(WebDriver driver) {
    super(driver);
    this.PAGE_URL = "https://secure-citadel-93919.herokuapp.com/#!/viewLogin";
    PageFactory.initElements(driver, this);

  }

  public LoginPage openLoginPage() {
    driver.get(PAGE_URL);
    return this;
  }

}
