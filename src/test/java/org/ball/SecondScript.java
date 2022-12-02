package org.ball;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class SecondScript {
	public static AndroidDriver driver;

	public static void main(String[] args) throws IOException {
		Properties property = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\ALWIN\\eclipse-workspace\\Alwin\\AppiumClasss\\file\\config.properties");
		property.load(fis);

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", property.getProperty("platformName"));
		cap.setCapability("platformVersion", property.getProperty("platformVersion"));
		cap.setCapability("deviceName", property.getProperty("deviceName"));
		cap.setCapability("", property.getProperty("udid"));
		cap.setCapability("appPackage", property.getProperty("appPackage"));
		cap.setCapability("appActivity", property.getProperty("appActivity"));
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
		WebElement contact = driver.findElement(By.xpath(property.getProperty("contact")));
		contact.click();
		WebElement add = driver.findElement(By.id(property.getProperty("add")));
		add.click();
		WebElement name = driver.findElement(By.xpath(property.getProperty("name")));
		name.sendKeys(property.getProperty("phName"));
		WebElement num = driver.findElement(By.xpath(property.getProperty("num")));
		num.sendKeys(property.getProperty("phNumber"));
		driver.navigate().back();
		WebElement ok = driver.findElement(By.id(property.getProperty("ok")));
		ok.click();

	}

}
