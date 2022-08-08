package com.facebook.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.facebook.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
    public static Properties prop;

public TestBase() {
	try {
		prop = new Properties();
		FileInputStream  ip = new FileInputStream("E:\\Automation\\Page_Object_Model_Selenium\\src\\main\\java\\com\\facebook\\qa\\config\\Config.properties");
		prop.load(ip);	
	}catch(FileNotFoundException e) {
		e.printStackTrace();	
	}catch (IOException e) {
		e.printStackTrace();
	}
}

public static void initialization(){
	String browserName = prop.getProperty("browser");
if(browserName.equals("firefox")){
	System.setProperty("webdriver.gecko.driver","C:\\Users\\Admin\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	driver = new FirefoxDriver(); 
}
else if(browserName.equals("chrome")){
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
	}

driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

driver.get(prop.getProperty("url"));
}
}
