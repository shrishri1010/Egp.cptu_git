package com.egp.qa.annualprocurement.testcases1;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.egp.qa.base.TestBase;
import com.egp.qa.helper.logger.LoggerHelper;

import com.egp.qa.utilities.TestUtil;
import com.pages.AppLtmWorkPage;
import com.pages.CreateAppPage;
import com.pages.LoginPage;

/**
 *
 * @author Shrikanth Kulal
 */

public class AnnualProcPlan_LTM_EPW2B_WorksTestCase extends TestBase {

	private Logger log = LoggerHelper.getLogger(AnnualProcPlan_LTM_EPW2B_WorksTestCase.class);
	com.pages.LoginPage loginPage;
	com.pages.HomePage homePage;
	TestUtil testUtil;
	com.pages.CreateAppPage createApp;
	com.pages.MyAppPage myAppPage;
	AnnualProcPlan_LTM_EPW2B_WorksTestCase appLTMWorksTest;
	String sheetName = "AppCreation";
	// public ExtentReports extent;
	// public ExtentTest extentTest;

	public AnnualProcPlan_LTM_EPW2B_WorksTestCase() {
		super();
	}

	/*
	 * @BeforeTest public void setExtent(){ extent = new
	 * ExtentReports(System.getProperty("user.dir")+
	 * "/test-output/ExtentReport.html", true); extent.addSystemInfo("Host Name",
	 * FileReaderManager.getInstance().getConfigReader().getSystemHostNamePath());
	 * extent.addSystemInfo("User Name",
	 * FileReaderManager.getInstance().getConfigReader().getSystemUserNamePath());
	 * extent.addSystemInfo("Environment",
	 * FileReaderManager.getInstance().getConfigReader().getSystemEnvironmentPath())
	 * ; }
	 */

	@BeforeMethod
	public void setUp(Method method) {
		initialization();
		testUtil = new TestUtil();
		createApp = new CreateAppPage();
		loginPage = new LoginPage();
		homePage = loginPage.loginWithPe();
		myAppPage = homePage.clickOnMyAppLink();
		String testName = method.getName();
		System.out.println("testName in registerMethod is :" + testName);
		extentTest = extentreport.createTest(testName);
	}

	/**
	 * @param BudgetType
	 * @param FinancialYear
	 * @param selectProject1
	 * @param appCode
	 * @param ProcurementNature
	 * @param TypeofEmergency
	 * @param PackageNo
	 * @param PackageDescription
	 * @param LotNo
	 * @param LotDescription
	 * @param Quantity
	 * @param unit
	 * @param EstimatedCost
	 * @param ApprovingAuthority
	 * @param ProcurementType
	 * @param ProcurementMethod
	 * @throws Throwable
	 */
	
	//App creation
	//@Test(priority=1, enabled=true, groups= {"sanity"}, dataProvider="addnewpackagedata")
	public void appCreationTest(String BudgetType, String FinancialYear, String selectProject1, String appCode,
			String ProcurementNature, String TypeofEmergency, String PackageNo, String PackageDescription, String LotNo,
			String LotDescription, String Quantity, String unit, String EstimatedCost, String ApprovingAuthority,
			String PQRequires, String ProcurementType, String ProcurementMethod, String FinancialEstimatedCost,
			String RunType) throws Throwable {
		// ExtentTest = extent.startTest("appCreationTest");
		log.info("****** appCreationTest *****");
		//MyScreenRecorder.startRecording("navigationTest");

		// createApp.createNewApp();
		AppLtmWorkPage appltmwork = PageFactory.initElements(driver, AppLtmWorkPage.class);

		// Call method
		appltmwork.Development_Budget_Works_LTM_TestCase(BudgetType, FinancialYear, selectProject1, appCode,
				ProcurementNature, TypeofEmergency, PackageNo, PackageDescription, LotNo, LotDescription, Quantity,
				unit, EstimatedCost, ApprovingAuthority, ProcurementType, ProcurementMethod, FinancialEstimatedCost,
				RunType);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "BudgetType is :" + BudgetType);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "FinancialYear is :" + FinancialYear);
		// extentTest.log(com.aventstack.extentreports.Status.INFO,
		// testUtil.randomNoApp());
		
		extentTest.log(com.aventstack.extentreports.Status.INFO, "Select project is :" + selectProject1);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "ProcurementNature is :" + ProcurementNature);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "TypeofEmergency is :" + TypeofEmergency);
		// extentTest.log(com.aventstack.extentreports.Status.INFO, "PackageNo is
		// :"+PackageNo);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "PackageDescription is :" + PackageDescription);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "LotNo is :" + LotNo);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "LotDescription is :" + LotDescription);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "Quantity is :" + Quantity);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "Unit is :" + unit);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "EstimatedCost is :" + EstimatedCost);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "ApprovingAuthority is :" + ApprovingAuthority);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "ProcurementType is :" + ProcurementType);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "ProcurementMethod is :" + ProcurementMethod);
		//MyScreenRecorder.stopRecording();
	}

	/**
	 * generateTenderIdTest from Annual procurement package
	 * @throws Throwable
	 */
	@Test(priority = 2, enabled = true, dataProvider = "addnewpackagedata")
	public void generateTenderIdTest(String BudgetType, String FinancialYear, String selectProject1, String appCode,
			String ProcurementNature, String TypeofEmergency, String PackageNo, String PackageDescription, String LotNo,
			String LotDescription, String Quantity, String unit, String packageEstimatedCost, String ApprovingAuthority,
			String PQRequires,String ProcurementType, String ProcurementMethod, String FinancialEstimatedCost, String RunType)
			throws Throwable {
		// extentTest = extent.startTest("appCreationTest");
		log.info("****** generateTenderIdTest *****");
		//MyScreenRecorder.startRecording("navigationTest");
		// createApp.createNewApp();
		AppLtmWorkPage appltmwork = PageFactory.initElements(driver, AppLtmWorkPage.class);

		System.out.println("packageCost is JOJI--->> " + packageEstimatedCost);
		
		//Call method
		if (RunType.equals("Y")) {
			//Create tenderIdGeneration method in AppLtmWork separate
			appltmwork.tenderIdGenerationForEPW2B_LTM_Works(FinancialEstimatedCost, packageEstimatedCost);
		}
		extentTest.log(com.aventstack.extentreports.Status.INFO, "BudgetType is :" + BudgetType);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "FinancialYear is :" + FinancialYear);
		// extentTest.log(com.aventstack.extentreports.Status.INFO,
		// testUtil.randomNoApp());
		extentTest.log(com.aventstack.extentreports.Status.INFO, "Select project is :" + selectProject1);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "ProcurementNature is :" + ProcurementNature);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "TypeofEmergency is :" + TypeofEmergency);
		// extentTest.log(com.aventstack.extentreports.Status.INFO, "PackageNo is
		// :"+PackageNo);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "PackageDescription is :" + PackageDescription);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "LotNo is :" + LotNo);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "LotDescription is :" + LotDescription);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "Quantity is :" + Quantity);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "Unit is :" + unit);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "package EstimatedCost is :" + packageEstimatedCost);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "ApprovingAuthority is :" + ApprovingAuthority);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "ProcurementType is :" + ProcurementType);
		extentTest.log(com.aventstack.extentreports.Status.INFO, "ProcurementMethod is :" + ProcurementMethod);
		//MyScreenRecorder.stopRecording();
	}

	@AfterTest
	public void endReport() {
		extentreport.flush();
		// driver.close();
	}
	
	@DataProvider(name = "addnewpackagedata")
	public Object[][] getAppDevelopmentBudgetOTMTestData() {
		Object data[][] = getExcelData("EgpTestData.xlsx", "appDevptBudgetWorksLTMEPW2B");
		return data;
	}

	/*
	 * @DataProvider(name="addNewPackageCost") public Object[][]
	 * getAppDevelopmentBudgetRFQTestData(){ Object data[][] =
	 * getExcelData("EgpTestData.xlsx", "PackageCost"); return data; }
	 */

	/**
	 * @author Shrikanth kulal
	 */
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		/*
		 * System.out.println("@@@AfterMethod is --->>");
		 * System.out.println("result.getStatus is"+result.getStatus());
		 * System.out.println("result.getName is"+result.getName());
		 * System.out.println("result.getthrowable is"+result.getThrowable());
		 * System.out.println("ITestResult.FAILURE is"+ITestResult.FAILURE);
		 */
		/*
		 * if (ITestResult.FAILURE==result.getStatus()) {
		 * Utilities.captureScreenshot(result.getName()); test.log(LogStatus.FAIL,
		 * result.getThrowable()); } report.endTest(test);
		 */
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "The test method named as : " + result.getName() + " is passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			TestUtil.captureScreenshot(result.getName());
			extentTest.log(Status.PASS, "The test method named as : " + result.getName() + " is Failed");
			extentTest.log(Status.FAIL, "Test failure : " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "The test method named as : " + result.getName() + " is skipped");
		}
	}
	
}
