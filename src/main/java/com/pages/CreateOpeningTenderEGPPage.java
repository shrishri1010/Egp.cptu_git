package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.egp.qa.base.TestBase;
import com.egp.qa.configfilereader.FileReaderManager;
import com.egp.qa.helper.alert.AlertHelper;
import com.egp.qa.helper.assertion.AssertionHelper;
import com.egp.qa.helper.assertion.VerificationHelper;
import com.egp.qa.helper.javascript.JavaScriptHelper;
import com.egp.qa.helper.logger.LoggerHelper;
import com.egp.qa.helper.select.DropDownHelper;
import com.egp.qa.helper.wait.WaitHelper;
import com.egp.qa.helper.window.WindowHelper;
import com.egp.qa.utilities.TestUtil;
import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

public class CreateOpeningTenderEGPPage extends TestBase {

	private Logger log = LoggerHelper.getLogger(CreateOpeningTenderEGPPage.class);
	DropDownHelper dropdwnhelper = new DropDownHelper(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	VerificationHelper verifhelper = new VerificationHelper(driver);
	JavaScriptHelper jse = new JavaScriptHelper(driver);
	WindowHelper windowhelper = new WindowHelper(driver);
	// AlertHelper alert = new AlertHelper(driver);

	@FindBy(id = "txtTenderId")
	private WebElement tenderpropId;

	@FindBy(id = "btnSearch")
	private WebElement searchbutton;

	@FindBy(xpath = "//a[text()='Mr. PE User']")
	private WebElement peuserlink;

	@FindBy(xpath = "//a[text()='Hope User']")
	private WebElement hopeuserlink;

	@FindBy(xpath = "//a[text()='TEC & PEC User CPTU']")
	private WebElement tecpecuserlink;

	@FindBy(id = "txtpassword")
	private WebElement password;

	@FindBy(id = "password")
	private WebElement password1;

	@FindBy(id = "txtcomments")
	private WebElement comments;

	@FindBy(id = "txtComments")
	private WebElement comments1;

	@FindBy(xpath = "//input[@name='btnsubmit']")
	private WebElement submitbutton;

	@FindBy(xpath = "//div[text()='Consent for Opening given successfully']")
	private WebElement consentText1;

	@FindBy(xpath = "//input[@name='btnMegaHash']")
	private WebElement megaMegaHashButton;

	@FindBy(xpath = "//div[text()='Mega Mega Hash verified successfully']")
	private WebElement megaMegaHashButtonText;

	@FindBy(xpath = "//a[@id='autorptgeneration']")
	private WebElement generateReportTempLink;

	@FindBy(xpath = "//a[@id='anchDecryptAll']")
	private WebElement decryptAllGenerateReport;

	@FindBy(xpath = "//span[text()='Verify Password']")
	private WebElement verifyPasswordButton;

	@FindBy(xpath = "//td[text()='Tender/Proposal Opening Report : ']/parent::*/child::td[2]/a[1]")
	private WebElement TOR1LINK;

	@FindBy(xpath = "//td[text()='Tender/Proposal Opening Report : ']/parent::*/child::td[2]/a[2]")
	private WebElement TOR2LINK;

	@FindBy(xpath = "//a[@id='signId']")
	private WebElement HOPEUSERLINK;

	@FindBy(xpath = "//a[@id='signId']")
	private WebElement tECPECUSERCPTU;

	@FindBy(xpath = "//*[@id='print_area']/table[8]/tbody/tr[2]/td[2]/a")
	private WebElement tECPECUSERCPTU1;

	@FindBy(xpath = "//*[@id='print_area']/table[8]/tbody/tr[2]/td[1]/a")
	private WebElement BODUSERLINK1;

	@FindBy(xpath = "//*[@id='print_area']/table[7]/tbody/tr[2]/td[2]/a")
	private WebElement HOPEUSERLINK1;

	// *[@id='print_area']/table[7]/tbody/tr[2]/td[2]/a

	@FindBy(xpath = "//input[@id='textfield']")
	private WebElement passwordText;

	@FindBy(xpath = "//a[text()='Go Back to Dashboard']")
	private WebElement goBacktoDashBoard;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logOutButton;

	@FindBy(xpath = "//a[@id='signId']")
	private WebElement PEUSERLINK;

	@FindBy(xpath = "//a[@id='signId']")
	private WebElement PEUSERLINKTest;

	@FindBy(xpath = "//*[@id='print_area']/table[8]/tbody/tr[2]/td[1]/a")
	private WebElement PEUSERLINK1;

	@FindBy(xpath = "//*[@id='print_area']/table[7]/tbody/tr[2]/td[1]/a")
	private WebElement MRPEUSERLINK1;

	@FindBy(xpath = "//a[text()='Close']")
	private WebElement closeButton;

	@FindBy(xpath = "//input[@id='hdnbuttonTenderClose']")
	private WebElement submitButton1;

	@FindBy(xpath = "//a[@id='achSentToPE']")
	private WebElement sendtoPE;

	@FindBy(xpath = "//div[text()='Sent to PE successfully']")
	private WebElement sendtoPETextEle;

	@FindBy(xpath = "//*[@id='btnReset']")
	private WebElement resetbutton;

	public CreateOpeningTenderEGPPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Consent for Mr.PEUSER
	 * @throws InterruptedException 
	 */
	public void createDevBudgetWorksWithOpenTendorMethodPEUser() throws InterruptedException {
		log.info("***********inside createDevBudgetWorksWithOpenTendorMethodTest************");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderOTMWorkPath());

		// To read the file --- FileInputStream
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String strngTenderId = null;
		try {
			strngTenderId = IOUtils.toString(fis);
			tenderpropId.sendKeys(strngTenderId + Keys.ENTER);
			waithelper.WaitForElementClickable(searchbutton, 200);
			jse.clickElement(searchbutton);
			Actions builder = new Actions(driver);
			builder.moveToElement(searchbutton).click().build().perform();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(200);
		waithelper.setImplicitWait(500, TimeUnit.SECONDS);

		// Method 1:
		/*
		 * 1.Iterate row and coloumn and get the cell value 2.Using for loop 3.Get total
		 * rows and iterate table 4.Put if(string matches) then select the value
		 * 5.Lengthy method
		 */

		// *[@id="resultTable"]/tbody/tr[1]/td[2]
		// *[@id="resultTable"]/tbody/tr[2]/td[2]

		// *[@id="resultTable"]/tbody/tr[10]/td[2]

		// this is for click icon
		// *[@id="resultTable"]/tbody/tr[3]/td[7]/a/img

		// I am splitting 2nd coloumn nothing but second td.
		String before_xpath = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath = "]/td[2]";

		for (int i = 1; i <= 10; i++) {
			log.info("*********** inside for loop ************");
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if (name.contains(strngTenderId)) {
				waithelper.WaitForElementClickable(
						driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")), 200);
				// driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +
				// "]/td[8]/a/img")).click();
				jse.clickElement(
						driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")));
				break;
			}
		}

		// Assert.assertTrue(false);
		TestUtil.clickOn(driver, peuserlink, 100);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments, 100, "testpackage");
		// Assert.assertTrue(false);
		jse.clickElement(submitbutton);

		String consentText = verifhelper.getText(consentText1);
		System.out.println("emailIdtext is ---->> " + consentText);
		AssertionHelper.verifyText(consentText, "Consent for Opening given successfully", "text is verified");

		// LogOut operation
		jse.clickElement(logOutButton);
	}

	/**
	 * Consent for TECUSER - getTenderOTMWorkPath
	 * 
	 * @throws InterruptedException
	 */
	public void createDevBudgetWorksWithOpenTendorMethodTECUser() throws InterruptedException {
		log.info("*********** inside createDevBudgetWorksWithOpenTendorMethod ************");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderOTMWorkPath());

		// To read the file --- FileInputStream
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String strngTenderId = null;
		try {
			strngTenderId = IOUtils.toString(fis);
			System.out.println("String TenderId with GSS --->>" + strngTenderId);
			tenderpropId.sendKeys(strngTenderId);
			waithelper.WaitForElementClickable(searchbutton, 200);
			jse.clickElement(searchbutton);
			Actions builder = new Actions(driver);
			builder.moveToElement(searchbutton).click().build().perform();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Thread.sleep(200);
		waithelper.setImplicitWait(500, TimeUnit.SECONDS);
		// Method 1:
		/*
		 * 1.Iterate row and coloumn and get the cell value 2.Using for loop 3.Get total
		 * rows and iterate table 4.Put if(string matches) then select the value
		 * 5.Lengthy method
		 */

		// *[@id="resultTable"]/tbody/tr[1]/td[2]
		// *[@id="resultTable"]/tbody/tr[2]/td[2]

		// *[@id="resultTable"]/tbody/tr[10]/td[2]

		// this is for click icon
		// *[@id="resultTable"]/tbody/tr[3]/td[7]/a/img

		// I am splitting 2nd coloumn nothing but second td.

		String before_xpath = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath = "]/td[2]";

		for (int i = 1; i <= 10; i++) {
			log.info("*********** inside for loop ************");
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if (name.contains(strngTenderId)) {
				waithelper.WaitForElementClickable(
						driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")), 200);
				// driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +
				// "]/td[8]/a/img")).click();
				jse.clickElement(
						driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")));
				break;
			}
		}

		/*
		 * int i = 1; while (i <= 10) {
		 * log.info("*********** inside for loop ************"); String name =
		 * driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
		 * System.out.println(name); if (name.contains(strngTenderId)) {
		 * waithelper.WaitForElementClickable(
		 * driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +
		 * "]/td[8]/a/img")), 200); //
		 * driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + //
		 * "]/td[8]/a/img")).click(); jse.clickElement(
		 * driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +
		 * "]/td[8]/a/img"))); break; } } i++;
		 */

		/*
		 * try {
		 * driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[1]/td[8]/a/img")
		 * ).click(); } catch (StaleElementReferenceException e) { e.printStackTrace();
		 * }
		 */
		// Assert.assertTrue(false);
		TestUtil.clickOn(driver, tecpecuserlink, 100);
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments, 100, "testpackage");
		jse.clickElement(submitbutton);

		String consentText = verifhelper.getText(consentText1);
		System.out.println("emailIdtext is ---->> " + consentText);
		AssertionHelper.verifyText(consentText, "Consent for Opening given successfully", "text is verified");

		waithelper.setImplicitWait(50, TimeUnit.SECONDS);

		// Click on Verify Mega Mega Hash
		jse.clickElement(megaMegaHashButton);

		waithelper.setImplicitWait(50, TimeUnit.SECONDS);
		// verify text
		String megaMegaHashButtonText1 = verifhelper.getText(megaMegaHashButtonText);
		System.out.println("emailIdtext is ---->> " + megaMegaHashButtonText1);
		AssertionHelper.verifyText(megaMegaHashButtonText1, "Mega Mega Hash verified successfully", "text is verified");

		// Click on generate Report Template Link(TOR/TER)
		TestUtil.clickOn(driver, generateReportTempLink, 100);
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();

		// Click on Decrypt All and generate report
		TestUtil.clickOn(driver, decryptAllGenerateReport, 100);
		TestUtil.sendKeys(driver, password1, 50, "egp12345");

		jse.clickElement(verifyPasswordButton);
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		alert2.accept();

		// Work with Tender/Proposal Opening Report :
		// Click on TOR1
		TestUtil.clickOn(driver, TOR1LINK, 50);
		waithelper.setImplicitWait(50, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, tECPECUSERCPTU, 50);

		// sending text
		TestUtil.sendKeys(driver, passwordText, 50, "egp12345");
		TestUtil.sendKeys(driver, comments, 50, "comments");
		jse.clickElement(submitbutton);

		jse.clickElement(goBacktoDashBoard);

		// Click on TOR2
		TestUtil.clickOn(driver, TOR2LINK, 50);
		waithelper.setImplicitWait(50, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, tECPECUSERCPTU1, 50);

		// Sending text
		TestUtil.sendKeys(driver, passwordText, 50, "egp12345");
		TestUtil.sendKeys(driver, comments, 50, "comments");
		jse.clickElement(submitbutton);

		jse.clickElement(goBacktoDashBoard);
		jse.clickElement(logOutButton);
	}

	/**
	 * login as POUSER perform
	 * 
	 * @throws InterruptedException
	 */
	public void createDevBudgetWorksWithOpenTendorMethodPEUser1() throws InterruptedException {
		log.info("***********inside createDevBudgetWorksWithOpenTendorMethod************");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderOTMWorkPath());

		// To read the file --- FileInputStream
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String strngTenderId = null;
		try {
			strngTenderId = IOUtils.toString(fis);
			tenderpropId.sendKeys(strngTenderId);
			waithelper.WaitForElementClickable(searchbutton, 200);
			jse.clickElement(searchbutton);
			Actions builder = new Actions(driver);
			builder.moveToElement(searchbutton).click().build().perform();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(200);
		waithelper.setImplicitWait(500, TimeUnit.SECONDS);

		// Method 1:
		/*
		 * 1.Iterate row and coloumn and get the cell value 2.Using for loop 3.Get total
		 * rows and iterate table 4.Put if(string matches) then select the value
		 * 5.Lengthy method
		 */

		// *[@id="resultTable"]/tbody/tr[1]/td[2]
		// *[@id="resultTable"]/tbody/tr[2]/td[2]

		// *[@id="resultTable"]/tbody/tr[10]/td[2]

		// this is for click icon
		// *[@id="resultTable"]/tbody/tr[3]/td[7]/a/img

		// I am splitting 2nd coloumn nothing but second td.

		String before_xpath = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath = "]/td[2]";

		for (int i = 1; i <= 10; i++) {
			log.info("*********** inside for loop ************");
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if (name.contains(strngTenderId)) {
				waithelper.WaitForElementClickable(
						driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")), 200);
				// driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +
				// "]/td[8]/a/img")).click();
				jse.clickElement(
						driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")));
				break;
			}
		}

		// Work with Tender/Proposal Opening Report : Click on TOR1
		TestUtil.clickOn(driver, TOR1LINK, 50);
		waithelper.setImplicitWait(50, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, PEUSERLINK, 50);

		// sending text
		TestUtil.sendKeys(driver, passwordText, 50, "egp12345");
		TestUtil.sendKeys(driver, comments, 50, "comments");
		jse.clickElement(submitbutton);

		jse.clickElement(goBacktoDashBoard);

		// Click on TOR2
		TestUtil.clickOn(driver, TOR2LINK, 50);
		waithelper.setImplicitWait(50, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, PEUSERLINK1, 50);

		// Sending text
		TestUtil.sendKeys(driver, passwordText, 50, "egp12345");
		TestUtil.sendKeys(driver, comments, 50, "comments");
		jse.clickElement(submitbutton);

		jse.clickElement(goBacktoDashBoard);

	}

	/**
	 * TEC & PEC User CPTU - egptecuser@gmail.com egptecuser login credentials
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws Throwable
	 */
	public void createDevBudgetWorksWithOpenTendorMethodTECUser1() throws InterruptedException {
		log.info("***********inside createDevBudgetWorksWithOpenTendorMethodTest************");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderOTMWorkPath());

		// To read the file --- FileInputStream
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String strngTenderId = null;
		try {
			strngTenderId = IOUtils.toString(fis);
			tenderpropId.sendKeys(strngTenderId);
			waithelper.WaitForElementClickable(searchbutton, 200);
			jse.clickElement(searchbutton);
			Actions builder = new Actions(driver);
			builder.moveToElement(searchbutton).click().build().perform();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(200);
		waithelper.setImplicitWait(500, TimeUnit.SECONDS);

		// Method 1:
		/*
		 * 1.Iterate row and coloumn and get the cell value 2.Using for loop 3.Get total
		 * rows and iterate table 4.Put if(string matches) then select the value
		 * 5.Lengthy method
		 */

		// *[@id="resultTable"]/tbody/tr[1]/td[2]
		// *[@id="resultTable"]/tbody/tr[2]/td[2]

		// *[@id="resultTable"]/tbody/tr[10]/td[2]

		// this is for click icon
		// *[@id="resultTable"]/tbody/tr[3]/td[7]/a/img

		// I am splitting 2nd coloumn nothing but second td.

		String before_xpath = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath = "]/td[2]";

		for (int i = 1; i <= 10; i++) {
			log.info("*********** inside for loop ************");
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if (name.contains(strngTenderId)) {
				waithelper.WaitForElementClickable(
						driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")), 200);
				// driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +
				// "]/td[8]/a/img")).click();
				jse.clickElement(
						driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")));
				break;
			}
		}
		// Close link
		// login as tec user
		TestUtil.clickOn(driver, closeButton, 50);

		TestUtil.sendKeys(driver, comments1, 50, "tested successfully");

		jse.clickElement(submitButton1);

		TestUtil.clickOn(driver, sendtoPE, 100);

		Alert alert3 = driver.switchTo().alert();
		alert3.accept();

		TestUtil.sendKeys(driver, comments1, 1000, "tested successfully123");

		jse.clickElement(submitButton1);

		// Verify text
		String sendToPEText = verifhelper.getText(sendtoPETextEle);
		System.out.println("emailIdtext is ---->> " + sendToPEText);
		AssertionHelper.verifyText(sendToPEText, "Sent to PE successfully", "text is verified");
	}

	/**
	 * Consent for PEUSER
	 */
	public void createDevBudgetWorksWithRFQUMethodPEUser() {
		log.info("***********inside createDevBudgetWorksWithOpenTendorMethod************");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderRFQWorkPath());

		// To read the file --- FileInputStream
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String strngTenderId = null;
		try {
			strngTenderId = IOUtils.toString(fis);
			tenderpropId.sendKeys(strngTenderId + Keys.ENTER);
			/*
			 * waithelper.WaitForElementVisibleWithPollingTime(searchbutton,20, 5);
			 * jse.scrollIntoView(searchbutton); jse.clickElement(searchbutton);
			 */
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Method 1:
		/*
		 * 1.Iterate row and coloumn and get the cell value 2.Using for loop 3.Get total
		 * rows and iterate table 4.Put if(string matches) then select the value
		 * 5.Lengthy method
		 */

		// *[@id="resultTable"]/tbody/tr[1]/td[2]
		// *[@id="resultTable"]/tbody/tr[2]/td[2]

		// *[@id="resultTable"]/tbody/tr[10]/td[2]

		// this is for click icon
		// *[@id="resultTable"]/tbody/tr[3]/td[7]/a/img

		// I am splitting 2nd coloumn nothing but second td.
		String before_xpath = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath = "]/td[2]";

		for (int i = 1; i <= 1; i++) {
			log.info("*********** inside for loop ************");
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if (name.contains(strngTenderId)) {
				System.out.println("shrikanth kulal -->> " + name);
				driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")).click();
				break;
			}
		}

		TestUtil.clickOn(driver, peuserlink, 100);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments, 100, "testpackage");
		// Assert.assertTrue(false);
		jse.clickElement(submitbutton);

		String consentText = verifhelper.getText(consentText1);
		System.out.println("emailIdtext is ---->> " + consentText);
		AssertionHelper.verifyText(consentText, "Consent for Opening given successfully", "text is verified");

		// LogOut operation
		jse.clickElement(logOutButton);
	}

	/**
	 * Consent for HOPEUSER - getTenderRFQWorkPath
	 */

	public void createDevBudgetWorksWithRFQUMethodHOPEUser() {
		log.info("*********** inside createDevBudgetWorksWithOpenTendorMethod ************");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderRFQWorkPath());

		// To read the file --- FileInputStream
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String strngTenderId = null;
		try {
			strngTenderId = IOUtils.toString(fis);
			System.out.println("String TenderId with GSS --->>" + strngTenderId);
			tenderpropId.sendKeys(strngTenderId);
			tenderpropId.clear();
			tenderpropId.sendKeys(strngTenderId);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// jse.clickElement(searchbutton)
		// searchbutton.click();
		// TestUtil.clickOn(driver, searchbutton, 100);
		try {
			jse.clickElement(searchbutton);
			// waithelper.setImplicitWait(100, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[1]/td[8]/a/img")).click();
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
		}

		TestUtil.clickOn(driver, hopeuserlink, 100);
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments, 100, "testpackage");
		jse.clickElement(submitbutton);

		String consentText = verifhelper.getText(consentText1);
		System.out.println("emailIdtext is ---->> " + consentText);
		AssertionHelper.verifyText(consentText, "Consent for Opening given successfully", "text is verified");

		/*
		 * WorkFlowCrt workflwcart = PageFactory.initElements(driver,
		 * WorkFlowCrt.class);
		 * 
		 * //LogOut operation try { workflwcart.createWorkFlowBidSubmission(); } catch
		 * (Throwable e) { e.printStackTrace(); }
		 */

		jse.clickElement(megaMegaHashButton);

		waithelper.setImplicitWait(50, TimeUnit.SECONDS);
		// verify text
		String megaMegaHashButtonText1 = verifhelper.getText(megaMegaHashButtonText);
		System.out.println("emailIdtext is ---->> " + megaMegaHashButtonText1);
		AssertionHelper.verifyText(megaMegaHashButtonText1, "Mega Mega Hash verified successfully", "text is verified");

		// Click on generate Report Template Link
		TestUtil.clickOn(driver, generateReportTempLink, 100);
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();

		// click on Decrypt All and generate report
		TestUtil.clickOn(driver, decryptAllGenerateReport, 100);
		TestUtil.sendKeys(driver, password1, 50, "egp12345");

		jse.clickElement(verifyPasswordButton);
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();

		// Work with Tender/Proposal Opening Report : Click on TOR1
		TestUtil.clickOn(driver, TOR1LINK, 50);
		waithelper.setImplicitWait(50, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, HOPEUSERLINK, 50);

		// sending text
		TestUtil.sendKeys(driver, passwordText, 50, "egp12345");
		TestUtil.sendKeys(driver, comments, 50, "comments");
		jse.clickElement(submitbutton);

		jse.clickElement(goBacktoDashBoard);

		// click on TOR2
		TestUtil.clickOn(driver, TOR2LINK, 50);
		waithelper.setImplicitWait(50, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, HOPEUSERLINK1, 50);

		// Sending text
		TestUtil.sendKeys(driver, passwordText, 50, "egp12345");
		TestUtil.sendKeys(driver, comments, 50, "comments");
		jse.clickElement(submitbutton);

		jse.clickElement(goBacktoDashBoard);
		jse.clickElement(logOutButton);
	}

	/**
	 * login as AOUSER perform
	 */
	public void createDevBudgetWorksWithRequestForQuotationUnitMethodPEUser1() {
		log.info("***********inside createDevBudgetWorksWithOpenTendorMethod************");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderRFQWorkPath());

		// To read the file --- FileInputStream
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String strngTenderId = null;
		try {
			strngTenderId = IOUtils.toString(fis);
			System.out.println("String TenderId with GSS --->>" + strngTenderId);
			// tenderpropId.sendKeys(strngTenderId);
			// TestUtil.clickOn(driver, resetbutton, 50);
			tenderpropId.sendKeys(strngTenderId);
		} catch (IOException e) {
			e.printStackTrace();
		}

		jse.clickElement(searchbutton);
		driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a/img")).click();

		// Work with Tender/Proposal Opening Report :
		// Click on TOR1
		TestUtil.clickOn(driver, TOR1LINK, 50);
		waithelper.setImplicitWait(50, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, PEUSERLINKTest, 50);

		// sending text
		TestUtil.sendKeys(driver, passwordText, 50, "egp12345");
		TestUtil.sendKeys(driver, comments, 50, "comments");

		jse.clickElement(submitbutton);

		jse.clickElement(goBacktoDashBoard);

		// Click on TOR2
		TestUtil.clickOn(driver, TOR2LINK, 50);
		waithelper.setImplicitWait(50, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, MRPEUSERLINK1, 50);

		// Sending text
		TestUtil.sendKeys(driver, passwordText, 50, "egp12345");
		TestUtil.sendKeys(driver, comments, 50, "comments");
		jse.clickElement(submitbutton);

		jse.clickElement(goBacktoDashBoard);

		// close link
		// Login as Hope user ---- make separate function for below lines (701 - 720)
		TestUtil.clickOn(driver, closeButton, 50);

		TestUtil.sendKeys(driver, comments1, 50, "tested successfully");

		jse.clickElement(submitButton1);

		TestUtil.clickOn(driver, sendtoPE, 100);

		Alert alert3 = driver.switchTo().alert();
		alert3.accept();

		TestUtil.sendKeys(driver, comments1, 1000, "tested successfully123");
					
		jse.clickElement(submitButton1);
		
		// verify text
		String sendToPEText = verifhelper.getText(sendtoPETextEle);
		System.out.println("emailIdtext is ---->> " + sendToPEText);
		AssertionHelper.verifyText(sendToPEText, "Sent to PE successfully", "text is verified");
	}

}
