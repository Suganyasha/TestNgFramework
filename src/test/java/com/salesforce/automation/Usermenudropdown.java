package com.salesforce.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.salesforceBase.BaseTest;

public class Usermenudropdown extends BaseTest {
	@Test
	public void Selectusermenu() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement usermenu = driver.findElement(By.id("userNavLabel"));
		Actions action = new Actions(driver);
		action.moveToElement(usermenu).perform();
		usermenu.click();
		Thread.sleep(500);
		WebElement dropdown = driver.findElement(By.id("userNav-menuItems"));
		System.out.println("Usermenu  items = " + dropdown.getText());
		usermenu.click();
	}
	@Test
	public void SelectMyProfile() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement usermenu = driver.findElement(By.id("userNavLabel"));
		usermenu.click();
		Thread.sleep(3000);
		WebElement myprofile = driver
				.findElement(By.xpath("//a[text()='My Profile']"));
		myprofile.click();Thread.sleep(500);
		// WebElement editprf = driver
		// .findElement(By.xpath("//img[@title='Edit Profile']"));
		// editprf.click();
		// Thread.sleep(3000);
		// driver.switchTo().frame(("contactInfoContentId"));
		// WebElement abt = driver
		// .findElement(By.xpath("//*[@id=\"aboutTab\"]/a"));
		// abt.click();
		// System.out.println("from iframe");
		// WebElement lastname = driver.findElement(By.id("lastName"));
		// lastname.clear();
		// System.out.println("from last name");
		// lastname.sendKeys("Sundaram");
		// WebElement saveall = driver
		// .findElement(By.xpath("//input[@value='Save All']"));
		// saveall.click();
		// driver.switchTo().defaultContent();
		// Thread.sleep(3000);
		// WebElement post = driver
		// .findElement(By.xpath("//a[@title='Post']"));
		// post.click();
		// System.out.println("post clicked");
		// Thread.sleep(3000);
		// WebElement frame = driver
		// .findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame
		// cke_reset']"));
		// System.out.println("inside frame");
		// driver.switchTo().frame(frame);
		// WebElement text = driver
		// .findElement(By.xpath("//body[text()='Share an update, @mention
		// someone...']"));
		// text.sendKeys("hello");
		// driver.switchTo().defaultContent();
		// WebElement sharebtn = driver
		// .findElement(By.id("publishersharebutton"));
		// sharebtn.click();
		// Thread.sleep(2000);
		// WebElement file = driver
		// .findElement(By.id("publisherAttachContentPost"));
		// file.click();
		// WebElement fileupload = driver
		// .findElement(By.id("chatterUploadFileAction"));
		// fileupload.click();
		// System.out.println("fileupload btn clicked");
		// WebElement choosefile = driver
		// .findElement(By.xpath("//*[@id='chatterFile']"));
		// System.out.println("choose file btn clicked");
		// choosefile.sendKeys("C:\\Users\\ShanSuganya\\OneDrive\\Desktop\\peacock.jpeg");
		// System.out.println("file selected");
		// WebElement sharebtn1 = driver
		// .findElement(By.id("publishersharebutton"));
		// sharebtn1.click();
		// System.out.println("pic shared");
		Thread.sleep(2000); 
		WebElement displaypic = driver.findElement(By.id("displayBadge"));
		Actions action = new Actions(driver);
		action.moveToElement(displaypic).build().perform();
		WebElement addphoto = driver.findElement(By.id("uploadLink"));
		addphoto.click();Thread.sleep(500);
		driver.switchTo().frame("uploadPhotoContentId");
		Thread.sleep(3000);
		WebElement choosefilebtn = driver
				.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
		choosefilebtn.sendKeys(
				"C:\\Users\\ShanSuganya\\OneDrive\\Desktop\\peacock.jpeg");
		System.out.println("choosebtn clicked");
		WebElement savebtn = driver
				.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
		savebtn.click();Thread.sleep(500);
		System.out.println("save btn clicked");
		WebElement cropPhoto = driver.findElement(By.id("j_id0:j_id7:save"));
		cropPhoto.click();Thread.sleep(500);
		System.out.println("Test case passed : photo uploaded");

	}
	@Test
	public void SelectMySetting() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement usermenu = driver.findElement(By.id("userNavLabel"));
		Actions action = new Actions(driver);
		action.moveToElement(usermenu).perform();
		usermenu.click();
		Thread.sleep(3000);
		WebElement mysetting = driver
				.findElement(By.xpath("//a[@title='My Settings']"));
		mysetting.click();Thread.sleep(500);
		WebElement personallink = driver
				.findElement(By.id("PersonalInfo_font"));
		personallink.click();Thread.sleep(500);
		WebElement loginhistory = driver
				.findElement(By.id("LoginHistory_font"));
		loginhistory.click();Thread.sleep(500);
	}
	public void Developerconsole() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement usermenu = driver.findElement(By.id("userNavLabel"));
		usermenu.click();Thread.sleep(500);
		WebElement developerconsole = driver.findElement(
				By.xpath("//a[@title ='Developer Console (New Window)']"));
		developerconsole.click();Thread.sleep(500);
		String originalWindow = driver.getWindowHandle();
		System.out.println("all windows =" + driver.getWindowHandles());
		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				driver.close();
			}
		}
	}
	@Test
	public void Selectlogout() throws InterruptedException {
		logInApp();
		Thread.sleep(3000);
		WebElement usermenu = driver.findElement(By.id("userNavLabel"));
		Actions action = new Actions(driver);
		action.moveToElement(usermenu).perform();
		usermenu.click();Thread.sleep(500);
		WebElement dropdown = driver.findElement(By.id("userNav-menuItems"));
		System.out.println("Usermenu  items = " + dropdown.getText());
		WebElement myname = driver
				.findElement(By.xpath("//*[@id=\"userNavLabel\"]"));
		myname.click();Thread.sleep(500);
		WebElement logout = driver
				.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
		logout.click();Thread.sleep(500);
	}
	/*
	public static void main(String[] args) throws InterruptedException {
		Usermenudropdown obj = new Usermenudropdown();
		obj.launchBrowser("Chrome");
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.Selectusermenu();
		Thread.sleep(500);
		obj.salesforcelogout();
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.SelectMyProfile();
		Thread.sleep(500);
		obj.salesforcelogout();
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		obj.SelectMySetting();
		Thread.sleep(500);
		obj.salesforcelogout();
		obj.salesforcelogin("https://login.salesforce.com/",
				"suganyas@tekarch.com", "Sugan@23");
		Thread.sleep(500);
		obj.Developerconsole();
		obj.salesforcelogout();
	}*/
}
