package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
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
public class WorkFlowCrt extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	WorkFlowCrt wrkflowchrt;
	private Logger log = LoggerHelper.getLogger(WorkFlowCrt.class);
	// JavascriptExecutor js = (JavascriptExecutor) driver;
	JavaScriptHelper js = new JavaScriptHelper(driver);
	AlertHelper alert = new AlertHelper(driver);
	VerificationHelper verification = new VerificationHelper(driver);
	AssertionHelper assertion = new AssertionHelper();
	WaitHelper wait = new WaitHelper(driver);
	DropDownHelper dh = new DropDownHelper(driver);
	CommanActivity cm = new CommanActivity();
	FrameHelper frame = new FrameHelper(driver);

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

	@FindBy(id = "tbnAdd")
	private WebElement WorkflowSubmit;

	@FindBy(linkText = "Logout")
	private WebElement LogOut;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr[2]/td[2]")
	private WebElement dmmyclk;

	// Hope Activity
	@FindBy(id = "btnLogin")
	private WebElement loginBtn;

	@FindBy(id = "headTabWorkFlow")
	private WebElement workflowTab;

	@FindBy(id = "headTabPayment")
	private WebElement paymentMenuTab;

	@FindBy(id = "headTabTender")
	private WebElement tenderMenuTab;

	@FindBy(xpath = "//ul[@id='paymentsubmenu']/li[2]/a[contains(text(),'Tender Payment')]")
	WebElement tenderPaymentMenuTab;

	@FindBy(xpath = "//*[@id='ddsubmenu2']/li[4]/a")
	WebElement allTenders;

	@FindBy(xpath = "//ul[@id='ddsubmenu2']/li[2]/a")
	WebElement myTenders;

	@FindBy(id = "txtTenderId")
	private WebElement tenderIdEle;

	@FindBy(id = "tenderId")
	private WebElement tenderPropId;

	@FindBy(linkText = "Pending task")
	private WebElement pendingTask;

	@FindBy(id = "workflowId")
	private WebElement SearchApp;

	@FindBy(id = "btnSearchwf")
	private WebElement SearchButton;

	@FindBy(xpath = ".//*[@id='1']/td[9]/a")
	private WebElement Clk;

	@FindBy(xpath = "/html")
	private WebElement CommentTextBox;

	@FindBy(xpath = "//span[@id='cke_txtComments']/span[2]/span/table/tbody/tr[2]/td/iframe")
	private WebElement iFrameWebElement;

	@FindBy(id = "txtAction")
	private WebElement AAction;

	@FindBy(id = "tbnAdd")
	private WebElement submit;

	@FindBy(xpath = "/html/body/div[1]/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/a")
	private WebElement LogOuHope1;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement LogOuHope;

	// PE user going to published Tender
	@FindBy(id = "headTabTender")
	private WebElement TenderLink;

	@FindBy(linkText = "My Tender")
	private WebElement MyTenderLink;

	@FindBy(id = "tenderId")
	private WebElement serchByTenderIdOnTextFld;

	@FindBy(id = "btnSearch")
	private WebElement SrchtndrBtn;

	@FindBy(xpath = "//input[@name='btnpaymentsearch']")
	private WebElement SrchtndrBtntext;

	// click verify link
	@FindBy(xpath = "//a[contains(text(),'Verify')]")
	private WebElement verifyLink;

	@FindBy(id = "txtComments")
	private WebElement remarksComments;

	@FindBy(id = "btnVerify")
	private WebElement buttonVerify;

	@FindBy(xpath = "//div[contains(text(),'Payment verified successfully')]")
	private WebElement paymentVerificationText;

	@FindBy(xpath = "//div[contains(text(),'Declaration completed successfully')]")
	private WebElement declarationVerificationText;

	@FindBy(xpath = "//div[text()='Tender Security Payment is Pending']")
	private WebElement tenderSecurityPaymentText;

	@FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr/td[7]/a/img")
	private WebElement clickToDasbordTndr;

	@FindBy(xpath = "//*[@id='resultTable']/tbody/tr[1]/td[7]/a/img")
	private WebElement clickToDashbordIcon;

	// create member committee
	@FindBy(linkText = "Create")
	WebElement EvaluationCommitteeCreate;

	@FindBy(id = "txtcommitteeName")
	WebElement CommitteeName;

	@FindBy(id = "addmem")
	WebElement AddMembers;

	@FindBy(xpath = "//a[@id='addmem']")
	WebElement AddMembersButton;

	@FindBy(id = "chk1")
	WebElement AOUserAsMember;

	@FindBy(id = "chk5")
	WebElement HopeUserAsMember;

	@FindBy(id = "chk12")
	private WebElement SamplePEMember;

	@FindBy(id = "//input[@id='chk55']")
	private WebElement MrPEUser_UAT;

	@FindBy(id = "//input[@id='chk57']")
	private WebElement TECCPTU;

	@FindBy(id = "chk31")
	private WebElement HopeuserTecMember;

	@FindBy(xpath = "//*[@id='myPanelDiv']/div[3]/div/button[1]")
	WebElement AddButtonInWindow;

	@FindBy(id = "cmbMemRole0")
	WebElement CommitteeRoleAOUser;
	// cp chair
	@FindBy(id = "cmbMemRole1")
	WebElement CommitteeRoleHopeUser;
	// m member value

	@FindBy(xpath = "//*[@id=\"offTabPanel\"]/li[4]/a")
	WebElement OpeningLink;

	@FindBy(xpath = "/html/body/div/div[3]/table/tbody/tr[2]/td[3]")
	WebElement UnnElee;

	@FindBy(xpath = "/html/body/table/tbody/tr[4]/td[2]/p")
	WebElement unassryeleemm;

	@FindBy(id = "btnSubmit")
	WebElement submitcommMem;

	@FindBy(xpath = "//*[@id=\"pe1\"]/table/tbody/tr[1]/th[1]")
	private WebElement dmmyclkkk;

	@FindBy(linkText = "TEC")
	private WebElement TecMembers;

	@FindBy(xpath = "//*[@id='ope']")
	private WebElement tecTab;

	@FindBy(id = "chk32")
	private WebElement TecPecUser;

	// APP
	@FindBy(id = "headTabApp")
	private WebElement AppLink;

	@FindBy(linkText = "My APP")
	private WebElement MyAppLink;

	@FindBy(id = "cmbstatus")
	private WebElement MyAppStatus;

	@FindBy(xpath = "//*[@id='btnSearchApp']")
	private WebElement srchBtnforappId;

	@FindBy(xpath = "//*[@id='0']/td[6]/a/img")
	private WebElement activityApp;

	@FindBy(linkText = "Publish")
	private WebElement ApppuBlish;

	@FindBy(id = "txtremark")
	private WebElement Textpublish;

	@FindBy(id = "btnsubmit")
	private WebElement subPublish;

	@FindBy(linkText = "Document")
	WebElement DocumentLink;

	@FindBy(xpath = "/html/body/div/div[3]/div[4]/table[3]/tbody/tr[9]/td[2]/table[5]/tbody/tr[2]/td[3]/a[2]")
	WebElement BillOfQuantitiesDashbord;

	@FindBy(linkText = "Fill up the Tables")
	WebElement FillUpTheTables;

	@FindBy(id = "chk1")
	WebElement CheckBoxCheck;

	@FindBy(id = "sucolumnbBtnCreateEdit")
	WebElement formSubmit;

	@FindBy(id = "Cell1_6")
	WebElement DeliveryPeriodindays;

	@FindBy(id = "Cell1_5")
	WebElement Quantity;

	@FindBy(xpath = "//td[@id='TD1_6']/input[@id='Cell1_6']")
	WebElement QuantityBOQ;

	@FindBy(xpath = "//td[@id='TD1_7']/input[@id='Cell1_7']")
	WebElement unitRateBOQ;

	@FindBy(xpath = "//select[@id='selComboWithOutCalc1_11']")
	WebElement iHaveSeenBOQ;

	// select[@id='selComboWithOutCalc1_11']

	@FindBy(id = "Cell1_4")
	WebElement MeasurementUnit;

	@FindBy(xpath = "//td[@id='TD1_5']/input[@id='Cell1_5']")
	WebElement MeasurementUnitBOQ;

	@FindBy(id = "Cell1_3")
	WebElement DescriptionofItem;

	@FindBy(xpath = "//td[@id='TD1_4']/textarea[@id='Cell1_4']")
	WebElement DescriptionofItemBOQ;

	@FindBy(id = "Cell1_2")
	WebElement ColumnHeader;

	@FindBy(id = "Cell1_1")
	WebElement ColumnHeader1;

	@FindBy(xpath = "//td[@id='TD1_1']/input[@id='Cell1_1']")
	WebElement ColumnHeaderItemNoBOQ;

	@FindBy(id = "Cell1_1")
	WebElement ItemNo;

	@FindBy(id = "Cell1_1")
	WebElement ColumnHeaderItemNoBOQItemNo;

	@FindBy(xpath = "//td[@id='TD1_2']/input[1][@id='Cell1_2']")
	WebElement ColumnHeaderItemNoBOQGroup;

	@FindBy(xpath = "//td[@id='TD1_3']/input[@id='Cell1_3']")
	WebElement itemCodeBOQ;

	@FindBy(id = "subBtnCreateEdit")
	WebElement subm;

	@FindBy(xpath = "//a[@title='Tender/Proposal Document']")
	WebElement TenderProposalDocument;

	@FindBy(xpath = "/html/body/div/div[3]/div[4]/table[3]/tbody/tr[9]/td[2]/table[5]/tbody/tr[3]/td[3]/a[2]")
	WebElement ScheduleofDayworksDashBord;

	@FindBy(xpath = "/html/body/div/div[3]/div[4]/table[3]/tbody/tr[9]/td[2]/table[5]/tbody/tr[4]/td[3]/a[1]")
	WebElement UnconditionalDiscountForm;

	@FindBy(xpath = "/html/body/div/div[3]/div[4]/table[3]/tbody/tr[9]/td[2]/table[5]/tbody/tr[2]/td[3]/a[2]")
	WebElement FormDasbrd2Bfrst;

	@FindBy(id = "Cell1_1")
	WebElement TextfldFor2Bform;

	@FindBy(xpath = "/html/body/div/div[3]/div[4]/table[3]/tbody/tr[9]/td[2]/table[5]/tbody/tr[3]/td[3]/a[2]")
	WebElement form2BBOQDashbord;

	@FindBy(id = "Cell1_7")
	WebElement textField2B7throw;

	@FindBy(id = "selComboWithOutCalc1_11")
	WebElement formdropdownAceptence;

	@FindBy(xpath = "//table[5]/tbody/tr[2]/td[3]/a[2][contains(text(),'Form Dashboard')]")
	private WebElement formDashbordEgp1;

	@FindBy(xpath = "/html/body/div/div[3]/div[4]/table[3]/tbody/tr[9]/td[2]/table[5]/tbody/tr[3]/td[3]/a[2][text()='Form Dashboard']")
	private WebElement formDashbordScheduleDayWorks;

	@FindBy(xpath = "//table[5]/tbody/tr[3]/td[3]/a[2][text()='Form Dashboard']")
	private WebElement formDashbordBOQ;

	@FindBy(xpath = "//table[4]/tbody/tr[2]/td[2]/a[1][text()='Fill up the Tables']")
	private WebElement FillUpTablesBOQ;

	@FindBy(xpath = "//table[3]/tbody/tr[2]/td[2]/a[1][text()='Fill up the Tables']")
	private WebElement FillUpTablesScheduleDayWorks;

	@FindBy(xpath = "//input[@id='chk1']")
	private WebElement checkBoxClick;

	/// ****************************
	@FindBy(xpath = "//input[@id='chk1']")
	private WebElement checkBoxSelect;

	@FindBy(xpath = "//input[@id='Cell1_1']")
	private WebElement itemNo;

	@FindBy(xpath = "//input[@id='Cell1_2']")
	private WebElement groupNo;

	@FindBy(xpath = "//input[@id='Cell1_3']")
	private WebElement itemCode;

	@FindBy(xpath = "//textarea[@id='Cell1_4']")
	private WebElement descItem;

	@FindBy(xpath = "//input[@id='Cell1_5']")
	private WebElement measureUnit;

	@FindBy(xpath = "//input[@id='Cell1_6']")
	private WebElement nominalQty;

	@FindBy(xpath = "//input[@id='subBtnCreateEdit']")
	private WebElement saveButon;

	@FindBy(xpath = "//table[3]/tbody/tr[9]/td[2]/table[5]/tbody/tr[4]/td[3]/a[1][contains(text(),'Form Dashboard')]")
	private WebElement formDashBoardDiscountForm;

	@FindBy(xpath = "/html/body/div/div[3]/table[4]/tbody/tr[2]/td[2]/a[1]")
	private WebElement fillUpTheTableEPg1;

	@FindBy(id = "Cell1_6")
	private WebElement formEPg1Field6;

	@FindBy(id = "Cell1_7")
	private WebElement formEPg1Field7;

	@FindBy(id = "Cell1_8")
	private WebElement formEPg1Field8;

	@FindBy(id = "sucolumnbBtnCreateEdit")
	private WebElement saveforForm1;

	@FindBy(id = "cmbFinancialYear")
	private WebElement FinanciaYear;

	@FindBy(xpath = "//ul[@class='tabPanel_1 noprint']/li")
	List<WebElement> totalTabs;

	@FindBy(xpath = "//div[@id='dialog-form']/fieldset/table/tbody/tr/td/ul/li/a")
	List<WebElement> totalTabsNew;

	@FindBy(xpath = "//ul[@class='tabPanel_1']/li/a")
	List<WebElement> totalTabsSize;

	@FindBy(id = "btnAgree")
	private WebElement agreeButton;

	@FindBy(id = "sign")
	private WebElement signButton;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//span[text()='Verify Password']")
	private WebElement verifyPassword;

	@FindBy(id = "encrypt")
	private WebElement encryptSaveButton;

	@FindBy(id = "save")
	private WebElement saveButton;

	@FindBy(xpath = "//div[contains(text(),'Form saved successfully')]")
	private WebElement fillSave1;

	@FindBy(xpath = "//div[text()='Document Uploaded and Mapped Successfully.']")
	private WebElement uploadMsg;

	@FindBy(xpath = "//*[@id='tblMain']/tbody/tr[2]/td[2]/a[4]")
	private WebElement encrypt1;

	@FindBy(xpath = "//*[@id='tblMain']/tbody/tr[3]/td[2]/a[4]")
	private WebElement encrypt1RFQ;

	@FindBy(xpath = "//*[@id='tblMain']/tbody/tr[3]/td[2]/a[4]")
	private WebElement encrypt2;

	@FindBy(xpath = "//*[@id='tblMain']/tbody/tr[4]/td[2]/a[4]")
	private WebElement encrypt3;

	@FindBy(xpath = "//*[@id='tblMain']/tbody/tr[5]/td[2]/a[4]")
	private WebElement encrypt4;

	@FindBy(xpath = "//*[@id='tblMain']/tbody/tr[8]/td[2]/a[4]")
	private WebElement encryptLink;
	
	@FindBy(xpath = "//*[@id='tblMain']/tbody/tr[7]/td[2]/a[4]")
	private WebElement encryptLink1;

	@FindBy(xpath = "//*[@id='tblMain']/tbody/tr[9]/td[2]/a[4]")
	private WebElement encrypt5;

	@FindBy(xpath = "//*[@id='tblMain']/tbody/tr[7]/td[2]/a[4]")
	private WebElement encrypt7Dup;

	@FindBy(xpath = "//*[@id='tblMain']/tbody/tr[8]/td/a[4]")
	private WebElement encrypt7Dup1;

	@FindBy(id = "decrypt")
	private WebElement decryptButton;

	@FindBy(xpath = "//span[text()='Ok']")
	private WebElement oKButton;

	@FindBy(xpath = "//select[starts-with(@id,'idcombodetail')]")
	private WebElement selectYes;

	@FindBy(xpath = "//*[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/child::table[1]/following-sibling::div[1]/child::table/tbody[1]/child::tr[2]/td[1]/child::input[3][starts-with(@id,'row')]")
	private WebElement nameOfTenderer;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[2]/table/tbody[1]/tr[2]/td[2]/input[3][starts-with(@id,'row')]")
	private WebElement regEmailId;

	// First checkbox row
	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[4]/table/tbody[1]/tr[2]/td[1]/input[starts-with(@id,'chk')]")
	private WebElement checkBox1;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[4]/table/tbody[1]/tr[2]/td[2]/input[3][starts-with(@id,'row')]")
	private WebElement contractNo;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[6]/table/tbody[1]/tr[2]/td[1]/input[starts-with(@id,'chk')]")
	private WebElement checkBoxNew;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[6]/table/tbody[1]/tr[2]/td[2]/input[3][starts-with(@id,'row')]")
	private WebElement typeOfEquipment;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[6]/table/tbody[1]/tr[2]/td[3]/input[3][starts-with(@id,'row')]")
	private WebElement noAvailable;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[6]/table/tbody[1]/tr[2]/td[4]/textarea[starts-with(@id,'row')]")
	private WebElement ownedLeased;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/table[4]/following-sibling::div/child::table/tbody[1]/tr[2]/td[1]/input[starts-with(@id,'chk')]")
	private WebElement selectCheckBoxListKey;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/table[4]/following-sibling::div/child::table/tbody[1]/tr[2]/td[2]/input[3][starts-with(@id,'row')]")
	private WebElement serialNoListKey;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/table[4]/following-sibling::div/child::table/tbody[1]/tr[2]/td[3]/input[3][starts-with(@id,'row')]")
	private WebElement positionListKey;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/table[4]/following-sibling::div/child::table/tbody[1]/tr[2]/td[4]/input[3][starts-with(@id,'row')]")
	private WebElement nameListKey;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/table[4]/following-sibling::div/child::table/tbody[1]/tr[2]/td[5]/input[3][starts-with(@id,'row')]")
	private WebElement qualificationListKey;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/table[4]/following-sibling::div/child::table/tbody[1]/tr[2]/td[6]/input[3][starts-with(@id,'row')]")
	private WebElement experienceListKey;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[4]/table/tbody[1]/tr[2]/td[3]/textarea[starts-with(@id,'row')]")
	private WebElement nameOfContract;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[4]/table/tbody[1]/tr[2]/td[5]/input[3][starts-with(@id,'row')]")
	private WebElement awardDate;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[4]/table/tbody[1]/tr[2]/td[6]/input[3][starts-with(@id,'row')]")
	private WebElement completionDate;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[4]/table/tbody[1]/tr[2]/td[7]/input[3][starts-with(@id,'row')]")
	private WebElement totalContractValue;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[4]/table/tbody[1]/tr[2]/td[8]/input[3][starts-with(@id,'row')]")
	private WebElement procEntityName;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[4]/table/tbody[1]/tr[2]/td[9]/textarea[starts-with(@id,'row')]")
	private WebElement procEntityAddress;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[4]/table/tbody[1]/tr[2]/td[10]/input[3][starts-with(@id,'row')]")
	private WebElement procEntityFax;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[4]/table/tbody[1]/tr[2]/td[11]/input[3][starts-with(@id,'row')]")
	private WebElement procEntityEmail;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[4]/table/tbody[1]/tr[2]/td[12]/textarea[starts-with(@id,'row')]")
	private WebElement pERequirement;

	// second checkbox row
	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[6]/table/tbody[1]/tr[2]/td[1]/input[starts-with(@id,'chk')]")
	private WebElement checkBox2;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[6]/table/tbody[1]/tr[2]/td[2]/input[3][starts-with(@id,'row')]")
	private WebElement financialYear;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[6]/table/tbody[1]/tr[2]/td[3]/input[3][starts-with(@id,'row')]")
	private WebElement amntInBDT;

	// Third checkbox row
	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[8]/table/tbody[1]/tr[2]/td[1]/input[starts-with(@id,'chk')]")
	private WebElement checkBox3;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[8]/table/tbody[1]/tr[2]/td[2]/input[3][starts-with(@id,'row')]")
	private WebElement No;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[8]/table/tbody[1]/tr[2]/td[3]/input[3][starts-with(@id,'row')]")
	private WebElement sourceOfFinance;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[4]/table/tbody[1]/tr[2]/td[3]/input[3][starts-with(@id,'row')]")
	private WebElement sourceOfFinanceNew;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[4]/table/tbody[1]/tr[2]/td[4]/input[3][starts-with(@id,'row')]")
	private WebElement AmntAvailableNew;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[8]/table/tbody[1]/tr[2]/td[4]/input[3][starts-with(@id,'row')]")
	private WebElement amntAvailable;

	// Fourth checkbox row
	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[10]/table/tbody[1]/tr[2]/td[1]/input[starts-with(@id,'chk')]")
	private WebElement checkBox4;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[10]/table/tbody[1]/tr[2]/td[2]/textarea[starts-with(@id,'row')]")
	private WebElement nameAddressOtherContact;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[2]/table/tbody[1]/tr[2]/td[1]/input[starts-with(@id,'chk')]")
	private WebElement selectCheckBox;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[2]/table/tbody[1]/tr[2]/td[2]/input[3][starts-with(@id,'row')]")
	private WebElement serialNo;

	@FindBy(xpath = "//table[@id='FormMatrix']/tbody[1]/tr[2]/td[2]/input[3][starts-with(@id,'row')]")
	private WebElement percentageTextBox;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[2]/table/tbody[1]/tr[2]/td[3]/textarea[starts-with(@id,'row')]")
	private WebElement nameOfWorks;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[2]/table/tbody[1]/tr[2]/td[4]/input[3][starts-with(@id,'row')]")
	private WebElement valueOfWorks;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[2]/table/tbody[1]/tr[2]/td[5]/input[3][starts-with(@id,'row')]")
	private WebElement dateOfActualCompletion;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[2]/table/tbody[1]/tr[2]/td[6]/input[3][starts-with(@id,'row')]")
	private WebElement nameOfPEOrgn;

	@FindBy(xpath = "//a[@title='Upload']")
	private WebElement mapDocuments;

	@FindBy(xpath = "//input[@id='txtDescription']")
	private WebElement descriptionTextField;

	@FindBy(xpath = "//form[@id='frmBidSubmit']/table/tbody/tr/td/div/table/tbody/tr/td/div[2]/table/tbody[1]/tr[2]/td[7]/input[3][starts-with(@id,'row')]")
	private WebElement unitPrice;

	@FindBy(xpath = "//*[@id='tblMain']/tbody/tr[2]/td[3]/a[text()='Map']")
	private WebElement map1;

	@FindBy(xpath = "//*[@id='tblMain']/tbody/tr[3]/td[3]/a")
	private WebElement map2;

	@FindBy(xpath = "//*[@id='tblMain']/tbody/tr[7]/td[3]/a")
	private WebElement map3;

	@FindBy(xpath = "//*[@id='tblMain']/tbody/tr[8]/td[3]/a")
	private WebElement map4;

	@FindBy(xpath = "//*[@id='tblMain']/tbody/tr[7]/td[3]/a")
	private WebElement mapdup3;

	@FindBy(xpath = "//*[@id='frmFileUp']/table/tbody/tr[3]/td[2]/select[@id='manDocId']")
	private WebElement docType1;

	@FindBy(xpath = "//*[@id='frmMap']/table/tbody/tr/td/select[@id='manDocId']")
	private WebElement docType2;

	@FindBy(xpath = "//a[text()=' Go Back to Dashboard']")
	private WebElement goBackToDashBoard;

	@FindBy(xpath = "//input[@id='chkValidate']")
	private WebElement iAgreeButton;

	@FindBy(xpath = "//table[@class='tableList_1 t_space']/tbody/tr[2]/td[3]/a[text()='Payment']")
	private WebElement payment;

	@FindBy(id = "txtEmailId")
	private WebElement emailId;

	@FindBy(xpath = "//input[@id='btnSearch']")
	private WebElement searchButton;

	@FindBy(xpath = "//a[text()='Make Payment']")
	private WebElement makePayment;

	@FindBy(id = "cmbPayment")
	private WebElement modeOfPayment;

	@FindBy(id = "txtInsRefNo")
	private WebElement instrumentNo;

	@FindBy(id = "txtIssuanceBankNm")
	private WebElement inssuingBank;

	@FindBy(id = "txtIssuanceBranch")
	private WebElement inssuingBankBranch;

	@FindBy(xpath = "//input[@id='txtIssuanceDt']")
	private WebElement issuanceDate;

	@FindBy(xpath = "//div[text()='Payment updated successfully']")
	private WebElement updatedText;

	@FindBy(xpath = "//div[text()='Payment verified successfully']")
	private WebElement updatedPaymentText;

	@FindBy(xpath = "//a[text()='Verify']")
	private WebElement verifyLink1;

	@FindBy(id = "chkValidate")
	private WebElement iAgreeCheckBbox;

	@FindBy(id = "btnFinalSub")
	private WebElement goToFinalSubButton;

	@FindBy(xpath = "//input[@name='btnFinalSub']")
	private WebElement finalSubmission;

	@FindBy(xpath = "//a[text()='Fill up the Tables']")
	private WebElement fillUpTables;

	public WorkFlowCrt() {
		PageFactory.initElements(driver, this);
	}

	public void CreateWorkFlow() throws Throwable {
		log.info("**** inside WorkFlowCreateAppPage class ********** ");
		Create.click();
		Thread.sleep(1000);
		NoofReviewers.sendKeys("0");
		dmmyclk.click();
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", Submit);
		Select slctinit = new Select(Initiator);
		slctinit.selectByValue("1");
		Thread.sleep(2000);
		Select slctaprv = new Select(Approver);
		slctaprv.selectByValue("6");
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", Submit2);
		Thread.sleep(1000);
		CreateWorkFlow.click();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Comments.sendKeys("Please Approve annual procuremnet plan");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		Select slctact = new Select(Action);
		slctact.selectByValue("Forward_2");
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", WorkflowSubmit);
		LogOut.click();
		// driver.navigate().refresh();
	}

	public void CreateWorkFlow1(String estimatedCost) throws Throwable {
		log.info("**** inside WorkFlowCreateAppPage class ********** ");

		// Click on Process file Work flow
		String before_xpath = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath = "]/td[5]";

		for (int i = 2; i <= 200; i++) {
			String estCost = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println("estCost is zzzzzz" + estCost);
			log.info(estCost);
			if (estCost.equals(estimatedCost)) {
				System.out.println("String1 is " + estCost);
				System.out.println("String2 is " + estimatedCost);
				// Click on Process file Work flow link
				driver.findElement(By.xpath(
						"//*[@id='resultTable']/tbody/tr[" + i + "]/td[10]/a[1][text()='Process file in Workflow']"))
						.click();
				// *[@id='resultTable']/tbody/tr[66]/td[10]/a[1][text()='Process file in
				// Workflow']
				break;
			}
		}
		Thread.sleep(2500);
		// Assert.assertTrue(false);
		// Create.click();
		/*
		 * Thread.sleep(1000); NoofReviewers.sendKeys("0"); dmmyclk.click();
		 * Thread.sleep(1000); js.executeScript("arguments[0].click();", Submit); Select
		 * slctinit = new Select(Initiator); slctinit.selectByValue("1");
		 * Thread.sleep(2000); Select slctaprv = new Select(Approver);
		 * slctaprv.selectByValue("6"); Thread.sleep(1000);
		 * js.executeScript("arguments[0].click();", Submit2); Thread.sleep(1000);
		 * CreateWorkFlow.click(); Thread.sleep(3000);
		 */
		// frame.switchToFrame(iFrameWebElement);
		// driver.switchTo().frame(1);
		driver.switchTo().frame(0);
		CommentTextBox.sendKeys("Please Approve annual procuremnet plan-shrikanth");
		driver.switchTo().defaultContent();
		Thread.sleep(100);
		Select slctact = new Select(Action);
		slctact.selectByValue("Forward_2");
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", WorkflowSubmit);
		LogOut.click();
		// driver.navigate().refresh();
	}

	// *********************APP HOPE USER METHOD - HOPE USER
	// LOGIN********************
	public void HopeUserActivityForAPP1stphase() throws Throwable {
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.loginWithHope();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		// loginBtn.click();
		Actions action = new Actions(driver);
		action.moveToElement(workflowTab).build().perform();
		pendingTask.click();
	}

	public void HopeUserActivityForAPP2ndPhase() throws Throwable {
		// Method 1:
		/*
		 * 1.Iterate row and coloumn and get the cell value 2.Using for loop 3.Get total
		 * rows and iterate table 4.Put if(string matches) then select the value
		 * 5.Lengthy method
		 */

		// *[@id='vContactsForm']/table/tbody/tr[4]/td[2]
		// *[@id='vContactsForm']/table/tbody/tr[5]/td[2]
		// *[@id='vContactsForm']/table/tbody/tr[6]/td[2]
		// *[@id='vContactsForm']/table/tbody/tr[7]/td[2]

		/*
		 * String before_xpath="//*[@id='vContactsForm']/table/tbody/tr["; String
		 * after_xpath="]/td[2]";
		 * 
		 * for (int i=4; i<=7; i++) { String
		 * name=driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText ();
		 * System.out.println(name); if (name.contains("aaa aaa")) {
		 * driver.findElement(By.xpath(
		 * "//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[1]/input")).click( ); } }
		 */
		SearchButton.click();
		Clk.click();
		js.executeScript("scroll(0, 200);");
		Thread.sleep(2000);
		// driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,
		// TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		CommentTextBox.sendKeys("annual procurement plan is Approved");
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("scroll(0, 300);");
		Select action1 = new Select(AAction);
		action1.selectByVisibleText("Approve");
		// driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,
		// TimeUnit.SECONDS);
		clickOn(driver, submit, 10);
		LogOuHope.click();
		// driver.navigate().refresh();
	}

	public void HopeUserActivity() throws Throwable {
		// initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.loginWithHope();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// loginBtn.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Actions actio = new Actions(driver);
		actio.moveToElement(workflowTab).build().perform();
		pendingTask.click();

		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderID_1Path());
		FileInputStream fis = new FileInputStream(src);
		String strgTendrId = IOUtils.toString(fis);

		SearchApp.sendKeys(strgTendrId);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		SearchButton.click();
		Clk.click();

		js.executeScript("scroll(0, 200);");
		Thread.sleep(2000);
		// driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,
		// TimeUnit.SECONDS);
		driver.switchTo().frame(0);

		CommentTextBox.sendKeys("Approved");
		driver.switchTo().defaultContent();

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		js.executeScript("scroll(0, 300);");

		Select action1 = new Select(AAction);
		action1.selectByVisibleText("Approve");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		// submit.click();
		js.executeScript("arguments[0].click();", submit);

		LogOuHope.click();
		driver.navigate().refresh();
	}

	public void PePublisheApp1stPhase() throws Throwable {
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.loginWithPe();

		Actions action = new Actions(driver);
		action.moveToElement(AppLink).build().perform();
		MyAppLink.click();
		// Select slt=new Select(FinanciaYear);
		// slt.selectByValue("2017-2018");
	}

	public void PePublisheApp2ndPhase() throws Throwable {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		Select sle = new Select(MyAppStatus);
		sle.selectByVisibleText("- Approved -");

		js.executeScript("arguments[0].click();", srchBtnforappId);

		activityApp.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		ApppuBlish.click();
		Textpublish.sendKeys("Published");

		Thread.sleep(2000);
		// clickOn(driver,subPublish,10);
		subPublish.click();
	}

	public void AppPublisheTender() throws Throwable {
		testUtil = new TestUtil();

		loginPage = new LoginPage();
		homePage = loginPage.loginWithPe();

		Actions actionn = new Actions(driver);
		actionn.moveToElement(TenderLink).build().perform();
		MyTenderLink.click();

		File src = new File(FileReaderManager.getInstance().getConfigReader().getTenderID_1Path());
		FileInputStream fis = new FileInputStream(src);
		String strgTendrId = IOUtils.toString(fis);

		serchByTenderIdOnTextFld.sendKeys(strgTendrId);

		// srchBtnforappId.click();
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", SrchtndrBtn);
		Thread.sleep(2000);
		clickToDasbordTndr.click();
		Thread.sleep(2000);
		// LogoutfromPE.click()

	}

	public void EvolutionCommitteeCreate() throws Throwable {
		EvaluationCommitteeCreate.click();
		unassryeleemm.click();
		CommitteeName.sendKeys("Evl Comm");
		Thread.sleep(1000);
		AddMembers.click();

		// Window Handling
		Thread.sleep(2000);
		String Parent_Window = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		// Switching back to Parent Window
		AOUserAsMember.click();
		HopeUserAsMember.click();
		AddButtonInWindow.click();
		driver.switchTo().window(Parent_Window);
		driver.switchTo().defaultContent();
		System.out.println("Windows come to back");

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,300)");
		Select slctAo = new Select(CommitteeRoleAOUser);
		slctAo.selectByValue("m");

		// Select slctHope = new Select(CommitteeRoleHopeUser);
		// slctHope.selectByValue("cp");
		// unnasrypageele.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		// submitcommMem.sendKeys(Keys.RETURN);
		js.executeScript("arguments[0].click();", submitcommMem);
		// submitcommMem.click();
	}

	public void OpningCommitteeCreate() throws Throwable {
		EvaluationCommitteeCreate.click();
		unassryeleemm.click();
		CommitteeName.sendKeys("Opening Committee team");
		AddMembers.click();
		// Window Handling
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		String Parent_Window = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		
		for (int i = 0; i < totalTabsNew.size(); i++) {
			WebElement element = totalTabsNew.get(i);
			String text = totalTabsNew.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.equals("Same PE")) {
				element.click();

				String before_xpth = "//div[@id='pe1']/table/tbody/tr[";
				String after_xpth = "]/td[2]";

				for (int k = 2; k <= 59; k++) {
					String memberName = driver.findElement(By.xpath(before_xpth+k+after_xpth)).getText();
					System.out.println("memberName is ----->>>" + memberName);
					log.info(memberName);
					if (memberName.contains("PE USER_UAT")) {
						driver.findElement(By.xpath("//*[@id='chk55']")).click();
						TestUtil.clickOn(driver, AddButtonInWindow, 100);
						break;
					}
				}
			}
		}

		// MrPEUser_UAT.click();
		// dmmyclkkk.click();
		// tecTab.click();
		// Thread.sleep(1000);
		// TECCPTU.click();
		// AddButtonInWindow.click();
		// Switching back to Parent Window
		driver.switchTo().window(Parent_Window);
		driver.switchTo().defaultContent();
		
		Thread.sleep(1000);
		js.clickElement(AddMembersButton);
		//js.scrollIntoView(AddMembersButton);
		//clickOn(driver, AddMembersButton, 500);
		//AddMembersButton.click();

		// ***********************************************

		String Parent_Window1 = driver.getWindowHandle();
		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
		
		for (int i = 0; i < totalTabsNew.size(); i++) {
			WebElement element = totalTabsNew.get(i);
			String text = totalTabsNew.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.equals("TEC")) {
				element.click();

				String before_xpth = "//tbody[@id='tbodype']/tr[";
				String after_xpth = "]/td[2]";

				for (int k = 1; k <= 2; k++) {
					String memberName = driver.findElement(By.xpath(before_xpth+k+after_xpth)).getText();
					log.info(memberName);
					if (memberName.contains("TEC CPTU CPTU")) {
						driver.findElement(By.xpath("//*[@id='chk59']")).click();
						TestUtil.clickOn(driver, AddButtonInWindow, 100);
						break;
					}
				}
			}
		}

	// MrPEUser_UAT.click();
	// dmmyclkkk.click();
	// tecTab.click();
	// Thread.sleep(1000);
	// TECCPTU.click();
	// AddButtonInWindow.click();
	// Switching back to Parent Window
	driver.switchTo().window(Parent_Window1);
	driver.switchTo().defaultContent();
	//AddMembersButton.click();

	System.out.println("Windows come to back");
	Thread.sleep(2000);
	js.executeScript("window.scrollBy(0,300)");

	Select slctAo = new Select(CommitteeRoleAOUser);
	slctAo.selectByValue("ms");
	// Assert.assertTrue(false);

	// Select slctHope = new Select(CommitteeRoleHopeUser);
	// slctHope.selectByValue("cp");

	// unnasrypageele.click();
	Thread.sleep(2000);
	// submitcommMem.sendKeys(Keys.RETURN);
	js.executeScript("arguments[0].click();",submitcommMem);
	// submitcommMem.click();
	}

	// For Notice
	public void CreateWorkFlowForNotice() throws Throwable {
		Create.click();
		Thread.sleep(1000);
		NoofReviewers.sendKeys("0");
		dmmyclk.click();
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", Submit);
		Select slctinit = new Select(Initiator);
		slctinit.selectByValue("1");
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", Submit2);
	}

	// ############@@@@@@@ Document Activity
	// ******^^^&&&&&&&&$$$####!!!~~~@@@@@@

	public void DocumentLinkActivityForFormPW3D() throws Throwable {

		DocumentLink.click();

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		js.executeScript("window.scrollBy(0,800)");

		BillOfQuantitiesDashbord.click();

		FillUpTheTables.click();

		CheckBoxCheck.click();

		ItemNo.sendKeys("11");

		ColumnHeader.sendKeys("sdjsdsa");

		DescriptionofItem.sendKeys("sdjjsjdks");

		MeasurementUnit.sendKeys("14");

		Quantity.sendKeys("sdgffsds");

		DeliveryPeriodindays.sendKeys("4");

		clickOn(driver, subm, 10);

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Alert altr = driver.switchTo().alert();
		altr.accept();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		altr.accept();

		TenderProposalDocument.click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,800)");
		ScheduleofDayworksDashBord.click();

		FillUpTheTables.click();

		CheckBoxCheck.click();

		ItemNo.sendKeys("11");

		ColumnHeader.sendKeys("sdjsdsa");

		DescriptionofItem.sendKeys("sdjjsjdks");

		MeasurementUnit.sendKeys("14");

		Quantity.sendKeys("sdgffsds");

		DeliveryPeriodindays.sendKeys("4");

		subm.click();
		clickOn(driver, subm, 10);

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		altr.accept();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		altr.accept();
		TenderProposalDocument.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}

	public void DocumentLinkActivityForFormPW3() throws Throwable {

		DocumentLink.click();

		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,800)");

		BillOfQuantitiesDashbord.click();

		FillUpTheTables.click();

		CheckBoxCheck.click();

		ItemNo.sendKeys("11");

		ColumnHeader.sendKeys("sdjsdsa");

		DescriptionofItem.sendKeys("sdjjsjdks");

		MeasurementUnit.sendKeys("14");

		Quantity.sendKeys("sdgffsds");

		DeliveryPeriodindays.sendKeys("4");

		Thread.sleep(2000);
		subm.click();

		Thread.sleep(2000);
		Alert altr = driver.switchTo().alert();
		altr.accept();
		Thread.sleep(2000);
		altr.accept();

		TenderProposalDocument.click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,800)");

		ScheduleofDayworksDashBord.click();

		FillUpTheTables.click();

		CheckBoxCheck.click();

		ItemNo.sendKeys("11");

		ColumnHeader.sendKeys("sdjsdsa");

		DescriptionofItem.sendKeys("sdjjsjdks");

		MeasurementUnit.sendKeys("14");

		Quantity.sendKeys("sdgffsds");

		DeliveryPeriodindays.sendKeys("4");

		Thread.sleep(2000);
		subm.click();

		Thread.sleep(2000);

		altr.accept();
		Thread.sleep(2000);
		altr.accept();
		TenderProposalDocument.click();
		Thread.sleep(2000);
		UnconditionalDiscountForm.click();
		FillUpTheTables.click();

		CheckBoxCheck.click();
		Thread.sleep(2000);
		subm.click();
		altr.accept();
		Thread.sleep(2000);
		altr.accept();
		TenderProposalDocument.click();
		Thread.sleep(1000);

	}

	public void DocumentLinkActivityForFormPW2B() throws Throwable {

		// DocumentLink.click();

		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,800)");

		FormDasbrd2Bfrst.click();

		FillUpTheTables.click();

		CheckBoxCheck.click();
		TextfldFor2Bform.sendKeys("2.222");
		subm.click();

		TenderProposalDocument.click();

		form2BBOQDashbord.click();

		FillUpTheTables.click();

		ItemNo.sendKeys("11");

		ColumnHeader.sendKeys("sdjsdsa");

		DescriptionofItem.sendKeys("sdjjsjdks");

		MeasurementUnit.sendKeys("14");

		Quantity.sendKeys("sdgffsds");

		DeliveryPeriodindays.sendKeys("4");
		textField2B7throw.sendKeys("2.987");

		js.executeScript("arguments[0].scrollIntoView();", formdropdownAceptence);

		Select slctAcept = new Select(formdropdownAceptence);
		slctAcept.selectByVisibleText("I've Seen");

		subm.click();
		Alert altr = driver.switchTo().alert();
		altr.accept();
		Thread.sleep(2000);
		altr.accept();
		TenderProposalDocument.click();

	}

	public void DocumentLinkActivityForFormEPG1() throws Throwable {
		// Click on Document tab
		DocumentLink.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,800)");
		formDashbordEgp1.click();
		FillUpTheTables.click();

		CheckBoxCheck.click();
		ColumnHeader.sendKeys("sdjsdsa");
		ItemNo.sendKeys("2");
		DescriptionofItem.sendKeys("sdjjsjdks");

		MeasurementUnit.sendKeys("14");
		Quantity.sendKeys("2");

		DeliveryPeriodindays.sendKeys("2");
		// formEPg1Field6.sendKeys("2");
		// formEPg1Field7.sendKeys("2");
		// formEPg1Field8.sendKeys("2");
		js.executeScript("window.scrollBy(0,800)");
		// clickOn(driver, saveforForm1, 20);

		clickOn(driver, subm, 20);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.accept();

		/*
		 * try { boolean b=alert.isAlertPresent(); if (b) { alert.acceptAlert(); } }
		 * catch (UnhandledAlertException e) { e.printStackTrace(); }
		 */

		// String actualText=alert.getAlertText();
		// System.out.println("text is "+actualText);
		// Assert.assertEquals(actualText, "Are you sure want to add Group : sdjsdsa
		// ?");
		// alert.acceptAlertIfPresent();
		// alert.acceptAlert();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// clickOn(drier, locator, timeout);
		// FillUpTheTables.click();
		// js.executeScript("arguments[0].click();", TenderProposalDocument);
		TenderProposalDocument.click();
	}

	/*
	 * Document tab
	 */
	public void Document_TAB_ActivityForm_e_PW1A() throws Throwable {

		// Click on Document tab
		for (int i = 0; i < totalTabs.size(); i++) {
			WebElement element = totalTabs.get(i);
			String text = totalTabs.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.equals("Document")) {
				element.click();
				break;
			}
		}

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,800)");

		// Form Name 2 - Tenderer's Quoted Price
		formDashbordEgp1.click();
		FillUpTheTables.click();

		CheckBoxCheck.click();
		ColumnHeader.sendKeys("sdjsdsa");
		ItemNo.sendKeys("2");
		DescriptionofItem.sendKeys("sdjjsjdks");

		MeasurementUnit.sendKeys("14");
		Quantity.sendKeys("2");

		DeliveryPeriodindays.sendKeys("2");
		// formEPg1Field6.sendKeys("2");
		// formEPg1Field7.sendKeys("2");
		// formEPg1Field8.sendKeys("2");
		js.executeScript("window.scrollBy(0,800)");
		// clickOn(driver, saveforForm1, 20);

		clickOn(driver, subm, 20);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.accept();

		/*
		 * try { boolean b=alert.isAlertPresent(); if (b) { alert.acceptAlert(); } }
		 * catch (UnhandledAlertException e) { e.printStackTrace(); }
		 */

		// String actualText=alert.getAlertText();
		// System.out.println("text is "+actualText);
		// Assert.assertEquals(actualText, "Are you sure want to add Group : sdjsdsa
		// ?");
		// alert.acceptAlertIfPresent();
		// alert.acceptAlert();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// clickOn(drier, locator, timeout);
		// FillUpTheTables.click();
		// js.executeScript("arguments[0].click();", TenderProposalDocument);
		TenderProposalDocument.click();
	}

	/**
	 * Document part
	 * 
	 * @throws Throwable
	 */
	public void Document_TAB_ActivityForm_e_PW2B() throws Throwable {

		for (int i = 0; i < totalTabs.size(); i++) {
			WebElement element = totalTabs.get(i);
			String text = totalTabs.get(i).getText();
			log.info("Tabs are ---->> " + text);

			if (text.equals("Document")) {
				element.click();
				break;
			}
		}

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,800)");

		/**
		 * Priced Bill of quantities
		 */
		formDashbordEgp1.click();
		FillUpTablesBOQ.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		CheckBoxCheck.click();

		ColumnHeaderItemNoBOQ.sendKeys("item001");
		ColumnHeaderItemNoBOQGroup.sendKeys("itemgroup001");

		// Item Code
		itemCodeBOQ.sendKeys("itemcode003");
		DescriptionofItemBOQ.sendKeys("item described properly");
		MeasurementUnitBOQ.sendKeys("1");
		QuantityBOQ.sendKeys("2");
		unitRateBOQ.sendKeys("232.213");

		// Select dropdown - I've seen
		dh.selectUsingVisibleText(iHaveSeenBOQ, "I Seen");
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		clickOn(driver, subm, 20);
		alert.acceptAlert();
		alert.acceptAlert();
		js.scrollIntoView(TenderProposalDocument);
		js.executeScript("arguments[0].click();", TenderProposalDocument);

		/*
		 * Form Name 2 - Tenderer's Quoted Price
		 */
		formDashbordBOQ.click();
		FillUpTheTables.click();

		CheckBoxCheck.click();
		ColumnHeader1.sendKeys("19601100.123");
		// ItemNo.sendKeys("2");
		// DescriptionofItem.sendKeys("sdjjsjdks");

		// MeasurementUnit.sendKeys("14");
		// rQuantity.sendKeys("2");

		// DeliveryPeriodindays.sendKeys("2");
		// formEPg1Field6.sendKeys("2");
		// formEPg1Field7.sendKeys("2");
		// formEPg1Field8.sendKeys("2");
		js.executeScript("window.scrollBy(0,800)");
		// clickOn(driver, saveforForm1, 20);

		clickOn(driver, subm, 20);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.scrollIntoView(TenderProposalDocument);
		js.executeScript("arguments[0].click();", TenderProposalDocument);
	}

	/*
	 * Document tab
	 */
	public void Document_TAB_ActivityForm_e_PW3() throws Throwable {

		// Click on Document tab
		for (int i = 0; i < totalTabs.size(); i++) {
			WebElement element = totalTabs.get(i);
			String text = totalTabs.get(i).getText();
			log.info("tabs are ---->> " + text);

			if (text.equals("Document")) {
				element.click();
				break;
			}
		}

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,800)");

		// Form Name 2 - Bill of Quantities
		formDashbordEgp1.click();
		FillUpTheTables.click();

		CheckBoxCheck.click();
		ItemNo.sendKeys("2");
		ColumnHeader.sendKeys("sdjsdsa");
		DescriptionofItem.sendKeys("sdjjsjdks");

		MeasurementUnit.sendKeys("14");
		Quantity.sendKeys("2");
		DeliveryPeriodindays.sendKeys("2");
		// formEPg1Field6.sendKeys("2");
		// formEPg1Field7.sendKeys("2");
		// formEPg1Field8.sendKeys("2");
		js.executeScript("window.scrollBy(0,800)");
		// clickOn(driver, saveforForm1, 20);

		clickOn(driver, subm, 20);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.accept();

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// clickOn(drier, locator, timeout);
		// FillUpTheTables.click();
		// js.executeScript("arguments[0].click();", TenderProposalDocument);
		TenderProposalDocument.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// Form Name 2 - Schedule of Day works
		formDashbordScheduleDayWorks.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		FillUpTablesScheduleDayWorks.click();

		checkBoxSelect.click();
		itemNo.sendKeys("78945");
		groupNo.sendKeys("testr78945");
		itemCode.sendKeys("test78950");
		descItem.sendKeys("quality product");
		measureUnit.sendKeys("Kgs");
		nominalQty.sendKeys("45578");
		clickOn(driver, saveButon, 20);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		alert1.accept();
		TenderProposalDocument.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// Form Name 2 - Discount Form
		formDashBoardDiscountForm.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		FillUpTablesScheduleDayWorks.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		checkBoxClick.click();
		clickOn(driver, saveButon, 20);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		alert2.accept();
		TenderProposalDocument.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	/**
	 * CreateWorkFlow for bidsubmission performs logout operation
	 * 
	 * @throws Throwable
	 */
	public void createWorkFlowBidSubmission() throws Throwable {
		log.info("****** inside createWorkFlowBidSubmission method ********** ");
		LogOut.click();
		// driver.navigate().refresh();
	}

	// *********************BranchChecker login
	// LOGIN********************
	public void branchCheckerLogin(String tenderIdValue) throws Throwable {
		log.info("****inside branchCheckerLogin method ********** ");
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.loginWithBranchChecker();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		Actions action = new Actions(driver);
		action.moveToElement(paymentMenuTab).build().perform();
		tenderPaymentMenuTab.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		tenderIdEle.sendKeys(tenderIdValue);

		// Method 1:
		/*
		 * 1.Iterate row and coloumn and get the cell value 2.Using for loop 3.Get total
		 * rows and iterate table 4.Put if(string matches), then select the value
		 * 5.Lengthy method
		 */

		// table[@id='list']/tbody/tr[3]/td[2]
		// .......till tr[10]
		//
		//
		// table[@id='list']/tbody/tr[10]/td[2]

		// This is for click icon
		// *[@id="resultTable"]/tbody/tr[3]/td[7]/a/img*/

		// I am splitting 2nd coloumn nothing but second td.

		// *[@id="resultTable"]/tbody/tr[
		// ]/td[2]

		String before_xpath = "//table[@id='list']/tbody/tr[";
		String after_xpath = "]/td[2]";

		for (int k = 1; k <= 10; k++) {
			log.info("***********inside for loop************");
			String name = driver.findElement(By.xpath(before_xpath + k + after_xpath)).getText();
			System.out.println(name);
			if (name.contains(tenderIdValue)) {
				System.out.println("shrikanth kulal -->> " + name);
				driver.findElement(By.xpath("//table[@id='list']/tbody/tr[" + k + "]/td[9]/a[1]")).click();
				break;
			}
		}

		// js.scrollToElementAndClick(SrchtndrBtn);
		// verifyLink.click();
		remarksComments.sendKeys("Test remarks");
		js.clickElement(buttonVerify);
		wait.setImplicitWait(15, TimeUnit.SECONDS);

		String alertTextValue = alert.getAlertText();
		System.out.println("Shrikanth alert window value is " + alertTextValue);
		alert.acceptAlert();

		String paymenttVerificationText = verification.getText(paymentVerificationText);
		System.out.println("date is ---->> " + paymenttVerificationText);
		AssertionHelper.verifyText(paymenttVerificationText, "Payment verified successfully", "text is verified");
		LogOut.click();
		// driver.navigate().refresh();
	}

	/*
	 * ********************* Tenderer login functionality
	 */
	public void egptendererLoginDevbudgetOTMMethod(String tenderIdValue) throws Throwable {
		log.info("**** inside tendererLogin method ********** ");

		// I am splitting 2nd coloumn nothing but second td.
		String before_xpath1 = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath1 = "]/td[2]";

		for (int i = 1; i <= 1; i++) {
			log.info("*********** inside for loop ************");
			String name = driver.findElement(By.xpath(before_xpath1 + i + after_xpath1)).getText();
			System.out.println(name);
			try {
				if (name.contains(tenderIdValue)) {
					System.out.println("shrikanth kulal -->> " + name);
					driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[7]/a/img")).click();
					break;
				}
			} catch (Exception e) {
				e.getMessage();
			}
			/*
			 * finally { //driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" +
			 * i + "]/td[7]/a/img")).click(); continue; }
			 */

		}
		System.out.println("Size is --->>" + totalTabs.size());
		for (int i = 0; i <= totalTabs.size(); i++) {
			WebElement element = totalTabs.get(i);
			String text = totalTabs.get(i).getText();
			System.out.println("tabs are ---->> " + text);

			if (text.equals("Docs.")) {
				element.click();
				break;
			}
		}
		// Assert.assertTrue(false);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.clickElement(agreeButton);

		String declarationVerificationText1 = verification.getText(declarationVerificationText);
		System.out.println("date is ---->> " + declarationVerificationText1);
		AssertionHelper.verifyText(declarationVerificationText1, "Declaration completed successfully",
				"text is verified");

		for (int i = 0; i < totalTabs.size(); i++) {
			WebElement element = totalTabs.get(i);
			String text = totalTabs.get(i).getText();
			System.out.println("tabs are ---->> " + text);

			if (text.equals("Tend. Preparation")) {
				element.click();
				break;
			}
		}
		// Assert.assertTrue(false);
		// e-Tender Submission Letter (Form e-PW2-1)
		// I am splitting 2nd coloumn nothing but second td.
		String before_xpath = "//*[@id='tblMain']/tbody/tr[";
		String after_xpath = "]/td[2]/a";

		for (int i = 2; i <= 9; i++) {
			log.info("*********** Fill -- inside for loop ************");

			if (i == 2) {
				log.info("*********** Fill1 -- i==2  if loop ************");
				// driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td[7]/a/img")).click();
				driver.findElement(By.xpath("//*[@id='tblMain']/tbody/tr[" + i + "]/td[2]/a")).click();

				js.scrollIntoView(signButton);
				// signButton.click();
				wait.WaitForElementVisibleWithPollingTime(signButton, 30, 3);
				js.clickElement(signButton);
				// wait element for password
				wait.WaitForElementVisibleWithPollingTime(password, 30, 3);
				TestUtil.sendKeys(driver, password, 100, "egp12345");
				Thread.sleep(500);
				// wait element for password
				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 3);
				js.clickElement(verifyPassword);
				Thread.sleep(500);
				
				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 3);
				js.clickElement(encryptSaveButton);
				Thread.sleep(500);

				wait.WaitForElementVisibleWithPollingTime(saveButton, 30, 3);
				// TestUtil.clickOn(driver, saveButton, 100);
				js.clickElement(saveButton);
				Thread.sleep(500);

				// Verification text
				String formSaved = verification.getText(fillSave1);
				AssertionHelper.verifyText(formSaved, "Form saved successfully", "text is verified");

				/**
				 * Encrypt link script - Encrypt link1 Click on Encrypt linkdecryptButton
				 */
				wait.WaitForElementVisibleWithPollingTime(encrypt1, 30, 5);
				js.clickElement(encrypt1);
				Thread.sleep(500);

				js.scrollIntoView(decryptButton);
				wait.WaitForElementVisibleWithPollingTime(decryptButton, 30, 5);
				// TestUtil.clickOn(driver, decryptButton, 50);
				js.clickElement(decryptButton);
				Thread.sleep(500);

				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");
				// TestUtil.clickOn(driver, verifyPassword, 50);
				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				js.clickElement(verifyPassword);
				Thread.sleep(500);
				
				//TestUtil.clickOn(driver, encryptSaveButton, 50);
				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				js.clickElement(encryptSaveButton);
				Thread.sleep(500);
				// TestUtil.clickOn(driver, oKButton, 50);
				wait.WaitForElementVisibleWithPollingTime(oKButton, 30, 5);
				js.clickElement(oKButton);
				Thread.sleep(500);
				// break;
			} else if (i == 3) {
				log.info("***********Fill2 -- i==3  if loop************");
				// Tenderer Information Form (e-PW2-2)
				driver.findElement(By.xpath("//*[@id='tblMain']/tbody/tr[" + i + "]/td[2]/a")).click();

				// Tenderer Information Form (Part-1)
				wait.WaitForElementVisibleWithPollingTime(nameOfTenderer, 30, 3);
				TestUtil.sendKeys(driver, nameOfTenderer, 100, "test123shrikulal");
				Thread.sleep(500);
				wait.WaitForElementVisibleWithPollingTime(regEmailId, 30, 3);
				TestUtil.sendKeys(driver, regEmailId, 100, "test123regmailId");
				Thread.sleep(500);

				// First row checkbox data enter
				wait.WaitForElementVisibleWithPollingTime(checkBox1, 30, 3);
				TestUtil.clickOn(driver, checkBox1, 100);
				Thread.sleep(200);
				wait.WaitForElementVisibleWithPollingTime(contractNo, 30, 3);
				TestUtil.sendKeys(driver, contractNo, 100, "123564");
				Thread.sleep(500);
				
				wait.WaitForElementVisibleWithPollingTime(sourceOfFinanceNew, 30, 3);
				TestUtil.sendKeys(driver, sourceOfFinanceNew, 100, "sourceOfFinance");
				Thread.sleep(500);
				
//				wait.WaitForElementVisibleWithPollingTime(nameOfContract, 30, 3);
//				TestUtil.sendKeys(driver, nameOfContract, 100, "nameofcontract");
//				Thread.sleep(500);

				wait.WaitForElementVisibleWithPollingTime(awardDate, 30, 3);
				TestUtil.sendKeys(driver, awardDate, 100, "testawarddate");

				wait.WaitForElementVisibleWithPollingTime(completionDate, 30, 3);
				TestUtil.sendKeys(driver, completionDate, 100, "testcompletiondate");

				wait.WaitForElementVisibleWithPollingTime(totalContractValue, 30, 3);
				TestUtil.sendKeys(driver, totalContractValue, 100, "200000");

				wait.WaitForElementVisibleWithPollingTime(procEntityName, 30, 3);
				TestUtil.sendKeys(driver, procEntityName, 100, "testprocEntit");

				wait.WaitForElementVisibleWithPollingTime(procEntityAddress, 30, 3);
				TestUtil.sendKeys(driver, procEntityAddress, 100, "testprocEntdress");

				wait.WaitForElementVisibleWithPollingTime(procEntityFax, 30, 3);
				TestUtil.sendKeys(driver, procEntityFax, 100, "testprocEntityFax");

				wait.WaitForElementVisibleWithPollingTime(procEntityEmail, 30, 3);
				TestUtil.sendKeys(driver, procEntityEmail, 100, "testprocEnyEmail");

				wait.WaitForElementVisibleWithPollingTime(pERequirement, 30, 3);
				TestUtil.sendKeys(driver, pERequirement, 100, "testprocEtyReq");

				// Second row checkbox data enter
				wait.WaitForElementVisibleWithPollingTime(checkBox2, 30, 3);
				TestUtil.clickOn(driver, checkBox2, 100);

				wait.WaitForElementVisibleWithPollingTime(financialYear, 30, 3);
				TestUtil.sendKeys(driver, financialYear, 100, "2019");

				// Amount in BDT - Bidder Value
				wait.WaitForElementVisibleWithPollingTime(amntInBDT, 30, 3);
				TestUtil.sendKeys(driver, amntInBDT, 100, "20000.199");

				// Third row checkbox data enter
				wait.WaitForElementVisibleWithPollingTime(checkBox3, 30, 3);
				TestUtil.clickOn(driver, checkBox3, 100);

				wait.WaitForElementVisibleWithPollingTime(No, 30, 3);
				TestUtil.sendKeys(driver, No, 100, "2019");

				wait.WaitForElementVisibleWithPollingTime(sourceOfFinance, 30, 3);
				TestUtil.sendKeys(driver, sourceOfFinance, 100, "sourceOfFinance");

				wait.WaitForElementVisibleWithPollingTime(amntAvailable, 30, 3);
				TestUtil.sendKeys(driver, amntAvailable, 100, "20000.199");

				// Fourth row checkbox data enter
				wait.WaitForElementVisibleWithPollingTime(checkBox4, 30, 3);
				TestUtil.clickOn(driver, checkBox4, 100);

				wait.WaitForElementVisibleWithPollingTime(nameAddressOtherContact, 30, 3);
				TestUtil.sendKeys(driver, nameAddressOtherContact, 100, "nameAddresContact");

				// click on Sign button
				wait.WaitForElementVisibleWithPollingTime(signButton, 30, 5);
				js.clickElement(signButton);

				// Encrypt scripts
				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");

				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				TestUtil.clickOn(driver, verifyPassword, 100);

				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				TestUtil.clickOn(driver, encryptSaveButton, 100);
				// TestUtil.clickOn(driver, saveButton, 50);
				wait.WaitForElementVisibleWithPollingTime(saveButton, 30, 5);
				js.clickElement(saveButton);

				// Verification text
				String formSaved = verification.getText(fillSave1);
				AssertionHelper.verifyText(formSaved, "Form saved successfully", "text is verified");

				// Encrypt scripts
				// Click on Encrypt link2
				wait.WaitForElementVisibleWithPollingTime(encrypt2, 30, 5);
				TestUtil.clickOn(driver, encrypt2, 100);

				js.scrollIntoView(decryptButton);
				wait.WaitForElementVisibleWithPollingTime(decryptButton, 30, 5);
				TestUtil.clickOn(driver, decryptButton, 100);

				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");

				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				TestUtil.clickOn(driver, verifyPassword, 100);

				// TestUtil.clickOn(driver, encryptSaveButton, 50);
				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				js.clickElement(encryptSaveButton);
				wait.WaitForElementVisibleWithPollingTime(oKButton, 30, 5);
				js.clickElement(oKButton);
				// TestUtil.clickOn(driver, oKButton, 50);
				// Assert.assertTrue(false);
			} else if (i == 4) {
				log.info("***********Fill3 -- i==4  if loop************");
				System.out.println("********shrikanthgss");
				driver.findElement(By.xpath("//*[@id='tblMain']/tbody/tr[" + i + "]/td[2]/a")).click();
				// select check box
				wait.WaitForElementVisibleWithPollingTime(selectCheckBox, 30, 5);
				TestUtil.clickOn(driver, selectCheckBox, 100);

				wait.WaitForElementVisibleWithPollingTime(serialNo, 30, 5);
				TestUtil.sendKeys(driver, serialNo, 100, "serialNo12345");

				wait.WaitForElementVisibleWithPollingTime(nameOfWorks, 30, 5);
				TestUtil.sendKeys(driver, nameOfWorks, 100, "nameOfWorkstender");

				wait.WaitForElementVisibleWithPollingTime(valueOfWorks, 30, 5);
				TestUtil.sendKeys(driver, valueOfWorks, 100, "1001.101");

				wait.WaitForElementVisibleWithPollingTime(dateOfActualCompletion, 30, 5);
				// String pastDate = TestUtil.getPastDate();
				TestBase.selectDateByJs(driver, dateOfActualCompletion, TestUtil.getPastDate());

				// Click on map documents link
				wait.WaitForElementVisibleWithPollingTime(mapDocuments, 30, 5);
				TestUtil.clickOn(driver, mapDocuments, 100);

				// Moved to "Map from Document Library" window page
				// WindowHandling
				/*
				 * WindowHelper wh = new WindowHelper(driver); wh.switchToChildWindow(1);
				 */
				String Parent_Window = driver.getWindowHandle();
				for (String handle : driver.getWindowHandles()) {
					driver.switchTo().window(handle);
				}

				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\100bx.txt");

				// Enter Description
				wait.WaitForElementVisibleWithPollingTime(descriptionTextField, 30, 5);
				TestUtil.sendKeys(driver, descriptionTextField, 100, "serialNo12345");

				wait.WaitForElementVisibleWithPollingTime(Submit, 30, 5);
				js.clickElement(Submit);
				Thread.sleep(50);
				String uploadMesg = verification.getText(uploadMsg);
				System.out.println("text fillSave1 is ---->> " + uploadMesg);
				AssertionHelper.verifyText(uploadMesg, "Document Uploaded and Mapped Successfully.",
						"text is verified");

				// Close child windows and move to parent window
				// wh.closeAllTabsAndSwitchToMainWindow();

				driver.close();
				driver.switchTo().window(Parent_Window);
				driver.switchTo().defaultContent();

				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				// wh.switchToParentWindow();

				// click on Sign button
				wait.WaitForElementVisibleWithPollingTime(signButton, 30, 5);
				js.clickElement(signButton);

				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");

				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				js.clickElement(verifyPassword);

				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				js.clickElement(encryptSaveButton);

				wait.WaitForElementVisibleWithPollingTime(saveButton, 30, 5);
				js.clickElement(saveButton);
				// TestUtil.clickOn(driver, verifyPassword, 50);
				// TestUtil.clickOn(driver, encryptSaveButton, 50);
				// TestUtil.clickOn(driver, saveButton, 50);

				// Encrypt scripts
				// Click on Encrypt link3
				wait.WaitForElementVisibleWithPollingTime(encrypt3, 30, 5);
				TestUtil.clickOn(driver, encrypt3, 100);

				js.scrollIntoView(decryptButton);
				wait.WaitForElementVisibleWithPollingTime(decryptButton, 30, 5);
				TestUtil.clickOn(driver, decryptButton, 100);

				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");

				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				TestUtil.clickOn(driver, verifyPassword, 100);

				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				TestUtil.clickOn(driver, encryptSaveButton, 100);

				wait.WaitForElementVisibleWithPollingTime(oKButton, 30, 5);
				TestUtil.clickOn(driver, oKButton, 100);
			} else if (i == 5) {
				log.info("***********Fill5 -- i==5  if loop************");
				driver.findElement(By.xpath("//*[@id='tblMain']/tbody/tr[" + i + "]/td[2]/a")).click();
				// select check box
				wait.WaitForElementVisibleWithPollingTime(selectCheckBox, 30, 5);
				TestUtil.clickOn(driver, selectCheckBox, 100);

				wait.WaitForElementVisibleWithPollingTime(serialNo, 30, 5);
				TestUtil.sendKeys(driver, serialNo, 100, "serialNo12345");

				wait.WaitForElementVisibleWithPollingTime(nameOfWorks, 30, 5);
				TestUtil.sendKeys(driver, nameOfWorks, 100, "works");

				wait.WaitForElementVisibleWithPollingTime(valueOfWorks, 30, 5);
				TestUtil.sendKeys(driver, valueOfWorks, 100, "200000");

				wait.WaitForElementVisibleWithPollingTime(dateOfActualCompletion, 30, 5);

				TestBase.selectDateByJs(driver, dateOfActualCompletion, TestUtil.getCurrentDate());

				wait.WaitForElementVisibleWithPollingTime(nameOfPEOrgn, 30, 5);
				TestUtil.sendKeys(driver, nameOfPEOrgn, 100, "test pe");

				// Click on map documents link
				wait.WaitForElementVisibleWithPollingTime(mapDocuments, 30, 5);
				TestUtil.clickOn(driver, mapDocuments, 100);

				// Moved to "Map from Document Library" window page
				// WindowHandling
				/*
				 * WindowHelper wh = new WindowHelper(driver); wh.switchToChildWindow(1);
				 */
				String Parent_Window = driver.getWindowHandle();
				for (String handle : driver.getWindowHandles()) {
					driver.switchTo().window(handle);
				}

				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\200bx.txt");

				// Enter Description
				wait.WaitForElementVisibleWithPollingTime(descriptionTextField, 30, 5);
				TestUtil.sendKeys(driver, descriptionTextField, 100, "serialNo12345");
				wait.WaitForElementVisibleWithPollingTime(Submit, 30, 5);
				js.clickElement(Submit);

				String uploadMesg = verification.getText(uploadMsg);
				System.out.println("text fillSave1 is ---->> " + uploadMesg);
				AssertionHelper.verifyText(uploadMesg, "Document Uploaded and Mapped Successfully.",
						"text is verified");

				// Close child windows and move to parent window
				// wh.closeAllTabsAndSwitchToMainWindow();

				driver.close();
				driver.switchTo().window(Parent_Window);
				driver.switchTo().defaultContent();

				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				// wh.switchToParentWindow();

				// click on Sign button
				wait.WaitForElementVisibleWithPollingTime(signButton, 30, 5);
				js.clickElement(signButton);

				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");

				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				TestUtil.clickOn(driver, verifyPassword, 100);

				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				TestUtil.clickOn(driver, encryptSaveButton, 100);

				wait.WaitForElementVisibleWithPollingTime(saveButton, 30, 5);
				js.clickElement(saveButton);
				// TestUtil.clickOn(driver, saveButton, 50);

				// Encrypt scripts
				// Click on Encrypt link3
				wait.WaitForElementVisibleWithPollingTime(encrypt4, 30, 5);
				TestUtil.clickOn(driver, encrypt4, 100);

				js.scrollIntoView(decryptButton);
				wait.WaitForElementVisibleWithPollingTime(decryptButton, 30, 5);
				TestUtil.clickOn(driver, decryptButton, 100);

				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");

				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				TestUtil.clickOn(driver, verifyPassword, 100);

				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				TestUtil.clickOn(driver, encryptSaveButton, 100);

				wait.WaitForElementVisibleWithPollingTime(oKButton, 30, 5);
				TestUtil.clickOn(driver, oKButton, 100);
			} else if (i == 9) {
				log.info("*********** Fill9 -- i==9  if loop************");
				// click on Fill link
				// Section 6. Bill of Quantities - *Bidder Value - official estimate cost(excel
				// value)%2= 400062.888
				driver.findElement(By.xpath("//*[@id='tblMain']/tbody/tr[" + i + "]/td[2]/a")).click();
				// enter unit price
				wait.WaitForElementVisibleWithPollingTime(unitPrice, 30, 3);
				// Bidder Value - official estimate cost(excel value)%2= 400062.888
				TestUtil.sendKeys(driver, unitPrice, 100, "400062.888");

				// click on Sign button
				wait.WaitForElementVisibleWithPollingTime(signButton, 30, 5);
				js.clickElement(signButton);

				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");

				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				TestUtil.clickOn(driver, verifyPassword, 100);

				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				TestUtil.clickOn(driver, encryptSaveButton, 100);

				wait.WaitForElementVisibleWithPollingTime(saveButton, 30, 5);
				TestUtil.clickOn(driver, saveButton, 100);

				// Encrypt scripts
				// Click on Encrypt link3
				wait.WaitForElementVisibleWithPollingTime(encrypt5, 30, 5);
				TestUtil.clickOn(driver, encrypt5, 100);

				js.scrollIntoView(decryptButton);
				wait.WaitForElementVisibleWithPollingTime(decryptButton, 30, 5);
				TestUtil.clickOn(driver, decryptButton, 100);

				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");

				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				TestUtil.clickOn(driver, verifyPassword, 100);

				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				TestUtil.clickOn(driver, encryptSaveButton, 100);

				wait.WaitForElementVisibleWithPollingTime(oKButton, 30, 5);
				TestUtil.clickOn(driver, oKButton, 100);
			}
		}

		// Handling map links - total 3 Map links
		for (int j = 1; j <= 3; j++) {

			// click on map1 link
			if (j == 1) {
				TestUtil.clickOn(driver, map1, 100);

				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\300bx.txt");

				// Select document type
				dh.selectUsingVisibleText(docType1, "Authorization Letter to submit Tender on behalf of Tenderer");
				wait.setImplicitWait(100, TimeUnit.SECONDS);

				js.scrollIntoView(docType2);
				dh.selectUsingVisibleText(docType2, "Authorization Letter to submit Tender on behalf of Tenderer");
				js.scrollIntoView(descriptionTextField);
				TestUtil.sendKeys(driver, descriptionTextField, 10, "testDescx");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);

				log.info("***National ID of authorised person****");
				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\400bx.txt");

				// Select document type
				dh.selectUsingVisibleText(docType1, "National ID of Authorised Person");
				wait.setImplicitWait(50, TimeUnit.SECONDS);

				js.scrollIntoView(docType2);
				dh.selectUsingVisibleText(docType2, "National ID of Authorised Person");
				js.scrollIntoView(descriptionTextField);
				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDescxy");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);

				wait.setImplicitWait(100, TimeUnit.SECONDS);

				js.clickElement(goBackToDashBoard);
				wait.setImplicitWait(100, TimeUnit.SECONDS);
			} else if (j == 2) {
				log.info("***National ID of authorised person 1****");

				TestUtil.clickOn(driver, map2, 100);
				wait.setImplicitWait(100, TimeUnit.SECONDS);

				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\111bx.txt");

				// Select document type
				dh.selectUsingVisibleText(docType1, "Valid Trade License");
				wait.setImplicitWait(100, TimeUnit.SECONDS);

				js.scrollIntoView(docType2);
				dh.selectUsingVisibleText(docType2, "Valid Trade License");
				js.scrollIntoView(descriptionTextField);
				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc101");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);

				log.info("*** Valid TIN Certificate 2 ****");
				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\112bx.txt");

				// Select document type
				dh.selectUsingVisibleText(docType1, "Valid TIN Certificate");
				wait.setImplicitWait(100, TimeUnit.SECONDS);

				js.scrollIntoView(docType2);
				dh.selectUsingVisibleText(docType2, "Valid TIN Certificate");
				js.scrollIntoView(descriptionTextField);
				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc102");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);

				log.info("*** VAT Registration Certificate 3 ****");
				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\113bx.txt");

				// Select document type
				dh.selectUsingVisibleText(docType1, "VAT Registration Certificate");
				wait.setImplicitWait(100, TimeUnit.SECONDS);

				js.scrollIntoView(docType2);
				dh.selectUsingVisibleText(docType2, "VAT Registration Certificate");
				js.scrollIntoView(descriptionTextField);
				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc103");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);

				log.info("*** Documentary evidence of Average Annual Construction Turnover 4 ****");
				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\114bx.txt");

				// Select document type
				dh.selectUsingVisibleText(docType1, "Documentary evidence of Average Annual Construction Turnover");
				wait.setImplicitWait(100, TimeUnit.SECONDS);

				js.scrollIntoView(docType2);
				dh.selectUsingVisibleText(docType2, "Documentary evidence of Average Annual Construction Turnover");
				js.scrollIntoView(descriptionTextField);
				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc104");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);

				log.info("*** Documentary evidence  of liquid assets 5 ****");
				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\115bx.txt");

				// Select document type
				dh.selectUsingVisibleText(docType1, "Documentary evidence  of liquid assets");
				wait.setImplicitWait(100, TimeUnit.SECONDS);

				js.scrollIntoView(docType2);
				dh.selectUsingVisibleText(docType2, "Documentary evidence  of liquid assets");
				js.scrollIntoView(descriptionTextField);
				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc105");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);

				log.info("*** Documentary evidence of Specific Experience 6 ****");
				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\116bx.txt");

				// Select document type
				dh.selectUsingVisibleText(docType1, "Documentary evidence of Specific Experience");
				wait.setImplicitWait(100, TimeUnit.SECONDS);

				js.scrollIntoView(docType2);
				dh.selectUsingVisibleText(docType2, "Documentary evidence of Specific Experience");
				js.scrollIntoView(descriptionTextField);
				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc106");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);
				js.clickElement(goBackToDashBoard);
				wait.setImplicitWait(100, TimeUnit.SECONDS);
			} else if (j == 3) {
				log.info("***click on map3 ***");
				TestUtil.clickOn(driver, map3, 100);
				wait.setImplicitWait(100, TimeUnit.SECONDS);
				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\117bx.txt");

				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc107");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				js.clickElement(goBackToDashBoard);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

				// Verify text
				String tenderSecurityPaymentText1 = verification.getText(tenderSecurityPaymentText);
				System.out.println("date is ---->> " + tenderSecurityPaymentText1);
				AssertionHelper.verifyText(tenderSecurityPaymentText1, "Tender Security Payment is Pending",
						"text is verified");
				LogOut.click();
			}
		}
	}

	/*
	 * ********** bidParticipateDevbudgetLTMMethod_EPW2B- Tenderer login
	 * functionality
	 */
	public void bidParticipateDevbudgetLTMMethod_EPW2B(String tenderIdValue) throws Throwable {
		log.info("**** inside bidParticipate DevbudgetLTMMethod_EPW2B method **********");

		//I am splitting 2nd coloumn nothing but second td.
		String before_xpath1 = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath1 = "]/td[2]";

		/*
		 * for (int i = 1; i <= 10; i++) {
		 * log.info("*********** inside for loop ************"); String name =
		 * driver.findElement(By.xpath(before_xpath1 + i + after_xpath1)).getText();
		 * System.out.println(name); try { if (name.contains(tenderIdValue)) {
		 * System.out.println("shrikanth kulal -->> " + name);
		 * driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +
		 * "]/td[7]/a/img")).click(); break; } } catch (Exception e) { e.getMessage(); }
		 * }
		 */

		for (int i = 0; i <= totalTabs.size(); i++) {
			WebElement element = totalTabs.get(i);
			String text = totalTabs.get(i).getText();
			System.out.println("tabs are ---->> " + text);

			if (text.equals("Docs.")) {
				element.click();
				break;
			}
		}
		Assert.assertTrue(true);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.clickElement(agreeButton);

		String declarationVerificationText1 = verification.getText(declarationVerificationText);
		System.out.println("date is ---->> " + declarationVerificationText1);
		AssertionHelper.verifyText(declarationVerificationText1, "Declaration completed successfully",
				"text is verified");

		for (int i = 0; i < totalTabs.size(); i++) {
			WebElement element = totalTabs.get(i);
			String text = totalTabs.get(i).getText();
			System.out.println("tabs are ---->> " + text);

			if (text.equals("Tend. Preparation")) {
				element.click();
				break;
			}
		}
		// e-Tender Submission Letter (Form e-PW2-1)
		// I am splitting 2nd coloumn nothing but second td.
		String before_xpath = "//*[@id='tblMain']/tbody/tr[";
		String after_xpath = "]/td[2]/a";

		for (int i = 2; i <= 9; i++) {
			log.info("*********** Fill -- inside for loop ************");
			if (i == 2) {
				// e-Tender Submission Letter (Form e-PW2-1)
				log.info("*********** Fill1 -- i==2  if loop ************");
				wait.WaitForElementVisibleWithPollingTime(driver.findElement(By.xpath("//*[@id='tblMain']/tbody/tr[" + i + "]/td[2]/a")), 500, 3);
				// Click on Fill link -->> e-Tender Submission Letter (Form e-PW2-1) *
				driver.findElement(By.xpath("//*[@id='tblMain']/tbody/tr[" + i + "]/td[2]/a")).click();
				
				Thread.sleep(500);
				js.scrollIntoView(signButton);
				// signButton.click();
				wait.WaitForElementVisibleWithPollingTime(signButton, 30, 3);
				js.clickElement(signButton);
				// wait element for password
				wait.WaitForElementVisibleWithPollingTime(password, 30, 3);
				TestUtil.sendKeys(driver, password, 100, "egp12345");

				// wait element for password
				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 3);
				js.clickElement(verifyPassword);
				Thread.sleep(500);
				
				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 3);
				js.clickElement(encryptSaveButton);
				Thread.sleep(500);
				
				wait.WaitForElementVisibleWithPollingTime(saveButton, 30, 3);
				// TestUtil.clickOn(driver, saveButton, 100);
				js.clickElement(saveButton);

				// Verification text
				String formSaved = verification.getText(fillSave1);
				AssertionHelper.verifyText(formSaved, "Form saved successfully", "text is verified");
				Thread.sleep(500);
				/**
				 * Encrypt link script - Encrypt link1 Click on Encrypt linkdecryptButton
				 */
				wait.WaitForElementVisibleWithPollingTime(encrypt1, 30, 5);
				js.clickElement(encrypt1);

				js.scrollIntoView(decryptButton);
				wait.WaitForElementVisibleWithPollingTime(decryptButton, 30, 5);
				// TestUtil.clickOn(driver, decryptButton, 50);
				js.clickElement(decryptButton);

				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");
				// TestUtil.clickOn(driver, verifyPassword, 50);
				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				js.clickElement(verifyPassword);
				// TestUtil.clickOn(driver, encryptSaveButton, 50);
				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				js.clickElement(encryptSaveButton);
				// TestUtil.clickOn(driver, oKButton, 50);
				wait.WaitForElementVisibleWithPollingTime(oKButton, 30, 5);
				js.clickElement(oKButton);
				// break;
			} else if (i == 3) {
				log.info("***********Fill2 -- i==3  if loop************");
				// Fill click -->> Tenderer Information Form (e-PW2-2)
				driver.findElement(By.xpath("//*[@id='tblMain']/tbody/tr[" + i + "]/td[2]/a")).click();

				// Tenderer Information Form (Part-1)
				wait.WaitForElementVisibleWithPollingTime(nameOfTenderer, 30, 3);
				TestUtil.sendKeys(driver, nameOfTenderer, 100, "egptenderer2");
				wait.WaitForElementVisibleWithPollingTime(regEmailId, 30, 3);
				TestUtil.sendKeys(driver, regEmailId, 100, "egptenderer2@gmail.com");

				// First row checkbox data enter
				wait.WaitForElementVisibleWithPollingTime(checkBox1, 30, 3);
				TestUtil.clickOn(driver, checkBox1, 100);
				wait.WaitForElementVisibleWithPollingTime(contractNo, 30, 3);
				TestUtil.sendKeys(driver, contractNo, 100, "9658486329");

				wait.WaitForElementVisibleWithPollingTime(sourceOfFinanceNew, 30, 3);
				TestUtil.sendKeys(driver, sourceOfFinanceNew, 100, "source of finance");

				wait.WaitForElementVisibleWithPollingTime(AmntAvailableNew, 30, 3);
				TestUtil.sendKeys(driver, AmntAvailableNew, 100, "1250090");

				/////////////////
				wait.WaitForElementVisibleWithPollingTime(checkBoxNew, 30, 3);
				TestUtil.clickOn(driver, checkBoxNew, 100);

				wait.WaitForElementVisibleWithPollingTime(typeOfEquipment, 30, 3);
				TestUtil.sendKeys(driver, typeOfEquipment, 100, "typeofrequirement");
				Thread.sleep(500);

				wait.WaitForElementVisibleWithPollingTime(noAvailable, 30, 3);
				TestUtil.sendKeys(driver, noAvailable, 100, "9625483219");
				Thread.sleep(500);

				wait.WaitForElementVisibleWithPollingTime(ownedLeased, 30, 3);
				TestUtil.sendKeys(driver, ownedLeased, 100, "testLeased");

				// selectCheckBoxListKey
				wait.WaitForElementVisibleWithPollingTime(selectCheckBoxListKey, 30, 3);
				TestUtil.clickOn(driver, selectCheckBoxListKey, 100);
				Thread.sleep(500);

				wait.WaitForElementVisibleWithPollingTime(serialNoListKey, 30, 3);
				TestUtil.sendKeys(driver, serialNoListKey, 100, "9958268758");
				Thread.sleep(500);

				wait.WaitForElementVisibleWithPollingTime(positionListKey, 30, 3);
				TestUtil.sendKeys(driver, positionListKey, 100, "testpositionListKey");
				Thread.sleep(500);

				wait.WaitForElementVisibleWithPollingTime(nameListKey, 30, 3);
				TestUtil.sendKeys(driver, nameListKey, 100, "nameListKey");
				Thread.sleep(500);

				wait.WaitForElementVisibleWithPollingTime(qualificationListKey, 30, 3);
				TestUtil.sendKeys(driver, qualificationListKey, 100, "qualificationListKey");
				Thread.sleep(500);

				wait.WaitForElementVisibleWithPollingTime(experienceListKey, 30, 3);
				TestUtil.sendKeys(driver, experienceListKey, 100, "experienceListKey");
				Thread.sleep(500);

				// click on Sign button
				wait.WaitForElementVisibleWithPollingTime(signButton, 30, 5);
				js.clickElement(signButton);

				// Encrypt scripts
				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");
				Thread.sleep(500);

				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				TestUtil.clickOn(driver, verifyPassword, 100);

				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				TestUtil.clickOn(driver, encryptSaveButton, 100);
				// TestUtil.clickOn(driver, saveButton, 50);
				wait.WaitForElementVisibleWithPollingTime(saveButton, 30, 5);
				js.clickElement(saveButton);

				// Verification text
				String formSaved = verification.getText(fillSave1);
				AssertionHelper.verifyText(formSaved, "Form saved successfully", "text is verified");

				// Encrypt scripts
				// Click on Encrypt link2
				wait.WaitForElementVisibleWithPollingTime(encrypt2, 30, 5);
				TestUtil.clickOn(driver, encrypt2, 100);

				js.scrollIntoView(decryptButton);
				wait.WaitForElementVisibleWithPollingTime(decryptButton, 30, 5);
				TestUtil.clickOn(driver, decryptButton, 100);

				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");
				Thread.sleep(500);

				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				TestUtil.clickOn(driver, verifyPassword, 100);

				// TestUtil.clickOn(driver, encryptSaveButton, 50);
				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				js.clickElement(encryptSaveButton);
				wait.WaitForElementVisibleWithPollingTime(oKButton, 30, 5);
				js.clickElement(oKButton);
				// TestUtil.clickOn(driver, oKButton, 50);
				// Assert.assertTrue(false);
			} else if (i == 7) {
				/**
				 * Priced Bill of Quantities (BOQ)
				 */
				log.info("***********Fill3 -- i==7  if loop************");
				System.out.println("********shrikanthgss******************");
				// Tenderer's Quoted Price * --->> click Fill
				driver.findElement(By.xpath("//*[@id='tblMain']/tbody/tr[" + i + "]/td[2]/a")).click();

				Thread.sleep(500);
				dh.selectUsingVisibleText(selectYes, "Yes");
				Thread.sleep(500);

				// Click on Sign button
				wait.WaitForElementVisibleWithPollingTime(signButton, 30, 5);
				js.clickElement(signButton);
				Thread.sleep(500);

				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");
				Thread.sleep(500);

				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				TestUtil.clickOn(driver, verifyPassword, 100);
				Thread.sleep(500);

				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				TestUtil.clickOn(driver, encryptSaveButton, 100);
				Thread.sleep(1000);
				
				wait.WaitForElementVisibleWithPollingTime(saveButton, 30, 5);
				js.clickElement(saveButton);
				Thread.sleep(1000);
				// TestUtil.clickOn(driver, saveButton, 50);

				// Encrypt scripts
				// Click on Encrypt link3
				wait.WaitForElementVisibleWithPollingTime(encryptLink1, 30, 5);
				TestUtil.clickOn(driver, encryptLink1, 100);
				Thread.sleep(1000);
				js.scrollIntoView(decryptButton);
				wait.WaitForElementVisibleWithPollingTime(decryptButton, 30, 5);
				TestUtil.clickOn(driver, decryptButton, 100);
				Thread.sleep(1000);

				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");
				Thread.sleep(1000);
				
				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				TestUtil.clickOn(driver, verifyPassword, 100);
				Thread.sleep(1000);
				
				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				TestUtil.clickOn(driver, encryptSaveButton, 100);
				Thread.sleep(1000);
				
				wait.WaitForElementVisibleWithPollingTime(oKButton, 30, 5);
				TestUtil.clickOn(driver, oKButton, 100);
			} else if (i == 8) {
				log.info("***********Fill8 -- i==8  if loop************");
				// Tenderer's Quoted Price * Need to work with i=8
				driver.findElement(By.xpath("//*[@id='tblMain']/tbody/tr[" + i + "]/td[2]/a")).click();
				// select check box
				wait.WaitForElementVisibleWithPollingTime(percentageTextBox, 30, 5);
				TestUtil.sendKeys(driver, percentageTextBox, 100, "0"); // 5% of Official cost
				Thread.sleep(1000);
				
				// click on Sign button
				wait.WaitForElementVisibleWithPollingTime(signButton, 30, 5);
				js.clickElement(signButton);
				Thread.sleep(1000);

				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");
				Thread.sleep(1000);
				
				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				js.clickElement(verifyPassword);
				Thread.sleep(1000);

				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				js.clickElement(encryptSaveButton);
				Thread.sleep(1000);
				
				wait.WaitForElementVisibleWithPollingTime(saveButton, 30, 5);
				js.clickElement(saveButton);
				// TestUtil.clickOn(driver, verifyPassword, 50);
				// TestUtil.clickOn(driver, encryptSaveButton, 50);
				// TestUtil.clickOn(driver, saveButton, 50);

				// Encrypt scripts
				// Click on Encrypt link3
				wait.WaitForElementVisibleWithPollingTime(encrypt7Dup1, 30, 5);
				TestUtil.clickOn(driver, encrypt7Dup, 100);
				Thread.sleep(1000);
				
				js.scrollIntoView(decryptButton);
				wait.WaitForElementVisibleWithPollingTime(decryptButton, 30, 5);
				TestUtil.clickOn(driver, decryptButton, 100);
				Thread.sleep(1000);

				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");
				Thread.sleep(1000);
				
				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				TestUtil.clickOn(driver, verifyPassword, 100);
				Thread.sleep(1000);
				
				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				TestUtil.clickOn(driver, encryptSaveButton, 100);
				Thread.sleep(1000);
				
				wait.WaitForElementVisibleWithPollingTime(oKButton, 30, 5);
				TestUtil.clickOn(driver, oKButton, 100);
			}
		}
		Assert.assertTrue(true);
		// Handling map links - total 3 Map links
		/*
		 * for (int j = 1; j <= 3; j++) {
		 * 
		 * // click on map1 link if (j == 1) { TestUtil.clickOn(driver, map1, 100);
		 * 
		 * // Upload files driver.findElement(By.xpath("//*[@id='fileUpload']"))
		 * .sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\42d2xa.txt");
		 * 
		 * // Select document type dh.selectUsingVisibleText(docType1,
		 * "Authorization Letter to submit Tender on behalf of Tenderer");
		 * wait.setImplicitWait(100, TimeUnit.SECONDS);
		 * 
		 * js.scrollIntoView(docType2); dh.selectUsingVisibleText(docType2,
		 * "Authorization Letter to submit Tender on behalf of Tenderer");
		 * js.scrollIntoView(descriptionTextField); TestUtil.sendKeys(driver,
		 * descriptionTextField, 10, "testDescx"); // TestUtil.clickOn(driver, Submit,
		 * 50); js.clickElement(Submit);
		 * 
		 * log.info("***National ID of authorised person****"); // Upload files
		 * driver.findElement(By.xpath("//*[@id='fileUpload']"))
		 * .sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\200d1x2a.txt");
		 * 
		 * // Select document type dh.selectUsingVisibleText(docType1,
		 * "National ID of Authorised Person"); wait.setImplicitWait(50,
		 * TimeUnit.SECONDS);
		 * 
		 * js.scrollIntoView(docType2); dh.selectUsingVisibleText(docType2,
		 * "National ID of Authorised Person"); js.scrollIntoView(descriptionTextField);
		 * TestUtil.sendKeys(driver, descriptionTextField, 100, "testDescxy"); //
		 * TestUtil.clickOn(driver, Submit, 50); js.clickElement(Submit);
		 * 
		 * wait.setImplicitWait(100, TimeUnit.SECONDS);
		 * 
		 * js.clickElement(goBackToDashBoard); wait.setImplicitWait(100,
		 * TimeUnit.SECONDS); } else if (j == 2) { log.info("*******map2*******");
		 * 
		 * TestUtil.clickOn(driver, map2, 100); wait.setImplicitWait(100,
		 * TimeUnit.SECONDS);
		 * 
		 * // Upload files driver.findElement(By.xpath("//*[@id='fileUpload']"))
		 * .sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\set1.txt");
		 * 
		 * // Select document type dh.selectUsingVisibleText(docType1,
		 * "Valid Trade License"); wait.setImplicitWait(100, TimeUnit.SECONDS);
		 * 
		 * js.scrollIntoView(docType2); dh.selectUsingVisibleText(docType2,
		 * "Valid Trade License"); js.scrollIntoView(descriptionTextField);
		 * TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc101"); //
		 * TestUtil.clickOn(driver, Submit, 50); js.clickElement(Submit);
		 * 
		 * log.info("*** Valid TIN Certificate 2 ****"); // Upload files
		 * driver.findElement(By.xpath("//*[@id='fileUpload']"))
		 * .sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\set2.txt");
		 * 
		 * // Select document type dh.selectUsingVisibleText(docType1,
		 * "Valid TIN Certificate"); wait.setImplicitWait(100, TimeUnit.SECONDS);
		 * 
		 * js.scrollIntoView(docType2); dh.selectUsingVisibleText(docType2,
		 * "Valid TIN Certificate"); js.scrollIntoView(descriptionTextField);
		 * TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc102"); //
		 * TestUtil.clickOn(driver, Submit, 50); js.clickElement(Submit);
		 * 
		 * log.info("*** VAT Registration Certificate 3 ****"); // Upload files
		 * driver.findElement(By.xpath("//*[@id='fileUpload']"))
		 * .sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\1162d2xa1.txt");
		 * 
		 * // Select document type dh.selectUsingVisibleText(docType1,
		 * "VAT Registration Certificate"); wait.setImplicitWait(100, TimeUnit.SECONDS);
		 * 
		 * js.scrollIntoView(docType2); dh.selectUsingVisibleText(docType2,
		 * "VAT Registration Certificate"); js.scrollIntoView(descriptionTextField);
		 * TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc103"); //
		 * TestUtil.clickOn(driver, Submit, 50); js.clickElement(Submit);
		 * 
		 * log.
		 * info("*** Documentary evidence of Average Annual Construction Turnover 4 ****"
		 * ); // Upload files driver.findElement(By.xpath("//*[@id='fileUpload']"))
		 * .sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\1172d2xa1.txt");
		 * 
		 * // Select document type dh.selectUsingVisibleText(docType1,
		 * "Documentary evidence of Average Annual Construction Turnover");
		 * wait.setImplicitWait(100, TimeUnit.SECONDS);
		 * 
		 * js.scrollIntoView(docType2); dh.selectUsingVisibleText(docType2,
		 * "Documentary evidence of Average Annual Construction Turnover");
		 * js.scrollIntoView(descriptionTextField); TestUtil.sendKeys(driver,
		 * descriptionTextField, 100, "testDesc104"); // TestUtil.clickOn(driver,
		 * Submit, 50); js.clickElement(Submit);
		 * 
		 * log.info("*** Documentary evidence  of liquid assets 5 ****"); // Upload
		 * files driver.findElement(By.xpath("//*[@id='fileUpload']"))
		 * .sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\1112d2xa1.txt");
		 * 
		 * // Select document type dh.selectUsingVisibleText(docType1,
		 * "Documentary evidence  of liquid assets"); wait.setImplicitWait(100,
		 * TimeUnit.SECONDS);
		 * 
		 * js.scrollIntoView(docType2); dh.selectUsingVisibleText(docType2,
		 * "Documentary evidence  of liquid assets");
		 * js.scrollIntoView(descriptionTextField); TestUtil.sendKeys(driver,
		 * descriptionTextField, 100, "testDesc105"); // TestUtil.clickOn(driver,
		 * Submit, 50); js.clickElement(Submit);
		 * 
		 * log.info("*** Documentary evidence of Specific Experience 6 ****"); // Upload
		 * files driver.findElement(By.xpath("//*[@id='fileUpload']"))
		 * .sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\1122d2xa1.txt");
		 * 
		 * // Select document type dh.selectUsingVisibleText(docType1,
		 * "Documentary evidence of Specific Experience"); wait.setImplicitWait(100,
		 * TimeUnit.SECONDS);
		 * 
		 * js.scrollIntoView(docType2); dh.selectUsingVisibleText(docType2,
		 * "Documentary evidence of Specific Experience");
		 * js.scrollIntoView(descriptionTextField); TestUtil.sendKeys(driver,
		 * descriptionTextField, 100, "testDesc106"); // TestUtil.clickOn(driver,
		 * Submit, 50); js.clickElement(Submit); js.clickElement(goBackToDashBoard);
		 * wait.setImplicitWait(100, TimeUnit.SECONDS); } else if (j == 3) {
		 * //Tenderer's Quoted Price * log.info("***click on map3 ***");
		 * TestUtil.clickOn(driver, map3, 100); wait.setImplicitWait(100,
		 * TimeUnit.SECONDS); // Upload files
		 * driver.findElement(By.xpath("//*[@id='fileUpload']"))
		 * .sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\1122d3xa1.txt");
		 * 
		 * TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc107"); //
		 * TestUtil.clickOn(driver, Submit, 50); js.clickElement(Submit);
		 * driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,
		 * TimeUnit.SECONDS); js.clickElement(goBackToDashBoard);
		 * driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,
		 * TimeUnit.SECONDS);
		 * 
		 * // Verify text String tenderSecurityPaymentText1 =
		 * verification.getText(tenderSecurityPaymentText);
		 * System.out.println("date is ---->> " + tenderSecurityPaymentText1);
		 * AssertionHelper.verifyText(tenderSecurityPaymentText1,
		 * "Tender Security Payment is Pending", "text is verified"); LogOut.click(); }
		 * }
		 */
	}

	/*
	 * ********** bidParticipateDevbudgetLTMMethod_EPW2B- Tenderer login
	 * functionality
	 */
	public void bidParticipateDevbudgetLTM_Map_EPW2B(String tenderIdValue) throws Throwable {
		log.info("**** inside bidParticipateDevbudgetLTMMethod_EPW2B method ********** ");

		// I am splitting 2nd coloumn nothing but second td.
		String before_xpath1 = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath1 = "]/td[2]";

		/*
		 * for (int i = 1; i <= 10; i++) {
		 * log.info("*********** inside for loop ************"); String name =
		 * driver.findElement(By.xpath(before_xpath1 + i + after_xpath1)).getText();
		 * System.out.println(name); try { if (name.contains(tenderIdValue)) {
		 * System.out.println("shrikanth kulal -->> " + name);
		 * driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +
		 * "]/td[7]/a/img")).click(); break; } } catch (Exception e) { e.getMessage(); }
		 * }
		 */

		for (int i = 0; i < totalTabs.size(); i++) {
			WebElement element = totalTabs.get(i);
			String text = totalTabs.get(i).getText();
			System.out.println("tabs are ---->> " + text);

			if (text.equals("Tend. Preparation")) {
				element.click();
				break;
			}
		}
		// e-Tender Submission Letter (Form e-PW2-1)
		// I am splitting 2nd coloumn nothing but second td.
		String before_xpath = "//*[@id='tblMain']/tbody/tr[";
		String after_xpath = "]/td[2]/a";

		Assert.assertTrue(true);
		// Handling map links - total 4 Map links
		for (int j = 1; j <= 4; j++) {

			// click on map1 link
			if (j == 1) {
				wait.WaitForElementVisibleWithPollingTime(map1, 500, 3);
				TestUtil.clickOn(driver, map1, 100);

				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\meq1z.txt");
				
				// Select document type
				dh.selectUsingVisibleText(docType1, "Authorization Letter to submit Tender on behalf of Tenderer");
				wait.setImplicitWait(100, TimeUnit.SECONDS);

				js.scrollIntoView(docType2);
				dh.selectUsingVisibleText(docType2, "Authorization Letter to submit Tender on behalf of Tenderer");
				js.scrollIntoView(descriptionTextField);
				TestUtil.sendKeys(driver, descriptionTextField, 10, "testDescx");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);

				log.info("***National ID of authorised person****");
				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\meq2z.txt");

				// Select document type
				dh.selectUsingVisibleText(docType1, "National ID of Authorised Person");
				wait.setImplicitWait(50, TimeUnit.SECONDS);

				js.scrollIntoView(docType2);
				dh.selectUsingVisibleText(docType2, "National ID of Authorised Person");
				js.scrollIntoView(descriptionTextField);
				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDescxy");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);

				wait.setImplicitWait(100, TimeUnit.SECONDS);

				js.clickElement(goBackToDashBoard);
				wait.setImplicitWait(100, TimeUnit.SECONDS);
			} else if (j == 2) {
				log.info("*******map2*******");
				wait.WaitForElementVisibleWithPollingTime(map2, 500, 3);
				TestUtil.clickOn(driver, map2, 100);
				wait.setImplicitWait(100, TimeUnit.SECONDS);

				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\meq3z.txt");

				// Select document type
				dh.selectUsingVisibleText(docType1, "Valid Trade License");
				wait.setImplicitWait(100, TimeUnit.SECONDS);

				js.scrollIntoView(docType2);
				dh.selectUsingVisibleText(docType2, "Valid Trade License");
				js.scrollIntoView(descriptionTextField);
				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc101");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);

				log.info("*** Valid TIN Certificate 2 ****");
				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\meq4z.txt");

				// Select document type
				dh.selectUsingVisibleText(docType1, "Valid TIN Certificate");
				wait.setImplicitWait(100, TimeUnit.SECONDS);

				js.scrollIntoView(docType2);
				dh.selectUsingVisibleText(docType2, "Valid TIN Certificate");
				js.scrollIntoView(descriptionTextField);
				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc102");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);

				log.info("*** VAT Registration Certificate 3 ****");
				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\meq5z.txt");

				// Select document type
				dh.selectUsingVisibleText(docType1, "VAT Registration Certificate");
				wait.setImplicitWait(100, TimeUnit.SECONDS);

				js.scrollIntoView(docType2);
				dh.selectUsingVisibleText(docType2, "VAT Registration Certificate");
				js.scrollIntoView(descriptionTextField);
				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc103");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);

				log.info("*** Documentary evidence of adequacy of liquid assets (ITT 9.1.a) ****");
				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\meq6z.txt");

				// Select document type
				dh.selectUsingVisibleText(docType1, "Documentary evidence of adequacy of liquid assets (ITT 9.1.a)");
				wait.setImplicitWait(100, TimeUnit.SECONDS);

				js.scrollIntoView(docType2);
				dh.selectUsingVisibleText(docType2, "Documentary evidence of adequacy of liquid assets (ITT 9.1.a)");
				js.scrollIntoView(descriptionTextField);
				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc104");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);
				js.clickElement(goBackToDashBoard);
				wait.setImplicitWait(100, TimeUnit.SECONDS);
			} else if (j == 3) {
				// Tenderer's Quoted Price *
				log.info("***click on map3 ***");
				TestUtil.clickOn(driver, map3, 100);
				wait.setImplicitWait(100, TimeUnit.SECONDS);
				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\meq7z.txt");

				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc107");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				js.clickElement(goBackToDashBoard);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			} else if (j == 4) {
				// Priced Bill of Quantities (BOQ)
				log.info("*** click on map4 ***");
				TestUtil.clickOn(driver, map4, 100);
				wait.setImplicitWait(100, TimeUnit.SECONDS);
				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\meq8z.txt");

				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc107");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				js.clickElement(goBackToDashBoard);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

				// Click on I Agree Checkbox
				TestUtil.clickOn(driver, iAgreeButton, 50);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				TestUtil.clickOn(driver, goToFinalSubButton, 50);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				TestUtil.clickOn(driver, finalSubmission, 50);

				//LogOut.click();
			}
		}
	}

	/**
	 * BranchMaker login TenderSecurityPending
	 * 
	 * @throws InterruptedException
	 */

	public void branchMakerLoginTenderSecurityPending() throws InterruptedException {
		log.info("****inside branchMakerLoginTenderSecurityPending method **********");
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.loginWithBranchMaker();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		Actions action = new Actions(driver);
		action.moveToElement(paymentMenuTab).build().perform();
		tenderPaymentMenuTab.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

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
			tenderIdEle.sendKeys(strngTenderId);

			// TestUtil.clickOn(driver, SrchtndrBtntext, 100);
			// TestUtil.clickOn(driver, SrchtndrBtntext, 100);
			// js.clickElement(SrchtndrBtntext);
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
		// .......
		// *[@id="resultTable"]/tbody/tr[10]/td[2]

		// this is for click icon
		// *[@id="resultTable"]/tbody/tr[3]/td[7]/a/img*/

		// I am splitting 2nd coloumn nothing but second td.

		// *[@id="resultTable"]/tbody/tr[
		// ]/td[2]

		String before_xpath = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath = "]/td[2]";

		for (int k = 1; k <= 10; k++) {
			log.info("***********inside for loop************");
			String name = driver.findElement(By.xpath(before_xpath + k + after_xpath)).getText();
			System.out.println(name);
			if (name.contains(strngTenderId)) {
				System.out.println("shrikanth kulal -->> " + name);
				driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + k + "]/td[7]/a/img")).click();
				break;
			}
		}

		// tenderPropId.sendKeys(tenderIdValue);
		// js.scrollToElementAndClick(SrchtndrBtn);
		// js.clickElement(SrchtndrBtn);

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// js.scrollIntoView(clickToDashbordIcon);
		// js.clickElement(clickToDashbordIcon);
		// clickToDashbordIcon.click();

		System.out.println("SizeQQQ is --->>" + totalTabsSize.size());

		for (int i = 0; i <= totalTabsSize.size(); i++) {
			WebElement element = totalTabsSize.get(i);
			String text = totalTabsSize.get(i).getText();
			System.out.println("tabs are ---->> " + text);

			if (text.equals("Tender/Proposal Security")) {
				element.click();
				break;
			}
		}

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.clickElement(payment);

		// Enter e-mail id
		TestUtil.sendKeys(driver, emailId, 30, "egptenderer1@gmail.com");
		js.clickElement(searchButton);

		// Click on Make Payment
		js.clickElement(makePayment);

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		// select mode of payment
		dh.selectUsingVisibleText(modeOfPayment, "DD");

		TestUtil.sendKeys(driver, instrumentNo, 30, "instrument101");
		TestUtil.sendKeys(driver, inssuingBank, 30, "syndbank");
		TestUtil.sendKeys(driver, inssuingBankBranch, 30, "maharastrabranchbank");
		Thread.sleep(200);

		// TestBase.selectDateByJs(driver,issuanceDate,"12/05/2018");
		// WebElement
		// fromDateElement=driver.findElement(By.xpath("//input[@id='txtIssuanceDt']"));
		// System.out.println("let me --"+fromDateElement.isDisplayed());
		// dateElement.click();
		// String dateVal="05/12/2018";
		// js.selectDateByJavaScript(issuanceDate, "05/12/2018");

		selectDateByJs(driver, issuanceDate, "05/12/2018");

		/*
		 * DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 * LocalDateTime now = LocalDateTime.now(); System.out.println("now is "+now);
		 */
		// String dateVal1 = dtf.format(now);
		// selectDateByJs(driver,issuanceDate,dateVal1);
		// js.clickElement(issuanceDate);
		// selectDateByJs(driver,issuanceDate,"05/12/2018");

		/*
		 * js.scrollIntoView(remarksComments);
		 * 
		 * TestUtil.sendKeys(driver, remarksComments, 30, "egptestcom");
		 * js.clickElement(submitcommMem);
		 * driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,
		 * TimeUnit.SECONDS);
		 * 
		 * //Verify text String updatedText1 = verification.getText(updatedText);
		 * System.out.println("date is ---->> "+updatedText1);
		 * AssertionHelper.verifyText(updatedText1, "Payment updated successfully",
		 * "text is verified");
		 * driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,
		 * TimeUnit.SECONDS);
		 */
		// LogOut.click();
	}

	// *********************BranchChecker login TenderSecurityPending

	public void branchCheckerLoginTenderSecurityPending() {
		log.info("****inside branchCheckerLoginTenderSecurityPending method **********");
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.loginWithBranchChecker();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		Actions action = new Actions(driver);
		action.moveToElement(paymentMenuTab).build().perform();
		tenderPaymentMenuTab.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

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
			tenderIdEle.sendKeys(strngTenderId);
			js.clickElement(SrchtndrBtn);

			TestUtil.clickOn(driver, verifyLink1, 50);
			TestUtil.sendKeys(driver, remarksComments, 50, "verified successfully");

			TestUtil.clickOn(driver, buttonVerify, 50);

			Alert alert = driver.switchTo().alert();
			alert.accept();

			// Verify text
			String updatedPayText = verification.getText(updatedPaymentText);
			System.out.println("text is ---->> " + updatedPayText);
			AssertionHelper.verifyText(updatedPayText, "Payment verified successfully", "text is verified");
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			LogOut.click();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tenderer login functionality
	 * 
	 * @throws Throwable
	 */
	public void egptendererLoginFinalSubmission() throws Throwable {
		log.info("**** inside tendererLogin method ********** ");
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.loginWithTenderer();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		Actions action = new Actions(driver);
		action.moveToElement(tenderMenuTab).build().perform();
		myTenders.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		// js.clickElement(clickToDashbordIcon);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

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
			tenderPropId.sendKeys(strngTenderId);

			js.clickElement(searchButton);
			Actions builder = new Actions(driver);
			builder.moveToElement(searchButton).click().build().perform();
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
		// .......
		// *[@id="resultTable"]/tbody/tr[10]/td[2]

		// this is for click icon
		// *[@id="resultTable"]/tbody/tr[3]/td[7]/a/img*/

		// I am splitting 2nd coloumn nothing but second td.

		// *[@id="resultTable"]/tbody/tr[
		// ]/td[2]

		String before_xpath = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath = "]/td[2]";

		for (int k = 1; k <= 10; k++) {
			log.info("*********** inside for loop ************");
			String name = driver.findElement(By.xpath(before_xpath + k + after_xpath)).getText();
			System.out.println(name);
			if (name.contains(strngTenderId)) {
				System.out.println("shrikanth kulal -->> " + name);
				driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + k + "]/td[7]/a/img")).click();
				break;
			}
		}

		System.out.println("Size is --->>" + totalTabs.size());
		try {
			log.info("************** inside try block ************************");
			for (int i = 0; i <= totalTabs.size(); i++) {
				WebElement element = totalTabs.get(i);
				String text = totalTabs.get(i).getText();
				System.out.println("tabs are ---->> " + text);

				if (text.equals("Tend. Preparation")) {
					element.click();
					break;
				}
			}
			js.scrollIntoView(iAgreeCheckBbox);
			TestUtil.clickOn(driver, iAgreeCheckBbox, 20);
			js.clickElement(goToFinalSubButton);

			js.scrollIntoView(finalSubmission);
			js.clickElement(finalSubmission);
		} catch (Exception e) {
			log.info("************** inside catch block************************");
			e.printStackTrace();
		} finally {
			System.out.println("shrikanth kulal inside finally block");
			try {
				log.info("************** inside try block************************");
				// loading url below one
				driver.navigate().to("https://www.training.eprocure.gov.bd/officer/TenderPdfGenerate.jsp?tenderid="
						+ strngTenderId + "");
			} catch (Exception e) {
				log.info("************** finally --->> inside catch block************************");
				e.printStackTrace();
			}
		}

	}

	/*
	 * ************** Tenderer login functionality - RFQU
	 */
	public void egptendererLoginDevbudgetWorksRFQUMethod(String tenderIdValue) throws Throwable {
		log.info("**** inside egptendererLoginDevbudgetWorksRFQUMethod ********** ");

		// I am splitting 2nd coloumn nothing but second td.
		String before_xpath1 = "//*[@id='resultTable']/tbody/tr[";
		String after_xpath1 = "]/td[2]";

		for (int i = 1; i <= 100; i++) {
			log.info("*********** inside for loop ************");
			String name = driver.findElement(By.xpath(before_xpath1 + i + after_xpath1)).getText();
			System.out.println("delhi is --->>>" + name);
			if (name.contains(tenderIdValue)) {
				System.out.println("shrikanth kulal -->> " + name);
				driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i + "]/td[7]/a/img")).click();
				break;
			}
		}

		for (int i = 0; i <= totalTabs.size(); i++) {
			WebElement element = totalTabs.get(i);
			String text = totalTabs.get(i).getText();
			System.out.println("tabs are ---->> " + text);

			if (text.equals("Docs.")) {
				element.click();
				break;
			}
		}
		// Assert.assertTrue(false);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.clickElement(agreeButton);

		String declarationVerificationText1 = verification.getText(declarationVerificationText);
		System.out.println("date is ---->> " + declarationVerificationText1);
		AssertionHelper.verifyText(declarationVerificationText1, "Declaration completed successfully",
				"text is verified");

		for (int i = 0; i < totalTabs.size(); i++) {
			WebElement element = totalTabs.get(i);
			String text = totalTabs.get(i).getText();
			System.out.println("tabs are ---->> " + text);

			if (text.equals("Tend. Preparation")) {
				element.click();
				break;
			}
		}

		// e-Tender Submission Letter (Form e-PW2-1)
		// I am splitting 2nd coloumn nothing but second td.
		String before_xpath = "//*[@id='tblMain']/tbody/tr[";
		String after_xpath = "]/td[2]/a";

		for (int i = 2; i <= 9; i++) {
			log.info("*********** Fill -- inside for loop ************");
			if (i == 2) {
				log.info("*********** Fill1 -- i==2  if loop ************");
				driver.findElement(By.xpath("//*[@id='tblMain']/tbody/tr[" + i + "]/td[2]/a")).click();

				js.scrollIntoView(signButton);
				// signButton.click();
				wait.WaitForElementVisibleWithPollingTime(signButton, 30, 5);
				js.clickElement(signButton);
				// wait element for password
				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");

				// wait element for password
				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				js.clickElement(verifyPassword);

				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				js.clickElement(encryptSaveButton);

				wait.WaitForElementVisibleWithPollingTime(saveButton, 30, 5);
				// TestUtil.clickOn(driver, saveButton, 100);
				js.clickElement(saveButton);

				String formSaved = verification.getText(fillSave1);
				System.out.println("text fillSave1 is ---->> " + formSaved);
				AssertionHelper.verifyText(formSaved, "Form saved successfully", "text is verified");
			} else if (i == 3) {
				log.info("*********** Fill2 -- i==3  if loop ************");
				driver.findElement(By.xpath("//*[@id='tblMain']/tbody/tr[" + i + "]/td[2]/a")).click();
				js.scrollIntoView(signButton);
				// signButton.click();
				wait.WaitForElementVisibleWithPollingTime(signButton, 30, 5);
				js.clickElement(signButton);
				// wait element for password
				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");

				// wait element for password
				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				js.clickElement(verifyPassword);

				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				js.clickElement(encryptSaveButton);

				wait.WaitForElementVisibleWithPollingTime(saveButton, 30, 5);
				// TestUtil.clickOn(driver, saveButton, 100);
				js.clickElement(saveButton);
				// wait.setImplicitWait(100, TimeUnit.SECONDS);
				// Thread.sleep(200);
				// js.clickElement(encryptSaveButton);

				String formSaved = verification.getText(fillSave1);
				System.out.println("text fillSave1 is ---->> " + formSaved);
				AssertionHelper.verifyText(formSaved, "Form saved successfully", "text is verified");

				// Encrypt scripts
				// Click on Encrypt linkdecryptButton
				// TestUtil.clickOn(driver, encrypt1, 50);
				wait.WaitForElementVisibleWithPollingTime(encrypt1RFQ, 30, 5);
				js.clickElement(encrypt1RFQ);

				js.scrollIntoView(decryptButton);
				wait.WaitForElementVisibleWithPollingTime(decryptButton, 30, 5);
				// TestUtil.clickOn(driver, decryptButton, 50);
				js.clickElement(decryptButton);

				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");
				// TestUtil.clickOn(driver, verifyPassword, 50);
				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				js.clickElement(verifyPassword);
				// TestUtil.clickOn(driver, encryptSaveButton, 50);
				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				js.clickElement(encryptSaveButton);
				// TestUtil.clickOn(driver, oKButton, 50);
				wait.WaitForElementVisibleWithPollingTime(oKButton, 30, 5);
				js.clickElement(oKButton);
				// break;
			} else if (i == 7) {
				log.info("*********** Fill7 -- i==7  if loop************");
				// click on Fill link
				driver.findElement(By.xpath("//*[@id='tblMain']/tbody/tr[" + i + "]/td[2]/a")).click();
				// enter unit price
				wait.WaitForElementVisibleWithPollingTime(unitPrice, 30, 5);
				TestUtil.sendKeys(driver, unitPrice, 100, "12025.123");

				// click on Sign button
				wait.WaitForElementVisibleWithPollingTime(signButton, 30, 5);
				js.clickElement(signButton);

				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");

				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				js.clickElement(verifyPassword);

				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				js.clickElement(encryptSaveButton);

				wait.WaitForElementVisibleWithPollingTime(saveButton, 30, 5);
				js.clickElement(saveButton);

				// Encrypt scripts
				// Click on Encrypt link3
				wait.WaitForElementVisibleWithPollingTime(encrypt7Dup, 30, 5);
				js.clickElement(encrypt7Dup);

				js.scrollIntoView(decryptButton);
				wait.WaitForElementVisibleWithPollingTime(decryptButton, 30, 5);
				js.clickElement(decryptButton);

				wait.WaitForElementVisibleWithPollingTime(password, 30, 5);
				TestUtil.sendKeys(driver, password, 100, "egp12345");

				wait.WaitForElementVisibleWithPollingTime(verifyPassword, 30, 5);
				js.clickElement(verifyPassword);

				wait.WaitForElementVisibleWithPollingTime(encryptSaveButton, 30, 5);
				js.clickElement(encryptSaveButton);

				wait.WaitForElementVisibleWithPollingTime(oKButton, 30, 5);
				js.clickElement(oKButton);
			}
		}

		// Handling map links
		for (int j = 1; j <= 7; j++) {

			// click on map1 link
			if (j == 1) {
				wait.WaitForElementVisibleWithPollingTime(map1, 30, 5);
				js.clickElement(map1);

				// Upload files
				log.info("*** Valid Trade License ****");
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\20c1x.txt");

				// Select document type
				wait.WaitForElementVisibleWithPollingTime(docType1, 30, 5);
				dh.selectUsingVisibleText(docType1, "Valid Trade License");

				js.scrollIntoView(docType2);
				dh.selectUsingVisibleText(docType2, "Valid Trade License");
				js.scrollIntoView(descriptionTextField);
				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc101");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);

				log.info("*** Valid TIN Certificate ****");
				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\30c1x.txt");

				// Select document type
				wait.WaitForElementVisibleWithPollingTime(docType1, 30, 5);
				dh.selectUsingVisibleText(docType1, "TIN Certificate");
				wait.WaitForElementVisibleWithPollingTime(docType1, 30, 5);

				js.scrollIntoView(docType2);
				dh.selectUsingVisibleText(docType2, "TIN Certificate");
				wait.WaitForElementVisibleWithPollingTime(descriptionTextField, 30, 5);
				js.scrollIntoView(descriptionTextField);
				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc102");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);

				log.info("*** VAT Registration Certificate 3 ****");
				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\40c1x.txt");

				// Select document type
				wait.WaitForElementVisibleWithPollingTime(docType1, 30, 5);
				dh.selectUsingVisibleText(docType1, "VAT Registration Certificate");

				wait.WaitForElementVisibleWithPollingTime(docType2, 30, 5);
				js.scrollIntoView(docType2);
				dh.selectUsingVisibleText(docType2, "VAT Registration Certificate");

				wait.WaitForElementVisibleWithPollingTime(descriptionTextField, 30, 5);
				js.scrollIntoView(descriptionTextField);
				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc103");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);
				wait.WaitForElementVisibleWithPollingTime(goBackToDashBoard, 30, 5);
				js.clickElement(goBackToDashBoard);

			} else if (j == 2) {
				/**
				 * Handling Maps
				 */
				log.info("***click on map2 ***");
				TestUtil.clickOn(driver, map2, 100);
				wait.setImplicitWait(100, TimeUnit.SECONDS);
				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\1141c1x.txt");

				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc107");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				js.clickElement(goBackToDashBoard);
			} else if (j == 7) {
				log.info("***click on map3 ***");
				TestUtil.clickOn(driver, mapdup3, 100);
				wait.setImplicitWait(100, TimeUnit.SECONDS);
				// Upload files
				driver.findElement(By.xpath("//*[@id='fileUpload']"))
						.sendKeys("C:\\Users\\Shrikanth Kulal\\Desktop\\1151c1x.txt");

				TestUtil.sendKeys(driver, descriptionTextField, 100, "testDesc107");
				// TestUtil.clickOn(driver, Submit, 50);
				js.clickElement(Submit);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				js.clickElement(goBackToDashBoard);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

				// Verify text
				String tenderSecurityPaymentText1 = verification.getText(tenderSecurityPaymentText);
				System.out.println("date is ---->> " + tenderSecurityPaymentText1);
				AssertionHelper.verifyText(tenderSecurityPaymentText1, "Tender Security Payment is Pending",
						"text is verified");
				LogOut.click();
			}
		}
	}
}
