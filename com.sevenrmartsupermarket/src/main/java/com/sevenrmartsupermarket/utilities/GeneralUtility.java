package com.sevenrmartsupermarket.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralUtility {
	WebDriver driver;

	public GeneralUtility(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * method to get text of element
	 * 
	 * @param element
	 * @return
	 */
	public String get_TextOfElement(WebElement element) {

		return element.getText();
	}

	/**
	 * method to get text of list of elements
	 * 
	 * @param elements
	 * @return
	 */

	public List<String> getTextOfElements(List<WebElement> elements) {
		List<String> text = new ArrayList();
		for (int i = 0; i < elements.size(); i++) {
			String data = elements.get(i).getText();
			text.add(data);
		}

		return text;
	}

	/**
	 * method to check element is displayed
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean is_Displayed(WebElement element) {
		return element.isDisplayed();

	}

	/**
	 * method to check element is selected
	 * 
	 * @param element
	 * @return boolean
	 */
	public boolean is_Selected(WebElement element) {
		return element.isSelected();

	}

	/**
	 * method to get attribute
	 * 
	 * @param element
	 * @param value
	 * @return String
	 */

	public String get_Attribute(WebElement element, String value) {
		return element.getAttribute(value);
	}

	/**
	 * method to get css value
	 * 
	 * @param element
	 * @param value
	 * @return
	 */
	public String get_CssValue(WebElement element, String value) {
		return element.getCssValue(value);

	}
	
	public static String getTimeStamp() {
		return new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		
	}

}
