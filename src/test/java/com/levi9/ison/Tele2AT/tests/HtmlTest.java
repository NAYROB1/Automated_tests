package com.levi9.ison.Tele2AT.tests;

import org.testng.annotations.*;

import com.levi9.ison.Tele2AT.pages.HtmlPage;

import com.levi9.ison.tests.BaseTest;

public class HtmlTest extends BaseTest{
	private HtmlPage gsp;
	private static final String URL = "http://www.w3schools.com/html/html_forms.asp";
	
	@BeforeMethod
	@Parameters({"profile"})
	public void SetUp(@Optional String profile) {
		super.setUp(profile);
		gsp = new HtmlPage(getDriver());
	}
	
	@Test
	public void test() {
		gsp.open(URL);
		gsp.enterSearchForm("da");
		gsp.submitSearch();
	}
	
	@AfterMethod
	public void closeDriver() throws Exception {
		//super.tearDown();

	}
}
