package com.egp.qa.helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.egp.qa.base.TestBase;
import com.egp.qa.helper.logger.LoggerHelper;

public class AlertHelper extends TestBase {
	// private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(AlertHelper.class);

	public AlertHelper(WebDriver driver) {
		this.driver = driver;
		log.info("AlertHelper object is created..");
	}

	public Alert switchToAlert() {
		System.out.println("switch to alert is :" + driver.switchTo().alert());
		log.info("Alert test is:" + driver.switchTo().alert());
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		switchToAlert().accept();
		log.info("accept Alert is done...");
	}

	public void dismissAlert() {
		switchToAlert().dismiss();
		log.info("dismiss Alert is done...");
	}

	public String getAlertText() {
		String text = switchToAlert().getText();
		log.info("alert text: " + text);
		return text;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			log.info("alert is present");
			return true;
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void acceptAlertIfPresent() {
		if (isAlertPresent()) {
			acceptAlert();
		} else {
			log.info("Alert is not present..");
		}
	}

	public void dismissAlertIfPresent() {
		if (isAlertPresent()) {
			dismissAlert();
		} else {
			log.info("Alert is not present..");
		}
	}

	public void acceptPrompt(String text) {
		if (isAlertPresent()) {
			Alert alert = switchToAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("Alert text : " + text);
		} else {

		}
	}
	
}
