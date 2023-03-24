package com.obsquara.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.obsqura.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHelper {
	WebDriver driver;
	public Properties prop;

	@BeforeMethod
	@Parameters({ "browser" })
	public void launchbrowser(String browser) {
		
		readConfig();
		
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("InternetExplorer")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Tools\\Webdriver_Firefox\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		// driver.get("https://qalegend.com/billing/public/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

//@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {

			try {

				TakesScreenshot screenshot = (TakesScreenshot) driver;

				File src = screenshot.getScreenshotAs(OutputType.FILE);

				FileUtils.copyFile(src, new File(Constants.SCREENSHOT_PATH + result.getName() + ".png"));

				System.out.println("Successfully captured a screenshot");

			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());

			}

		}

		driver.close();

	}

	public void readConfig() {
		try {
			prop = new Properties();
			FileInputStream fis;
            fis = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\com\\obsquara\\configuration\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
