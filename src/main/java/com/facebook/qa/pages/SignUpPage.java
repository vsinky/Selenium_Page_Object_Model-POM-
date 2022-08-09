package com.facebook.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.facebook.qa.base.TestBase;

public class SignUpPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"login_link\"]/a[2]")
	WebElement SignupforFacebook;
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@name='reg_email__']")
	WebElement email ;
	
	@FindBy(xpath = "//input[@name='reg_email_confirmation__']")
	WebElement confirmation_email;
	
	@FindBy(xpath ="//input[@name='reg_passwd__']")
	WebElement password;
	
	@FindBy(xpath = "//*[@id='day']")
	WebElement day;
	
	@FindBy(xpath = "//*[@id='month']")
	WebElement month;
	
	@FindBy(xpath = "//*[@id='year']")
	WebElement year;
	
	@FindBy(xpath = "//label[text()='Female']")
	WebElement gender;
	
	@FindBy(xpath ="//button[contains(text(),'Sign')]")
	WebElement signBtn;
	
	// Initializing the Page Objects:
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	public SignUpPage createNewAccount() {
		SignupforFacebook.click();
		return new SignUpPage();
	}
	
	public HomePage signup(String fn, String ln, String em, String rem, String pwd, String d, String m, String y, String g) {
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		email.sendKeys(em);
		confirmation_email.sendKeys(rem);
		password.sendKeys(pwd);
		day.sendKeys(d);
		month.sendKeys(m);
		year.sendKeys(y);
		gender.click();
		signBtn.click();
		
		return new HomePage();
	}
}

