package com.salesforce.automation;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.salesforceBase.BaseTest;

public class SalesforceCreateOpty extends BaseTest {
	@Test
	public void opportunitiesdropdown() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement oppolink = driver.findElement(
				By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[8]/a"));
		oppolink.click();
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"fcf\"]"));
		dropdown.click();
		WebElement opportunitiesDropdown = driver
				.findElement(By.xpath("//select[@id='fcf']"));
		List<WebElement> dropdownOptions = opportunitiesDropdown
				.findElements(By.tagName("option"));
		System.out.println("********************************");
		String[] dropDownsArr = new String[dropdownOptions.size()];
		for (int i = 0; i < dropdownOptions.size(); i++) {
			System.out.println(" " + dropdownOptions.get(i).getText());
			dropDownsArr[i] = dropdownOptions.get(i).getText();
		}

		// System.out.println("dropdownOptions : "+dropdownOptions);
		String[] expectedOptionsArr = {"All Opportunities",
				"Closing Next Month", "Closing This Month", "My Opportunities",
				"New Last Week", "New This Week", "Opportunity Pipeline",
				"Private", "Recently Viewed Opportunities", "Won"};
		// System.out.println("expectedOptionsArr : "+expectedOptionsArr+" ,
		// dropDownsArr : "+dropDownsArr);
		if (Arrays.equals(expectedOptionsArr, dropDownsArr)) {
			System.out.println("test passed.");
		} else {
			System.out.println("test failed.");
		}
	}
	@Test
	public void createanewopty() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement oppolink = driver.findElement(
				By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[8]/a"));
		oppolink.click();
		WebElement newbutton = driver.findElement(By.xpath(
				"/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[1]/form/table/tbody/tr/td[2]/input"));
		newbutton.click();
		WebElement opponame = driver.findElement(By.xpath("//*[@id=\"opp3\"]"));
		opponame.sendKeys("ABCD");
		WebElement accountname = driver
				.findElement(By.xpath("//*[@id=\"opp4\"]"));
		accountname.sendKeys("Suganya23");
		WebElement closedate = driver
				.findElement(By.xpath("//*[@id=\"opp9\"]"));
		closedate.sendKeys("02/12/2024");
		WebElement stage = driver.findElement(By.id("opp11"));
		Select selectstage = new Select(stage);
		selectstage.selectByVisibleText("Qualification");
		WebElement probability = driver.findElement(By.id("opp12"));
		probability.clear();
		probability.sendKeys("80");
		WebElement leadsource = driver.findElement(By.id("opp6"));
		Select selectleadsource = new Select(leadsource);
		selectleadsource.selectByVisibleText("Web");
		WebElement primary = driver.findElement(By.xpath("//*[@id=\"opp17\"]"));
		primary.sendKeys("");
		WebElement savebtn = driver
				.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		savebtn.click();
		WebElement pageDescription = driver.findElement(
				By.xpath("//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h2"));
		if (pageDescription.getText().equalsIgnoreCase("ABCD")) {
			System.out.println("test case is passed");
		} else {
			System.out.println("test case is not passed");
		}
	}
	@Test
	public void TestOpportunityPipelineReport() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement oppolink = driver.findElement(
				By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[8]/a"));
		oppolink.click();
		WebElement oppopipeline = driver.findElement(By.xpath(
				"//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a"));
		oppopipeline.click();
		String expectedTitle = ("Opportunity Pipeline ~ Salesforce - Developer Edition");
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("test passed: page displayed");
		} else {
			System.out.println("test failed: page not displayed");
		}
	}
	@Test
	public void TestStuckOpportunitiesReport() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement oppolink = driver.findElement(
				By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[8]/a"));
		oppolink.click();
		WebElement StuckOpportunities = driver.findElement(By.xpath(
				"//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a"));
		StuckOpportunities.click();

		String expectedTitle = ("Stuck Opportunities ~ Salesforce - Developer Edition");
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println(
					"TestStuckOpportunitiesReport: Test Passed: Page Displayed");
		} else {
			System.out.println(
					"TestStuckOpportunitiesReport: Test Failed: Page Not Displayed");
		}
	}
	@Test
	public void TestQuarterlySummaryReport() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement oppolink = driver.findElement(
				By.xpath("/html/body/div[1]/div[1]/div/div/nav/ul/li[8]/a"));
		oppolink.click();
		WebElement interval = driver.findElement(By.id("quarter_q"));
		Select selectinterval = new Select(interval);
		selectinterval.selectByVisibleText("Next FQ");
		WebElement include = driver.findElement(By.id("open"));
		Select selectinclude = new Select(include);
		selectinclude.selectByVisibleText("Open Opportunities");
		WebElement runreport = driver.findElement(By
				.xpath("//*[@id=\"lead_summary\"]/table/tbody/tr[3]/td/input"));
		runreport.click();
		System.out
				.println("TestQuarterlySummaryReport: Test Passed: Run Report");

	}
	/*
	public static void main(String args[]) throws InterruptedException {
		SalesforceCreateOpty obj = new SalesforceCreateOpty();
		obj.launchBrowser("Chrome");
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		/*
		 * obj.opportunitiesdropdown(); obj.salesforcelogout();
		 * obj.salesforcelogin("https://login.salesforce.com/",
		 * "suganyas@tekarch.com", "Sugan@23");
		 
		obj.createanewopty();
		obj.salesforcelogout();

		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.TestOpportunityPipelineReport();
		obj.salesforcelogout();
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.TestStuckOpportunitiesReport();
		obj.salesforcelogout();
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.TestQuarterlySummaryReport();
		obj.salesforcelogout();

	}*/
}