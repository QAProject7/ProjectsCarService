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
    static String[][] users = null;
    @FindBy(xpath = "//*[@id='ng-view']//h1")
    private WebElement Header;

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

    @FindBy(xpath = "//a[contains(@ng-click,'logOut')]")
    private WebElement logoutLabel;

    public LoginTolPage openLoginPage() {
        driver.get(PAGE_URL);
        return this;
    }
    public WebElement getHeader(){
        return Header;
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
        clickElement(this.submitButton);
        return this;
    }

    public Boolean isLogOut(){
        //return this.veriinfyElementIsPresent(loginLabel);
        return logoutLabel.isDisplayed();
    }

    public Boolean isLogIn(){
        return logHeader.isEnabled();

    }

    public static  int readTableUsers(String fileName){

        if (fileName == "") fileName = "https://secure-citadel-93919.herokuapp.com/api/authentic";
        BufferedReader br;
        while (true)
            try {
                br = new BufferedReader(new InputStreamReader(new URL(fileName).openStream()));
                break;
            } catch (IOException e1) {
                return -1;
            }

        int numberUsers = 0;
        while(true) {

            String inp = null;
            try {
                inp = br.readLine();
            } catch (IOException e) {
                break;
            }
            if (inp == null) break;

            String[] usersBrutto = inp.split("},");
            numberUsers = usersBrutto.length;
            String[] usersNetto = new String[numberUsers];
            String[] user;
            String[] fieldNames = null;
            users = new String[numberUsers][];

            for (int i = 0; i < numberUsers; i++) {
                usersNetto[i] = usersBrutto[i].replaceAll("[\"{]", ""); //(\{)
                user = usersNetto[i].split(",");
                //if (fieldNames == null)
                users[i] = new String[user.length];
                for (int j = 0; j < user.length; j++)
                    users[i][j] = user[j].substring(user[j].indexOf(":") + 1);
            }
        }
        return numberUsers;
    }
    public static String getPasswordByEmail(String email){

        for (int i = 0; i < users.length; i++) {
            if (users[i][1].equals(email)) {
                return users[i][2];
            }
        }
        return "";
    }
    public static Boolean isClientExists(String email){

        for (int i = 0; i < users.length; i++) {
            if (users[i][1].equals(email)) {
                return true;
            }
        }
        return false;
    }
}
