package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.constants.Constants;
import com.obsqura.utiities.GenericUtilities;
import com.obsqura.utiities.PageUtilities;
import com.obsqura.utiities.WaitUtilities;

public class Expensepage {
	
	public WebDriver driver;
	public String message;
	WaitUtilities waitu=new WaitUtilities();
	PageUtilities pageu= new PageUtilities();	
	GenericUtilities genericu=new GenericUtilities();
	    @FindBy(xpath="//span[text()='Expenses']")
		WebElement expenses;
		@FindBy(xpath="//a[text()='Add Expenses']")
		WebElement addExpenses;
		@FindBy(xpath="//select[@name='location_id']")
		WebElement businessLocation;
		@FindBy(id="final_total")
		WebElement totalAmount;
		@FindBy(xpath="//button[text()='Save']")
		WebElement save;
		@FindBy(xpath="//div[@class='toast-message']")
		public WebElement expenseAddedMessage;
		@FindBy(xpath="//a[text()='Expense Categories']") 
		WebElement expensecategory;
		@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-modal']")
		WebElement add;
		@FindBy(xpath="//input[@id='name']")
		WebElement categoryname;
		@FindBy(xpath="//input[@id='code']")
		WebElement categorycode;
		@FindBy(xpath="//button[text()='Save']")
		WebElement savecategory;
		@FindBy(xpath="//*[@id=\"toast-container\"]/div/div")
		public WebElement categoryaddedmessage;
		
		
		public Expensepage(WebDriver driver) { 					 
			this.driver=driver;
			PageFactory.initElements(driver, this);				 
		}
		
		public boolean addExpenses() {
			genericu.clickOnElement(expenses);
			genericu.clickOnElement(addExpenses);
			Select select=new Select(businessLocation);
			select.selectByValue(Constants.DECIMALVALUE);
			totalAmount.sendKeys(Constants.TOTALAMOUNT);
			genericu.clickOnElement(save);
			System.out.println(expenseAddedMessage.isDisplayed());
			return expenseAddedMessage.isDisplayed();
			
		}
		public void addexpensecategory()
		{
			genericu.clickOnElement(expenses);
			genericu.clickOnElement(expensecategory);
			genericu.clickOnElement(add);
			pageu.clearAndEnterText(categoryname, Constants.CATEGORY_NAME);
			pageu.clearAndEnterText(categorycode, Constants.CATEGORY_CODE);
			genericu.clickOnElement(savecategory);
			categoryaddedmessage.isDisplayed();
			
		}
}
