package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.constants.Constants;
import com.obsqura.utiities.PageUtilities;
import com.obsqura.utiities.WaitUtilities;

public class InvoiceSettingsPage {
	WebDriver driver;
	PageUtilities pageu=new PageUtilities() ;
	WaitUtilities waitu = new WaitUtilities();
	
	@FindBy(xpath ="//a[@id='tour_step2_menu']")
	WebElement settings;
	@FindBy(xpath="//span[text()='Invoice Settings']")
	WebElement invoicesettings;
	@FindBy(xpath="//button[@class=\"btn btn-primary btn-modal pull-right\"]")
	WebElement addbutton;
	@FindBy(xpath="//*[@id=\"invoice_scheme_add_form\"]/div[2]/div[1]/div[1]/div[2]")
	WebElement format;
	@FindBy(xpath="//input[@id='name']")
	WebElement namefield;
	@FindBy(xpath="//input[@id='start_number']")
	WebElement startfrom;
	@FindBy(xpath="//select[@id='total_digits']")
	WebElement noofdigits;
	@FindBy(xpath="//button[text()='Save']")
	WebElement savebutton;
	@FindBy(xpath="//*[@id=\"toast-container\"]/div/div")
	public WebElement successmessage;
	
	
	public InvoiceSettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addNewInvoiceSetting() {
		
		settings.click();
		invoicesettings.click();
		addbutton.click();
		format.click();
		waitu.waitforelementtobeClickable(driver, namefield);
		pageu.clearAndEnterText(namefield, Constants.BUSINESS_NAME);
		pageu.clearAndEnterText(startfrom, Constants.START_YEAR);
		pageu.selecttextfromDropdownList(noofdigits, "5");
		savebutton.click();
		successmessage.isDisplayed();
	}
}
