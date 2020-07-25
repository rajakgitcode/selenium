package Utility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Test.TestBase;

public class ExtentTestNGITestListener extends TestListenerAdapter {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public static ExtentTest logger;

	@Override
	public synchronized void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // time stamp

		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/ExtentReport" + "_" + timeStamp + ".html");
		
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

		report = new ExtentReports();

		report.attachReporter(htmlReporter);
		report.setSystemInfo("Host name", "localhost");
		report.setSystemInfo("Environemnt", "QA");
		report.setSystemInfo("user", "Raja");

		htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		htmlReporter.config().setReportName("Functional Testing"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		report.flush();
	}

	@Override
	public synchronized void onTestStart(ITestResult testResult) {
		// report.createTest(testResult.getName());
		// logger.info("****Test Started****" + testResult.getName());

	}

	@Override
	public synchronized void onTestSuccess(ITestResult testResult) {
		logger = report.createTest(testResult.getName()); // create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(testResult.getName(), ExtentColor.GREEN)); 
	}

	@Override
	public synchronized void onTestFailure(ITestResult testResult) {
		logger = report.createTest(testResult.getName()); // create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(testResult.getName(), ExtentColor.RED)); 

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp

		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + testResult.getName() + "_"
				+ timeStamp + ".jpg";
		
		logger.log(Status.DEBUG,  testResult.getThrowable().getMessage());
		
		try {
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void onTestSkipped(ITestResult testResult) {
		logger = report.createTest(testResult.getName()); // create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(testResult.getName(), ExtentColor.ORANGE)); 
	}

	@Override
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}
}
