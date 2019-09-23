package com.egp.qa.helper.javascript;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;

import com.egp.qa.base.TestBase;
import com.egp.qa.helper.logger.LoggerHelper;


public class JavaScriptHelper extends TestBase{
	//private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);
	
	public JavaScriptHelper(WebDriver driver){
		this.driver = driver;
		log.info("JavaScriptHelper class has been initialised");
	}
	
	public Object executeScript(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(script);
	}
	
	public Object executeScript(String script, Object...args) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(script,args);
	}
	
	public void scrollToElement(WebElement element) {
		//boolean asds = driver.findElement(By.id("")).getAttribute("").contains("che");
		log.info("Scroll to WebElement ...");
		executeScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x, element.getLocation().y);
	}
	
	public void scrollToElementAndClick(WebElement element) {
		scrollToElement(element);
		element.click();
		log.info("element is clicked...."+element.toString());
	}
	
	public void scrollIntoView(WebElement element) {
		log.info("Scroll till WebElement ...");
		executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log.info("element is clicked: "+element.toString());
	}
	
	public void scrollDownVertically() {
		log.info("scrolling down vertically...");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void scrollUpVertically() {
		log.info("scrolling up vertically...");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
	/**
	 * This method wil scroll till given pixel(e.g=1500)
	 * @param pixel
	 */
	public void scrollDownByPixel(int pixel) {
		executeScript("window.scrollBy(0,"+pixel+")");
	}
	
	public void scrollUpByPixel(int pixel) {
		executeScript("window.scrollBy(0,-"+pixel+")");
	}
	
	/**
	 * This method wil zoom screen by 100%
	 * @param pixel
	 */
	public void zoomInBy100Percentage() {
		executeScript("document.body.style.zoom='100%'");
	}
	
	/**
	 * This method wil zoom screen by 60%
	 * @param pixel
	 */
	public void zoomInBy60Percentage() {
		executeScript("document.body.style.zoom='40%'");
	}
	
	/**
	 * This method will click on element
	 * @param pixel
	 */
	public void clickElement(WebElement element) {
		log.info("click on element...");
		executeScript("arguments[0].click();", element);
	}
	
	public void selectDateByJavaScript(WebElement element, String dateVal){
		log.info("click on datepicker input...");
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
	}
	
}
