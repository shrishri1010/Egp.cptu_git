package com.egp.qa.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.egp.qa.helper.logger.LoggerHelper;

public class AssertionHelper {
	
	private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);
	
	public static void verifyText(String s1, String s2, String message) {
		log.info("verifying text: "+ s1 + " with "+ s2);
		Assert.assertEquals(s1, s2, message);
	}
	
	public static void makeTrue() {
		log.info("making script PASS..");
		Assert.assertTrue(true);
	}
	
	public static void makeTrue(String message) {
		log.info("making script PASS.."+ message);
		Assert.assertTrue(true, message);
	}
	
	public static void makeFalse() {
		log.info("making script FAIL..");
		Assert.assertTrue(false);
	}
	
	public static void makeFalse(String message) {
		log.info("making script FAIL.."+message);
		Assert.assertTrue(false, message);
	}
	
	public static void verifyTrue(boolean status) {
		log.info("status is true..");
		Assert.assertTrue(status);
	}
	
	public static void verifyFalse(boolean status) {
		Assert.assertFalse(status);
	}	
	
	public static void verifyNull(String s1) {
		log.info("verify object is null..");
		Assert.assertNull(s1);
	}	
	
	public static void verifyNotNull(String s1) {
		log.info("verify object is not null..");
		Assert.assertNotNull(s1);
	}
	
	public static void pass() {
		log.info("status is pass..");
		Assert.assertTrue(true);
	}
	
	public static void fail() {
		log.info("status is fail..");
		Assert.assertTrue(false);
	}
	
	public static void updateTestStatus(boolean status) {
		if (status) {
			pass();
		} else {
			fail();
		}
	}
	
}
