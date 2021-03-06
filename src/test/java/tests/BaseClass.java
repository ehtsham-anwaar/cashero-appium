package tests;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	AppiumDriver androidDriver;
	ExtentReports extent; 
	ExtentHtmlReporter htmlReporter; 
	
	@BeforeSuite
	public void reportSetup() {
		htmlReporter = new ExtentHtmlReporter("./Reports/" + new SimpleDateFormat("yyyy-MM-dd_HH-mm'.html'").format(new Date()));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void setup() {
		try {
			
			DesiredCapabilities capability = new DesiredCapabilities();

			capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
			capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4a");
			capability.setCapability(MobileCapabilityType.UDID, "09091JEC214196");
			capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
			capability.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + getApkRelativePATH());
			
			androidDriver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);
			androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		} catch (Exception exp) {
			System.out.println("Cause is : " + exp.getCause());
			System.out.println("Message is : " + exp.getMessage());
			//exp.printStackTrace();
		}
		
	}
	
	public String getApkRelativePATH() {
		if(System.getProperty("os.name").equals("Linux")) {
			return "/src/test/resources/apps/app-qa-debug.apk";
		}
		else if (System.getProperty("os.name").equals("Windows 10")){
			return "\\src\\test\\resources\\apps\\app-qa-debug.apk";
		}
		else {
			System.out.println("No apk file found!");
			androidDriver.quit();
			return null;
		}
	}
	
	@AfterTest
	public void teardown() {
		//androidDriver.quit();
	}
	
	@AfterSuite
	public void reportTeardow() {
		extent.flush();
	}
	
}
