package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sevenrmartsupermarket.constants.Constants;

public class ExcelReader {
	XSSFSheet sheet;
	XSSFWorkbook workbook;

	XSSFRow row;
	XSSFCell cell;

	/**
	 * method to select excel file
	 * 
	 * @param workBookName
	 * @param sheetName
	 */
	public void setExcelFile(String workBookName, String sheetName) {
		try {
			String path = Constants.EXCEL_FILE_PATH_STRING + workBookName + ".xlsx";
			File src = new File(path);
			FileInputStream fi = new FileInputStream(src);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * method to get cell data from excel file
	 * 
	 * @param rowNo
	 * @param colomnNo
	 * @return
	 */
	public String getCellData(int rowNo, int colomnNo) {
		row = sheet.getRow(rowNo);
		cell = row.getCell(colomnNo);

		switch (cell.getCellType()) {
		case STRING: {
			String x;
			x = cell.getStringCellValue();
			return x;
		}
		case NUMERIC: {
			long d = (long) cell.getNumericCellValue();
			return String.valueOf(d);
		}

		default:
			return null;

		}

	}
	
	public Object[][] getMultiDimentionalData(int row, int coloumn)
	{
		Object data[][]=new Object[row][coloumn];
		for (int i=0;i<row;i++) {
				for (int j=0;j<coloumn;j++) {
					data[i][j]=getCellData(i, j);
				}
		}
		
		return data;
	}
}
