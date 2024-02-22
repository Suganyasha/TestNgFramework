package com.salesforce.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.salesforceBase.BaseTest;

public class SalesforceLeads extends BaseTest {
	@Test
	public void leads1() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement leadlink = driver.findElement(By.id("Lead_Tab"));
		leadlink.click();

		String leadsHomePageTitle = driver.getTitle();
		System.out.println("leadsHomePageTitle : " + leadsHomePageTitle);
		if (leadsHomePageTitle.contains("Leads")) {
			System.out.println("Test Passed - Leads Home page is displayed");
		} else {
			System.out
					.println("Test Failed - Leads Home page is not displayed");
		}

	}
	@Test
	public void leads2() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement leadlink = driver.findElement(By.id("Lead_Tab"));
		leadlink.click();

		String leadsHomePageTitle = driver.getTitle();
		System.out.println("leadsHomePageTitle : " + leadsHomePageTitle);
		if (leadsHomePageTitle.contains("Leads")) {
			System.out.println("Test Passed - Leads Home page is displayed");
		} else {
			System.out
					.println("Test Failed - Leads Home page is not displayed");
		}
		WebElement dropdown = driver.findElement(By.id("fcf"));
		dropdown.click();
		System.out.println("dropdown" + dropdown.getText());
	}
	@Test
	public void leads3() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement leadlink = driver.findElement(By.id("Lead_Tab"));
		leadlink.click();

		String leadsHomePageTitle = driver.getTitle();
		System.out.println("leadsHomePageTitle : " + leadsHomePageTitle);
		if (leadsHomePageTitle.contains("Leads")) {
			System.out.println("Test Passed - Leads Home page is displayed");
		} else {
			System.out
					.println("Test Failed - Leads Home page is not displayed");
		}

		WebElement dropdown = driver.findElement(By.id("fcf"));
		dropdown.click();
		Thread.sleep(200);
		System.out.println("dropdown" + dropdown.getText());
		Select selectlead = new Select(dropdown);
		selectlead.selectByVisibleText("Today's Leads");
		Thread.sleep(200);
		WebElement go = driver.findElement(
				By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
		go.click();
		System.out.println("Today's Lead selected");
		Thread.sleep(200);
		WebElement myname = driver
				.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
		myname.click();
		Thread.sleep(200);
		WebElement logout = driver
				.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
		logout.click();
		Thread.sleep(3000);
/*
		salesforcelogin(
				"https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");

		Thread.sleep(3000);*/
		leadlink = driver.findElement(By.id("Lead_Tab"));
		leadlink.click();
		Thread.sleep(200);
		go = driver.findElement(
				By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
		go.click();
	}
	@Test
	public void leads4() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement leadlink = driver.findElement(By.id("Lead_Tab"));
		leadlink.click();
		WebElement dropdown = driver.findElement(By.id("fcf"));
		dropdown.click();
		System.out.println("dropdown" + dropdown.getText());
		Select selectlead = new Select(dropdown);
		selectlead.selectByVisibleText("Today's Leads");
		WebElement go = driver.findElement(
				By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
		go.click();
		System.out.println("New page displayed");
	}
	@Test
	public void leads5() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement leadlink = driver.findElement(By.id("Lead_Tab"));
		leadlink.click();
		WebElement newbtn = driver.findElement(
				By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		newbtn.click();
		WebElement lname = driver.findElement(By.id("name_lastlea2"));
		lname.sendKeys("ABCD");
		WebElement company = driver.findElement(By.id("lea3"));
		company.sendKeys("ABCD");
		WebElement save = driver
				.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
		save.click();
		Thread.sleep(3000);
		WebElement topname = driver.findElement(
				By.xpath("//*[@id=\"contactHeaderRow\"]/div[2]/h2"));
		if (topname.getText().equalsIgnoreCase("ABCD")) {
			System.out.println("Test case is passed");
		} else {
			System.out.println("Test case is not passed");
		}
	}
	/*
	public static void main(String[] args) throws InterruptedException {
		SalesforceLeads obj = new SalesforceLeads();
		obj.launchBrowser("Chrome");
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		 obj.leads1();
		 obj.salesforcelogout();
		 obj.salesforcelogin("https://login.salesforce.com/",
					"suganyas@tekarch.com", "Sugan@23");
		 obj.leads2();
		 obj.salesforcelogout();
		 obj.salesforcelogin("https://login.salesforce.com/",
					"suganyas@tekarch.com", "Sugan@23");
		 //obj.leads3();
		 obj.salesforcelogout();
		 obj.salesforcelogin("https://login.salesforce.com/",
					"suganyas@tekarch.com", "Sugan@23");
		 obj.leads4();
		 obj.salesforcelogout();
		 obj.salesforcelogin("https://login.salesforce.com/",
					"suganyas@tekarch.com", "Sugan@23");
		 obj.leads5();
		 obj.salesforcelogout();
	}*/
}
