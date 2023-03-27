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
import com.obsqura.constants.Constants;
import com.obsqura.utiities.GenericUtilities;
import com.obsqura.utiities.PageUtilities;
import com.obsqura.utiities.WaitUtilities;

public class CustomerPage {
	
	WebDriver driver;
	PageUtilities pageu=new PageUtilities();
	WaitUtilities waitu=new WaitUtilities();
	GenericUtilities genericu=new  GenericUtilities();
	@FindBy(xpath="//i[@class='fa fa-address-book']")
	WebElement contacts;
	@FindBy(xpath="//a[text()=' Customers']")
	WebElement customers;
	@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement addbutton;
	@FindBy(xpath="//select[@id='contact_type']")
	WebElement contacttype;
	@FindBy(xpath="//input[@name='name']")
	WebElement name;
	@FindBy(xpath="//input[@name='mobile']")
	WebElement mobile;
	@FindBy(xpath="//button[@type='submit']")
	WebElement save;
	@FindBy(xpath="//*[@id=\"toast-container\"]/div/div")
	public WebElement successmessage;
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	@FindBy(xpath="//button[text()='Actions']")
	WebElement actions;
	@FindBy(xpath="//a[@class='edit_contact_button']")
	WebElement edit;
	@FindBy(xpath="//input[@id='alternate_number']")
	WebElement alternatenumber;
	@FindBy(xpath="//button[text()='Update']")
	WebElement update;
	@FindBy(xpath="//*[@id=\"toast-container\"]/div/div")
	public WebElement updatedmessage;
	@FindBy(xpath="//a[@class='delete_contact_button']")
	WebElement deletbutton;
	@FindBy(xpath="//button[text()='OK']")
	WebElement deletok;
    @FindBy(xpath="//*[@id=\"toast-container\"]/div/div")
    WebElement deletedmessage;
	
	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addNewContact() {
		contacts.click();
		customers.click();
		waitu.waitforelementtobeClickable(driver, addbutton);
		addbutton.click();
		pageu.selecttextfromDropdownList(contacttype, "Customers");
		pageu.clearAndEnterText(name, Constants.NEWCUSTOMER_NAME);
		pageu.clearAndEnterText(mobile,Constants.MOBILE);
		save.click();
		successmessage.isDisplayed();		
	}

	public String deleteNewlyAddedCustomerData() {
		contacts.click();
		customers.click();
		pageu.clearAndEnterText(search, Constants.NEWCUSTOMER_NAME);
		actions.click();
		deletbutton.click();
		waitu.waitforelementtobeClickable(driver, deletok);
		deletok.click();
		String deletmessage=genericu.getAttributeOfElement(deletedmessage);
		return deletmessage;
		
}
	}
