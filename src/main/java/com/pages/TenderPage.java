package com.pages;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.egp.qa.base.TestBase;
import com.egp.qa.configfilereader.FileReaderManager;
import com.egp.qa.utilities.TestUtil;


/**
*
* @author SHIVANSHU SHANDILYA
*/

public class TenderPage extends TestBase {
	@FindBy(id = "headTabApp")
	WebElement AppLink;
	
	@FindBy(linkText = "My APP")
	WebElement MyAppLink;
	
	@FindBy(id = "txtAppId")
	WebElement SerchAPPID; 
	
	
	
	@FindBy(id = "cmbstatus")
	WebElement 	Status;
	
	
	@FindBy(id = "btnSearchApp")
	WebElement SerchAppIdBtn;
	
	@FindBy(xpath = "//*[@id=\"0\"]/td[6]/a")
	WebElement  DashBordClick;
	
	
	@FindBy(linkText = "Create Tender/Proposal")
	WebElement  ClickToCreateTender;
	
	
	@FindBy(id = "txtinvitationRefNo")
	WebElement InvitationReferenceNoTextField ;
	
	
	@FindBy(id = "txttenderpublicationDate")
	WebElement ProposalPublicationDateandTime;
	
	
	@FindBy(id = "txttenderLastSellDate")
	WebElement ProposalDocumentlastsellingdownloadingDateandTime;
	
	
	
	@FindBy(id = "txtpreTenderMeetStartDate")
	WebElement ProposalmeetingStartDateandTime;
	
	
	
	@FindBy(id = "txtpreTenderMeetEndDate")
	WebElement ProposalmeetingEndDateandTime ;
	
	
	@FindBy(id = "txtpreQualCloseDate")
	WebElement ProposalClosingDateandTime;
	
	
	
	@FindBy(id = "txtpreQualOpenDate")
	WebElement ProposalOpeningDateandTime;
	
	@FindBy(id="txtlastDateTenderSub")
	WebElement ProposalSecuritySubmission ;
	
	
	@FindBy(xpath = "/html")
	WebElement EligibilityofTendererTextBox;
	
	
	@FindBy(xpath = "/html")
	WebElement BriefDescriptionofGoodsandRelatedService;
	
	@FindBy(id="txtpreQualDocPrice")
	WebElement ProposalDocumentPrice ;
	
	
	@FindBy(id = "locationlot_0")
	WebElement Location;
	
	@FindBy(id="tenderSecurityAmount_0")
	WebElement ProposalSecurityAmountInBDT;
	
	@FindBy(id = "startTimeLotNo_0")
	WebElement StartDateEle; 
	
	
	
	@FindBy(id = "complTimeLotNo_0")
	WebElement CompletionDateEle;
	
	
	@FindBy(id = "btnsubmit")
	WebElement submitToRadiobtn;
	
	
	@FindBy(id = "tenderDocument")
	WebElement StandardTenderProposalDocument;
	
	
	@FindBy(id = "cmbDomesticPreference")
	WebElement DomesticPreferenceRequires;
	
	
	@FindBy(id = "btnSubmit")
	WebElement SubmitButon2TenderPraposal;
	
	@FindBy(id="txttenderValidity")
	WebElement ProposalValidityInNoofDays ;
	
	@FindBy(xpath = "/html/body/div/div[2]/table[1]/tbody/tr[1]/td[2]")
	WebElement TenderId;
	
	@FindBy(id="txttenderSecurityValidity")
	WebElement ProposalSecurityValidityInNoofDays ;
	
	@FindBy(xpath="/html/body/div[3]/div[4]/table/tbody/tr[6]/td[2]/a")
	WebElement AddOfficialCostEstimate ;
	
	@FindBy(id="taka_0")
	WebElement OfficialCostEstimate ;
	
	@FindBy(xpath="/html/body/div[3]/div[4]/table/tbody/tr[5]/td[2]/a")
	WebElement CommitteeMemberforEncryptionCreate;
	
	@FindBy(linkText="Go back to Tender/Proposal Dashboard")
	WebElement GoToDashBoard ; 
	
	@FindBy(id="submit")
	WebElement OfficialCostEstimateSubmit ;
	
	//@FindBy(xpath="//*[@id=\"offTabPanel\"]/li[2]/a")
	@FindBy(linkText="Document")
	WebElement DocumentLink;
	
	@FindBy(xpath="/html/body/div/div[3]/div[4]/table[3]/tbody/tr[8]/td[2]/table[3]/tbody/tr[2]/td[3]/a[1]")
	WebElement FormDashBordTenderSubmissionLetter;

	@FindBy(linkText="Fill up the Tables")
	WebElement FillUpTheTables ;
	
	@FindBy(id="chk1")
	WebElement CheckBoxCheck ;
	
	@FindBy(xpath="/html/body/div/div[3]/div[1]/span/a")
	WebElement FormDashBord;
	
	@FindBy(xpath="/html/body/div/div[3]/div[4]/table[3]/tbody/tr[8]/td[2]/table[3]/tbody/tr[3]/td[3]/a[1]")
	WebElement FormDashboardTechnicalSpecifications;
	
	@FindBy(xpath="/html/body/div/div[3]/div[1]/span/a")
	WebElement TenderProposalDocument ;
	
	@FindBy(xpath="/html/body/div/div[3]/div[4]/table[3]/tbody/tr[8]/td[2]/table[5]/tbody/tr[2]/td[3]/a[1]")
	WebElement FormDasbordPriceAndDeliveryScheduleforGood ;
	
	
	@FindBy(xpath="/html/body/div/div[3]/div[4]/table[3]/tbody/tr[8]/td[2]/table[5]/tbody/tr[3]/td[3]/a[1]")
	WebElement PriceAndCompletionScheduleForRelatedServices ;
	
	@FindBy(id="Cell1_1")
	WebElement ItemNo;
	
	@FindBy(id="Cell1_2")
	WebElement ColumnHeader ;
	
	@FindBy(id="Cell1_3")
	WebElement DescriptionofItem ;
	
	@FindBy(id="Cell1_4")
	WebElement MeasurementUnit ;
	
	@FindBy(id="Cell1_5")
	WebElement Quantity ;
	
	@FindBy(id="Cell1_6")
	WebElement DeliveryPeriodindays ;
	
	@FindBy(linkText="Create")
	WebElement createLink;
	
	@FindBy(linkText="Tender/Proposal Doc. Preparation")
	WebElement ProposalDocPreparation ;
	
	//@FindBy(xpath="/html/body/div/div[3]/div[1]/span/a")
	//WebElement ProposalDocPreparation ;
	
	
	//@FindBy(linkText="Evaluation")
	//WebElement EvaluationLink ;
	
	@FindBy(xpath="//*[@id=\"offTabPanel\"]/li[3]")
	WebElement EvaluationLink ;
	
	
	@FindBy(linkText="Create")
	WebElement EvaluationCommitteeCreate ;
	
	@FindBy(id="txtcommitteeName")
	WebElement CommitteeName ;
	
	
	@FindBy(id="addmem")
	WebElement AddMembers;
	
	@FindBy(id="chk1")
	WebElement AOUserAsMember;
	
	@FindBy(id="chk5")
	WebElement HopeUserAsMember;
	
	@FindBy(xpath="//*[@id=\"myPanelDiv\"]/div[3]/div/button[1]")
	WebElement Addmembers;
	
	@FindBy(id="cmbMemRole0")
	WebElement CommitteeRoleAOUser;
	// cp  chair 
	@FindBy(id="cmbMemRole1")
	WebElement CommitteeRoleHopeUser ;
	// m    member value 
	
	@FindBy(linkText="Create")
	WebElement CreateWorkFlow;
	
	@FindBy(xpath="//*[@id=\"offTabPanel\"]/li[4]/a")
	WebElement OpeningLink;		
	
	@FindBy(xpath="/html/body/div/div[3]/table/tbody/tr[2]/td[3]")
	WebElement UnnElee;
	
	@FindBy(xpath="/html/body/table/tbody/tr[4]/td[2]/p")
	WebElement unassryeleemm;
	
	@FindBy(id="btnSubmit")
	WebElement submitcommMem;
	
	@FindBy(xpath="//*[@id=\"members\"]/tbody/tr[2]/td[1]")
	WebElement unnasrypageele;
	
	
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
	
	
	@FindBy(xpath="/html/body/div/div[3]/div[4]/table[3]/tbody/tr[8]/td[2]/table[6]/tbody/tr/td[2]/a")
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
	WebElement GrandsummaryForWork;
	
	@FindBy(xpath="/html/body/div/div[3]/div[4]/table[3]/tbody/tr[9]/td[2]/table[6]/tbody/tr/td[1]")
	WebElement unnesscreategrand;
	
	@FindBy(id="popup_ok")
	WebElement CreateNewFormConfirmation;
	
	//@FindBy(xpath="/html/body/div[3]/div[4]/table[1]/tbody/tr[4]/td[2]/a")
	@FindBy(xpath="/html/body/div[3]/div[4]/table[1]/tbody/tr[4]/td[2]/a")
	WebElement createnotice;
	
	@FindBy(xpath="/html/body/div[3]/div[4]/table[1]/tbody/tr[1]/td[2]/a[1]")
	WebElement creatence;
	
	@FindBy(xpath="/html/body/div[3]/div[4]/div/span")
	WebElement etervd;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	public TenderPage() {
		PageFactory.initElements(driver, this);
		
		}
	
	
	
	
	public void Tender() throws Throwable {
		

		
File src= new File(FileReaderManager.getInstance().getConfigReader().getAppGoodsOwnPath());
FileInputStream fis = new FileInputStream(src);
String strngAppId = IOUtils.toString(fis);
		
		SerchAPPID.sendKeys(strngAppId);
		
		 Select app = new Select(Status);
	      
	       app.selectByValue("Approved");
	       
	       js.executeScript("arguments[0].click();", SerchAppIdBtn);
	       
	       js.executeScript("arguments[0].click();", DashBordClick);
	       
	       js.executeScript("window.scrollBy(0,1000)");
	       
	       ClickToCreateTender.click();
	       
	       InvitationReferenceNoTextField.sendKeys("214563");
	       
	       LocalDateTime now = LocalDateTime.now();
	       LocalDateTime NextDaysAfter = now.plusDays(1);
	       LocalDateTime friday = NextDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       
	       
	       LocalDateTime sevenDaysAfter = now.plusDays(21);
	       LocalDateTime friday1 = sevenDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       System.out.println(friday1);
	       
	       LocalDateTime oneDaysAfter = now.plusDays(2);
	       LocalDateTime friday2 = oneDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       
	       LocalDateTime SixDaysAfter = now.plusDays(14);
	       LocalDateTime friday3 = SixDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       
	       LocalDateTime EightDaysAfter = now.plusDays(8);
	       LocalDateTime friday4 = EightDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       
	       LocalDateTime NineDaysAfter = now.plusDays(9);
	       LocalDateTime fridaySecuritySubmission = NineDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       LocalDateTime TenDaysAfter = now.plusDays(10);
	       
	       LocalDateTime fortyFiveDaysAfter = now.plusDays(45);
	       LocalDateTime friday5 = fortyFiveDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       
	       LocalDateTime fortySevenDaysAfter = now.plusDays(65);
	       LocalDateTime friday6 = fortySevenDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       
	       LocalDateTime fortyNineDaysAfter = now.plusDays(74);
	       LocalDateTime friday7 = fortyNineDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       
	       LocalDateTime TwalveDaysAfter = now.plusDays(12);
	       
	       LocalDateTime sixDaysBehind = now.minusDays(6);
			
	       LocalDateTime sixDaysAfter = now.plusDays(6);
			
			DateTimeFormatter formatter_2 = DateTimeFormatter.ofPattern("dd/MM/yyyy 10:15");
			
			
			DateTimeFormatter formatter_3 = DateTimeFormatter.ofPattern("dd/MM/yyyy 03:15");
			
			DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			String curentDate=(NextDaysAfter).format(formatter_2);
			
			  
			  String praposalDocLastSeling  =(friday1).format(formatter_3);
			  System.out.println(praposalDocLastSeling);
			  
			  String ProposalmeetingStar  =(friday).format(formatter_3);
			  
			  System.out.println("ProposalmeetingStarting:" +ProposalmeetingStar);
			  
			  String ProposalmeetingEnd  =(friday3).format(formatter_3);
			  
			  String SecuritySubmission  =(friday4).format(formatter_3);
			  
			  String ProposalClosing  =(friday5).format(formatter_3);
			  
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			  
			  String ProposalOpening  =(friday5).format(formatter_3);
			  
			  String StartDate  =(friday6).format(formatter_1);
			  
			  String CompletionDate   =(friday7).format(formatter_1);
			
			  String format_2=(sixDaysBehind).format(formatter_1);
			 
			  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			  String format=(sixDaysAfter).format(formatter_1);
			 
			  selectDateByJs(driver,ProposalPublicationDateandTime,curentDate);
			  selectDateByJs(driver,ProposalDocumentlastsellingdownloadingDateandTime,praposalDocLastSeling);
			  selectDateByJs(driver,ProposalmeetingStartDateandTime,ProposalmeetingStar);
			  selectDateByJs(driver,ProposalmeetingEndDateandTime,ProposalmeetingEnd);
			  selectDateByJs(driver,ProposalClosingDateandTime,ProposalClosing);
			  selectDateByJs(driver,ProposalOpeningDateandTime,ProposalOpening);
			  selectDateByJs(driver,ProposalSecuritySubmission,SecuritySubmission);
			  
			  
			  Thread.sleep(2000);
				 driver.switchTo().frame(0);
				 Thread.sleep(1000);
				 
				 EligibilityofTendererTextBox.sendKeys("eligible for this  tender");
				 
				 driver.switchTo().defaultContent();
				 
				 driver.switchTo().frame(1);
				 Thread.sleep(1000);
				 
				 BriefDescriptionofGoodsandRelatedService.sendKeys("Discription of  tender");
				 
				 driver.switchTo().defaultContent();
				 
				 ProposalDocumentPrice.sendKeys("3000");
				 
				 js.executeScript("window.scrollBy(0,3000)");
				 
				 Location.sendKeys("dhaka");
				 
				 ProposalSecurityAmountInBDT.sendKeys("3800");
				 
				 selectDateByJs(driver,StartDateEle,StartDate);
				 
				 Thread.sleep(2000);
				
					
				selectDateByJs(driver,CompletionDateEle,CompletionDate);
				
				js.executeScript("arguments[0].click();", submitToRadiobtn);
				
				Thread.sleep(200);
				
			String strTid	= TenderId.getText();
				
				System.out.println(strTid);
				
				
				
			
				File fnew= new File(FileReaderManager.getInstance().getConfigReader().getTenderID_1Path());

				if (fnew.exists() && fnew.isFile())
				  {
				  fnew.delete();
				  }

				System.out.println("File Creating...."+"\n");


				try {
				    System.out.println("Writing Content in file....."+"\n");
				    FileWriter f2 = new FileWriter(fnew, false);
				    f2.write(strTid);
				    System.out.println("Writing Content in File completed ....."+"\n");
				    f2.close();
				    System.out.println("Flie Closed Successfully"+"\n");
				  
				   
				    
				} catch (IOException e) {
				    e.printStackTrace();
				}



				
				
				
				
				
				
				
				
				
				Select slctntr = new Select(StandardTenderProposalDocument);
				slctntr.selectByValue("25");
				
				ProposalValidityInNoofDays.sendKeys("15"); 
				// ProposalValidityInNoofDays minimum should be 15 days 
				
				ProposalSecurityValidityInNoofDays.click();
				
				// Proposal Security Validity In No. of Days will be 43 
				
				//Select slctPreq = new Select(DomesticPreferenceRequires);
				//slctPreq.selectByValue("No");
				
				js.executeScript("arguments[0].click();", SubmitButon2TenderPraposal);
				 
				
				AddOfficialCostEstimate.click();
				
				OfficialCostEstimate.sendKeys("20000");
				
				
				
				js.executeScript("arguments[0].click();", OfficialCostEstimateSubmit);
				
				//GoToDashBoard.click();
				
				DocumentLink.click();
				
				 Thread.sleep(2000);
				
		
				js.executeScript("window.scrollBy(0,800)");
				
				FormDashBordTenderSubmissionLetter.click();
				
				FillUpTheTables.click();
				
				CheckBoxCheck.click();
				
				
				
				formSubmit.click();
				 Thread.sleep(2000);
				 
				   Alert alet3=driver.switchTo().alert();
				   alet3.accept();	
				
				//FormDashBord.click();
				TenderProposalDocument.click();
				
				
				js.executeScript("window.scrollBy(0,800)");
				
				FormDashboardTechnicalSpecifications.click();
				
                FillUpTheTables.click();
				
				CheckBoxCheck.click();
				
				
				formSubmit.click();
				   Alert alet4=driver.switchTo().alert();
				   alet4.accept();	
				//FormDashBord.click();
				
				TenderProposalDocument.click();
				js.executeScript("window.scrollBy(0,1000)");
				FormDasbordPriceAndDeliveryScheduleforGood.click();
				
				   FillUpTheTables.click();
				   
				  
				   CheckBoxCheck.click();
				   
				   ItemNo.sendKeys("11");
				   
				   ColumnHeader.sendKeys("sdjsdsa");
				   
				   DescriptionofItem.sendKeys("sdjjsjdks");
				   
				   MeasurementUnit.sendKeys("14");
				   
				   Quantity.sendKeys("sdgffsds");
				 
				   DeliveryPeriodindays.sendKeys("4");
				   
				   Thread.sleep(2000);
				   formSubmit.click();
				   Alert alet=driver.switchTo().alert();
				   alet.accept();	   
				   
				   //FormDashBord.click();
				   Thread.sleep(2000);
					TenderProposalDocument.click();
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(0,800)");
					PriceAndCompletionScheduleForRelatedServices.click();
					
					FillUpTheTables.click();
					   
					CheckBoxCheck.click();
					
					ItemNo.sendKeys("11");
					   
					   ColumnHeader.sendKeys("sdjsdsa");
					   
					   DescriptionofItem.sendKeys("sdjjsjdks");
					   
					   MeasurementUnit.sendKeys("14");
					   
					   Quantity.sendKeys("sdgffsds");
					 
					   DeliveryPeriodindays.sendKeys("4");
					   Thread.sleep(2000);
					   formSubmit.click();
					   Alert alet2=driver.switchTo().alert();
					   alet.accept();	   
					   //FormDashBord.click();
					   Thread.sleep(2000);
						TenderProposalDocument.click();
						
						GrandSummary.click();
						Thread.sleep(2000);
						
						js.executeScript("arguments[0].click();", GrandSummarySubmit);
						
						TenderProposalDocument.click();
						Thread.sleep(2000);
						UnnElee.click();
						EvaluationLink.click();
						//js.executeScript("arguments[0].click();", EvaluationLink);
						
						
						EvaluationCommitteeCreate.click();
						unassryeleemm.click();
						CommitteeName.sendKeys("Evl Comm");
						
						AddMembers.click();
						
						
						//Window Handling
						Thread.sleep(2000);
						String Parent_Window = driver.getWindowHandle();  
						for (String handle : driver.getWindowHandles()) {

						     driver.switchTo().window(handle);
						     
						     }
						//Switching back to Parent Window  
						 
						
						AOUserAsMember.click();
						
						HopeUserAsMember.click();
						
						Addmembers.click();
						
						
						 
						driver.switchTo().window(Parent_Window);  
						driver.switchTo().defaultContent();
						System.out.println("Windows come to back");
						 
						
						Thread.sleep(2000);
						
						 js.executeScript("window.scrollBy(0,300)");
						
						
						Select slctAo = new Select(CommitteeRoleAOUser);
						slctAo.selectByValue("m");
						
						//Select slctHope = new Select(CommitteeRoleHopeUser);
						//slctHope.selectByValue("cp");
						
						//unnasrypageele.click();
						Thread.sleep(2000);
						//submitcommMem.sendKeys(Keys.RETURN);
						js.executeScript("arguments[0].click();", submitcommMem);
						//submitcommMem.click();
						
						//CreateWorkFlow.click();
						//WorkFlowCrt wfcrt= new WorkFlowCrt();
						//wfcrt.CreateWorkFlow();
						WorkFlowCrt wfcrt=	PageFactory.initElements(driver, WorkFlowCrt.class);
						wfcrt.CreateWorkFlow();
						wfcrt.HopeUserActivity();
						wfcrt.AppPublisheTender();


						
						Thread.sleep(2000);
						
						EvaluationLink.click();
						NotifyCommitteeMembers.click();
						
						js.executeScript("window.scrollBy(0,300)");
						
						txtRemarks.sendKeys("Remarks");
						
						NotifyBtn.click();
						Thread.sleep(2000);
						ponnnusgh.click();
						OpeningLink.click();
						wfcrt.OpningCommitteeCreate();
						Thread.sleep(2000);
						//CreateWorkFlow.click();
						wfcrt.CreateWorkFlow();
						wfcrt.HopeUserActivity();
						wfcrt.AppPublisheTender();
						
						Thread.sleep(2000);
						
						OpeningLink.click();
                        NotifyCommitteeMembers.click();
						
						js.executeScript("window.scrollBy(0,300)");
						
						txtRemarks.sendKeys("Remarks");
						
						NotifyBtn.click();
						Thread.sleep(2000);
						opningdummy.click();
						NoticeLink.click();
						
						NoticeCreateMemmber.click();
						
						memberHopeChckBx.click();
						memberAoeChckBx.click();
						
						js.executeScript("arguments[0].click();", Submtmmbr);
						NoticeLink.click();
						Thread.sleep(2000);
						//Alert alert =driver.switchTo().alert();
						//alert.accept();
						//driver.switchTo().defaultContent();
						
                        ConfigureNoticeTab.click();
						
						
						
						Select slctconfr = new Select(ClarificationTenderIsTobeallowed);
						slctconfr.selectByValue("No");
						
						submitConfm.click();
						
						NoticeLink.click();
						Thread.sleep(2000);
						//Alert alert =driver.switchTo().alert();
						//alert.accept();
						//driver.switchTo().defaultContent();
						//Thread.sleep(3000);
						//NoticeLink.click();
						//opniningfrted.click();
						
						//CreateWorkFlow.click();
						
						
						wfcrt.CreateWorkFlowForNotice();
						Thread.sleep(2000);
						
						PublishTender.click();
						js.executeScript("window.scrollBy(0,1000)");
						commentstToPublishTender.sendKeys("Tender ");
						PublishSubmitBtn.click();
						//wfcrt.CreateWorkFlow();
						//wfcrt.HopeUserActivity();
						
						
						Thread.sleep(10000);
						
						driver.navigate().refresh();
						
						//NoticeLink.click();
						
						//ConfigureNoticeTab.click();
						
						
						
						//Select slctconfr = new Select(ClarificationTenderIsTobeallowed);
						//slctconfr.selectByValue("No");
						
						//submitConfm.click();

						
                       
			

	}
	
	
	
	
	
	//%%%%%%%%%%####@@@ TEnder Creation For Work With Revenue 
	
	
	
	
	
public void TenderWorkRev() throws Throwable {
		
		// Overridden file will call here for APP id 
File src= new File(FileReaderManager.getInstance().getConfigReader().getAppWorkRevPath());
		
FileInputStream fis = new FileInputStream(src);
String strngAppId = IOUtils.toString(fis);
		
		SerchAPPID.sendKeys(strngAppId);
		
		 Select app = new Select(Status);
	      
	       app.selectByValue("Approved");
	       
	       js.executeScript("arguments[0].click();", SerchAppIdBtn);
	       
	       js.executeScript("arguments[0].click();", DashBordClick);
	       
	       js.executeScript("window.scrollBy(0,1000)");
	       
	       ClickToCreateTender.click();
	       
	       InvitationReferenceNoTextField.sendKeys("214563");
	       
	       LocalDateTime now = LocalDateTime.now();
	       LocalDateTime NextDaysAfter = now.plusDays(1);
	       LocalDateTime friday = NextDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       
	       
	       LocalDateTime sevenDaysAfter = now.plusDays(21);
	       LocalDateTime friday1 = sevenDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       System.out.println(friday1);
	       
	       LocalDateTime oneDaysAfter = now.plusDays(2);
	       LocalDateTime friday2 = oneDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       
	       LocalDateTime SixDaysAfter = now.plusDays(14);
	       LocalDateTime friday3 = SixDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       
	       LocalDateTime EightDaysAfter = now.plusDays(8);
	       LocalDateTime friday4 = EightDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       
	       LocalDateTime NineDaysAfter = now.plusDays(9);
	       LocalDateTime fridaySecuritySubmission = NineDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       LocalDateTime TenDaysAfter = now.plusDays(10);
	       
	       LocalDateTime fortyFiveDaysAfter = now.plusDays(45);
	       LocalDateTime friday5 = fortyFiveDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       
	       LocalDateTime fortySevenDaysAfter = now.plusDays(65);
	       LocalDateTime friday6 = fortySevenDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       
	       LocalDateTime fortyNineDaysAfter = now.plusDays(74);
	       LocalDateTime friday7 = fortyNineDaysAfter.with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) ).plusDays(2);
	       
	       LocalDateTime TwalveDaysAfter = now.plusDays(12);
	       
	       LocalDateTime sixDaysBehind = now.minusDays(6);
			
	       LocalDateTime sixDaysAfter = now.plusDays(6);
			
			DateTimeFormatter formatter_2 = DateTimeFormatter.ofPattern("dd/MM/yyyy 10:15");
			
			
			DateTimeFormatter formatter_3 = DateTimeFormatter.ofPattern("dd/MM/yyyy 03:15");
			
			DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			String curentDate=(NextDaysAfter).format(formatter_2);
			
			  
			  String praposalDocLastSeling  =(friday1).format(formatter_3);
			  System.out.println(praposalDocLastSeling);
			  
			  String ProposalmeetingStar  =(friday).format(formatter_3);
			  
			  System.out.println("ProposalmeetingStarting:" +ProposalmeetingStar);
			  
			  String ProposalmeetingEnd  =(friday3).format(formatter_3);
			  
			  String SecuritySubmission  =(friday4).format(formatter_3);
			  
			  String ProposalClosing  =(friday5).format(formatter_3);
			  
			  Thread.sleep(2000);
			  
			  String ProposalOpening  =(friday5).format(formatter_3);
			  
			  String StartDate  =(friday6).format(formatter_1);
			  
			  String CompletionDate   =(friday7).format(formatter_1);
			
			  String format_2=(sixDaysBehind).format(formatter_1);
			 
			  Thread.sleep(2000);
			  String format=(sixDaysAfter).format(formatter_1);
			 
			  selectDateByJs(driver,ProposalPublicationDateandTime,curentDate);
			  selectDateByJs(driver,ProposalDocumentlastsellingdownloadingDateandTime,praposalDocLastSeling);
			  selectDateByJs(driver,ProposalmeetingStartDateandTime,ProposalmeetingStar);
			  selectDateByJs(driver,ProposalmeetingEndDateandTime,ProposalmeetingEnd);
			  selectDateByJs(driver,ProposalClosingDateandTime,ProposalClosing);
			  selectDateByJs(driver,ProposalOpeningDateandTime,ProposalOpening);
			  selectDateByJs(driver,ProposalSecuritySubmission,SecuritySubmission);
			  
			  
			  Thread.sleep(2000);
				 driver.switchTo().frame(0);
				 Thread.sleep(1000);
				 
				 EligibilityofTendererTextBox.sendKeys("eligible for this  tender");
				 
				 driver.switchTo().defaultContent();
				 
				 driver.switchTo().frame(1);
				 Thread.sleep(1000);
				 
				 BriefDescriptionofGoodsandRelatedService.sendKeys("Discription of  tender");
				 
				 driver.switchTo().defaultContent();
				 
				 ProposalDocumentPrice.sendKeys("3000");
				 
				 js.executeScript("window.scrollBy(0,3000)");
				 
				 Location.sendKeys("dhaka");
				 
				 ProposalSecurityAmountInBDT.sendKeys("3800");
				 
				 selectDateByJs(driver,StartDateEle,StartDate);
				 
				 Thread.sleep(2000);
				
					
				selectDateByJs(driver,CompletionDateEle,CompletionDate);
				
				js.executeScript("arguments[0].click();", submitToRadiobtn);
				
				Thread.sleep(200);
				
			String strTid	= TenderId.getText();
				
				System.out.println(strTid);
				
				
				
				File fnew=new File(FileReaderManager.getInstance().getConfigReader().getTenderWorkRevPath());

				if (fnew.exists() && fnew.isFile())
				  {
				  fnew.delete();
				  }

				System.out.println("File Creating...."+"\n");


				try {
				    System.out.println("Writing Content in file....."+"\n");
				    FileWriter f2 = new FileWriter(fnew, false);
				    f2.write(strTid);
				    System.out.println("Writing Content in File completed ....."+"\n");
				    f2.close();
				    System.out.println("Flie Closed Successfully"+"\n");
				  
				   
				    
				} catch (IOException e) {
				    e.printStackTrace();
				}



				
				
				
				Select slctntr = new Select(StandardTenderProposalDocument);
				slctntr.selectByValue("44");
				//if work with revenue amount is above 2 crore than form  PWD3  ByValue("44")
				//if work with revenue amount is upto 2 crore than form  PW2A  ByValue("5")
				ProposalValidityInNoofDays.sendKeys("15"); 
				// ProposalValidityInNoofDays minimum should be 15 days 
				
				ProposalSecurityValidityInNoofDays.click();
				
				// Proposal Security Validity In No. of Days will be 43 
				
				
				js.executeScript("arguments[0].click();", SubmitButon2TenderPraposal);
				
				Alert altr =driver.switchTo().alert();
				altr.accept();
				
                AddOfficialCostEstimate.click();
				
				OfficialCostEstimate.sendKeys("50000000");
				
				js.executeScript("arguments[0].click();", OfficialCostEstimateSubmit);
				
				
				WorkFlowCrt wfcrt=	PageFactory.initElements(driver, WorkFlowCrt.class);
				
				wfcrt.DocumentLinkActivityForFormPW3();
				
				 js.executeScript("window.scrollBy(0,2000)");
				 Thread.sleep(2000);
				 //unnesscreategrand.click();
				//GrandSummary.click(); 
				js.executeScript("arguments[0].click();", GrandsummaryForWork);
				Thread.sleep(2000);
				
				
				js.executeScript("arguments[0].click();", GrandSummarySubmit);
				
				String Parent_Window = driver.getWindowHandle();  
				for (String handle : driver.getWindowHandles()) {

				  driver.switchTo().window(handle);
				  
				  }


				CreateNewFormConfirmation.click();

				
				driver.switchTo().window(Parent_Window);  
				driver.switchTo().defaultContent();
				
				
				
				TenderProposalDocument.click();
				Thread.sleep(2000);
				UnnElee.click();
				EvaluationLink.click();
				
				EvaluationCommitteeCreate.click();
				unassryeleemm.click();
				CommitteeName.sendKeys("Evl Comm");
				
				AddMembers.click();
				
				
				//Window Handling
				Thread.sleep(2000);
				String Parent_Window_2 = driver.getWindowHandle();  
				for (String handle : driver.getWindowHandles()) {

				     driver.switchTo().window(handle);
				     
				     }
				//Switching back to Parent Window  
				 
				
				AOUserAsMember.click();
				
				HopeUserAsMember.click();
				
				Addmembers.click();
				
				
				 
				driver.switchTo().window(Parent_Window_2);  
				driver.switchTo().defaultContent();
				System.out.println("Windows come to back");
				 
				
				Thread.sleep(2000);
				
				 js.executeScript("window.scrollBy(0,300)");
				
				
				Select slctAo = new Select(CommitteeRoleAOUser);
				slctAo.selectByValue("m");
				
				//Select slctHope = new Select(CommitteeRoleHopeUser);
				//slctHope.selectByValue("cp");
				
				//unnasrypageele.click();
				Thread.sleep(2000);
				//submitcommMem.sendKeys(Keys.RETURN);
				js.executeScript("arguments[0].click();", submitcommMem);
				//submitcommMem.click();
				
				wfcrt.CreateWorkFlowForNotice();
				
				
				
                NotifyCommitteeMembers.click();
				
				js.executeScript("window.scrollBy(0,300)");
				
				txtRemarks.sendKeys("Remarks");
				
				NotifyBtn.click();
				
				
			
				Thread.sleep(2000);
				ponnnusgh.click();
				OpeningLink.click();
				wfcrt.OpningCommitteeCreate();
				Thread.sleep(2000);
				
                wfcrt.CreateWorkFlowForNotice();
				
				NotifyCommitteeMembers.click();
				
				js.executeScript("window.scrollBy(0,300)");
				
				txtRemarks.sendKeys("Remarks");
				
				NotifyBtn.click();
				Thread.sleep(2000);
				opningdummy.click();
				NoticeLink.click();
				
				NoticeCreateMemmber.click();
				
				memberHopeChckBx.click();
				memberAoeChckBx.click();
				
				js.executeScript("arguments[0].click();", Submtmmbr);
				NoticeLink.click();
				Thread.sleep(2000);
				//Alert alert =driver.switchTo().alert();
				//alert.accept();
				//driver.switchTo().defaultContent();
				/*
                ConfigureNoticeTab.click();
				
				
				
				Select slctconfr0 = new Select(ClarificationTenderIsTobeallowed);
				slctconfr0.selectByValue("No");
				
				submitConfm.click();
				*/
				//NoticeLink.click();
				//Thread.sleep(2000);
				//Alert alert =driver.switchTo().alert();
				//alert.accept();
				//driver.switchTo().defaultContent();
				//Thread.sleep(3000);
				//NoticeLink.click();
				//opniningfrted.click();
				
				//CreateWorkFlow.click();
				
				
				wfcrt.CreateWorkFlowForNotice();
				Thread.sleep(2000);
               
				
				
                ConfigureNoticeTab.click();
				
				
				
				Select slctconfr0 = new Select(ClarificationTenderIsTobeallowed);
				slctconfr0.selectByValue("No");
				
				submitConfm.click();
				
				Thread.sleep(2000);
				PublishTender.click();
				js.executeScript("window.scrollBy(0,1000)");
				commentstToPublishTender.sendKeys("Tender ");
				PublishSubmitBtn.click();
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				driver.navigate().refresh();
	
	
}
	
	
	
}
