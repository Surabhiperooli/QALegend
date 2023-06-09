package com.obsqura.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.constants.Constants;
import com.obsqura.utiities.GenericUtilities;
import com.obsqura.utiities.PageUtilities;
import com.obsqura.utiities.WaitUtilities;

public class BusinessSettingsPage {
	WebDriver driver;
	PageUtilities pageu=new PageUtilities() ;
	WaitUtilities waitu = new WaitUtilities();
	GenericUtilities genericu=new GenericUtilities();
	
	@FindBy(xpath ="//a[@id='tour_step2_menu']")
	WebElement settings;
	@FindBy(xpath ="//a[text()=' Business Settings']")
	WebElement businesssettings;
	@FindBy(xpath="//input[@id='name']")
	WebElement businessname;
	@FindBy(xpath="//input[@id='default_profit_percent']")
	WebElement profipercentage;
	@FindBy(xpath="//select[@id='accounting_method']")
	WebElement accountingmethod;
	@FindBy(xpath="//input[@id='transaction_edit_days']")
	WebElement transactioneditdays;
	@FindBy(xpath="//select[@name='date_format']")
	WebElement dateformat;
	@FindBy(xpath="//select[@id='time_format']")
	WebElement timeformat;
	@FindBy(xpath="//button[text()='Update Settings']")
	WebElement updatebutton;
	@FindBy(xpath="//*[@id=\"toast-container\"]/div/div")
	public WebElement successmessage;
	
	public BusinessSettingsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void updateBusinessSettings() {
		genericu.clickOnElement(settings);
		genericu.clickOnElement(businesssettings);
		pageu.clearAndEnterText(businessname,Constants.BUSINESS_NAME);
		pageu.clearAndEnterText(profipercentage,Constants.PERCENTAGE+Keys.ENTER);
		pageu.selecttextfromDropdownList(accountingmethod,"FIFO (First In First Out)");
		pageu.clearAndEnterText(transactioneditdays, Constants.DAYS);
		pageu.selecttextfromDropdownList(dateformat, "dd-mm-yyyy");
		pageu.selecttextfromDropdownList(timeformat, "12 Hour");
		genericu.clickOnElement(updatebutton);
		successmessage.isDisplayed();
}
	}
