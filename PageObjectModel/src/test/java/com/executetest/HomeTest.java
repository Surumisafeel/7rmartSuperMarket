package com.executetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.basepackage.BaseClass;
import com.utilities.Utility;

import elementRepository.HomePage;

public class HomeTest extends BaseClass{
	HomePage homePage;
	@Test
	
	public void verifyObsquraLogo() {
		homePage= new HomePage(driver);
		//homePage.printTitle();
		boolean actualResult =homePage.isObsquralogoDisplayed();
		Assert.assertTrue(actualResult);
		
		
	}
	@Test
	public void verifyHeadrs() {
		homePage= new HomePage(driver);
		homePage.getHomePageHeaders();
		
	}
	@Test
	public void verifyExcelRead() {
		Utility utility = new Utility(driver);
		utility.getExcelcellData(0, 0);
	}
	}


