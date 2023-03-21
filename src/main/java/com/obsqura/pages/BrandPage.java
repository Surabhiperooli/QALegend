package com.obsqura.pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utiities.PageUtilities;

public class BrandPage {
	
	WebDriver driver;
	@FindBy(xpath = "//*[contains(@id,'tour_step5_menu')]")
	public WebElement product;
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/brands']")
	WebElement brand;
	@FindBy(xpath = "//button[text()='End tour']")
	WebElement endtour;

	@FindBy(xpath = "//*[@class='content-header']//h1[text()='Brands        ']")
	public WebElement brandsTitle;

	@FindBy(xpath = "//*[@id='brands_table_filter']//label//input")
	public WebElement search;

	@FindBy(id = "name")
	public WebElement brandnamefield;

	@FindBy(id = "description")
	public WebElement descriptionfield;

	@FindBy(xpath = "//*[@class='btn btn-primary' and text()='Save']")
	public WebElement save;

	@FindBy(xpath = "//*[@id='brand_add_form']/div[3]/button[2]")
	public WebElement close;

	@FindBy(xpath = "//*[@class='btn btn-block btn-primary btn-modal']")
	public WebElement add;
	@FindBy(xpath="//*[@class='toast-message']")
	public WebElement successmessage;

	@FindBy(xpath = "//*[@id='brands_table']/tbody/tr[1]/td[3]/button[2]/i")
	public WebElement delete;
	

	@FindBy(xpath = "//*[@id='brands_table']/tbody/tr[1]/td[3]/button[1]/i")
	public WebElement edit;
	@FindBy(xpath="//div[@class='toast-message']")
	public WebElement editsuccess;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement update;

	@FindBy(xpath = "//button[@class='swal-button swal-button--confirm swal-button--danger' and text()='OK']")
	public WebElement deleteOk;
	@FindBy(xpath="//div[@class='toast-message']")
	public WebElement deletesuccess;

	@FindBy(xpath = "//*[@class='swal-button swal-button--cancel' and text()='Cancel']")
	public WebElement deleteCancel;

	@FindBy(xpath = "//*[@class='dataTables_empty' and text()='No matching records found']")
	public WebElement noResult;

	public BrandPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
	public void closeEndtour() {
		endtour.click();
	}
	
	
	
	public boolean addaNewBrand(String brndnme,String descrptn) {
		PageUtilities pageu=new PageUtilities();
		product.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].scrollIntoView(true);", brand);
		brand.click();
		add.click();
		pageu.sendKeystotextfieldMethod1(brandnamefield,brndnme);
		pageu.sendKeystotextfieldMethod1(descriptionfield, descrptn);
		save.click();
		return successmessage.isDisplayed();
	}
	
	}
	
	
	

