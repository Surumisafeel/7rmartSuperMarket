package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {

	WebDriver driver;
	
	XSSFSheet sheet;
	XSSFWorkbook workbook;
	
	XSSFRow row;
	XSSFCell cell;

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
		
		public void getExcelcellData(int r,int c) {
			
			String path = "C:\\Users\\surum\\OneDrive\\Desktop\\Obsqura Assignment\\Selenium.xlsx";
			try {
				File src= new File(path);
				FileInputStream fi =new FileInputStream(src);
				workbook = new XSSFWorkbook(fi);
				sheet = workbook.getSheet("NameAndAge");
				row =sheet.getRow(r);
				cell = row.getCell(c);
				System.out.println(cell.getStringCellValue());
				//System.out.println(cell.getNumericCellValue());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}
		}
		// for(WebElement element:elements) {
		// String data = element.getText();
		// }

		

	


