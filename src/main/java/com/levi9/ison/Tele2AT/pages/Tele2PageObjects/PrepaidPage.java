package com.levi9.ison.Tele2AT.pages.Tele2PageObjects;

import com.levi9.ison.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Vlado on 7/9/2016.
 */
public class PrepaidPage extends BasePage {

    public final static String pageTitle = "Sim Only Prepaid + € 20 gratis beltegoed van Tele2";

    public PrepaidPage(WebDriver driver){
        super(driver, pageTitle, null);
        PageFactory.initElements(driver, this);
    }
}
