package com.sevenrmartsupermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriverWait wait;
	WebDriver driver;
	public static final long IMPLICIT_WAIT = 10;
	public static final long EXPLICIT_WAIT = 20;

	public WaitUtility(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * method to wait for a located element to be visible
	 * 
	 * @param xpath
	 */
	public void waitForElementToBeVisible(String xpath) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	/**
	 * method to wait for element to be visible
	 * 
	 * @param element
	 */
	public void waitForElementToBeVisible(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * method to wait for a element to be invisible
	 * 
	 * @param element
	 */
	public void waitForElementToBeInvisible(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * wait for a elemet to be clickable
	 * 
	 * @param xpath
	 */
	public void waitForElementToBeClickable(String xpath) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	/**
	 * wait for alert to be visible
	 * 
	 * @param element
	 */
	public void waitForAlertToBeVisible(String element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}

}
