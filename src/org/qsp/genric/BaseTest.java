package org.qsp.genric;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest implements IAutoConst {
	public WebDriver driver;

	@BeforeSuite
	public void openBrowser() {
		if (browser_name.equalsIgnoreCase("chrome")) {
			System.setProperty(chrome_key, chrome_value);
			driver = new ChromeDriver();
		} else if (browser_name.equalsIgnoreCase("firefox")) {
			System.setProperty(firefox_key, firefox_value);
			driver = new FirefoxDriver();
		} else {
			driver = null;
		}
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeBrowser(ITestResult testResult) throws IOException {
		int status = testResult.getStatus();
		String name = testResult.getName();
		if (status == 1) {
			Reporter.log("test case " + name + " is pass", true);
		} else {
			String path = img_path + name + ".png";
			TakeSnap.takePic(driver, path);
			Reporter.log("test case " + name + " is fail", true);
		}
		driver.close();
	}

}
