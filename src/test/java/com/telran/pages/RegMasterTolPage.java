package com.telran.pages;

import com.telran.TestNgTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by tol-ka on 08.02.2017.
 */
public class RegMasterTolPage extends Page{
    WebElement arrayServicesCheckBox[][] = new WebElement[9][];
    @FindBy(xpath ="//input[@ng-model='master.mechanics']")
            private WebElement mechanicsCheckbox;
    @FindBy(xpath ="//input[@ng-model='master.mounting']")
            private WebElement mountingCheckbox;
    @FindBy(xpath ="//input[@ng-model='master.carWash']")
            private WebElement carwashCheckbox;
    @FindBy(xpath ="//input[@ng-model='master.towTruck']")
            private WebElement towtrucksCheckbox;

    @FindBy(id="exampleInputCName")
            private WebElement clientNameTextBox;

    @FindBy(xpath="//input[@ng-model='master.chosenPlace']")
            private WebElement clientAddressTextBox;

    @FindBy(id="exampleInputHouse")
            private WebElement clientHouseTextBox;

    @FindBy(id="exampleInputTelephone")
            private WebElement clientTelephoneTextBox;

    @FindBy(id="exampleInputTime")
            private WebElement clientStartTimeTextBox;

    @FindBy(id="exampleInputTime1")
            private WebElement clientEndTimeTextBox;

    @FindBy(id="exampleInputEmail2")
            private WebElement clientEmailTextBox;

    @FindBy(xpath = "//input[@ng-model='master.categories.bicycle']")
            private WebElement bicycleCheckBox;

    @FindBy(xpath = "//input[@ng-model='master.categories.passCar']")
            private WebElement passCarCheckBox;

    @FindBy(xpath = "//input[@ng-model='master.categories.lorry']")
            private WebElement lorryCheckBox;

    @FindBy(xpath = "//input[@ng-model='master.categories.bus']")
            private WebElement busCheckBox;

    @FindBy(xpath = "//input[@ng-model='master.categories.moped']")
    private WebElement mopedCheckBox;

    @FindBy(id = "exampleSelectVehicle")
            private WebElement vehicleDropBox;

    //new Select(driver.findElement(By.id("exampleSelectVehicle"))).selectByVisibleText("Audi");
    //driver.findElement(By.xpath("//select[@id='exampleSelectVehicle']/option[5]")).click();
    @FindBy(xpath = "//input[@ng-click='addItem(listCars)']")
            private WebElement addCarButton;
    //driver.findElement(By.xpath("//div[@id='ng-view']/div/div/div/form/div[8]/div/input")).click();

    @FindBy(xpath = "//li[@class='ng-binding ng-scope'][@ng-repeat='item in arrayCarsM track by $index']")
            private WebElement clientVehiclesList;
    @FindBy(xpath = "//li[@class='ng-binding ng-scope'][@ng-repeat='item in arrayCarsM track by $index']/span")
        private WebElement removeClientVehiclesButton;

   @FindBy(id = "exampleInputNameManager")
            private WebElement nameManagerTextBox;

    @FindBy(id = "exampleInputTelManager")
            private WebElement telManagerTextBox;

    @FindBy(id = "exampleInputDirector")
            private WebElement directorTextBox;

    @FindBy(id = "exampleInputLogo")
            private WebElement logoTextBox;
    //driver.findElement(By.id("exampleInputLogo")).clear();
    //driver.findElement(By.id("exampleInputLogo")).sendKeys("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
    @FindBy(xpath = "//input[@ng-click='addImg(master.logo)']")
            private WebElement addLogoButton;
    //driver.findElement(By.xpath("//div[@id='ng-view']/div/div/div/form/div[13]/div/input[2]")).click();
    @FindBy(xpath = "//form[@ng-submit='addMaster()']/button[@type='submit']")
            private WebElement submitMasterButton;
    //driver.findElement(By.xpath("//div[@id='ng-view']/div/div/div/form/button")).click();
    public RegMasterTolPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "https://secure-citadel-93919.herokuapp.com/#!/registrationMaster";
        PageFactory.initElements(driver, this);

    }
    public RegMasterTolPage openRegMasterPage() {
        driver.get(PAGE_URL);
        return this;
    }
    public RegMasterTolPage setArrayCheckBox(){
        int countGroups, countWorks;
        countGroups = driver.findElements(By.xpath("//ul[@ng-repeat='serv in services']")).size();
                //selenium.getXPathCount("//ul[@ng-repeat='serv in services']").intValue();
        for(int i = 0; i < countGroups; i++) {
            countWorks = driver.findElements(By.xpath("//ul[@ng-repeat='serv in services'][" + (i + 1) + "]//input[contains(@ng-model,'master.services')][@type='checkbox']")).size();
                    //selenium.getXPathCount("//ul[@ng-repeat='serv in services'][" + (i + 1) + "]//input[contains(@ng-model,'master.services')][@type='checkbox']").intValue();
            //label[contains(text(),'Services')]/../div/ul[1]/li/ul[1]/li/input
            arrayServicesCheckBox[i] = new WebElement[countWorks];
            for(int j = 0; j < countWorks; j++){

                arrayServicesCheckBox[i][j] = driver.findElement(By.xpath("//ul[@ng-repeat='serv in services'][" + (i + 1) + "]//ul["+(j+1)+"]//input[contains(@ng-model,'master.services')][@type='checkbox']"));
            }

        }
        return this;
    }
    public RegMasterTolPage checkArrayCheckBox(){
        for(int i = 0; i < arrayServicesCheckBox.length; i++)
            for(int j = 0; j < arrayServicesCheckBox[i].length; j++)
                arrayServicesCheckBox[i][j].click();
        return this;
    }
    public RegMasterTolPage checkArrayCheckBox(int group){
        for(int j = 0; j < arrayServicesCheckBox[group].length; j++)
                arrayServicesCheckBox[group][j].click();
        return this;
    }
    public RegMasterTolPage checkArrayCheckBox(int group, int service){
        arrayServicesCheckBox[group][service].click();
        return this;
    }
    public RegMasterTolPage fillCompanyName(String name){
        setElementText(clientNameTextBox, name);
        return this;
    }
    public RegMasterTolPage fillAddressClient(String address){
        setElementText(clientAddressTextBox, address);
        return this;
    }
    public RegMasterTolPage fillHouseClient(String house){
        setElementText(clientHouseTextBox, house);
        return this;
    }
    public RegMasterTolPage fillTelephoneClient(String telephone){
        setElementText(clientTelephoneTextBox, telephone);
        return this;
    }
    public RegMasterTolPage fillStartHour(String hour){
        setElementText(clientStartTimeTextBox, hour);
        return this;
    }
    public RegMasterTolPage fillEndHour(String hour){
        setElementText(clientEndTimeTextBox, hour);
        return this;
    }
    public RegMasterTolPage fillEmailClient(String mail){
        setElementText(clientEmailTextBox, mail);
        return this;
    }
    public RegMasterTolPage setBicycleCheckbox(){
        if (!bicycleCheckBox.isSelected()) bicycleCheckBox.click();
        return this;
    }
    public RegMasterTolPage unsetBicycleCheckbox(){
        if (bicycleCheckBox.isSelected()) bicycleCheckBox.click();
        return this;
    }
    public RegMasterTolPage setPasscarCheckbox(){
        if (!passCarCheckBox.isSelected()) passCarCheckBox.click();
        return this;
    }
    public RegMasterTolPage unsetPasscarCheckbox(){
        if (passCarCheckBox.isSelected()) passCarCheckBox.click();
        return this;
    }
    public RegMasterTolPage setLorryCheckbox(){
        if (!lorryCheckBox.isSelected()) lorryCheckBox.click();
        return this;
    }
    public RegMasterTolPage unsetLorryCheckbox(){
        if (lorryCheckBox.isSelected()) lorryCheckBox.click();
        return this;
    }
    public RegMasterTolPage setMopedCheckbox(){
        if (!mopedCheckBox.isSelected()) mopedCheckBox.click();
        return this;
    }
    public RegMasterTolPage unsetMopedCheckbox(){
        if (mopedCheckBox.isSelected()) mopedCheckBox.click();
        return this;
    }
    public RegMasterTolPage setBusCheckbox(){
        if (!busCheckBox.isSelected()) busCheckBox.click();
        return this;
    }
    public RegMasterTolPage unsetBusCheckbox(){
        if (busCheckBox.isSelected()) busCheckBox.click();
        return this;
    }
    public RegMasterTolPage setMechanicsCheckbox(){
        if (!mechanicsCheckbox.isSelected()) mechanicsCheckbox.click();
        return this;
    }
    public RegMasterTolPage unsetMechanicsCheckbox(){
        if (mechanicsCheckbox.isSelected()) mechanicsCheckbox.click();
        return this;
    }
    public RegMasterTolPage setMountingCheckbox(){
        if (!mountingCheckbox.isSelected()) mountingCheckbox.click();
        return this;
    }
    public RegMasterTolPage unsetMountingCheckbox(){
        if (mountingCheckbox.isSelected()) mountingCheckbox.click();
        return this;
    }
    public RegMasterTolPage setCarwashCheckbox(){
        if (!carwashCheckbox.isSelected()) carwashCheckbox.click();
        return this;
    }
    public RegMasterTolPage unsetCarwashCheckbox(){
        if (carwashCheckbox.isSelected()) carwashCheckbox.click();
        return this;
    }
    public RegMasterTolPage setTowtracksCheckbox(){
        if (!towtrucksCheckbox.isSelected()) towtrucksCheckbox.click();
        return this;
    }
    public RegMasterTolPage unsetTowtracsCheckbox() {
        if (towtrucksCheckbox.isSelected()) towtrucksCheckbox.click();
        return this;
    }
    public RegMasterTolPage fillNameManager(String name){
        setElementText(nameManagerTextBox, name);
        return this;
    }
    public RegMasterTolPage fillTelManager(String telephone){
        setElementText(telManagerTextBox, telephone);
        return this;
    }
    public RegMasterTolPage fillDirector(String name){
        setElementText(directorTextBox, name);
        return this;
    }
    public RegMasterTolPage clickSubmit(){
        clickElement(submitMasterButton);
        return this;
    }
    public RegMasterTolPage selectVehicle(String name){
        selectValueInDropdownbyText(vehicleDropBox, name);
        return this;
    }
    public RegMasterTolPage clickAddcar(){
        clickElement(addCarButton);
        return this;
    }
}

