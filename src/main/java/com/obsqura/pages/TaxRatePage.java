package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utiities.PageUtilities;
import com.obsqura.utiities.WaitUtilities;

public class TaxRatePage {
	WebDriver driver;
	PageUtilities pageu= new PageUtilities();
	WaitUtilities waitu=new WaitUtilities();
	
	@FindBy(xpath = "//button[text()='End tour']")
	WebElement endtour;
	@FindBy(xpath ="//*[@id=\"tour_step2_menu\"]/span[2]/i")	
	WebElement settingsdropdown;
	@FindBy(xpath ="//span[text()='Tax Rates']")
	WebElement taxrates;
	@FindBy(xpath ="/html/body/div[2]/div[1]/section[2]/div[1]/div[1]/div/button")
	WebElement addbutton;
	@FindBy(xpath ="//*[@id=\"name\"]")
	WebElement namefield;
	@FindBy(xpath ="//*[@id=\"amount\"]")
	WebElement taxratefield;
	@FindBy(xpath ="//*[@id=\"tax_rate_add_form\"]/div[3]/button[1]")
	WebElement savebutton;
	@FindBy(xpath ="//*[@id=\"toast-container\"]/div")
	public WebElement successmessage;
	
	public TaxRatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void closeEndtour() {
		endtour.click();
	}

	public boolean addNewTaxRate(String nme, String tax) {
		settingsdropdown.click();
		taxrates.click();
		addbutton.click();
		pageu.clearAndEnterText(namefield, nme);
		pageu.clearAndEnterText(taxratefield, tax);
		savebutton.click();
		System.out.println(successmessage.isDisplayed());
		return successmessage.isDisplayed();
	}

}
