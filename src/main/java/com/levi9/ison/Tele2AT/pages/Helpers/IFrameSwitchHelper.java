package com.levi9.ison.Tele2AT.pages.Helpers;


import com.levi9.ison.pages.BasePage;
import org.openqa.selenium.WebDriver;


/**
 * Created by Vlado on 7/11/2016.
 */
public class IFrameSwitchHelper extends BasePage{


    public void switchIFrame(String value){
        getDriver().switchTo().frame(value);
    }

    public void switchToDefaultFrame(){
        getDriver().switchTo().defaultContent();
    }

    public IFrameSwitchHelper(WebDriver driver){
        super(driver, null, null);
        //PageFactory.initElements(driver, this);
    }

}
