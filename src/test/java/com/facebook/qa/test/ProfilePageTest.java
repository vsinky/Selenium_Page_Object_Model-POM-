package com.facebook.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;
import com.facebook.qa.pages.ProfilePage;

public class ProfilePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	public ProfilePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		profilePage = new ProfilePage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Log in to Facebook");
	}
	@Test(priority=2)
	public void verifyProfilePageTest() {
		profilePage = homePage.clickOnprofilePage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
