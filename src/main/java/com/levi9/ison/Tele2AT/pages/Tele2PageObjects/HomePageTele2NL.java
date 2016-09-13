package com.levi9.ison.Tele2AT.pages.Tele2PageObjects;

import com.levi9.ison.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



/**
 * Created by Vlado on 7/9/2016.
 */
public class HomePageTele2NL extends BasePage {

    private final static String pageTitle = "Tele2 • Telefonie, Internet & TV";

    //private final static String pageTitle = "aa.com";

    public HomePageTele2NL (WebDriver driver){
        super(driver, pageTitle, null);
    }

    public void getHeaderMobiel(){
        WebElement mobiel = getDriver().findElement(By.id("mobiel"));
        mobiel.click();
    }

    public void getSimOnlyPage(){
        getDriver().findElement(By.xpath(".//a[contains(., 'Sim Only')]")).click();
    }

    public void getCatalogPage(){
        getDriver().findElement(By.xpath("//a[contains(., 'Abonnement met telefoon')] "));
    }

    public void getPrepaidPage(){
        getDriver().findElement(By.xpath("//a[contains(., 'Prepaid')] "));
    }

    public void clickSearch(){
        getDriver().findElement(By.name("localeSubmit")).click();
        //getDriver().findElement(By.name("btnG")).click();

    }







}
