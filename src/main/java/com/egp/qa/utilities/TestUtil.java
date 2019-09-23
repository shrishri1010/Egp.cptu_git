package com.egp.qa.utilities;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.egp.qa.base.TestBase;
import com.egp.qa.configfilereader.FileReaderManager;

/**
*
* @author SHIVANSHU SHANDILYA
*/

public class TestUtil extends TestBase{
	
	@FindBy(xpath="//A[@id='hrefCPV']/self::A")
	WebElement SelectCategory;
	
	@FindBy(className="jstree-checkbox")
	WebElement CpvCatAgri;
	
	@FindBy(id="btnGetCheckedNode")
	WebElement SubmitCpvCategory;
	
	@FindBy(xpath="//*[@id=\"7335\"]/a/ins[1]")
	WebElement computerRel;
	
	static Workbook book;
	static Sheet sheet;
	
	public static long PAGE_LOAD_TIMEOUT = 500;
	public static long IMPLICIT_WAIT = 100;
	public static int Time_Out=30;
	
	public void randomNo() {
		WebElement WebEle =driver.findElement(By.id("txtPackageNo"));
		java.util.Random rand = new java.util.Random();
		int n = rand.nextInt(999999999) + 1;
		String PackageNo_1 = Integer.toString(n);
		WebEle.sendKeys(PackageNo_1);
	}
	
	public void randomNoApp() {
		WebElement WebEle =driver.findElement(By.id("txtAppCode"));
		java.util.Random rand = new java.util.Random();
		int n = rand.nextInt(99999999) + 1;
		String PackageNo_1 = Integer.toString(n);
		System.out.println("Shrikanth PackageNo_1 is --->>"+PackageNo_1);
		WebEle.sendKeys(PackageNo_1);
	}
	
	public void WindowHandleSelectCatg() throws Throwable{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		SelectCategory.click();
		//Window Handling
		//Thread.sleep(5000);
		String Parent_Window = driver.getWindowHandle();  
		for (String handle : driver.getWindowHandles()) {
		  driver.switchTo().window(handle);
		}
		computerRel.click();
		js.executeScript("window.scrollBy(0,1000)");
		SubmitCpvCategory.click();
		Thread.sleep(1000);
		//+++++
		driver.switchTo().window(Parent_Window);  
		driver.switchTo().defaultContent();
		System.out.println("Windows come to back");
	}
	
	public void switchToFrame(){
		driver.switchTo().frame("");
	}
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(FileReaderManager.getInstance().getConfigReader().getTestDataPath());
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
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	/**
	 * Java Docs 
	 * @return by shrikanth kulal
	 */
	public static String timestampMethod(){
        SimpleDateFormat timeStamp=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date=new Date();
        String timestampValue=timeStamp.format(date);
        return timestampValue;
    }
	
	//Future Date
	public static String getTomorrowDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 2);
        return dateFormat.format(cal.getTime());
	}
		
	//Current date
	public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        return dateFormat.format(cal.getTime());
	}
		
	//Past date
	public static String getPastDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -2);
        return dateFormat.format(cal.getTime());
	}
	
	
	/**
	 * Java Docs 
	 * @return by shrikanth kulal
	 */
	public static void captureScreenshot(String screenshotName) throws Exception {
		//Convert webdriver object to screen sheet
		TakesScreenshot takescrshot = (TakesScreenshot)driver;
		//Call getScreenshotAs method to create image file
		File src = takescrshot.getScreenshotAs(OutputType.FILE);
		String str = timestampMethod();
		str=str.replace(" ", "-");
		str=str.replace(":", "-");
		// Copy file to Desired Location  
		FileUtils.copyFile(src, new File("/E:/Test build Given by Joji through pen drive/E-GP Automation Testing/EGP.cptu/screenshots/"+screenshotName+str+".png"));
		//E:\Test build Given by Joji through pen drive\E-GP Automation Testing\EGP.cptu\screenshots
	}
	
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout)
		.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
	}
	
	public static void sendKeysTab(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		//element.click();
		element.clear();
		element.sendKeys(value,Keys.TAB); 
	}
	
	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout)
		.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
}
