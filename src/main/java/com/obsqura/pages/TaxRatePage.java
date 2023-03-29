package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utiities.GenericUtilities;
import com.obsqura.utiities.PageUtilities;
import com.obsqura.utiities.WaitUtilities;

public class TaxRatePage {
	WebDriver driver;
	PageUtilities pageu= new PageUtilities();
	WaitUtilities waitu=new WaitUtilities();
	GenericUtilities genericu=new GenericUtilities();
	@FindBy(xpath = "//button[text()='End tour']")
	WebElement endtour;
	@FindBy(xpath ="//*[@id=\"tour_step2_menu\"]/span[2]/i")	
	WebElement settingsdropdown;
	@FindBy(xpath ="//*[@id=\"tour_step3\"]/li[6]/a")
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

	public String addNewTaxRate(String nme, String tax) {
		genericu.clickOnElement(settingsdropdown);
		genericu.clickOnElement(taxrates);
		genericu.clickOnElement(addbutton);
		pageu.clearAndEnterText(namefield, nme);
		pageu.clearAndEnterText(taxratefield, tax);
		genericu.clickOnElement(savebutton);
		System.out.println(successmessage.isDisplayed());
		String display=successmessage.getAttribute("innerText");
		System.out.println(display);
		return display;
	}

}
