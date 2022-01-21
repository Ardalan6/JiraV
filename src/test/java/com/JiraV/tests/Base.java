package com.JiraV.tests;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.io.Files;

public class Base {

	final static Logger logger = Logger.getLogger(Base.class);

	public String URL = "https://www.jirav.com/";
	public WebDriver driver;
	int defaultWaitTimeInSecs = 15;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		logger.info("starting 'Chrome' browser.");

		driver.get(URL);
		logger.info("Going to 'www.jirav.com' .");
		driver.manage().timeouts().implicitlyWait(defaultWaitTimeInSecs, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(defaultWaitTimeInSecs, TimeUnit.SECONDS);
		logger.info("Maximizing the browser.");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	public String captureScreenShot(String screenShotFileName) {

		String screenshotFilePath = null;
		try {
			screenshotFilePath = "src/test/resources/screenshot" + screenShotFileName + "_" + getCurrentTime() + ".png";
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			Files.copy(scrFile, new File(screenshotFilePath));

			logger.info("Screenshot File: " + screenshotFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotFilePath;

	}

	public String getCurrentTime() {
		String finalTime = null;

		Date date = new Date();
		logger.debug("time1: " + date.toString());

		String tempTime = new Timestamp(date.getTime()).toString();

		return finalTime;

	}

	@AfterClass
	public void tearDown() {
		logger.info("This test is done.");
		driver.close();
		driver.quit();

	}

}
