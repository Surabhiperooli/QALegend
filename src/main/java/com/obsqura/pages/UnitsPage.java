package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.constants.Constants;
import com.obsqura.utiities.GenericUtilities;
import com.obsqura.utiities.WaitUtilities;

public class UnitsPage {
	WebDriver driver;
	WaitUtilities waitu=new WaitUtilities();
	GenericUtilities genericu=new GenericUtilities();
	@FindBy(xpath="//span[text()='Products']")
	WebElement products;
	@FindBy(xpath = "//button[text()='End tour']")
	WebElement endtour;
	@FindBy(xpath="//span[text()='Units']")
	WebElement units;
	@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement addUnits;
	@FindBy(id="actual_name")
	WebElement unitName;
	@FindBy(id="short_name")
	WebElement unitShortName;
	@FindBy(id="allow_decimal")
	WebElement allowdecimal;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement save;
	@FindBy(xpath="//div[@class='toast-message']")
	public WebElement message;
	
	
	public UnitsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void closeEndtour() {
		genericu.clickOnElement(endtour);
	}

	public String addNewUnit() {
		genericu.clickOnElement(products);
		genericu.clickOnElement(units);
		genericu.clickOnElement(addUnits);
		waitu.waitforelementtobeClickable(driver, unitName);
		unitName.sendKeys(Constants.UNIT_NAME);
		unitShortName.sendKeys(Constants.UNIT_NAME);
		genericu.clickOnElement(allowdecimal);
		Select select = new Select(allowdecimal);
		select.selectByVisibleText("Yes");
		genericu.clickOnElement(save);
		String displaymessage=genericu.getAttributeOfElement(message);
		return displaymessage;
		

	}

}
