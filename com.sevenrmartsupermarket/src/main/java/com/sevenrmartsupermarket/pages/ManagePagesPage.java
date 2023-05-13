package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManagePagesPage {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;
	@FindBy(xpath = "//p[contains(text(),'Manage Content')]")
	private WebElement manageContent;
	@FindBy(xpath = "//p[contains(text(),'Manage Pages')]")
	private WebElement managePage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement managePageNewButton;
	
	@FindBy(xpath = "//input[@placeholder='Enter the Title']")
	private WebElement eneterTitle;
	
	@FindBy(xpath = "//div[@class='note-editable card-block']")
	private WebElement description;
	@FindBy(xpath = "//input[@placeholder='Enter Page Name']")
	private WebElement enterPageName;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//input[@name='main_img']")
	private WebElement imageUploadElement;
	
	

	
	public ManagePagesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnManagePages() {
		manageContent.click();
		managePage.click();
	}
	/**
	 * method to click on new button
	 */
	public void clickOnNewButton() {
		managePageNewButton.click();
	}
	
	public void inputTitle(String title) {
		eneterTitle.sendKeys(title);

	}
	public void inputDescription(String description) {
		eneterTitle.sendKeys(description);

	}
	
	public void inputenterPageName(String pageName) {
		enterPageName.sendKeys(pageName);

	}
	public void clickOnSaveButton() {
		saveButton.click();
	}
	public void uploadPageContentImage(String imageName) {
		pageutility= new PageUtility(driver);
		pageutility.uploadFile(imageUploadElement, imageName);		
	}
	
	public void addPageContent(String title, String description, String pageName, String imageName) {
		clickOnNewButton();
		inputTitle(title);
		inputDescription(description);
		inputenterPageName(pageName);
		uploadPageContentImage(imageName);
		clickOnSaveButton();
		
	}
}
