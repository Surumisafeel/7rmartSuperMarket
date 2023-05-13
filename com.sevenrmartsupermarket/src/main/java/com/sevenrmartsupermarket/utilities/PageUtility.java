package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.constants.Constants;

public class PageUtility {
	WebDriver driver;
	Select select;
	Actions actions;
	JavascriptExecutor javascriptexecuter;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * method to select from dropdown by index
	 * 
	 * @param index
	 * @param element
	 */
	public void select_ByIndex(int index, WebElement element) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * method to select from dropdown by visible text
	 * 
	 * @param text
	 * @param element
	 */
	public void select_ByVisibleText(String text, WebElement element) {
		select = new Select(element);
		select.selectByVisibleText(text);

	}

	/**
	 * method to select from dropdown by visible value
	 * 
	 * @param value
	 * @param element
	 */
	public void select_ByVisibleValue(String value, WebElement element) {
		select = new Select(element);
		select.selectByValue(value);

	}

	/**
	 * method to move to element
	 * 
	 * @param element
	 */

	public void move_toElement(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();

	}

	/**
	 * method to scroll in to view
	 * 
	 * @param element
	 */
	public void scroll_into_View(WebElement element) {

		javascriptexecuter = (JavascriptExecutor) driver;
		javascriptexecuter.executeScript("arguments[0].scrollIntoView();", element);

	}

	/**
	 * method to accept alert
	 */
	public void alertAccept() {
		driver.switchTo().alert().accept();
	}

	/**
	 * method to dismiss alert
	 */
	public void alertDismiss() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * method to sent text to alert box
	 * 
	 * @param text
	 */
	public void alertText(String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	/**
	 * method to click elemet using javascript executer
	 * 
	 * @param element
	 */
	public void js_ExecuterClick(WebElement element) {
		javascriptexecuter.executeScript("arguments[0].click();", element);
	}

	/**
	 * method to upload file
	 * 
	 * @param element
	 * @param fileName
	 */
	public void fileUpload(WebElement element, String fileName) {
		File fileupload = new File(Constants.IMAGE_DIRECTORY + fileName + ".jpeg");
		element.sendKeys(fileupload.getAbsolutePath());

	}

	/**
	 * method to handle windows
	 * 
	 * @param windoID
	 */
	public void windowHandles(String windoID) {
		driver.getWindowHandle();

	}
	
	public void scrollAndClick(WebElement element) {
		int x=0;
		javascriptexecuter=(JavascriptExecutor) driver; 
		while(!is_clicked(element)) {//==false
			javascriptexecuter.executeScript("window.scrollBy(0,"+x+")");
			x++;
		}
		
	}
	
	public boolean is_clicked(WebElement element) {
		try {
			element.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void uploadFile(WebElement element,String fileName) {
		try {
			File file = new File(Constants.IMAGE_DIRECTORY+fileName);
			element.sendKeys(file.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
