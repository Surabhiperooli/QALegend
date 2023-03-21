package com.obsqura.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;
import com.obsqura.utiities.WaitUtilities;

public class CustomerPage {
	
	WebDriver driver;
	WaitUtilities waitu=new WaitUtilities();
	@FindBy(xpath="//i[@class='fa fa-address-book']")
	WebElement contacts;
	@FindBy(xpath="//a[text()=' Customers']")
	WebElement customers;
    @FindBy(xpath="//a[@class=\"btn buttons-collection btn-info\"]") 
	WebElement actionbutton;
	@FindBy(xpath="//ul[@class=\"dt-button-collection dropdown-menu\"]")
	WebElement actiondropdown;
	@FindBy(xpath="//a[text()=\" Copy\"]")
	WebElement copy;
	@FindBy(xpath="//div[text()='Copied 25 rows to clipboard']']")
	WebElement message1;
	@FindBy(xpath="//div[@id='datatables_buttons_info']")
	WebElement messagebox;

	
	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public String customerentryCopyToClipboard() {

		WebElement contacts = driver.findElement(By.xpath("//i[@class='fa fa-address-book']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", contacts);
		contacts.click();
		customers.click();
		waitu.hardSleep(5000);
		actionbutton.click();
		actiondropdown.isDisplayed();
		copy.click();
		messagebox.isDisplayed();
		System.out.println(messagebox.isDisplayed());
		String message = messagebox.getText();
		System.out.println(message);
		return message;

	}

}
