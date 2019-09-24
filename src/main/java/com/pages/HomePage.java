package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.egp.qa.base.TestBase;

/**
*
* @author SHIVANSHU SHANDILYA
*/
public class HomePage extends TestBase {
	@FindBy(xpath = "//b[contains(text(),'Welcome,')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@id='headTabApp']")
	WebElement applink;
	
	@FindBy(linkText = "Create APP")
	WebElement CreateAppLink;
	
	@FindBy(xpath = "//ul[@id='submenu-configuration']/li[2]/a")
	WebElement MyAppLink;

	@FindBy(xpath = "//a[contains(text(),'tender')]")
	WebElement TenderLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement newTenderLink;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	
	@FindBy(xpath="//img[@src='/resources/images/Dashboard/e-GP.gif']")
	WebElement egpLogo;
	
	@FindBy(xpath="//a[@id='headTabPayment']")
	WebElement paymentLink;
	
	@FindBy(xpath="//a[@id='headTabTender']")
	WebElement tendermenu;
	
	@FindBy(xpath="//ul[@id='ddsubmenu2']/li[2]/a[text()='My Tender']")
	WebElement myTenderLink;
	
	@FindBy(xpath="//ul[@id='ddsubmenu2']/li[2]/a[text()='My Tenders']")
	WebElement myTenderLink1;
	
	@FindBy(xpath="//ul[@id='ddsubmenu2']/li[3]/a[text()='Limited Tenders']")
	WebElement limitedTenderLink;
	
	@FindBy(xpath="//ul[@id='paymentsubmenu']/li[2]/a[contains(text(),'Tender Payment')]")
	WebElement tenderPaymentLink;
	
	@FindBy(xpath="//ul[@id='ddsubmenu2']/li[4]/a[text()='All Tenders']")
	WebElement allTendersLink;
	
	@FindBy(xpath="//*[@id='headTabEval']")
	WebElement evaluationTab;
	
	@FindBy(xpath="//a[@id='headTabWorkFlow']")
	WebElement workFlowMenu;
	
	@FindBy(xpath="//ul[@id='ddsubmenu3']/li/a[contains(text(),'Pending task')]")
	WebElement pendingTask;
	
	@FindBy(xpath="//*[@id='evalMenu']/li[1]/a[contains(text(),'Opening Committee')]")
	WebElement openingCommiteeLink;
	
	@FindBy(xpath="//*[@id='evalMenu']/li[2]/a[contains(text(),'Evaluation Committee')]")
	WebElement evaluationCommittee;
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public boolean verifyLogOutLink() {
		return logout.isDisplayed();
	}
	
	public boolean validateEgpImage() {
		return egpLogo.isDisplayed();
	}
	
	
	/*public CreateApp clickOnAppLink(){
		appLink.click();
		return new CreateApp();
	}*/
	
	public TenderPage clickOnTenderLink(){
		TenderLink.click();
		return new TenderPage();
	}
	
	/*public WorkFlowPage clickOnWorkFlowLink(){
	tasksLink.click();
	return new TasksPage();
	*/
	
	public CreateAppPage clickOnCreateAppLink(){
		Actions action = new Actions(driver);
		action.moveToElement(applink).build().perform();
		CreateAppLink.click();
		return new CreateAppPage();
	}
	
	public MyAppPage clickOnMyAppLink(){
		Actions action = new Actions(driver);
		action.moveToElement(applink).build().perform();
		MyAppLink.click();
		return new MyAppPage();
	}
	
	public BranchMakerCheckerPaymentPage clickOnPaymentLinkProcess(){
		Actions action = new Actions(driver);
		action.moveToElement(paymentLink).build().perform();
		tenderPaymentLink.click();
		return new BranchMakerCheckerPaymentPage();
	}
	
	public CreateBidSubmissionParticipateEGPPage clickOnPaymentLink(){
		Actions action = new Actions(driver);
		action.moveToElement(paymentLink).build().perform();
		tenderPaymentLink.click();
		return new CreateBidSubmissionParticipateEGPPage();
	}
	
	public CreateOpeningTenderEGPPage clickOnEvaluationMenu(){
		Actions action = new Actions(driver);
		action.moveToElement(evaluationTab).build().perform();
		openingCommiteeLink.click();
		return new CreateOpeningTenderEGPPage();
	}
	
	public TenderPage clickOnTenderMenu(){
		Actions action = new Actions(driver);
		action.moveToElement(tendermenu).build().perform();
		myTenderLink.click();
		return new TenderPage();
	}
	
	public TenderPage clickOnTenderMenu1(){
		Actions action = new Actions(driver);
		action.moveToElement(tendermenu).build().perform();
		myTenderLink1.click();
		return new TenderPage();
	}
	
	public TenderPage clickOnTenderMenu2(){
		Actions action = new Actions(driver);
		action.moveToElement(tendermenu).build().perform();
		limitedTenderLink.click();
		return new TenderPage();
	}
	public CreateBidSubmissionParticipateEGPPage clickOnTenderMenuLimitedTender(){
		Actions action = new Actions(driver);
		action.moveToElement(tendermenu).build().perform();
		limitedTenderLink.click();
		return new CreateBidSubmissionParticipateEGPPage();
	}
	
	public CreateDevelopmentBudgetWorkEvaluationPage clickOnEvaluationMenuWithEvaluationCommitee(){
		Actions action = new Actions(driver);
		action.moveToElement(evaluationTab).build().perform();
		evaluationCommittee.click();
		return new CreateDevelopmentBudgetWorkEvaluationPage();
	}
	
	public WorkFlowCrt clickOnWorkFlowPendingTask(){
		Actions action = new Actions(driver);
		action.moveToElement(workFlowMenu).build().perform();
		pendingTask.click();
		return new WorkFlowCrt();
	}
	
	public TenderAppDevelopmentBudgetWorkOpenTenderingPage clickOnPaymentLink1(){
		Actions action = new Actions(driver);
		action.moveToElement(paymentLink).build().perform();
		tenderPaymentLink.click();
		return new TenderAppDevelopmentBudgetWorkOpenTenderingPage();
	}
	
	public AppLtmWorkPage clickOnPaymentLinkAppLtmWork(){
		Actions action = new Actions(driver);
		action.moveToElement(paymentLink).build().perform();
		tenderPaymentLink.click();
		return new AppLtmWorkPage();
	}
	
	public CreateBidSubmissionParticipateEGPPage clickOnAllTendersLink(){
		Actions action = new Actions(driver);
		action.moveToElement(tendermenu).build().perform();
		allTendersLink.click();
		return new CreateBidSubmissionParticipateEGPPage();
	}
	
}

	
