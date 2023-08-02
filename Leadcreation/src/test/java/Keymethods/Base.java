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
	SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMddyyyyM");
	String Date12 = dateFormat2.format(new Date());

	public void Base1(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport)
			throws InterruptedException, AWTException, IOException {
		test = extentreport.createTest("Vakilsearch Test");
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
		SimpleDateFormat dateFormat1PrivateLimited = new SimpleDateFormat("MMddyyMMS");
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
		test.log(Status.PASS, "Lead form page " + totalTime + "ms");
		System.out.println(driver.getTitle().toString());

		LoginPageobjects.Email.sendKeys("shakthi" + Date11PrivateLimited + "@yopmail.com");

		LoginPageobjects.Phonenumber.click();

		LoginPageobjects.Phonenumber.sendKeys("9" + Date11PrivateLimited);
		Thread.sleep(2000);
		LoginPageobjects.City.click();
		LoginPageobjects.City.sendKeys("chen");

		Thread.sleep(6000);
		WebElement findElement12 = driver.findElement(By.xpath("//div[contains(text(),'Chennai, Tamil Nadu')]"));
		wait.until(ExpectedConditions.elementToBeClickable(findElement12)).click();
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
		String text = driver.findElement(
				By.xpath("//p[contains(text(),'Takes less than 1 min')]"))
				.getText();
		System.out.println(text);
		long finish1 = System.currentTimeMillis();
		long totalTime1 = finish1 - start1;
		System.out.println("Total Time for page load - " + totalTime1);

		test.log(Status.PASS, "Enter  company name page " + totalTime1 + "ms");

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
			
			//.findElement(By.xpath("//button[@class='styles_customBtn__nb6mV styles_next__NvT8q false false ']"))
				//	.click();
			
	
		try {
			long start22 = System.currentTimeMillis();
			LoginPageobjects.Next.click();
			
			
			driver.findElement(By.xpath("//input[@class='styles_otpInput__5bXLj']")).click();
			
			long finish22 = System.currentTimeMillis();
			long totalTime22 = finish22 - start22;

			test.log(Status.PASS, "Mobile OTP verification page " + totalTime22 + "ms");
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_DELETE);
			robot.keyRelease(KeyEvent.VK_DELETE);
			driver.findElement(By.xpath("//input[@class='styles_otpInput__5bXLj']")).sendKeys("9789955331");

			driver.findElement(By.xpath("//button[contains(text(),'Send OTP')]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[1]"))
					.sendKeys("0");
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[2]"))
					.sendKeys("0");
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[3]"))
					.sendKeys("0");
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[4]"))
					.sendKeys("0");
			Thread.sleep(4000);
			long start2 = System.currentTimeMillis();
			driver.findElement(By.xpath("//p[contains(text(),'Next')]")).click();
			String text2 = driver.findElement(By.xpath("//p[contains(text(),'Takes less than 1 min')]")).getText();
		System.out.println(text2);
			long finish2 = System.currentTimeMillis();
			long totalTime2111 = finish2 - start2;

			test.log(Status.PASS, "Payment Cart Page " + totalTime2111 + "ms");
			driver.findElement(By.xpath("//span[contains(text(),'Proceed to pay')]")).click();
			driver.findElement(By.xpath("(//div[@class='nav-item'])[1]")).click();
			driver.findElement(By.xpath("//input[@id='gpay']")).click();
			driver.findElement(By.xpath("//button[@id='btn-gpay']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//i[@class='back']")).click();

		} catch (Exception MyIntrest1) {

			test.log(Status.PASS, "Retry Page Triggered");
			System.out.println(MyIntrest1);
		}
		try {
			driver.switchTo().alert().accept();
		} catch (Exception Alert34) {
			System.out.println(Alert34);
		}
		// driver.findElement(By.xpath("//i[@class='back']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'YES, CANCEL')]")).click();

	}

	public void GstRegistration(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport)
			throws InterruptedException, AWTException, IOException {
		SimpleDateFormat dateFormat1GstRegistration = new SimpleDateFormat("MMddyyMMS");
		String Date1GstRegistration = dateFormat1GstRegistration.format(new Date());
		test = extentreport.createTest("GST Registration");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		HelpdeskPageobject.TaxCompliance.click();
		long start = System.currentTimeMillis();
		WebElement element3 = driver.findElement(By.xpath("(//a[contains(text(),'GST Registration')])[1]"));
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("arguments[0].click();", element3);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='service_form_primary_email']")));
		LoginPageobjects.Email.click();
		
		
		long finish = System.currentTimeMillis();
		long totalTime = finish - start;
		System.out.println("Total Time for page load - " + totalTime);

		test.log(Status.PASS, "Lead form page  " + totalTime + "ms");
		// HelpdeskPageobject.GSTRegistration.click();

	

		LoginPageobjects.Email.sendKeys("shakthi" + Date1GstRegistration + "@yopmail.com");

		LoginPageobjects.Phonenumber.click();

		LoginPageobjects.Phonenumber.sendKeys("9" + Date1GstRegistration);
		Thread.sleep(2000);
		LoginPageobjects.City.click();
		LoginPageobjects.City.sendKeys("chen");
     
		Thread.sleep(16000);
		WebElement findElement12 = driver.findElement(By.xpath("//div[contains(text(),'Chennai, Tamil Nadu')]"));
		wait.until(ExpectedConditions.elementToBeClickable(findElement12)).click();
		Robot robot = new Robot();

//		if (LoginPageobjects.whatsapptogleoff.isSelected()) {
//
//			test.log(Status.PASS, "whatsapptogle off");
//		} else {
//System.out.println("failed");
//			test.log(Status.FAIL, "whatsapptogleoff Failed");
//		}
		LoginPageobjects.whatsapptogleoffGSTRegistration.click();
		Thread.sleep(2000);
		long start1 = System.currentTimeMillis();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@class='fullwidth btn btn-primary']")));
		driver.findElement(By.xpath("//button[@class='fullwidth btn btn-primary']")).click();
		
		
		System.out.println("succes1");

		long finish1 = System.currentTimeMillis();
		long totalTime1 = finish1 - start1;
		System.out.println("Age of Business selection page " + totalTime1);

		Thread.sleep(1500);

		try {
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//label[contains(text(),'No, I don’t have a company name')]")));

			LoginPageobjects.noidonthaveacompanyNameGSTRig.click();

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
			driver.findElement(By.xpath("//label[contains(text(),'New business')]")).click();

			test.log(Status.PASS, "Payment Cart PageTotal Time for page load " + totalTime1);
			LoginPageobjects.Next.click();
			System.out.println(e);
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//label[contains(text(),'No, I don’t have a company name')]")));
			LoginPageobjects.noidonthaveacompanyNameGSTRig.click();
			Thread.sleep(2000);
			LoginPageobjects.Next.click();
			Thread.sleep(3000);
			LoginPageobjects.Software.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}

		try {
			long start21 = System.currentTimeMillis();
			LoginPageobjects.Next.click();
			driver.findElement(By.xpath("//input[@class='styles_otpInput__5bXLj']")).click();
		    long finish21 = System.currentTimeMillis();
			long totalTime21 = finish21 - start21;
			System.out.println("Mobile OTP verification page - " + totalTime21);

			test.log(Status.PASS, "Mobile OTP verification page" + totalTime21);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_DELETE);
			robot.keyRelease(KeyEvent.VK_DELETE);
			driver.findElement(By.xpath("//input[@class='styles_otpInput__5bXLj']")).sendKeys("9789955331");
			driver.findElement(By.xpath("//button[contains(text(),'Send OTP')]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[1]"))
					.sendKeys("0");
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[2]"))
					.sendKeys("0");
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[3]"))
					.sendKeys("0");
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[4]"))
					.sendKeys("0");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//p[contains(text(),'Next')]")).click();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			long start2 = System.currentTimeMillis();
			WebElement element39 = driver.findElement(By.xpath("//span[contains(text(),'Proceed to pay')]"));
			JavascriptExecutor executor39 = (JavascriptExecutor) driver;
			executor39.executeScript("arguments[0].click();", element39);
			driver.findElement(By.xpath("(//div[@class='nav-item'])[1]")).click();
			
			long finish2 = System.currentTimeMillis();
			long totalTime2 = finish2 - start2;
			System.out.println("Total Time for page load - " + totalTime2);

			test.log(Status.PASS, "Payment cart page " + totalTime2);
			
			driver.findElement(By.xpath("//input[@id='gpay']")).click();
			driver.findElement(By.xpath("//button[@id='btn-gpay']")).click();
			Thread.sleep(3000);
			try {

				driver.findElement(By.xpath("//i[@class='back']")).click();
				try {
					driver.switchTo().alert().accept();
				} catch (Exception Z) {
					System.out.println(Z);
				}
				// driver.findElement(By.xpath("//i[@class='back']")).click();
				driver.findElement(By.xpath("//button[contains(text(),'YES, CANCEL')]")).click();

			} catch (Exception e) {
				System.out.println(e);
			}

			// driver.findElement(By.xpath("//button[contains(text(),'View
			// account')]")).click();

		} catch (Exception MyIntrest1) {

			test.log(Status.PASS, "Otp Validation / Payment Cart Page");
			System.out.println("MyIntrest1");
		}
		try {
			driver.switchTo().alert().accept();
		} catch (Exception Alert34) {
			System.out.println(Alert34);
		}
		Thread.sleep(3500);
	}

	public void TrademarkRegistration(WebDriver driver, String Username, String Mobilenumber,
			ExtentReports extentreport) throws InterruptedException, AWTException, IOException {
		SimpleDateFormat dateFormat1TrademarkRegistration = new SimpleDateFormat("MMddyyMMS");
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

		test.log(Status.PASS, "Trademark Registration Time for page load " + totalTime + "ms");
		// HelpdeskPageobject.GSTRegistration.click();

		

		LoginPageobjects.Email.sendKeys("shakthi" + Date1TrademarkRegistration + "@yopmail.com");

		LoginPageobjects.PhonenumberTrademarkIP.click();

		LoginPageobjects.PhonenumberTrademarkIP.sendKeys("9789955331");
		Thread.sleep(2000);
		LoginPageobjects.CityTrademark.click();
		LoginPageobjects.CityTrademark.sendKeys("chen");

		Thread.sleep(16000);
		WebElement findElement12 = driver.findElement(By.xpath("//div[contains(text(),'Chennai, Tamil Nadu')]"));
		wait.until(ExpectedConditions.elementToBeClickable(findElement12)).click();
		Robot robot = new Robot();

//		if (LoginPageobjects.whatsapptogleoff.isSelected()) {
//
//			test.log(Status.PASS, "whatsapptogle off");
//		} else {
//System.out.println("failed");
//			test.log(Status.FAIL, "whatsapptogleoff Failed");
//		}
		LoginPageobjects.toggleTrademark.click();
		Thread.sleep(2000);
		
		// driver.findElement(By.xpath("(//button[contains(text(),'Consult an
		// Expert')])[1]")).click();
//System.out.println("succes1");

		

		try {
			long start2 = System.currentTimeMillis();
			WebElement element501011 = driver.findElement(By.xpath("(//button[contains(text(),'Consult an Expert')])[1]"));
			JavascriptExecutor executor501011 = (JavascriptExecutor) driver;
			executor501011.executeScript("arguments[0].click();", element501011);
			driver.findElement(By.xpath("(//div[@class='styles_content__g4N5_'])[4]")).click();
			long finish2 = System.currentTimeMillis();
			long totalTime2 = finish2 - start2;
			System.out.println("Total Time for page load - " + totalTime2);

			test.log(Status.PASS, "Enter  company name page" + totalTime2 + "ms");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//p[contains(text(),'Next')]")).click();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(3000);
			long start3 = System.currentTimeMillis();
			driver.findElement(By.xpath("//div[@class='styles_btnCta__Vt6zM']")).click();
			driver.findElement(By.xpath("(//div[@class='nav-item'])[1]")).click();
			long finish3 = System.currentTimeMillis();
			long totalTime3 = finish3 - start3;
			System.out.println("Total Time for page load - " + totalTime2);

			test.log(Status.PASS, "Payment Cart Page  Time for load " + totalTime2 + "ms");

			
			driver.findElement(By.xpath("//input[@id='gpay']")).click();
			driver.findElement(By.xpath("//button[@id='btn-gpay']")).click();
			Thread.sleep(3000);
			try {

				driver.findElement(By.xpath("//i[@class='back']")).click();
				try {
					driver.switchTo().alert().accept();
				} catch (Exception Z) {
					System.out.println(Z);
				}
				// driver.findElement(By.xpath("//i[@class='back']")).click();
				driver.findElement(By.xpath("//button[contains(text(),'YES, CANCEL')]")).click();
				driver.switchTo().alert().accept();

			} catch (Exception e) {
				System.out.println(e);
			}

		} catch (Exception MyIntrest1) {

			test.log(Status.FAIL, "Payment Cart Page");
			System.out.println(MyIntrest1);
		}
		try {
			driver.switchTo().alert().accept();
		} catch (Exception Alert34) {
			System.out.println(Alert34);
		}
		Thread.sleep(4500);
	}

	public void helpdesk(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport,
			String Helpdeskuserid, String helpdeskpassword) throws InterruptedException {
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
			WebElement element501011 = driver.findElement(By.xpath("//input[@id='search']"));
			JavascriptExecutor executor501011 = (JavascriptExecutor) driver;
			executor501011.executeScript("arguments[0].click();", element501011);
			element501011.sendKeys("9789955331");
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
