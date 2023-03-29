package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.constants.Constants;
import com.obsqura.utiities.GenericUtilities;
import com.obsqura.utiities.PageUtilities;
import com.obsqura.utiities.WaitUtilities;

public class CategoriesPage {
	WebDriver driver;
	WaitUtilities waitu = new WaitUtilities();
	PageUtilities pageu=new PageUtilities();
	GenericUtilities genericu=new GenericUtilities();
	
	@FindBy(xpath ="//a[@id='tour_step5_menu']")
	WebElement products;
	@FindBy(xpath ="//span[text()='Categories ']")
	WebElement catogeries;
	@FindBy(xpath ="//button[text()=' Add']")
	WebElement add;
	@FindBy(xpath ="//input[@id='name']")
	WebElement categorynamefield;
	@FindBy(xpath ="//input[@id='short_code']")
	WebElement categorycode;
	@FindBy(xpath ="//button[text()='Save']")
	WebElement savebutton;
	@FindBy(xpath ="//*[@id=\"toast-container\"]/div/div")
	public WebElement successmessage;
	
	public CategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String addNewCategories() {
		genericu.clickOnElement(products);
		genericu.clickOnElement(catogeries);
		genericu.clickOnElement(add);
		pageu.clearAndEnterText(categorynamefield,Constants.CATEGORY_NAME );
		pageu.clearAndEnterText(categorycode, Constants.CATEGORY_CODE);
		genericu.clickOnElement(savebutton);
		String displaymessage=successmessage.getAttribute("innerText");
		System.out.println(displaymessage);
		return displaymessage;
		
	}
}
