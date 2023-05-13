package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageUsersPage;

public class ManageUsersTest extends Base {
	HomePage homePage;
	LoginPage loginpage;
	ManageUsersPage manageruserpage;

	@Test(groups = "smoke")
	public void verifyStatusChangeofUser() {
		loginpage = new LoginPage(driver);
		manageruserpage = new ManageUsersPage(driver);
		loginpage.loginUtility();
		manageruserpage.clickOnManageUsers();
		String actualStatusAlert= manageruserpage.clickOnDeactivationButton("CIJIN SJ");
		String expectedStatusAlert ="×\r\n"
				+ "Alert!\r\n"
				+ "User Status Changed Successfully";
		Assert.assertEquals(actualStatusAlert, expectedStatusAlert);
	}
	@Test(groups= {"sanity","smoke"})
	public void verifyUserDeletion() {
		loginpage = new LoginPage(driver);
		manageruserpage = new ManageUsersPage(driver);
		loginpage.loginUtility();
		manageruserpage.clickOnManageUsers();
		String actuallDeleteStatus= manageruserpage.clickOnDeleteUsers("CIJIN SJ");
		manageruserpage.searchForAuser("CIJIN SJ");
		String expectedDeleteStatus ="User deleted Successfully";
		Assert.assertEquals(actuallDeleteStatus, expectedDeleteStatus);
	}
	//xpath taken for admin users chhange it to manageusers
}
