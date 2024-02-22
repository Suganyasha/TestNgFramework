package com.salesforce.automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.salesforceBase.BaseTest;

public class CreateAccount extends BaseTest {
	@Test
	public void createAccount() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement account = driver
				.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		account.click();
		WebElement newbtn = driver.findElement(
				By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		newbtn.click();
		WebElement accountname = driver
				.findElement(By.xpath("//*[@id=\"acc2\"]"));
		accountname.sendKeys("Suganya 123");
		WebElement type = driver.findElement(By.id("acc6"));
		Select selecttype = new Select(type);
		selecttype.selectByVisibleText("Technology Partner");
		WebElement custpriority = driver.findElement(By.id("00NGA00000UDJT7"));
		Select selectcustpriority = new Select(custpriority);
		selectcustpriority.selectByVisibleText("High");
		WebElement save = driver
				.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		save.click();
		WebElement topname = driver.findElement(
				By.xpath("//*[@id=\"contactHeaderRow\"]/div[2]/h2"));
		if (topname.getText().equalsIgnoreCase("Suganya 123")) {
			System.out.println("CreateAccount: test case is passed");
		} else {
			System.out.println("CreateAccount: test case is not passed");
		}
	}
	@Test
	public void createnewview() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement account = driver
				.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		account.click();
		WebElement createnewview = driver.findElement(
				By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		createnewview.click();
		WebElement viewname = driver.findElement(By.id("fname"));
		viewname.sendKeys("Aahan_VN");
		WebElement viewuniquename = driver.findElement(By.id("devname"));
		viewuniquename.sendKeys("Jahana_UN");
		WebElement save = driver.findElement(By.xpath(
				"//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		save.click();
		System.out.println("createNewView: test case is passed");

	}
	public void editview() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement account = driver
				.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		account.click();
		WebElement dropdown = driver.findElement(By.id("fcf"));
		dropdown.click();
		// System.out.println("dropdown viewed");
		WebElement editkey = driver.findElement(
				By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[1]"));
		editkey.click();
		// System.out.println("entered edit key");
		Thread.sleep(2000);
		WebElement viewname = driver.findElement(By.id("fname"));
		viewname.sendKeys("Aana");
		WebElement field = driver.findElement(By.id("fcol1"));
		Select selectfield = new Select(field);
		selectfield.selectByVisibleText("Account Name");
		WebElement operator = driver.findElement(By.id("fop1"));
		Select selectoperator = new Select(operator);
		selectoperator.selectByVisibleText("equals");
		WebElement value = driver.findElement(By.id("fval1"));
		value.sendKeys("a");
		WebElement save = driver.findElement(By.xpath(
				"//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		save.click();
		WebElement viewname1 = driver
				.findElement(By.xpath("//select[@name='fcf']/option[2]"));
		String expectedname = viewname1.getText();
		String actualname = "Aana";
		Thread.sleep(2000);
		if (actualname.equalsIgnoreCase(expectedname)) {
			System.out.println("Editview Test Case Passed");
		} else {
			System.out.println("Editview Test Case Failed");
		}
	}
@Test
	public void mergeaccounts() throws InterruptedException {
	logInApp();
	Thread.sleep(3000);
		WebElement account = driver
				.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		account.click();
		WebElement mergeaccount = driver.findElement(By.xpath(
				"//*[@id=\"toolsContent\"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a"));
		mergeaccount.click();
		WebElement faccount = driver.findElement(By.id("srch"));
		faccount.sendKeys("Suganya");
		WebElement findaccounts = driver.findElement(
				By.xpath("//*[@id=\"stageForm\"]/div/div[2]/div[4]/input[2]"));
		findaccounts.click();
		Thread.sleep(500);
		WebElement next = driver.findElement(By.xpath(
				"//*[@id=\"stageForm\"]/div/div[2]/div[5]/div/input[1]"));
		next.click();
		Thread.sleep(500);
		WebElement merge = driver.findElement(By.xpath(
				"//*[@id=\"stageForm\"]/div/div[2]/div[1]/div/input[2]"));
		merge.click();
		Thread.sleep(500);
		String expError = "These records will be merged into one record using the selected values. Merging can't be undone. Proceed with the record merge?";
		Alert al = driver.switchTo().alert();
		Thread.sleep(500);
		String actualError = al.getText();
		if (actualError.equals(expError)) {
			System.out.println("MergeAccounts TestCase Passed");
		} else {
			System.out.println("MergeAccounts TestCase Failed");
		}
		Thread.sleep(3000);
		al.accept();
	}
@Test
	public void createaccountreport() throws InterruptedException {
	logInApp();
	Thread.sleep(3000);
		WebElement account = driver
				.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		account.click();
		WebElement account30 = driver.findElement(By.xpath(
				"//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a"));
		account30.click();
		/// html/body/div[2]/div[3]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[2]/table/tbody/tr[2]/td[2]/div/div/form/div/div[1]/input
		WebElement datefield = driver.findElement(By.id("ext-gen20"));
		datefield.click();
		Thread.sleep(2000);
		/// html/body/div[17]/div/div[3]
		WebElement createddate = driver.findElement(By.xpath(
				"//div[@class='x-combo-list-inner']/div[text()='Created Date']"));
		createddate.click();
		// Select selectcreateddate =new Select(createddate);
		// selectcreateddate.selectByValue("Created Date");
		WebElement datebtn = driver
				.findElement(By.xpath("//*[@id=\"ext-gen152\"]"));
		datebtn.click();
		Thread.sleep(200);
		WebElement frombtn = driver.findElement(By.id("ext-gen281"));
		frombtn.click();
		Thread.sleep(200);
		WebElement date1btn = driver
				.findElement(By.xpath("//*[@id=\"ext-gen154\"]"));
		date1btn.click();
		Thread.sleep(200);
		WebElement tobtn = driver
				.findElement(By.xpath("//*[@id=\"ext-gen296\"]"));
		tobtn.click();
		Thread.sleep(200);
		WebElement save = driver.findElement(By.id("saveReportBtn"));
		save.click();
		Thread.sleep(200);
		WebElement reportname = driver
				.findElement(By.id("saveReportDlg_reportNameField"));
		reportname.sendKeys("Suga");
		WebElement reportuname = driver
				.findElement(By.id("saveReportDlg_DeveloperName"));
		Thread.sleep(200);
		reportuname.clear();
		Thread.sleep(200);
		reportuname.sendKeys("Laya");
		Thread.sleep(200);
		// WebElement savenrun =
		// driver.findElement(By.xpath("//button[@id='ext-gen324']"));
		WebElement savenrun = driver.findElement(By.id("dlgSaveAndRun"));
		Thread.sleep(5000);
		System.out.println("Save button is enabled: " + savenrun.isEnabled());
		savenrun.click();
		Thread.sleep(1000);
		WebElement topname = driver.findElement(By.xpath(
				"//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1"));
		if (topname.getText().equalsIgnoreCase("Suga")) {
			System.out.println("CreateAccountReport test case is passed");
		} else {
			System.out.println("CreateAccountReport test case is not passed");
		}
	}

	/*public static void main(String[] args) throws InterruptedException {
		CreateAccount obj = new CreateAccount();
		obj.launchBrowser("Chrome");
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.createAccount();
		obj.salesforcelogout();
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.createnewview();
		obj.salesforcelogout();
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.editview();
		obj.salesforcelogout();
		//obj.salesforcelogin("https://login.salesforce.com/",
		//		"suganyas@tekarch.com", "Sugan@23");
		//obj.mergeaccounts();
		//obj.salesforcelogout();
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.createaccountreport();
		obj.salesforcelogout();

	}*/
}