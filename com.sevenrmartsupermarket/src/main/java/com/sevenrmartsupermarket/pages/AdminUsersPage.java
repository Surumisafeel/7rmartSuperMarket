package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "//li[18]//a[@class=' nav-link']//i[1]")
	private WebElement adminUsersElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']//i[@class='fas fa-edit']")
	private WebElement adminUsersNewButton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameElement;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordElement;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypeElement;
	@FindBy(xpath = "//div[@class='card-footer center']//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	private WebElement userNameSearch;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	private WebElement searchButtoninsideSearchBox;
	@FindBy(xpath = "//tbody//tr//td")
	private WebElement userNameResult;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlert;
	@FindBy(xpath = "//img[@class='img-circle']")
	private WebElement adminRight;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	private WebElement logout;
	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement adminLeft;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * method to click on adminusers
	 */
	public void clickOnAdminUsers() {

		adminUsersElement.click();
	}

	/**
	 * method to click on add new admin user button
	 */
	public void clickOnAdminUsersNewButton() {
		adminUsersNewButton.click();
	}

	/**
	 * method to input username
	 * 
	 * @param userName
	 */
	public void inputUserName(String userName) {
		userNameElement.sendKeys(userName);

	}

	/**
	 * method to input password
	 */
	public void inputPassword(String password) {
		passwordElement.sendKeys(password);

	}

	/**
	 * method to create new user
	 * 
	 * @param userName
	 * @param password
	 * @param UserType
	 */
	public void createUser(String userName, String password, String UserType) {
		pageutility = new PageUtility(driver);
		clickOnAdminUsersNewButton();
		inputUserName(userName);
		inputPassword(password);
		pageutility.select_ByVisibleText(UserType, userTypeElement);
		clickOnSaveButton();
	}

	/**
	 * method to click on save button from admin user add page
	 */
	public void clickOnSaveButton() {
		saveButton.click();
	}

	/**
	 * method to get success alert after user addition
	 * 
	 * @return
	 */
	public String getSuccessAlert() {

		return successAlert.getText();

	}

	/**
	 * method to search user
	 */
	public void searchForAuser(String user) {
		searchButton.click();
		userNameSearch.sendKeys(user);
		searchButtoninsideSearchBox.click();

	}

	/**
	 * method to get user search resut text
	 * 
	 * @return
	 */
	public String getResultText() {
		String userNameSearchResult = userNameResult.getText();
		return userNameSearchResult;

	}

	public void logout() {
		pageutility = new PageUtility(driver);
		adminRight.click();
		logout.click();

	}

	public String getprofileName() {
		String newProfile = adminLeft.getText();
		return newProfile;

	}

}
