package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class PushNotificationPage {
	WebDriver driver;
	GeneralUtility generalUtility;
	PageUtility pageUtility;
	LoginPage loginPage;

	@FindBy(xpath = "//i[@class='nav-icon fas fa-fas fa-bell']")
	private WebElement pushNotification;

	public PushNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * method to clcik on push notification page
	 */
	public void clickOnPushNotification() {
		pushNotification.click();
	}

}
