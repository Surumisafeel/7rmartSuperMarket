package com.executetest;

import org.testng.annotations.Test;

import com.basepackage.BaseClass;

import elementRepository.DatePickersPage;

public class DatePickersTest extends BaseClass {
	DatePickersPage datepickerspage;
	
	@Test
	public void verifyDatePicker() {
		String date="26-08-2030";
		datepickerspage = new DatePickersPage(driver);
		datepickerspage.datePickerHeaderClick();
		datepickerspage.selectDate(date);
		
	}
}
