package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 50;

	// public static String TESTDATA_SHEET_PATH =
	// "D:\\Workplace\\POM\\src\\main\\java\\com\\qa\\testData\\testdata.xlsx";
	//public static String TESTDATA_SHEET_PATH = "C:\\Users\\Jatin\\git\\POM\\src\\main\\java\\com\\qa\\testData\\testdata.xlsx";
	public static String TESTDATA_SHEET_PATH = "C:/Users/Jatin/git/POM/src/main/java/com/qa/testData/FreeCRMData.xlsx";

	static Workbook book;
	static Sheet sheet;

	public void switchToFrame() {
		// driver.switchTo().frame("mainpanel");

		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		WebDriver frntest = driver.switchTo().frame("mainpanel");

		frntest.switchTo().frame("intercom-borderless-frame");

		driver.findElement(
				By.xpath("//div[@class ='intercom-composer intercom-composer-borderless']/pre/following::textarea"))
				.click();
		driver.findElement(By.xpath("//div[@class='intercom-borderless-dismiss-button']")).click();

		System.out.println("pop up closed successfully");

		driver.switchTo().frame("mainpanel");

	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

}
