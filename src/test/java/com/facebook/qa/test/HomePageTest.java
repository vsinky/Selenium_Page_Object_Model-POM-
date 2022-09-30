package com.facebook.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;
import com.facebook.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	Logger log = Logger.getLogger(HomePageTest.class);
    
	public HomePageTest() {
		super();
}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		//notificationPage = new NotificationsPage();
	    homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));	
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
	  String homePageTitle = homePage.verifyHomePageTitle();
	  Assert.assertEquals(homePageTitle, "Facebook");
	  
	}
	
	@Test(priority = 2)
	public void verifyUsernameTest() {
	Assert.assertTrue(homePage.verifyUsername());	
	log.info("verify username test: ");
}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}