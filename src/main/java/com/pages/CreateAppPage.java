package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
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

import com.egp.qa.base.TestBase;
import com.egp.qa.configfilereader.FileReaderManager;

import com.egp.qa.helper.assertion.AssertionHelper;
import com.egp.qa.helper.assertion.VerificationHelper;
import com.egp.qa.helper.calender.CalenderHelper;
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

public class CreateAppPage extends TestBase {
	CreateAppPage crt;
	TestUtil testUtil= new TestUtil();
	private Logger log = LoggerHelper.getLogger(CreateAppPage.class);
	DropDownHelper dropdwnhelper = new DropDownHelper(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	VerificationHelper verifhelper = new VerificationHelper(driver);
	JavaScriptHelper jse = new JavaScriptHelper(driver); 
	WindowHelper windowhelper = new WindowHelper(driver);
	CalenderHelper calhelper = new CalenderHelper(driver);
	WorkFlowCrt wrkflow = new WorkFlowCrt();
	
	
	@FindBy(id = "cmbBudgetType")
	private WebElement BudgetType;
	
	@FindBy(id = "cmbFinancialYear")
	private WebElement FinancialYear;
	
	@FindBy(id = "cmbProject")
	private WebElement SelectProject;
	
	@FindBy(id = "txtAppCode")
	private WebElement APPCode;
	
	@FindBy(id = "buttonNext")
	private WebElement NextButton;
	
	@FindBy(xpath="//*[@id='frmAddPackageDetail']/table/tbody/tr[4]/td[2]")
	private WebElement BudgetTypetext;
	
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
	
	@FindBy(xpath = "//a[@id='hrefCPV']")
	private WebElement SelectCategory;
	
	@FindBy(xpath = "//input[@id='keyword']")
	private WebElement searchKeyword;
	
	@FindBy(xpath = "//input[@name='srchbutton']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//li[@id='5815']/a/ins[1]")
	private WebElement constructionworkcheckbox;
	
	@FindBy(className = "jstree-checkbox")
	private WebElement CpvCatAgri;
	
	@FindBy(id = "btnGetCheckedNode")
	private WebElement SubmitCpvCategory;
	
	@FindBy(id = "cmbAuthority")
	private WebElement ApprovingAuthority;
	
	@FindBy(id = "cmbProcureType")
	private WebElement ProcurementType ;
	
	@FindBy(id = "cmbProcureMethod")
	private WebElement ProcurementMethod;
	
	@FindBy(id = "btnNext")
	private WebElement NextButton2;
	
	@FindBy(id = "txtRfqdtadvtift")
	private WebElement ExpectedDateOfAdvertisementOfIFTon;
	
	@FindBy(id = "txtRfqdtadvtiftNo")
	private WebElement NoOfDaysExpectedLastDateofSubmissionofTenders;
	
	//////////////////
	@FindBy(id = "txtRfqexpdtopen")
	private WebElement NoOfDaysExpectedLastDateofSubmissionofTendersAAA;
	
	@FindBy(id = "txtRfqdtsubNo")
	private WebElement  NoOfDaysExpectedDateofOpeningofTenders;
	
	@FindBy(id = "txtRfqexpdtopenNo")
	private WebElement  NoOfDaysExpectedDateofSubmissionofEvaluationReport;
	
	@FindBy(id = "txtRfqdtsubevaRptNo")
	private WebElement  NoOfDaysExpectedDateofApprovalforAwardofContract;
	
	@FindBy(id = "txtRfqexpdtAppawdNo")
	private WebElement  NoOfDaysExpectedDateofIssuanceoftheNOA;
	
	@FindBy(id = "txtRfqdtIssNOANo")
	private WebElement  NoOfDaysExpectedDateofSigningofContract;
	
	@FindBy(id = "txtRfqexpdtSignNo")
	private WebElement  NoOfDaysExpectedDateofCompletionofContract;
	
	@FindBy(id = "btnSave")
	private WebElement Save;
	
	@FindBy(linkText = "Create")
	private WebElement Create;
	
	@FindBy(id = "textfield1")
	private WebElement NoofReviewers;
	
	@FindBy(id = "button")
	private WebElement  Submit;
	
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
	
	@FindBy(id = "tbnAdd")
	private WebElement WorkflowSubmit ;
	
	@FindBy(xpath = "/html/body/div/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/a")
	private WebElement LogOut;
	
	@FindBy(id = "btnsubmit")
	private WebElement NoofReviewersWorkFlow;

	@FindBy(id = "btnsubmit")
	private WebElement NoofDaysforFileEscalation;
	
	@FindBy(id="txtEmailId") 
	private WebElement username;
	
	@FindBy(id="txtPassword")
	private WebElement password;
	
	@FindBy(id="btnLogin")
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

	//For Works
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
		
	//For Service
	@FindBy(id = "cmbServiceType")
	private WebElement ServiceType;

	@FindBy(id = "cmbRFARequires")
	private WebElement REOIRFARFPRequires;

	//For Service REOI
	@FindBy(id = "txtREOQexpdtadvtREOI")
	private WebElement ExpectedDateofAdvertisementofREOI ;

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
	private WebElement ExpectedDateofSubmissionofCombinedEvaluationReport ;

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

	//For Service RFA/RFP
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
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	public CreateAppPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	/**
	 * Method To Call APP Creation Budget Revenue Procure nature Goods
	 * @shrikanth kulal
	 */
	public void createNewAnnualProcurementPlan(String BudgetTypeText, String financialYearText, 
			String appCodeText, String ProcurementNatureText,
			String TypeofEmergencyText,String PackageNoText,	
			String PackageDescriptionText, String LotNoText, 
			String LotDescriptionText,	String QuantityText, 
			String unitText, String EstimatedCostText,
			String ApprovingAuthorityText, String ProcurementTypeText, String ProcurementMethodText) throws InterruptedException, Throwable{
		dropdwnhelper.selectUsingVisibleText(BudgetType, BudgetTypeText);
		waithelper.setImplicitWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		dropdwnhelper.selectUsingVisibleText(FinancialYear, financialYearText);
		testUtil.randomNoApp(); 
		TestUtil.clickOn(driver, NextButton, TestUtil.Time_Out);
		waithelper.setImplicitWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		boolean verifyText = verifhelper.isDisplayed(BudgetTypetext);
		AssertionHelper.verifyTrue(verifyText);
		AssertionHelper.updateTestStatus(verifyText);
		String str=AppId.getText();
		System.out.println("str app id is --->>> "+str);
		File fnew=new File(FileReaderManager.getInstance().getConfigReader().getAppGoodRevenuePath());
	
		if (fnew.exists() && fnew.isFile()){
		  fnew.delete();
		}
		System.out.println("File Creating...."+"\n");
		try {
		    System.out.println("Writing Content in file....."+"\n");
		    FileWriter f2 = new FileWriter(fnew, false);
		    f2.write(str);
		    System.out.println("Writing Content in File completed ....."+"\n");
		    f2.close();
		    System.out.println("Flie Closed Successfully"+"\n");
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		//TestUtil.sendKeys(driver, MiddleName1, TestUtil.timeOut, MiddleName);
		//TestUtil.sendKeys(driver, APPCode, TestUtil.Time_Out, appCodeText);
		//TestUtil.clickOn(driver, NextButton, TestUtil.Time_Out);
		//waithelper.setImplicitWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//boolean verifyText = verifhelper.isDisplayed(BudgetTypetext);
		//AssertionHelper.verifyTrue(verifyText);
		//AssertionHelper.updateTestStatus(verifyText);
		dropdwnhelper.selectUsingVisibleText(ProcurementNature, ProcurementNatureText);
		waithelper.setImplicitWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		dropdwnhelper.selectUsingVisibleText(TypeofEmergency, TypeofEmergencyText);
		TestUtil.sendKeys(driver, PackageNo, TestUtil.Time_Out, PackageNoText);
		TestUtil.sendKeys(driver, PackageDescription, TestUtil.Time_Out, PackageDescriptionText);
		TestUtil.sendKeys(driver, LotNo, TestUtil.Time_Out, LotNoText);
		TestUtil.sendKeys(driver, LotDescription, TestUtil.Time_Out, LotDescriptionText);
		TestUtil.sendKeys(driver, Quantity, TestUtil.Time_Out, QuantityText);
		TestUtil.sendKeys(driver, Unit, TestUtil.Time_Out, unitText);
		TestUtil.sendKeys(driver, EstimatedCost, TestUtil.Time_Out, EstimatedCostText);
		waithelper.setImplicitWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		jse.clickElement(SelectCategory);
		//TestUtil.sendKeys(driver, searchKeyword, TestUtil.Time_Out, "sangeeth");
		//TestUtil.clickOn(driver, shrikanthCheckBox, TestUtil.Time_Out);
		
		//driver.getWindowHandles() provides window ids(2 window ids are available -- parent  window id and child  window id)
		Set<String> handler=driver.getWindowHandles();
		//If we want to fetch all the values from Array or Arraylist we have to use for loop() bec. for loop() on the basis of indexes(i=0,1,2 etc..)
		//In set object, it does not store the value on the basis of indexes, So we are using Iterator
		Iterator<String> it=handler.iterator();
		
		String parentWindowId =it.next();
		System.out.println("parent window id: "+ parentWindowId);
		
		String childWindowId =it.next();
		System.out.println("child window id: "+ childWindowId);
		
		driver.switchTo().window(childWindowId);
		
		String childWindowIdTitle=driver.getTitle();
		System.out.println("child window title is: "+ childWindowIdTitle);
		AssertionHelper.verifyText(childWindowIdTitle, "CPV Category", "texts are matching");
		
		TestUtil.sendKeys(driver, searchKeyword, TestUtil.Time_Out, "construction");
		TestUtil.clickOn(driver, searchButton, TestUtil.Time_Out);
		
		//Checking constructionworkcheckbox
		if (!constructionworkcheckbox.isSelected()) {
			constructionworkcheckbox.click();
		}
		
		TestUtil.clickOn(driver, SubmitCpvCategory, TestUtil.Time_Out);
		waithelper.setImplicitWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//driver will switch to the parentWindow
		driver.switchTo().window(parentWindowId);
		String parentWindowIdTitle=driver.getTitle();
		System.out.println("parent window title is: "+ parentWindowIdTitle);
		AssertionHelper.verifyText(parentWindowIdTitle, "APP Package Details", "texts are matching");
		dropdwnhelper.selectUsingVisibleText(ApprovingAuthority, ApprovingAuthorityText);
		dropdwnhelper.selectUsingVisibleText(ProcurementType, ProcurementTypeText);
		waithelper.setImplicitWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		dropdwnhelper.selectUsingVisibleText(ProcurementMethod, ProcurementMethodText);
		
		TestUtil.clickOn(driver, NextButton2, TestUtil.Time_Out);
		
		CalenderHelper.selectDateByJs(driver, ExpectedDateOfAdvertisementOfIFTon, "29/10/2018");
		TestUtil.sendKeysTab(driver, NoOfDaysExpectedLastDateofSubmissionofTenders, TestUtil.Time_Out, "14");
		//jse.clickElement(NoOfDaysExpectedLastDateofSubmissionofTendersAAA);
		TestUtil.sendKeysTab(driver, NoOfDaysExpectedDateofOpeningofTenders, TestUtil.Time_Out, "0");
		/////////////////////////////////////
		//TestUtil.sendKeysTab(driver, NoOfDaysExpectedDateofSubmissionofEvaluationReport, TestUtil.Time_Out, "21");
		//TestUtil.sendKeysTab(driver, NoOfDaysExpectedDateofApprovalforAwardofContract, TestUtil.Time_Out, "14");
		//TestUtil.sendKeysTab(driver, NoOfDaysExpectedDateofIssuanceoftheNOA, TestUtil.Time_Out, "7");
		//NoOfDaysExpectedDateofIssuanceoftheNOA.sendKeys("3");
		/////////////////////////////////////
		TestUtil.sendKeysTab(driver, NoOfDaysExpectedDateofSigningofContract, TestUtil.Time_Out, "28");
		Thread.sleep(2000);
		TestUtil.sendKeysTab(driver, NoOfDaysExpectedDateofCompletionofContract, TestUtil.Time_Out, "10");
		jse.scrollIntoViewAndClick(Save);
		//waithelper.pageLoadTimeOut(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		WorkFlowCrt wfcr =	PageFactory.initElements(driver, WorkFlowCrt.class);
		try {
			wfcr.CreateWorkFlow();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		////////////////////////////// Hope login/////////////////////////////////////////////
		try {
			wfcr.HopeUserActivityForAPP1stphase();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		File src= new File(FileReaderManager.getInstance().getConfigReader().getAppGoodRevenuePath());
		
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
		//enters appId
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
		
		
		
		///TILL HERE
		//Shivanshu code
		//driver.close();//driver will close the childWindow
		/*Select app = new Select(BudgetType);
	    app.selectByValue("2");
		System.out.println("budget is selected");*/
		/*driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		Select year = new Select(FinancialYear);
		year.selectByValue("9");
		TestUtil testutil= new TestUtil();
		testutil.randomNoApp(); 
		//Next.click();
		//clickOn(driver,Next,20);
		String str=AppId.getText();
		File fnew=new File(FileReaderManager.getInstance().getConfigReader().getAppGoodRevenuePath());
	
		if (fnew.exists() && fnew.isFile()){
		  fnew.delete();
		}
		System.out.println("File Creating...."+"\n");
		try {
		    System.out.println("Writing Content in file....."+"\n");
		    FileWriter f2 = new FileWriter(fnew, false);
		    f2.write(str);
		    System.out.println("Writing Content in File completed ....."+"\n");
		    f2.close();
		    System.out.println("Flie Closed Successfully"+"\n");
		} catch (IOException e) {
		    e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Select slctntr = new Select(ProcurementNature);
		slctntr.selectByValue("Goods");
		Select slctemrg = new Select(TypeofEmergency);
		slctemrg.selectByValue("Normal");
		testutil.randomNo();
		PackageDescription.sendKeys("125jjjdgg hhuiihh");
		LotNo.sendKeys("12378");
		LotDescription.sendKeys("this is lot");
		Quantity.sendKeys("123458");
		Unit.sendKeys("KG");
		EstimatedCost.sendKeys("5897");
		PackageEstCost.sendKeys("4589");
	
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//Thread.sleep(1000);
		//SelectCategory.click();
		clickOn(driver,SelectCategory,20);
		//Window Handling
		//Thread.sleep(5000);
		String Parent_Window = driver.getWindowHandle();  
		for (String handle : driver.getWindowHandles()) {
		     driver.switchTo().window(handle);
		}
		CpvCatAgri.click();
		js.executeScript("window.scrollBy(0,1000)");
		//SubmitCpvCategory.click();
		clickOn(driver,SubmitCpvCategory,20);
		//+++++
		driver.switchTo().window(Parent_Window);  
		driver.switchTo().defaultContent();
		System.out.println("Windows come to back");
		//Thread.sleep(5000);
		Select slctauth = new Select(ApprovingAuthority);
		slctauth.selectByValue("6");
		Select slctprtype = new Select(ProcurementType);
		slctprtype.selectByValue("NCT");
		Thread.sleep(1000);
		Select slctprmthd = new Select(ProcurementMethod);
		slctprmthd.selectByValue("2");
		//NextButton2.click();
		clickOn(driver,NextButton2,20);
		String dateVal = "25/03/2018" ;
		selectDateByJs(driver,ExpectedDateOfAdvertisementOfIFTon,dateVal);
		Thread.sleep(2000);
		NoOfDaysExpectedLastDateofSubmissionofTenders.sendKeys("5");
		NoOfDaysExpectedDateofOpeningofTenders.sendKeys("2");
		NoOfDaysExpectedDateofSubmissionofEvaluationReport.sendKeys("2");
		NoOfDaysExpectedDateofApprovalforAwardofContract.sendKeys("4");
		Thread.sleep(2000);
		NoOfDaysExpectedDateofIssuanceoftheNOA.sendKeys("3");
		NoOfDaysExpectedDateofSigningofContract.sendKeys("4");
		NoOfDaysExpectedDateofCompletionofContract.sendKeys("4");
		Thread.sleep(1000);
	
		clickOn(driver,Save,20);
		WorkFlowCrt wfcr=	PageFactory.initElements(driver, WorkFlowCrt.class);
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

		File src= new File(FileReaderManager.getInstance().getConfigReader().getAppGoodRevenuePath());
		
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
		}*/
	}

	//########  Own Budget  Procurement Nature Good  ************************
	public void OwnBudgetGoodsApp(String pckgdscpr, String lotno, 
			String lotdsrptn, String quantity, 
			String unit, String estCost) throws InterruptedException, Throwable{
		//select budget type
	    Select app = new Select(BudgetType);
	    app.selectByValue("3");
	    waithelper.setImplicitWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	    
	    Select year = new Select(FinancialYear);
	    year.selectByValue("9");
	    waithelper.setImplicitWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	    testUtil.randomNoApp(); 

		//Next.click();
		clickOn(driver,NextButton,20);
		String str=AppId.getText();
		File fnew=new File(FileReaderManager.getInstance().getConfigReader().getAppGoodsOwnPath());
	
		if (fnew.exists() && fnew.isFile()){
		  fnew.delete();
		}
		System.out.println("File Creating...."+"\n");
	
		try {
		    System.out.println("Writing Content in file....."+"\n");
		    FileWriter f2 = new FileWriter(fnew, false);
		    f2.write(str);
		    System.out.println("Writing Content in File completed ....."+"\n");
		    f2.close();
		    System.out.println("Flie Closed Successfully"+"\n");
		} catch (IOException e) {
		    e.printStackTrace();
		}

		Select slctntr = new Select(ProcurementNature);
		slctntr.selectByValue("Goods");
		waithelper.setImplicitWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Select slctemrg = new Select(TypeofEmergency);
		slctemrg.selectByValue("Normal");
		testUtil.randomNo();
		PackageDescription.sendKeys(pckgdscpr);
		LotNo.sendKeys(lotno);
		LotDescription.sendKeys(lotdsrptn);
		Quantity.sendKeys(quantity);
		Unit.sendKeys(unit);
		EstimatedCost.sendKeys(estCost);
		PackageEstCost.sendKeys("4589");
		waithelper.setImplicitWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,1000)");
		waithelper.setImplicitWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		SelectCategory.click();
		//Window Handling
		//Thread.sleep(5000);
		String Parent_Window = driver.getWindowHandle();  
		for (String handle : driver.getWindowHandles()) {
		  driver.switchTo().window(handle);
		}
		CpvCatAgri.click();
		js.executeScript("window.scrollBy(0,1000)");
		SubmitCpvCategory.click();
		waithelper.setImplicitWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//+++++
		driver.switchTo().window(Parent_Window);  
		driver.switchTo().defaultContent();
		System.out.println("Windows come to back");
		waithelper.setImplicitWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		Select slctauth = new Select(ApprovingAuthority);
		slctauth.selectByValue("2");
		 
		Select slctprtype = new Select(ProcurementType);
		slctprtype.selectByValue("NCT");
		
		waithelper.setImplicitWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
		Select slctprmthd = new Select(ProcurementMethod);
		slctprmthd.selectByValue("2");
		
		NextButton2.click();
		LocalDate now = LocalDate.now();
		 
		DateTimeFormatter formatter_2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
		String format_2=(now).format(formatter_2);
	
		String dateVal = "21/06/2018" ;
	
	
		selectDateByJs(driver,ExpectedDateOfAdvertisementOfIFTon,format_2);
		waithelper.setImplicitWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		NoOfDaysExpectedLastDateofSubmissionofTenders.sendKeys("5");
		NoOfDaysExpectedDateofOpeningofTenders.sendKeys("2");
		NoOfDaysExpectedDateofSubmissionofEvaluationReport.sendKeys("2");
		NoOfDaysExpectedDateofApprovalforAwardofContract.sendKeys("4");
		waithelper.setImplicitWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		NoOfDaysExpectedDateofIssuanceoftheNOA.sendKeys("3");
		NoOfDaysExpectedDateofSigningofContract.sendKeys("4");
		NoOfDaysExpectedDateofCompletionofContract.sendKeys("4");
		Save.click();
		WorkFlowCrt wfcr=	PageFactory.initElements(driver, WorkFlowCrt.class);
		wfcr.CreateWorkFlow();
		wfcr.HopeUserActivityForAPP1stphase();
	
		File src= new File(FileReaderManager.getInstance().getConfigReader().getAppGoodsOwnPath());
		FileInputStream fis = new FileInputStream(src);
		String strgAppIdGoodsOwn = IOUtils.toString(fis);
	
		SearchApp.sendKeys(strgAppIdGoodsOwn);
		wfcr.HopeUserActivityForAPP2ndPhase();
		wfcr.PePublisheApp1stPhase();
		serchAppid.sendKeys(strgAppIdGoodsOwn);
		wfcr.PePublisheApp2ndPhase();
	}




	//########  Own Budget  Procurement Nature Work  ************************
	public void OwnBudgetWorksApp() throws InterruptedException{
		Select app = new Select(BudgetType);
		app.selectByValue("3");
		//System.out.println("budget is selected");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
		Select year = new Select(FinancialYear);
		year.selectByValue("9");
	
		TestUtil testutil= new TestUtil();
		testutil.randomNoApp(); 
	
		//Next.click();
		clickOn(driver,NextButton,20);
		String str=AppId.getText();
	
		File fnew=new File(FileReaderManager.getInstance().getConfigReader().getAppWorkRevPath());
		if (fnew.exists() && fnew.isFile()){
		  fnew.delete();
		}
		System.out.println("File Creating...."+"\n");
		try {
		    System.out.println("Writing Content in file....."+"\n");
		    FileWriter f2 = new FileWriter(fnew, false);
		    f2.write(str);
		    System.out.println("Writing Content in File completed ....."+"\n");
		    f2.close();
		    System.out.println("Flie Closed Successfully"+"\n");
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Select slctntr = new Select(ProcurementNature);
		slctntr.selectByValue("Works");
	
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
		Select slctemrg = new Select(TypeofEmergency);
		slctemrg.selectByValue("Normal");
		testutil.randomNo();
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
		CommanActivity com=PageFactory.initElements(driver, CommanActivity.class);
		try {
			com.WindowHandleSelectCatg();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	
		Select slctauth = new Select(ApprovingAuthority);
		slctauth.selectByValue("1");
	
		Select slctpqReq = new Select(PQRequires);
		slctpqReq.selectByValue("No");
	
		Select slctprtype = new Select(ProcurementType);
		slctprtype.selectByValue("NCT");
	
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
		Select slctprmthd = new Select(ProcurementMethod);
		slctprmthd.selectByValue("2");
	
		clickOn(driver,NextButton2,10);
	
		com.DatePickerNextDate();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
		NoOfDaysExpectedLastDateofSubmissionofTenders.sendKeys("5");
		NoOfDaysExpectedDateofOpeningofTenders.sendKeys("2");
		NoOfDaysExpectedDateofSubmissionofEvaluationReport.sendKeys("2");
		NoOfDaysExpectedDateofApprovalforAwardofContract.sendKeys("4");
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		NoOfDaysExpectedDateofIssuanceoftheNOA.sendKeys("3");
		NoOfDaysExpectedDateofSigningofContract.sendKeys("4");
		NoOfDaysExpectedDateofCompletionofContract.sendKeys("4");
		Save.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		WorkFlowCrt wfcr=	PageFactory.initElements(driver, WorkFlowCrt.class);
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
	
		File src= new File(FileReaderManager.getInstance().getConfigReader().getAppWorkRevPath());
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



//  **************DEVLOPEMENT BUDGET PROCURE NATURE GOOD  #########%%%%%%%%%%%%%%&&&&&&&&&
	public void DevBudgetGoodsApp() throws InterruptedException{
	    Select app = new Select(BudgetType);
	    app.selectByValue("1");
		
		Select year = new Select(FinancialYear);
		year.selectByValue("9");
		
		Select sltdep = new Select(SelectProject);
		sltdep.selectByValue("3097");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//testUtil = new TestUtil();
		testUtil.randomNoApp(); 
		NextButton.click();
		String str=AppId.getText();
		File fnew=new File(FileReaderManager.getInstance().getConfigReader().getAppGoodDevlopementPath());
		if (fnew.exists() && fnew.isFile()){
		  fnew.delete();
		}
		System.out.println("File Creating...."+"\n");
		try {
		    System.out.println("Writing Content in file....."+"\n");
		    FileWriter f2 = new FileWriter(fnew, false);
		    f2.write(str);
		    System.out.println("Writing Content in File completed ....."+"\n");
		    f2.close();
		    System.out.println("Flie Closed Successfully"+"\n");
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Select slctntr = new Select(ProcurementNature);
		slctntr.selectByValue("Goods");
		
		Select slctemrg = new Select(TypeofEmergency);
		slctemrg.selectByValue("Normal");
		
		testUtil.randomNo();
		PackageDescription.sendKeys("package test");
		LotNo.sendKeys("12378");
		LotDescription.sendKeys("this is lot");
		Quantity.sendKeys("123458");
		Unit.sendKeys("KG");
		EstimatedCost.sendKeys("5897");
		PackageEstCost.sendKeys("4589");
		
		js.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		CommanActivity com=PageFactory.initElements(driver, CommanActivity.class);
		try {
			com.WindowHandleSelectCatg();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	
		Select slctauth = new Select(ApprovingAuthority);
		slctauth.selectByValue("1");
		 
		Select slctprtype = new Select(ProcurementType);
		slctprtype.selectByValue("NCT");
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Select slctprmthd = new Select(ProcurementMethod);
		slctprmthd.selectByValue("2");
		NextButton2.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		com.DatePickerNextDate();
		NoOfDaysExpectedLastDateofSubmissionofTenders.sendKeys("5");
		NoOfDaysExpectedDateofOpeningofTenders.sendKeys("2");
		NoOfDaysExpectedDateofSubmissionofEvaluationReport.sendKeys("2");
		NoOfDaysExpectedDateofApprovalforAwardofContract.sendKeys("4");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		NoOfDaysExpectedDateofIssuanceoftheNOA.sendKeys("3");
		NoOfDaysExpectedDateofSigningofContract.sendKeys("4");
		NoOfDaysExpectedDateofCompletionofContract.sendKeys("4");
		Save.click();
	
		WorkFlowCrt wfcr=	PageFactory.initElements(driver, WorkFlowCrt.class);
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
	
	
		File src= new File(FileReaderManager.getInstance().getConfigReader().getAppGoodDevlopementPath());
		
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



	// ***********Budget Type Development Procure Nature Work ******************
	public void DevBudgetWorkApp() throws InterruptedException{
	    Select app = new Select(BudgetType);
	    app.selectByValue("1");
		Select sltdep = new Select(SelectProject);
		sltdep.selectByValue("3097");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Select year = new Select(FinancialYear);
		year.selectByValue("9");
	
		testUtil = new TestUtil();
		testUtil.randomNoApp(); 
		clickOn(driver,NextButton,10);
	
		String str=AppId.getText();
		File fnew=new File(FileReaderManager.getInstance().getConfigReader().getAppWorkDevPath());
		
		if (fnew.exists() && fnew.isFile()){
		  fnew.delete();
		}
		System.out.println("File Creating...."+"\n");
		try {
		    System.out.println("Writing Content in file....."+"\n");
		    FileWriter f2 = new FileWriter(fnew, false);
		    f2.write(str);
		    System.out.println("Writing Content in File completed ....."+"\n");
		    f2.close();
		    System.out.println("Flie Closed Successfully"+"\n");
		} catch (IOException e) {
		    e.printStackTrace();
		}
	
		Select slctntr = new Select(ProcurementNature);
		slctntr.selectByValue("Works");
		
		Select slctemrg = new Select(TypeofEmergency);
		slctemrg.selectByValue("Normal");
		
		testUtil.randomNo();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		PackageDescription.sendKeys("125jjjdgg hhuiihh");
		LotNo.sendKeys("12378");
		LotDescription.sendKeys("this is lot");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Quantity.sendKeys("123458");
		Unit.sendKeys("KG");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		EstimatedCost.sendKeys("5897");
		PackageEstCost.sendKeys("4589");
		
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
		CommanActivity com=PageFactory.initElements(driver, CommanActivity.class);
		try {
			com.WindowHandleSelectCatg();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		Select slctauth = new Select(ApprovingAuthority);
		slctauth.selectByValue("1");
		
		Select slctpqReq = new Select(PQRequires);
		slctpqReq.selectByValue("No");
		
		Select slctprtype = new Select(ProcurementType);
		slctprtype.selectByValue("NCT");
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Select slctprmthd = new Select(ProcurementMethod);
		slctprmthd.selectByVisibleText("Open Tendering Method");
		
		clickOn(driver,NextButton2,10);
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		com.DatePickerNextDate();
	
		NoOfDaysExpectedLastDateofSubmissionofTenders.sendKeys("5");
		NoOfDaysExpectedDateofOpeningofTenders.sendKeys("2");
		NoOfDaysExpectedDateofSubmissionofEvaluationReport.sendKeys("2");
		NoOfDaysExpectedDateofApprovalforAwardofContract.sendKeys("4");
		NoOfDaysExpectedDateofIssuanceoftheNOA.sendKeys("3");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		NoOfDaysExpectedDateofSigningofContract.sendKeys("4");
		NoOfDaysExpectedDateofCompletionofContract.sendKeys("4");
		clickOn(driver,Save,10);
		WorkFlowCrt wfcr=	PageFactory.initElements(driver, WorkFlowCrt.class);
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
	
		File src= new File(FileReaderManager.getInstance().getConfigReader().getAppWorkDevPath());
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


	// ***************Budget type Revenue Procure Nature Work ****************
	public void RevBudgetWorkApp() throws InterruptedException{
	    Select app = new Select(BudgetType);
	    app.selectByValue("2");
	    System.out.println("budget is selected");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Select year = new Select(FinancialYear);
		year.selectByValue("9");
	
		testUtil = new TestUtil();
		testUtil.randomNoApp(); 
		clickOn(driver,NextButton,10);
	
		String str=AppId.getText();
		File fnew=new File(FileReaderManager.getInstance().getConfigReader().getAppWorkRevPath());
		if (fnew.exists() && fnew.isFile()){
		  fnew.delete();
		}
		System.out.println("File Creating...."+"\n");
		try {
		    System.out.println("Writing Content in file....."+"\n");
		    FileWriter f2 = new FileWriter(fnew, false);
		    f2.write(str);
		    System.out.println("Writing Content in File completed ....."+"\n");
		    f2.close();
		    System.out.println("Flie Closed Successfully"+"\n");
		} catch (IOException e) {
		    e.printStackTrace();
		}
	
		Select slctntr = new Select(ProcurementNature);
		slctntr.selectByValue("Works");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Select slctemrg = new Select(TypeofEmergency);
		slctemrg.selectByValue("Normal");
		testUtil.randomNo();
		PackageDescription.sendKeys("tested successfully");
		LotNo.sendKeys("12378");
		LotDescription.sendKeys("this is lot");
		Quantity.sendKeys("123458");
		Unit.sendKeys("KG");
		EstimatedCost.sendKeys("589745521");
		PackageEstCost.sendKeys("45890000");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		CommanActivity com=PageFactory.initElements(driver, CommanActivity.class);
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
		slctprmthd.selectByValue("2");
		clickOn(driver,NextButton2,10);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		com.DatePickerNextDate();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		NoOfDaysExpectedLastDateofSubmissionofTenders.sendKeys("5");
		NoOfDaysExpectedDateofOpeningofTenders.sendKeys("2");
		NoOfDaysExpectedDateofSubmissionofEvaluationReport.sendKeys("2");
		NoOfDaysExpectedDateofApprovalforAwardofContract.sendKeys("4");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		NoOfDaysExpectedDateofIssuanceoftheNOA.sendKeys("3");
		NoOfDaysExpectedDateofSigningofContract.sendKeys("4");
		NoOfDaysExpectedDateofCompletionofContract.sendKeys("4");
		clickOn(driver,Save,10);
	
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		WorkFlowCrt wfcr=	PageFactory.initElements(driver, WorkFlowCrt.class);
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
	
		File src= new File(FileReaderManager.getInstance().getConfigReader().getAppWorkRevPath());
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

}
