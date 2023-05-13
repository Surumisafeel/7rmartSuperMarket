package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotificationPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class PushNotificationTest extends Base {
	LoginPage loginPage;
	PushNotificationPage pushNotificationPage;
	ExcelReader excelReader =new ExcelReader();
	
	@Test
	public void verifyPushNotification() {
		loginPage=new LoginPage(driver);
		pushNotificationPage = new PushNotificationPage(driver);
		
		loginPage.loginUtility();
		pushNotificationPage.clickOnPushNotification();
		excelReader.setExcelFile("Push Notification Data", "Notification Data");
		String title=excelReader.getCellData(0, 0);
		System.out.println(title);
//		excelReader.setExcelFile("LoginData", "InvalidLoginCredential");
//		String userName=excelReader.getCellData(0, 0);
//		String password=excelReader.getCellData(0, 1);
	}
}
