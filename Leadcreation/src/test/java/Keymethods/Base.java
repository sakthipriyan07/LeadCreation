package Keymethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import MainBase.CriticalFlowDetail;
import PageFactory.HelpdeskPageobject;
import PageFactory.HomescreenPageobject;
import PageFactory.LoginPageobjects;

public class Base extends HelpdeskPageobject {

	ExtentTest test;

	ScreenShot screenshot = new ScreenShot();
	SimpleDateFormat dateFormat1 = new SimpleDateFormat("MMddyyHHMMSSSS");
	String Date11 = dateFormat1.format(new Date());
	SimpleDateFormat dateFormat2 = new SimpleDateFormat("wwyyyyhh");
	String Date12 = dateFormat2.format(new Date());

	public void Base1(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport)
			throws InterruptedException, AWTException, IOException {
		test = extentreport.createTest("Vakilsearch website landing");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();

		driver.get("https://vakilsearch.com/");

		PageFactory.initElements(driver, LoginPageobjects.class);
		if (driver.getTitle() != "Online Legal Services for Startups & SMEs in India | Vakil Search") {
			test.log(Status.PASS, "VakilSearchURL launched");

		} else {

			test.log(Status.FAIL, "VakilSearchURL");
		}

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@datainput='1']")));
		// Thread.sleep(2000);

	}

	public void PrivateLimited(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport)
			throws IOException, InterruptedException, AWTException {
		SimpleDateFormat dateFormat1PrivateLimited = new SimpleDateFormat("wwyyyyhhmm");
		String Date11PrivateLimited = dateFormat1PrivateLimited.format(new Date());
		test = extentreport.createTest("Private Limited Company");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Business Setup']")));
		LoginPageobjects.Businesssetup.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//b[normalize-space()='Private Limited Company']")));
		long start = System.currentTimeMillis();
		LoginPageobjects.Pvtdcompany.click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='service_form_primary_email']")));
		LoginPageobjects.Email.click();
		long finish = System.currentTimeMillis();
		long totalTime = finish - start;
		System.out.println("Total Time for page load - " + totalTime);
		test.log(Status.PASS, "PVT Page redirection " + totalTime + "ms");
		System.out.println(driver.getTitle().toString());

		LoginPageobjects.Email.sendKeys("shakthi" + Date11PrivateLimited + "@yopmail.com");

		LoginPageobjects.Phonenumber.click();

		LoginPageobjects.Phonenumber.sendKeys("91" + Date12);
		Thread.sleep(3000);

		WebElement element310 = driver.findElement(By.xpath("//input[@placeholder='City*']"));
		JavascriptExecutor executor310 = (JavascriptExecutor) driver;
		executor310.executeScript("arguments[0].click();", element310);
		// LoginPageobjects.City.click();
		LoginPageobjects.City.sendKeys("chen");

		Thread.sleep(6000);

		WebElement element31 = driver.findElement(By.xpath("//div[contains(text(),'Chennai, Tamil Nadu')]"));
		JavascriptExecutor executor31 = (JavascriptExecutor) driver;
		executor31.executeScript("arguments[0].click();", element31);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
//		if (LoginPageobjects.whatsapptogleoff.isSelected()) {
//
//			test.log(Status.PASS, "whatsapptogle off");
//		} else {
//System.out.println("failed");
//			test.log(Status.FAIL, "whatsapptogleoff Failed");
//		}
		LoginPageobjects.whatsapptogleoff.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@class='fullwidth btn btn-primary']")));
		long start1 = System.currentTimeMillis();
		driver.findElement(By.xpath("//button[@class='fullwidth btn btn-primary']")).click();
		System.out.println("succes1");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Takes less than 1 min')]")));
		String text = driver.findElement(By.xpath("//p[contains(text(),'Takes less than 1 min')]")).getText();
		System.out.println(text);
		long finish1 = System.currentTimeMillis();
		long totalTime1 = finish1 - start1;
		System.out.println("Total Time for page load - " + totalTime1);

		test.log(Status.PASS, "Enter  company name page redirection " + totalTime1 + "ms");

		Thread.sleep(1500);

		driver.findElement(By.xpath("//span[contains(text(),'Skip it for now')]")).click();
		Thread.sleep(2000);
		LoginPageobjects.Ageofbusiness.click();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// LoginPageobjects.Next.click();

		// .findElement(By.xpath("//button[@class='styles_customBtn__nb6mV
		// styles_next__NvT8q false false ']"))
		// .click();

		long start21 = System.currentTimeMillis();
		driver.findElement(By.xpath("//button[@class='styles_customBtn__nb6mV styles_next__NvT8q false false ']"))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Next')]"))).getText();
		
		long finish21 = System.currentTimeMillis();
		long totalTime21 = finish21 - start21;
		System.out.println("Total Time for page load - " + totalTime21);

		test.log(Status.PASS, "Mobile OTP Redirection " + totalTime21 + "ms");

		long start211 = System.currentTimeMillis();
		driver.findElement(By.xpath("//p[contains(text(),'Next')]")).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Proceed to pay')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Proceed to pay')]")).click();

		long finish2111 = System.currentTimeMillis();
		long totalTime2111 = finish2111 - start211;
		System.out.println("Total Time for page load - " + totalTime21);

		test.log(Status.PASS, "PaymentPage redirection " + totalTime2111 + "ms");
	}

	public void GstRegistration(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport)
			throws InterruptedException, AWTException, IOException {
		SimpleDateFormat dateFormat1GstRegistration = new SimpleDateFormat("wwmmyyyyhhmm");
		String Date1GstRegistration = dateFormat1GstRegistration.format(new Date());
		test = extentreport.createTest("GST Registration");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		HelpdeskPageobject.TaxCompliance.click();
		long start = System.currentTimeMillis();
		WebElement element3 = driver.findElement(By.xpath("(//a[contains(text(),'GST Registration')])[1]"));
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("arguments[0].click();", element3);
		WebElement findElement = driver.findElement(By.xpath("//input[@id='inputForEmail']"));
		findElement.click();

		long finish = System.currentTimeMillis();
		long totalTime = finish - start;
		System.out.println("Total Time for page load - " + totalTime);

		test.log(Status.PASS, "GST registration Page redirection  " + totalTime + "ms");
		// HelpdeskPageobject.GSTRegistration.click();

		findElement.sendKeys("shakthi" + Date1GstRegistration + "@yopmail.com");

		LoginPageobjects.Phonenumber.sendKeys("91" + Date12);
		Thread.sleep(2000);
		WebElement findElement2 = driver.findElement(By.xpath("//input[@placeholder='City']"));
		JavascriptExecutor findElement54 = (JavascriptExecutor) driver;
		findElement54.executeScript("arguments[0].click();", findElement2);

		findElement2.sendKeys("chen");
		Thread.sleep(10000);
		WebElement findElement222 = driver.findElement(By.xpath("//div[contains(text(),'Chennai, Tamil Nadu')]"));
		JavascriptExecutor findElement5422 = (JavascriptExecutor) driver;
		findElement5422.executeScript("arguments[0].click();", findElement222);
		
	
		Robot robot = new Robot();

//		if (LoginPageobjects.whatsapptogleoff.isSelected()) {
//
//			test.log(Status.PASS, "whatsapptogle off");
//		} else {
//System.out.println("failed");
//			test.log(Status.FAIL, "whatsapptogleoff Failed");
//		}

		Thread.sleep(2000);
		long start1 = System.currentTimeMillis();
		
		WebElement element300 = driver.findElement(By.xpath("(//button[@class='styles_actionBtn__XNtcU'])[1]"));
		JavascriptExecutor executor300 = (JavascriptExecutor) driver;
		executor300.executeScript("arguments[0].click();", element300);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//label[contains(text(),'No, I don’t have a company name')]/parent::div")));

		System.out.println("succes1");

		long finish1 = System.currentTimeMillis();
		long totalTime1 = finish1 - start1;
		System.out.println("Age of Business Page Redirection " + totalTime1);

		Thread.sleep(3500);

		try {
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//label[contains(text(),'No, I don’t have a company name')]/parent::div")));
driver.findElement(By.xpath("//label[contains(text(),'No, I don’t have a company name')]/parent::div")).click();
	

			test.log(Status.PASS, "Age of Business selection page " + totalTime1 + "ms");
			Thread.sleep(2000);
			LoginPageobjects.Next.click();
			Thread.sleep(3000);
			LoginPageobjects.Software.click();
			Thread.sleep(2000);

//			Thread.sleep(2000);
//			LoginPageobjects.Ageofbusiness.click();
//			robot.keyPress(KeyEvent.VK_DOWN);
//			robot.keyRelease(KeyEvent.VK_DOWN);
//
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e);
			driver.findElement(By.xpath("//label[contains(text(),'New business')]")).click();

			test.log(Status.PASS, "Payment Cart PageTotal Time for page load " + totalTime1);
			LoginPageobjects.Next.click();
			Thread.sleep(4000);
			System.out.println(e);
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//label[contains(text(),'No, I don’t have a company name')]")));
		
			
			JavascriptExecutor executor34 = (JavascriptExecutor) driver;
			executor34.executeScript("arguments[0].click();", noidonthaveacompanyNameGSTRig);
		//	LoginPageobjects.noidonthaveacompanyNameGSTRig.click();
			Thread.sleep(2000);
			LoginPageobjects.Next.click();
			Thread.sleep(3000);
			LoginPageobjects.Software.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}

		long start21 = System.currentTimeMillis();
		LoginPageobjects.Next.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@class='styles_otpInput__5bXLj']")));
		driver.findElement(By.xpath("//input[@class='styles_otpInput__5bXLj']")).click();
		long finish21 = System.currentTimeMillis();
		long totalTime21 = finish21 - start21;
		System.out.println("Payment Page Redirection - " + totalTime21);

		test.log(Status.PASS, "Mobile OTP verification page" + totalTime21);
		
	}

	public void TrademarkRegistration(WebDriver driver, String Username, String Mobilenumber,
			ExtentReports extentreport) throws InterruptedException, AWTException, IOException {
		SimpleDateFormat dateFormat1TrademarkRegistration = new SimpleDateFormat("mmwwyyyyhhmm");
		String Date1TrademarkRegistration = dateFormat1TrademarkRegistration.format(new Date());
		test = extentreport.createTest("Trademark Registration");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		HelpdeskPageobject.TrademarkIP.click();

		long start = System.currentTimeMillis();
		WebElement element3 = driver.findElement(By.xpath("(//b[contains(text(),'Trademark Registration')])"));
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("arguments[0].click();", element3);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='service_form_primary_email']")));
		LoginPageobjects.Email.click();

		long finish = System.currentTimeMillis();
		long totalTime = finish - start;
		System.out.println("Total Time for page load - " + totalTime);

		test.log(Status.PASS, "Trademark Registration Redirection " + totalTime + "ms");
		// HelpdeskPageobject.GSTRegistration.click();

		LoginPageobjects.Email.sendKeys("shakthi" + Date1TrademarkRegistration + "@yopmail.com");

		LoginPageobjects.PhonenumberTrademarkIP.click();

		LoginPageobjects.PhonenumberTrademarkIP.sendKeys("91" + Date12);
		Thread.sleep(2000);
		
		WebElement findElement12w = driver.findElement(By.xpath("//input[@placeholder='City']"));
		JavascriptExecutor findElement122w = (JavascriptExecutor) driver;
		findElement122w.executeScript("arguments[0].click();", findElement12w);
	
		LoginPageobjects.CityTrademark.sendKeys("chen");

		Thread.sleep(10000);
		WebElement findElement12 = driver.findElement(By.xpath("//div[contains(text(),'Chennai, Tamil Nadu')]"));
		JavascriptExecutor findElement122 = (JavascriptExecutor) driver;
		findElement122.executeScript("arguments[0].click();", findElement12);
		
		
		Robot robot = new Robot();

//		if (LoginPageobjects.whatsapptogleoff.isSelected()) {
//
//			test.log(Status.PASS, "whatsapptogle off");
//		} else {
//System.out.println("failed");
//			test.log(Status.FAIL, "whatsapptogleoff Failed");
//		}
	//	LoginPageobjects.toggleTrademark.click();
		Thread.sleep(2000);

		// driver.findElement(By.xpath("(//button[contains(text(),'Consult an
		// Expert')])[1]")).click();
//System.out.println("succes1");

		
			long start2 = System.currentTimeMillis();
			WebElement element501011 = driver
					.findElement(By.xpath("(//button[contains(text(),'Consult an Expert')])[1]"));
			JavascriptExecutor executor501011 = (JavascriptExecutor) driver;
			executor501011.executeScript("arguments[0].click();", element501011);
			
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='styles_headingg___9Kcx'])[4]"))).click();
			
			long finish2 = System.currentTimeMillis();
			long totalTime2 = finish2 - start2;
			System.out.println("Total Time for page load - " + totalTime2);

			test.log(Status.PASS, "Enter  company name page Redirection" + totalTime2 + "ms");
			Thread.sleep(2000);
					
			driver.findElement(By.xpath("//button[@class='styles_customBtn__nb6mV styles_next__NvT8q false false ']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@class='styles_customBtn__nb6mV styles_next__NvT8q false false ']")).click();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			long start290 = System.currentTimeMillis();
			driver.findElement(By.xpath("//span[contains(text(),'Proceed to pay')]")).click();
			Thread.sleep(5000);
			long finish290 = System.currentTimeMillis();
			long totalTime290 = finish290 - start290;
			System.out.println("Total Time for page load - " + totalTime290);

			test.log(Status.PASS, "Payment page Redirection" + totalTime290 + "ms");
			Thread.sleep(2000);
			
			
			
	}
			

	public void helpdesk(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport,
			String Helpdeskuserid, String helpdeskpassword) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
			SimpleDateFormat dateFormat1TrademarkRegistration1 = new SimpleDateFormat("wwyyyyhh");
			String Date1TrademarkRegistration1 = dateFormat1TrademarkRegistration1.format(new Date());
		test = extentreport.createTest("HelpDesk lead Verification Result");
		driver.get("https://helpdesk.vakilsearch.com/login");

		Thread.sleep(10000);
		Username1.sendKeys(Helpdeskuserid);
		String text1 = Username1.getText();
		String text2 = "testingsa_2_2020@vakilsearch.com";
		System.out.println(text1);
//		if (text1.contains(text2)) {
//			test.log(Status.PASS, "Yes");
//		} else {
//
//			test.log(Status.FAIL, "Username Not same");
//		}

		Password.sendKeys(helpdeskpassword);
		Signin.click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Helpdesk.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Tickets.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(8000);
		try {
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search']")));
			
			WebElement element501011 = driver.findElement(By.xpath("//input[@id='search']"));
			JavascriptExecutor executor501011 = (JavascriptExecutor) driver;
			executor501011.executeScript("arguments[0].click();", element501011);
			element501011.sendKeys("91" + Date12);
			driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
			String ticket3 = driver
					.findElement(
							By.xpath("(//tr[@class='ticket_index_tr'])[3]//child::td/child::div/child::ul/child::li"))
					.getText().substring(0, 51);
			String ticket2 = driver
					.findElement(
							By.xpath("(//tr[@class='ticket_index_tr'])[2]//child::td/child::div/child::ul/child::li"))
					.getText().substring(0, 49);
			String ticket1 = driver
					.findElement(
							By.xpath("(//tr[@class='ticket_index_tr'])[1]//child::td/child::div/child::ul/child::li"))
					.getText().substring(0, 39);
			String ticket02 = "Need Help with : Goods & Service Tax Registration";
			String ticket03 = "Need Help with : Private Limited Company Registration";
			String ticket01 = "Need Help with : Trademark Registration";

			if (ticket03.contains(ticket3)) {

				test.log(Status.PASS, "Private Limited Company Registration lead verified");
			} else {
				test.log(Status.FAIL, "Private Limited Company Registration lead Failed");
			}

			if (ticket02.contains(ticket2)) {

				test.log(Status.PASS, "Need Help with : Goods & Service Tax Registration lead verified");
			} else {
				test.log(Status.FAIL, "Need Help with : Goods & Service Tax Registration lead Failed");
			}

			if (ticket01.contains(ticket1)) {

				test.log(Status.PASS, "Need Help with : Trademark Registration lead verified");
			} else {
				test.log(Status.FAIL, "Need Help with : Trademark Registration lead Failed");
			}

		} catch (Exception Search) {
			System.out.println(Search);

		}
	}

}
