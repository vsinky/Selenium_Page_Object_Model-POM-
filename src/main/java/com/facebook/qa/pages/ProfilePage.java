package com.facebook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.TestBase;

public class ProfilePage extends TestBase {
	@FindBy(xpath = "//span[contains(text(),'Sinky Verma')]")
	WebElement profilePage;

	@FindBy(xpath = "//span[text()='Find Friends']")
	WebElement findFriendsLink;

	@FindBy(xpath = "//a[contains(@href,'/notifications/')]")
	WebElement NotificationsLink;

	@FindBy(xpath = "//a[contains(@href,'/groups/')]")
	WebElement groupsLink;

	@FindBy(xpath = "//span[contains(text(),'See All Photos')]")
	WebElement seeAllPhotosLink;

	
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
	     return driver.getTitle();
	    		 
	}
	public boolean verifyUsername() {
		return profilePage.isDisplayed();
	}
	public HomePage ClickOnFindFriendsLink() {
		findFriendsLink.click();
		return new HomePage();
	}

	public ProfilePage clickOnprofilePage() {
		profilePage.click();
		return new ProfilePage();
	}
	public ProfilePage seeAllPhotos() {
		profilePage.click();
	 seeAllPhotosLink.click();
	 return new ProfilePage();
	}

}
