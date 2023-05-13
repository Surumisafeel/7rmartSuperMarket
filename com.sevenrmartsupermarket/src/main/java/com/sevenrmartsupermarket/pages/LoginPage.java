package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

import net.bytebuddy.asm.Advice.Enter;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();
	FileInputStream fileinputstream;
	GeneralUtility generalUtility;
	PageUtility pageUtility;
	@CacheLookup
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameElement;
	@CacheLookup
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordElement;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement signinButton;
	@FindBy(xpath = "//div[@class='info']")
	private WebElement profileName;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement loginErrorMessage;
	@FindBy(xpath = "//input[@id='remember']")
	private WebElement remeberMeCheckbox;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			fileinputstream = new FileInputStream(Constants.CONFIG_FILE_PATH);

			properties.load(fileinputstream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * method to send userName
	 * 
	 * @return String
	 */
	public void enterUserName(String userName) {
		userNameElement.sendKeys(userName);
	}

	/**
	 * method to send password
	 * 
	 * @return String
	 */
	public void enterPassword(String password) {
		passwordElement.sendKeys(password);
	}

	public void clickOnSignInButton() {
		signinButton.click();
	}

	/**
	 * parameterized method to login to application
	 * 
	 * @return String
	 */
	public void loginUtility(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}

	/**
	 * method to login to application
	 */
	public void loginUtility() {
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}

	/**
	 * method to read profile name
	 * 
	 * @return String
	 */
	public String getProfileText() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.get_TextOfElement(profileName);
	}

	/**
	 * method to read Error Message
	 * 
	 * @return String
	 */
	public String getErrorMessageText() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.get_TextOfElement(loginErrorMessage);
	}

	/**
	 * method to check rememberMechackBox is selected
	 * 
	 * @return boolean
	 */
	public boolean isRememberMecheckboxSelected() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.is_Selected(remeberMeCheckbox);
	}

	/**
	 * method to check SignIn button is displayed
	 * 
	 * @return boolean
	 */
	public boolean isSignInButtonisDisplayed() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.is_Displayed(signinButton);
	}

}
