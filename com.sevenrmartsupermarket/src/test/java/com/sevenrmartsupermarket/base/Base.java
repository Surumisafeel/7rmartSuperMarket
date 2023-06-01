package com.sevenrmartsupermarket.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.ScreenShot;
import com.sevenrmartsupermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	Properties properties = new Properties();
	FileInputStream fileinputstream;
	ScreenShot screenShot = new ScreenShot();

	public Base() {

		try {
			fileinputstream = new FileInputStream(Constants.CONFIG_FILE_PATH);

			properties.load(fileinputstream);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void initilize(String browser, String url) {
		if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");//check selenium version
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(WaitUtility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true , enabled = false)
	public void launchBrowser(String browser) {
		
		String url = properties.getProperty("url");
		initilize(browser, url);
	}
	@BeforeMethod(alwaysRun = true , enabled =true)
	public void launchBrowser() {
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		initilize(browser, url);
	}

	@AfterMethod(alwaysRun = true)
	public void closeapplication(ITestResult itestresult) {
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			screenShot.takeScreenshot(driver, itestresult.getName());

		}
		driver.close();
	}
}
