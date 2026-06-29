package capgemini.waltdisney;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	ExtentReports extent;

	@Test
	public void getlink() {
		ExtentTest test = extent.createTest("Getting link");// create a test
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		extent.flush();// saying test is over
	}

	@BeforeTest
	public void report() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);// here we need togive path where report should
																		// save so this will create a report in that
																		// purticular path
		reporter.config().setReportName("dummyresults");
		reporter.config().setDocumentTitle("summa");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Testers", "Raj2a");
	}
}
