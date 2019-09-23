package com.egp.qa.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.egp.qa.base.TestBase;
import com.egp.qa.helper.logger.LoggerHelper;

public class WaitHelper extends TestBase{
	
	//private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver){
		this.driver = driver;
		log.info("waithelper object created..");
	}
	
	/**
	 * ImplicitWait method
	 * @param timeout
	 * @param unit
	 */
	public void setImplicitWait(long timeout, TimeUnit unit) {
		log.info("Implicit Wait has been set to: "+timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}
	
	/**
	 * This will help us to get WebdriverWait object
	 * @param timeout
	 * @param unit
	 */
	public WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec){
		log.info("shrikanth get WebdriverWait object: "+timeOutInSeconds);
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		wait.ignoring(TimeoutException.class);
		return wait;
	}
	
	/**
	 * This method will make sure element is visible
	 * @param timeout
	 * @param unit
	 */
	public void WaitForElementVisibleWithPollingTime(WebElement element,int timeOutInSeconds,int pollingEveryInMiliSec) {
		log.info("waiting for :"+element.toString()+" for :"+timeOutInSeconds+" seconds ");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This will help us to get WaitForElementClickable
	 * @param timeout
	 * @param unit
	 */
	public void WaitForElementClickable(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :"+element.toString()+" for :"+timeOutInSeconds+" seconds ");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("element is clickable now");
	}
	
	/**
	 * This will help us to get WaitForVisibilityOfElement
	 * @param timeout
	 * @param unit
	 */
	public void waitForElement(WebElement element, int timeOutInSeconds) {
		log.info("waiting for : " +element.toString()+ " for :" +  timeOutInSeconds + " seconds	");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element)); 
		log.info("element is visible now");
	}
	
	/**
	 * This will help us to get WaitForElementNotPresent
	 * @param timeout
	 * @param unit
	 */
	public boolean WaitForElementNotPresent(WebElement element, long timeOutInSeconds) {
		log.info("waiting for :"+element.toString()+" for :"+timeOutInSeconds+" seconds ");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("element is invisible now");
		return status;
	}
	
	/**
	 * This will help us to get frameToBeAvailableAndSwitchToIt 
	 * @param timeout
	 * @param unit
	 */
	public void WaitForElementNotPresent1(WebElement element, long timeOutInSeconds) {
		log.info("waiting for :"+element.toString()+" for :"+timeOutInSeconds+" seconds ");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("frame is available and switched");
	}
	
	/**
	 * This method will give us to get FluentWait object
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	private Wait<WebDriver> getFluentWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		log.info("Waiting for getFluentWait ---->>>"+timeOutInSeconds+" seconds ");
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(timeOutInSeconds))
		.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec))
		.ignoring(NoSuchElementException.class)
		.ignoring(TimeoutException.class);
		return fwait;
	}
	
	/**
	 * This method will give us to get FluentWait object
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	public WebElement waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		Wait<WebDriver> fwait = getFluentWait(timeOutInSeconds, pollingEveryInMiliSec);
		fwait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	public void pageLoadTimeOut(long timeout, TimeUnit unit) {
		log.info("waiting for page load timeout for : "+unit+ " seconds");
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("page is loaded");
	}
}
