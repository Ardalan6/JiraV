package com.JiraV.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class joinPartnerProgramTest extends Base {

	final static Logger logger = Logger.getLogger(joinPartnerProgramTest.class);

	@Test
	public void bookAnApointment() throws InterruptedException {

		logger.info("Clicking on 'Pricing btn' .");
		logger.info("Navagating to 'Jirav Pricing by soloution' page.");
		driver.findElement(By.cssSelector("#hs_menu_wrapper_menu_ > ul > li:nth-child(3) > a")).click();
		logger.info("Clicling on 'Join Partner Program' Button.");
		driver.findElement(By.cssSelector(
				"#hs_cos_wrapper_module_1604642107623172 > div > div > div.pricing-solution-section-inner > div > div.plan-type-heading > a > h4 > span"))
				.click();
		logger.info("Clicking on 'Join Partner' btn.");
		driver.findElement(By.cssSelector("#cta_button_2567042_014c2dcc-e3dd-46a5-97d9-39b6ebc9549c")).click();
		logger.info("Navegating to 'Become a Partner Page. '");
		logger.info("Filling up the form.");
		WebElement first_name = driver.findElement(By.name("firstname"));
		//First name can NOT contain numbers!
		first_name.sendKeys("Josh1234");
		WebElement last_name = driver.findElement(By.name("lastname"));
		//Last name can NOT contain numbers!
		last_name.sendKeys("12559k");
		driver.findElement(By.name("email")).sendKeys("TestEmail@Amazon.com");
		driver.findElement(By.name("company")).sendKeys("TestComapny");
		//Phone number can NOT be this long !
		driver.findElement(By.name("phone")).sendKeys("1233131231232341");
		driver.findElement(By.name("number_of_clients")).sendKeys("1");
		Select drpDwn = new Select(driver.findElement(By.name("number_of_employees_1")));
		drpDwn.selectByValue("26 - 75");
		captureScreenShot("PrtnerProgramTest");
		logger.info("Clicking on 'Become a partner' btn.");		
		driver.findElement(By.cssSelector("input.hs-button.primary.large")).click();
		logger.info("Navegating to the 'Book an apointment' page'");
		logger.info("Clicking on'Book an apointment' btn.");
		driver.findElement(By.xpath("//span[text()='BOOK A 15 MINUTE CONSULTATION']")).click();
		logger.info("Navegating to 'Let's Meet' page.");
		

	}

}
