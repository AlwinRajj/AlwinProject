package org.ball;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvide extends BaseClass {
	@BeforeMethod
	private void startDate() {
		Date d = new Date();
		System.out.println(d);
	}

	@AfterMethod
	private void endDate() {
		Date d = new Date();
		System.out.println(d);
	}

	@BeforeClass
	private void browserLaunch() {
		launchBrowser();
		windowMaximize();
	}

	@AfterClass
	private void closeBrowser() {
		closeEntireBrowser();
	}
	
	@DataProvider(name = "fb data")
	private Object[][] data() {
		return new Object[][] {
			{"alwin","raj"},
			{"flarence","selvakumar"},
			{"subuhani","alwin"},
			{"alwin","football"}

	};
	}
	
	
	@Test(dataProvider = "fb data")
	private void fbLaunch(String un ,String ps) {
		launchUrl("https://en-gb.facebook.com/login/");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys(un);
		WebElement pas = driver.findElement(By.id("pass"));
		pas.sendKeys(ps);


}
}
