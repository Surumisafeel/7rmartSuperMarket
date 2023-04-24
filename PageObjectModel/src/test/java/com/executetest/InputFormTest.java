package com.executetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.basepackage.BaseClass;

import elementRepository.HomePage;
import elementRepository.InputFormPage;

public class InputFormTest extends BaseClass {
	InputFormPage inputformpage;
@Test
public void verifyShowMessageButtonText() {
	
	inputformpage= new InputFormPage(driver);
		//homePage.printTitle();
	    inputformpage.ElementClick();
//		boolean actualResult =inputformpage.isShowMessageDisplayed();
//		System.out.println("Actual result"+actualResult);
//		Assert.assertTrue(actualResult);
		String expectedText="Show Message";
		//String actualTextShowMessage=inputformpage.showMessageButtonText();
		
		String actualTextShowMessage=inputformpage.get_TextofShowMessageButton();
		System.out.println(actualTextShowMessage);
		Assert.assertEquals(actualTextShowMessage, expectedText);
		
		
	}
@Test
public void verifyCheckBoxclick() {
	inputformpage= new InputFormPage(driver);
	//inputformpage.callpageFactory();
	inputformpage.ElementClick();
	inputformpage.clickOnCheckBoxLink();
	
}




}



