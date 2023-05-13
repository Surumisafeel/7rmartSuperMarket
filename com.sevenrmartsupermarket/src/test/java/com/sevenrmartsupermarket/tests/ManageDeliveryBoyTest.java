package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.base.DataProviders;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageDeliveryBoyTest extends Base {
	HomePage homePage;
	LoginPage loginPage;
	ManageDeliveryBoyPage managedeliveryboypage;

	@Test(dataProvider = "New Delivery boy user creation data", dataProviderClass = DataProviders.class)

	public void verifyDeliveryBoyNewUserCreationWithdataProvidersFromExcel(String name, String emaiId,
			String phoneNumber, String address, String userName, String password) {
		// homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginPage.loginUtility();
		managedeliveryboypage.clickOnManageDeliveryBoy();
		name = "Surumi" + GeneralUtility.getTimeStamp();
		userName = "Surumi" + GeneralUtility.getTimeStamp();
		managedeliveryboypage.createUser(name, emaiId, phoneNumber, address, userName, password);
		boolean actualAlert = managedeliveryboypage.getResultText();
		Assert.assertEquals(actualAlert, true);
	}

	@Test(dataProvider = "New user creation data", dataProviderClass = DataProviders.class)

	public void verifyDeliveryBoyUserCreationWithdataProviders(String name, String emaiId, String phoneNumber,
			String address, String userName, String password) {
		// homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginPage.loginUtility();
		managedeliveryboypage.clickOnManageDeliveryBoy();
		name = "Surumi" + GeneralUtility.getTimeStamp();
		userName = "Surumi" + GeneralUtility.getTimeStamp();
		managedeliveryboypage.createUser(name, emaiId, emaiId, address, userName, password);
		boolean actualAlert = managedeliveryboypage.getResultText();
		boolean expectedAlert = true;
		Assert.assertEquals(actualAlert, expectedAlert);
	}

	@Test

	public void verifyDeliveryBoyUserCreation() {
		// homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginPage.loginUtility();
		managedeliveryboypage.clickOnManageDeliveryBoy();
		String name = "Surumi" + GeneralUtility.getTimeStamp();
		String userName = "Surumi" + GeneralUtility.getTimeStamp();
		managedeliveryboypage.createUser(name, "test@test.com", "90090", "addressTest", userName, "testPass");
		boolean actualAlert = managedeliveryboypage.getResultText();
		boolean expectedAlert = true;
		Assert.assertEquals(actualAlert, expectedAlert);
	}

}
