package com.obsqura.pages;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obsqura.utiities.WaitUtilities;

public class Homepage {
	WebDriver driver;
	public String notification;
	WaitUtilities waitu = new WaitUtilities();
	
	
	@FindBy(xpath = "//button[text()='End tour']")
	WebElement endtour;
	@FindBy(xpath = "/html/body/div[2]/div[1]/section[1]/h1") 
	WebElement welcomemessage;
	public WebElement welcomenote;
	@FindBy(xpath = "//span[@class='title']")
	WebElement usermanagementoption;
	@FindBy(xpath = "//i[@class='fa fa-angle-left pull-right']")
	WebElement usermanagementdropdown;
	@FindBy(xpath = "//button[@id='btnCalculator']")
	WebElement calculator;
	@FindBy(xpath ="//div[@class='popover-content']")
	public WebElement calculatordisplay;
	
	
	@FindBy(xpath = "/html/body/div[2]/header/nav/div/button[2]")
	WebElement todaysprofitmessagebutton;
	@FindBy(xpath = "//*[@id=\"todays_profit_modal\"]/div/div")////div[@class='modal-content']
	public WebElement todaysprofitmessagedisplay;
	@FindBy(xpath = "//button[text()='Close']")
	WebElement todaysprofitmessageclose;
	
	
	@FindBy(xpath = "//i[@class='fa fa-bell-o']")
	WebElement bellbutton;
	@FindBy(xpath = "//*[@id=\"notifications_list\"]/li")
	WebElement notificationmessage;
	
	
	@FindBy(xpath = "//*[@id=\"purchase_payment_dues_table\"]/tbody/tr[1]/td[2]/a")
	WebElement referencenumber;
	@FindBy(xpath = "//button[@class='btn btn-primary no-print']")
	WebElement printbutton;
	@FindBy(xpath = "//*[@id=\"sidebar\"]//print-preview-button-strip//div/cr-button[1]")
	WebElement finalprintbutton;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void closeEndtour() {
		endtour.click();
	}

	public boolean isHomepageLoaded()
	{
		return welcomemessage.isDisplayed();

	}

	public boolean iswelcomemsgHomepageShowing() {
		String welcmemsg = welcomemessage.getText();
		System.out.println(welcmemsg);
		return welcomemessage.isDisplayed();
	}

	public boolean usermanagementdropdownfn() {
		usermanagementdropdown.click();
		WebElement s = usermanagementdropdown;
		System.out.println(s.getText());
		return usermanagementdropdown.isDisplayed();

	}

	public boolean calculatordisplaying() {
		waitu.hardSleep(5000);
		calculator.click();
		System.out.println(calculatordisplay.isDisplayed());
		return calculatordisplay.isDisplayed();
		
	}

	public String notificationshowing() {
		waitu.hardSleep(5000);
		bellbutton.click();
        notification = notificationmessage.getAttribute("innerText");
		return notification;

	}

	public boolean todaysProfitPopUpMessage() {
		waitu.hardSleep(3000);
		todaysprofitmessagebutton.click();
		waitu.hardSleep(5000);
		System.out.println(todaysprofitmessagedisplay.isDisplayed());
        return todaysprofitmessagedisplay.isDisplayed();
	}

	public void purchaseDetailsPrint() {
		referencenumber.click();
		printbutton.click();
		waitu.hardSleep(5000);
		finalprintbutton.click();
	}
}
