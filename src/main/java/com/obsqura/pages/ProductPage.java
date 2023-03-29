package com.obsqura.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utiities.GenericUtilities;
import com.obsqura.utiities.PageUtilities;
import com.obsqura.utiities.WaitUtilities;

public class ProductPage {
	WebDriver driver;
	PageUtilities pageu=new PageUtilities() ;
	WaitUtilities waitu = new WaitUtilities();
	GenericUtilities genericu=new GenericUtilities();
	
	@FindBy(xpath = "//*[@id=\"tour_step5_menu\"]")
	WebElement productsdrowpdown;
	@FindBy(xpath = "//*[@id=\"tour_step5\"]/ul")
	WebElement productsdropdownlist;
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	@FindBy(xpath="//*[@id=\"product_table\"]/tbody/tr/td[1]/input")
	WebElement
	checkbox;
	@FindBy(xpath = "//*[@id=\"tour_step5\"]/ul/li[1]/a")
	WebElement listproducts;
	@FindBy(xpath = "//div[@id='product_list_tab']")
	WebElement firstsetofproducts;;
	@FindBy(xpath = "//*[@id=\"product_list_tab\"]")
	public WebElement productlist;
	@FindBy(xpath = "//input[@id='deactivate-selected']")
	WebElement deactivateselected;
	@FindBy(xpath = "//button[text()='OK']")
	WebElement warningmessageok;
	@FindBy(xpath = "//div[text()='Products deactivated successfully']")
	public WebElement deactivatedtoastmessage;
	@FindBy(xpath = "//*[@id=\"tour_step5\"]/ul/li[2]/a")
	public WebElement addproduct;
	@FindBy(xpath = "//*[@id=\"name\"]")
	public WebElement proname;
	@FindBy(xpath="//*[@id=\"select2-unit_id-container\"]")
	public WebElement clickunit;
	@FindBy(xpath = "/html/body/span/span/span[1]/input")
	public WebElement unitelementtypefield;
	@FindBy(xpath = "//*[@id=\"select2-unit_id-results\"]")
	WebElement unitlist;
	@FindBy(xpath ="//*[@id=\"product_add_form\"]/div[3]/div/div/div[2]/div/span/span[1]/span/span[2]")
	WebElement sellingpricetax;
	@FindBy(xpath ="//*[@id=\"select2-tax_type-container\"]")
	WebElement exclusive;
	@FindBy(xpath ="//*[@id=\"select2-type-container\"]")
	WebElement single;
	@FindBy(xpath ="//*[@id=\"product_add_form\"]/div[3]/div/div/div[4]/div/span/span[1]/span/span[2]")
	WebElement producttype;
	@FindBy(xpath = "//*[@id=\"unit_id\"]/option[3]")
	public WebElement option;
	@FindBy(xpath = "//*[@id=\"product_add_form\"]/div[1]/div/div/div[5]/div/span/span[1]")
	public WebElement category;
	@FindBy(id = "select2-barcode_type-container")
	WebElement clickbarcode;
	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement barcodeelement;

	@FindBy(xpath = "//*[@id=\"category_id\"]/option[3]")
	public WebElement option1;
	@FindBy(xpath = "//*[@id=\"alert_quantity\"]")
	public WebElement alertqty;
	@FindBy(xpath = "//*[@id=\"single_dpp\"]")
	public WebElement exctax;
	@FindBy(xpath = "//*[@id=\"product_add_form\"]/div[4]/div/div/div/button[4]")
	public WebElement savebutton;
    @FindBy(id = "single_dpp")
	public WebElement exctaxelement;
	@FindBy(id = "single_dpp_inc_tax")
	public WebElement inctaxelement;
	@FindBy(xpath = "//*[@id=\"toast-container\"]/div")
	public WebElement success;
	
	

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public String addnewProduct(String productname, String unit, String barcode, String alertquantity,String exctax,String inctax) {
		 
		genericu.clickOnElement(productsdrowpdown);
		genericu.clickOnElement(listproducts);
		genericu.clickOnElement(addproduct);
		pageu.clearAndEnterText(proname,productname );
		genericu.clickOnElement(clickunit);
		pageu.clearAndEnterText(unitelementtypefield,unit+Keys.ENTER);
		genericu.clickOnElement(clickbarcode);
		pageu.clearAndEnterText(barcodeelement,barcode+Keys.ENTER);
		pageu.clearAndEnterText(alertqty,alertquantity);
		genericu.clickOnElement(sellingpricetax);
		genericu.clickOnElement(exclusive);
		genericu.clickOnElement(producttype);
		genericu.clickOnElement(single);
		pageu.clearAndEnterText(exctaxelement,exctax+Keys.ENTER);
		pageu.clearAndEnterText(inctaxelement,inctax+Keys.ENTER);
		genericu.clickOnElement(savebutton);
		String displaymessage=genericu.getAttributeOfElement(success);
		return displaymessage;
		}
	
	}

