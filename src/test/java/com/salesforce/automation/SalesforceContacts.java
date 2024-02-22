package com.salesforce.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.salesforceBase.BaseTest;

public class SalesforceContacts extends BaseTest {
	@Test
	public void Createnewcontact() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement contact = driver
				.findElement(By.xpath("//a[@title='Contacts Tab']"));
		contact.click();
		Thread.sleep(200);
		WebElement newbtn = driver.findElement(
				By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		newbtn.click();
		Thread.sleep(200);
		WebElement lname = driver.findElement(By.id("name_lastcon2"));
		lname.sendKeys("ABCD");
		WebElement accname = driver.findElement(By.xpath("//*[@id=\"con4\"]"));
		accname.sendKeys("Suganya23");
		WebElement save = driver
				.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		save.click();
		Thread.sleep(200);
		WebElement topname = driver.findElement(
				By.xpath("//*[@id=\"contactHeaderRow\"]/div[2]/h2"));
		if (topname.getText().equalsIgnoreCase("ABCD")) {
			System.out.println("CreateNewContact test case is passed");
		} else {
			System.out.println("CreateNewContact test case is not passed");
		}

	}
	@Test
	public void Createnewviewincontactpage() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement contact = driver.findElement(By.id("Contact_Tab"));
		contact.click();
		Thread.sleep(200);
		WebElement createnw = driver.findElement(
				By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		createnw.click();
		Thread.sleep(200);
		WebElement viewname = driver.findElement(By.id("fname"));
		viewname.sendKeys("Little");
		WebElement viewuname = driver.findElement(By.id("devname"));
		viewuname.sendKeys("mee");
		WebElement save = driver.findElement(By.xpath(
				"//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
		save.click();
		Thread.sleep(200);
		String createnewPageTitle = driver.getTitle();
		System.out.println("NEW PAGE : " + createnewPageTitle);
		if (createnewPageTitle.contains("Contacts")) {
			System.out.println("CreateNewViewinContactPage Test Passed -New page is displayed");
		} else {
			System.out.println("CreateNewViewinContactPage Test Failed - Newpage is not displayed");
		}
	}
	@Test
	public void Checkrecentlycreatedcontactinthecontactpage()
			throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement contact = driver.findElement(By.id("Contact_Tab"));
		contact.click();
		Thread.sleep(200);
		WebElement view = driver.findElement(By.id("fcf"));
		Select selectview = new Select(view);
		selectview.selectByVisibleText("Little");
		WebElement go = driver.findElement(By.xpath("//input[@title='Go!']"));
		go.click();
		Thread.sleep(200);
		WebElement expectedviewname = driver
				.findElement(By.xpath("//select/option[5]"));
		String actualviewname = "Little";
		if (expectedviewname.getText().equalsIgnoreCase(actualviewname)) {
			System.out.println("CheckRecentlyCreatedContactIntheContactPage Test Passed ");
		} else {
			System.out.println("CheckRecentlyCreatedContactIntheContactPage Test Failed");
		}
	}
@Test
	public void Checkmycontactsview() throws InterruptedException {
	logInApp();
	Thread.sleep(3000);
		WebElement contact = driver.findElement(By.id("Contact_Tab"));
		contact.click();
		Thread.sleep(200);
		WebElement view = driver.findElement(By.id("fcf"));
		Select selectview = new Select(view);
		selectview.selectByVisibleText("My Contacts");
		WebElement go = driver.findElement(By.xpath("//input[@title='Go!']"));
		go.click();
		Thread.sleep(200);
		WebElement expectedtext = driver
				.findElement(By.xpath("//select/option[6]"));
		String actualtext = "My Contacts";
		if (expectedtext.getText().equals(actualtext)) {
			System.out.println("CheckMyContactsView Test Case Passed");
		} else {
			System.out.println("CheckMyContactsView Test Case Failed");
		}

	}
@Test
	public void Viewacontactinthecontactpage() throws InterruptedException {
	logInApp();
	Thread.sleep(3000);
		WebElement contact = driver.findElement(By.id("Contact_Tab"));
		contact.click();
		Thread.sleep(200);
		WebElement view1 = driver.findElement(By.id("fcf"));
		Select selectview1 = new Select(view1);
		selectview1.selectByVisibleText("Little");
		WebElement go = driver.findElement(By.xpath("//input[@title='Go!']"));
		go.click();
		Thread.sleep(3000);
		WebElement expected = driver
				.findElement(By.xpath("//select/option[5]"));
		String actual = "Little";
		if (expected.getText().equalsIgnoreCase(actual)) {
			System.out.println("ViewAContactIntheContactPage Test Case Passed");
		} else
			System.out.println("ViewAContactIntheContactPage Test Case Failed");
	}
@Test
	public void Checktheerrormessage() throws InterruptedException {
	logInApp();
	Thread.sleep(3000);
		WebElement contact = driver.findElement(By.id("Contact_Tab"));
		contact.click();
		Thread.sleep(200);
		WebElement newview = driver.findElement(
				By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		newview.click();
		Thread.sleep(200);
		WebElement vuname = driver.findElement(By.id("devname"));
		vuname.sendKeys("EFGH");
		WebElement save = driver.findElement(By.xpath(
				"//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		save.click();
		Thread.sleep(200);
		WebElement error = driver.findElement(
				By.xpath("//div[text()=\" You must enter a value\"]"));
		String expectederror = error.getText();
		String actualerror = "Error: You must enter a value";
		if (expectederror.equalsIgnoreCase(actualerror)) {
			System.out.println("CheckTheErrorMessage test case passed");
		} else {
			System.out.println("CheckTheErrorMessage test case failed");
		}
	}
@Test
	public void Checkthecancelbutton() throws InterruptedException {
	logInApp();
	Thread.sleep(3000);
		WebElement contact = driver.findElement(By.id("Contact_Tab"));
		contact.click();
		Thread.sleep(200);
		WebElement newview = driver.findElement(
				By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		newview.click();
		Thread.sleep(200);
		WebElement vuname = driver.findElement(By.id("fname"));
		vuname.sendKeys("ABCD");
		System.out.println("view name entered");
		WebElement vu1name = driver.findElement(By.id("devname"));
		System.out.println("view unique name entered");
		vuname.clear();
		vu1name.sendKeys("EFGH");
		WebElement cancel = driver.findElement(By.xpath(
				"//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[2]"));
		cancel.click();
		String PreviousPageTitle = driver.getTitle();
		System.out.println("Title" + "=" + PreviousPageTitle);
		if (PreviousPageTitle.contains("Contacts")) {
			System.out.println("CheckTheCancelButton Test Passed -New page is displayed");
		} else {
			System.out.println("CheckTheCancelButton Test Failed - Newpage is not displayed");
		}
	}
@Test
	public void Checksaveandnewbutton() throws InterruptedException {
	logInApp();
	Thread.sleep(3000);
		WebElement contact = driver.findElement(By.id("Contact_Tab"));
		contact.click();
		Thread.sleep(200);
		WebElement newbtn = driver.findElement(
				By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		newbtn.click();
		Thread.sleep(200);
		WebElement lname = driver.findElement(By.id("name_lastcon2"));
		lname.sendKeys("Indian");
		WebElement accname = driver.findElement(By.id("con4"));
		accname.sendKeys("Global Media");
		WebElement savennew = driver
				.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[2]"));
		savennew.click();
		Thread.sleep(200);
		System.out.println("CheckSaveAndNewButton Test Passed");

	}
/*
	public static void main(String args[]) throws InterruptedException {
		SalesforceContacts obj = new SalesforceContacts();
		obj.launchBrowser("Chrome");
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.Createnewcontact();
		obj.salesforcelogout();
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.Createnewviewincontactpage();
		obj.salesforcelogout();
		Thread.sleep(200);
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.Checkrecentlycreatedcontactinthecontactpage();
		obj.salesforcelogout();
		Thread.sleep(200);
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.Checkmycontactsview();
		obj.salesforcelogout();
		Thread.sleep(200);
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.Viewacontactinthecontactpage();
		obj.salesforcelogout();
		Thread.sleep(200);
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.Checktheerrormessage();
		obj.salesforcelogout();
		Thread.sleep(200);
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.Checkthecancelbutton();
		obj.salesforcelogout();
		Thread.sleep(200);
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.Checksaveandnewbutton();
		obj.salesforcelogout();
	}*/

}