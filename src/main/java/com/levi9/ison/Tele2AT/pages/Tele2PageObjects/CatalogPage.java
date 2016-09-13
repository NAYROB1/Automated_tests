package com.levi9.ison.Tele2AT.pages.Tele2PageObjects;

import com.levi9.ison.Tele2AT.pages.Enums.PageLinks;
import com.levi9.ison.Tele2AT.pages.Helpers.IFrameSwitchHelper;
import com.levi9.ison.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

/**
 * Created by Vlado on 7/9/2016.
 *
 * Page Object class for Catalog page
 */
public class CatalogPage extends BasePage {

    public final static String pageTitle = "Smartphones • Vind de beste smartphone deals bij Tele2";

    CatalogPage cp;
    Actions actions = new Actions(getDriver());
    IFrameSwitchHelper ifr = new IFrameSwitchHelper(getDriver());

    @FindBy(how = How.XPATH, using = ".//h5[contains(.,'Het nieuwste 4G-netwerk van Nederland')]")
    public WebElement staticText1;

    @FindBy(how = How.XPATH, using = ".//h5[contains(.,'Alleen de beste smartphone topdeals')]")
    public WebElement staticText2;

    @FindBy(how = How.XPATH, using = ".//h5[contains(.,'Gratis nummerbehoud')]")
    public WebElement staticText3;

    @FindBy(how = How.XPATH, using = ".//h4[contains(.,'Telefoons met abonnement')]")
    public WebElement staticText4;

    @FindBy(how = How.ID, using = "allAbonnementPhones")
    private WebElement showAllHandsetsButton;

    @FindBy(how = How.ID, using = "buttonAccept")
    private WebElement acceptCookie;

    private String hs;

    /**
     * Method for closing the cookie bar
     */
    public void closeCookieBar(){
        ifr.switchIFrame("qb_cookie_consent_main");
        getAcceptCookie().click();
        ifr.switchToDefaultFrame();
    }

    public CatalogPage(WebDriver driver){
        super(driver, pageTitle, null);
        PageFactory.initElements(driver, this);
    }

    public WebElement getAcceptCookie(){
        return acceptCookie;
    }

    /**
     * Method for creating Catalog page driver and opening the catalog page
     */
    public void openCatalogPage(){
        cp = new CatalogPage(getDriver());
        cp.open(PageLinks.catalogPageURL.getPageLinkValue());
        cp.waitForPageToLoad();
        closeCookieBar();
    }

    /**
     * Method for click on "Alle telephons met Abonnement" button
     */
    public void showAllHandsets(){
        showAllHandsetsButton.click();
    }

    /**
     * Method for fetching all handsets on catalog page
     * @return handsets;
     */
    public List<WebElement> getHandsetList(){
        List<WebElement> handsets = getDriver().findElements(By.xpath(".//*[@id='abonnementPhonesWrapper']/div/div"));
        //System.out.println(handsets.toString());
        //System.out.println(handsets.size());
        return handsets;
    }

    /**
     * Method for counting handsets on catalog page
     * @return number of devices on catalog page
     */
    public int handsetCount(){
        System.out.println(getHandsetList().size());
        return getHandsetList().size();
    }

    public String getHandsetTitleTrim(){
        return hs;
    }

    /**
     * Method for clicking on Radnom Handset on catalog page
     * @return HandsetPage;
     */
    public HandsetPage clickRandomHandset(){
        Random r = new Random();
        int ranNum = r.nextInt(handsetCount());
        showAllHandsets();
        WebElement handset = getHandsetList().get(ranNum);
        hs = handset.getText().substring(0, handset.getText().length()-15);
        System.out.println("Catalog page clicked handset: " +  hs);
        actions.moveToElement(handset).click().perform();
        return new HandsetPage(getDriver());
    }
}
