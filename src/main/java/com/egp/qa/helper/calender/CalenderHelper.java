package com.egp.qa.helper.calender;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.egp.qa.base.TestBase;
import com.egp.qa.helper.assertion.VerificationHelper;
import com.egp.qa.helper.logger.LoggerHelper;

public class CalenderHelper extends TestBase{
	//private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(CalenderHelper.class);
	String month = "Oct 2018";
	String date = "28";
	
	public CalenderHelper(WebDriver driver){
		this.driver = driver;
		log.info("CalenderHelper object is created..");
	}
	
	public  void enterDateText() throws InterruptedException {
		//driver.findElement(By.xpath("//input[@name='checkin']")).click();
		WebElement mon=driver.findElement(By.xpath("//table[28]/child::*/child::*/td/div/div[1]/table/tbody/tr/td/div/div[contains(text(),'Oct 2018')]"));
		System.out.println(mon.getText());
		
		
		/*while (true) {
			if (mon.getText().equals(month)) {
				break;
			}
			else {
				driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][1]/div[1]/table/thead/tr[1]/th[3]")).click();
				Thread.sleep(2000);
			}
		}
		driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu'][1]/div[1]/table/thead/following-sibling::tbody/tr[4]/td[contains(text(),'"+date+"')]")).click();*/
	} 
	
	
	public static void selectDateByJs(WebDriver driver,WebElement element, String dateVal){
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
	}
}
