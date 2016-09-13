package com.levi9.ison.Tele2AT.tests;

import com.levi9.ison.Tele2AT.pages.Tele2PageObjects.CatalogPage;
import com.levi9.ison.Tele2AT.pages.Tele2PageObjects.HandsetPage;
import com.levi9.ison.Tele2AT.pages.Tele2PageObjects.PrepaidPage;
import com.levi9.ison.Tele2AT.pages.Tele2PageObjects.SimOnlyPage;
import com.levi9.ison.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Vlado on 7/24/2016.
 */
public class HandsetPageTest extends BaseTest{

    private SimOnlyPage sop;
    private CatalogPage cp;
    private PrepaidPage prepaidSimOnlyPage;
    private HandsetPage hsp;

    @BeforeTest
    @Parameters({"profile"})
    public void SetUp(@Optional String profile){
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vlado\\Desktop\\chrom\\chromedriver.exe");
        super.setUp(profile);
        getDriver().manage().window().maximize();
        sop = new SimOnlyPage(getDriver());
        cp = new CatalogPage(getDriver());
        hsp = new HandsetPage(getDriver());
        prepaidSimOnlyPage = new PrepaidPage(getDriver());
    }

    @Test
    public void imageIsPresent(){
        cp.openCatalogPage();
        cp.clickRandomHandset();
        hsp.waitForPageToLoad();

        hsp.imageIsPresent();
        Assert.assertEquals(hsp.imageIsPresent(), true, "Not present!");
    }




    @AfterMethod
    public void closeDriver() throws Exception{
        super.tearDown();
    }


}
