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
import com.obsqura.utiities.PageUtilities;
import com.obsqura.utiities.WaitUtilities;

public class CustomerPage {
	
	WebDriver driver;
	PageUtilities pageu=new PageUtilities() ;
	WaitUtilities waitu=new WaitUtilities();
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
	@FindBy(xpath="//button[@type='submit']")
	WebElement update;
	@FindBy(xpath="//*[@id=\"toast-container\"]/div/div")
	public WebElement updatedmessage;
    @FindBy(xpath="//a[@class=\"btn buttons-collection btn-info\"]") 
	WebElement actionbutton;
    @FindBy(xpath="//a[text()=\" Copy\"]")
	WebElement copy;
	@FindBy(xpath="//div[text()='Copied 25 rows to clipboard']']")
	WebElement message1;
	@FindBy(xpath="//div[@id='datatables_buttons_info']")
	public WebElement message;
	

	
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

	public void editNewlyAddedCustomerData() {
		contacts.click();
		customers.click();
		pageu.clearAndEnterText(search, Constants.NEWCUSTOMER_NAME);
		actions.click();
		edit.click();
		pageu.clearAndEnterText(alternatenumber, Constants.ALTERNATE_MOBILE);
		waitu.waitforelementtobeClickable(driver, update);
		update.click();
		System.out.println(updatedmessage.isDisplayed());
		
	}
	

}
