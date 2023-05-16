package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.base.DataProviders;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUsersTest extends Base {
	HomePage homePage;
	LoginPage loginPage;
	AdminUsersPage adminuserspage;

	@Test(dataProvider = "Admin user creation data",dataProviderClass = DataProviders.class)

	public void verifyUserProfileWithDataProvider(String userName, String password, String userType) {
		// homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.loginUtility();
		adminuserspage.clickOnAdminUsers();
		userName = "Surumi" + GeneralUtility.getTimeStamp();
		adminuserspage.createUser(userName, password, userType);
		String newlyUser =userName;
		String newlyPassword=password;
		adminuserspage.logout();
		loginPage.loginUtility(newlyUser, newlyPassword);
		String actualProfileName= adminuserspage.getprofileName();
		System.out.println(actualProfileName);
		String expectedProfileName=userName;
		System.out.println(expectedProfileName);
		Assert.assertEquals(actualProfileName, expectedProfileName);
		

	}

	@Test

	public void verifyUserCreation() {
		// homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.loginUtility();
		adminuserspage.clickOnAdminUsers();
		String user = "Surumi" + GeneralUtility.getTimeStamp();
		adminuserspage.createUser(user, "admin", "Staff");

	}

	@Test
	public void verifyUserSearchResult() {
		loginPage = new LoginPage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.loginUtility();
		adminuserspage.clickOnAdminUsers();
		String user="Lauryn Stiedemann Boyer";
		adminuserspage.searchForAuser(user);
		String actualUserNameSearchResult = adminuserspage.getResultText();
		String expectedUserNameSearchResult = "saj";
		Assert.assertEquals(actualUserNameSearchResult, expectedUserNameSearchResult);

	}

	@Test
	public void verifyUserCreationMessage() {
		loginPage = new LoginPage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginPage.loginUtility();
		adminuserspage.clickOnAdminUsers();
		adminuserspage.createUser("Mehrin", "admin", "Staff");
		String actualUserCreationMessage = adminuserspage.getSuccessAlert();
		String expectedUserCreationMessage = "User Created Successfully";
		Assert.assertEquals(actualUserCreationMessage, expectedUserCreationMessage);

	}
}
