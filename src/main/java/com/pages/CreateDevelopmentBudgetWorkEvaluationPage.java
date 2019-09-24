package com.pages;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.egp.qa.base.TestBase;
import com.egp.qa.configfilereader.FileReaderManager;
import com.egp.qa.helper.alert.AlertHelper;
import com.egp.qa.helper.assertion.AssertionHelper;
import com.egp.qa.helper.assertion.VerificationHelper;
import com.egp.qa.helper.frame.FrameHelper;
import com.egp.qa.helper.javascript.JavaScriptHelper;
import com.egp.qa.helper.logger.LoggerHelper;
import com.egp.qa.helper.select.DropDownHelper;
import com.egp.qa.helper.wait.WaitHelper;
import com.egp.qa.utilities.TestUtil;

public class CreateDevelopmentBudgetWorkEvaluationPage extends TestBase {
	private Logger log = LoggerHelper.getLogger(CreateDevelopmentBudgetWorkEvaluationPage.class);
	DropDownHelper dropdown = new DropDownHelper(driver);
	JavaScriptHelper js = new JavaScriptHelper(driver);
	WaitHelper wait = new WaitHelper(driver);
	VerificationHelper verification = new VerificationHelper(driver);
	AlertHelper al = new AlertHelper(driver);
	FrameHelper frame = new FrameHelper(driver);

	@FindBy(id = "txtAppId")
	private WebElement SerchAPPID;

	@FindBy(id = "tenderId")
	private WebElement tenderPropId;

	@FindBy(id = "txtTenderId")
	private WebElement tenderPropId1;

	@FindBy(id = "workflowId")
	private WebElement workFlowId;

	@FindBy(xpath = "//a[contains(text(),'Configure')]")
	private WebElement evalConfigurationLink;

	@FindBy(id = "cmbStatus")
	private WebElement statusValue;

	@FindBy(id = "txtAction")
	private WebElement actionDropDown;

	@FindBy(id = "tbnAdd")
	private WebElement buttonAdd;

	@FindBy(xpath = "//ul[@id='tabForApproved']/li")
	List<WebElement> totalTabs;

	@FindBy(xpath = "//*[@id='offTabPanel']/li/a")
	List<WebElement> totalTabsSize;

	@FindBy(xpath = "//ul[@class='tabPanel_1']/li/a")
	List<WebElement> totalTabsSizeText;

	@FindBy(xpath = "//ul[@class='tabPanel_1 noprint']/li/a")
	List<WebElement> totalTabsSizeCount;

	@FindBy(xpath = "//input[@id='btnSearch']")
	private WebElement searchButton;

	@FindBy(xpath = "//input[@id='btnSearchwf']")
	private WebElement searchButtonClick;

	@FindBy(xpath = "//div[@class='tabPanelArea_1']/table[1]/tbody/tr/td[2]/a[text()='View']")
	private WebElement viewLink;

	@FindBy(xpath = "//div[@class='tabPanelArea_1']/div/a")
	private WebElement advertisementLink;

	@FindBy(xpath = "//input[@id='txtNewsPaper']")
	private WebElement nameOfNewsPaper;

	@FindBy(xpath = "//input[@id='txtWeb']")
	private WebElement urlAdvertisementPage;

	@FindBy(xpath = "//input[@id='txtNAdvDt']")
	private WebElement advertisementDate;

	@FindBy(xpath = "//input[@id='txtWAdvDt']")
	private WebElement websiteAdvertisementDate;

	@FindBy(xpath = "//*[@id='btnSubmit']")
	private WebElement submitButton;

	@FindBy(xpath = "//input[@name='btnsubmit']")
	private WebElement submitButtonName;

	@FindBy(xpath = "//div[contains(text(),'Tender/Proposal Advertisement added successfully')]")
	private WebElement advertisementText;

	@FindBy(xpath = "//div[contains(text(),'Sent to TEC/PEC Chairperson successfully')]")
	private WebElement advertisementText3;

	@FindBy(xpath = "//div[contains(text(),'PQ Process initiated successfully')]")
	private WebElement pqProcessText;

	@FindBy(xpath = "//div[contains(text(),'PQ Process Completed successfully')]")
	private WebElement pqProcessComplete;

	@FindBy(xpath = "//div[contains(text(),'File processed successfully')]")
	private WebElement fileProcessSuccess;

	@FindBy(xpath = "//*[@id='trTOR']/td[2]/a[3]")
	private WebElement sendToTECPEC;

	@FindBy(xpath = "//a[text()='Send to TEC/PEC Chairperson']")
	private WebElement sendToTECPECChairPerson;

	@FindBy(xpath = "//textarea[@id='txtComments']")
	private WebElement comments;

	@FindBy(xpath = "//textarea[@id='txtcomments']")
	private WebElement comments1;

	@FindBy(xpath = "//input[@id='hdnbuttonTenderClose']")
	private WebElement submitButtonTest;

	@FindBy(xpath = "//input[@id='rbEvalTypeTeam']")
	private WebElement teamRadioButton;

	@FindBy(xpath = "//input[@id='rbTSCMember_1']")
	private WebElement aoUserRadioButton;

	@FindBy(xpath = "//div[contains(text(),'Configuration done successfully.')]")
	private WebElement sucessmsg;

	@FindBy(xpath = "//div[contains(text(),'Tender/Proposal Evaluation Report 1 prepared successfully')]")
	private WebElement tenderproposalevalreportsuccessmsg;

	@FindBy(xpath = "//div[contains(text(),'Successfully notified to Chairperson')]")
	private WebElement successNotifyMsg;

	@FindBy(xpath = "//div[contains(text(),'Nomination done Successfully!')]")
	private WebElement nominationmsg;

	@FindBy(xpath = "//div[contains(text(),'Declaration given successfully')]")
	private WebElement declarationmsg;

	@FindBy(xpath = "//table[@class='tableList_1 t_space']/tbody/tr[3]/td/a")
	private WebElement AOUSERLINK;

	@FindBy(xpath = "//*[@id='print_area']/form/table[5]/tbody/tr[2]/td[1]/a")
	private WebElement AOUSERLINK1;

	@FindBy(xpath = "//*[@id='print_area']/form/table[5]/tbody/tr[2]/td[1]/a")
	private WebElement TECPECUSERLINK1;

	@FindBy(xpath = "//*[@id='frmEvalClari']/div/div[4]/div[3]/table[1]/tbody/tr[2]/td[4]/a[2][text()='Evaluate Tenderer']")
	private WebElement evaluatetendererlink;
	
	@FindBy(xpath = "//*[@id='frmEvalClari']/div/div[4]/div[3]/table[1]/tbody/tr[3]/td[4]/a[2][text()='Evaluate Tenderer']")
	private WebElement evaluatetendererlinkNew;

	@FindBy(xpath = "//*[@id='fformtr_1']/td[3]/a")
	private WebElement evaluateformlink1;

	@FindBy(xpath = "//*[@id='fformtr_2']/td[3]/a")
	private WebElement evaluateformlink2;

	@FindBy(xpath = "//textarea[@id='evalNonCompRemarks']")
	private WebElement reason;

	@FindBy(xpath = "//input[@id='btnPost']")
	private WebElement submitPost;

	@FindBy(xpath = "//a[text()='Go back to Dashboard']")
	private WebElement dashboardButton;

	@FindBy(xpath = "//a[text()='Go Back to Dashboard']")
	private WebElement dashboardButton1;

	@FindBy(xpath = "//*[@id='print_area']/form/div[3]/label/input")
	private WebElement saveButtonInput;

	@FindBy(xpath = "//*[@id='print_area']/form/div[4]/label/input")
	private WebElement tenderSaveButton;

	@FindBy(xpath = "//*[@id='print_area']/form/div[4]/label")
	private WebElement saveButton1;

	@FindBy(xpath = "//input[@id='btnNotifyToTEC']")
	private WebElement notifyChairperson;

	@FindBy(xpath = "//a[contains(text(),'Fill Evaluation Form (Tender Evaluation Report 1)')]")
	private WebElement fillEvaluationForm1;

	@FindBy(xpath = "//a[contains(text(),'Fill Evaluation Form (Tender Evaluation Report 2)')]")
	private WebElement fillEvaluationForm2;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement logOut;

	@FindBy(xpath = "//a[contains(text(),'Consent for Nomination')]")
	private WebElement consentForNomination;

	@FindBy(id = "textfield")
	private WebElement password;

	@FindBy(xpath = "//a[contains(text(),'Hope User')]")
	private WebElement hopeUserLink;
	
	@FindBy(xpath = "//a[contains(text(),'Hope User TRAINING')]")
	private WebElement hopeUserLinkNew;
	
	@FindBy(xpath = "//*[@id='btnsubmit']")
	private WebElement signLink;

	@FindBy(xpath = "//a[contains(text(),'Mr. PE User')]")
	private WebElement peUserLink;

	@FindBy(xpath = "//a[contains(text(),'Finalize Responsiveness')]")
	private WebElement finalizeResponsivenessLink;
	
	@FindBy(xpath = "//*[@id='frmEvalClari']/div/div[4]/div[3]/table[1]/tbody/tr/td[2]/table/tbody/tr[2]/td[4]/a[text()='Finalize Responsiveness']")
	private WebElement finalizeResponsivenessLink1;
	
	@FindBy(xpath = "//*[@id='frmEvalClari']/div/div[4]/div[3]/table[1]/tbody/tr/td[2]/table/tbody/tr[3]/td[4]/a[text()='Finalize Responsiveness']")
	private WebElement finalizeResponsivenessLink2;

	@FindBy(xpath = "//input[@id='techQualify_0']")
	private WebElement technicalResponsiveRadioButton;

	@FindBy(xpath = "//*[@id='frmEvalClari']/div/div[4]/div[3]/table[2]/tbody/tr[4]/td[2]/a[2]")
	private WebElement tenderEvaluationReportConfigure1;

	@FindBy(xpath = "//*[@id='frmEvalClari']/div/div[4]/div[3]/table[2]/tbody/tr[5]/td[2]/a[2]")
	private WebElement tenderEvaluationReportConfigure2;

	@FindBy(xpath = "//a[contains(text(),'View and Sign')]")
	private WebElement viewAndSignLink;

	@FindBy(xpath = "//tr/td[contains(text(),'Tender Evaluation Report 1')]/following-sibling::td/a")
	private WebElement viewAndSignLink1;

	@FindBy(xpath = "//tr/td[contains(text(),'Tender Evaluation Report 2')]/following-sibling::td/a")
	private WebElement viewAndSignLink2;
	
	@FindBy(xpath = "//*[@id='round_1']/tr[3]/td[2]/a[4]")
	private WebElement viewAndSignLinkNew;
	
	@FindBy(xpath = "//*[@id='round_1']/tr[4]/td[2]/a[4]")
	private WebElement viewAndSignLinkNewLink;

	@FindBy(xpath = "//tr/td[contains(text(),'Price Comparison Report')]/following-sibling::td/a")
	private WebElement priceComparisionReportViewAndSave;

	@FindBy(xpath = "//input[@id='svBtn']")
	private WebElement saveReportButton;
	
	@FindBy(xpath = "//input[@id='svBtn']")
	private WebElement lotteryButton;
	
	@FindBy(xpath = "//*[@id='round_1']/tr[3]/td[2]/a[2]")
	private WebElement configure1;
	
	@FindBy(xpath = "//*[@id='round_1']/tr[4]/td[2]/a[2]")
	private WebElement configure2;
	
	@FindBy(xpath = "//*[@id='print_area']/form/div[3]/label/input")
	private WebElement saveValue;
	
	@FindBy(xpath = "//*[@id='print_area']/form/div[4]/label/input")
	private WebElement saveValueNew;

	@FindBy(xpath = "/html/body/div/div[2]/div[4]/div[2]/table/tbody/tr[2]/td[3]/a")
	private WebElement processLink;

	@FindBy(xpath = "//a[contains(text(),'Initiate')]")
	private WebElement initiateLink;

	@FindBy(xpath = "//input[@id='txtSiteVisitDate']")
	private WebElement siteVisitDateTime;

	@FindBy(xpath = "//a[contains(text(),'Complete')]")
	private WebElement completeLink;

	@FindBy(xpath = "//a[contains(text(),'Go back')]")
	private WebElement goBackbutton;

	// Tender evaluation report 3
	@FindBy(xpath = "//*[@id='round_1']/tr[3]/td[2]/a[text()='View and Sign']")
	private WebElement viewAndSignLink3;
	
	@FindBy(xpath = "//*[@id='round_1']/tr[5]/td[2]/a[text()='View and Sign']")
	private WebElement viewAndSignLink3NewLink;
	
	@FindBy(xpath = "//*[@id='print_area']/table[7]/tbody/tr[2]/td[2]/a[contains(text(),'Hope User TRAINING')]")
	private WebElement hopeUserLink3New;
	
	@FindBy(xpath = "//*[@id='print_area']/table[7]/tbody/tr[2]/td[2]/a[contains(text(),'Mr. PE User')]")
	private WebElement peUserLink3;
	
	@FindBy(xpath = "//*[@id='print_area']/form/table[5]/tbody/tr[2]/td[1]/a")
	private WebElement aoUserLink3;

	@FindBy(xpath = "//*[@id='RecommendedReTendering']/a")
	private WebElement aoUserLink4;
	
	@FindBy(xpath = "//*[@id='print_area']/table[7]/tbody/tr[2]/td[1]/a")
	private WebElement aoUserLink4New;
	
	@FindBy(xpath = "//*[@id='RecommendedReTendering']/a")
	private WebElement hopeUserLink4;

	@FindBy(xpath = "//*[@id='RecommendedReTendering']/a[text()='Mr. PE User']")
	private WebElement peUserLink4;

	// Tender evaluation report 4
	@FindBy(xpath = "//*[@id='round_1']/tr[4]/td[2]/a[text()='View and Sign']")
	private WebElement viewAndSignLink4;
	
	@FindBy(xpath = "//*[@id='round_1']/tr[6]/td[2]/a[text()='View and Sign']")
	private WebElement viewAndSignLink4New;
	
	@FindBy(xpath = "//*[@id='round_1']/tr[4]/td[2]/a[text()='View and Sign']")
	private WebElement viewAndSignLink4Edit;

	@FindBy(xpath = "//tr//td[contains(text(),'Contract Approval Workflow')]/following-sibling::*/a")
	private WebElement createLink;

	@FindBy(xpath = "//input[@id='textfield1']")
	private WebElement noOfReviewers;

	@FindBy(xpath = "//input[@id='button']")
	private WebElement submitButton1;

	@FindBy(xpath = "//input[@id='btnWfSubmit']")
	private WebElement submitButton2;

	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	private WebElement yesButton;

	@FindBy(xpath = "//a[contains(text(),'Process file in Workflow')]")
	private WebElement processFileWorkFlow;

	@FindBy(xpath = "//*[@id='cke_contents_txtComments']/iframe")
	private WebElement frameWindow;

	@FindBy(xpath = "//html[@contenteditable='true']")
	private WebElement commentsTextArea;

	// Tender Evaluation Report 3
	@FindBy(xpath = "//*[@id='round_1']/tr[3]/td[1]/following-sibling::td/a[2][text()='View and Sign']")
	private WebElement viewAndSignLinkTenderEvaluationReport3;

	@FindBy(xpath = "//*[@id='round_1']/tr[4]/td[1]/following-sibling::td/a[2][text()='View and Sign']")
	private WebElement viewAndSignLinkTenderEvaluationReport4;

	@FindBy(xpath = "//*[@id='resultTable']/tbody/tr/td[7]/a")
	private WebElement dashIconClick;

	@FindBy(xpath = "//*[@id='resultTable']/tbody/tr/td[8]/a")
	private WebElement dashIconClick1;

	public CreateDevelopmentBudgetWorkEvaluationPage() {
		PageFactory.initElements(driver, this);
	}

	public void createTenderDevBudgetWorksWithEvaluationTenderMethod() throws Throwable {
		log.info("************ createTenderDevBudgetWorksWithEvaluationTenderMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderOTMWorkPath());

		// To read the file --- FileInputStream
		FileInputStream fis = new FileInputStream(src);
		String strngTenderId = IOUtils.toString(fis);
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId.sendKeys(strngTenderId);

		wait.WaitForElementVisibleWithPollingTime(statusValue, 100, 30);
		dropdown.selectUsingVisibleText(statusValue, "Processing");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		wait.WaitForElementClickable(searchButton, 200);
		js.clickElement(searchButton);
		Thread.sleep(100);
		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();
		Thread.sleep(500);

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
			System.out.println("inside loop -->> " + name);
			if (name.contains(strngTenderId)) {
				wait.WaitForElementClickable(
						driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[7]/a/img")), 200);
				// driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +
				// "]/td[8]/a/img")).click();
				js.clickElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[7]/a/img")));
				break;
			}
		}

		for (int i = 0; i < totalTabsSize.size(); i++) {
			WebElement element = totalTabsSize.get(i);
			String text = totalTabsSize.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.equals("Evaluation")) {
				element.click();
				break;
			}
		}
		// Assert.assertTrue(false);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(viewLink);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		// Update advertisement - step 1
		js.clickElement(advertisementLink);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.sendKeys(driver, nameOfNewsPaper, 100, "times of bangladhesh");
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.selectDateByJavaScript(advertisementDate, "10/04/2019");
		TestUtil.sendKeys(driver, urlAdvertisementPage, 100, "https://www.training.eprocure.gov.bd");
		js.selectDateByJavaScript(websiteAdvertisementDate, "10/04/2019");
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(submitButton);

		String advertisementTextString1 = verification.getText(advertisementText);
		System.out.println("text fillSave1 is ---->> " + advertisementTextString1);
		AssertionHelper.verifyText(advertisementTextString1, "Tender/Proposal Advertisement added successfully",
				"text is verified");

		// Update advertisement - step 2
		js.clickElement(advertisementLink);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.sendKeys(driver, nameOfNewsPaper, 100, "times of dhaka");
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.selectDateByJavaScript(advertisementDate, "10/04/2019");
		TestUtil.sendKeys(driver, urlAdvertisementPage, 100, "https://www.training.dhaka.gov.bd");
		js.selectDateByJavaScript(websiteAdvertisementDate, "10/04/2019");
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(submitButton);

		// Verify text
		String advertisementTextString2 = verification.getText(advertisementText);
		System.out.println("text fillSave1 is ---->> " + advertisementTextString2);
		AssertionHelper.verifyText(advertisementTextString2, "Tender/Proposal Advertisement added successfully",
				"text is verified");

		for (int i = 0; i < totalTabsSize.size(); i++) {
			WebElement element = totalTabsSize.get(i);
			String text = totalTabsSize.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.equals("Opening")) {
				element.click();
				break;
			}
		}
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		wait.WaitForElementClickable(searchButton, 200);
		js.clickElement(sendToTECPECChairPerson);

		TestUtil.sendKeys(driver, comments, 100, "tested comments");
		wait.WaitForElementClickable(submitButtonTest, 200);
		js.clickElement(submitButtonTest);

		// Verify text
		String advertisementTextString3 = verification.getText(advertisementText3);
		System.out.println("text fillSave1 is ---->> " + advertisementTextString3);
		AssertionHelper.verifyText(advertisementTextString3, "Sent to TEC/PEC Chairperson successfully",
				"text is verified");
	}

	/**
	 * HOPEUSER login credentials
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluationChairPersonLoginFirstTestCaseMethod() throws InterruptedException {
		log.info("************ createTenderDevBudgetWorksEvaluationChairPersonLoginFirstTestCaseMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderOTMWorkPath());

		// To read the file --- FileInputStream
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String strngTenderId = null;
		try {
			strngTenderId = IOUtils.toString(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		wait.WaitForElementClickable(searchButton, 200);
		js.clickElement(searchButton);
		Thread.sleep(500);
		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();
		Thread.sleep(1000);

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
			System.out.println("inside loop -->> " + name);
			if (name.contains(strngTenderId)) {
				wait.WaitForElementClickable(
						driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")), 200);
				// driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +
				// "]/td[8]/a/img")).click();
				js.clickElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")));
				break;
			}
		}

		wait.WaitForElementClickable(evalConfigurationLink, 200);
		evalConfigurationLink.click();

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		if (!teamRadioButton.isSelected()) {
			TestUtil.clickOn(driver, teamRadioButton, 100);
		}

		// click on AO User radio Button
		if (!aoUserRadioButton.isSelected()) {
			TestUtil.clickOn(driver, aoUserRadioButton, 100);
		}

		js.clickElement(submitButton);

		// Verify text
		String sucessmsg1 = verification.getText(sucessmsg);
		System.out.println("text fillSave1 is ---->> " + sucessmsg1);
		AssertionHelper.verifyText(sucessmsg1, "Configuration done successfully.", "text is verified");

		TestUtil.clickOn(driver, logOut, 100);
	}

	/**
	 * TECUSER login credentials
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluation_MemberSecretaryLogin_SecondTestCaseMethod()
			throws InterruptedException {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationMemberSecretaryLoginSecondTestCaseMethod **********");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		wait.WaitForElementClickable(searchButton, 200);
		js.clickElement(searchButton);
		Thread.sleep(500);
		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();
		Thread.sleep(1000);

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
			System.out.println("inside loop -->> " + name);
			if (name.contains(strngTenderId)) {
				wait.WaitForElementClickable(
						driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")), 200);
				// driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +
				// "]/td[8]/a/img")).click();
				js.clickElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")));
				break;
			}
		}

		Assert.assertTrue(true);
		// click on Consent for nomination
		wait.WaitForElementClickable(consentForNomination, 200);
		TestUtil.clickOn(driver, consentForNomination, 100);

		wait.WaitForElementClickable(submitButton, 200);
		js.clickElement(submitButton);

		/*
		 * Alert al = driver.switchTo().alert(); al.accept();
		 */

		// Handling Alert pop up windows
		al.acceptAlert();

		// Verify text
		String nominationmsg1 = verification.getText(nominationmsg);
		System.out.println("nominationmsg is ---->> " + nominationmsg1);
		AssertionHelper.verifyText(nominationmsg1, "Nomination done Successfully!", "text is verified");

		// click on AO user link
		// table[@class='tableList_1 t_space']/tbody/tr[3]/td/a
		wait.WaitForElementClickable(AOUSERLINK, 200);
		TestUtil.clickOn(driver, AOUSERLINK, 100);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test comments");

		wait.WaitForElementClickable(submitButtonName, 200);
		js.clickElement(submitButtonName);

		// Verify text
		String declarationmsg1 = verification.getText(declarationmsg);
		System.out.println("declarationmsg1 is ---->> " + declarationmsg1);
		AssertionHelper.verifyText(declarationmsg1, "Declaration given successfully", "text is verified");

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.equals("Clarification")) {
				element.click();
				break;
			}
		}
		// Click on Evaluate tenderer
		wait.WaitForElementClickable(evaluatetendererlink, 200);
		TestUtil.clickOn(driver, evaluateformlink1, 100);
		TestUtil.sendKeys(driver, reason, 100, "egpdfgdfgfdgdfg12345");
		wait.WaitForElementClickable(submitPost, 200);
		TestUtil.clickOn(driver, submitPost, 100);

		wait.WaitForElementClickable(evaluateformlink2, 200);
		TestUtil.clickOn(driver, evaluateformlink2, 100);
		TestUtil.sendKeys(driver, reason, 100, "egpdfgdfgfdgdfg12345");

		wait.WaitForElementClickable(submitPost, 200);
		TestUtil.clickOn(driver, submitPost, 100);

		js.scrollIntoView(dashboardButton);
		wait.WaitForElementClickable(dashboardButton, 200);
		js.clickElement(dashboardButton);

		wait.WaitForElementClickable(fillEvaluationForm1, 200);
		js.clickElement(fillEvaluationForm1);
		wait.setImplicitWait(200, TimeUnit.SECONDS);
		js.scrollIntoView(saveButtonInput);

		wait.WaitForElementClickable(saveButtonInput, 200);
		js.clickElement(saveButtonInput);

		// Verify text
		String tenderproposalevalreportsuccessmsg1 = verification.getText(tenderproposalevalreportsuccessmsg);
		System.out.println("text fillSave1 is ---->> " + tenderproposalevalreportsuccessmsg1);
		AssertionHelper.verifyText(tenderproposalevalreportsuccessmsg1,
				"Tender/Proposal Evaluation Report 1 prepared successfully", "text is verified");

		// Fill Evaluation Form2
		wait.WaitForElementClickable(fillEvaluationForm2, 200);
		js.clickElement(fillEvaluationForm2);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(tenderSaveButton);
		wait.WaitForElementClickable(tenderSaveButton, 200);
		js.clickElement(tenderSaveButton);

		// Click on Notify Chairperson, if evaluation is finalised
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(notifyChairperson);
		wait.WaitForElementClickable(notifyChairperson, 200);
		js.clickElement(notifyChairperson);

		// Verify text
		String successNotifyMsg1 = verification.getText(successNotifyMsg);
		System.out.println("text fillSave1 is ---->> " + successNotifyMsg1);
		AssertionHelper.verifyText(successNotifyMsg1, "Successfully notified to Chairperson", "text is verified");

		js.scrollIntoView(logOut);
		// js.clickElement(logOut);
	}

	/**
	 * HOPEUSER - MEMBER _ SECRETARY _ LOGIN login credentials
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluationMemberSecretary_Login_Fifth_TestCaseMethod()
			throws InterruptedException {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationMemberSecretary_Login_Fifth_TestCaseMethod **********");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		wait.WaitForElementClickable(searchButton, 200);
		js.clickElement(searchButton);
		Thread.sleep(500);
		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();
		Thread.sleep(1000);

		// I am splitting 2nd coloumn nothing but second td.
		String before_xpath = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath = "]/td[2]";

		for (int i = 1; i <= 10; i++) {
			log.info("*********** inside for loop ************");
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println("inside loop -->> " + name);
			if (name.contains(strngTenderId)) {
				wait.WaitForElementClickable(
						driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")), 200);
				// driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +
				// "]/td[8]/a/img")).click();
				js.clickElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")));
				break;
			}
		}

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		wait.WaitForElementClickable(priceComparisionReportViewAndSave, 200);
		TestUtil.clickOn(driver, priceComparisionReportViewAndSave, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		wait.WaitForElementClickable(saveReportButton, 200);
		TestUtil.clickOn(driver, saveReportButton, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Post Qualification")) {
				element.click();
				break;
			}
		}
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		wait.WaitForElementClickable(processLink, 200);
		TestUtil.clickOn(driver, processLink, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		// Click on initiateLink
		wait.WaitForElementClickable(initiateLink, 200);
		TestUtil.clickOn(driver, initiateLink, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		js.selectDateByJavaScript(siteVisitDateTime, "17/04/2019");
		TestUtil.sendKeys(driver, comments, 100, "test comments");
		wait.WaitForElementClickable(submitButton, 200);
		js.clickElement(submitButton);

		// Verify text
		String pqProcessText1 = verification.getText(pqProcessText);
		System.out.println("text fillSave1 is ---->> " + pqProcessText1);
		AssertionHelper.verifyText(pqProcessText1, "PQ Process initiated successfully", "text is verified");

		// Click on complete link
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		wait.WaitForElementClickable(completeLink, 200);
		TestUtil.clickOn(driver, completeLink, 100);

		js.selectDateByJavaScript(siteVisitDateTime, "24/12/2018");
		TestUtil.sendKeys(driver, comments, 100, "test comments");
		wait.WaitForElementClickable(submitButton, 200);
		js.clickElement(submitButton);

		// Verify text
		String pqProcessComplete1 = verification.getText(pqProcessComplete);
		System.out.println("text fillSave1 is ---->> " + pqProcessComplete1);
		AssertionHelper.verifyText(pqProcessComplete1, "PQ Process Completed successfully", "text is verified");

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(goBackbutton);
		wait.WaitForElementClickable(goBackbutton, 200);
		js.clickElement(goBackbutton);

		/*
		 * for (int i = 0; i < totalTabsSizeText.size(); i++) { WebElement element =
		 * totalTabsSizeText.get(i); String text = totalTabsSizeText.get(i).getText();
		 * log.info("tabs are ---->> " + text);
		 * 
		 * if (text.contains("Eval. Report")) { element.click(); break; } }
		 */
	}

	/**
	 * HOPEUSER login credentials
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluationChairPersonLogin_Third_TestCaseMethod()
			throws InterruptedException {
		log.info("************ createTenderDevBudgetWorksEvaluationChairPersonLogin_Third_TestCaseMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderOTMWorkPath());

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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		wait.WaitForElementClickable(searchButton, 200);
		js.clickElement(searchButton);
		Thread.sleep(500);
		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();
		Thread.sleep(1000);

		// I am splitting 2nd coloumn nothing but second td.
		String before_xpath = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath = "]/td[2]";

		for (int i = 1; i <= 10; i++) {
			log.info("*********** inside for loop ************");
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println("inside loop -->> " + name);
			if (name.contains(strngTenderId)) {
				wait.WaitForElementClickable(
						driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")), 200);
				// driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +
				// "]/td[8]/a/img")).click();
				js.clickElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")));
				break;
			}
		}

		js.scrollIntoView(peUserLink);
		wait.WaitForElementClickable(peUserLink, 200);
		TestUtil.clickOn(driver, peUserLink, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test commentstest");

		wait.WaitForElementClickable(submitButtonName, 200);
		js.clickElement(submitButtonName);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		// Verify text
		String declarationmsg1 = verification.getText(declarationmsg);
		System.out.println("declarationmsg1 is ---->> " + declarationmsg1);
		AssertionHelper.verifyText(declarationmsg1, "Declaration given successfully", "text is verified");

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report ")) {
				element.click();
				break;
			}
		}

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		wait.WaitForElementClickable(finalizeResponsivenessLink, 200);
		TestUtil.clickOn(driver, finalizeResponsivenessLink, 100);

		// click on technical Responsive RadioButton
		if (!technicalResponsiveRadioButton.isSelected()) {
			wait.WaitForElementClickable(technicalResponsiveRadioButton, 200);
			TestUtil.clickOn(driver, technicalResponsiveRadioButton, 100);
		}

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		wait.WaitForElementClickable(submitButtonName, 200);
		js.clickElement(submitButtonName);

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		// Tender Evaluation Report 1 - configure click
		wait.WaitForElementClickable(tenderEvaluationReportConfigure1, 200);
		TestUtil.clickOn(driver, tenderEvaluationReportConfigure1, 100);

		// Save button input
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(saveButtonInput);
		wait.WaitForElementClickable(saveButtonInput, 200);
		js.clickElement(saveButtonInput);

		// Verify text
		String tenderproposalevalreportsuccessmsg1 = verification.getText(tenderproposalevalreportsuccessmsg);
		System.out.println("text fillSave1 is ---->> " + tenderproposalevalreportsuccessmsg1);
		AssertionHelper.verifyText(tenderproposalevalreportsuccessmsg1,
				"Tender/Proposal Evaluation Report 1 prepared successfully", "text is verified");

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		wait.WaitForElementClickable(viewAndSignLink, 200);
		TestUtil.clickOn(driver, viewAndSignLink, 100);

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(peUserLink);
		wait.WaitForElementClickable(peUserLink, 200);
		TestUtil.clickOn(driver, peUserLink, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test commentstest");
		wait.WaitForElementClickable(submitButtonName, 200);
		js.clickElement(submitButtonName);

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(dashboardButton1);
		wait.WaitForElementClickable(dashboardButton1, 200);
		js.clickElement(dashboardButton1);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		// Tender Evaluation Report2 --- Configure
		wait.WaitForElementClickable(tenderEvaluationReportConfigure2, 200);
		TestUtil.clickOn(driver, tenderEvaluationReportConfigure2, 100);

		js.scrollIntoView(saveButton1);
		wait.WaitForElementClickable(saveButton1, 200);
		js.clickElement(saveButton1);

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		wait.WaitForElementClickable(viewAndSignLink, 200);
		js.clickElement(viewAndSignLink);

		// Pe user link click
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(peUserLink);
		wait.WaitForElementClickable(peUserLink, 200);
		TestUtil.clickOn(driver, peUserLink, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test commentstest");
		wait.WaitForElementClickable(submitButtonName, 200);
		js.clickElement(submitButtonName);

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		wait.WaitForElementClickable(dashboardButton1, 200);
		js.clickElement(dashboardButton1);
	}

	/**
	 * AOUSER - MEMBER _ SECRETARY _ LOGIN login credentials
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluationMemberSecretary_Login_Fourth_TestCaseMethod()
			throws InterruptedException {
		log.info("************ createTenderDevBudgetWorksEvaluationChairPersonLogin_Third_TestCaseMethod **********");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		wait.WaitForElementClickable(searchButton, 200);
		js.clickElement(searchButton);
		Thread.sleep(500);
		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();
		Thread.sleep(1000);

		// I am splitting 2nd coloumn nothing but second td.
		String before_xpath = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath = "]/td[2]";

		for (int i = 1; i <= 10; i++) {
			log.info("*********** inside for loop ************");
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println("inside loop -->> " + name);
			if (name.contains(strngTenderId)) {
				wait.WaitForElementClickable(
						driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")), 200);
				// driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +
				// "]/td[8]/a/img")).click();
				js.clickElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")));
				break;
			}
		}
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		Assert.assertTrue(false);
		// Tender Evaluation Report 1 - View and Sign
		wait.WaitForElementClickable(viewAndSignLink1, 200);
		TestUtil.clickOn(driver, viewAndSignLink1, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		js.scrollIntoView(TECPECUSERLINK1);
		wait.WaitForElementClickable(TECPECUSERLINK1, 200);
		TestUtil.clickOn(driver, TECPECUSERLINK1, 100);

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test commentstest");

		wait.WaitForElementClickable(submitButtonName, 200);
		js.clickElement(submitButtonName);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(dashboardButton1);
		wait.WaitForElementClickable(dashboardButton1, 200);
		js.clickElement(dashboardButton1);

		// Tender Evaluation Report 2 - View and sign
		js.scrollIntoView(viewAndSignLink2);
		wait.WaitForElementClickable(viewAndSignLink2, 200);
		TestUtil.clickOn(driver, viewAndSignLink2, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		// click on AO USER link
		js.scrollIntoView(TECPECUSERLINK1);
		wait.WaitForElementClickable(TECPECUSERLINK1, 200);
		TestUtil.clickOn(driver, TECPECUSERLINK1, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test commentstest");

		// Click on Sign button
		wait.WaitForElementClickable(submitButtonName, 200);
		js.clickElement(submitButtonName);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		wait.WaitForElementClickable(dashboardButton1, 200);
		js.clickElement(dashboardButton1);

		wait.WaitForElementClickable(logOut, 200);
		TestUtil.clickOn(driver, logOut, 100);
	}

	/**
	 * AOUSER - MEMBER _ SECRETARY _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluation_ChairPerson_Login_Fifth_TestCaseMethod() {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationMemberSecretary_Login_Fifth_TestCaseMethod **********");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		// Price Comparison Report - click on ViewAndSave
		TestUtil.clickOn(driver, priceComparisionReportViewAndSave, 100);

		TestUtil.clickOn(driver, saveReportButton, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Post Qualification")) {
				element.click();
				break;
			}
		}
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, processLink, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, initiateLink, 100);

		js.selectDateByJavaScript(siteVisitDateTime, "01/04/2019");
		TestUtil.sendKeys(driver, comments, 100, "test comments");
		js.clickElement(submitButton);

		// Verify text
		String pqProcessText1 = verification.getText(pqProcessText);
		System.out.println("text fillSave1 is ---->> " + pqProcessText1);
		AssertionHelper.verifyText(pqProcessText1, "PQ Process initiated successfully", "text is verified");

		// click on complete link
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, completeLink, 100);

		js.selectDateByJavaScript(siteVisitDateTime, "24/12/2018");
		TestUtil.sendKeys(driver, comments, 100, "test comments");
		js.clickElement(submitButton);

		// Verify text
		String pqProcessComplete1 = verification.getText(pqProcessComplete);
		System.out.println("text fillSave1 is ---->> " + pqProcessComplete1);
		AssertionHelper.verifyText(pqProcessComplete1, "PQ Process Completed successfully", "text is verified");

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(goBackbutton);
		js.clickElement(goBackbutton);

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}
	}

	/**
	 * AOUSER - MEMBER _ SECRETARY _ LOGIN login credentials
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluationMemberSecretary_Login_Sixth_TestCaseMethod()
			throws InterruptedException {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationMemberSecretary_Login_Fifth_TestCaseMethod **********");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		wait.WaitForElementClickable(searchButton, 200);
		js.clickElement(searchButton);
		Thread.sleep(500);
		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();
		Thread.sleep(1000);

		// I am splitting 2nd coloumn nothing but second td.
		String before_xpath = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath = "]/td[2]";

		for (int i = 1; i <= 10; i++) {
			log.info("*********** inside for loop ************");
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println("inside loop -->> " + name);
			if (name.contains(strngTenderId)) {
				wait.WaitForElementClickable(
						driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")), 200);
				// driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +
				// "]/td[8]/a/img")).click();
				js.clickElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")));
				break;
			}
		}

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}

		// Tender Evaluation Report 3 ---- Click on View and Sign
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		wait.WaitForElementClickable(viewAndSignLink3, 200);
		TestUtil.clickOn(driver, viewAndSignLink3, 100);

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(peUserLink3);
		wait.WaitForElementClickable(peUserLink3, 200);
		TestUtil.clickOn(driver, peUserLink3, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test comments");
		wait.WaitForElementClickable(submitButtonName, 200);
		js.clickElement(submitButtonName);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(dashboardButton1);
	}

	/**
	 * HOPEUSER - MEMBER _ SECRETARY _ LOGIN login credentials
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluationMemberSecretary_Login_Seventh_TestCaseMethod()
			throws InterruptedException {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationMemberSecretary_Login_Seventh_TestCaseMethod **********");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		wait.WaitForElementClickable(searchButton, 200);
		js.clickElement(searchButton);
		Thread.sleep(500);
		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();
		Thread.sleep(1000);

		// I am splitting 2nd coloumn nothing but second td.
		String before_xpath = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath = "]/td[2]";

		for (int i = 1; i <= 10; i++) {
			log.info("*********** inside for loop ************");
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println("inside loop -->> " + name);
			if (name.contains(strngTenderId)) {
				wait.WaitForElementClickable(
						driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")), 200);
				// driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +
				// "]/td[8]/a/img")).click();
				js.clickElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")));
				break;
			}
		}

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}
		
		// Tender Evaluation Report 4 ---- Click on View and Sign
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		wait.WaitForElementClickable(viewAndSignLink4, 200);
		TestUtil.clickOn(driver, viewAndSignLink4, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		
		js.scrollIntoView(peUserLink4);
		wait.WaitForElementClickable(viewAndSignLink4, 200);
		TestUtil.clickOn(driver, peUserLink4, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test comments");
		wait.WaitForElementClickable(submitButtonName, 200);
		js.clickElement(submitButtonName);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(dashboardButton1);
		wait.WaitForElementClickable(dashboardButton1, 200);
		js.clickElement(dashboardButton1);
		TestUtil.clickOn(driver, logOut, 100);
	}

	/**
	 * PEUSER - Contract Approval Workflow _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluation_ContractWorkFlow_PE_Login_Eight_TestCaseMethod() {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationMemberSecretary_Login_Fifth_TestCaseMethod **********");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId.sendKeys(strngTenderId);

		// status dropdown
		dropdown.selectUsingVisibleText(statusValue, "Processing");

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		// click on searchbutton
		// js.clickElement(searchButton);

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[7]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[7]/a"))).click()
					.build().perform();
		}

		for (int i = 0; i < totalTabsSizeCount.size(); i++) {
			WebElement element = totalTabsSizeCount.get(i);
			String text = totalTabsSizeCount.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Evaluation")) {
				element.click();
				break;
			}
		}

		TestUtil.clickOn(driver, createLink, 100);

		// Handling Alert pop up windows
		al.acceptAlert();

		TestUtil.sendKeys(driver, noOfReviewers, 100, "0");

		noOfReviewers.sendKeys(Keys.TAB);
		js.scrollIntoView(submitButton1);
		js.clickElement(submitButton1);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(submitButton2);
		js.clickElement(submitButton2);

		TestUtil.clickOn(driver, yesButton, 100);
		TestUtil.clickOn(driver, logOut, 100);
	}

	/**
	 * HOPE USER - CHAIR PERSON _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluationChairPerson_Login_Nineth_TestCaseMethod() {
		log.info("************ createTenderDevBudgetWorksEvaluationChairPerson_Login_Nineth_TestCaseMethod **********");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}

		js.scrollIntoView(processFileWorkFlow);
		js.clickElement(processFileWorkFlow);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		// driver.switchTo().frame(1);
		frame.switchToFrame(frameWindow);
		TestUtil.sendKeys(driver, commentsTextArea, 100, "Pls approve my evaluation tender");
		driver.switchTo().defaultContent();
		dropdown.selectUsingVisibleText(actionDropDown, "Forward");
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(buttonAdd);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		// Verify text
		String fileProcessSuccess1 = verification.getText(fileProcessSuccess);
		System.out.println("text fileProcessSuccess is ---->> " + fileProcessSuccess1);
		AssertionHelper.verifyText(fileProcessSuccess1, "File processed successfully", "text is verified");

		TestUtil.clickOn(driver, logOut, 100);
	}

	/**
	 * HOPE USER - CHAIR PERSON _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluationChairPersonWorkFlow_Login_Tenth_TestCaseMethod() {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationChairPersonWorkFlow_Login_Tenth_TestCaseMethod **********");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		workFlowId.sendKeys(strngTenderId);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButtonClick).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='1']/td[9]/a[contains(text(),'Process')]")))
					.click().build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			// builder.moveToElement(driver.findElement(By.xpath("//*[@id='1']/td[9]/a[contains(text(),'Process')]"))).click().build().perform();
		}

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		// driver.switchTo().frame(1);
		frame.switchToFrame(frameWindow);
		TestUtil.sendKeys(driver, commentsTextArea, 100, "Pls approve my evaluation tender");
		driver.switchTo().defaultContent();
		dropdown.selectUsingVisibleText(actionDropDown, "Approve");
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(buttonAdd);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		// Verify text
		String fileProcessSuccess1 = verification.getText(fileProcessSuccess);
		System.out.println("text fileProcessSuccess is ---->> " + fileProcessSuccess1);
		AssertionHelper.verifyText(fileProcessSuccess1, "File processed successfully", "text is verified");

		TestUtil.clickOn(driver, logOut, 100);
	}

	/*****************
	 * createTenderDevBudgetWorksEvaluation_Advertisement_Method
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluation_Advertisement_Method() throws Throwable {
		log.info("************ createTenderDevBudgetWorksWithOpenTendorMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderRFQWorkPath());

		// To read the file --- FileInputStream
		FileInputStream fis = new FileInputStream(src);
		String strngTenderId = IOUtils.toString(fis);
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId.sendKeys(strngTenderId);

		dropdown.selectUsingVisibleText(statusValue, "Processing");
		Thread.sleep(500);
		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[7]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[7]/a"))).click()
					.build().perform();
		}

		for (int i = 0; i < totalTabsSize.size(); i++) {
			WebElement element = totalTabsSize.get(i);
			String text = totalTabsSize.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.equals("Evaluation")) {
				element.click();
				break;
			}
		}
		// Assert.assertTrue(false);
		wait.WaitForElementClickable(viewLink, 500);
		js.clickElement(viewLink);
		wait.WaitForElementClickable(advertisementLink, 500);

		// Update advertisement - step 1
		js.clickElement(advertisementLink);
		wait.waitForElement(nameOfNewsPaper, 100);
		TestUtil.sendKeys(driver, nameOfNewsPaper, 100, "times of bangladhesh");
		wait.waitForElement(advertisementDate, 100);
		js.selectDateByJavaScript(advertisementDate, "01/04/2019");
		TestUtil.sendKeys(driver, urlAdvertisementPage, 100, "https://www.training.eprocure.gov.bd");
		wait.waitForElement(websiteAdvertisementDate, 100);
		js.selectDateByJavaScript(websiteAdvertisementDate, "01/04/2019");
		wait.WaitForElementClickable(submitButton, 500);
		js.clickElement(submitButton);

		String advertisementTextString1 = verification.getText(advertisementText);
		System.out.println("text fillSave1 is ---->> " + advertisementTextString1);
		AssertionHelper.verifyText(advertisementTextString1, "Tender/Proposal Advertisement added successfully",
				"text is verified");

		// Update advertisement - step 2
		wait.WaitForElementClickable(advertisementLink, 500);
		js.clickElement(advertisementLink);
		TestUtil.sendKeys(driver, nameOfNewsPaper, 100, "times of dhaka");
		wait.waitForElement(advertisementDate, 100);
		js.selectDateByJavaScript(advertisementDate, "01/04/2019");
		TestUtil.sendKeys(driver, urlAdvertisementPage, 100, "https://www.training.dhaka.gov.bd");
		wait.waitForElement(websiteAdvertisementDate, 100);
		js.selectDateByJavaScript(websiteAdvertisementDate, "01/04/2019");
		wait.WaitForElementClickable(submitButton, 500);
		js.clickElement(submitButton);

		// Verify text
		String advertisementTextString2 = verification.getText(advertisementText);
		System.out.println("text fillSave1 is ---->> " + advertisementTextString2);
		AssertionHelper.verifyText(advertisementTextString2, "Tender/Proposal Advertisement added successfully",
				"text is verified");

		for (int i = 0; i < totalTabsSize.size(); i++) {
			WebElement element = totalTabsSize.get(i);
			String text = totalTabsSize.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.equals("Opening")) {
				element.click();
				break;
			}
		}
		wait.WaitForElementClickable(sendToTECPECChairPerson, 500);
		js.clickElement(sendToTECPEC);

		TestUtil.sendKeys(driver, comments, 100, "tested comments");
		wait.WaitForElementClickable(submitButtonTest, 500);
		js.clickElement(submitButtonTest);

		// Verify text
		String advertisementTextString3 = verification.getText(advertisementText3);
		System.out.println("text fillSave1 is ---->> " + advertisementTextString3);
		AssertionHelper.verifyText(advertisementTextString3, "Sent to TEC/PEC Chairperson successfully",
				"text is verified");
	}

	/**
	 * HOPEUSER login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksRFQUEvaluationChairPersonLoginFirstTestCaseMethod() {
		log.info("************ createTenderDevBudgetWorksEvaluationChairPersonLoginFirstTestCaseMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderRFQWorkPath());

		// To read the file --- FileInputStream
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String strngTenderId = null;
		try {
			strngTenderId = IOUtils.toString(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}

		wait.WaitForElementClickable(evalConfigurationLink, 500);
		evalConfigurationLink.click();

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		if (!teamRadioButton.isSelected()) {
			TestUtil.clickOn(driver, teamRadioButton, 100);
		}

		// click on AO User radio Button
		if (!aoUserRadioButton.isSelected()) {
			TestUtil.clickOn(driver, aoUserRadioButton, 100);
		}

		wait.WaitForElementClickable(evalConfigurationLink, 500);
		js.clickElement(submitButton);

		// Verify text
		String sucessmsg1 = verification.getText(sucessmsg);
		System.out.println("text fillSave1 is ---->> " + sucessmsg1);
		AssertionHelper.verifyText(sucessmsg1, "Configuration done successfully.", "text is verified");

		TestUtil.clickOn(driver, logOut, 100);
	}

	/**
	 * AOUSER login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluationRFQU_MemberSecretaryLogin_SecondTestCaseMethod() {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationMemberSecretaryLoginSecondTestCaseMethod **********");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}

		// Click on Consent for nomination
		TestUtil.clickOn(driver, consentForNomination, 100);
		// Assert.assertTrue(false);
		wait.WaitForElementClickable(submitButton, 500);
		js.clickElement(submitButton);

		// Handling Alert pop up windows
		al.acceptAlert();

		// Verify text
		String nominationmsg1 = verification.getText(nominationmsg);
		AssertionHelper.verifyText(nominationmsg1, "Nomination done Successfully!", "text is verified");

		// click on AO user link
		// table[@class='tableList_1 t_space']/tbody/tr[3]/td/a
		TestUtil.clickOn(driver, AOUSERLINK, 100);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments, 100, "test comments");

		wait.WaitForElementClickable(submitButtonName, 500);
		js.clickElement(submitButtonName);

		// Verify text
		String declarationmsg1 = verification.getText(declarationmsg);
		System.out.println("declarationmsg1 is ---->> " + declarationmsg1);
		AssertionHelper.verifyText(declarationmsg1, "Declaration given successfully", "text is verified");

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.equals("Clarification")) {
				element.click();
				break;
			}
		}
		// Click on Evaluate tenderer
		TestUtil.clickOn(driver, evaluatetendererlink, 100);

		// Click on Evaluate Form1
		TestUtil.clickOn(driver, evaluateformlink1, 100);
		TestUtil.sendKeys(driver, reason, 100, "tendeor delay");
		TestUtil.clickOn(driver, submitPost, 100);

		// Click on Evaluate Form2
		TestUtil.clickOn(driver, evaluateformlink2, 100);
		TestUtil.sendKeys(driver, reason, 100, "tendeor delay 2");
		TestUtil.clickOn(driver, submitPost, 100);

		js.scrollIntoView(dashboardButton);
		js.clickElement(dashboardButton);

		// Fill Evaluation Form (Tender Evaluation Report 1)
		wait.WaitForElementClickable(fillEvaluationForm1, 500);
		js.clickElement(fillEvaluationForm1);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(saveButtonInput);

		js.clickElement(saveButtonInput);

		// Verify text
		String tenderproposalevalreportsuccessmsg1 = verification.getText(tenderproposalevalreportsuccessmsg);
		System.out.println("text fillSave1 is ---->> " + tenderproposalevalreportsuccessmsg1);
		AssertionHelper.verifyText(tenderproposalevalreportsuccessmsg1,
				"Tender/Proposal Evaluation Report 1 prepared successfully", "text is verified");

		// Fill Evaluation Form (Tender Evaluation Report 2)
		wait.WaitForElementClickable(fillEvaluationForm2, 500);
		js.clickElement(fillEvaluationForm2);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(tenderSaveButton);

		js.clickElement(tenderSaveButton);

		// Click on Notify Chairperson, if evaluation is finalised
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(notifyChairperson);
		js.clickElement(notifyChairperson);

		// Verify text
		String successNotifyMsg1 = verification.getText(successNotifyMsg);
		System.out.println("text fillSave1 is ---->> " + successNotifyMsg1);
		AssertionHelper.verifyText(successNotifyMsg1, "Successfully notified to Chairperson", "text is verified");

		js.scrollIntoView(logOut);
		js.clickElement(logOut);
	}

	/**
	 * HOPEUSER login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksRFQUEvaluationChairPersonLogin_Third_TestCaseMethod() {
		log.info("************ createTenderDevBudgetWorksEvaluationChairPersonLogin_Third_TestCaseMethod **********");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}

		js.scrollIntoView(hopeUserLink);
		TestUtil.clickOn(driver, hopeUserLink, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test commentstest");

		wait.WaitForElementClickable(submitButtonName, 500);
		js.clickElement(submitButtonName);

		// Verify text
		String declarationmsg1 = verification.getText(declarationmsg);
		System.out.println("declarationmsg1 is ---->> " + declarationmsg1);
		AssertionHelper.verifyText(declarationmsg1, "Declaration given successfully", "text is verified");

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report ")) {
				element.click();
				break;
			}
		}

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, finalizeResponsivenessLink, 100);

		// click on technical Responsive RadioButton
		if (!technicalResponsiveRadioButton.isSelected()) {
			TestUtil.clickOn(driver, technicalResponsiveRadioButton, 100);
		}

		wait.WaitForElementClickable(submitButtonName, 500);
		js.clickElement(submitButtonName);

		wait.setImplicitWait(100, TimeUnit.SECONDS);

		// Tender Evaluation Report 1
		TestUtil.clickOn(driver, tenderEvaluationReportConfigure1, 100);

		// Save button input
		js.scrollIntoView(saveButtonInput);
		js.clickElement(saveButtonInput);

		// Verify text
		String tenderproposalevalreportsuccessmsg1 = verification.getText(tenderproposalevalreportsuccessmsg);
		System.out.println("text fillSave1 is ---->> " + tenderproposalevalreportsuccessmsg1);
		AssertionHelper.verifyText(tenderproposalevalreportsuccessmsg1,
				"Tender/Proposal Evaluation Report 1 prepared successfully", "text is verified");

		// Tender Evaluation Report 1
		TestUtil.clickOn(driver, viewAndSignLink, 100);

		js.scrollIntoView(hopeUserLink);
		TestUtil.clickOn(driver, hopeUserLink, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test commentstest");
		wait.WaitForElementClickable(submitButtonName, 500);
		js.clickElement(submitButtonName);

		// Go back to Dashboard
		wait.WaitForElementClickable(dashboardButton1, 500);
		js.clickElement(dashboardButton1);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		// Tender Evaluation Report 2
		TestUtil.clickOn(driver, tenderEvaluationReportConfigure2, 100);

		js.scrollIntoView(saveButton1);
		wait.WaitForElementClickable(saveButton1, 500);
		js.clickElement(saveButton1);

		// Tender Evaluation Report 2
		wait.WaitForElementClickable(viewAndSignLink, 500);
		js.clickElement(viewAndSignLink);

		// Hope user link click
		wait.WaitForElementClickable(hopeUserLink, 500);
		js.scrollIntoView(hopeUserLink);
		TestUtil.clickOn(driver, hopeUserLink, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test commentstest");
		wait.WaitForElementClickable(submitButtonName, 500);
		js.clickElement(submitButtonName);

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		wait.WaitForElementClickable(dashboardButton1, 500);
		js.clickElement(dashboardButton1);
	}

	/**
	 * AOUSER - MEMBER _ SECRETARY _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksRFQU_EvaluationMemberSecretary_Login_Fourth_TestCaseMethod() {
		log.info("************ createTenderDevBudgetWorksEvaluationChairPersonLogin_Third_TestCaseMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderRFQWorkPath());

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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}
		// Tender Evaluation Report 1
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, viewAndSignLink1, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(AOUSERLINK1);
		TestUtil.clickOn(driver, AOUSERLINK1, 100);
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test commentstest");

		js.clickElement(submitButtonName);
		js.clickElement(dashboardButton1);

		// Tender Evaluation Report 2
		js.scrollIntoView(viewAndSignLink2);
		TestUtil.clickOn(driver, viewAndSignLink2, 100);

		// click on AO USER link
		js.scrollIntoView(AOUSERLINK1);
		TestUtil.clickOn(driver, AOUSERLINK1, 100);
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test commentstest");

		js.clickElement(submitButtonName);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(dashboardButton1);

		TestUtil.clickOn(driver, logOut, 100);
	}

	/**
	 * HOPEUSER - MEMBER _ SECRETARY _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksRFQU_EvaluationMemberSecretary_Login_Fifth_TestCaseMethod() {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationMemberSecretary_Login_Fifth_TestCaseMethod **********");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, priceComparisionReportViewAndSave, 100);

		TestUtil.clickOn(driver, saveReportButton, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Post Qualification")) {
				element.click();
				break;
			}
		}
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, processLink, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, initiateLink, 100);

		js.selectDateByJavaScript(siteVisitDateTime, "03/04/2019");
		TestUtil.sendKeys(driver, comments, 100, "test comments");
		js.clickElement(submitButton);

		// Verify text
		String pqProcessText1 = verification.getText(pqProcessText);
		System.out.println("text fillSave1 is ---->> " + pqProcessText1);
		AssertionHelper.verifyText(pqProcessText1, "PQ Process initiated successfully", "text is verified");

		// click on complete link
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, completeLink, 100);

		js.selectDateByJavaScript(siteVisitDateTime, "02/04/2018");
		TestUtil.sendKeys(driver, comments, 100, "test comments");
		js.clickElement(submitButton);

		// Verify text
		String pqProcessComplete1 = verification.getText(pqProcessComplete);
		System.out.println("text fillSave1 is ---->> " + pqProcessComplete1);
		AssertionHelper.verifyText(pqProcessComplete1, "PQ Process Completed successfully", "text is verified");

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(goBackbutton);
		js.clickElement(goBackbutton);

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}

		// Tender Evaluation Report 3
		// *[@id='round_1']/tr[3]/td[1]/following-sibling::td/a[2][text()='View and
		// Sign']

		/*
		 * wait.waitForElement(viewAndSignLinkTenderEvaluationReport3, 100, 10);
		 * TestUtil.clickOn(driver, viewAndSignLinkTenderEvaluationReport3, 100);
		 * 
		 * //Click on Hope user TestUtil.clickOn(driver, hopeUserLink, 100);
		 * TestUtil.sendKeys(driver, password, 100, "egp12345");
		 * TestUtil.sendKeys(driver, comments1, 100, "test comments");
		 * js.clickElement(submitButtonName);
		 * 
		 * js.scrollIntoView(dashboardButton); js.clickElement(dashboardButton);
		 * 
		 * // Tender Evaluation Report 4
		 * wait.waitForElement(viewAndSignLinkTenderEvaluationReport4, 100, 10);
		 * TestUtil.clickOn(driver, viewAndSignLinkTenderEvaluationReport4, 100);
		 * //Click on Hope user TestUtil.clickOn(driver, hopeUserLink, 100);
		 * TestUtil.sendKeys(driver, password, 100, "egp12345");
		 * TestUtil.sendKeys(driver, comments1, 100, "test comments");
		 * js.clickElement(submitButtonName);
		 */
	}

	/**
	 * AOUSER - MEMBER _ SECRETARY _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksRFQU_Evaluation_MemberSecretary_Login_Sixth_TestCaseMethod() {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationMemberSecretary_Login_Fifth_TestCaseMethod **********");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}

		// Tender Evaluation Report 3 ---- Click on View and Sign
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, viewAndSignLink3, 100);
		js.scrollIntoView(peUserLink3);
		TestUtil.clickOn(driver, peUserLink3, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test comments");
		js.clickElement(submitButtonName);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(dashboardButton1);
	}

	/**
	 * HOPEUSER - MEMBER _ SECRETARY _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluationRFQU_MemberSecretary_Login_Seventh_TestCaseMethod() {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationMemberSecretary_Login_Seventh_TestCaseMethod **********");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}

		// Tender Evaluation Report 4 ---- Click on View and Sign
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, viewAndSignLink4Edit, 100);
		js.scrollIntoView(peUserLink4);
		TestUtil.clickOn(driver, peUserLink4, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test comments");
		js.clickElement(submitButtonName);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(dashboardButton1);
		TestUtil.clickOn(driver, logOut, 100);
	}

	/**
	 * PEUSER - Contract Approval Workflow _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluationRFQU_ContractWorkFlow_PE_Login_Eight_TestCaseMethod() {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationMemberSecretary_Login_Fifth_TestCaseMethod **********");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId.sendKeys(strngTenderId);

		// status dropdown
		dropdown.selectUsingVisibleText(statusValue, "Processing");

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		// click on searchbutton
		// js.clickElement(searchButton);

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[7]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[7]/a"))).click()
					.build().perform();
		}

		for (int i = 0; i < totalTabsSizeCount.size(); i++) {
			WebElement element = totalTabsSizeCount.get(i);
			String text = totalTabsSizeCount.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Evaluation")) {
				element.click();
				break;
			}
		}

		TestUtil.clickOn(driver, createLink, 100);

		// Handling Alert pop up windows
		al.acceptAlert();

		TestUtil.sendKeys(driver, noOfReviewers, 100, "0");

		noOfReviewers.sendKeys(Keys.TAB);
		js.scrollIntoView(submitButton1);
		js.clickElement(submitButton1);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(submitButton2);
		js.clickElement(submitButton2);

		TestUtil.clickOn(driver, yesButton, 100);
		TestUtil.clickOn(driver, logOut, 100);
	}

	/**
	 * HOPE USER - CHAIR PERSON _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluationRFQU_ChairPerson_Login_Nineth_TestCaseMethod() {
		log.info("************ createTenderDevBudgetWorksEvaluationChairPerson_Login_Nineth_TestCaseMethod **********");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}

		js.scrollIntoView(processFileWorkFlow);
		js.clickElement(processFileWorkFlow);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		// driver.switchTo().frame(1);
		frame.switchToFrame(frameWindow);
		TestUtil.sendKeys(driver, commentsTextArea, 100, "Pls approve my evaluation tender");
		driver.switchTo().defaultContent();
		dropdown.selectUsingVisibleText(actionDropDown, "Forward");
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(buttonAdd);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		// Verify text
		String fileProcessSuccess1 = verification.getText(fileProcessSuccess);
		System.out.println("text fileProcessSuccess is ---->> " + fileProcessSuccess1);
		AssertionHelper.verifyText(fileProcessSuccess1, "File processed successfully", "text is verified");

		TestUtil.clickOn(driver, logOut, 100);
	}

	/**
	 * HOPE USER - CHAIR PERSON _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluationRFQU_ChairPersonWorkFlow_Login_Tenth_TestCaseMethod() {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationChairPersonWorkFlow_Login_Tenth_TestCaseMethod **********");
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		workFlowId.sendKeys(strngTenderId);

		TestUtil.clickOn(driver, searchButtonClick, 200);
		Actions builder = new Actions(driver);
		builder.moveToElement(searchButtonClick).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='1']/td[9]/a[contains(text(),'Process')]")))
					.click().build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			// builder.moveToElement(driver.findElement(By.xpath("//*[@id='1']/td[9]/a[contains(text(),'Process')]"))).click().build().perform();
		}

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		// driver.switchTo().frame(1);
		frame.switchToFrame(frameWindow);
		TestUtil.sendKeys(driver, commentsTextArea, 100, "Pls approve my evaluation tender");
		driver.switchTo().defaultContent();
		dropdown.selectUsingVisibleText(actionDropDown, "Approve");
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(buttonAdd);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		// Verify text
		String fileProcessSuccess1 = verification.getText(fileProcessSuccess);
		System.out.println("text fileProcessSuccess is ---->> " + fileProcessSuccess1);
		AssertionHelper.verifyText(fileProcessSuccess1, "File processed successfully", "text is verified");

		TestUtil.clickOn(driver, logOut, 100);
	}
	
	
	/*****************
	 * createTenderDevBudgetWorksEvaluation_LTM_EPW2B_Advertisement_Method
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluation_LTM_EPW2B_Advertisement_Method() throws Throwable {
		log.info("************ createTenderDevBudgetWorksWithOpenTendorMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderLtmWorkPath());

		// To read the file --- FileInputStream
		FileInputStream fis = new FileInputStream(src);
		String strngTenderId = IOUtils.toString(fis);
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId.sendKeys(strngTenderId);

		dropdown.selectUsingVisibleText(statusValue, "Processing");
		Thread.sleep(500);
		TestUtil.clickOn(driver, searchButton, 200);
		Assert.assertTrue(true);
		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[7]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[7]/a"))).click()
					.build().perform();
		}
		
		for (int i = 0; i < totalTabsSize.size(); i++) {
			WebElement element = totalTabsSize.get(i);
			String text = totalTabsSize.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.equals("Evaluation")) {
				element.click();
				break;
			}
		}
		// Assert.assertTrue(false);
		wait.WaitForElementClickable(viewLink, 500);
		js.clickElement(viewLink);
		wait.WaitForElementClickable(advertisementLink, 500);

		// Update advertisement - step 1
		js.clickElement(advertisementLink);
		wait.waitForElement(nameOfNewsPaper, 100);
		TestUtil.sendKeys(driver, nameOfNewsPaper, 100, "times of bangladhesh");
		wait.waitForElement(advertisementDate, 100);
		js.selectDateByJavaScript(advertisementDate, "11/07/2019");
		TestUtil.sendKeys(driver, urlAdvertisementPage, 100, "https://www.training.eprocure.gov.bd");
		wait.waitForElement(websiteAdvertisementDate, 100);
		js.selectDateByJavaScript(websiteAdvertisementDate, "11/07/2019");
		wait.WaitForElementClickable(submitButton, 500);
		js.clickElement(submitButton);

		String advertisementTextString1 = verification.getText(advertisementText);
		System.out.println("text fillSave1 is ---->> " + advertisementTextString1);
		AssertionHelper.verifyText(advertisementTextString1, "Tender/Proposal Advertisement added successfully",
				"text is verified");

		/*
		 * Click on Opening Tab
		 */
		for (int i = 0; i < totalTabsSize.size(); i++) {
			WebElement element = totalTabsSize.get(i);
			String text = totalTabsSize.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.equals("Opening")) {
				element.click();
				break;
			}
		}
		wait.WaitForElementClickable(sendToTECPECChairPerson, 500);
		js.clickElement(sendToTECPEC);

		TestUtil.sendKeys(driver, comments, 100, "tested comments");
		wait.WaitForElementClickable(submitButtonTest, 500);
		js.clickElement(submitButtonTest);

		// Verify text
		String advertisementTextString3 = verification.getText(advertisementText3);
		System.out.println("text fillSave1 is ---->> " + advertisementTextString3);
		AssertionHelper.verifyText(advertisementTextString3, "Sent to TEC/PEC Chairperson successfully",
				"text is verified");
	}
	
	/**
	 * HOPEUSER login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorks_LTMEPW2B_EvaluationChairPersonLoginFirstTestCaseMethod() {
		log.info("************ createTenderDevBudgetWorksEvaluationChairPersonLoginFirstTestCaseMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderLtmWorkPath());

		// To read the file --- FileInputStream
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String strngTenderId = null;
		try {
			strngTenderId = IOUtils.toString(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}
		
		//Evaluation Configuration
		wait.WaitForElementClickable(evalConfigurationLink, 500);
		evalConfigurationLink.click();

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		if (!teamRadioButton.isSelected()) {
			TestUtil.clickOn(driver, teamRadioButton, 100);
		}

		// click on AO User radio Button
		if (!aoUserRadioButton.isSelected()) {
			TestUtil.clickOn(driver, aoUserRadioButton, 100);
		}

		wait.WaitForElementClickable(evalConfigurationLink, 500);
		js.clickElement(submitButton);

		// Verify text
		String sucessmsg1 = verification.getText(sucessmsg);
		System.out.println("text fillSave1 is ---->> " + sucessmsg1);
		AssertionHelper.verifyText(sucessmsg1, "Configuration done successfully.", "text is verified");

		TestUtil.clickOn(driver, logOut, 100);
	}
	
	/**
	 * AOUSER login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluation_LTM_EPW2B_MemberSecretaryLogin_SecondTestCaseMethod() {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationMemberSecretaryLoginSecondTestCaseMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderLtmWorkPath());

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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);
		Assert.assertTrue(false);
		
		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}

		// Evaluation Nomination - Click on Consent for nomination
		TestUtil.clickOn(driver, consentForNomination, 100);
		// Assert.assertTrue(false);
		wait.WaitForElementClickable(submitButton, 500);
		js.clickElement(submitButton);

		// Handling Alert pop up windows
		al.acceptAlert();

		// Verify text
		String nominationmsg1 = verification.getText(nominationmsg);
		AssertionHelper.verifyText(nominationmsg1, "Nomination done Successfully!", "text is verified");

		// click on AO user link
		// table[@class='tableList_1 t_space']/tbody/tr[3]/td/a
		TestUtil.clickOn(driver, AOUSERLINK, 100);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments, 100, "test comments");

		wait.WaitForElementClickable(submitButtonName, 500);
		js.clickElement(submitButtonName);

		// Verify text
		String declarationmsg1 = verification.getText(declarationmsg);
		System.out.println("declarationmsg1 is ---->> " + declarationmsg1);
		AssertionHelper.verifyText(declarationmsg1, "Declaration given successfully", "text is verified");

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.equals("Clarification")) {
				element.click();
				break;
			}
		}
		
		// Click on Evaluate tenderer
		TestUtil.clickOn(driver, evaluatetendererlink, 100);

		// Click on e-Tender Submission Letter (Form e-PW2-1)
		TestUtil.clickOn(driver, evaluateformlink1, 100);
		TestUtil.sendKeys(driver, reason, 100, "tendeor delay");
		TestUtil.clickOn(driver, submitPost, 100);

		// Click on Evaluate Form2
		//Tenderer Information Form (e-PW2-2)
		TestUtil.clickOn(driver, evaluateformlink2, 100);
		TestUtil.sendKeys(driver, reason, 100, "tendeor delay 2");
		TestUtil.clickOn(driver, submitPost, 100);

		js.scrollIntoView(dashboardButton);
		js.clickElement(dashboardButton);
		
		//*************************************************
		//Second tendor click ---- Evaluate Tenderer
		TestUtil.clickOn(driver, evaluatetendererlinkNew, 100);

		// Click on e-Tender Submission Letter (Form e-PW2-1)
		TestUtil.clickOn(driver, evaluateformlink1, 100);
		TestUtil.sendKeys(driver, reason, 100, "tendeor delay");
		TestUtil.clickOn(driver, submitPost, 100);

		// Click on Evaluate Form2 - Tenderer Information Form (e-PW2-2)
		TestUtil.clickOn(driver, evaluateformlink2, 100);
		TestUtil.sendKeys(driver, reason, 100, "tendeor delay 2");
		TestUtil.clickOn(driver, submitPost, 100);

		js.scrollIntoView(dashboardButton);
		js.clickElement(dashboardButton);
		
		//********************************************
		// Fill Evaluation Form (Tender Evaluation Report 1)
		wait.WaitForElementClickable(fillEvaluationForm1, 500);
		js.clickElement(fillEvaluationForm1);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(saveButtonInput);
		js.clickElement(saveButtonInput);

		// Verify text
		String tenderproposalevalreportsuccessmsg1 = verification.getText(tenderproposalevalreportsuccessmsg);
		System.out.println("text fillSave1 is ---->> " + tenderproposalevalreportsuccessmsg1);
		AssertionHelper.verifyText(tenderproposalevalreportsuccessmsg1,
				"Tender/Proposal Evaluation Report 1 prepared successfully", "text is verified");

		// Fill Evaluation Form (Tender Evaluation Report 2)
		wait.WaitForElementClickable(fillEvaluationForm2, 500);
		js.clickElement(fillEvaluationForm2);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(tenderSaveButton);
		js.clickElement(tenderSaveButton);

		// Click on Notify Chairperson, if evaluation is finalised
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(notifyChairperson);
		js.clickElement(notifyChairperson);

		// Verify text
		String successNotifyMsg1 = verification.getText(successNotifyMsg);
		System.out.println("text fillSave1 is ---->> " + successNotifyMsg1);
		AssertionHelper.verifyText(successNotifyMsg1, "Successfully notified to Chairperson", "text is verified");

		js.scrollIntoView(logOut);
		js.clickElement(logOut);
	}
	
	/**
	 * HOPEUSER login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorks_LTMEPW2B_EvaluationChairPersonLogin_Third_TestCaseMethod() {
		log.info("************ createTenderDevBudgetWorksEvaluationChairPersonLogin_Third_TestCaseMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderLtmWorkPath());

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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}
		
		for (int i = 0; i < totalTabsSize.size(); i++) {
			WebElement element = totalTabsSize.get(i);
			String text = totalTabsSize.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.equals("Evaluation")) {
				element.click();
				break;
			}
		}
		
		js.scrollIntoView(hopeUserLinkNew);
		TestUtil.clickOn(driver, hopeUserLinkNew, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test commentstest");

		wait.WaitForElementClickable(submitButtonName, 500);
		js.clickElement(submitButtonName);

		// Verify text
		String declarationmsg1 = verification.getText(declarationmsg);
		System.out.println("declarationmsg1 is ---->> " + declarationmsg1);
		AssertionHelper.verifyText(declarationmsg1, "Declaration given successfully", "text is verified");

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report ")) {
				element.click();
				break;
			}
		}

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, finalizeResponsivenessLink1, 100);

		// click on technical Responsive RadioButton
		if (!technicalResponsiveRadioButton.isSelected()) {
			TestUtil.clickOn(driver, technicalResponsiveRadioButton, 100);
		}

		wait.WaitForElementClickable(submitButtonName, 500);
		js.clickElement(submitButtonName);

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		
		//****************************************8**********
		TestUtil.clickOn(driver, finalizeResponsivenessLink2, 100);

		// click on technical Responsive RadioButton
		if (!technicalResponsiveRadioButton.isSelected()) {
			TestUtil.clickOn(driver, technicalResponsiveRadioButton, 100);
		}

		wait.WaitForElementClickable(submitButtonName, 500);
		js.clickElement(submitButtonName);

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		
		//*****************************************************
		
		// Tender Evaluation Report 1 --->> Click on Configure link
		TestUtil.clickOn(driver, tenderEvaluationReportConfigure1, 100);

		// Save button input
		js.scrollIntoView(saveButtonInput);
		js.clickElement(saveButtonInput);

		// Verify text
		String tenderproposalevalreportsuccessmsg1 = verification.getText(tenderproposalevalreportsuccessmsg);
		System.out.println("text fillSave1 is ---->> " + tenderproposalevalreportsuccessmsg1);
		AssertionHelper.verifyText(tenderproposalevalreportsuccessmsg1,
				"Tender/Proposal Evaluation Report 1 prepared successfully", "text is verified");

		// Tender Evaluation Report 1 --->> Click on  View and Sign link
		TestUtil.clickOn(driver, viewAndSignLink, 100);

		js.scrollIntoView(hopeUserLinkNew);
		TestUtil.clickOn(driver, hopeUserLinkNew, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test commentstest");
		wait.WaitForElementClickable(submitButtonName, 500);
		js.clickElement(submitButtonName);

		// Go back to Dashboard
		wait.WaitForElementClickable(dashboardButton1, 500);
		js.clickElement(dashboardButton1);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		// Tender Evaluation Report 2 --- >>  Click on Configure link
		TestUtil.clickOn(driver, tenderEvaluationReportConfigure2, 100);

		js.scrollIntoView(saveButton1);
		wait.WaitForElementClickable(saveButton1, 500);
		js.clickElement(saveButton1);

		// Tender Evaluation Report 2
		wait.WaitForElementClickable(viewAndSignLink, 500);
		js.clickElement(viewAndSignLink);

		// Hope user link click
		wait.WaitForElementClickable(hopeUserLinkNew, 500);
		js.scrollIntoView(hopeUserLinkNew);
		TestUtil.clickOn(driver, hopeUserLinkNew, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test commentstest");
		wait.WaitForElementClickable(submitButtonName, 500);
		js.clickElement(submitButtonName);

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		wait.WaitForElementClickable(dashboardButton1, 500);
		js.clickElement(dashboardButton1);
	}
	
	/**
	 * AOUSER - MEMBER _ SECRETARY _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorks_LTMEPW2B_EvaluationMemberSecretary_Login_Fourth_TestCaseMethod() {
		log.info("************ createTenderDevBudgetWorksEvaluationChairPersonLogin_Third_TestCaseMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderLtmWorkPath());

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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}
		// Tender Evaluation Report 1 --- 	View and Sign
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, viewAndSignLink1, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(AOUSERLINK1);
		TestUtil.clickOn(driver, AOUSERLINK1, 100);
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test commentstest");

		js.clickElement(submitButtonName);
		js.clickElement(dashboardButton1);

		// Tender Evaluation Report 2 --- 	View and Sign
		js.scrollIntoView(viewAndSignLink2);
		TestUtil.clickOn(driver, viewAndSignLink2, 100);

		// click on AO USER link
		js.scrollIntoView(AOUSERLINK1);
		TestUtil.clickOn(driver, AOUSERLINK1, 100);
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test commentstest");

		js.clickElement(submitButtonName);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(dashboardButton1);

		TestUtil.clickOn(driver, logOut, 100);
	}
	
	/**
	 * HOPEUSER - MEMBER _ SECRETARY _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorks_LTMEPW2B_EvaluationMemberSecretary_Login_Fifth_TestCaseMethod() {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationMemberSecretary_Login_Fifth_TestCaseMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderLtmWorkPath());

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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		
		//Price Comparison Report --->> Click on View and Save link
		TestUtil.clickOn(driver, priceComparisionReportViewAndSave, 100);
		
		//Click on lottery button
		TestUtil.clickOn(driver, lotteryButton, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		
		//Tender Evaluation Report 1 --->>  Configure
		TestUtil.clickOn(driver, configure1, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, saveValue, 100);
		
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		
		//Tender Evaluation Report 1 --->>  View and Sign
		TestUtil.clickOn(driver, viewAndSignLinkNew, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(hopeUserLinkNew);
		TestUtil.clickOn(driver, hopeUserLinkNew, 100);
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test commentstest");
		
		//Sign beku
		TestUtil.clickOn(driver, signLink, 100);
		
		//dashboard
		TestUtil.clickOn(driver, dashboardButton1, 100);
		
		//Tender Evaluation Report 2 --->> configure2
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, configure2, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, saveValueNew, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		
		//Tender Evaluation Report 2 --->> Click on  View and Sign link
		TestUtil.clickOn(driver, viewAndSignLinkNewLink, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(hopeUserLinkNew);
		TestUtil.clickOn(driver, hopeUserLinkNew, 100);
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test commentstest");
		TestUtil.clickOn(driver, signLink, 100);
		
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, dashboardButton1, 100);
		
		/**
		 * 
		 * 
		 * 
		 * PENDING
		 * 
		 * 
		 */
		
		

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Post Qualification")) {
				element.click();
				break;
			}
		}
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, processLink, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, initiateLink, 100);

		js.selectDateByJavaScript(siteVisitDateTime, "03/04/2019");
		TestUtil.sendKeys(driver, comments, 100, "test comments");
		js.clickElement(submitButton);

		// Verify text
		String pqProcessText1 = verification.getText(pqProcessText);
		System.out.println("text fillSave1 is ---->> " + pqProcessText1);
		AssertionHelper.verifyText(pqProcessText1, "PQ Process initiated successfully", "text is verified");

		// click on complete link
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, completeLink, 100);

		js.selectDateByJavaScript(siteVisitDateTime, "02/04/2018");
		TestUtil.sendKeys(driver, comments, 100, "test comments");
		js.clickElement(submitButton);

		// Verify text
		String pqProcessComplete1 = verification.getText(pqProcessComplete);
		System.out.println("text fillSave1 is ---->> " + pqProcessComplete1);
		AssertionHelper.verifyText(pqProcessComplete1, "PQ Process Completed successfully", "text is verified");

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(goBackbutton);
		js.clickElement(goBackbutton);

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}

		// Tender Evaluation Report 3
		// *[@id='round_1']/tr[3]/td[1]/following-sibling::td/a[2][text()='View and
		// Sign']

		/*
		 * wait.waitForElement(viewAndSignLinkTenderEvaluationReport3, 100, 10);
		 * TestUtil.clickOn(driver, viewAndSignLinkTenderEvaluationReport3, 100);
		 * 
		 * //Click on Hope user TestUtil.clickOn(driver, hopeUserLink, 100);
		 * TestUtil.sendKeys(driver, password, 100, "egp12345");
		 * TestUtil.sendKeys(driver, comments1, 100, "test comments");
		 * js.clickElement(submitButtonName);
		 * 
		 * js.scrollIntoView(dashboardButton); js.clickElement(dashboardButton);
		 * 
		 * // Tender Evaluation Report 4
		 * wait.waitForElement(viewAndSignLinkTenderEvaluationReport4, 100, 10);
		 * TestUtil.clickOn(driver, viewAndSignLinkTenderEvaluationReport4, 100);
		 * //Click on Hope user TestUtil.clickOn(driver, hopeUserLink, 100);
		 * TestUtil.sendKeys(driver, password, 100, "egp12345");
		 * TestUtil.sendKeys(driver, comments1, 100, "test comments");
		 * js.clickElement(submitButtonName);
		 */
	}
	
	
	/**
	 * AOUSER - MEMBER _ SECRETARY _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorks_LTMEPW2B_Evaluation_MemberSecretary_Login_Sixth_TestCaseMethod() {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationMemberSecretary_Login_Fifth_TestCaseMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderLtmWorkPath());

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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);
		Assert.assertTrue(true);

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}

		// Tender Evaluation Report 1 ---- Click on View and Sign
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, viewAndSignLink3, 100);
		js.scrollIntoView(aoUserLink3);
		TestUtil.clickOn(driver, aoUserLink3, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test comments");
		js.clickElement(submitButtonName);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(dashboardButton1);
		
		// Tender Evaluation Report 2 ---- Click on View and Sign
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, viewAndSignLink4, 100);
		js.scrollIntoView(aoUserLink3);
		TestUtil.clickOn(driver, aoUserLink3, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test comments");
		js.clickElement(submitButtonName);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(dashboardButton1);
	}
	
	/**
	 * HOPEUSER - MEMBER _ SECRETARY _ LOGIN login credentials
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluation_LTM_MemberSecretary_Login_Seventh_TestCaseMethod() {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationMemberSecretary_Login_Seventh_TestCaseMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderLtmWorkPath());

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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}

		// Tender Evaluation Report 4 ---- Click on View and Sign
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, viewAndSignLink4Edit, 100);
		js.scrollIntoView(peUserLink4);
		TestUtil.clickOn(driver, peUserLink4, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test comments");
		js.clickElement(submitButtonName);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(dashboardButton1);
		TestUtil.clickOn(driver, logOut, 100);
	}
	
	/**
	 * PEUSER - Contract Approval Workflow _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluation_LTM_ContractWorkFlow_PE_Login_Eight_TestCaseMethod() {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationMemberSecretary_Login_Fifth_TestCaseMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderLtmWorkPath());

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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId.sendKeys(strngTenderId);

		// status dropdown
		dropdown.selectUsingVisibleText(statusValue, "Processing");

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		// click on searchbutton
		// js.clickElement(searchButton);

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[7]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[7]/a"))).click()
					.build().perform();
		}

		for (int i = 0; i < totalTabsSizeCount.size(); i++) {
			WebElement element = totalTabsSizeCount.get(i);
			String text = totalTabsSizeCount.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Evaluation")) {
				element.click();
				break;
			}
		}
		/*
		 * Contract Approval Workflow --- click on Create link
		 */

		TestUtil.clickOn(driver, createLink, 100);

		// Handling Alert pop up windows
		al.acceptAlert();

		TestUtil.sendKeys(driver, noOfReviewers, 100, "0");

		noOfReviewers.sendKeys(Keys.TAB);
		js.scrollIntoView(submitButton1);
		js.clickElement(submitButton1);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(submitButton2);
		js.clickElement(submitButton2);

		TestUtil.clickOn(driver, yesButton, 100);
		TestUtil.clickOn(driver, logOut, 100);
	}
	
	/**
	 * HOPE USER - CHAIR PERSON _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluation_LTM_ChairPerson_Login_Nineth_TestCaseMethod() {
		log.info("************ createTenderDevBudgetWorksEvaluationChairPerson_Login_Nineth_TestCaseMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderLtmWorkPath());

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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}
		//**************************
		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Post Qualification")) {
				element.click();
				break;
			}
		}
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, processLink, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, initiateLink, 100);

		js.selectDateByJavaScript(siteVisitDateTime, "24/07/2019");
		TestUtil.sendKeys(driver, comments, 100, "test comments");
		js.clickElement(submitButton);

		// Verify text
		String pqProcessText1 = verification.getText(pqProcessText);
		System.out.println("text fillSave1 is ---->> " + pqProcessText1);
		AssertionHelper.verifyText(pqProcessText1, "PQ Process initiated successfully", "text is verified");

		// click on complete link
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, completeLink, 100);

		js.selectDateByJavaScript(siteVisitDateTime, "24/07/2018");
		TestUtil.sendKeys(driver, comments, 100, "test comments");
		js.clickElement(submitButton);

		// Verify text
		String pqProcessComplete1 = verification.getText(pqProcessComplete);
		System.out.println("text fillSave1 is ---->> " + pqProcessComplete1);
		AssertionHelper.verifyText(pqProcessComplete1, "PQ Process Completed successfully", "text is verified");

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(goBackbutton);
		js.clickElement(goBackbutton);

		//************************

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}
		
		//Tender Evaluation Report 3 ---->> Click on View and Sign
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		wait.WaitForElementClickable(viewAndSignLink3NewLink, 200);
		TestUtil.clickOn(driver, viewAndSignLink3NewLink, 100);

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(hopeUserLink3New);
		wait.WaitForElementClickable(hopeUserLink3New, 200);
		TestUtil.clickOn(driver, hopeUserLink3New, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test comments");
		wait.WaitForElementClickable(submitButtonName, 200);
		js.clickElement(submitButtonName);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(dashboardButton1);
				
		
				
				
				
		//*********************************************************
		
		/*js.scrollIntoView(processFileWorkFlow);
		js.clickElement(processFileWorkFlow);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		// driver.switchTo().frame(1);
		frame.switchToFrame(frameWindow);
		TestUtil.sendKeys(driver, commentsTextArea, 100, "Pls approve my evaluation tender");
		driver.switchTo().defaultContent();
		dropdown.selectUsingVisibleText(actionDropDown, "Forward");
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(buttonAdd);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		// Verify text
		String fileProcessSuccess1 = verification.getText(fileProcessSuccess);
		System.out.println("text fileProcessSuccess is ---->> " + fileProcessSuccess1);
		AssertionHelper.verifyText(fileProcessSuccess1, "File processed successfully", "text is verified");

		TestUtil.clickOn(driver, logOut, 100);*/
	}
	
	/**
	 * HOPE USER - CHAIR PERSON _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluation_LTM_ChairPerson_Login_Nineth_TestCaseMethod1() {
		log.info("************ createTenderDevBudgetWorksEvaluationChairPerson_Login_Nineth_TestCaseMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderLtmWorkPath());

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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		tenderPropId1.sendKeys(strngTenderId);

		TestUtil.clickOn(driver, searchButton, 200);

		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a"))).click()
					.build().perform();
		}

		for (int i = 0; i < totalTabsSizeText.size(); i++) {
			WebElement element = totalTabsSizeText.get(i);
			String text = totalTabsSizeText.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.contains("Eval. Report")) {
				element.click();
				break;
			}
		}
		
		//Tender Evaluation Report 3 ---->> Click on View and Sign
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		wait.WaitForElementClickable(viewAndSignLink3NewLink, 200);
		TestUtil.clickOn(driver, viewAndSignLink3NewLink, 100);

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(aoUserLink4New);
		wait.WaitForElementClickable(aoUserLink4New, 200);
		TestUtil.clickOn(driver, aoUserLink4New, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test comments");
		wait.WaitForElementClickable(submitButtonName, 200);
		js.clickElement(submitButtonName);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(dashboardButton1);
				
		
		//Tender Evaluation Report 4 ---->> Click on View and Sign
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		wait.WaitForElementClickable(viewAndSignLink4New, 200);
		TestUtil.clickOn(driver, viewAndSignLink4New, 100);

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.scrollIntoView(aoUserLink4);
		wait.WaitForElementClickable(aoUserLink4, 200);
		TestUtil.clickOn(driver, aoUserLink4, 100);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments1, 100, "test comments");
		wait.WaitForElementClickable(submitButtonName, 200);
		js.clickElement(submitButtonName);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(dashboardButton1);	
		
		//**************************************************
		js.scrollIntoView(processFileWorkFlow);
		js.clickElement(processFileWorkFlow);
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		// driver.switchTo().frame(1);
		frame.switchToFrame(frameWindow);
		TestUtil.sendKeys(driver, commentsTextArea, 100, "Pls approve my evaluation tender");
		driver.switchTo().defaultContent();
		dropdown.selectUsingVisibleText(actionDropDown, "Forward");
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(buttonAdd);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		// Verify text
		String fileProcessSuccess1 = verification.getText(fileProcessSuccess);
		System.out.println("text fileProcessSuccess is ---->> " + fileProcessSuccess1);
		AssertionHelper.verifyText(fileProcessSuccess1, "File processed successfully", "text is verified");

		TestUtil.clickOn(driver, logOut, 100);
		
	}
	
	/**
	 * HOPE USER - CHAIR PERSON _ LOGIN login credentials
	 * 
	 * @throws Throwable
	 */
	public void createTenderDevBudgetWorksEvaluation_LTM_ChairPersonWorkFlow_Login_Tenth_TestCaseMethod() {
		log.info(
				"************ createTenderDevBudgetWorksEvaluationChairPersonWorkFlow_Login_Tenth_TestCaseMethod **********");
		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderLtmWorkPath());

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
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("strngTenderId is --->>" + strngTenderId);
		workFlowId.sendKeys(strngTenderId);

		TestUtil.clickOn(driver, searchButtonClick, 200);
		Actions builder = new Actions(driver);
		builder.moveToElement(searchButtonClick).click().build().perform();

		try {
			builder.moveToElement(driver.findElement(By.xpath("//*[@id='1']/td[9]/a[contains(text(),'Process')]")))
					.click().build().perform();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			// builder.moveToElement(driver.findElement(By.xpath("//*[@id='1']/td[9]/a[contains(text(),'Process')]"))).click().build().perform();
		}

		wait.setImplicitWait(100, TimeUnit.SECONDS);
		// driver.switchTo().frame(1);
		frame.switchToFrame(frameWindow);
		TestUtil.sendKeys(driver, commentsTextArea, 100, "Pls approve my evaluation tender");
		driver.switchTo().defaultContent();
		dropdown.selectUsingVisibleText(actionDropDown, "Approve");
		wait.setImplicitWait(100, TimeUnit.SECONDS);
		js.clickElement(buttonAdd);
		wait.setImplicitWait(100, TimeUnit.SECONDS);

		// Verify text
		String fileProcessSuccess1 = verification.getText(fileProcessSuccess);
		System.out.println("text fileProcessSuccess is ---->> " + fileProcessSuccess1);
		AssertionHelper.verifyText(fileProcessSuccess1, "File processed successfully", "text is verified");

		TestUtil.clickOn(driver, logOut, 100);
	}
}
