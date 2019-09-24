package com.pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.egp.qa.base.TestBase;
import com.egp.qa.helper.javascript.JavaScriptHelper;
import com.egp.qa.helper.logger.LoggerHelper;
import com.egp.qa.utilities.TestUtil;

/**
*
* @author SHIVANSHU SHANDILYA
*/
public class CommanActivity extends TestBase{
	private Logger log = LoggerHelper.getLogger(CommanActivity.class);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	JavaScriptHelper jse = new JavaScriptHelper(driver);
	@FindBy(xpath="//A[@id='hrefCPV']/self::A")
	WebElement SelectCategory;
	
	@FindBy(xpath="//img[@id='deptTreeIcn']")
	WebElement ministryLink;
	
	@FindBy(className="jstree-checkbox")
	WebElement CpvCatAgri;
	
	@FindBy(id="btnGetCheckedNode")
	WebElement SubmitCpvCategory;
	
	@FindBy(id="txtpqdtadvtinvt")
	WebElement datePQ;
	
	@FindBy(id="txtRfqdtadvtift")
	WebElement ExpectedDateOfAdvertisementOfIFTon;
	
	@FindBy(xpath="//*[@id='7335']/a/ins[1]")
	WebElement computerRel;
	
	@FindBy(xpath="//*[@id=\"deptid_171\"]/a")
	WebElement computerRel1;
	
	@FindBy(id = "cmbFinancialYear")
	private WebElement FinancialYear;
	
	@FindBy(xpath="//input[@id='txtIssuanceDt']")
	private WebElement issuanceDate;
	
	/**
	 * Handle multiple window handling
	 * @throws Throwable
	 */
	
	public void WindowHandleSelectCatg() throws Throwable{
		log.info("******WindowHandleSelectCatg**********");
		jse.scrollIntoView(SelectCategory);
		jse.clickElement(SelectCategory);
		//SelectCategory.click();
		//Window Handling
		//Thread.sleep(5000);
		String Parent_Window = driver.getWindowHandle();  
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		//CpvCatAgri.click();
		computerRel.click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//js.executeScript("window.scrollBy(0,1000)");
		jse.scrollIntoView(SubmitCpvCategory);
		jse.clickElement(SubmitCpvCategory);
		//SubmitCpvCategory.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//+++++
		driver.switchTo().window(Parent_Window);  
		driver.switchTo().defaultContent();
		System.out.println("Windows come to back");
	}
	
	public void WindowHandleSelectCatg1() throws Throwable{
		log.info("******WindowHandleSelectCatg**********");
		//jse.scrollIntoView(SelectCategory);
		jse.clickElement(ministryLink);
		//SelectCategory.click();
		//Window Handling
		//Thread.sleep(5000);
		String Parent_Window = driver.getWindowHandle();  
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		//CpvCatAgri.click();
		computerRel1.click();
		js.executeScript("window.scrollBy(0,1000)");
		//SubmitCpvCategory.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//+++++
		driver.switchTo().window(Parent_Window);  
		driver.switchTo().defaultContent();
		System.out.println("Windows come to back");
	}
	
	public void DatePickerCurentDate() {
	    LocalDateTime now = LocalDateTime.now();
	    LocalDateTime NextDays = now.plusDays(2);
		DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String curentDate=(now).format(formatter_1);
		selectDateByJs(driver,datePQ,curentDate);
	}
               
    public void DatePickerNextDate() {
    	LocalDateTime now = LocalDateTime.now();
    	LocalDateTime NextDaysAfter = now.plusDays(7);
 		DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 		String NextDate=(NextDaysAfter).format(formatter_1);
 		selectDateByJs(driver,ExpectedDateOfAdvertisementOfIFTon,NextDate);
    }
              
             
    public void SelectFinancialYearAPP() {
    	 Select year = new Select(FinancialYear);
 		 List<WebElement> list=year.getOptions();
 		 System.out.println(list.size());
 		 year.selectByValue(String.valueOf(list.size()));
 		 list=null;
    }
    
    

}
