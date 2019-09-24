package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.egp.qa.base.TestBase;
import com.egp.qa.configfilereader.FileReaderManager;
//import com.egp.qa.evaluation.otm.testcases.CreateDevelopmentBudgetWorkOTMEvaluation_AdvertisementTestCase;
import com.egp.qa.helper.logger.LoggerHelper;

/**
*
* @author SHIVANSHU SHANDILYA
*/

public class LoginPage  extends TestBase{
	
	private Logger log = LoggerHelper.getLogger(LoginPage.class);
	
	//Page Factory - OR:
	@FindBy(id="txtEmailId") 
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	//@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	//WebElement signUpBtn;
	
	@FindBy(xpath="/html/body/div[1]/div/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/b")
	WebElement WelcomeUser;
	
	@FindBy(xpath="//img[@src='/resources/images/cptuEgpLogo.gif']")
	WebElement cptuLogo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	//Actions: diff feature available on the login page
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return cptuLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}
	
	public HomePage loginWithPe() {
		log.info("****** loginWithPe *****");
		username.sendKeys(FileReaderManager.getInstance().getConfigReader().getUserNamePe());
		password.sendKeys(FileReaderManager.getInstance().getConfigReader().getPasswordPe());
		js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}

	public HomePage loginWithHope() {
		username.sendKeys(FileReaderManager.getInstance().getConfigReader().getUserNameHope());
		password.sendKeys(FileReaderManager.getInstance().getConfigReader().getPasswordHope());
		js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}
	
	/***
	 * login with branchmaker
	 * @return
	 */
	public HomePage loginWithBranchMaker() {
		username.sendKeys(FileReaderManager.getInstance().getConfigReader().getUserNameBranchMaker());
		password.sendKeys(FileReaderManager.getInstance().getConfigReader().getPasswordBranchMaker());
		js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}
	
	public HomePage loginWithBranchChecker() {
		username.sendKeys(FileReaderManager.getInstance().getConfigReader().getUserNameBranchChecker());
		password.sendKeys(FileReaderManager.getInstance().getConfigReader().getPasswordBranchChecker());
		js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}
	
	public HomePage loginWithTenderer() {
		username.sendKeys(FileReaderManager.getInstance().getConfigReader().getUserNameTenderer());
		password.sendKeys(FileReaderManager.getInstance().getConfigReader().getPasswordTenderer());
		js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}
	
	public HomePage loginWithTenderer2() {
		username.sendKeys(FileReaderManager.getInstance().getConfigReader().getUserNameTenderer2());
		password.sendKeys(FileReaderManager.getInstance().getConfigReader().getPasswordTenderer2());
		js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}
	
	public HomePage loginWithTendererText(String tendererName, String RunType) {
		username.sendKeys(tendererName);
		password.sendKeys(FileReaderManager.getInstance().getConfigReader().getPasswordTenderer2());
		js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}
	
	/**
	 * login with egpao user - opening tender process
	 * @return
	 */
	public HomePage loginWithEgpAOUser() {
		username.sendKeys(FileReaderManager.getInstance().getConfigReader().getUserNameEGPAOUser());
		password.sendKeys(FileReaderManager.getInstance().getConfigReader().getPasswordEGPAOUser());
		js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}
	
	public HomePage loginWithEgpBODUser() {
		username.sendKeys(FileReaderManager.getInstance().getConfigReader().getUserNameEGPBODUser());
		password.sendKeys(FileReaderManager.getInstance().getConfigReader().getPasswordEGPBODUser());
		js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}
	
	public HomePage loginWithEgpTECUser() {
		username.sendKeys(FileReaderManager.getInstance().getConfigReader().getUserNameEGPTECUser());
		password.sendKeys(FileReaderManager.getInstance().getConfigReader().getPasswordEGPTECUser());
		js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}

}
