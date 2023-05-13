package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;
	@FindBy(xpath = "(//a[@class=' nav-link'])[8]")
	private WebElement manageDeliveryBoy;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement ManageDeliveryBoyNewButton;
	@FindBy(xpath = "//input[@placeholder='Enter the Name']")
	private WebElement eneterDeliveryBoyName;
	@FindBy(xpath = "//input[@placeholder='Enter the Email']")
	private WebElement eneterDeliveryBoyEmailId;
	@FindBy(xpath = "//input[@placeholder='Enter the Phone Number']")
	private WebElement eneterDeliveryBoyPhoneNumber;
	@FindBy(xpath = "//textarea[@placeholder='Enter the Address']")
	private WebElement eneterDeliveryBoyAddress;
	@FindBy(xpath = "//input[@placeholder='Enter the Username']")
	private WebElement eneterDeliveryBoyUserName;
	@FindBy(xpath = "//input[@placeholder='Enter the Password']")
	private WebElement eneterDeliveryBoypassword;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement deliveryBoyCreationresult;

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * method to click on Manage Delivery Boy page
	 */
	public void clickOnManageDeliveryBoy() {
		manageDeliveryBoy.click();
	}

	/**
	 * method to click on new button
	 */
	public void clickOnNewButton() {
		ManageDeliveryBoyNewButton.click();
	}

	/**
	 * method to input name
	 */
	public void inputName(String name) {
		eneterDeliveryBoyName.sendKeys(name);

	}

	/**
	 * method to input EmailId
	 */
	public void inputEmaiId(String emailId) {
		eneterDeliveryBoyEmailId.sendKeys(emailId);

	}

	/**
	 * method to input phone number
	 */
	public void inputPhoneNumber(String phonenUmber) {
		eneterDeliveryBoyPhoneNumber.sendKeys(phonenUmber);

	}

	/**
	 * method to input adress
	 */
	public void inputAddress(String address) {
		eneterDeliveryBoyAddress.sendKeys(address);

	}

	/**
	 * method to input username
	 */
	public void inputUserName(String userName) {
		eneterDeliveryBoyUserName.sendKeys(userName);

	}

	/**
	 * method to input password
	 */
	public void inputPassword(String password) {
		eneterDeliveryBoypassword.sendKeys(password);

	}

	/**
	 * method to click on save button from admin user add page
	 */
	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void createUser(String name, String emaiId, String phoneNumber, String address, String userName,
			String password) {
		pageutility = new PageUtility(driver);
		clickOnManageDeliveryBoy();
		clickOnNewButton();
		inputName(name);
		inputEmaiId(emaiId);
		inputPhoneNumber(phoneNumber);
		inputAddress(address);
		inputUserName(userName);
		inputPassword(password);
		pageutility.scrollAndClick(saveButton);
		// clickOnSaveButton();
	}

	public boolean getResultText() {
		String deliveryBoyCreationAlert = deliveryBoyCreationresult.getText();
		if (deliveryBoyCreationAlert.contains("Delivery Boy Details Created Successfully"))
			return true;

		else
			return false;

	}

}
