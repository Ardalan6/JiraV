package com.JiraV.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class GetDemoTest extends Base {

	final static Logger logger = Logger.getLogger(GetDemoTest.class);

	@Test
	public void getDemo() {

		// can't use ID to find an element because it's dynamic.
		// filling up some information
		driver.findElement(By.cssSelector("#hs_menu_wrapper_my_simple_menu > ul > li:nth-child(2) > a")).click();
		WebElement first_name = driver.findElement(By.name("firstname"));
		first_name.sendKeys("Ardalan");
		WebElement last_name = driver.findElement(By.name("lastname"));
		last_name.sendKeys("Forouzandeh");
		// this is a bug . client CAN NOT use wrong Email Format!
		driver.findElement(By.name("email")).sendKeys("TestEmail@Amazon.co");
		driver.findElement(By.name("company")).sendKeys("TestComapny");
		// this is a bug ! client CAN NOTuse this much of numbers in phone number filed.
		// In think they used "LONG" data type!
		driver.findElement(By.name("phone")).sendKeys("57112345678901234545");
		driver.findElement(By.xpath("(//input[@name='channel__forms_'])[2]")).click();
		driver.findElement(By.name("number_of_clients")).sendKeys("0");

		// clicking on 'Request Demo' btn
		driver.findElement(
				By.cssSelector("#hsForm_56671b8f-ed79-4777-af3a-dddbd1443ffe_4206 > div > div.actions > input"))
				.click();
		captureScreenShot("TestGetDemo");

	}

}
