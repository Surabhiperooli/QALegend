package com.obsqura.utiities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	WebDriver driver;
	
	public void hardSleep(long sleepTimeInSeconds) {
		try {
			Thread.sleep(sleepTimeInSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitforelementtobeLoad(long waitTimeInSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTimeInSeconds));
	}

	public void waitforelementtobeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));

		 wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// IT is the expectation for checking that an element is present on the DOM of a
	// page.
	// This does not necessarily mean that the element is visible.
	public void waitForElementToBePresent(WebDriver driver,String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		
	}

	// is the expectation for checking that an element is present on the DOM of a
	// page and visible.
	// Visibility means that the element is not only displayed but also has a height
	// and width that is greater than 0.
	public void waitUntilElementIsDisplayedOnScreen(WebDriver driver,WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	
	}

	public void waitforelementToBeSelected(WebDriver driver,String locator, String attributeType,String attributeValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.attributeToBe(By.xpath(locator),attributeType,attributeValue));
	}
	public void waitforelementToBeSelected(WebDriver driver,String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wait.until(ExpectedConditions.elementToBeSelected(By.xpath(locator)));
	}


}
