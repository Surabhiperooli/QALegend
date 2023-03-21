package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.constants.Constants;
import com.obsqura.utiities.PageUtilities;
import com.obsqura.utiities.WaitUtilities;

public class BarCodePage {
	WebDriver driver;
	PageUtilities pageu=new PageUtilities() ;
	WaitUtilities waitu = new WaitUtilities();
	@FindBy(xpath ="//a[@id='tour_step2_menu']")WebElement settings;
	@FindBy(xpath ="//span[text()='Barcode Settings']")WebElement barcodesettings;
	@FindBy(xpath ="//a[text()=' Add new setting']")WebElement addnewBarcode;
	@FindBy(xpath ="//input[@id='name']")WebElement stickersheetname;
	@FindBy(xpath ="//input[@name='top_margin']")WebElement topmargin;
	@FindBy(xpath ="//input[@name='left_margin']")WebElement leftmargin;
	@FindBy(xpath ="//input[@name='width']")WebElement widthofsticker;
	@FindBy(xpath ="//input[@name='height']")WebElement heightofsticker;
	@FindBy(xpath ="//input[@name='paper_width']")WebElement paperwidth;
	@FindBy(xpath ="//input[@name='paper_height']")WebElement paperheight;
	@FindBy(xpath ="//input[@name='stickers_in_one_row']")WebElement stickersinrow;
	@FindBy(xpath ="//input[@id='row_distance']")WebElement distancebtwnrows;
	@FindBy(xpath ="//input[@id='col_distance']")WebElement distancebtwncolumn;
	@FindBy(xpath ="//input[@id='stickers_in_one_sheet']")WebElement numberofstickers;
	@FindBy(xpath ="//button[text()='Save']")WebElement save;
	@FindBy(xpath ="//*[@id=\"toast-container\"]/div/div")public WebElement successmessage;
	@FindBy(xpath="//button[@class='btn btn-xs btn-danger delete_barcode_button']")WebElement deletbutton;
	@FindBy(xpath="//input[@class='form-control input-sm']")WebElement searchfield;
	@FindBy(xpath="//button[text()='OK']")WebElement deleteok;
	@FindBy(xpath="//*[@id=\"toast-container\"]/div/div")public WebElement detetedtoastmessage;
	
	
	
public BarCodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void addNewBarcode() {
		waitu.hardSleep(3000);
		settings.click();
		barcodesettings.click();
		addnewBarcode.click();
		pageu.sendKeystotextfieldMethod1(stickersheetname,Constants.STICKER_NAME );
		pageu.sendKeystotextfieldMethod1(topmargin, Constants.TOP_MARGIN);
		pageu.sendKeystotextfieldMethod1(leftmargin,Constants.LEFT_MARGIN );
		pageu.sendKeystotextfieldMethod1(widthofsticker, Constants.WIDTH);
		waitu.hardSleep(3000);
		pageu.sendKeystotextfieldMethod1(heightofsticker,Constants.HEIGHT );
		pageu.sendKeystotextfieldMethod1(paperwidth, Constants.WIDTH);
		pageu.sendKeystotextfieldMethod1(paperheight, Constants.HEIGHT);
		pageu.sendKeystotextfieldMethod1(stickersinrow,Constants.STICKERS_IN_ROW );
		waitu.hardSleep(3000);
		pageu.sendKeystotextfieldMethod1(distancebtwnrows, Constants.DISTANCE_BTWN_ROWS);
		pageu.sendKeystotextfieldMethod1(distancebtwncolumn, Constants.DISTANCE_BTWN_COLMNS);
		pageu.sendKeystotextfieldMethod1(numberofstickers, Constants.NO_OF_STICKERS);
		waitu.hardSleep(3000);
		save.click();
		waitu.hardSleep(3000);
		successmessage.isDisplayed();
	}
	public String deleteBarCode() {
		waitu.hardSleep(3000);
		settings.click();
		barcodesettings.click();
		waitu.hardSleep(5000);
		pageu.sendKeystotextfieldMethod1(searchfield, Constants.STICKER_NAME );
		waitu.hardSleep(3000);
		deletbutton.click();
		waitu.hardSleep(3000);
		deleteok.click();
		pageu.sendKeystotextfieldMethod1(searchfield, Constants.STICKER_NAME );
		waitu.hardSleep(3000);
		detetedtoastmessage.isDisplayed();
		String message=detetedtoastmessage.getText();
		return message;
	}
	
}
