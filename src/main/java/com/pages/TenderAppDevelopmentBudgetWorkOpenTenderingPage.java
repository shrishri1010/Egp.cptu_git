package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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



public class TenderAppDevelopmentBudgetWorkOpenTenderingPage extends TestBase {
	int  convTendId;
	private Logger log = LoggerHelper.getLogger(TenderAppDevelopmentBudgetWorkOpenTenderingPage.class);
	
	DropDownHelper dropdown= new DropDownHelper(driver);
	JavaScriptHelper js1 = new JavaScriptHelper(driver);
	WaitHelper wait = new WaitHelper(driver);
	VerificationHelper verification = new VerificationHelper(driver);
	AlertHelper al = new AlertHelper(driver);
	FrameHelper frame = new FrameHelper(driver);
	WindowHelper helper = new WindowHelper(driver);
	
	@FindBy(id = "headTabApp")
	private WebElement AppLink;
	
	@FindBy(linkText = "My APP")
	private WebElement MyAppLink;
	
	@FindBy(id = "txtAppId")
	private WebElement SerchAPPID;
	
	@FindBy(xpath = "//input[@id='tenderId']")
	private WebElement tenderPropId;
	
	@FindBy(id = "cmbstatus")
	private WebElement 	Status;
	
	@FindBy(id = "btnSearchApp")
	private WebElement SerchAppIdBtn;
	
	@FindBy(xpath = "//*[@id=\"0\"]/td[6]/a")
	private WebElement  DashBordClick;
	
	@FindBy(linkText = "Create Tender/Proposal")
	private WebElement  ClickToCreateTender;
	
	@FindBy(id = "txtinvitationRefNo")
	private WebElement InvitationReferenceNoTextField ;
	
	@FindBy(id = "txttenderpublicationDate")
	private WebElement ProposalPublicationDateandTime;
	
	@FindBy(id = "txttenderLastSellDate")
	private WebElement ProposalDocumentlastsellingdownloadingDateandTime;
	
	@FindBy(id = "txtpreTenderMeetStartDate")
	private WebElement ProposalmeetingStartDateandTime;
	
	@FindBy(id = "txtpreTenderMeetEndDate")
	private WebElement ProposalmeetingEndDateandTime ;
	
	@FindBy(id = "txtpreQualCloseDate")
	private WebElement ProposalClosingDateandTime;
	
	@FindBy(id = "txtpreQualOpenDate")
	private WebElement ProposalOpeningDateandTime;
	
	@FindBy(id="txtlastDateTenderSub")
	private WebElement ProposalSecuritySubmission;
	
	@FindBy(xpath = "/html")
	private WebElement EligibilityofTendererTextBox;
	
	@FindBy(xpath = "/html")
	private WebElement BriefDescriptionofGoodsandRelatedService;
	
	@FindBy(id="txtpreQualDocPrice")
	private WebElement ProposalDocumentPrice;
	
	@FindBy(id = "locationlot_0")
	private WebElement Location;
	
	@FindBy(id="tenderSecurityAmount_0")
	private WebElement ProposalSecurityAmountInBDT;
	
	@FindBy(id = "startTimeLotNo_0")
	private WebElement StartDateEle; 
	
	@FindBy(id = "complTimeLotNo_0")
	private WebElement CompletionDateEle;
	
	@FindBy(id = "btnsubmit")
	private WebElement submitToRadiobtn;
	
	@FindBy(xpath = "//input[@id='btnSubmit']")
	private WebElement submitToRadiobtn1;
	
	@FindBy(id = "tenderDocument")
	private WebElement StandardTenderProposalDocument;
	
	@FindBy(id = "cmbDomesticPreference")
	private WebElement DomesticPreferenceRequires;
	
	@FindBy(id = "btnSubmit")
	private WebElement SubmitButon2TenderPraposal;
	
	@FindBy(id="txttenderValidity")
	private WebElement ProposalValidityInNoofDays ;
	
	@FindBy(xpath = "/html/body/div/div[2]/table[1]/tbody/tr[1]/td[2]")
	private WebElement TenderId;
	
	@FindBy(xpath = "//td[text()='Tender/Proposal ID :']/following-sibling::td[1]")
	private WebElement TenderIdText1;
	
	@FindBy(id="txttenderSecurityValidity")
	private WebElement ProposalSecurityValidityInNoofDays ;
	
	@FindBy(xpath="/html/body/div[3]/div[4]/table/tbody/tr[6]/td[2]/a")
	private WebElement AddOfficialCostEstimate ;
	
	@FindBy(id="taka_0")
	private WebElement OfficialCostEstimate ;
	
	@FindBy(xpath="/html/body/div[3]/div[4]/table/tbody/tr[5]/td[2]/a")
	private WebElement CommitteeMemberforEncryptionCreate;
	
	@FindBy(linkText="Go back to Tender/Proposal Dashboard")
	private WebElement GoToDashBoard ; 
	
	@FindBy(id="submit")
	private WebElement OfficialCostEstimateSubmit ;
	
	//@FindBy(xpath="//*[@id=\"offTabPanel\"]/li[2]/a")
	@FindBy(linkText="Document")
	private WebElement DocumentLink;
	
	@FindBy(xpath="/html/body/div/div[3]/div[4]/table[3]/tbody/tr[8]/td[2]/table[3]/tbody/tr[2]/td[3]/a[1]")
	private WebElement FormDashBordTenderSubmissionLetter;

	@FindBy(linkText="Fill up the Tables")
	private WebElement FillUpTheTables ;
	
	@FindBy(id="chk1")
	private WebElement CheckBoxCheck ;
	
	@FindBy(xpath="/html/body/div/div[3]/div[1]/span/a")
	private WebElement FormDashBord;
	
	@FindBy(xpath="/html/body/div/div[3]/div[4]/table[3]/tbody/tr[8]/td[2]/table[3]/tbody/tr[3]/td[3]/a[1]")
	private WebElement FormDashboardTechnicalSpecifications;
	
	@FindBy(xpath="/html/body/div/div[3]/div[1]/span/a")
	private WebElement TenderProposalDocument ;
	
	@FindBy(xpath="/html/body/div/div[3]/div[4]/table[3]/tbody/tr[8]/td[2]/table[5]/tbody/tr[2]/td[3]/a[1]")
	private WebElement FormDasbordPriceAndDeliveryScheduleforGood ;
	
	@FindBy(xpath="/html/body/div/div[3]/div[4]/table[3]/tbody/tr[8]/td[2]/table[5]/tbody/tr[3]/td[3]/a[1]")
	private WebElement PriceAndCompletionScheduleForRelatedServices ;
	
	@FindBy(id="Cell1_1")
	private WebElement ItemNo;
	
	@FindBy(id="Cell1_2")
	private WebElement ColumnHeader ;
	
	@FindBy(id="Cell1_3")
	private WebElement DescriptionofItem ;
	
	@FindBy(id="Cell1_4")
	private WebElement MeasurementUnit ;
	
	@FindBy(id="Cell1_5")
	private WebElement Quantity ;
	
	@FindBy(id="Cell1_6")
	private WebElement DeliveryPeriodindays ;
	
	@FindBy(linkText="Create")
	private WebElement createLink;
	
	@FindBy(linkText="Tender/Proposal Doc. Preparation")
	private WebElement ProposalDocPreparation ;
	
	//@FindBy(xpath="/html/body/div/div[3]/div[1]/span/a")
	//WebElement ProposalDocPreparation ;
	
	//@FindBy(linkText="Evaluation")
	//WebElement EvaluationLink ;
	
	@FindBy(xpath="//*[@id=\"offTabPanel\"]/li[3]")
	private WebElement EvaluationLink ;
	
	//@FindBy(linkText="Create")
	@FindBy(xpath="/html/body/div[3]/div[4]/table[2]/tbody/tr[1]/td[2]/a[1]")
	private WebElement EvaluationCommitteeCreate ;
	
	@FindBy(id="txtcommitteeName")
	private WebElement CommitteeName ;
	
	@FindBy(id="addmem")
	private WebElement AddMembers;
	
	@FindBy(id="chk1")
	private WebElement AOUserAsMember;
	
	@FindBy(id="chk5")
	private WebElement HopeUserAsMember;
	
	@FindBy(xpath="//*[@id='myPanelDiv']/div[3]/div/button[1]")
	private WebElement Addmembers;
	
	@FindBy(id="cmbMemRole0")
	private WebElement CommitteeRoleAOUser;
	// cp  chair 
	@FindBy(id="cmbMemRole1")
	private WebElement CommitteeRoleHopeUser ;
	// m    member value 
	
	@FindBy(linkText="Create")
	private WebElement CreateWorkFlow;
	
	@FindBy(xpath="//*[@id=\"offTabPanel\"]/li[4]/a")
	private WebElement OpeningLink;		
	
	@FindBy(xpath="/html/body/div/div[3]/table/tbody/tr[2]/td[3]")
	private WebElement UnnElee;
	
	@FindBy(xpath="/html/body/table/tbody/tr[4]/td[2]/p")
	private WebElement unassryeleemm;
	
	@FindBy(id="btnSubmit")
	private WebElement submitcommMem;
	
	@FindBy(xpath="//*[@id=\"members\"]/tbody/tr[2]/td[1]")
	private WebElement unnasrypageele;
	
	@FindBy(linkText="Notify Committee Members")
	private WebElement NotifyCommitteeMembers ;
	
	@FindBy(id="txtaRemarks")
	private WebElement txtRemarks;
	
	@FindBy(id="btnPublish")
	private WebElement NotifyBtn;
	
	@FindBy(linkText="Opening")
	private WebElement OpningLink;
	
	@FindBy(xpath="/html/body/div[3]/div[4]/table[2]/tbody/tr[2]/td[2]")
	private WebElement ponnnusgh;
	
	@FindBy(linkText="Notice")
	private WebElement NoticeLink;
	
	@FindBy(xpath="//*[@id=\"members\"]/tbody/tr[1]/td[1]/input")
	private WebElement memberHopeChckBx;
	
	@FindBy(xpath="//*[@id=\"members\"]/tbody/tr[2]/td[1]/input")
	private WebElement memberAoeChckBx;
	
	@FindBy(id="hdnsubmit")
	private WebElement Submtmmbr;
	
	@FindBy(xpath="/html/body/div[3]/div[4]/table/tbody/tr[5]/td[2]/a")
	private WebElement NoticeCreateMemmber;
	
	@FindBy(linkText="Configure")
	private WebElement ConfigureNoticeTab;
	
	@FindBy(id="claricomboid")
	private WebElement ClarificationTenderIsTobeallowed; 
	
	@FindBy(id="sublastdate")
	private WebElement submitConfm;
	
	@FindBy(xpath="/html/body/div[1]/div[3]/div[6]/div")
	private WebElement   opningdummy;
	
	@FindBy(xpath="/html/body/div[3]/div[4]/table/tbody/tr[4]/td[1]")
	private WebElement opniningfrted;
	
	@FindBy(id="sucolumnbBtnCreateEdit")
	private WebElement formSubmit;
	
	/*@FindBy(xpath="//table[3]/tbody/tr[9]/td[2]/table[6]/tbody/tr/td[2]/a[contains(text(),'Create')]")
	private WebElement GrandSummary;*/
	
	@FindBy(xpath="//a[text()='Create']")
	private WebElement GrandSummary;
	
	@FindBy(id="saveoredit")
	private WebElement GrandSummarySubmit;
	
	@FindBy(xpath="/html/body/div[3]/div[4]/table/tbody/tr[1]/td[2]/a[3]")
	private WebElement PublishTender;
	
	@FindBy(id="comments")
	private WebElement commentstToPublishTender;
	
	@FindBy(id="Publish")
	private WebElement PublishSubmitBtn;
	
	@FindBy(xpath="/html/body/div/div[3]/div[4]/table[3]/tbody/tr[9]/td[2]/table[5]/tbody/tr[2]/td[3]/a[2]")
	private WebElement BillOfQuantitiesDashbord;
	
	@FindBy(xpath="/html/body/div/div[3]/div[4]/table[3]/tbody/tr[9]/td[2]/table[5]/tbody/tr[3]/td[3]/a[2]")
	private WebElement ScheduleofDayworksDashBord;
	
	//@FindBy(xpath=" //a[contains(text(),’Create’)]")
	//@FindBy(linkText="Create")
	@FindBy(xpath="/html/body/div/div[3]/div[4]/table[3]/tbody/tr[9]/td[2]/table[6]/tbody/tr/td[2]/a")
	private WebElement GrandsummaryForWork;
	
	@FindBy(xpath="/html/body/div/div[3]/div[4]/table[3]/tbody/tr[9]/td[2]/table[6]/tbody/tr/td[1]")
	private WebElement unnesscreategrand;
	
	@FindBy(id="popup_ok")
	private WebElement CreateNewFormConfirmation;
	
	//@FindBy(xpath="/html/body/div[3]/div[4]/table[1]/tbody/tr[4]/td[2]/a")
	@FindBy(xpath="/html/body/div[3]/div[4]/table[1]/tbody/tr[4]/td[2]/a")
	private WebElement createnotice;
	
	@FindBy(xpath="/html/body/div[3]/div[4]/table[1]/tbody/tr[1]/td[2]/a[1]")
	private WebElement creatence;
	
	@FindBy(xpath="/html/body/div[3]/div[4]/div/span")
	private WebElement etervd;
	
	@FindBy(xpath="/html/body/div/div[3]/div[4]/table[3]/tbody/tr[5]/td[2]/table[6]/tbody/tr/td[2]/a")
	private WebElement FormPg1CreateGrandSumary;
	
	@FindBy(id="saveoredit")
	private WebElement FormPg1garandsmumarySave;
	
	@FindBy(linkText="Tender/Proposal Doc. Preparation")
	private WebElement TenderPraposalDocsPrep;
	
	@FindBy(id="totalValue_1")
	private WebElement unnssjoo;
	
	@FindBy(xpath="//*[@id=\"frmCreateTender\"]/div[2]")
	WebElement unnnskk;
	
	@FindBy(xpath = "/html")
	private WebElement EligibilityofTenderer;
	
	@FindBy(id = "cmbstatus")
	private WebElement Stat;
	
	@FindBy(id = "btnSearchApp")
	private WebElement SearchAPP;
	
	@FindBy(xpath = "//*[@id='0']/td[6]/a/img")
	private WebElement DashboardApp;
	
	@FindBy(linkText = "Create Tender/Proposal")
	private WebElement CreateTender;
	
	@FindBy(id = "txtinvitationRefNo")
	private WebElement InvitationReferenceNo;
	
	@FindBy(id = "txttenderpublicationDate")
	private WebElement OTMPublicationDateandTime;
	
	@FindBy(id = "txttenderLastSellDate")
	private WebElement TenderProposalDocumentlastsellingdownloadingDateandTime;
	
	@FindBy(id = "txtpreTenderMeetStartDate")
	private WebElement PreTenderProposalmeetingStartDateandTime;
	
	@FindBy(id = "txtpreTenderMeetEndDate")
	private WebElement PreTenderProposalmeetingEndDateandTime;
	
	@FindBy(id = "txtpreQualCloseDate")
	private WebElement ClosingDateandTime;
	
	@FindBy(xpath = "//*[@id=\"frmCreateTender\"]/table[3]/tbody/tr[6]/td[3]")
	private WebElement TenderProposalOpeningDateandTime1;
	
	@FindBy(id = "startTimeLotNo_0")
	private WebElement StartDate;
	
	@FindBy(id = "complTimeLotNo_0")
	private WebElement CompletionDate;
	
	@FindBy(xpath="//a[text()='Create a Tenderer's/Consultant's List']")
	private WebElement SelectTenderConsultant;
	
	@FindBy(xpath="/html/body/div[3]/table[2]/tbody/tr[2]/td[3]/a")
	private WebElement CreateTenderConsultantList;
	
	@FindBy(xpath="//select[@id='cmbComRegAddState']")
	private WebElement selectState;
	
	@FindBy(xpath="//input[@id='btnSearch']")
	private WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"ummap\"]/div/label/input")
	private WebElement AddToList;
	
	@FindBy(xpath="/html/body/div[3]/span/a")
	private WebElement GoToDashBord;
	
	@FindBy(xpath="//div[contains(text(),'File has processed and Tender Published successfully')]")
	public WebElement divMessage;
	
	@FindBy(xpath="//ul[@class='tabPanel_1 noprint']/li/a")
	List<WebElement> totalTabsSize;
	
	@FindBy(xpath="//ul[@class='tabPanel_1']/li/a")
	List<WebElement> totalTabsSize1;
	
	@FindBy(xpath="//a[text()='Edit']")
	public WebElement editLink;
	
	@FindBy(xpath="//td[text()='Configure Key Information ']/following-sibling::*/a[text()='Create']")
	public WebElement createKeyInformationLink;
	
	@FindBy(id="tenderDocument")
	public WebElement tenderProposalDocumnet;
	
	@FindBy(id = "txtTenderId")
	private WebElement tenderId;
	
	@FindBy(xpath="//ul[@class='tabPanel_1']/li")
	List<WebElement> totalTabs;
	
	@FindBy(xpath = "//table[@class='tableList_1 t_space']/tbody/tr/td[3]/a[text()='Payment']")
	private WebElement paymentLinkText;
	
	@FindBy(id = "txtEmailId")
	private WebElement emailIdText;
	
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
	
	@FindBy(xpath = "//input[@id='txtIssuanceDt']")
	private WebElement issuenceDate;
	
	@FindBy(id = "txtComments")
	private WebElement remarks;
	
	@FindBy(id = "btnSubmit")
	private WebElement clickSubmitButton;
	
	@FindBy(xpath = "//div[text()='Payment information entered successfully']")
	private WebElement textVerify;
	
	@FindBy(linkText = "Logout")
	private WebElement LogOut;
	
	@FindBy(id = "btnpaymentsearch")
	private WebElement searchButton1;
	
	@FindBy(xpath = "//textarea[@id='txtComments']")
	private WebElement remarks1;
	
	@FindBy(xpath = "//input[@id='btnVerify']")
	private WebElement verifyButton;
	
	@FindBy(xpath = "//div[text()='Payment verified successfully']")
	private WebElement updatedText;
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchButtonId;
	
	@FindBy(xpath = "//*[@id='resultTable']/tbody/tr/td[7]/a/img")
	private WebElement dashBoardIcon;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	public TenderAppDevelopmentBudgetWorkOpenTenderingPage() {
		PageFactory.initElements(driver, this);
	}
		
	/**
	 * Tender creation
	 * @throws Throwable
	 * author shrikanth kulal
	 */
	
	public void createTenderDevBudgetWorksWithOpenTendorMethod() throws Throwable {
		
		File src = new File(FileReaderManager.getInstance().getConfigReader().getAppOtmWorkPath());
		
		//To read the file ---->> FileInputStream
		FileInputStream fis = new FileInputStream(src);
		String strngAppId = IOUtils.toString(fis);
		System.out.println("Strng AppId with GSS --->>" + strngAppId);
		SerchAPPID.sendKeys(strngAppId);
		
		Select app = new Select(Status);
	    app.selectByValue("Approved");
	       
	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		/*Select Status = new Select(Stat);
		Status.selectByValue("Approved");*/
		
		//Thread.sleep(500);
			
		js.executeScript("arguments[0].click();", SearchAPP);
		js.executeScript("arguments[0].click();", DashboardApp);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(500);
		
		
		//Click on Create/Tender proposal link
		js.executeScript("arguments[0].click();", CreateTender);
		
		InvitationReferenceNo.sendKeys("Invitation Reference No 047141");	
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
	    
	    LocalDateTime now = LocalDateTime.now();
	    System.out.println("now it is --->> "+now);
	    
	    //plus 7 days -->> Pre - Tender/Proposal meeting Start Date and Time
	    LocalDateTime seven = now.plusDays(7);
	    System.out.println("seven it is --->> "+seven);
	    
	    //plus 3 minutes
		LocalDateTime one = now.plusMinutes(3); 
		System.out.println("one plus one --->> "+now);
		
		//plus one
		String PublicationDateandTime = dtf.format(one) ;
		selectDateByJs(driver,OTMPublicationDateandTime,PublicationDateandTime);
		
		//plus 20
		LocalDateTime twenty = now.plusDays(20); 
		String lastsellingdownloadingDateandTime = dtf.format(twenty);
		selectDateByJs(driver,TenderProposalDocumentlastsellingdownloadingDateandTime,lastsellingdownloadingDateandTime);
		
		//plus 7
		String meetingStartDateandTime = dtf.format(seven);
		selectDateByJs(driver,PreTenderProposalmeetingStartDateandTime,meetingStartDateandTime);
		
		//plus 10
		LocalDateTime ten = now.plusDays(10); 
		String meetingEndDateandTime = dtf.format(ten) ;
		selectDateByJs(driver,PreTenderProposalmeetingEndDateandTime,meetingEndDateandTime);
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,500)");
		
		//plus 40
		LocalDateTime fourty = now.plusDays(40); 
		String dateVal1 = dtf.format(fourty) ;
		selectDateByJs(driver,ClosingDateandTime,dateVal1);
		ClosingDateandTime.sendKeys(Keys.F5);
		//ProposalOpeningDateandTime
		
		//plus 35
		LocalDateTime thirtyfive = now.plusDays(35); 
		String dateVal2 = dtf.format(thirtyfive) ;
		selectDateByJs(driver,ProposalSecuritySubmission,dateVal2);
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//ClosingDateandTime.click();
		
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//js.executeScript("arguments[0].click();", TenderProposalOpeningDateandTime1);
		
		//***************Switch to frame(0)****************************************
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		EligibilityofTenderer.sendKeys("Eligibility of Tenderer/Consultant");
		driver.switchTo().defaultContent();
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,500)");
		
		//*****************Switch to frame(1)
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.switchTo().frame(1);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		EligibilityofTenderer.sendKeys("Brief Description of Goods and Related Service");
		driver.switchTo().defaultContent();
		
		//Enter Tender/Proposal Document Price
		ProposalDocumentPrice.sendKeys("4000");
		
		//Enter location
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Location.sendKeys("Dhaka");
		 
		//Enter Tender/proposal Security
		ProposalSecurityAmountInBDT.sendKeys("4000");
		
		//*****************Start Date
		LocalDateTime fifty = now.plusDays(50); 
		String StartDat = dtf.format(fifty) ;
		selectDateByJs(driver,StartDate,StartDat);
		
		//*****************Completion Date
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		LocalDateTime fiftyfive = now.plusDays(55); 
		String CompletionDat = dtf.format(fiftyfive) ;
		selectDateByJs(driver,CompletionDate,CompletionDat);
		
		//click on submit button
		js.executeScript("arguments[0].click();", submitToRadiobtn);
		
		//clickOn(driver,submitToRadiobtn,10);
		String strTenderId = TenderId.getText();
		System.out.println("tender id  is --->> "+strTenderId);
		
		//Convert string tenderId to double
		int convTendId=Integer.parseInt(strTenderId);
		System.out.println("convert string tenderId to double --->>"+convTendId);
		
		//Configure Official Cost Estimate, Approving Authority, STD Selection Page
		
		//Enter Tender/Proposal Validity in No. of Days :
		//TestUtil.sendKeys(driver, ProposalValidityInNoofDays, TestUtil.Time_Out, "16");
		
		ProposalValidityInNoofDays.sendKeys("16",Keys.TAB);
		js.executeScript("arguments[0].click();", submitToRadiobtn1);
		
		AlertHelper alert = new AlertHelper(driver);
		alert.acceptAlertIfPresent();
		
		//Save the tenderId
		File fnew=new File(FileReaderManager.getInstance().getConfigReader().getTenderOTMWorkPath());
		if (fnew.exists() && fnew.isFile()){
			fnew.delete();
		}
		System.out.println("File Creating...."+"\n");

		try {
		    System.out.println("Writing Content in file....."+"\n");
		    FileWriter f2 = new FileWriter(fnew, false);
		    f2.write(strTenderId);
		    System.out.println("Writing Content in File completed ....."+"\n");
		    f2.close();
		    System.out.println("File Closed Successfully"+"\n");
		} catch (IOException e) {
		    e.printStackTrace();
		}
				
		//Select slctntr = new Select(StandardTenderProposalDocument);
		//slctntr.selectByValue("40");
		
		//ProposalValidityInNoofDays.sendKeys("65"); 
		//js.executeScript("arguments[0].click();", SubmitButon2TenderPraposal);
		
		//Add official cost estimate
		AddOfficialCostEstimate.click();
		OfficialCostEstimate.sendKeys("5200650");
		js.executeScript("arguments[0].click();", OfficialCostEstimateSubmit);
		
		//Workflow Cart Page
		WorkFlowCrt wfcrt =	PageFactory.initElements(driver, WorkFlowCrt.class);
		
		try {
			wfcrt.DocumentLinkActivityForFormEPG1();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		//TenderProposalDocument.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,800)");
		
		clickOn(driver,GrandSummary,100);
		js.executeScript("arguments[0].click();", GrandSummarySubmit);
		TenderProposalDocument.click();
		
		//EvaluationLink testing
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		UnnElee.click();
		EvaluationLink.click();
		EvaluationCommitteeCreate.click();
		unassryeleemm.click();
		CommitteeName.sendKeys("Evl Comm");
		clickOn(driver,AddMembers,10);
		
		//Window Handling
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		String Parent_Window_2 = driver.getWindowHandle();  
		for (String handle : driver.getWindowHandles()) {
		     driver.switchTo().window(handle);
		}
				
		AOUserAsMember.click();
		HopeUserAsMember.click();
		clickOn(driver,Addmembers,10);
		driver.switchTo().window(Parent_Window_2);  
		driver.switchTo().defaultContent();
		System.out.println("Windows come to back");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,300)");
				
		Select slctAo = new Select(CommitteeRoleAOUser);
		slctAo.selectByValue("m");
			
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("arguments[0].click();", submitcommMem);
		wfcrt.CreateWorkFlowForNotice();
        NotifyCommitteeMembers.click();
		js.executeScript("window.scrollBy(0,300)");
		txtRemarks.sendKeys("Remarks");
		clickOn(driver,NotifyBtn,10);
		ponnnusgh.click();
		OpeningLink.click();
		wfcrt.OpningCommitteeCreate();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        wfcrt.CreateWorkFlowForNotice();
		NotifyCommitteeMembers.click();
		js.executeScript("window.scrollBy(0,300)");
		txtRemarks.sendKeys("Remarks");
		clickOn(driver,NotifyBtn,10);
		
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
		/*SelectTenderConsultant.click();
		CreateTenderConsultantList.click();
		js.executeScript("window.scrollBy(0,1500)");
		clickOn(driver,AddToList,10);
		GoToDashBord.click();*/
		
		wfcrt.CreateWorkFlowForNotice();
		log.info("*****Start SelectTenderConsultant **************");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
        ConfigureNoticeTab.click();
			
		Select slctconfr0 = new Select(ClarificationTenderIsTobeallowed);
		slctconfr0.selectByValue("No");
		clickOn(driver,submitConfm,10);
		
		PublishTender.click();
		js.executeScript("window.scrollBy(0,1000)");
		commentstToPublishTender.sendKeys("Tender ");
		
		WaitHelper wh = new WaitHelper(driver);
		
		try {
			log.info("************** inside try block ************************");
			js.executeScript("arguments[0].click();", PublishSubmitBtn);
			//wh.pageLoadTimeOut(15000, TimeUnit.SECONDS);
			Thread.sleep(15000);
			//driver.navigate().to("https://www.training.eprocure.gov.bd/Index.jsp");
			
			//WebElement ele = wh.waitForElement(divMessage, 500, 5);
			//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			//Thread.sleep(1000);
			//wh.WaitForElementVisibleWithPollingTime(divMessage, 250, 5);
			//driver.navigate().refresh();
			//wh.setImplicitWait(10000, TimeUnit.SECONDS);
		} catch (Exception e) {
			log.info("************** inside catch block************************");
			e.printStackTrace();
		}finally {
			System.out.println("shrikanth kulal inside finally block");
			//driver.navigate().to("https://www.training.eprocure.gov.bd/Index.jsp+strTenderId");
			//https://www.training.eprocure.gov.bd/officer/Notice.jsp?tenderid=41996&msgPublish=msgPublish
			try{
				log.info("************** inside try block************************");
				//loading url below one
				driver.navigate().to("https://www.training.eprocure.gov.bd/officer/TenderPdfGenerate.jsp?tenderid="+convTendId+"");
				//wh.pageLoadTimeOut(10000, TimeUnit.SECONDS);
				Thread.sleep(500);
				
				//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				//////********************************
				//WebElement waitElement = driver.findElement(By.xpath("//img[@src='/resources/images/Dashboard/ajax-loader.gif']"));
				 
				//waitElement = wh.waitForElement(driver.findElement(By.xpath("//img[@src='/resources/images/Dashboard/ajax-loader.gif']")), 250, 10);
				//checking if loading indicator was found and if so we wait for it to
				//disappear
				/*if (waitElement != null) {
					System.out.println("shrikanth kulal is not equal to null");
				    WebDriverWait wait = new WebDriverWait(driver, 100);
				    boolean status=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@src='/resources/images/Dashboard/ajax-loader.gif']")));
				    System.out.println("status is ---->>> " +status);
				}*/
			}catch (Exception e) {
				log.info("************** finally --->> inside catch block************************");
				e.printStackTrace();
			}
			finally {
				//driver.navigate().to("https://www.training.eprocure.gov.bd/officer/Notice.jsp?tenderid="+convTendId+"&msgPublish=msgPublish");
			}
			/////******************
			//driver.navigate().to("https://www.training.eprocure.gov.bd/officer/Notice.jsp?tenderid=convTendId&msgPublish=msgPublish");
			//driver.navigate().to("https://www.training.eprocure.gov.bd/officer/Notice.jsp?tenderid=convTendId&msgPublish=msgPublish");
		}
		
		//PublishSubmitBtn.click();
		//driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//Thread.sleep(10000);
		/*driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(500);
		driver.navigate().refresh();*/
	}
	
	/**
	 * Tender creation - createTender-DevBudget-Works-With-RequestForQuotation
	 * @throws Throwable
	 * author shrikanth kulal
	 */
	public void createTenderDevBudgetWorksWithRequestForQuotation() throws Throwable {
		
		File src = new File("E:\\Users\\shrikanth\\Downloads\\TenderID\\TenderID_RFQU_Works.txt");
		
		//To read the file --- FileInputStream
		FileInputStream fis = new FileInputStream(src);
		String strngTenderId = IOUtils.toString(fis);
		System.out.println("Strng tenderId with GSS --->>" + strngTenderId);
		tenderPropId.sendKeys(strngTenderId);
		
		//Method 1:
		/*1.Iterate row and coloumn and get the cell value
		2.Using for loop
		3.Get total rows and iterate table
		4.Put if(string matches) then select the value
		5.Lengthy method*/
		
		//*[@id="resultTable"]/tbody/tr[1]/td[2]
		//*[@id="resultTable"]/tbody/tr[2]/td[2]
		
		//*[@id="resultTable"]/tbody/tr[10]/td[2]
		
		//this is for click icon
		//*[@id="resultTable"]/tbody/tr[3]/td[7]/a/img
		
		//I am splitting 2nd coloumn nothing but second td.
		String before_xpath="//*[@id='resultTable']/tbody/tr[";
		String after_xpath="]/td[2]";
		
		for (int i=1; i<=10; i++) {
			log.info("*********** inside for loop ************");
			String tenderId=driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
			System.out.println("tenderId is ---->> "+tenderId);
			if (tenderId.contains("45800")) {
				//System.out.println("shrikanth kulal -->> "+name);
				driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td[7]/a/img")).click();
				break;
			}
		}
	    
	    for (int i = 0; i < totalTabsSize.size(); i++) {
			WebElement element = totalTabsSize.get(i);
			String text = totalTabsSize.get(i).getText();
			log.info("tabs are ---->> "+text);
			
			if (text.equals("Notice")) {
				element.click();
				break;
			}
	    }
	    Assert.assertTrue(true);
	    
	    TestUtil.clickOn(driver, editLink, 100);
	    
	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		InvitationReferenceNo.sendKeys("Invitation Reference No 9900486878");
		Assert.assertTrue(true);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
	    
	    LocalDateTime now = LocalDateTime.now();
	    System.out.println("now it is --->> "+now);
	    
	    //plus 7 days -->> Pre - Tender/Proposal meeting Start Date and Time
	    LocalDateTime seven = now.plusDays(7);
	    System.out.println("seven it is --->> "+seven);
	    
	    //plus 3 minutes
		LocalDateTime one = now.plusMinutes(3); 
		System.out.println("one plus one --->> "+now);
		
		//plus one
		String PublicationDateandTime = dtf.format(one) ;
		selectDateByJs(driver,OTMPublicationDateandTime,PublicationDateandTime);
		
		//plus 20
		LocalDateTime twenty = now.plusDays(20); 
		String lastsellingdownloadingDateandTime = dtf.format(twenty);
		selectDateByJs(driver,TenderProposalDocumentlastsellingdownloadingDateandTime,lastsellingdownloadingDateandTime);
		
		//plus 7
		String meetingStartDateandTime = dtf.format(seven);
		selectDateByJs(driver,PreTenderProposalmeetingStartDateandTime,meetingStartDateandTime);
		
		//plus 10
		LocalDateTime ten = now.plusDays(10); 
		String meetingEndDateandTime = dtf.format(ten) ;
		selectDateByJs(driver,PreTenderProposalmeetingEndDateandTime,meetingEndDateandTime);
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,500)");
		
		//plus 40
		LocalDateTime fourty = now.plusDays(40); 
		String dateVal1 = dtf.format(fourty) ;
		selectDateByJs(driver,ClosingDateandTime,dateVal1);
		ClosingDateandTime.sendKeys(Keys.F5);
		//ProposalOpeningDateandTime
		
		//plus 35
		LocalDateTime thirtyfive = now.plusDays(35); 
		String dateVal2 = dtf.format(thirtyfive) ;
		selectDateByJs(driver,ProposalSecuritySubmission,dateVal2);
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//ClosingDateandTime.click();
		
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//js.executeScript("arguments[0].click();", TenderProposalOpeningDateandTime1);
		
		//***************Switch to frame(0)****************************************
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		EligibilityofTenderer.sendKeys("Eligibility of Tenderer/Consultant");
		driver.switchTo().defaultContent();
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,500)");
		
		//***************** Switch to frame(1)
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.switchTo().frame(1);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		EligibilityofTenderer.sendKeys("Brief Description of Goods and Related Service");
		driver.switchTo().defaultContent();
		
		//Enter Tender/Proposal Document Price
		//ProposalDocumentPrice.sendKeys("4000");
		
		//Enter location
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Location.sendKeys("Dhaka");
		 
		//Enter Tender/proposal Security
		ProposalSecurityAmountInBDT.sendKeys("4000");
		
		//*****************Start Date
		LocalDateTime fifty = now.plusDays(50); 
		String StartDat = dtf.format(fifty) ;
		selectDateByJs(driver,StartDate,StartDat);
		
		//*****************Completion Date
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		LocalDateTime fiftyfive = now.plusDays(55); 
		String CompletionDat = dtf.format(fiftyfive) ;
		selectDateByJs(driver,CompletionDate,CompletionDat);
		
		//click on submit button
		js.executeScript("arguments[0].click();", submitToRadiobtn);
		//clickOn(driver,submitToRadiobtn,10);
	}
	
	/**
	 * Working on _Configure_key_Information
	 */
	
	public void createTenderDevBudgetWorksWithRequestForQuotation_Configure_key_Information() {
		//Click on Dashboard
		//I am splitting 2nd coloumn nothing but second td.
		String before_xpath="//*[@id='resultTable']/tbody/tr[";
		String after_xpath="]/td[2]";
		
		for (int i=1; i<=10; i++) {
			log.info("***********inside for loop************");
			String name=driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
			System.out.println(name);
			if (name.contains("45800")) {
				//System.out.println("shrikanth kulal -->> "+name);
				driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td[7]/a/img")).click();
				break;
			}
		}
	    
	    for (int i = 0; i < totalTabsSize.size(); i++) {
			WebElement element = totalTabsSize.get(i);
			String text = totalTabsSize.get(i).getText();
			log.info("tabs are ---->> "+text);
			
			if (text.equals("Notice")) {
				element.click();
				break;
			}
	    }
	    
		String strTenderId	= TenderIdText1.getText();
		System.out.println("tender id  is --->> "+strTenderId);
		
		//Convert string tenderId to double
		convTendId=Integer.parseInt(strTenderId);
		System.out.println("convert string tenderId to double --->>"+convTendId);
		
		
		TestUtil.clickOn(driver, createKeyInformationLink, 100);
		
		//Select Standard Tender/Proposal Document 
		dropdown.selectUsingVisibleText(tenderProposalDocumnet, "e-PW1(a)");
		
		
		//Configure Official Cost Estimate, Approving Authority, STD Selection Page
		//Enter Tender/Proposal Validity in No. of Days :
		//TestUtil.sendKeys(driver, ProposalValidityInNoofDays, TestUtil.Time_Out, "16");
		
		ProposalValidityInNoofDays.sendKeys("16",Keys.TAB);
		
		js.executeScript("arguments[0].click();", submitToRadiobtn1);
	}
	
	
	public void createTenderDevBudgetWorksWithRequestForQuotation_Clarification_Tender_Proposal_configure() {	
		//I am splitting 2nd coloumn nothing but second td.
		String before_xpath="//*[@id='resultTable']/tbody/tr[";
		String after_xpath="]/td[7]";
		
		String xpath1="//*[@id='resultTable']/tbody/tr[";
		String xpath2="]/td[2]";
		
		for (int i=1; i<=10; i++) {
			log.info("*********** inside for loop ************");
			String tenderId=driver.findElement(By.xpath(xpath1+i+xpath2)).getText();
			System.out.println(tenderId);
			if (tenderId.contains("45800")) {
				//System.out.println("shrikanth kulal -->> "+name);
				driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td[7]/a/img")).click();
				break;
			}
		}
		
	    for (int i = 0; i < totalTabsSize.size(); i++) {
			WebElement element = totalTabsSize.get(i);
			String text = totalTabsSize.get(i).getText();
			log.info("tabs are ---->> "+text);
			
			if (text.equals("Notice")) {
				element.click();
				break;
			}
	    }
	   
	    String strTenderId = TenderIdText1.getText();
		System.out.println("tender id  is --->> "+strTenderId);
		
		//Save the tenderId
		File fnew=new File(FileReaderManager.getInstance().getConfigReader().getTenderOTMWorkPath());
		
		/**To read the file**/
		/*FileInputStream fis = null;
		try {
			fis = new FileInputStream(fnew);
			System.out.println("source file is " +fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		
		//Assert.assertTrue(false);
		
		if (fnew.exists() && fnew.isFile()){
			fnew.delete();
		}
		System.out.println("File Creating...."+"\n");

		try {
		    System.out.println("Writing Content in file....."+"\n");
		    FileWriter f2 = new FileWriter(fnew, false);
		    f2.write(strTenderId);
		    System.out.println("Writing Content in File completed ....."+"\n");
		    f2.close();
		    System.out.println("File Closed Successfully"+"\n");
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	    //Assert.assertTrue(false);
		AddOfficialCostEstimate.click();
		OfficialCostEstimate.sendKeys("5200650");
		js.executeScript("arguments[0].click();", OfficialCostEstimateSubmit);
		
		//Workflow Cart Page
		WorkFlowCrt wfcrt =	PageFactory.initElements(driver, WorkFlowCrt.class);
		
		try {
			wfcrt.DocumentLinkActivityForFormEPG1();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		//TenderProposalDocument.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,800)");
		
		clickOn(driver,GrandSummary,100);
		js.executeScript("arguments[0].click();", GrandSummarySubmit);
		TenderProposalDocument.click();
		
		//EvaluationLink testing
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		UnnElee.click();
		EvaluationLink.click();
		EvaluationCommitteeCreate.click();
		unassryeleemm.click();
		CommitteeName.sendKeys("Evl Comm");
		clickOn(driver,AddMembers,10);
		
		//Window Handling
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		String Parent_Window_2 = driver.getWindowHandle();  
		for (String handle : driver.getWindowHandles()) {
		     driver.switchTo().window(handle);
		}
				
		AOUserAsMember.click();
		HopeUserAsMember.click();
		clickOn(driver,Addmembers,10);
		driver.switchTo().window(Parent_Window_2);  
		driver.switchTo().defaultContent();
		System.out.println("Windows come to back");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,300)");
				
		Select slctAo = new Select(CommitteeRoleAOUser);
		slctAo.selectByValue("m");
			
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("arguments[0].click();", submitcommMem);
		try {
			wfcrt.CreateWorkFlowForNotice();
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        NotifyCommitteeMembers.click();
		js.executeScript("window.scrollBy(0,300)");
		txtRemarks.sendKeys("Remarks");
		clickOn(driver,NotifyBtn,10);
		ponnnusgh.click();
		OpeningLink.click();
		try {
			wfcrt.OpningCommitteeCreate();
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        try {
			wfcrt.CreateWorkFlowForNotice();
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		NotifyCommitteeMembers.click();
		js.executeScript("window.scrollBy(0,300)");
		txtRemarks.sendKeys("Remarks");
		clickOn(driver,NotifyBtn,10);
		
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
		SelectTenderConsultant.click();
		CreateTenderConsultantList.click();
		dropdown.selectUsingVisibleText(selectState, "Dhaka");
		js1.scrollIntoView(searchButton);
		js1.clickElement(searchButton);
		js.executeScript("window.scrollBy(0,1500)");
		clickOn(driver,AddToList,10);
		GoToDashBord.click();
		
		try {
			wfcrt.CreateWorkFlowForNotice();
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		log.info("***** Start SelectTenderConsultant ******");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
        ConfigureNoticeTab.click();
			
		Select slctconfr0 = new Select(ClarificationTenderIsTobeallowed);
		slctconfr0.selectByValue("No");
		clickOn(driver,submitConfm,10);
		
		PublishTender.click();
		js.executeScript("window.scrollBy(0,1000)");
		commentstToPublishTender.sendKeys("Tender ");
		
		WaitHelper wh = new WaitHelper(driver);
		
		try {
			log.info("************** inside try block *********************");
			js.executeScript("arguments[0].click();", PublishSubmitBtn);
			//wh.pageLoadTimeOut(15000, TimeUnit.SECONDS);
			Thread.sleep(15000);
			//driver.navigate().to("https://www.training.eprocure.gov.bd/Index.jsp");
			
			//WebElement ele = wh.waitForElement(divMessage, 500, 5);
			//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			//Thread.sleep(1000);
			//wh.WaitForElementVisibleWithPollingTime(divMessage, 250, 5);
			//driver.navigate().refresh();
			//wh.setImplicitWait(10000, TimeUnit.SECONDS);
		} catch (Exception e) {
			log.info("************** inside catch block************************");
			e.printStackTrace();
		}finally {
			System.out.println("shrikanth kulal inside finally block");
			//driver.navigate().to("https://www.training.eprocure.gov.bd/Index.jsp+strTenderId");
			//https://www.training.eprocure.gov.bd/officer/Notice.jsp?tenderid=41996&msgPublish=msgPublish
			try{
				log.info("************** inside try block************************");
				//loading url below one
				driver.navigate().to("https://www.training.eprocure.gov.bd/officer/TenderPdfGenerate.jsp?tenderid="+convTendId+"");
				//wh.pageLoadTimeOut(10000, TimeUnit.SECONDS);
				Thread.sleep(500);
				
				//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				//////********************************
				//WebElement waitElement = driver.findElement(By.xpath("//img[@src='/resources/images/Dashboard/ajax-loader.gif']"));
				 
				//waitElement = wh.waitForElement(driver.findElement(By.xpath("//img[@src='/resources/images/Dashboard/ajax-loader.gif']")), 250, 10);
				//checking if loading indicator was found and if so we wait for it to
				//disappear
				/*if (waitElement != null) {
					System.out.println("shrikanth kulal is not equal to null");
				    WebDriverWait wait = new WebDriverWait(driver, 100);
				    boolean status=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@src='/resources/images/Dashboard/ajax-loader.gif']")));
				    System.out.println("status is ---->>> " +status);
				}*/
			}catch (Exception e) {
				log.info("************** finally --->> inside catch block************************");
				e.printStackTrace();
			}
			finally {
				//driver.navigate().to("https://www.training.eprocure.gov.bd/officer/Notice.jsp?tenderid="+convTendId+"&msgPublish=msgPublish");
			}
			/////******************
			//driver.navigate().to("https://www.training.eprocure.gov.bd/officer/Notice.jsp?tenderid=convTendId&msgPublish=msgPublish");
			//driver.navigate().to("https://www.training.eprocure.gov.bd/officer/Notice.jsp?tenderid=convTendId&msgPublish=msgPublish");
		}
		
		//PublishSubmitBtn.click();
		//driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//Thread.sleep(10000);
		/*driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(500);
		driver.navigate().refresh();*/
	}
	
	
	
	/**
	 * Branch maker login ---->> Perform operations
	 */
	public void createBranchMakerPayment()  {
		log.info("*********** inside createBranchMakerPayment ************");
		File src = new File("E:\\Users\\shrikanth\\Downloads\\TenderID\\TenderID_RFQU_Works.txt");
		
		//To read the file --- FileInputStream
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String strngTenderId=null;
		try {
			strngTenderId = IOUtils.toString(fis);
			System.out.println("String TenderId with GSS --->>" + strngTenderId);
			tenderId.sendKeys(strngTenderId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		js1.clickElement(searchButtonId);
		js1.scrollIntoView(dashBoardIcon);
		js1.clickElement(dashBoardIcon);
		
		
		//Method 1:
		/*1.Iterate row and coloumn and get the cell value
		2.Using for loop
		3.Get total rows and iterate table
		4.Put if(string matches) then select the value
		5.Lengthy method*/
		
		//*[@id="resultTable"]/tbody/tr[1]/td[2]
		//*[@id="resultTable"]/tbody/tr[2]/td[2]
		
		//*[@id="resultTable"]/tbody/tr[10]/td[2]
		
		//this is for click icon
		//*[@id="resultTable"]/tbody/tr[3]/td[7]/a/img
		
		//I am splitting 2nd coloumn nothing but second td.
		/*String before_xpath="//*[@id='resultTable']/tbody/tr[";
		String after_xpath="]/td[2]";
		
		for (int i=1; i<=10; i++) {
			log.info("***********inside for loop************");
			String name=driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
			System.out.println(name);
			if (name.contains(strngTenderId)) {
				System.out.println("shrikanth kulal -->> "+name);
				try {
					driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td[7]/a/img")).click();
					break;
				} catch (Exception e) {
					e.getMessage();
				}finally {
					driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td[7]/a/img")).click();
					//break;
				}
				
			}
		}*/
		
		
		//Verify close date and time
		/*String closeDateTime = verification.getText(closingDateTime);
		System.out.println("date is ---->> "+closeDateTime);
		AssertionHelper.verifyText(closeDateTime, "29-Dec-2018 09:57", "text is verified");*/
		
		//List<WebElement> data = driver.findElements(By.xpath("//ul[@class='tabPanel_1']/li"));	
		System.out.println("size is --->>"+totalTabs.size());
		 
		for (int i = 0; i < totalTabs.size(); i++) {
			WebElement element = totalTabs.get(i);
			String text = totalTabs.get(i).getText();
			System.out.println("tabs are ---->> "+text);
			
			if (text.equals("Tender/Proposal Security")) {
				element.click();
				break;
			}
		}
		
		//Click on Make Payment in Action tab
		paymentLinkText.click();
		
		//Enter e-mail id text and search
		emailIdText.sendKeys("egptenderer1@gmail.com");
		js1.clickElement(searchButton);
		
		makePaymentLinkText.click();
		
		//DropDownhelper used to select ModeOfPayment
		dropdown.selectUsingVisibleText(selectModeOfPayment, "Pay Order");
		TestUtil.sendKeys(driver, instrumentNo, 100, "test12345");
		TestUtil.sendKeys(driver, issuingBank, 100, "national bannk");
		TestUtil.sendKeys(driver, issuingBankBranch, 100, "gulshan1");
		
		js1.selectDateByJavaScript(issuenceDate, "06-03-2019");
		//Enter remarks
		remarks.sendKeys("ModeOfPayment is done");
		
		Assert.assertTrue(false);
		//click on Submit button
		//js.scrollToElementAndClick(clickSubmitButton);
		
		js1.scrollIntoView(clickSubmitButton);
		js1.clickElement(clickSubmitButton);
		
		wait.setImplicitWait(50, TimeUnit.SECONDS);
				 
		//Verify emailIdtext label
		String tenderText = verification.getText(textVerify);
		System.out.println("emailIdtext is ---->> "+tenderText);
		AssertionHelper.verifyText(tenderText, "Payment information entered successfully", "text is verified");
		
		wait.setImplicitWait(50, TimeUnit.SECONDS);
		LogOut.click();
	}
	
	
	/**
	 * Branch Maker login - perform operations
	 */
	public void createBranchCheckerPayment() {
		// *********************BranchMaker login TenderSecurityPending
		log.info("**** inside createBranchCheckerPayment method **********");
		File src = new File("E:\\Users\\shrikanth\\Downloads\\TenderID\\TenderID_RFQU_Works.txt");
		
		//To read the file ---->> FileInputStream
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String strngTenderId=null;
		try {
			strngTenderId = IOUtils.toString(fis);
			System.out.println("String TenderId with GSS --->>" + strngTenderId);
			tenderId.sendKeys(strngTenderId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//js1.clickElement(searchButton1);
		
		//Method 1:
		/*1.Iterate row and coloumn and get the cell value
		2.Using for loop
		3.Get total rows and iterate table
		4.Put if(string matches) then select the value
		5.Lengthy method*/
		
		//table[@id="list"]/tbody/tr[3]/td[2]
		//*[@id="resultTable"]/tbody/tr[2]/td[2]
		//.......
		//*[@id="resultTable"]/tbody/tr[10]/td[2]
		
		//this is for click icon
		//*[@id="resultTable"]/tbody/tr[3]/td[7]/a/img*/		
		
		//I am splitting 2nd coloumn nothing but second td.
		//*[@id="resultTable"]/tbody/tr[
		//]/td[2]
		
		String before_xpath="//table[@id='list']/tbody/tr[";
		String after_xpath="]/td[2]";
		
		for (int k=2; k<=10; k++) {
			log.info("*********** inside for loop************");
			
			try {
				String name=driver.findElement(By.xpath(before_xpath+k+after_xpath)).getText();
				System.out.println(name);
				if (name.contains(strngTenderId)) {
					System.out.println("shrikanth kulal -->> "+name);
					driver.findElement(By.xpath("//table[@id='list']/tbody/tr["+k+"]/td[9]/a[text()='Verify']")).click();
					break;
				}
			} catch (Exception e) {
				e.getMessage();
			}/*finally {
				driver.findElement(By.xpath("//table[@id='list']/tbody/tr["+k+"]/td[9]/a[text()='Verify']")).click();
				//continue;//table[@id='list']/tbody/tr["+k+"]/td[9]/a[text()='Verify']
			}*/
		}
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		TestUtil.sendKeys(driver, remarks1, 100, "verified success");
		js1.clickElement(verifyButton);
		
		//handle Alert
		al.acceptAlert();
		
		//Verify text
		String updatedText1 = verification.getText(updatedText);
		System.out.println("date is ---->> "+updatedText1);
		AssertionHelper.verifyText(updatedText1, "Payment verified successfully", "text is verified");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		LogOut.click();
	}
	
}
