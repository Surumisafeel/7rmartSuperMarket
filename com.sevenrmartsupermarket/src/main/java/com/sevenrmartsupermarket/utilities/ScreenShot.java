package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	TakesScreenshot takescreenshot;// interface to capture screenshot

	public void takeScreenshot(WebDriver driver, String imageName) {
		try {
			takescreenshot = (TakesScreenshot) driver;
			File file = takescreenshot.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());// current system date
			String destination = System.getProperty("user.dir") + "//Screenshots//" + imageName + " " + timeStamp+".png";
			File finalDestination = new File(destination);
			FileHandler.copy(file, finalDestination);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
