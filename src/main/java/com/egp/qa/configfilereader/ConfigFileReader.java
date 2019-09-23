package com.egp.qa.configfilereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


/**
*
* @author SHIVANSHU SHANDILYA
*/

public class ConfigFileReader {
	
	private Properties properties;
	//private final String propertyFilePath= "C:\\eclps2\\EGP.cptu\\src\\main\\java\\com\\E_GP\\QA\\Config\\Configuation.properties";
	private final String propertyFilePath = "D:\\SVN Code Sync\\EGP.cptu\\src\\main\\java\\com\\egp\\qa\\config\\configuration.properties";
	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) 
			return driverPath;
		else 
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	
	public String getTestDataPath(){
		String testDataSheet = properties.getProperty("testDataSheet");
		if(testDataSheet!= null) return testDataSheet;
		else throw new RuntimeException("testDataSheet not specified in the Configuration.properties file.");		
	}
	
	public String getSystemHostNamePath(){
		String systemHostName = properties.getProperty("systemHostName");
		if(systemHostName!= null) return systemHostName;
		else throw new RuntimeException("systemHostName not specified in the Configuration.properties file.");		
	}
	
	public String getSystemUserNamePath(){
		String systemUserName = properties.getProperty("systemUserName");
		if(systemUserName!= null) return systemUserName;
		else throw new RuntimeException("systemUserName not specified in the Configuration.properties file.");		
	}
	
	public String getTenderID_1Path(){
		String TenderID_1Path = properties.getProperty("TenderID_1Path");
		if(TenderID_1Path!= null) return TenderID_1Path;
		else throw new RuntimeException("TenderID_1Path not specified in the Configuration.properties file.");		
	}
	
	public String getTenderRFQGoodPath(){
		String TenderRFQGoodPath = properties.getProperty("TenderRFQGoodPath");
		if(TenderRFQGoodPath!= null) 
			return TenderRFQGoodPath;
		else 
			throw new RuntimeException("TenderRFQGoodPath not specified in the Configuration.properties file.");		
	}
	
	public String getTenderOTMWorkPath(){
		String TenderOTMWorkPath = properties.getProperty("TenderOTMWorkPath");
		if(TenderOTMWorkPath!= null) 
			return TenderOTMWorkPath;
		else 
			throw new RuntimeException("TenderRFQGoodPath not specified in the Configuration.properties file.");		
	}
	
	public String getTenderRFQWorkPath(){
		String TenderRFQWorkPath = properties.getProperty("TenderRFQWorkPath");
		if(TenderRFQWorkPath!= null) 
			return TenderRFQWorkPath;
		else 
			throw new RuntimeException("TenderRFQGoodPath not specified in the configuration.properties file.");		
	}
	
	public String getTenderWorkRevPath(){
		String TenderWorkRevPath = properties.getProperty("TenderWorkRevPath");
		if(TenderWorkRevPath!= null) return TenderWorkRevPath;
		else throw new RuntimeException("TenderRFQGoodPath not specified in the Configuration.properties file.");		
	}
	
	public String getTenderLtmWorkPath(){
		String TenderLtmWorkPath = properties.getProperty("TenderLtmWorkPath");
		if(TenderLtmWorkPath!= null) 
			return TenderLtmWorkPath;
		else 
			throw new RuntimeException("TenderLtmWorkPath not specified in the Configuration.properties file.");		
	}
	
	public String getAppGoodRevenuePath(){
		String AppGoodRevenuePath = properties.getProperty("AppGoodRevenuePath");
		if(AppGoodRevenuePath!= null) 
			return AppGoodRevenuePath;
		else 
			throw new RuntimeException("AppGoodRevenuePath not specified in the Configuration.properties file.");		
	}
	
	public String getAppGoodDevlopementPath(){
		String AppGoodDevlopementPath = properties.getProperty("AppGoodDevlopementPath");
		if(AppGoodDevlopementPath!= null) 
			return AppGoodDevlopementPath;
		else 
			throw new RuntimeException("AppGoodDevlopementPath not specified in the Configuration.properties file.");		
	}
	
	
	public String getAppGoodsOwnPath(){
		String appGoodsOwnPath = properties.getProperty("appGoodsOwnPath");
		if(appGoodsOwnPath!= null) 
			return appGoodsOwnPath;
		else 
			throw new RuntimeException("appGoodsOwnPath not specified in the Configuration.properties file.");		
	}
	
	public String getAppWorkDevPath(){
		String AppWorkDevPath = properties.getProperty("AppWorkDevPath");
		if(AppWorkDevPath!= null) 
			return AppWorkDevPath;
		else 
			throw new RuntimeException("AppWorkDevPath not specified in the Configuration.properties file.");		
	}
	
	public String getAppWorkRevPath(){
		String AppWorkRevPath = properties.getProperty("AppWorkRevPath");
		if(AppWorkRevPath!= null) 
			return AppWorkRevPath;
		else 
			throw new RuntimeException("AppWorkRevPath not specified in the Configuration.properties file.");		
	}
	
	public String getAppLtmWorkPath(){
		String AppLtmWorkPath = properties.getProperty("AppLtmWorkPath");
		if(AppLtmWorkPath!= null) 
			return AppLtmWorkPath;
		else 
			throw new RuntimeException("AppLtmWorkPath not specified in the Configuration.properties file.");		
	}
	/**
	 * open tendering method
	 * @return
	 */
	
	public String getAppOtmWorkPath(){
		String AppOtmWorkPath = properties.getProperty("AppOtmWorkPath");
		if(AppOtmWorkPath!= null) 
			return AppOtmWorkPath;
		else 
			throw new RuntimeException("AppLtmWorkPath not specified in the Configuration.properties file.");		
	}
	
	public String getSystemEnvironmentPath(){
		String systemEnvironment = properties.getProperty("systemEnvironment");
		if(systemEnvironment!= null) return systemEnvironment;
		else throw new RuntimeException("systemEnvironment not specified in the Configuration.properties file.");		
	}
	
	public long getPageLoadTimeOut() {
		String pageLoadTimeOut = properties.getProperty("PAGE_LOAD_TIMEOUT");
		if (pageLoadTimeOut !=null) return Long.parseLong(pageLoadTimeOut);
		else throw new RuntimeException("pageLoadTimeOut not specified in the Configuration.properties file.");
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("ImplicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) 
			return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getUserNamePe() {
		String username_pe = properties.getProperty("username_pe");
		if(username_pe != null) return username_pe;
		else throw new RuntimeException("username_pe not specified in the Configuration.properties file.");
		
	}
	
	public String getPasswordPe() {
			String password_pe = properties.getProperty("password_pe");
			if(password_pe != null) return password_pe;
			else throw new RuntimeException("password_pe not specified in the Configuration.properties file.");
	}

	public String getUserNameHope() {
		String username_Hope = properties.getProperty("username_Hope");
		if(username_Hope != null) 
			return username_Hope;
		else 
			throw new RuntimeException("username_Hope not specified in the Configuration.properties file.");
	}

	public String getPasswordHope() {
		String password_Hope = properties.getProperty("password_Hope");
		if(password_Hope != null) return password_Hope;
		else throw new RuntimeException("password_Hope not specified in the Configuration.properties file.");
	}
	
	/**
	 * getUserNameBranchMaker
	 * @return
	 */
	public String getUserNameBranchMaker() {
		String username_branchmaker = properties.getProperty("username_branchmaker");
		if(username_branchmaker != null) 
			return username_branchmaker;
		else 
			throw new RuntimeException("username_Hope not specified in the Configuration.properties file.");
	}
	
	/**
	 * getPasswordBranchMaker
	 * @return
	 */
	public String getPasswordBranchMaker() {
		String password_branchmaker = properties.getProperty("password_branchmaker");
		if(password_branchmaker != null) 
			return password_branchmaker;
		else 
			throw new RuntimeException("password_Hope not specified in the Configuration.properties file.");
	}
	
	/**
	 * getUserNameBranchCheker
	 * @return
	 */
	public String getUserNameBranchChecker() {
		String username_branchchecker = properties.getProperty("username_branchcheker");
		if(username_branchchecker != null) 
			return username_branchchecker;
		else 
			throw new RuntimeException("username_Hope not specified in the Configuration.properties file.");
	}
	
	/**
	 * getPasswordBranchChecker
	 * @return
	 */
	public String getPasswordBranchChecker() {
		String password_branchchecker = properties.getProperty("password_branchcheker");
		if(password_branchchecker != null) 
			return password_branchchecker;
		else 
			throw new RuntimeException("password_Hope not specified in the Configuration.properties file.");
	}
	
	/**
	 * getUserNameTenderer
	 * @return
	 */
	public String getUserNameTenderer() {
		String username_Tenderer = properties.getProperty("username_tender");
		if(username_Tenderer != null) 
			return username_Tenderer;
		else 
			throw new RuntimeException("username_Hope not specified in the Configuration.properties file.");
	}
	
	/**
	 * getPasswordBranchChecker
	 * @return
	 */
	public String getPasswordTenderer() {
		String password_tenderer = properties.getProperty("password_tender");
		if(password_tenderer != null) 
			return password_tenderer;
		else 
			throw new RuntimeException("password_Hope not specified in the Configuration.properties file.");
	}
	
	/**
	 * getUserNameTenderer
	 * @return
	 */
	public String getUserNameTenderer2() {
		String username_Tenderer = properties.getProperty("username_tender2");
		if(username_Tenderer != null) 
			return username_Tenderer;
		else 
			throw new RuntimeException("username_Hope not specified in the Configuration.properties file.");
	}
	
	/**
	 * getPasswordBranchChecker
	 * @return
	 */
	public String getPasswordTenderer2() {
		String password_tenderer = properties.getProperty("password_tender2");
		if(password_tenderer != null) 
			return password_tenderer;
		else 
			throw new RuntimeException("password_Hope not specified in the Configuration.properties file.");
	}
	/**
	 * getEgpAO User
	 * @return
	 */
	public String getUserNameEGPAOUser() {
		String username_egpaouser = properties.getProperty("username_egpaouser");
		if(username_egpaouser != null) 
			return username_egpaouser;
		else 
			throw new RuntimeException("username_Hope not specified in the Configuration.properties file.");
	}
	
	/**
	 * getPasswordBranchChecker
	 * @return
	 */
	public String getPasswordEGPAOUser() {
		String password_egpaouser = properties.getProperty("password_egpaouser");
		if(password_egpaouser != null) 
			return password_egpaouser;
		else 
			throw new RuntimeException("password_Hope not specified in the Configuration.properties file.");
	}
	
	/**
	 * getEgpBOD UserName
	 * @return
	 */
	public String getUserNameEGPBODUser() {
		String username_egpboduser = properties.getProperty("username_egpboduser");
		if(username_egpboduser != null) 
			return username_egpboduser;
		else 
			throw new RuntimeException("username_Hope not specified in the Configuration.properties file.");
	}
	
	/**
	 * getEgpBOD Password
	 * @return
	 */
	public String getPasswordEGPBODUser() {
		String password_egpboduser = properties.getProperty("password_egpboduser");
		if(password_egpboduser != null) 
			return password_egpboduser;
		else 
			throw new RuntimeException("password_Hope not specified in the Configuration.properties file.");
	}
	
	/**
	 * getEgpTECPEC UserName
	 * @return
	 */
	public String getUserNameEGPTECUser() {
		String username_egptecuser = properties.getProperty("username_egptecuser");
		if(username_egptecuser != null) 
			return username_egptecuser;
		else 
			throw new RuntimeException("username_Hope not specified in the Configuration.properties file.");
	}
	
	/**
	 * getEgpTECPEC Password
	 * @return
	 */
	public String getPasswordEGPTECUser() {
		String password_egptecuser = properties.getProperty("password_egptecuser");
		if(password_egptecuser != null) 
			return password_egptecuser;
		else 
			throw new RuntimeException("password_Hope not specified in the Configuration.properties file.");
	}
	
	/**
	 * Creating add new packages - 1
	 */
	public String getAppDevlopementBudgetGoodsRequestForQuotaionPath(){
		String appDevelopmentBudgetGoodsRFQPathValue = properties.getProperty("AppDevelopmentBudgetGoodsRFQPath");
		if(appDevelopmentBudgetGoodsRFQPathValue!= null) 
			return appDevelopmentBudgetGoodsRFQPathValue;
		else 
			throw new RuntimeException("AppGoodDevlopementPath not specified in the Configuration.properties file.");		
	}
	
	/**
	 * Creating add new packages - 2
	 */
	public String createAPPDevlopementBudget_Works_RequestForQuotaionUnit_Path(){
		String appDevelopmentBudgetWorksRFQUPathValue = properties.getProperty("AppDevelopmentBudgetWorksRFQUPath");
		if(appDevelopmentBudgetWorksRFQUPathValue!= null) 
			return appDevelopmentBudgetWorksRFQUPathValue;
		else 
			throw new RuntimeException("AppGoodDevlopementPath not specified in the Configuration.properties file.");		
	}
	
	/**
	 * Creating add new packages - 2
	*/
	public String createAPPDevlopementBudget_Works_LTM_Path(){
		String appDevelopmentBudgetWorksLTMPathValue = properties.getProperty("AppDevelopmentBudgetWorksLTMPath");
		if(appDevelopmentBudgetWorksLTMPathValue!= null) 
			return appDevelopmentBudgetWorksLTMPathValue;
		else 
			throw new RuntimeException("AppGoodDevlopementPath not specified in the Configuration.properties file.");		
	}
	
}
