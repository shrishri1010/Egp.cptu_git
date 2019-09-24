package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.egp.qa.base.TestBase;
import com.egp.qa.configfilereader.FileReaderManager;
import com.egp.qa.helper.assertion.AssertionHelper;
import com.egp.qa.helper.assertion.VerificationHelper;
import com.egp.qa.helper.javascript.JavaScriptHelper;
import com.egp.qa.helper.logger.LoggerHelper;
import com.egp.qa.helper.select.DropDownHelper;
import com.egp.qa.helper.wait.WaitHelper;
import com.egp.qa.helper.window.WindowHelper;
import com.egp.qa.utilities.TestUtil;

public class BranchMakerCheckerPaymentPage extends TestBase {
	// Test
	CreateAppPage crt;
	TestUtil testUtil = new TestUtil();
	/// JavascriptExecutor jse = (JavascriptExecutor)driver;
	private Logger log = LoggerHelper.getLogger(BranchMakerCheckerPaymentPage.class);
	DropDownHelper dropdwnhelper = new DropDownHelper(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	VerificationHelper verifhelper = new VerificationHelper(driver);
	JavaScriptHelper jse = new JavaScriptHelper(driver);
	WindowHelper windowhelper = new WindowHelper(driver);

	@FindBy(id = "txtTenderId")
	private WebElement tenderId;

	@FindBy(id = "txtEmailId")
	private WebElement emailIdText;

	@FindBy(xpath = "/html/body/div/div[3]/div[2]")
	private WebElement tenderHeader;

	@FindBy(id = "btnSearch")
	private WebElement searchButton;

	@FindBy(linkText = "Make Payment")
	private WebElement makePaymentLinkText;

	@FindBy(linkText = "/html/body/div/div[3]/div[4]/table/tbody/tr[2]/td[3]/a[contains(text(),'Payment')]")
	private WebElement paymentLink;

	@FindBy(id = "cmbPayment")
	private WebElement selectModeOfPayment;

	@FindBy(id = "btnSubmit")
	private WebElement clickSubmitButton;

	@FindBy(id = "txtComments")
	private WebElement remarks;

	@FindBy(xpath = "//input[@id='btnpaymentsearch' and @value='Search']")
	private WebElement searchButton1;

	@FindBy(xpath = "//ul[@class='tabPanel_1']/li")
	List<WebElement> totalTabs;

	@FindBy(xpath = "//input[@id='txtInsRefNo']")
	private WebElement instrumentNo;

	@FindBy(xpath = "//input[@id='txtIssuanceBankNm']")
	private WebElement issuingBank;

	@FindBy(xpath = "//input[@id='txtIssuanceBranch']")
	private WebElement issuingBankBranch;

	@FindBy(xpath = "//input[@id='txtIssuanceDt']")
	private WebElement issuenceDate;

	public BranchMakerCheckerPaymentPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * BranchMakerCheckerPaymentProcess - OTMWorks tendor
	 */
	public void branchMakerCheckerPaymentProcessOTMWorksTender() {
		log.info("*********** inside branchMakerCheckerPaymentProcessOTMWorksTender ************");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderOTMWorkPath());

		// To read the file --->> FileInputStream
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
			tenderId.sendKeys(strngTenderId);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// js.clickElement(searchButtonId);
		// Method 1:
		/*
		 * 1.Iterate row and coloumn and get the cell value
		 * 2.Using for loop
		 * 3.Get total
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
			log.info("***********inside for loop************");
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if (name.contains(strngTenderId)) {
				System.out.println("shrikanth kulal -->> " + name);
				driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[7]/a/img")).click();
				break;
			}
		}

		// Verify close date and time
		/*
		 * String closeDateTime = verification.getText(closingDateTime);
		 * System.out.println("date is ---->> "+closeDateTime);
		 * AssertionHelper.verifyText(closeDateTime, "29-Dec-2018 09:57",
		 * "text is verified");
		 */

		// List<WebElement> data =
		// driver.findElements(By.xpath("//ul[@class='tabPanel_1']/li"));
		System.out.println("size is --->>" + totalTabs.size());

		for (int i = 0; i < totalTabs.size(); i++) {
			WebElement element = totalTabs.get(i);
			String text = totalTabs.get(i).getText();
			System.out.println("tabs are ---->> " + text);

			if (text.equals("Document Fees")) {
				element.click();
				break;
			}
		}

		// Verify emailIdtext label
		String tenderText = verifhelper.getText(tenderHeader);
		System.out.println("emailIdtext is ---->> " + tenderText);
		AssertionHelper.verifyText(tenderText, "Tender/Proposal Detail", "text is verified");

		// Enter e-mail id text and search
		emailIdText.sendKeys("egptenderer1@gmail.com");
		jse.clickElement(searchButton);

		// Click on Make Payment in Action tab
		makePaymentLinkText.click();

		// DropDownhelper used to select ModeOfPayment
		DropDownHelper dropdown = new DropDownHelper(driver);
		dropdown.selectUsingVisibleText(selectModeOfPayment, "Cash");

		// Enter remarks
		remarks.sendKeys("ModeOfPayment is done");
		// click on Submit button
		// js.scrollToElementAndClick(clickSubmitButton);

		jse.scrollIntoView(clickSubmitButton);
		jse.clickElement(clickSubmitButton);

		waithelper.setImplicitWait(50, TimeUnit.SECONDS);

		WorkFlowCrt workflwcart = PageFactory.initElements(driver, WorkFlowCrt.class);

		// LogOut operation
		try {
			workflwcart.createWorkFlowBidSubmission();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		/**
		 * branch-Checker-Login functionality
		 */
		try {
			workflwcart.branchCheckerLogin(strngTenderId);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * BranchMakerCheckerPaymentProcess - Tender_Proposal_Security
	 * @throws InterruptedException 
	 */
	public void branchMakerCheckerPaymentProcessOTMWorksTender_Proposal_Security_New() throws InterruptedException {
		log.info("*********** inside branchMakerCheckerPaymentProcessOTMWorksTender ************");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderOTMWorkPath());

		// To read the file --->> FileInputStream
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
			tenderId.sendKeys(strngTenderId);
			Thread.sleep(500);
			searchButton1.click();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// js.clickElement(searchButtonId);
		// Method 1:
		/*
		 * 1.Iterate row and coloumn and get the cell value
		 * 2.Using for loop
		 * 3.Get total
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
			log.info("***********inside for loop************");
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if (name.contains(strngTenderId)) {
				System.out.println("shrikanth kulal -->> " + name);
				driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[7]/a/img")).click();
				break;
			}
		}

		// Verify close date and time
		/*
		 * String closeDateTime = verification.getText(closingDateTime);
		 * System.out.println("date is ---->> "+closeDateTime);
		 * AssertionHelper.verifyText(closeDateTime, "29-Dec-2018 09:57",
		 * "text is verified");
		 */

		// List<WebElement> data =
		// driver.findElements(By.xpath("//ul[@class='tabPanel_1']/li"));
		System.out.println("size is --->>" + totalTabs.size());

		for (int i = 0; i < totalTabs.size(); i++) {
			WebElement element = totalTabs.get(i);
			String text = totalTabs.get(i).getText();
			System.out.println("tabs are ---->> " + text);

			if (text.equals("Tender/Proposal Security")) {
				element.click();
				break;
			}
		}

		/*// Verify emailIdtext label
		String tenderText = verifhelper.getText(tenderHeader);
		System.out.println("emailIdtext is ---->> " + tenderText);
		AssertionHelper.verifyText(tenderText, "Tender/Proposal Detail", "text is verified");*/
		paymentLink.click();

		// Enter e-mail id text and search
		emailIdText.sendKeys("egptenderer1@gmail.com");
		jse.clickElement(searchButton);
		
		makePaymentLinkText.click();

		// DropDownhelper used to select ModeOfPayment
		dropdwnhelper.selectUsingVisibleText(selectModeOfPayment, "Pay Order");
		TestUtil.sendKeys(driver, instrumentNo, 100, "test12345");
		TestUtil.sendKeys(driver, issuingBank, 100, "national bannk");
		TestUtil.sendKeys(driver, issuingBankBranch, 100, "gulshan1");
		jse.selectDateByJavaScript(issuenceDate, "26-08-2019");

		// Enter remarks
		remarks.sendKeys("ModeOfPayment is done");

		// click on Submit button
		// js.scrollToElementAndClick(clickSubmitButton);
		jse.scrollIntoView(clickSubmitButton);
		jse.clickElement(clickSubmitButton);
		waithelper.setImplicitWait(50, TimeUnit.SECONDS);

		WorkFlowCrt workflwcart = PageFactory.initElements(driver, WorkFlowCrt.class);

		// LogOut operation
		try {
			workflwcart.createWorkFlowBidSubmission();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		/**
		 * branch-Checker-Login functionality
		 */
		try {
			workflwcart.branchCheckerLogin(strngTenderId);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
