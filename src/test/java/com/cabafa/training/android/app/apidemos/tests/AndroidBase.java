package com.cabafa.training.android.app.apidemos.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidBase {

	AppiumDriver<MobileElement> driver;
	AppiumDriverLocalService service;
	DesiredCapabilities capabilities= new DesiredCapabilities();
	
	XSSFWorkbook excelWorkbook;
	XSSFSheet excelSheet;
	//Object data[][];

	@BeforeSuite
	public void startServer() throws IOException, InterruptedException {

		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
	}

	@AfterSuite (alwaysRun = true)
	public void stopServer() {

		service.stop();
	}

	@AfterClass (alwaysRun = true)
	public void closeApp() {
		driver.quit();
	}
	
	public void scroll() {

		Dimension size = driver.manage().window().getSize();
		int x = size.getWidth() / 2;
		int iniy = (int) (size.getHeight() * .60);
		int endy = (int) (size.getHeight() * .10);
		driver.swipe(x, iniy, x, endy, 1000);
	}

	public void setCapabilities() {
		capabilities.setCapability("deviceName", "CB5A2ALXSN");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		// capabilities.setCapability("noReset", "true");
	}

	public void installApp(String app) throws MalformedURLException {

		File src = new File("src");
		File apk = new File(src, app);

		setCapabilities();
		capabilities.setCapability("app", apk.getAbsolutePath());

		driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void startApp(String pack, String activity) throws MalformedURLException {

		setCapabilities();
		capabilities.setCapability("appPackage", pack);
		capabilities.setCapability("appActivity", activity);

		driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void setDataFile(String path, String file, String sheet) throws IOException {
		
		File src = new File(path);
		File excel = new File(src, file);
		
		FileInputStream fis = new FileInputStream(excel.getAbsolutePath());
		
		excelWorkbook = new XSSFWorkbook(fis);
		excelSheet = excelWorkbook.getSheet(sheet);
		
	}
	
	public Object[][] getDataFromSheet() throws IOException {
		
		int rowCount = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum() + 1;
		int colCount = excelSheet.getRow(0).getLastCellNum();
		
		Object data[][] = new Object[rowCount - 1][colCount];
		for (int rNum = 2; rNum <= rowCount; rNum++) {
			for (int cNum = 0; cNum < colCount; cNum++) {
				data[rNum - 2][cNum] = getCellData(excelSheet.getSheetName(), cNum, rNum); // Your sheet name
			}
		}
		return data;
	}
	
	public String getCellData(String sheetName, int colNum, int rowNum) {
		
		XSSFRow row = null;
		XSSFCell cell = null;
		
		try {
			if (rowNum <= 0)
				return "";
			int index = excelWorkbook.getSheetIndex(sheetName);
			if (index == -1)
				return "";
			excelSheet = excelWorkbook.getSheetAt(index);
			row = excelSheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist in xls";
		}
	}

}
