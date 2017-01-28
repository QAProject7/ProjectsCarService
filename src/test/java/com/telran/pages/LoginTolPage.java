package com.telran.pages;

import jdk.nashorn.api.scripting.URLReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.*;
import java.io.*;
/**
 * Created by Anatoly on 28.01.2017.
 */
public class LoginTolPage extends Page {
    public LoginTolPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "https://secure-citadel-93919.herokuapp.com/#!/viewLogin";
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text()='Login']")
    private WebElement logHeader;

    @FindBy(xpath = "//label[@for='exampleInputEmail1'")
    private WebElement emailLabel;

    @FindBy(id="exampleInputEmail1")
    private WebElement emailInputBox;

    @FindBy(xpath = "//label[@for='exampleInputPassword1'")
    private WebElement passwordLabel;

    @FindBy(id="exampleInputPassword1")
    private WebElement passwordInputBox;

    @FindBy(xpath = "//form[@ng-submit='authLogin(user)']//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//li[@id='logIn']")
    private WebElement loginLabel;

    public LoginTolPage openLoginPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public LoginTolPage fillEmail(String email){
        setElementText(emailInputBox, email);
        return this;
    }

    public LoginTolPage fillPassword(String password){
        setElementText(passwordInputBox, password);
        return this;
    }

    public LoginTolPage clickLoginSubmit(){
        clickElement(submitButton);
        return this;
    }

    public Boolean isLogin(){
        //return this.verifyElementIsPresent(loginLabel);
        return loginLabel.isDisplayed();
    }

    public String getPasswordFromServer(String email){
        String password = "";
        String fileName ="https://secure-citadel-93919.herokuapp.com/api/authentic ";

        BufferedReader br;
        while (true)
            try {
                br = new BufferedReader(new InputStreamReader(new URL(fileName).openStream()));
                break;
            } catch (IOException e1) {
                return "";
            }

        while(true) {

            String inp = null;
            try {
                inp = br.readLine();
            } catch (IOException e) {
                break;
            }
            if (inp == null) break;

            String[] spl = inp.split("},");

            int nEmail;
            String sEmail;

            for (int i = 0; i < spl.length; i++) {
                if ((nEmail = spl[i].indexOf("email")) != -1) {
                    sEmail = spl[i].substring(nEmail + 8, spl[i].indexOf("\"", nEmail + 8));
                } else
                    break;
                if (sEmail.equals(email)) {
                    password = spl[i].substring(nEmail = spl[i].indexOf("password") + 11, spl[i].indexOf("\"", nEmail));
                    return password;
                }
            }
        }

        return password;
    }
}
