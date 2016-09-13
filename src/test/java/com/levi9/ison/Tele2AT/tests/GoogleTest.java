package com.levi9.ison.Tele2AT.tests;

import org.testng.annotations.*;

import com.levi9.ison.Tele2AT.pages.GoogleHome;

import com.levi9.ison.tests.BaseTest;

public class GoogleTest extends BaseTest {
	private GoogleHome googleHome;
	private static final String URL = "http://www.google.com";

	@BeforeMethod
	@Parameters({"profile"})
	public void SetUp(@Optional String profile){
		//initialize environment, webdriver
		super.setUp(profile);
		//create an instance of page, in this case GoogleHome page
		googleHome = new GoogleHome(getDriver());
	}
	
	@Test
	public void google() {
		//go to google home page (URL is already set in GoogleHome page class)
		googleHome.open(URL);
		//call method from GoogleHome page class which will enter "test" in the main search form
		googleHome.enterSearchForm("test");
	}
	
	@AfterMethod
	public void closeDriver() throws Exception {
		//super.tearDown();
	}
}
