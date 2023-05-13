package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.ScreenShot;

public class LoginTest extends Base {
	LoginPage loginPage;
	ExcelReader excelReader = new ExcelReader();
	ScreenShot screenShot;

	// loginPage = new LoginPage(driver);

	@Test
	public void verify7rmartSurperMarketLogo() {

	}

	@Test
	public void verifyLoginFunctionality() {
		loginPage = new LoginPage(driver);
		screenShot = new ScreenShot();
		loginPage.loginUtility();
		//String expectedProfileName = "Admin";
		String expectedProfileName = Constants.EXPECTEDERRORMEASSAGE;
		String actualProfileName = loginPage.getProfileText();
		//screenShot.takeScreenshot(driver, "Surumi");
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}

	@Test(groups="smoke")
	public void verifyInvalidLoginErrorMessage() {
		loginPage = new LoginPage(driver);

		excelReader.setExcelFile("LoginData", "InvalidLoginCredentials");
		String userName = excelReader.getCellData(0, 0);
		String password = excelReader.getCellData(0, 1);

		loginPage.loginUtility(userName, password);
		String expectedErrorMessage = "×\r\n" + "Alert!\r\n" + "Invalid Username/Password";
		String actualErrorMessage = loginPage.getErrorMessageText();
		System.out.println("Actual Error Message is" + actualErrorMessage);
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}

	@Test(groups="sanity)")
	public void verifyRememberMeisSelected() {
		loginPage = new LoginPage(driver);
		boolean actualResult = loginPage.isRememberMecheckboxSelected();
		Assert.assertTrue(actualResult);

	}

	@Test
	public void verifySignInButtonisDisplayed() {
		loginPage = new LoginPage(driver);
		boolean actualResult = loginPage.isSignInButtonisDisplayed();
		Assert.assertTrue(actualResult);

	}
}
