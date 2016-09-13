package com.levi9.ison.Tele2AT.tests;


import com.levi9.ison.Tele2AT.pages.Enums.PageLinks;
import com.levi9.ison.Tele2AT.pages.Tele2PageObjects.CatalogPage;
import com.levi9.ison.Tele2AT.pages.Tele2PageObjects.HandsetPage;
import com.levi9.ison.Tele2AT.pages.Tele2PageObjects.PrepaidPage;
import com.levi9.ison.Tele2AT.pages.Tele2PageObjects.SimOnlyPage;
import com.levi9.ison.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeoutException;

/**
 * Created by Vlado on 7/6/2016.
 *
 * Test class for Catalog page on Tele2.nl flow
 */
public class TestClass extends BaseTest {

    public final static String titleSimOnly = "Sim Only abonnement • € 9 per maand bij Tele2";
    public final static String titleCatalogPage = "Smartphones • Vind de beste smartphone deals bij Tele2";
    public final static String titleSimOnlyPrepaid = "Sim Only Prepaid + € 20 gratis beltegoed van Tele2";

    private SimOnlyPage sop;
    private CatalogPage cp;
    private PrepaidPage prepaidSimOnlyPage;
    private HandsetPage hsp;


    @BeforeMethod
    @Parameters({"profile"})
    public void SetUp(@Optional String profile){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vlado\\Desktop\\chrom\\chromedriver.exe");
        super.setUp(profile);
        getDriver().manage().window().maximize();
        sop = new SimOnlyPage(getDriver());
        cp = new CatalogPage(getDriver());
        hsp = new HandsetPage(getDriver());
        prepaidSimOnlyPage = new PrepaidPage(getDriver());
    }

//    /**
//     * Method for teting Sim Only Page load
//     * @throws TimeoutException
//     */
//    @Test
//    public void SimOnlyPageLoadTest() throws TimeoutException{
//        sop.open(PageLinks.SimOnlyPageURL.getPageLinkValue());
//        sop.waitForPageToLoad();
//        Assert.assertEquals(sop.getTitle(), titleSimOnly, "This is not correct page");
//    }
//
//    /**
//     * Method for testing Catalog Page load
//     * @throws TimeoutException
//     */
//    @Test
//    public void CatalogPageLoadTest() throws TimeoutException{
//        cp.openCatalogPage();
//        cp.waitForPageToLoad();
//        Assert.assertEquals(cp.getTitle(), titleCatalogPage, "This is not correct page");
//    }
//
//    /**
//     * Method for testing Sim Only Prepaid Page load
//     * @throws TimeoutException
//     */
//    @Test
//    public void SimOnlyPrepaidPageLoadTest() throws TimeoutException{
//        prepaidSimOnlyPage.open(PageLinks.prepaidSimPageURL.getPageLinkValue());
//        prepaidSimOnlyPage.waitForPageToLoad();
//        Assert.assertEquals(prepaidSimOnlyPage.getTitle(), titleSimOnlyPrepaid, "This is not correct page");
//    }
//
//    /**
//     * Method for checking if correct static block is displayed on Catalog page
//     * @throws Exception
//     */
//    @Test
//    public void CorrectStaticTextVisibleCatalogPage() throws Exception{
//        cp.openCatalogPage();
//        Assert.assertEquals(cp.staticText1.isDisplayed(), true, "Static text should be: Het nieuwste 4G-netwerk van Nederland");
//        Assert.assertEquals(cp.staticText2.isDisplayed(), true, "Static text should be: Alleen de beste smartphone topdeals");
//        Assert.assertEquals(cp.staticText3.isDisplayed(), true, "Static text should be: Gratis nummerbehoud");
//        Assert.assertEquals(cp.handsetCount() + " Telefoons gevonden", "35 Telefoons gevonden", "Number of devices should be: 35 Telefoons gevonden");
//        Assert.assertEquals(cp.staticText4.isDisplayed(), true, "Static text should be: Telefoons met abonnement");
//    }
//
//    /**
//     * Method for testing if Catalog page contains number of handset static text
//     */
//    @Test
//    public void NumberOfDevicesOnCatalogPageStaticTextTest(){
//        cp.openCatalogPage();
//        cp.handsetCount();
//    }

    /**
     * Method for testing the click on Random handset present on Catalog page
     */
    @Test
    public void clickRandomHandsetTest(){
        cp.openCatalogPage();
        cp.clickRandomHandset();
        hsp.waitForPageToLoad();
        System.out.println("Device page title: " + hsp.getTitle());
        System.out.println("Device page handset: " + hsp.getDeviceName());
        Assert.assertEquals(hsp.getDeviceName(), cp.getHandsetTitleTrim(), "Device name is not correct!");
    }


    @AfterTest
    public void closeDriver() throws  Exception{
        super.tearDown();
    }
//    @AfterMethod
//    public void closeDriver() throws Exception{
//        super.tearDown();
//    }
}
/*

 */