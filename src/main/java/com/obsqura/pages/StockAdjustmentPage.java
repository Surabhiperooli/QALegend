package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utiities.GenericUtilities;
import com.obsqura.utiities.PageUtilities;
import com.obsqura.utiities.WaitUtilities;

public class StockAdjustmentPage {
	WebDriver driver;
	PageUtilities pageu=new PageUtilities() ;
	WaitUtilities waitu = new WaitUtilities();
	GenericUtilities genericu=new GenericUtilities();
	
	
	@FindBy(xpath="/html/body/div[2]/aside/section/ul/li[8]/a/span[2]")
	WebElement stockadjustment;
	@FindBy(xpath="/html/body/div[2]/aside/section/ul/li[8]/ul/li[2]/a")
	WebElement addstockadjustment;
	@FindBy(xpath="//select[@name='location_id']")
	WebElement location;

	@FindBy(xpath="//input[@type='search']")
	WebElement searchfield;
	@FindBy(xpath="//select[@name='adjustment_type']")
	WebElement adjustmenttype;
	@FindBy(xpath="//button[@type='submit']")
	WebElement savebutton;
	@FindBy(xpath="//div[@class='toast-message']")
	WebElement successmessage;
	
	
	
	
	
	
	public StockAdjustmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String addStockAdjustment() {
		genericu.clickOnElement(stockadjustment);
		genericu.clickOnElement(addstockadjustment);
		 pageu.selecttextfromDropdownList(location, "Demo Company (BL0001)");
		 pageu.selecttextfromDropdownList(adjustmenttype, "Normal");
		 genericu.clickOnElement(savebutton);
		 String message=genericu.getAttributeOfElement(successmessage);
		 return message;
	}
}
