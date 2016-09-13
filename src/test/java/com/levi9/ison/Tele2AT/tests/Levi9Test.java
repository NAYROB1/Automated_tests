package com.levi9.ison.Tele2AT.tests;

import java.util.concurrent.TimeoutException;

import org.testng.annotations.*;

import com.levi9.ison.Tele2AT.pages.Levi9Home;

import com.levi9.ison.helpers.WaitHelper;
import com.levi9.ison.tests.BaseTest;

public class Levi9Test extends BaseTest { 
	
	/** The url. */
	private static final String URL = "http://www.levi9.com/";

	/** The levi9 home. */
	private Levi9Home levi9Home; 

	/* (non-Javadoc)
	 * @see com.levi9.testautomation.ison.tests.BaseTest#setUp()
	 */
	@BeforeMethod
	@Parameters({"profile"})
	public void SetUp(@Optional String profile) {
		super.setUp(profile);
		levi9Home = new Levi9Home(getDriver());
	}

	/**
	 * Test.
	 *
	 * @throws TimeoutException the timeout exception
	 */
	@Test
	public void test() throws TimeoutException {
		levi9Home.open(URL);
		WaitHelper.waitAdditional(3);
	}

	/**
	 * Tear down.
	 */
	@AfterMethod
	public void closeDriver() throws Exception {
		//super.tearDown();
	}
}