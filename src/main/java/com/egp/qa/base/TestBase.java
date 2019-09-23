package com.egp.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.egp.qa.configfilereader.FileReaderManager;
import com.egp.qa.helper.excel.ExcelHelper;
import com.egp.qa.helper.logger.LoggerHelper;
import com.egp.qa.helper.resource.ResourceHelper;
import com.egp.qa.utilities.TestUtil;
import com.egp.qa.utilities.WebEventListener;
import com.google.errorprone.annotations.Var;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	private Logger log = LoggerHelper.getLogger(TestBase.class);
	public  static EventFiringWebDriver e_driver;
	public static  WebEventListener eventListener;
	public ExtentReports extentreport;
	public com.aventstack.extentreports.ExtentTest extentTest;
	ExtentHtmlReporter htmlreporter;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src//main//java//com//egp//qa//config//configuration.properties");
			prop.load(ip);
			String str1= TestUtil.timestampMethod();
			str1=str1.replace(" ", "-");
			str1=str1.replace(":", "-");
			htmlreporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/ReportsGenerate/EgpExtentReport/"+str1+".html"));
			htmlreporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
			extentreport=new com.aventstack.extentreports.ExtentReports();
			extentreport.setSystemInfo("Environment", "Shrikanth Kulal");
			extentreport.attachReporter(htmlreporter);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	
	public static void initialization(){
	    String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			/*ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
	        options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
	        options.addArguments("--headless"); // only if you are ACTUALLY running headless
	        options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
	        options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
	        options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
	        options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
	        options.addArguments("--disable-gpu"); //https:*/
			
			//System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigReader().getDriverPath());
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("src/main/resources/drivers/chromedriver.exe"));
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("--no-sandbox");
			driver = new ChromeDriver();		
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver",ResourceHelper.getResourcePath("src/main/resources/drivers/geckodriver.exe"));	
			driver = new FirefoxDriver();
		}else if (browserName.equals("MicrosoftEdge")) {
			//Create object of DesiredCapabilities class
			DesiredCapabilities cap=DesiredCapabilities.edge();
			// Set ACCEPT_SSL_CERTS  variable to true
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			System.setProperty("webdriver.edge.driver", ResourceHelper.getResourcePath("src/main/resources/drivers/MicrosoftWebDriver.exe"));
			//ChromeOptions chrome = new ChromeOptions();
			//chrome.addArguments("disable-extensions");
			driver = new EdgeDriver(cap);
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(FileReaderManager.getInstance().getConfigReader().getPageLoadTimeOut(),TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS); 
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
	
	
	public static void selectDateByJs(WebDriver driver,WebElement element, String dateVal){
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
	}

	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver , timeout)
		.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	
	public static void clickOn2(WebDriver drier, WebElement locator, int timeout) {
			new WebDriverWait(driver , timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
			locator.click();
	}
	
	public Object[][] getExcelData(String excelName, String sheetName) {
		String excelLocation = ResourceHelper.getResourcePath("src/main/java/com/egp/qa/testdata/")+excelName;
		log.info("excel location "+excelLocation);
		//ExcelHelper excelHelper = new ExcelHelper();
		Object[][] data = ExcelHelper.getExcelData(excelLocation, sheetName);
		return data;
	}
	
}