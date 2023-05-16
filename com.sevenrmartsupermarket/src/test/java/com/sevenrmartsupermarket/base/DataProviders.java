package com.sevenrmartsupermarket.base;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class DataProviders {
	ExcelReader excelReader = new ExcelReader();

	@DataProvider(name = "New user creation data")
	public Object[][] DataProviderDeliveryBoyCreation() {
		return new Object[][] {
				{ "DeliveryBoyName", "deliveryBoyName@test.com", "90922", "DeliveryBoyAddress",
						"DeliveryboyUserName123", "password" },
				{ "DeliveryBoyName1", "deliveryBoyName1@test.com", "909922", "DeliveryBoyAddress1",
						"DeliveryboyUserName1234", "password" } };
	}

	@DataProvider(name = "Admin user creation data")
	public Object[][] DataProviderLoginDataCreation() {
		return new Object[][] { { "Surumi93", "password", "Staff" }, { "surumi19", "password", "Staff" } };
	}

	@DataProvider(name = "New Delivery boy user creation data")
	public Object[][] DataProviderDeliveryBoyInfo() {
		excelReader.setExcelFile("DeliveryBoy", "DeliveryBoy Data");

		Object data[][] = excelReader.getMultiDimentionalData(3, 6);
		return data;
	}
	/**
	 * method to get multidimentional excel data
	 * @return Object [][]
	 */
	@DataProvider(name = "New Manage page creation data")
	public Object[][] DataProviderManagePage() {
		excelReader.setExcelFile("ManagePageContent","pageContent");

		Object data[][] = excelReader.getMultiDimentionalData(2,4);
		return data;
	}
}
