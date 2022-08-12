package com.facebook.qa.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;
import com.facebook.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
    LoginPage loginPage;
	HomePage homePage;
    TestUtil testUtil;

	String sheetName = "loginPage";
	Logger log = Logger.getLogger(LoginPageTest.class);
	
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
	
@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	} 

@Test (dataProvider="getTestData")
public void loginTest(String uname,String pwd) throws InterruptedException {
	//loginPage.validatLoginPageTitle();
	loginPage.login(uname,pwd);
	Thread.sleep(2000);
	log.info("login successful with username: " +uname);

}
	
	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
		log.info("browser is closed");
	}
	} 
	
	
	
	
	 

