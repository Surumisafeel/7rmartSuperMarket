package com.basepackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void launchURl() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);
		driver.get("https://selenium.obsqurazone.com/index.php");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void closeBrowser()
	{
		
	}

}
