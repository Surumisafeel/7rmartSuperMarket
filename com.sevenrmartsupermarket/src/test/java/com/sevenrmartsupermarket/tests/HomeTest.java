package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class HomeTest extends Base {
	HomePage homePage;
	LoginPage loginPage;

	@Test
	public void verifyLogo() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		loginPage.loginUtility();
		String actualLogo = homePage.getHomePageLogoText();
		String expectedLogo = "7rmart supermarket";
		Assert.assertEquals(actualLogo, expectedLogo);
		homePage.getResponseCode();

	}

}
