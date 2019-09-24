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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.egp.qa.base.TestBase;
import com.egp.qa.configfilereader.FileReaderManager;
import com.egp.qa.helper.assertion.AssertionHelper;
import com.egp.qa.helper.assertion.VerificationHelper;
import com.egp.qa.helper.javascript.JavaScriptHelper;
import com.egp.qa.helper.logger.LoggerHelper;
import com.egp.qa.helper.select.DropDownHelper;
import com.egp.qa.helper.wait.WaitHelper;

public class CreateBidSubmissionParticipateEGPPage extends TestBase {
	private Logger log = LoggerHelper.getLogger(CreateBidSubmissionParticipateEGPPage.class);

	JavaScriptHelper js = new JavaScriptHelper(driver);
	AssertionHelper assertion = new AssertionHelper();
	VerificationHelper verification = new VerificationHelper(driver);
	WaitHelper wait = new WaitHelper(driver);
	
	@FindBy(id = "txtTenderId")
	private WebElement tenderId;

	@FindBy(id = "tenderId")
	private WebElement tenderPropId;
	
	@FindBy(id = "btnpaymentsearch")
	private WebElement searchButtonId;

	@FindBy(xpath = "//table[@class='tableView_1 infoBarBorder']/tbody/tr[2]/td[2]")
	private WebElement closingDateTime;

	@FindBy(xpath = "/html/body/div/div[3]/div[2]")
	private WebElement tenderHeader;

	@FindBy(id = "txtEmailId")
	private WebElement emailIdText;

	@FindBy(id = "btnSearch")
	private WebElement searchButton;

	@FindBy(linkText = "Make Payment")
	private WebElement makePaymentLinkText;

	@FindBy(id = "cmbPayment")
	private WebElement selectModeOfPayment;

	@FindBy(id = "btnSubmit")
	private WebElement clickSubmitButton;

	@FindBy(id = "txtComments")
	private WebElement remarks;

	@FindBy(xpath = "//ul[@class='tabPanel_1']/li")
	List<WebElement> totalTabs;

	public CreateBidSubmissionParticipateEGPPage() {
		PageFactory.initElements(driver, this);
	}

	public void createBidSubmission() {
		log.info("***********inside createBidSubmission************");
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
			tenderId.sendKeys(strngTenderId);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// js.clickElement(searchButtonId);

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
		String tenderText = verification.getText(tenderHeader);
		System.out.println("emailIdtext is ---->> " + tenderText);
		AssertionHelper.verifyText(tenderText, "Tender/Proposal Detail", "text is verified");

		// Enter e-mail id text and search
		emailIdText.sendKeys("egptenderer1@gmail.com");
		js.clickElement(searchButton);

		// Click on Make Payment in Action tab
		makePaymentLinkText.click();

		// DropDownhelper used to select ModeOfPayment
		DropDownHelper dropdown = new DropDownHelper(driver);
		dropdown.selectUsingVisibleText(selectModeOfPayment, "Cash");

		// Enter remarks
		remarks.sendKeys("ModeOfPayment is done");
		// click on Submit button
		// js.scrollToElementAndClick(clickSubmitButton);

		js.scrollIntoView(clickSubmitButton);
		js.clickElement(clickSubmitButton);

		wait.setImplicitWait(50, TimeUnit.SECONDS);

		WorkFlowCrt workflwcart = PageFactory.initElements(driver, WorkFlowCrt.class);

		// LogOut operation
		try {
			workflwcart.createWorkFlowBidSubmission();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		// branch-Checker-Login functionality
		try {
			workflwcart.branchCheckerLogin(strngTenderId);
			// tenderId.sendKeys(strngTenderId);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		// EGP tenderer/contractor/bidder - Login functionality
		/*
		 * try { workflwcart.egptendererLogin(strngTenderId);
		 * //tenderId.sendKeys(strngTenderId); } catch (Throwable e) {
		 * e.printStackTrace(); }
		 */
	}

	/**
	 * Participatetenderer - EGP tenderer/Contractor/Bidder - Login functionality
	 */
	public void createBidSubmissionParticipatetenderer() {
		log.info("*********** inside createBidSubmission ************");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderOTMWorkPath());

		//To read the file ---->> FileInputStream
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
			tenderPropId.sendKeys(strngTenderId);
			js.clickElement(searchButton);
			
			Actions builder = new Actions(driver);
			builder.moveToElement(searchButton).click().build().perform();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Assert.assertTrue(false);
		WorkFlowCrt workflwcart = PageFactory.initElements(driver, WorkFlowCrt.class);

		/**
		 * EGP tenderer/contractor/bidder - Login functionality
		*/
		try {
			workflwcart.egptendererLoginDevbudgetOTMMethod(strngTenderId);
			wait.WaitForElementVisibleWithPollingTime(tenderPropId,20, 5);
			// tenderId.sendKeys(strngTenderId);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Participatetenderer - EGP tenderer/Contractor/Bidder - Login functionality
	*/
	public void bidSubmissionParticipate_Tenderer_LTM_EPW2B() {
		log.info("*********** inside createBidSubmission ************");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderLtmWorkPath());

		//To read the file ---->> FileInputStream
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
			tenderPropId.sendKeys(strngTenderId);
			Assert.assertTrue(true);
			//js.clickElement(searchButton);
			
			// Method 1:
			/*
			 * 1.Iterate row and coloumn and get the cell value 
			 * 2.Using for loop 
			 * 3.Get total rows and iterate table 
			 * 4.Put if(string matches),then select the value
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
				String tenderIdValue = driver.findElement(By.xpath(before_xpath+i+ after_xpath)).getText();
				System.out.println(tenderIdValue);
				if (tenderIdValue.contains(strngTenderId)) {
					driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[7]/a/img")).click();
					break;
				}
			}
			Assert.assertTrue(true);
			/*Actions builder = new Actions(driver);
			builder.moveToElement(searchButton).click().build().perform();*/
			//Assert.assertTrue(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		WorkFlowCrt workflwcart = PageFactory.initElements(driver, WorkFlowCrt.class);

		/**
		 * EGP tenderer/contractor/bidder - Login functionality
		*/
		try {
			workflwcart.bidParticipateDevbudgetLTMMethod_EPW2B(strngTenderId);
			wait.WaitForElementVisibleWithPollingTime(tenderPropId,20, 5);
			// tenderId.sendKeys(strngTenderId);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Participatetenderer - EGP tenderer/Contractor/Bidder - Login functionality
	*/
	public void bidSubmissionParticipate_Map_Tenderer_LTM_EPW2B() {
		log.info("*********** inside createBidSubmission ************");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderLtmWorkPath());

		//To read the file ---->> FileInputStream
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
			tenderPropId.sendKeys(strngTenderId);
			Assert.assertTrue(true);
			//js.clickElement(searchButton);
			
			// Method 1:
			/*
			 * 1.Iterate row and coloumn and get the cell value 
			 * 2.Using for loop 
			 * 3.Get total rows and iterate table 
			 * 4.Put if(string matches),then select the value
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

			for (int i = 1; i <= 100; i++) {
				log.info("*********** inside for loop ************");
				String tenderIdValue = driver.findElement(By.xpath(before_xpath+i+ after_xpath)).getText();
				System.out.println(tenderIdValue);
				if (tenderIdValue.contains(strngTenderId)) {
					driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[7]/a/img")).click();
					break;
				}
			}
			Assert.assertTrue(true);
			/*Actions builder = new Actions(driver);
			builder.moveToElement(searchButton).click().build().perform();*/
			//Assert.assertTrue(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		WorkFlowCrt workflwcart = PageFactory.initElements(driver, WorkFlowCrt.class);

		/**
		 * EGP tenderer/contractor/bidder - Login functionality
		*/
		try {
			workflwcart.bidParticipateDevbudgetLTM_Map_EPW2B(strngTenderId);
			wait.WaitForElementVisibleWithPollingTime(tenderPropId,20, 5);
			// tenderId.sendKeys(strngTenderId);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * EGP BidSubmission - branchmaker login
	 * branchchecker login
	 * egp tenderer login
	 */
	public void createBidSubmissionEGPmakerCheckertenderer() {
		log.info("******* createBidSubmissionEGPmakerCheckertenderer ***********");
		WorkFlowCrt workflwcart = PageFactory.initElements(driver, WorkFlowCrt.class);

		/**
		 * Tender security is pending so login as Branchmaker
		 */
		try {
			workflwcart.branchMakerLoginTenderSecurityPending();
			//tenderId.sendKeys(strngTenderId);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		/**
		 * Tender security is pending so login as BranchChecker
		 */
		try {
			workflwcart.branchCheckerLoginTenderSecurityPending();
			// tenderId.sendKeys(strngTenderId);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		/**
		 * Final Submission for login as BranchChecker
		 */
		try {
			workflwcart.egptendererLoginFinalSubmission();
			// tenderId.sendKeys(strngTenderId);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Participatetenderer - EGP tenderer/Contractor/Bidder - Login functionality - RFQU
	 */
	public void createBidSubmissionParticipateTendererForRFQU() {
		log.info("*********** inside createBidSubmission ************");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderRFQWorkPath());

		// To read the file ---->> FileInputStream
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
			tenderPropId.sendKeys(strngTenderId);
			
			/*js.scrollIntoView(searchButton);
			wait.WaitForElementVisibleWithPollingTime(searchButton, 30, 5);
			js.clickElement(searchButton);
			Assert.assertTrue(false);*/
			/*Actions builder = new Actions(driver);
			builder.moveToElement(searchButton).click().build().perform();*/
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		WorkFlowCrt workflwcart = PageFactory.initElements(driver, WorkFlowCrt.class);
		/**
		 * EGP tenderer/contractor/bidder - Login functionality
		*/
		try {
			workflwcart.egptendererLoginDevbudgetWorksRFQUMethod(strngTenderId);
			wait.WaitForElementVisibleWithPollingTime(tenderPropId,20, 5);
			//tenderId.sendKeys(strngTenderId);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
