package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.base.DataProviders;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManagePagesPage;

public class ManagePagesTest extends Base {
	HomePage homePage;
	LoginPage loginPage;
	ManagePagesPage managepagespage;

	@Test(dataProvider = "New Manage page creation data", dataProviderClass = DataProviders.class)
	public void verifyAddPagesFunctionality(String title, String description, String pageName, String image) {
		loginPage = new LoginPage(driver);
		managepagespage = new ManagePagesPage(driver);
		loginPage.loginUtility();
		managepagespage.clickOnManagePages();
		managepagespage.addPageContent(title, description, pageName,image);
	}

	@Test
	public void deleteThis() {
		loginPage = new LoginPage(driver);
		managepagespage = new ManagePagesPage(driver);
		loginPage.loginUtility();
		managepagespage.clickOnManagePages();
		managepagespage.addPageContent("Test342", "test445", "536", "image1.jpg");

	}

}
