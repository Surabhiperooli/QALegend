package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.constants.Constants;
import com.obsqura.utiities.WaitUtilities;

public class UnitsPage {
	WebDriver driver;
	WaitUtilities waitu=new WaitUtilities();
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
			endtour.click();
		}
		public void addNewUnit() {
			waitu.hardSleep(5000);
			products.click();
			units.click();
			addUnits.click();
			unitName.sendKeys(Constants.UNIT_NAME);
			unitShortName.sendKeys(Constants.UNIT_NAME);
			allowdecimal.click();
			Select select=new Select(allowdecimal);
			select.selectByVisibleText("Yes");
			save.click();
			waitu.hardSleep(5000);
			message.isDisplayed();
			
		}
		
	}

