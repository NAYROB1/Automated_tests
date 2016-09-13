package com.levi9.ison.Tele2AT.pages.Tele2PageObjects;

import com.levi9.ison.Tele2AT.pages.Enums.PageLinks;
import com.levi9.ison.helpers.WaitHelper;
import com.levi9.ison.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Vlado on 7/10/2016.
 */
public class HandsetPage extends BasePage{

    HandsetPage hsp;
    CatalogPage cp;

    public final static String pageTitle = " + Abonnement van Tele2";

    @FindBy(how = How.XPATH, using = ".//*[@class='white-box']/h4")
    private WebElement deviceNameText;

    @FindBy(how = How.XPATH, using = ".//*[@class='tele2-slider product-slider double']")
    private WebElement imageContainer;

    public HandsetPage(WebDriver driver){
        super(driver, pageTitle, null);
        PageFactory.initElements(driver, this);
    }

    public String getDeviceName(){
        return deviceNameText.getText();
    }

    public boolean imageIsPresent(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='tele2-slider product-slider double']")));

        return imageContainer.isDisplayed();
    }

    public void waiter(){


    }










}
