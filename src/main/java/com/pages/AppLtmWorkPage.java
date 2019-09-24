package com.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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
import com.egp.qa.helper.window.WindowHelper;
import com.egp.qa.utilities.TestUtil;

/**
 *
 * @author SHIVANSHU SHANDILYA
 */

public class AppLtmWorkPage extends TestBase {
	CreateAppPage crt;
	TestUtil testUtil;
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	private Logger log = LoggerHelper.getLogger(AppLtmWorkPage.class);
	DropDownHelper dropdwnhelper = new DropDownHelper(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	VerificationHelper verifhelper = new VerificationHelper(driver);
	JavaScriptHelper js1 = new JavaScriptHelper(driver);
	WindowHelper windowhelper = new WindowHelper(driver);
	CommanActivity com = new CommanActivity();
	FrameHelper framehelper = new FrameHelper(driver);
	AlertHelper alert = new AlertHelper(driver);

	@FindBy(id = "cmbBudgetType")
	private WebElement BudgetType;

	@FindBy(id = "cmbFinancialYear")
	private WebElement FinancialYear;

	@FindBy(id = "cmbProject")
	private WebElement SelectProject;

	@FindBy(id = "txtAppCode")
	private WebElement APPCode;

	@FindBy(id = "buttonNext")
	private WebElement Next;

	@FindBy(xpath = "//*[@id=\"frmAddPackageDetail\"]/table/tbody/tr[2]/td[2]")
	private WebElement AppId;

	@FindBy(id = "cmbProcureNature")
	private WebElement ProcurementNature;

	@FindBy(id = "cmbEmergencyType")
	private WebElement TypeofEmergency;

	@FindBy(id = "txtPackageNo")
	private WebElement PackageNo;

	@FindBy(id = "txtaPackageDesc")
	private WebElement PackageDescription;

	@FindBy(id = "txtLotNo_1")
	private WebElement LotNo;

	@FindBy(id = "txtLotDesc_1")
	private WebElement LotDescription;

	@FindBy(id = "txtQuantity_1")
	private WebElement Quantity;

	@FindBy(id = "txtUnit_1")
	private WebElement Unit;

	@FindBy(id = "txtEstimateCost_1")
	private WebElement EstimatedCost;

	@FindBy(id = "txtPackageCost")
	private WebElement PackageEstCost;

	@FindBy(xpath = "//A[@id='hrefCPV']/self::A")
	private WebElement SelectCategory;

	@FindBy(className = "jstree-checkbox")
	private WebElement CpvCatAgri;

	@FindBy(id = "btnGetCheckedNode")
	private WebElement SubmitCpvCategory;

	@FindBy(id = "cmbAuthority")
	private WebElement ApprovingAuthority;

	@FindBy(id = "cmbProcureType")
	private WebElement ProcurementType;

	@FindBy(id = "cmbProcureMethod")
	private WebElement ProcurementMethod;

	@FindBy(id = "btnNext")
	private WebElement Next2;

	@FindBy(id = "txtRfqdtadvtift")
	private WebElement ExpectedDateOfAdvertisementOfIFTon;

	@FindBy(id = "txtRfqdtadvtiftNo")
	private WebElement NoOfDaysExpectedLastDateofSubmissionofTenders;

	@FindBy(id = "txtRfqdtsubNo")
	private WebElement NoOfDaysExpectedDateofOpeningofTenders;

	@FindBy(id = "txtRfqexpdtopenNo")
	private WebElement NoOfDaysExpectedDateofSubmissionofEvaluationReport;

	@FindBy(id = "txtRfqdtsubevaRptNo")
	private WebElement NoOfDaysExpectedDateofApprovalforAwardofContract;

	@FindBy(id = "txtRfqexpdtAppawdNo")
	private WebElement NoOfDaysExpectedDateofIssuanceoftheNOA;

	@FindBy(id = "txtRfqdtIssNOANo")
	private WebElement NoOfDaysExpectedDateofSigningofContract;

	@FindBy(id = "txtRfqexpdtSignNo")
	private WebElement NoOfDaysExpectedDateofCompletionofContract;

	@FindBy(id = "btnSave")
	private WebElement Save;

	@FindBy(linkText = "Create")
	private WebElement Create;

	@FindBy(id = "textfield1")
	private WebElement NoofReviewers;

	@FindBy(id = "button")
	private WebElement Submit;

	@FindBy(id = "cmbstartsby1")
	private WebElement Initiator;

	@FindBy(id = "cmbendsby2")
	private WebElement Approver;

	@FindBy(id = "btnsubmit")
	private WebElement Submit2;

	@FindBy(linkText = "Process file in Workflow")
	private WebElement CreateWorkFlow;

	@FindBy(xpath = "/html")
	private WebElement Comments;

	@FindBy(id = "txtAction")
	private WebElement Action;

	@FindBy(xpath = "//input[@id='txtIssuanceDt']")
	private WebElement issuenceDate;

	@FindBy(id = "txtComments")
	private WebElement remarks;

	@FindBy(id = "btnSubmit")
	private WebElement clickSubmitButton;

	@FindBy(id = "tbnAdd")
	private WebElement WorkflowSubmit;

	@FindBy(xpath = "/html/body/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/a")
	private WebElement LogOut;

	@FindBy(id = "btnsubmit")
	private WebElement NoofReviewersWorkFlow;

	@FindBy(id = "btnsubmit")
	private WebElement NoofDaysforFileEscalation;

	@FindBy(id = "txtEmailId")
	private WebElement username;

	@FindBy(id = "txtPassword")
	private WebElement password;

	@FindBy(id = "btnLogin")
	private WebElement loginBtn;

	@FindBy(xpath = ".//*[@id='headTabWorkFlow']")
	private WebElement workflowTab;

	@FindBy(xpath = ".//*[@id='ddsubmenu3']/li[1]/a")
	private WebElement pendingTask;

	@FindBy(id = "workflowId")
	private WebElement SearchApp;

	@FindBy(id = "btnSearchwf")
	private WebElement SearchButton;

	@FindBy(xpath = ".//*[@id='1']/td[9]/a")
	private WebElement Clk;

	@FindBy(xpath = "/html")
	private WebElement CommentTextBox;

	@FindBy(id = "txtAction")
	private WebElement AAction;

	@FindBy(id = "tbnAdd")
	private WebElement submit;

	@FindBy(xpath = "/html/body/div[1]/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/a")
	private WebElement LogOuHope;

	@FindBy(id = "headTabApp")
	WebElement AppLink;

	@FindBy(linkText = "My APP")
	WebElement MyAppLink;

	@FindBy(id = "txtAppId")
	WebElement serchAppid;

	@FindBy(xpath = "//*[@id=\"btnSearchApp\"]")
	WebElement srchBtnforappId;

	@FindBy(xpath = "//*[@id=\"0\"]/td[6]/a/img")
	WebElement activityApp;

	@FindBy(linkText = "Publish")
	WebElement ApppuBlish;

	@FindBy(id = "txtremark")
	WebElement Textpublish;

	@FindBy(id = "btnsubmit")
	WebElement subPublish;

	@FindBy(linkText = "Logout")
	WebElement LogoutfromPE;

	// For Works
	@FindBy(id = "cmbPQRequires")
	private WebElement PQRequires;

	@FindBy(id = "txtpqdtadvtinvt")
	private WebElement datePQ;

	@FindBy(id = "txtpqdtadvtinvtNo")
	private WebElement ExpectedDateofApplicationsSubmission;

	@FindBy(id = "txtPqdtappsubNo")
	private WebElement ExpectedDateOfSubmissionOfEvaluationReport;

	@FindBy(id = "txtPqdtsubevarptNo")
	private WebElement ExpectedDateofApprovalOfList;

	// For Service
	@FindBy(id = "cmbServiceType")
	private WebElement ServiceType;

	@FindBy(id = "cmbRFARequires")
	private WebElement REOIRFARFPRequires;

	// For Service REOI
	@FindBy(id = "txtREOQexpdtadvtREOI")
	private WebElement ExpectedDateofAdvertisementofREOI;

	@FindBy(id = "txtREOQexpdtadvtREOINo")
	private WebElement ExpectedDateofLastDateofReceiptofEOI;

	@FindBy(id = "txtREOQexpdtlstdtRcptEOINo")
	private WebElement ExpectedDateofSubmissionofRecommendedShortlistedFirm;

	@FindBy(id = "txtREOQexpdtsubsrtlstFrmNo")
	private WebElement ExpectedDateofApprovalofRecommendedShortlistedFirm;

	@FindBy(id = "txtRFPexpdtissueRFP")
	private WebElement ExpecteddateofIssueofRFP;

	@FindBy(id = "txtRFPexpdtissueRFPNo")
	private WebElement ExpectedDateofSubmissionofProposal;

	@FindBy(id = "txtRFPexpdtSubProposalNo")
	private WebElement ExpectedDateofTechnicalProposalOpening;

	@FindBy(id = "txtRFPexpdttechOpenNo")
	private WebElement ExpectedDateofTechnicalProposalEvaluation;

	@FindBy(id = "txtRFPexpdttechEvaNo")
	private WebElement ExpectedDateofFinancialProposalOpening;

	@FindBy(id = "txtRFPextdtFinOpenNo")
	private WebElement ExpectedDateofSubmissionofCombinedEvaluationReport;

	@FindBy(id = "txtRFPexpdtsubCOmEvaRptNo")
	private WebElement ExpectedDateofApprovalofCombinedEvaluationReport;

	@FindBy(id = "txtRFPexpdtappcomEvaRptNo")
	private WebElement ExpectedDateofCompletionofNegotiation;

	@FindBy(id = "txtRFPexpdtcompNegoNo")
	private WebElement ExpectedDateofApprovalforAwardofContract;

	@FindBy(id = "txtRFPexpdtappawdContractNo")
	private WebElement ExpectedDateofSigningofContract;

	@FindBy(id = "txtRFPexpdtsigncontractNo")
	private WebElement ExpectedDateofCompletionofContract;

	@FindBy(id = "idtxttotal")
	private WebElement TotalTimetoContractSigning;

	// For Service RFA/RFP
	@FindBy(id = "txtRFAexpdtadvtRFA")
	private WebElement ExpectedDateofAdvertisementofRFA;

	@FindBy(id = "txtRFAexpdtadvtRFANo")
	private WebElement DateofReceiptofApplication;

	@FindBy(id = "txtRFAdtrcptAppNo")
	private WebElement DateofEvaluationofApplication;

	@FindBy(id = "txtRFAdteveappNo")
	private WebElement DateofInterviewofSelectedIndividuals;

	@FindBy(id = "txtRFAdtintrvwselIndNo")
	private WebElement DateofEvaluationofFinalselectionlist;

	@FindBy(id = "txtRFAdtevaFnlselLstNo")
	private WebElement DateofSubmissionofEvaluationReport;

	@FindBy(id = "txtRFAdtsubevaRptNo")
	private WebElement DateofApprovalofConsultants;

	@FindBy(xpath = "//input[@id='txtAppId']")
	private WebElement searchAppId;

	@FindBy(id = "cmbstatus")
	private WebElement cmbStatusDropDown;

	@FindBy(xpath = "//input[@id='btnSearchApp']")
	private WebElement searchAppButton;

	@FindBy(xpath = "//a[contains(text(),'Add New Package')]")
	private WebElement addNewPackage;

	@FindBy(xpath = "//a[text()='Process file in Workflow']")
	private WebElement processFileInWorkFlow;

	@FindBy(id = "cmbAppType")
	private WebElement packageType;

	@FindBy(xpath = "//select[@id='cmbstatus']")
	private WebElement statusSelect;

	@FindBy(id = "txtinvitationRefNo")
	private WebElement RFQNo;

	@FindBy(id = "txttenderpublicationDate")
	private WebElement RFQPublicationDateandTime;

	@FindBy(id = "txttenderLastSellDate")
	private WebElement TenderProposalDocumentlastsellingdownloadingDateandTime;

	@FindBy(id = "txtpreTenderMeetStartDate")
	private WebElement PreTenderProposalmeetingStartDateandTime;

	@FindBy(id = "txtpreTenderMeetEndDate")
	private WebElement PreTenderProposalmeetingEndDateandTime;

	@FindBy(id = "txtpreQualCloseDate")
	private WebElement ClosingDateandTime;

	@FindBy(id = "txtlastDateTenderSub")
	private WebElement ProposalSecuritySubmission;

	@FindBy(xpath = "/html")
	private WebElement EligibilityofTenderer;

	@FindBy(id = "locationlot_0")
	private WebElement Location;

	@FindBy(id = "tenderSecurityAmount_0")
	private WebElement ProposalSecurityAmountInBDT;

	@FindBy(xpath = "//input[@id='txtpreQualDocPrice']")
	private WebElement tenderProposalDocumentPrice;

	@FindBy(id = "startTimeLotNo_0")
	private WebElement StartDate;

	@FindBy(id = "complTimeLotNo_0")
	private WebElement CompletionDate;

	@FindBy(id = "btnsubmit")
	private WebElement submitToRadiobtn;

	@FindBy(xpath = "//td[text()='Tender/Proposal ID :']/following-sibling::td[1]")
	private WebElement TenderId;

	@FindBy(id = "tenderDocument")
	private WebElement StandardTenderProposalDocument;

	@FindBy(id = "txttenderValidity")
	private WebElement ProposalValidityInNoofDays;

	@FindBy(xpath = "//input[@id='btnSubmit']")
	private WebElement submitToRadiobtn1;

	@FindBy(xpath = "//a[text()='Add']")
	private WebElement AddOfficialCostEstimate;

	@FindBy(id = "taka_0")
	private WebElement OfficialCostEstimate;

	@FindBy(id = "submit")
	private WebElement OfficialCostEstimateSubmit;

	@FindBy(xpath = "//a[text()='Create']")
	private WebElement GrandSummaryCreateLink;

	@FindBy(xpath = "//input[@id='chkFormId_0']")
	private WebElement TendererQuotedPrice;
	
	@FindBy(xpath = "//input[@id='chkFormId_1']")
	private WebElement TendererQuotedPrice1;

	@FindBy(id = "saveoredit")
	private WebElement GrandSummarySubmit;

	@FindBy(xpath = "//span[@id='popup_ok']")
	private WebElement confClick;

	@FindBy(xpath = "/html/body/div/div[3]/div[1]/span/a")
	private WebElement TenderProposalDocument;

	@FindBy(xpath = "//a[text()='Tender/Proposal Doc. Preparation']")
	private WebElement TenderProposalDocument1;

	@FindBy(xpath = "/html/body/div/div[3]/table/tbody/tr[2]/td[3]")
	private WebElement UnnElee;

	@FindBy(xpath = "//ul[@class='tabPanel_1 noprint']/li")
	List<WebElement> totalTabs;

	@FindBy(xpath = "//ul[@class='tabPanel_1']/li")
	List<WebElement> totalTabs1;

	@FindBy(xpath = "/html/body/div/div[3]/div[2]")
	private WebElement tenderHeader;

	@FindBy(xpath = "//table[@class='tableList_1 t_space']/tbody/tr/td[3]/a[text()='Payment']")
	private WebElement paymentLinkText;

	@FindBy(id = "txtEmailId")
	private WebElement emailIdText;

	@FindBy(xpath = "//input[@id='btnSearch']")
	private WebElement searchButton;

	@FindBy(xpath = "//a[text()='Make Payment']")
	private WebElement makePaymentLinkText;

	@FindBy(id = "cmbPayment")
	private WebElement selectModeOfPayment;

	@FindBy(xpath = "//input[@id='txtInsRefNo']")
	private WebElement instrumentNo;

	@FindBy(xpath = "//input[@id='txtIssuanceBankNm']")
	private WebElement issuingBank;

	@FindBy(xpath = "//input[@id='txtIssuanceBranch']")
	private WebElement issuingBankBranch;

	@FindBy(xpath = "/html/body/div[3]/div[4]/table[2]/tbody/tr[1]/td[2]/a[1]")
	private WebElement EvaluationCommitteeCreate;

	@FindBy(id = "txtcommitteeName")
	private WebElement CommitteeName;

	@FindBy(id = "addmem")
	private WebElement AddMembers;

	@FindBy(id = "chk1")
	private WebElement AOUserAsMember;

	@FindBy(id = "chk5")
	private WebElement HopeUserAsMember;

	@FindBy(xpath = "//*[@id='myPanelDiv']/div[3]/div/button[1]")
	private WebElement Addmembers;

	@FindBy(id = "cmbMemRole0")
	private WebElement CommitteeRoleAOUser;

	@FindBy(id = "btnSubmit")
	private WebElement submitcommMem;

	@FindBy(linkText = "Notify Committee Members")
	private WebElement NotifyCommitteeMembers;

	@FindBy(id = "txtaRemarks")
	private WebElement txtRemarks;

	@FindBy(id = "btnPublish")
	private WebElement NotifyBtn;

	@FindBy(linkText = "Opening")
	private WebElement OpningLink;

	@FindBy(xpath = "/html/body/div[3]/div[4]/table[2]/tbody/tr[2]/td[2]")
	private WebElement ponnnusgh;

	@FindBy(xpath = "/html/body/div[1]/div[3]/div[6]/div")
	private WebElement opningdummy;

	@FindBy(linkText = "Notice")
	private WebElement NoticeLink;

	@FindBy(xpath = "/html/body/div[3]/div[4]/table/tbody/tr[5]/td[2]/a")
	private WebElement NoticeCreateMemmber;

	@FindBy(xpath = "//*[@id='members']/tbody/tr[1]/td[1]/input")
	private WebElement memberHopeChckBx;

	@FindBy(xpath = "//*[@id='members']/tbody/tr[2]/td[1]/input")
	private WebElement memberAoeChckBx;
	
	@FindBy(xpath = "//*[@id='members']/tbody/tr[1]/td[1]/input")
	private WebElement memberTECCPTUChckBx;

	@FindBy(xpath = "//*[@id='members']/tbody/tr[2]/td[1]/input")
	private WebElement memberPEChckBx;

	@FindBy(id = "hdnsubmit")
	private WebElement Submtmmbr;

	@FindBy(linkText = "Configure")
	private WebElement ConfigureNoticeTab;

	@FindBy(xpath = "//td[text()='Selected Tenderers/Consultants for Tender/Proposal']/parent::*/child::td[2]/a")
	private WebElement createTendererConsultantListLink1;

	@FindBy(xpath = "//table[@class='tableList_1 t_space']/tbody/tr[2]/td[3]/a")
	private WebElement createTendererConsultantListLink2;

	@FindBy(xpath = "//select[@id='cmbComRegAddState']")
	private WebElement selectStateDistrict;

	@FindBy(xpath = "//input[@id='btnSearch']")
	private WebElement btnSearch;

	@FindBy(xpath = "//input[@name='map']")
	private WebElement addtoList;

	@FindBy(id = "claricomboid")
	private WebElement ClarificationTenderIsTobeallowed;

	@FindBy(id = "sublastdate")
	private WebElement submitConfm;

	@FindBy(xpath = "/html/body/div[3]/div[4]/table/tbody/tr[1]/td[2]/a[3]")
	private WebElement PublishTender;

	@FindBy(id = "comments")
	private WebElement commentstToPublishTender;

	@FindBy(id = "Publish")
	private WebElement PublishSubmitBtn;

	@FindBy(xpath = "//a[text()='Go back to Dashboard']")
	private WebElement goBackDashBoard;

	@FindBy(id = "txtTenderId")
	private WebElement tenderId;

	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchButtonId;

	@FindBy(xpath = "//*[@id='resultTable']/tbody/tr/td[7]/a/img")
	private WebElement dashBoardIcon;

	@FindBy(xpath = "//a[text()='Verify']")
	private WebElement verifyLink;

	@FindBy(xpath = "//input[@id='btnVerify']")
	private WebElement verifyButton;

	@FindBy(xpath = "//div[text()='Payment information entered successfully']")
	private WebElement textVerify;

	@FindBy(xpath = "//div[text()='Payment verified successfully']")
	private WebElement textVerify1;

	@FindBy(id = "txtTenderId")
	private WebElement tenderpropId;

	@FindBy(xpath = "//a[text()='Mr. PE User']")
	private WebElement peuserlink;
	
	@FindBy(xpath = "//a[@id='anchMemDec']")
	private WebElement peUserDevLink;

	@FindBy(id = "txtcomments")
	private WebElement comments;

	@FindBy(xpath = "//input[@name='btnsubmit']")
	private WebElement submitbutton;

	@FindBy(xpath = "//div[text()='Consent for Opening given successfully']")
	private WebElement consentText1;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logOutButton;

	@FindBy(id = "btnSearch")
	private WebElement searchbutton;

	@FindBy(xpath = "//a[text()='Hope User']")
	private WebElement hopeuserlink;
	
	@FindBy(xpath = "//a[text()='Hope User TRAINING']")
	private WebElement hopeuserlinkTRAINING;
	
	@FindBy(xpath = "//a[@id='anchMemDec']")
	private WebElement tecCptulinkTRAINING;

	@FindBy(xpath = "//input[@name='btnMegaHash']")
	private WebElement megaMegaHashButton;
	
	@FindBy(xpath = "//*[@id='frmNotifyPE']/div[2]/label/input")
	private WebElement notifyPEButton;

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

	@FindBy(xpath = "//input[@id='textfield']")
	private WebElement passwordText;

	@FindBy(xpath = "//a[text()='Go Back to Dashboard']")
	private WebElement goBacktoDashBoard;

	@FindBy(xpath = "//*[@id='print_area']/table[7]/tbody/tr[2]/td[2]/a")
	private WebElement HOPEUSERLINK1;
	
	@FindBy(xpath = "//*[@id='print_area']/table[7]/tbody/tr[2]/td[1]/a")
	private WebElement tecCptuLINK1;

	@FindBy(id = "password")
	private WebElement password1;

	@FindBy(xpath = "//a[@id='signId']")
	private WebElement PEUSERLINKTest;

	@FindBy(xpath = "//*[@id='print_area']/table[7]/tbody/tr[2]/td[1]/a")
	private WebElement MRPEUSERLINK1;
	
	@FindBy(xpath = "//*[@id='print_area']/table[7]/tbody/tr[2]/td[2]/a")
	private WebElement MRPEUSERLINK12;

	@FindBy(xpath = "//a[text()='Close']")
	private WebElement closeButton;

	@FindBy(xpath = "//input[@id='hdnbuttonTenderClose']")
	private WebElement submitButton1;

	@FindBy(xpath = "//a[@id='achSentToPE']")
	private WebElement sendtoPE;

	@FindBy(id = "txtComments")
	private WebElement comments1;

	@FindBy(xpath = "//div[text()='Sent to PE successfully']")
	private WebElement sendtoPETextEle;

	@FindBy(xpath = "//*[@id='btnReset']")
	private WebElement resetbutton;

	@FindBy(xpath = "//div[@id='popup_message']")
	private WebElement confirmMessage;

	@FindBy(xpath = "//span[@id='popup_ok']")
	private WebElement yesButton;

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public AppLtmWorkPage() {
		PageFactory.initElements(driver, this);
	}

	/***
	 * BudgetType -- Revenue Budget Procurement Nature -- Works Procurement Method
	 * -- Limit tendering method so method name is -- DevBudgetWorRFqkApp
	 * 
	 * @throws InterruptedException
	 */

	public void RevBudgetWorkAppLtm() throws InterruptedException {
		Select app = new Select(BudgetType);
		app.selectByValue("2");
		System.out.println("Budget is selected");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		CommanActivity com = PageFactory.initElements(driver, CommanActivity.class);
		com.SelectFinancialYearAPP();

		testUtil = new TestUtil();
		testUtil.randomNoApp();
		clickOn(driver, Next, 10);

		String str = AppId.getText();
		File fnew = new File(FileReaderManager.getInstance().getConfigReader().getAppLtmWorkPath());
		if (fnew.exists() && fnew.isFile()) {
			fnew.delete();
		}

		System.out.println("File Creating...." + "\n");
		try {
			System.out.println("Writing Content in file....." + "\n");
			FileWriter f2 = new FileWriter(fnew, false);
			f2.write(str);
			System.out.println("Writing Content in File completed ....." + "\n");
			f2.close();
			System.out.println("Flie Closed Successfully" + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

		Select slctntr = new Select(ProcurementNature);
		slctntr.selectByValue("Works");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		Select slctemrg = new Select(TypeofEmergency);
		slctemrg.selectByValue("Normal");

		testUtil.randomNo();
		PackageDescription.sendKeys("125jjjdgg hhuiihh");
		LotNo.sendKeys("12378");
		LotDescription.sendKeys("this is lot");
		Quantity.sendKeys("123458");
		Unit.sendKeys("KG");
		EstimatedCost.sendKeys("589745521");
		PackageEstCost.sendKeys("45890000");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		try {
			com.WindowHandleSelectCatg();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		Select slctauth = new Select(ApprovingAuthority);
		slctauth.selectByValue("1");

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		Select slctpqReq = new Select(PQRequires);
		slctpqReq.selectByValue("No");

		Select slctprtype = new Select(ProcurementType);
		slctprtype.selectByValue("NCT");

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		Select slctprmthd = new Select(ProcurementMethod);
		slctprmthd.selectByValue("3");

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		clickOn(driver, Next2, 10);

		com.DatePickerNextDate();

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		NoOfDaysExpectedLastDateofSubmissionofTenders.sendKeys("5");
		NoOfDaysExpectedDateofOpeningofTenders.sendKeys("2");
		NoOfDaysExpectedDateofSubmissionofEvaluationReport.sendKeys("2");
		NoOfDaysExpectedDateofApprovalforAwardofContract.sendKeys("4");

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		NoOfDaysExpectedDateofIssuanceoftheNOA.sendKeys("3");
		NoOfDaysExpectedDateofSigningofContract.sendKeys("4");
		NoOfDaysExpectedDateofCompletionofContract.sendKeys("4");

		clickOn(driver, Save, 10);

		WorkFlowCrt wfcr = PageFactory.initElements(driver, WorkFlowCrt.class);

		try {
			wfcr.CreateWorkFlow();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		try {
			wfcr.HopeUserActivityForAPP1stphase();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		File src = new File(FileReaderManager.getInstance().getConfigReader().getAppLtmWorkPath());
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String strgAppIdGoodsOwn = null;
		try {
			strgAppIdGoodsOwn = IOUtils.toString(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		SearchApp.sendKeys(strgAppIdGoodsOwn);

		try {
			wfcr.HopeUserActivityForAPP2ndPhase();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		try {
			wfcr.PePublisheApp1stPhase();
		} catch (Throwable e) {

			e.printStackTrace();
		}

		serchAppid.sendKeys(strgAppIdGoodsOwn);

		try {
			wfcr.PePublisheApp2ndPhase();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/***
	 * BudgetType ---> DevlopmentBudget Procurement Nature -- Works Procurement
	 * Method -- Request for quotation unit rate so method name is
	 * DevBudgetWorRFqkApp
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void Development_Budget_Works_LTM_TestCase(String BudgetType, String FinancialYear, String selectProject1,
			String appCode, String ProcurementNature1, String TypeofEmergency1, String PackageNo,
			String PackageDescription1, String LotNo1, String LotDescription1, String Quantity1, String unit1,
			String EstimatedCost1, String ApprovingAuthority1, String ProcurementType1, String ProcurementMethod1,
			String FinancialEstimatedCost, String RunType) throws InterruptedException, IOException {

		// Method 1:
		/*
		 * 1.Iterate row and coloumn and get the cell value 2.Using for loop 3.Get total
		 * rows and iterate table 4.Put if(string matches) then 5.Select the value
		 * 5.Lengthy method
		 */
		// *[@id='resultTable']/tbody/tr[]/td[10]/a[1]

		// Search Pending AppId
		//Old app id -  4142 - dev server
		//Old app id -  64042  - training server
		//Old app id -  5190  - staging server
		
		File file = new File(FileReaderManager.getInstance().getConfigReader().createAPPDevlopementBudget_Works_LTM_Path());
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String appId = br.readLine();
		System.out.println("appId is --->>"+appId);
		searchAppId.sendKeys(appId);
		
		Assert.assertTrue(true);

		// Select package type
		dropdwnhelper.selectUsingVisibleText(cmbStatusDropDown, "- Approved -");

		js1.clickElement(searchAppButton);

		String before_xpath = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath = "]/td[10]/a[1]";

		for (int i = 0; i <= 100; i++) {
			String name = driver.findElement(By.xpath("//*[@id='" + i + "']/td[2]")).getText();
			System.out.println("name is zzzzzz" + name);
			log.info(name);
			if (name.contains(appId)) {
				driver.findElement(By.xpath("//*[@id='" + i + "']/td[6]/a/img")).click();
				break;
			}
		}
		Assert.assertTrue(true);
		// Click on Add new package
		js1.scrollIntoView(addNewPackage);
		js1.clickElement(addNewPackage);

		String str = AppId.getText();
		System.out.println("data is " + str);
		File src = new File(
				FileReaderManager.getInstance().getConfigReader().createAPPDevlopementBudget_Works_LTM_Path());
		// File fnew = new
		// File("E:\\Users\\shrikanth\\Downloads\\AppId\\appDevelopmentBudgetWorksRFQU.txt");

		System.out.println("Writing Content in file....." + "\n");
		FileWriter f2 = new FileWriter(src, false);
		f2.write(str);
		f2.flush();
		f2.close();

		// Select package type
		dropdwnhelper.selectUsingVisibleText(packageType, "e-GP");
		Assert.assertTrue(true);

		// Select procurement nature
		dropdwnhelper.selectUsingVisibleText(ProcurementNature, ProcurementNature1);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// Select TypeofEmergency
		dropdwnhelper.selectUsingVisibleText(TypeofEmergency, TypeofEmergency1);

		testUtil = new TestUtil();
		testUtil.randomNo();
		PackageDescription.sendKeys(PackageDescription1);

		LotNo.sendKeys(LotNo1);
		LotDescription.sendKeys(LotDescription1);
		Quantity.sendKeys(Quantity1);
		Unit.sendKeys(unit1);
		EstimatedCost.sendKeys(EstimatedCost1);
		// PackageEstCost.sendKeys("890000");

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// Window handling
		try {
			com = PageFactory.initElements(driver, CommanActivity.class);
			com.WindowHandleSelectCatg();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// Select ApprovingAuthority
		dropdwnhelper.selectUsingVisibleText(ApprovingAuthority, ApprovingAuthority1);

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// Select PQRequires
		dropdwnhelper.selectUsingVisibleText(PQRequires, "No");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// Select ProcurementType
		dropdwnhelper.selectUsingVisibleText(ProcurementType, ProcurementType1);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		Thread.sleep(200);

		// Select ProcurementMethod
		dropdwnhelper.selectUsingVisibleText(ProcurementMethod, ProcurementMethod1);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		clickOn(driver, Next2, 10);

		waithelper.pageLoadTimeOut(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		com.DatePickerNextDate();

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		NoOfDaysExpectedLastDateofSubmissionofTenders.sendKeys("5");
		NoOfDaysExpectedDateofOpeningofTenders.sendKeys("2");
		NoOfDaysExpectedDateofSubmissionofEvaluationReport.sendKeys("2");
		NoOfDaysExpectedDateofApprovalforAwardofContract.sendKeys("4");

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		NoOfDaysExpectedDateofIssuanceoftheNOA.sendKeys("3");
		NoOfDaysExpectedDateofSigningofContract.sendKeys("4");
		NoOfDaysExpectedDateofCompletionofContract.sendKeys("4");

		// Assert.assertTrue(false);
		clickOn(driver, Save, 10);

		// Process file on workflow - Click this link
		TestUtil.clickOn(driver, processFileInWorkFlow, 100);

		// TestUtil.sendKeysTab(driver, noOfReviewers, 100, "0");
		// js1.clickElement(submitButton);

		// Select initiator and Approver
		// initiator=PE
		// Approver=Hope
		// dropdwnhelper.selectUsingVisibleText(approverDropDown, "HOPE");
		// js1.clickElement(submitButton1);

		Thread.sleep(2000);
		// If there is only one frame in html page, then use index is 0 -
		// driver.switchTo().frame(0);
		driver.switchTo().frame(0);
		// framehelper.switchToFrame(0);
		Comments.sendKeys("Please Approve annual procuremnet plan");
		// Assert.assertTrue(false);
		driver.switchTo().defaultContent();
		Thread.sleep(100);
		dropdwnhelper.selectUsingVisibleText(Action, "Forward");
		waithelper.setImplicitWait(100, TimeUnit.SECONDS);

		js1.clickElement(WorkflowSubmit);
		LogOut.click();

		// Once logout
		// From here - Hope User Login takes place and workflow starts

		WorkFlowCrt wfcr = PageFactory.initElements(driver, WorkFlowCrt.class);

		// From here - Hope user login
		try {
			wfcr.HopeUserActivityForAPP1stphase();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		/*File src1 = new File(FileReaderManager.getInstance().getConfigReader()
				.createAPPDevlopementBudget_Works_RequestForQuotaionUnit_Path());*/
		
		File src1 = new File(FileReaderManager.getInstance().getConfigReader()
				.createAPPDevlopementBudget_Works_LTM_Path());
		
		FileInputStream fis1 = null;
		try {
			fis1 = new FileInputStream(src1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String strgAppIdWorksDevelopment = null;
		try {
			strgAppIdWorksDevelopment = IOUtils.toString(fis1);
			System.out.println("Shriaknth is -->>" + strgAppIdWorksDevelopment);
		} catch (IOException e) {
			e.printStackTrace();
		}

		SearchApp.sendKeys(strgAppIdWorksDevelopment);

		try {
			wfcr.HopeUserActivityForAPP2ndPhase();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		try {
			wfcr.PePublisheApp1stPhase();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		serchAppid.sendKeys(strgAppIdWorksDevelopment);
		try {
			wfcr.PePublisheApp2ndPhase();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * generateTenderIdTest from Annual procurement package
	 * 
	 * @throws Throwable
	 */
	public void tenderIdGeneration(String FinancialEstimatedCost, String packageCost) {
		// Search Pending App Id
		searchAppId.sendKeys("64042");
		dropdwnhelper.selectUsingVisibleText(statusSelect, "- Approved -");
		js1.clickElement(searchAppButton);

		String before_xpath = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath = "]/td[10]/a[1]";

		for (int i = 0; i <= 20; i++) {
			String name = driver.findElement(By.xpath("//*[@id='" + i + "']/td[2]")).getText();
			System.out.println("name is zzzzzz" + name);
			log.info(name);
			if (name.contains("64042")) {
				driver.findElement(By.xpath("//*[@id='" + i + "']/td[6]/a/img")).click();
				break;
			}
		}

		for (int i = 2; i <= 100; i++) {
			// *[@id="resultTable"]/tbody/tr['"+i+"']/td[5]
			String name = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[5]")).getText();
			System.out.println("name is zzzzzz" + name);
			log.info(name);
			if (name.equals(packageCost)) {
				/**
				 * Then, Click on Create tender/proposal link
				 */
				System.out.println("test is ---->>" + name + " " + packageCost);
				driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[10]/a[2]")).click();
				break;
			}
		}
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		RFQNo.sendKeys("Invitation Reference No 9900486878");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		LocalDateTime now = LocalDateTime.now();
		System.out.println("now it is --->> " + now);

		// plus 7 days -->> Pre - Tender/Proposal meeting Start Date and Time
		LocalDateTime seven = now.plusDays(7);
		System.out.println("seven it is --->> " + seven);

		// plus 3 minutes
		LocalDateTime one = now.plusMinutes(3);
		System.out.println("one plus one --->> " + now);

		// plus one
		String RFQPublicationDateandTime1 = dtf.format(one);
		selectDateByJs(driver, RFQPublicationDateandTime, RFQPublicationDateandTime1);

		// plus 20
		LocalDateTime twenty = now.plusDays(20);
		String lastsellingdownloadingDateandTime = dtf.format(twenty);
		selectDateByJs(driver, TenderProposalDocumentlastsellingdownloadingDateandTime,
				lastsellingdownloadingDateandTime);

		// plus 7
		String meetingStartDateandTime = dtf.format(seven);
		selectDateByJs(driver, PreTenderProposalmeetingStartDateandTime, meetingStartDateandTime);

		// plus 10
		LocalDateTime ten = now.plusDays(10);
		String meetingEndDateandTime = dtf.format(ten);
		selectDateByJs(driver, PreTenderProposalmeetingEndDateandTime, meetingEndDateandTime);

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,500)");

		// plus 40
		LocalDateTime fourty = now.plusDays(40);
		String dateVal1 = dtf.format(fourty);
		selectDateByJs(driver, ClosingDateandTime, dateVal1);
		ClosingDateandTime.sendKeys(Keys.F5);
		// ProposalOpeningDateandTime

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		// plus 35
		/*
		 * LocalDateTime thirtyfive = now.plusDays(35); String dateVal2 =
		 * dtf.format(thirtyfive); selectDateByJs(driver, ProposalSecuritySubmission,
		 * dateVal2);
		 */

		// ***************Switch to frame(0)****************************************
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		EligibilityofTenderer.sendKeys("Eligibility of Tenderer/Consultant");
		driver.switchTo().defaultContent();

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,500)");

		// ***************** Switch to frame(1)
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.switchTo().frame(1);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		EligibilityofTenderer.sendKeys("Brief Description of Goods and Related Service");
		driver.switchTo().defaultContent();

		// Enter Tender/Proposal Document Price
		// ProposalDocumentPrice.sendKeys("4000");

		// Enter location
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Location.sendKeys("Dhaka");

		// Enter Tender/proposal Security
		// ProposalSecurityAmountInBDT.sendKeys("4000");

		// *****************Start Date
		LocalDateTime fifty = now.plusDays(50);
		String StartDat = dtf.format(fifty);
		selectDateByJs(driver, StartDate, StartDat);

		// *****************Completion Date
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		LocalDateTime fiftyfive = now.plusDays(55);
		String CompletionDat = dtf.format(fiftyfive);
		selectDateByJs(driver, CompletionDate, CompletionDat);

		// click on submit button
		js.executeScript("arguments[0].click();", submitToRadiobtn);

		String strTenderId = TenderId.getText();
		System.out.println("tender id  is --->> " + strTenderId);

		// Convert string tenderId to double
		int convTendId = Integer.parseInt(strTenderId);
		System.out.println("convert string tenderId to double --->>" + convTendId);

		/*
		 * Notice Tab
		 */
		// Configure key information details
		dropdwnhelper.selectUsingVisibleText(StandardTenderProposalDocument, "e-PW1(a)");
		ProposalValidityInNoofDays.sendKeys("16", Keys.TAB);
		js.executeScript("arguments[0].click();", submitToRadiobtn1);
		// Handle alert
		AlertHelper alert = new AlertHelper(driver);
		alert.acceptAlertIfPresent();

		// Save the tenderId

		// E:\\Users\\shrikanth\\Downloads\\AppId\\appDevelopmentBudgetWorksRFQU.txt
		File fnew = new File(FileReaderManager.getInstance().getConfigReader().getTenderRFQWorkPath());
		if (fnew.exists() && fnew.isFile()) {
			fnew.delete();
		}
		System.out.println("File Creating...." + "\n");

		try {
			System.out.println("Writing Content in file....." + "\n");
			FileWriter f2 = new FileWriter(fnew, false);
			f2.write(strTenderId);
			System.out.println("Writing Content in File completed ....." + "\n");
			f2.close();
			System.out.println("File Closed Successfully" + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Official Cost Estimate - Click on Add link
		AddOfficialCostEstimate.click();
		OfficialCostEstimate.sendKeys(FinancialEstimatedCost);
		js.executeScript("arguments[0].click();", OfficialCostEstimateSubmit);

		// Create Workflow
		WorkFlowCrt wfcrt = PageFactory.initElements(driver, WorkFlowCrt.class);

		try {
			/*
			 * Document tab
			 */
			wfcrt.Document_TAB_ActivityForm_e_PW1A();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,800)");

		clickOn(driver, GrandSummaryCreateLink, 100);
		js.executeScript("arguments[0].click();", GrandSummarySubmit);
		TenderProposalDocument.click();

		/*
		 * Evaluation tab
		 */
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		UnnElee.click();
		// Click on Document tab
		for (int i = 0; i < totalTabs.size(); i++) {
			WebElement element = totalTabs.get(i);
			String text = totalTabs.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.equals("Evaluation")) {
				element.click();
				break;
			}
		}
		// EvaluationLink.click();
		EvaluationCommitteeCreate.click();
		// unassryeleemm.click();
		CommitteeName.sendKeys("Evl Comm");
		clickOn(driver, AddMembers, 10);

		// Window Handling
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		String Parent_Window_2 = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		AOUserAsMember.click();
		HopeUserAsMember.click();
		clickOn(driver, Addmembers, 10);
		driver.switchTo().window(Parent_Window_2);
		driver.switchTo().defaultContent();
		System.out.println("Windows come to back");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,300)");

		Select slctAo = new Select(CommitteeRoleAOUser);
		slctAo.selectByValue("m");

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("arguments[0].click();", submitcommMem);
		/*
		 * Create workflow for Notice tab
		 */
		try {
			wfcrt.CreateWorkFlowForNotice();
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		NotifyCommitteeMembers.click();
		js.executeScript("window.scrollBy(0,300)");
		txtRemarks.sendKeys("Remarks");
		clickOn(driver, NotifyBtn, 10);
		ponnnusgh.click();
		/*
		 * Create workflow for Opening tab
		 */
		// OpeningLink.click();
		for (int i = 0; i < totalTabs.size(); i++) {
			WebElement element = totalTabs.get(i);
			String text = totalTabs.get(i).getText();
			log.info("tabs are ---->> " + text);
			if (text.equals("Opening")) {
				element.click();
				break;
			}
		}
		try {
			wfcrt.OpningCommitteeCreate();
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		try {
			wfcrt.CreateWorkFlowForNotice();
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		NotifyCommitteeMembers.click();
		js.executeScript("window.scrollBy(0,300)");
		txtRemarks.sendKeys("Remarks");
		clickOn(driver, NotifyBtn, 10);

		opningdummy.click();
		NoticeLink.click();
		NoticeCreateMemmber.click();
		memberHopeChckBx.click();
		memberAoeChckBx.click();

		js.executeScript("arguments[0].click();", Submtmmbr);
		NoticeLink.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		js.executeScript("window.scrollBy(0,800)");

		log.info("*****Before SelectTenderConsultant **************");
		/*
		 * SelectTenderConsultant.click(); CreateTenderConsultantList.click();
		 * js.executeScript("window.scrollBy(0,1500)"); clickOn(driver,AddToList,10);
		 * GoToDashBord.click();
		 */

		/*
		 * Selected Tenderers/Consultants for Tender/Proposal
		 */
		TestUtil.clickOn(driver, createTendererConsultantListLink1, 100);
		TestUtil.clickOn(driver, createTendererConsultantListLink2, 100);

		/*
		 * landed on Select Tenderers/Consultants for the Tender/Proposal
		 */
		dropdwnhelper.selectUsingVisibleText(selectStateDistrict, "Dhaka");
		js.executeScript("arguments[0].click();", btnSearch);
		// Click on Add to List
		js.executeScript("arguments[0].click();", addtoList);
		js.executeScript("arguments[0].click();", goBackDashBoard);

		try {
			/*
			 * Create WorkFlow For NoticeTab
			 */
			wfcrt.CreateWorkFlowForNotice();
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		log.info("*****Start SelectTenderConsultant **************");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		ConfigureNoticeTab.click();

		Select slctconfr0 = new Select(ClarificationTenderIsTobeallowed);
		slctconfr0.selectByValue("No");
		clickOn(driver, submitConfm, 10);

		PublishTender.click();
		js.executeScript("window.scrollBy(0,1000)");
		commentstToPublishTender.sendKeys("Tender ");

		WaitHelper wh = new WaitHelper(driver);

		try {
			log.info("************** inside try block ************************");
			js.executeScript("arguments[0].click();", PublishSubmitBtn);
			// wh.pageLoadTimeOut(15000, TimeUnit.SECONDS);
			Thread.sleep(15000);
			// driver.navigate().to("https://www.training.eprocure.gov.bd/Index.jsp");

			// WebElement ele = wh.waitForElement(divMessage, 500, 5);
			// driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,
			// TimeUnit.SECONDS);
			// Thread.sleep(1000);
			// wh.WaitForElementVisibleWithPollingTime(divMessage, 250, 5);
			// driver.navigate().refresh();
			// wh.setImplicitWait(10000, TimeUnit.SECONDS);
		} catch (Exception e) {
			log.info("************** inside catch block************************");
			e.printStackTrace();
		} finally {
			System.out.println("shrikanth kulal inside finally block");
			// driver.navigate().to("https://www.training.eprocure.gov.bd/Index.jsp+strTenderId");
			// https://www.training.eprocure.gov.bd/officer/Notice.jsp?tenderid=41996&msgPublish=msgPublish
			try {
				log.info("************** inside try block************************");
				// loading url below one
				driver.navigate().to("https://www.training.eprocure.gov.bd/officer/TenderPdfGenerate.jsp?tenderid="
						+ convTendId + "");
				// wh.pageLoadTimeOut(10000, TimeUnit.SECONDS);
				Thread.sleep(500);

				// driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,
				// TimeUnit.SECONDS);
				////// ********************************
				// WebElement waitElement =
				// driver.findElement(By.xpath("//img[@src='/resources/images/Dashboard/ajax-loader.gif']"));

				// waitElement =
				// wh.waitForElement(driver.findElement(By.xpath("//img[@src='/resources/images/Dashboard/ajax-loader.gif']")),
				// 250, 10);
				// checking if loading indicator was found and if so we wait for it to
				// disappear
				/*
				 * if (waitElement != null) {
				 * System.out.println("shrikanth kulal is not equal to null"); WebDriverWait
				 * wait = new WebDriverWait(driver, 100); boolean
				 * status=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
				 * "//img[@src='/resources/images/Dashboard/ajax-loader.gif']")));
				 * System.out.println("status is ---->>> " +status); }
				 */
			} catch (Exception e) {
				log.info("************** finally --->> inside catch block************************");
				e.printStackTrace();
			} finally {
				// driver.navigate().to("https://www.training.eprocure.gov.bd/officer/Notice.jsp?tenderid="+convTendId+"&msgPublish=msgPublish");
			}
			///// ******************
			// driver.navigate().to("https://www.training.eprocure.gov.bd/officer/Notice.jsp?tenderid=convTendId&msgPublish=msgPublish");
			// driver.navigate().to("https://www.training.eprocure.gov.bd/officer/Notice.jsp?tenderid=convTendId&msgPublish=msgPublish");
		}
	}

	/**
	 * generateTenderIdTest from Annual procurement package
	 * @throws IOException 
	 * @throws Throwable
	 */
	public void tenderIdGenerationForEPW2B_LTM_Works(String FinancialEstimatedCost, String packageCost) throws IOException {
		// Search Pending App Id
		
		File file = new File(FileReaderManager.getInstance().getConfigReader().createAPPDevlopementBudget_Works_LTM_Path());
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String appId = br.readLine();
		
		System.out.println("appId is --->>"+appId);
		searchAppId.sendKeys(appId);
		dropdwnhelper.selectUsingVisibleText(statusSelect, "- Approved -");
		js1.clickElement(searchAppButton);
		//Assert.assertTrue(false);

		String before_xpath = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath = "]/td[10]/a[1]";

		for (int i = 0; i <= 1000; i++) {
			String name = driver.findElement(By.xpath("//*[@id='" + i + "']/td[2]")).getText();
			System.out.println("name is zzzzzz" + name);
			log.info(name);
			if (name.contains(appId)) {
				driver.findElement(By.xpath("//*[@id='" + i + "']/td[6]/a/img")).click();
				break;
			}
		}

		for (int i = 2; i <= 1000; i++) {
			// *[@id="resultTable"]/tbody/tr['"+i+"']/td[5]
			String name = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[5]")).getText();
			System.out.println("name is zzzzzz" + name);
			log.info(name);
			if (name.equals(packageCost)) {
				/**
				 * Then, Click on Create tender/proposal link
				 */
				System.out.println("test is ---->>" + name + " " + packageCost);
				driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[10]/a[2]")).click();
				break;
			}
		}
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		RFQNo.sendKeys("Invitation Reference No 9900486878");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		LocalDateTime now = LocalDateTime.now();
		System.out.println("now it is --->> " + now);

		// plus 7 days ------->> Pre - Tender/Proposal meeting Start Date and Time
		LocalDateTime seven = now.plusDays(7);
		System.out.println("seven it is --->> " + seven);

		// plus 3 minutes
		LocalDateTime one = now.plusMinutes(3);
		System.out.println("one plus one --->> " + now);

		// plus one
		String RFQPublicationDateandTime1 = dtf.format(one);
		selectDateByJs(driver, RFQPublicationDateandTime, RFQPublicationDateandTime1);

		// plus 20
		LocalDateTime twenty = now.plusDays(20);
		String lastsellingdownloadingDateandTime = dtf.format(twenty);
		selectDateByJs(driver, TenderProposalDocumentlastsellingdownloadingDateandTime,
				lastsellingdownloadingDateandTime);

		// plus 7
		String meetingStartDateandTime = dtf.format(seven);
		selectDateByJs(driver, PreTenderProposalmeetingStartDateandTime, meetingStartDateandTime);

		// plus 10
		LocalDateTime ten = now.plusDays(10);
		String meetingEndDateandTime = dtf.format(ten);
		selectDateByJs(driver, PreTenderProposalmeetingEndDateandTime, meetingEndDateandTime);

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,500)");

		// plus 40
		LocalDateTime fourty = now.plusDays(40);
		String dateVal1 = dtf.format(fourty);
		selectDateByJs(driver, ClosingDateandTime, dateVal1);
		ClosingDateandTime.sendKeys(Keys.F5);

		// ProposalOpeningDateandTime
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// plus 35
		LocalDateTime thirtyfive = now.plusDays(35);
		String dateVal2 = dtf.format(thirtyfive);
		selectDateByJs(driver, ProposalSecuritySubmission, dateVal2);

		// ***************Switch to frame(0)****************************************
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		EligibilityofTenderer.sendKeys("Eligibility of Tenderer/Consultant");
		driver.switchTo().defaultContent();

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,500)");

		// ***************** Switch to frame(1)
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.switchTo().frame(1);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		EligibilityofTenderer.sendKeys("Brief Description of Goods and Related Service");
		driver.switchTo().defaultContent();

		// Enter Tender/Proposal Document Price
		tenderProposalDocumentPrice.sendKeys("4000");

		// Enter location
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Location.sendKeys("Dhaka");

		// Enter Tender/proposal Security
		ProposalSecurityAmountInBDT.sendKeys("4000");

		// ***************** Start Date
		LocalDateTime fifty = now.plusDays(50);
		String StartDat = dtf.format(fifty);
		selectDateByJs(driver, StartDate, StartDat);

		// *****************Completion Date
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		LocalDateTime fiftyfive = now.plusDays(55);
		String CompletionDat = dtf.format(fiftyfive);
		selectDateByJs(driver, CompletionDate, CompletionDat);

		// Click on submit button
		js.executeScript("arguments[0].click();", submitToRadiobtn);

		String strTenderId = TenderId.getText();
		System.out.println("tender id  is --->> " + strTenderId);

		// Convert string tenderId to int
		int convTendId = Integer.parseInt(strTenderId);
		System.out.println("convert string tenderId to double --->>" + convTendId);
		/*
		 * Notice Tab
		 */
		// Configure key information details
		dropdwnhelper.selectUsingVisibleText(StandardTenderProposalDocument, "e-PW2(b)");
		ProposalValidityInNoofDays.sendKeys("16", Keys.TAB);
		js.executeScript("arguments[0].click();", submitToRadiobtn1);
		// Handle Alert
		/*
		 * AlertHelper alert = new AlertHelper(driver); alert.acceptAlertIfPresent();
		 */

		// Save the tenderId
		// E://Users//shrikanth//Downloads//AppId//appDevelopmentBudgetWorksRFQU.txt
		File fnew = new File(FileReaderManager.getInstance().getConfigReader().getTenderLtmWorkPath());
		if (fnew.exists() && fnew.isFile()) {
			fnew.delete();
		}
		System.out.println("File Creating...." + "\n");

		try {
			System.out.println("Writing Content in file......" + "\n");
			FileWriter f2 = new FileWriter(fnew, false);
			f2.write(strTenderId);
			System.out.println("Writing Content in File completed ....." + "\n");
			f2.close();
			System.out.println("File Closed Successfully" + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(true);
		// Official Cost Estimate - Click on Add link
		AddOfficialCostEstimate.click();
		OfficialCostEstimate.sendKeys(FinancialEstimatedCost);
		js.executeScript("arguments[0].click();", OfficialCostEstimateSubmit);

		// Create Workflow
		WorkFlowCrt wfcrt = PageFactory.initElements(driver, WorkFlowCrt.class);
		Assert.assertTrue(true);
		try {
			/*
			 * Document tab WorkFlowCrt java
			 */
			wfcrt.Document_TAB_ActivityForm_e_PW2B();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,800)");

		/*
		 * Grand Summary - Create link
		 */
		clickOn(driver, GrandSummaryCreateLink, 100);

		boolean checkBoxSelect = TendererQuotedPrice1.isSelected();
		if (!checkBoxSelect) {
			TendererQuotedPrice1.click();
		}
		clickOn(driver, GrandSummarySubmit, 100);

		String verifyText = confirmMessage.getText();
		System.out.println("Shrikanth kerala ----->>>>>>" + verifyText);
		AssertionHelper.verifyText(verifyText, "Be sure that you have selected ‘Tenderer’s Quoted Price’ form ONLY.",
				"Verified Successfully");

		//Click on Yes Button
		//yesButton.click();

		clickOn(driver, yesButton, 100);
		TenderProposalDocument1.click();

		/*
		 * js.executeScript("arguments[0].click();", GrandSummarySubmit);
		 * TenderProposalDocument.click();
		 */

		/*
		 * Evaluation tab
		 */
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		UnnElee.click();
		// Click on Document tab
		for (int i = 0; i < totalTabs.size(); i++) {
			WebElement element = totalTabs.get(i);
			String text = totalTabs.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.equals("Evaluation")) {
				element.click();
				break;
			}
		}
		// EvaluationLink.click();
		EvaluationCommitteeCreate.click();
		// unassryeleemm.click();
		CommitteeName.sendKeys("Evl Commitee members team");
		clickOn(driver, AddMembers, 10);

		// Window Handling
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		String Parent_Window_2 = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		
		//div[@id='pe1']/table/tbody/tr[]/td[2]
		String before_xpth = "//div[@id='pe1']/table/tbody/tr[";
		String after_xpth = "]/td[2]";

		for (int i = 2; i <= 1000; i++) {
			String memberName = driver.findElement(By.xpath(before_xpth+i+after_xpth)).getText();
			System.out.println("name is zzzzzz" + memberName);
			log.info(memberName);
			if (memberName.contains("PE USER_UAT")) {
				driver.findElement(By.xpath("//*[@id='chk55']")).click();
				continue;
			}else if (memberName.contains("TEC CPTU CPTU")) {
				driver.findElement(By.xpath("//*[@id='chk57']")).click();
				break;
			}
		}
		Assert.assertTrue(true);
		//AOUserAsMember.click();
		//HopeUserAsMember.click();
		clickOn(driver, Addmembers, 10);
		driver.switchTo().window(Parent_Window_2);
		driver.switchTo().defaultContent();
		System.out.println("Windows come to back");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,300)");

		Select slctAo = new Select(CommitteeRoleAOUser);
		slctAo.selectByValue("ms");

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("arguments[0].click();", submitcommMem);
		/*
		 * Create workflow for Notice tab
		 */
		try {
			wfcrt.CreateWorkFlowForNotice();
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		NotifyCommitteeMembers.click();
		js.executeScript("window.scrollBy(0,300)");
		txtRemarks.sendKeys("Remarks");
		clickOn(driver, NotifyBtn, 10);
		ponnnusgh.click();
		
		Assert.assertTrue(true);
		/*
		 * Create Workflow for Opening tab
		 */
		// OpeningLink.click();
		for (int i = 0; i < totalTabs.size(); i++) {
			WebElement element = totalTabs.get(i);
			String text = totalTabs.get(i).getText();
			log.info("tabs are ---->> " + text);
			if (text.equals("Opening")) {
				element.click();
				break;
			}
		}

		try {
			wfcrt.OpningCommitteeCreate();
		} catch (Throwable e1) {
			e1.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		try {
			//Create work flow
			wfcrt.CreateWorkFlowForNotice();
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		NotifyCommitteeMembers.click();
		js.executeScript("window.scrollBy(0,300)");
		txtRemarks.sendKeys("Remarks");
		clickOn(driver, NotifyBtn, 10);

		opningdummy.click();
		NoticeLink.click();
		/*
		 * Committee Member for Encryption/Decryption
		 */
		NoticeCreateMemmber.click();
		Assert.assertTrue(true);
		memberTECCPTUChckBx.click();
		memberPEChckBx.click();

		js.executeScript("arguments[0].click();", Submtmmbr);
		NoticeLink.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		js.executeScript("window.scrollBy(0,800)");

		log.info("*****Before SelectTenderConsultant **************");
		/*
		 * SelectTenderConsultant.click(); CreateTenderConsultantList.click();
		 * js.executeScript("window.scrollBy(0,1500)"); clickOn(driver,AddToList,10);
		 * GoToDashBord.click();
		 */

		/*
		 * Selected Tenderers/Consultants for Tender/Proposal
		 */
		TestUtil.clickOn(driver, createTendererConsultantListLink1, 100);
		TestUtil.clickOn(driver, createTendererConsultantListLink2, 100);

		/*
		 * landed on Select Tenderers/Consultants for the Tender/Proposal
		 */
		dropdwnhelper.selectUsingVisibleText(selectStateDistrict, "Dhaka");
		js.executeScript("arguments[0].click();", btnSearch);
		// Click on Add to List
		js.executeScript("arguments[0].click();", addtoList);
		js.executeScript("arguments[0].click();", goBackDashBoard);

		try {
			/*
			 * Create WorkFlow For NoticeTab
			 */
			wfcrt.CreateWorkFlowForNotice();
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		log.info("*****Start SelectTenderConsultant **************");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		/*
		 * Clarification on Tender/Proposal
		 */
		ConfigureNoticeTab.click();

		Select slctconfr0 = new Select(ClarificationTenderIsTobeallowed);
		slctconfr0.selectByValue("No");
		clickOn(driver, submitConfm, 10);

		PublishTender.click();
		js.executeScript("window.scrollBy(0,1000)");
		commentstToPublishTender.sendKeys("Tender ");

		WaitHelper wh = new WaitHelper(driver);

		try {
			log.info("************** inside try block ************************");
			js.executeScript("arguments[0].click();", PublishSubmitBtn);
			// wh.pageLoadTimeOut(15000, TimeUnit.SECONDS);
			Thread.sleep(15000);
			// driver.navigate().to("https://www.training.eprocure.gov.bd/Index.jsp");

			// WebElement ele = wh.waitForElement(divMessage, 500, 5);
			// driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,
			// TimeUnit.SECONDS);
			// Thread.sleep(1000);
			// wh.WaitForElementVisibleWithPollingTime(divMessage, 250, 5);
			// driver.navigate().refresh();
			// wh.setImplicitWait(10000, TimeUnit.SECONDS);
		} catch (Exception e) {
			log.info("************** inside catch block************************");
			e.printStackTrace();
		} finally {
			System.out.println("shrikanth kulal inside finally block");
			// driver.navigate().to("https://www.training.eprocure.gov.bd/Index.jsp+strTenderId");
			// https://www.training.eprocure.gov.bd/officer/Notice.jsp?tenderid=41996&msgPublish=msgPublish
			try {
				log.info("************** inside try block************************");
				// loading url below one
				driver.navigate().to("https://www.training.eprocure.gov.bd/officer/TenderPdfGenerate.jsp?tenderid="
						+ convTendId + "");
				// wh.pageLoadTimeOut(10000, TimeUnit.SECONDS);
				Thread.sleep(500);

				// driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,
				// TimeUnit.SECONDS);
				////// ********************************
				// WebElement waitElement =
				// driver.findElement(By.xpath("//img[@src='/resources/images/Dashboard/ajax-loader.gif']"));

				// waitElement =
				// wh.waitForElement(driver.findElement(By.xpath("//img[@src='/resources/images/Dashboard/ajax-loader.gif']")),
				// 250, 10);
				// checking if loading indicator was found and if so we wait for it to
				// disappear
				/*
				 * if (waitElement != null) {
				 * System.out.println("shrikanth kulal is not equal to null"); WebDriverWait
				 * wait = new WebDriverWait(driver, 100); boolean
				 * status=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
				 * "//img[@src='/resources/images/Dashboard/ajax-loader.gif']")));
				 * System.out.println("status is ---->>> " +status); }
				 */
			} catch (Exception e) {
				log.info("************** finally --->> inside catch block************************");
				e.printStackTrace();
			} finally {
				// driver.navigate().to("https://www.training.eprocure.gov.bd/officer/Notice.jsp?tenderid="+convTendId+"&msgPublish=msgPublish");
			}
			///// ******************
			// driver.navigate().to("https://www.training.eprocure.gov.bd/officer/Notice.jsp?tenderid=convTendId&msgPublish=msgPublish");
			// driver.navigate().to("https://www.training.eprocure.gov.bd/officer/Notice.jsp?tenderid=convTendId&msgPublish=msgPublish");
		}
	}

	/**
	 * Branch maker login ---->> Pefilerform operations
	 * 
	 * @throws InterruptedException
	 */
	public void createBranchMakerPayment_LTM_EPW2B(String tendererName) throws InterruptedException {
		log.info("*********** inside createBranchMakerPayment ************");
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
			System.out.println("String TenderId with GSS --->>" + strngTenderId);
			tenderId.sendKeys(strngTenderId);
			Thread.sleep(2000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		js1.clickElement(searchButtonId);
		Thread.sleep(3000);
		js1.scrollIntoView(dashBoardIcon);
		js1.clickElement(dashBoardIcon);

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
		/*
		 * String before_xpath="//*[@id='resultTable']/tbody/tr["; String
		 * after_xpath="]/td[2]";
		 * 
		 * for (int i=1; i<=10; i++) {
		 * log.info("***********inside for loop************"); String
		 * name=driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
		 * System.out.println(name); if (name.contains(strngTenderId)) {
		 * System.out.println("shrikanth kulal -->> "+name); try {
		 * driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+
		 * "]/td[7]/a/img")).click(); break; } catch (Exception e) { e.getMessage();
		 * }finally { driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+
		 * "]/td[7]/a/img")).click(); //break; }
		 * 
		 * } }
		 */

		// Verify close date and time
		/*
		 * String closeDateTime = verification.getText(closingDateTime);
		 * System.out.println("date is ---->> "+closeDateTime);
		 * AssertionHelper.verifyText(closeDateTime, "29-Dec-2018 09:57",
		 * "text is verified");
		 */

		// List<WebElement> data =
		// driver.findElements(By.xpath("//ul[@class='tabPanel_1']/li"));
		System.out.println("size is --->>" + totalTabs1.size());

		for (int i = 0; i < totalTabs1.size(); i++) {
			WebElement element = totalTabs1.get(i);
			String text = totalTabs1.get(i).getText();
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
		emailIdText.sendKeys(tendererName);
		js1.clickElement(searchButton);

		// Click on Make Payment in Action tab
		makePaymentLinkText.click();

		Assert.assertTrue(true);

		// DropDownhelper used to select ModeOfPayment
		DropDownHelper dropdown = new DropDownHelper(driver);
		dropdown.selectUsingVisibleText(selectModeOfPayment, "Cash");

		// Enter remarks
		remarks.sendKeys("ModeOfPayment is done");
		// click on Submit button
		// js.scrollToElementAndClick(clickSubmitButton);

		js1.scrollIntoView(clickSubmitButton);
		js1.clickElement(clickSubmitButton);
	}

	/**
	 * Branch checker login ---->> Perform operations
	 * 
	 * @throws InterruptedException
	 */
	public void createBranchCheckerPayment_LTM_EPW2B(String tendererName) throws InterruptedException {
		log.info("*********** inside createBranchMakerPayment ************");
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
			System.out.println("String TenderId with GSS --->>" + strngTenderId);
			tenderId.sendKeys(strngTenderId);
			Thread.sleep(3000);
			js1.clickElement(searchButtonId);
			Thread.sleep(3000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// js1.clickElement(searchButtonId);
		// Thread.sleep(2000);
		// js1.scrollIntoView(dashBoardIcon);
		// js1.clickElement(dashBoardIcon);

		// Method 1:
		/*
		 * 1.Iterate row and coloumn and get the cell value 2.Using for loop 3.Get total
		 * rows and iterate table 4.Put if(string matches) then select the value
		 * 5.Lengthy method
		 */

		// table[@id='list']/tbody/tr[2]/td[3]
		// table[@id='list']/tbody/tr[3]/td[3]

		// this is for click icon
		// *[@id="resultTable"]/tbody/tr[3]/td[7]/a/img

		// I am splitting 2nd coloumn nothing but second td.

		String before_xpath = "//table[@id='list']/tbody/tr[";
		String after_xpath = "]/td[3]";

		for (int i = 1; i <= 10; i++) {
			log.info("*********** inside for loop ************");
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if (name.contains(tendererName)) {
				System.out.println("shrikanth kulal -->> " + name);
				try {
					driver.findElement(By.xpath("//table[@id='list']/tbody/tr[" + i + "]/td[9]/a[text()='Verify']"))
							.click();
					break;
				} catch (Exception e) {
					e.getMessage();
				} finally {

				}
			}
		}

		Assert.assertTrue(true);
		// verifyLink.click();
		remarks.sendKeys("ModeOfPayment is done");

		js1.scrollIntoView(verifyButton);
		js1.clickElement(verifyButton);

		alert.acceptAlert();

		// Verify emailIdtext label
		String tenderText = verifhelper.getText(textVerify1);
		System.out.println("emailIdtext is ---->> " + tenderText);
		AssertionHelper.verifyText(tenderText, "textVerify1", "text is verified");
	}

	/**
	 * Branch Maker login ---->> Perform operations
	 * 
	 * @throws InterruptedException
	 */
	public void createBranchMakerPayment_Tender_Security_Payemnt_LTM_EPW2B(String tendererName)
			throws InterruptedException {
		log.info("*********** inside createBranchMakerPayment ************");
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
			System.out.println("String TenderId with GSS --->>" + strngTenderId);
			tenderId.sendKeys(strngTenderId);
			js1.clickElement(searchButtonId);
			Thread.sleep(2000);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * js1.clickElement(searchButtonId); Thread.sleep(2000);
		 * js1.scrollIntoView(dashBoardIcon); js1.clickElement(dashBoardIcon);
		 */

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
				try {
					driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[7]/a/img")).click();
					break;
				} catch (Exception e) {
					e.getMessage();
				}
			}
		}

		System.out.println("size is --->>" + totalTabs1.size());

		for (int i = 0; i < totalTabs1.size(); i++) {
			WebElement element = totalTabs1.get(i);
			String text = totalTabs1.get(i).getText();
			System.out.println("tabs are ---->> " + text);

			if (text.equals("Tender/Proposal Security")) {
				element.click();
				break;
			}
		}

		Assert.assertTrue(true);
		// Click on Make Payment in Action tab
		paymentLinkText.click();

		// Enter e-mail id text and search
		emailIdText.sendKeys(tendererName);
		js1.clickElement(searchButton);
		makePaymentLinkText.click();

		// DropDownhelper used to select ModeOfPayment
		dropdwnhelper.selectUsingVisibleText(selectModeOfPayment, "Pay Order");
		TestUtil.sendKeys(driver, instrumentNo, 100, "test12345");
		TestUtil.sendKeys(driver, issuingBank, 100, "national bannk");
		TestUtil.sendKeys(driver, issuingBankBranch, 100, "gulshan1");

		js1.selectDateByJavaScript(issuenceDate, "22-08-2019");

		// Enter remarks
		remarks.sendKeys("ModeOfPayment is done");

		// click on Submit button
		// js.scrollToElementAndClick(clickSubmitButton);
		js1.scrollIntoView(clickSubmitButton);
		js1.clickElement(clickSubmitButton);
		waithelper.setImplicitWait(50, TimeUnit.SECONDS);

		// Verify emailIdtext label
		String tenderText = verifhelper.getText(textVerify);
		System.out.println("emailIdtext is ---->> " + tenderText);
		AssertionHelper.verifyText(tenderText, "Payment information entered successfully", "text is verified");

		waithelper.setImplicitWait(50, TimeUnit.SECONDS);
		// LogOut.click();
	}

	/**
	 * Consent for PEUSER
	 */
	public void createDevBudgetWorks_LTM_EPW2B_Method_PEUser() {
		log.info("***********inside createDevBudgetWorksWithOpenTendorMethod************");
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
				waithelper.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")), 500, 3);
				driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[8]/a/img")).click();
				break;
			}
		}

		TestUtil.clickOn(driver, peUserDevLink, 100);

		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments, 100, "testpackage");
		// Assert.assertTrue(false);
		js1.clickElement(submitbutton);

		String consentText = verifhelper.getText(consentText1);
		System.out.println("emailIdtext is ---->> " + consentText);
		AssertionHelper.verifyText(consentText, "Consent for Opening given successfully", "text is verified");

		// LogOut operation
		js1.clickElement(logOutButton);
	}

	/**
	 * Consent for HOPEUSER - getTenderRFQWorkPath
	 */
	public void createDevBudgetWorks_LTM_EPW2B_Method_HOPEUser() {
		log.info("*********** inside createDevBudgetWorksWithOpenTendorMethod ************");
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
			js1.clickElement(searchbutton);
			// waithelper.setImplicitWait(100, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[1]/td[8]/a/img")).click();
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
		}

		TestUtil.clickOn(driver, tecCptulinkTRAINING, 100);
		TestUtil.sendKeys(driver, password, 100, "egp12345");
		TestUtil.sendKeys(driver, comments, 100, "testpackage");
		js1.clickElement(submitbutton);

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
		
		js1.clickElement(megaMegaHashButton);

		waithelper.setImplicitWait(50, TimeUnit.SECONDS);
		// verify text
		String megaMegaHashButtonText1 = verifhelper.getText(megaMegaHashButtonText);
		System.out.println("emailIdtext is ---->> " + megaMegaHashButtonText1);
		AssertionHelper.verifyText(megaMegaHashButtonText1, "Mega Mega Hash verified successfully", "text is verified");

		// Click on Generate Report Template(TOR/TER) Link
		TestUtil.clickOn(driver, generateReportTempLink, 100);
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();

		// click on Decrypt All and generate report link
		TestUtil.clickOn(driver, decryptAllGenerateReport, 100);
		TestUtil.sendKeys(driver, password1, 50, "egp12345");

		js1.clickElement(verifyPasswordButton);
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();

		// Work with Tender/Proposal Opening Report : Click on TOR1
		TestUtil.clickOn(driver, TOR1LINK, 50);
		waithelper.setImplicitWait(50, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, HOPEUSERLINK, 50);

		// sending text
		TestUtil.sendKeys(driver, passwordText, 50, "egp12345");
		TestUtil.sendKeys(driver, comments, 50, "comments");
		js1.clickElement(submitbutton);

		js1.clickElement(goBacktoDashBoard);

		// click on TOR2
		TestUtil.clickOn(driver, TOR2LINK, 50);
		waithelper.setImplicitWait(50, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, tecCptuLINK1, 50);

		// Sending text
		TestUtil.sendKeys(driver, passwordText, 50, "egp12345");
		TestUtil.sendKeys(driver, comments, 50, "comments");
		js1.clickElement(submitbutton);

		js1.clickElement(goBacktoDashBoard);
		//js1.clickElement(logOutButton);
	}

	/**
	 * login as AOUSER perform
	 */
	public void createDevBudgetWorks_LTM_PEUser1() {
		log.info("***********inside createDevBudgetWorksWithOpenTendorMethod************");
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
			System.out.println("String TenderId with GSS --->>" + strngTenderId);
			// tenderpropId.sendKeys(strngTenderId);
			// TestUtil.clickOn(driver, resetbutton, 50);
			tenderpropId.sendKeys(strngTenderId);
		} catch (IOException e) {
			e.printStackTrace();
		}

		js1.clickElement(searchbutton);
		driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a/img")).click();

		// Work with Tender/Proposal Opening Report :
		// Click on TOR1
		TestUtil.clickOn(driver, TOR1LINK, 50);
		waithelper.setImplicitWait(50, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, PEUSERLINKTest, 50);

		// sending text
		TestUtil.sendKeys(driver, passwordText, 50, "egp12345");
		TestUtil.sendKeys(driver, comments, 50, "comments");

		js1.clickElement(submitbutton);

		js1.clickElement(goBacktoDashBoard);

		// Click on TOR2
		TestUtil.clickOn(driver, TOR2LINK, 50);
		waithelper.setImplicitWait(50, TimeUnit.SECONDS);
		TestUtil.clickOn(driver, MRPEUSERLINK12, 50);

		// Sending text
		TestUtil.sendKeys(driver, passwordText, 50, "egp12345");
		TestUtil.sendKeys(driver, comments, 50, "comments");
		js1.clickElement(submitbutton);

		js1.clickElement(goBacktoDashBoard);
		js1.clickElement(logOutButton);
	}

	/**
	 * Send to PE
	 */
	public void createDevBudgetWorks_LTM_EPW2B_Method_SendToPe() {
		log.info("***********inside createDevBudgetWorks_LTM_EPW2B_Method_SendToPe ************");
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
			System.out.println("String TenderId with GSS --->>" + strngTenderId);
			// tenderpropId.sendKeys(strngTenderId);
			// TestUtil.clickOn(driver, resetbutton, 50);
			tenderpropId.sendKeys(strngTenderId);
		} catch (IOException e) {
			e.printStackTrace();
		}

		js1.clickElement(searchbutton);
		driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[8]/a/img")).click();
		// close link
		// Login as Hope user ---- make separate function for below lines (701 - 720)
		//Tender/Proposal Opening Process :
		TestUtil.clickOn(driver, closeButton, 50);

		TestUtil.sendKeys(driver, comments1, 50, "tested successfully");

		js1.clickElement(submitButton1);

		TestUtil.clickOn(driver, sendtoPE, 100);

		Alert alert3 = driver.switchTo().alert();
		alert3.accept();

		TestUtil.sendKeys(driver, comments1, 1000, "tested successfully123");

		js1.clickElement(submitButton1);

		//Verify text
		String sendToPEText = verifhelper.getText(sendtoPETextEle);
		System.out.println("emailIdtext is ---->> " + sendToPEText);
		AssertionHelper.verifyText(sendToPEText, "Sent to PE successfully", "text is verified");
	}
}
