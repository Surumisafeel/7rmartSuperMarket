package com.sevenrmartsupermarket.pages;

import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageUsersPage {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-user']")
	private WebElement manageUsers;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	private List<WebElement> nameElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[5]/td[6]/a[1]")
	private WebElement actionLock;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement StatusChangeAlertMessage;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//a[3]")
	private WebElement deleteButtonxpath;
	@FindBy(xpath = "//i[@class=' fa fa-search']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@name='un']")
	private WebElement userNameSearch;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	private WebElement searchButtoninsideSearchBox;

	//// table[@class='table table-bordered table-hover
	//// table-sm']/tbody/tr[5]/td[6]/a[1]
	/**
	 * method to initiate pagefactory
	 * 
	 * @param driver
	 */
	public ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * method to click on manage users
	 */
	public void clickOnManageUsers() {
		manageUsers.click();
	}

	public String clickOnDeactivationButton(String name) {
		generalutility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		List<String> userNames = new ArrayList<String>();
		userNames = generalutility.getTextOfElements(nameElement);
		int i = 0;
		for (i = 0; i < userNames.size(); i++) {
			if (name.equals(userNames.get(i))) {
				i++;
				break;
			}

		}
		WebElement deactiveButton = driver.findElement(
				By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr[" + i + "]/td[6]/a[1]"));
		pageutility.scroll_into_View(deactiveButton);
		pageutility.scrollAndClick(deactiveButton);
		String activeStatusMessage = StatusChangeAlertMessage.getText();
		return activeStatusMessage;
	}

	public String clickOnDeleteUsers(String name) {
		generalutility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		List<String> userNames = new ArrayList<String>();
		userNames = generalutility.getTextOfElements(nameElement);
		int i = 0;
		for (i = 0; i < userNames.size(); i++) {
			if (name.equals(userNames.get(i))) {
				i++;
				break;
			}

		}
		WebElement deleteButtonElement = driver.findElement(By.xpath(
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + i + "]//td[5]//a[3]"));
		//pageutility.scroll_into_View(deleteButtonElement);
		pageutility.scrollAndClick(deleteButtonElement);
		pageutility.alertAccept();
		String deleteStatusMessage = StatusChangeAlertMessage.getText();
		return deleteStatusMessage;
	}

	public void searchForAuser(String name) {
		searchButton.click();
		userNameSearch.sendKeys(name);
		searchButtoninsideSearchBox.click();

	}

}
