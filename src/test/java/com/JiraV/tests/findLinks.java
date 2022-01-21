package com.JiraV.tests;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class findLinks extends Base {

	final static Logger logger = Logger.getLogger(findLinks.class);
	
	@Test
	public void allTheLinks() {

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int TotalLinks = allLinks.size();
		logger.info("All the links : " + TotalLinks);

	}

	@Test
	public void findTotalNumberEmptyLinkPrint() {

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int counter = 1;

		List<String> emptyLinks = new ArrayList<String>();

		for (WebElement link : allLinks) {
			String linkTxt = link.getText();
			if (linkTxt.isEmpty()) {
				emptyLinks.add(linkTxt);
				logger.info("Total empty links : " + emptyLinks);
			}
			counter++;
		}

		int totalNumEmptyLinks = emptyLinks.size();
		logger.info("total empty links: " + totalNumEmptyLinks);

	}

}
