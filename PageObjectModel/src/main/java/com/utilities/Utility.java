package com.utilities;

import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {

	WebDriver driver;

	public String get_TextOfElement(WebElement element) {

		return element.getText();
	}

	public  Utility(WebDriver driver) {
		this.driver = driver;

	}

	public List<String> getTextOfElements(String listXpath) {

		List<String> text = new ArrayList();

		List<WebElement> elements = driver.findElements(By.xpath(listXpath));

		for (int i = 0; i < elements.size(); i++) {
			String data = elements.get(i).getText();
			text.add(data);
		}
		return text;
		}
		
		public List<String> getTextOfElements(List<WebElement> elements) {
			List<String> text = new ArrayList();
			for (int i = 0; i < elements.size(); i++) {
				String data = elements.get(i).getText();
				text.add(data);
			}

			return text;
		}
		}
		// for(WebElement element:elements) {
		// String data = element.getText();
		// }

		

	


