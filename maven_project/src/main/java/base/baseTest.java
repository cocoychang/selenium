package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;

public class baseTest {
	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	
	
	@BeforeTest
	@Parameters("browser")
	public void mainBeforeTestMethod(String browser) {
		// initialize the HtmlReporter
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("HostName", "RHEL8");
        sparkReporter.config().setDocumentTitle("Automation Reports");
        setupDriver(browser);
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  
	}
	@BeforeMethod
	public void beforeMethod(Method testMethod) {
		logger = extent.createTest(testMethod.getName());
		
		
		
	}
	@AfterMethod
		public void afterMethod(ITestResult result) {
			if(result.getStatus() == ITestResult.FAILURE) {
				logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ "- Test Case Failed", ExtentColor.RED));
				logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+ "- Test Case Failed", ExtentColor.RED));
			} else if(result.getStatus() == ITestResult.SKIP) {
				logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"- Test Case Skipped", ExtentColor.ORANGE));
			}else if(result.getStatus() == ITestResult.SUCCESS) {
				logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"- Test Case Paased", ExtentColor.GREEN));
			} 
			
		}	

	@AfterTest
	public void afterTest() {
		extent.flush();
		driver.quit();
	}
public void setupDriver(String browser) {
	if(browser.equalsIgnoreCase("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}else if(browser.equalsIgnoreCase("FireFox")) {	
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}else if(browser.equalsIgnoreCase("edge")) {	
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	
}
}
