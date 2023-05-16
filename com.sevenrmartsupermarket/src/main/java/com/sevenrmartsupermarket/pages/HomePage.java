package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class HomePage {
	WebDriver driver;
	Properties properties = new Properties();
	FileInputStream fileinputstream;
	GeneralUtility generalUtility;
	PageUtility pageUtility;

	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	private WebElement homePageLogo;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			fileinputstream = new FileInputStream(Constants.CONFIG_FILE_PATH);

			properties.load(fileinputstream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * method to get home page logo
	 * 
	 * @return
	 */
	public String getHomePageLogoText() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.get_TextOfElement(homePageLogo);
	}

	public void getResponseCode() {
		generalUtility = new GeneralUtility(driver);
		int statusCode = generalUtility
				.getResponseStatusCode("https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png");
		System.out.println(statusCode);
	}

}
