package com.executetest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.basepackage.BaseClass;

import elementRepository.TablePage;

public class TablePageTest extends BaseClass {

	TablePage tablepage;

	@Test
	public void verifyHeaders() {
		
		boolean tcStatus =true;
		tablepage = new TablePage(driver);
		tablepage.ElementClick();

		List<String> actualNames = new ArrayList<String>();
		actualNames = tablepage.getEmployeeNames();
		//System.out.println(actualNames);

		List<String> expectedNames = new ArrayList<String>();
		expectedNames.add("Tiger Nixon");
		expectedNames.add("Garrett Winters");
		expectedNames.add("Ashton Cox");
		expectedNames.add("Cedric Kelly");
		expectedNames.add("Airi Satou");
		expectedNames.add("Brielle Williamson");
		expectedNames.add("Herrod Chandler");
		expectedNames.add("Rhona Davidson");
		expectedNames.add("Colleen Hurst");
		expectedNames.add("Sonya Frost");
		//System.out.println(expectedNames);
		for (int i = 0; i < expectedNames.size(); i++) {
			if (!expectedNames.get(i).equals(actualNames.get(i))) {
				System.out.println("Expected "+expectedNames);
				System.out.println("Expected "+actualNames);
				 tcStatus =false;
			}
		
		Assert.assertTrue(tcStatus);

	}
	}
	@Test
	public void verifysalary() {
		tablepage= new TablePage(driver);
		tablepage.ElementClick();
		tablepage.printSalaries();
	}

}
