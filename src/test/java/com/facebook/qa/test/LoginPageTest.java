package com.facebook.qa.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
    LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test (priority=1)
	public void LoginPageTitle() {
		String title = loginPage.validatLoginPageTitle();
		Assert.assertEquals(title, "Log in to Facebook");
	}
	
	@Test (priority=2)
	public void loginTest() {
		loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
	
	}
	
	
	
	
	 

