package com.salesforceBase;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
// warning fatal bebug, info
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;
import com.salesforce.utility.Constants;
import com.salesforce.utility.ExtentReportsUtility;
import com.salesforce.utility.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.salesforce.utility.SalesforceListenerUtility.class)
public class BaseTest {
	
	protected static WebDriver driver = null;
	protected ExtentReportsUtility extentReport=ExtentReportsUtility.getInstance();

	protected Logger baseTestlog=LogManager.getLogger();
	
	@BeforeMethod
	@Parameters("browserName")
	public void setUpBeforeMethod(@Optional("firefox") String name,ITestResult result) throws InterruptedException {
		
		baseTestlog.info(".........BeforeMethod setUpBeforeMethod executed---------------");
		launchBrowser(name);
		
		String url=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"url");
		goToUrl(url);
	}
	
	@AfterMethod
	public void tearDownAfterTestMethod() {
		closeBrowser();
		baseTestlog.info("******tearDownAfterTestMethod executed***********");
	}
	
	
	
	public void launchBrowser(String browserName) throws InterruptedException {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			baseTestlog.info("browser instance chrome created.");
			//extentReport.logTestInfo("browser instance chrome created");
			driver.manage().window().maximize();
			baseTestlog.info("window is maximized");
			System.out.println(driver);
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		case "safari":
			// Safari does not require a separate driver setup, as it is included with macOS
			driver = new SafariDriver();
			break;

		default:
			baseTestlog.info("Unsupported browser: " + browserName);
		}

		// return driver;
	}
	
	public void goToUrl(String url) {
		driver.get(url);
		baseTestlog.info(url + "is entered");
		
	}
	
	public void closeBrowser() {
		driver.close();
		baseTestlog.info("browser instance closed");
		driver=null;
	}
	public void quitBrowser() {
		driver.quit();
		baseTestlog.info("all browser closed");
		driver=null;
		
	}
	
	public void takescreenshot(String filepath) {
		 TakesScreenshot screenCapture=(TakesScreenshot)driver;
		 File src=screenCapture.getScreenshotAs(OutputType.FILE);
		 File destination=new File(filepath);
		 try {
			Files.copy(src, destination);
			baseTestlog.info("captured the screen");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			baseTestlog.info("went wrong when capturing the screen");
			
		}
	}
	
	public void takescreenshot(WebElement element,String filepath) {
		
	}
	
	public void launchApp() throws InterruptedException {
		driver.get("https://login.salesforce.com/");
		if (driver.getTitle().equalsIgnoreCase("Login | Salesforce")) {
			System.out.println("Salesforce application page is displayed");
		}
		else {
			System.out.println("Failed ! Salesforce application page is not displayed");
		}	
		Thread.sleep(2000);
	}
	
	public void logInApp() throws InterruptedException {
		Thread.sleep(1000);
		WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		username.sendKeys("suganyas@tekarch.com");
		System.out.println("User Name is displayed in User name field");
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys("Sugan@23");
		System.out.println("Password displayed in password feild");
//		WebElement rememberButton = driver.findElement(By.xpath("//*[@id=\"rememberUn\"]"));
//	    rememberButton.click();
		WebElement logButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/input[2]"));
		logButton.click();
		Thread.sleep(3000);
	    String title = driver.getTitle();
	    if(driver.getTitle().equalsIgnoreCase(title)) {
	    	System.out.println("Test pass. Salesforce homepage displayed");
	    }
	    else {
	    	System.out.println("test failed. Salesforce homepage not displayed");
	    }
	}
	
	public void logInApp(String username, String password) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"username\"]"))
			.sendKeys(username);
		System.out.println("User Name is displayed in User name field");
		driver.findElement(By.xpath("//*[@id=\"password\"]"))
			.sendKeys(password);
		System.out.println("Password displayed in password feild");

		WebElement logButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/input[2]"));
		logButton.click();
		Thread.sleep(3000);
	    String title = driver.getTitle();
	    if(driver.getTitle().equalsIgnoreCase(title)) {
	    	System.out.println("Test pass. Salesforce homepage displayed");
	    }
	    else {
	    	System.out.println("test failed. Salesforce homepage not displayed");
	    }
	}
	
	public void logOutApp() throws InterruptedException {
		Thread.sleep(3000);
		WebElement dropdown = driver.findElement(By.id("userNav-arrow"));
	    dropdown.click();
	    Thread.sleep(1000);
		WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
	    logout.click();
	    System.out.println("Home page loggedout successfully");
	}
	

/*public void clickcontact() throws InterruptedException {
	WebElement contact = driver
			.findElement(By.xpath("//a[@title='Contacts Tab']"));
	contact.click();
}
public void createnewcontact() throws InterruptedException {
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
}
  public void createnewviewincontactpage() throws InterruptedException {
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
}
  public void checkrecentlycreatedcontactinthecontactpage() throws InterruptedException {
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
	public void checkmycontactsview() throws InterruptedException {
	
		WebElement view = driver.findElement(By.id("fcf"));
		Select selectview = new Select(view);
		selectview.selectByVisibleText("My Contacts");
		WebElement go = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
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
	public void viewacontactinthecontactpage() throws InterruptedException {

		WebElement view1 = driver.findElement(By.id("fcf"));
		Select selectview1 = new Select(view1);
		selectview1.selectByVisibleText("Little");
		WebElement go = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
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
	public void checktheerrormessage() throws InterruptedException {
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
}*/
}