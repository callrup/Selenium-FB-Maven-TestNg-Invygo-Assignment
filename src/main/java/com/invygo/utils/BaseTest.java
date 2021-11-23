package com.invygo.utils;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


/**
 * Unit test for simple App.
 */
public class BaseTest 
   
{
    
	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	public void setupDriver(String browserName)
	
	{
		
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + File.separator+ "drivers"+ File.separator	+"chromedriver.exe");
			//Create prefs map to store all preferences 
			Map<String, Object> prefs = new HashMap<String, Object>();

			//Put this into prefs map to switch off browser notification
			prefs.put("profile.default_content_setting_values.notifications", 2);

			//Create chrome options to set this prefs
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + File.separator+ "drivers"+ File.separator	+"geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + File.separator+ "drivers"+ File.separator	+"chromedriver.exe");
			driver = new ChromeDriver();
		}
	}
	@BeforeTest
	public void beforeTestMethod()
	{
		// initialize the HtmlReporter
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator+ "reports"+ File.separator +"AutomationReport.html");
		
		//configuration items to change the look and feel
        //add content, manage tests etc
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setDocumentTitle("Selenium ExtentReport");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Automation Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
	   //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

      //To add system or environment info by using the setSystemInfo method.
        extent.setSystemInfo("Automation Tester", "Rupam");
	}
	
	
	@BeforeMethod
	@Parameters(value= {"browserName"})
	public void beforeMethodMethod(@Optional("chrome")String browserName , Method testMethod)
	{
		logger = extent.createTest(testMethod.getName());
		//Initialize Browser 
		setupDriver(browserName);
		// Maximize Window
		driver.manage().window().maximize();
		//delete cookies
		driver.manage().deleteAllCookies();
		// Get Url 
		driver.get(Constants.url);
		//Set Implicit wait for 20 sec
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}
	
	
	
	@AfterMethod
	public void afterMethodMethod(ITestResult result)
	{
		
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			String methodName = result.getMethod().getMethodName();
			String logText ="Test Case:" + methodName + "Passed";
			logger.log(Status.PASS, MarkupHelper.createLabel(logText+" PASSED ", ExtentColor.GREEN));

			}
		else if (result.getStatus() == ITestResult.FAILURE)
		{
			String methodName = result.getMethod().getMethodName();
			String logText ="Test Case:" + methodName + "Failed";
			logger.log(Status.FAIL, MarkupHelper.createLabel(logText+" FAILED ", ExtentColor.RED));
			logger.fail(result.getThrowable());

		}
		
	}
	
	
	
	@AfterTest
	public void afterTestMethod()
	{
		extent.flush();
		driver.quit();
	}
	
	
}
